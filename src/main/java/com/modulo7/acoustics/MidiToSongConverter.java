package com.modulo7.acoustics;

/**
 * Created by asanyal on 6/28/2015.
 *
 * This class is responsible to converting a midi file into a modulo7
 * representation, its lacking a chord ID system for midi
 */

import com.modulo7.common.exceptions.*;
import com.modulo7.common.interfaces.AbstractAnalyzer;
import com.modulo7.common.utils.Modulo7Globals;
import com.modulo7.common.utils.Modulo7Utils;
import com.modulo7.crawler.utils.MusicSources;
import com.modulo7.musicstatmodels.musictheorymodels.CircleOfFifths;
import com.modulo7.musicstatmodels.musictheorymodels.KKTonalityProfiles;
import com.modulo7.musicstatmodels.representation.buildingblocks.Note;
import com.modulo7.musicstatmodels.representation.metadata.KeySignature;
import com.modulo7.musicstatmodels.representation.metadata.ScaleType;
import com.modulo7.musicstatmodels.representation.metadata.SongMetadata;
import com.modulo7.musicstatmodels.representation.metadata.TimeSignature;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;
import com.modulo7.musicstatmodels.representation.monophonic.VoiceInstant;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;
import com.modulo7.musicstatmodels.vectorspacemodels.vectorspacerepresentations.songvectors.PitchDurationHistogram;
import com.modulo7.musicstatmodels.vectorspacemodels.vectorspacerepresentations.songvectors.TonalDurationHistogram;
import com.modulo7.nlp.Lyrics;
import org.apache.log4j.Logger;

import javax.sound.midi.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * A class to convert midi files to Notes
 */
public class MidiToSongConverter implements AbstractAnalyzer {

    // Midi Byte representation of on note
    public static final int NOTE_ON = 0x90;

    // Midi Byte representation of off note
    public static final int NOTE_OFF = 0x80;

    // Midi Byte representation of the key signature
    public static final int KEY_SIGNATURE_BYTE = 0x59;

    // Midi byte representation of the time signature of the song
    public static final byte TIME_SIGNATURE_BYTE = 0x58;

    // Midi Byte representation of the tempo
    private static final int TEMPO_BYTE =  0x51;

    // Midi byte representation of the lyric meta event
    public static final byte LYRIC = 0x05;

    // Apache log4j logger representation
    private static final Logger logger = Logger.getLogger(MidiToSongConverter.class);

    // The scale element for this midi recording
    private KeySignature keySignature = null;

    // The time signature associated with this midi recording
    private TimeSignature timeSignature = null;

    // Acquire the lyrics from the midi file
    private Lyrics lyrics = new Lyrics();

    // Tempo and rhythm information for midi track
    private Map<Integer, Double> secondsPerTick = new HashMap<>();

    // Average number of ticks per second
    private double meanTicksPerSec;

    // Total number of ticks for this midi track
    private double numTicks;

    // Sequence of tracks for this midi file
    private List<Track> tracks = new ArrayList<>();

    // Number of ticks per beat for this midi track
    private int ticksPerBeat;

    /**
     * Basic constructor for the midi to song converter
     * @param midiFileLocation
     */
    public MidiToSongConverter(final String midiFileLocation) throws InvalidMidiDataException, Modulo7NoSuchFileException {
        // Gets the sequence of events from a midi file, we can then acquire the various parameters from the midi
        // sequences to construct voice instants
        Sequence midiSequence;

        try {
            midiSequence = MidiSystem.getSequence(new File(midiFileLocation));
        } catch (IOException e) {
            throw new Modulo7NoSuchFileException("No such file found in location:" + midiFileLocation);
        }

        numTicks = midiSequence.getTickLength();

        // Caclulate timing information, i.e the mean ticks per second for this midi file
        meanTicksPerSec = (numTicks) / ((double) midiSequence.getMicrosecondLength() / 1000000.0);

        // Acquire the ticks per beat
        ticksPerBeat = midiSequence.getResolution();

        // Acquire the tracks
        tracks = Arrays.asList(midiSequence.getTracks());
    }

