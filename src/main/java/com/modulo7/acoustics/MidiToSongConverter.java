package com.modulo7.acoustics;

/**
 * Created by asanyal on 6/28/2015.
 *
 * This class is responsible to converting a midi file into a modulo7
 * representation
 *
 */
import com.modulo7.common.utils.Modulo7Globals;

import com.modulo7.musicstatmodels.representation.Song;
import com.modulo7.musicstatmodels.representation.Voice;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.sound.midi.*;

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

    // Midi Byte representation of the tempo
    private static final int TEMPO_BYTE =  0x51;

    // Apache log4j logger representation
    private static final Logger logger = Logger.getLogger(MidiToSongConverter.class);

    // The midi sequence of the Midi Song Coverter for a particular midi file
    private Sequence midiSequence;

    // Variable to indicate if the key signature has been acquired from the midi file or not
    private boolean keySignatureAcquired = false;

    /**
     * Basic constructor for the midi to song converter
     * @param midiFileLocation
     */
    public MidiToSongConverter(final String midiFileLocation) throws InvalidMidiDataException, IOException {
        // Gets the sequence of events from a midi file, we can then acquire the various parameters from the midi
        // sequences to construct voice instants
        midiSequence = MidiSystem.getSequence(new File(midiFileLocation));
    }

    /**
     * Gets the data of the entire song from a midi file
     * via the Java midi parser and analysis
     */
    @Override
    public Song getSongRepresentation() {

        // Construct a voice to channel map
        final Map<Integer, Voice> voiceToChannelMap = new HashMap<>();

        int trackNumber = 0;

        for (Track track : midiSequence.getTracks()) {

            trackNumber++;

            logger.info("Track " + trackNumber + ": size = " + track.size());

            for (int i=0; i < track.size(); i++) {

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
                    } else if (sm.getCommand() == NOTE_OFF) {
                        int key = sm.getData1();
                        int octave = (key / 12)-1;
                        int note = key % 12;
                        String noteName = Modulo7Globals.NOTE_NAMES[note];
                        int velocity = sm.getData2();
                        logger.debug("Note off, " + noteName + octave + " key=" + key + " velocity: " + velocity);
                    } else if (sm.getCommand() == KEY_SIGNATURE_BYTE) {
                        // Acquire the key signature from the midi file
                        if (!keySignatureAcquired) {
                            // Acquire the scale info
                            int scaleMidiInfo = sm.getData1();
                            int keyMidiInfo = sm.getData2();

                            if (scaleMidiInfo == 0); // major
                                // meta_data[0] = new Integer(0);
                            else if (scaleMidiInfo == 1); // minor
                                // meta_data[0] = new Integer(1);

                            keySignatureAcquired = true;
                        }
                    } else {
                        // We ignore the command elements that are neither note on or off
                    }
                } else {
                   logger.info("Other message: " + message.getClass());
                }
            }
        }

        // TODO : Fix this
        return null;
    }

    /**
     * Test code for Midi converter, taking a basic midi file and converting to
     * notes
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        MidiToSongConverter converter = new MidiToSongConverter("C:\\Users\\asanyal\\Downloads\\01A-1__Good_Times_Bad_Times.mid");
        converter.getSongRepresentation();
    }
}