    /**
     * Gets the data of the entire song from a midi file
     * via the Java midi parser and analysis
     */
    @Override
    public Song getSongRepresentation() {

        // Construct a voice to channel map
        final Map<Integer, Voice> voiceToChannelMap = new HashMap<>();

        // Generate the rhythm information first
        generateTempoMap();

        int trackNumber = 0;

        for (Track track : tracks) {

            trackNumber++;

            logger.info("Track " + trackNumber + ": size = " + track.size());

            // Incrementally add voice instants to a voice
            voiceToChannelMap.put(trackNumber, new Voice());

            for (int i = 0; i < track.size(); i++) {

                MidiEvent event = track.get(i);
                logger.info("@" + event.getTick() + " ");
                MidiMessage message = event.getMessage();

                if (message instanceof ShortMessage) {
                    ShortMessage sm = (ShortMessage) message;
                    logger.info("Channel: " + sm.getChannel() + " ");

                    if (sm.getCommand() == NOTE_ON) {
                        int key = sm.getData1();
                        int octave = (key / 12)-1;
                        int note = key % 12;
                        String noteName = Modulo7Globals.NOTE_NAMES[note];
                        int velocity = sm.getData2();
                        logger.debug("Note on, " + noteName + octave + " key=" + key + " velocity: " + velocity);

                        // If the velocity with which this key was pressed was not equal to zero, we now estimate how long the note was played
                        try {
                            double noteDuration;
                            if (velocity != 0) {
                                noteDuration = getNoteDuration(track, event, i, sm);
                            } else {
                                noteDuration = Modulo7Globals.UNKNOWN;
                            }
                            VoiceInstant instant = new VoiceInstant(Note.getNoteValue(noteName), noteDuration, velocity);
                            Modulo7Utils.addVoiceInstantToVoiceMap(voiceToChannelMap, instant, trackNumber);
                        } catch (Modulo7InvalidVoiceInstantSizeException | Modulo7BadNoteException e) {
                            logger.error(e.getMessage());
                        }
                    } else {
                        // We ignore the command elements that are neither note on or off
                    }
                }
                // Parsing meta events
                else if (message instanceof MetaMessage) {
                    MetaMessage metaMessage = (MetaMessage) message;

                    // If you get lyrics event then add it to
                    if (metaMessage.getType() == LYRIC) {
                        lyrics.addLyricsElementToSong(new String(metaMessage.getData()));
                    } else if (metaMessage.getType() == KEY_SIGNATURE_BYTE) {
                        // Acquire the key signature from the midi file
                        if (keySignature == null) {
                            try {
                                final ScaleType scale = metaMessage.getData()[1] == 0 ? ScaleType.MAJOR : ScaleType.MINOR;
                                int fifths = new Byte(metaMessage.getData()[0]).intValue();
                                final String key = CircleOfFifths.getKeyGivenFifthDistance(scale, fifths);
                                keySignature = new KeySignature(key, scale);
                            } catch (Modulo7InvalidCircleOfFifthsDistance | Modulo7BadKeyException e) {
                                logger.error(e.getMessage());
                            }
                        }
                    } else if (metaMessage.getType() == TIME_SIGNATURE_BYTE) {

                        if (timeSignature != null) {
                            final int noteisBeatVal = new Byte(metaMessage.getData()[0]).intValue();
                            final int beatsPerMeasure = new Byte(metaMessage.getData()[1]).intValue();
                            timeSignature = new TimeSignature(noteisBeatVal, beatsPerMeasure);
                        }
                    }
                } else {
                   logger.info("Other message: " + message.getClass());
                }
            }
        }

        // Acquire the voices from a hash set
        HashSet<Voice> voiceSet = new HashSet<>(voiceToChannelMap.values());

        HashSet<Voice> nonEmptyVoiceSet = new HashSet<>();

        for (final Voice voice : voiceSet) {
            if (voice.getNumVoiceInstantsOfVoice() > 0) {
                nonEmptyVoiceSet.add(voice);
            }
        }

        if (timeSignature != null && keySignature != null) {
            return new Song(nonEmptyVoiceSet, new SongMetadata(keySignature, timeSignature), MusicSources.MIDI);
        } else {
            final Song song = new Song(nonEmptyVoiceSet, MusicSources.MIDI);

            try {
                final KeySignature keySignature;
                PitchDurationHistogram histogram = new PitchDurationHistogram();
                histogram.computeVectorRepresentation(song);
                keySignature = KKTonalityProfiles.estimateBestKeySignature(histogram);
                song.addSongMetadata(keySignature);
            } catch (Modulo7BadKeyException e) {
                logger.error(e.getMessage());
            }

            return song;
        }
    }


    /**
     * Gets the note duration for a particular note
     *
     * @param track
     * @param event
     * @param currentEventNumber
     * @param currShortMsg
     * @return
     */
    private double getNoteDuration(final Track track, final MidiEvent event, final int currentEventNumber, final ShortMessage currShortMsg) {

        // Look ahead to find the corresponding note off for this note on
        int eventStartTick = (int) event.getTick();
        int eventEndTick = track.size(); // when the note off occurs (default to last tick

        for (int i = currentEventNumber + 1; i < track.size(); i++) {
            MidiEvent endEvent = track.get(i);
            MidiMessage endMessage = endEvent.getMessage();
            if (endMessage instanceof ShortMessage) {
                ShortMessage endShortMessage = (ShortMessage) endMessage;
                // sample channel requirement
                if (endShortMessage.getChannel() == currShortMsg.getChannel()) {
                    if (endShortMessage.getCommand() == NOTE_OFF) {
                        // same pitch requirement
                        if (endShortMessage.getData1() == currShortMsg.getData1()) {
                            eventEndTick = (int) endEvent.getTick();
                            i = track.size() + 1; // exit loop
                        }
                    }
                    // note on (with vel 0 is equiv to note off)
                    if (endShortMessage.getCommand() == NOTE_OFF) {

                        final int noteOffVelocity = endShortMessage.getData2() ;

                        if (noteOffVelocity== 0) {
                            // same pitch
                            if (endShortMessage.getData1() == currShortMsg.getData1()) {
                                eventEndTick = (int) endEvent.getTick();
                                i = track.size() + 1; // exit loop
                            }
                        }
                    }
                }
            }
        }

        // Calculate duration of note
        double duration = 0;
        for (int i = eventStartTick ; i < eventEndTick ; i++)
            duration += secondsPerTick.get(i);

        return duration;
    }

    /**
     * Look through the recording in order to find tempo change messages
     * Fill in secondsPerTick on these messages.
     */
    private void generateTempoMap()
    {
        // Instantiate secondsPerTick and initialize entries to the average
        // number of ticks per second
        for (int i = 0; i < numTicks; i++)
            secondsPerTick.put(i, 1.0 / meanTicksPerSec);

        // Fill in tempo changes
        for (Track track : tracks) {
            // Go through all the events in the current track, searching for tempo change messages
            for (int n_event = 0; n_event < track.size(); n_event++) {

                // Get the MIDI message corresponding to the next MIDI event
                MidiEvent event = track.get(n_event);
                MidiMessage message = event.getMessage();

                // If message is a MetaMessage (which tempo change messages are)
                if (message instanceof MetaMessage) {
                    MetaMessage meta_message = (MetaMessage) message;

                    if (meta_message.getType() == TEMPO_BYTE) {

                        // Find the number of PPQ ticks per beat
                        int ticks_per_beat = ticksPerBeat;

                        // Find the number of microseconds per beat
                        byte[] meta_data = meta_message.getData();
                        int	microseconds_per_beat = ((meta_data[0] & 0xFF) << 16)
                                | ((meta_data[1] & 0xFF) << 8)
                                | (meta_data[2] & 0xFF);

                        // Find the number of seconds per tick
                        double current_seconds_per_tick = ((double) microseconds_per_beat) / ((double) ticks_per_beat);
                        current_seconds_per_tick = current_seconds_per_tick / 1000000.0;

                        // Make all subsequent tempos be at the current_seconds_per_tick rate
                        for (int i = (int) event.getTick(); i < secondsPerTick.size(); i++) {
                            secondsPerTick.put(i, current_seconds_per_tick);
                        }
                    }
                }
            }
        }
    }
}

