package com.modulo7.othersources;

import java.io.File;
import java.io.IOException;
import java.util.*;

import com.modulo7.acoustics.AbstractAnalyzer;
import com.modulo7.common.exceptions.*;
import com.modulo7.common.utils.FrequencyNoteMap;
import com.modulo7.common.utils.Modulo7Utils;
import com.modulo7.crawler.utils.MusicSources;
import com.modulo7.musicstatmodels.musictheorymodels.CircleOfFifths;
import com.modulo7.musicstatmodels.representation.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * Created by asanyal on 7/23/2015.
 *
 * A basic music xml parser using simple JSOUP
 *
 * Heavily inspired by :
 *
 * https://bitbucket.org/dorienh/musicxmlparserdh/src/
 * 20e1beea207a83140fc4008825760da50f223d26/src/musicXMLparserDH.java?at=master
 *
 */
public class BasicMusicXMLParser implements AbstractAnalyzer {

    // JSoup document element containing the required document entities
    private Document doc;

    // Logger for the basic Music XML Parser
    final static Logger logger = Logger.getLogger(BasicMusicXMLParser.class.getName());

    // Key signature of the song if its present in the music xml encoding
    private KeySignature keySignature = null;

    // The time signature associated with this song
    private TimeSignature timeSignature = null;

    // The set of lines that describe the song, mapped to line index
    private Map<Integer, Voice> voiceIndextoVoiceMap = new HashMap<>();

    // Get an instance of frequencies to the notes
    private FrequencyNoteMap frequencyNoteMap = FrequencyNoteMap.getInstance();

    // A list of all the division elements in the music xml document
    private List<Integer> divisions = new ArrayList<>();

    // A division multiplier map
    private Map<Integer, Integer> divMultiplier = new HashMap<>();

    /**
     * Basic constructor takes as input the filename and applies
     *
     *
     * @param  filename
     * @throws IOException
     */
    public BasicMusicXMLParser(final String filename) throws IOException, Modulo7InvalidMusicXMLFile {

        final File input = new File(filename);
        doc = Jsoup.parse(input, "UTF-8", filename);

        checkIfValidMusicXMLFile(filename);
    }


    /**
     * Check if the music xml file is valid or not
     * @param filename
     * @throws Modulo7InvalidMusicXMLFile
     */
    private void checkIfValidMusicXMLFile(final String filename) throws Modulo7InvalidMusicXMLFile {
        // Check if the document contains notes and is infact a valid music xml file
        if (doc.getElementsByTag("note").isEmpty()){
            if (doc.getElementsByTag("note").isEmpty()){
                logger.error("Please check that your music xml file is encoded in UTF-8 or UTF-16 and contains notes.");
                throw new Modulo7InvalidMusicXMLFile("Bad music xml file:" + filename);
            }
        }
    }

    /**
     * Parses the music xml into a modulo7 song
     * @return
     *
     */
    @Override
    public Song getSongRepresentation() {

        // Init the lines as a map between line index (also called voice in music xml jargon)
        for (Element note : this.doc.getElementsByTag("Note")) {

            // Acquire the voice of the note in question
            final String voiceOfNote = note.getElementsByTag("voice").text();
            int voiceNumber;

            // In the voice is not specified for the note, assume voice number = 1
            if (voiceOfNote.length() == 0) {
                voiceNumber = 1;
            } else {
                voiceNumber = Integer.parseInt(voiceOfNote);
            }

            // Init a voice associated with a voice number
            if (voiceIndextoVoiceMap.get(voiceNumber) == null) {
                voiceIndextoVoiceMap.put(voiceNumber, new Voice());
            }
        }

        // Gets the number of divisions and a multiplier for the length of the song
        getDivisionInformation();

        // Acquires the key signature from the music xml file and stores as the key signature element
        try {
            acquireKeySignatureFromMusicXMLFile();
        } catch (Modulo7InvalidCircleOfFifthsDistance | Modulo7BadKeyException e) {
            e.printStackTrace();
        }

        // Acquires the beats information
        acquireTimeSignature();

        // acquires the notes
        getNotes();

        // Acquire the voices from a hash set
        final Set<Voice> voiceSet = new HashSet<>(voiceIndextoVoiceMap.values());

        // Construct song meta data object
        final SongMetadata metadata = new SongMetadata(keySignature, timeSignature);

        // Return the modulo7 constructed song from the data
        return new Song(voiceSet, metadata, MusicSources.MUSIC_XML_FILE);
    }

    /**
     * Acquires the time signature information from music XML file
     */
    private void acquireTimeSignature() {
        for (Element thisTime : this.doc.getElementsByTag("time")) {

            Integer beat = null;
            Integer beatType = null;

            for (Element thisBeat : thisTime.getElementsByTag("beats")) {
                beat = Integer.parseInt(thisBeat.text());
                break;
            }

            for (Element thisBeatType : thisTime.getElementsByTag("beat-type")) {
                beatType = Integer.parseInt(thisBeatType.text());
                break;
            }

            // Set the time signature if both beat and beats per divisioninformation exists
            if (beat != null && beatType != null)
                timeSignature = new TimeSignature(beat, beatType);
        }
    }

    /**
     * Acquires the key signature from the music xml file
     *
     * Read the tutorial here for understanding : http://www.musicxml.com/tutorial/the-midi-compatible-part/attributes/
     *
     * @throws Modulo7InvalidCircleOfFifthsDistance
     * @throws Modulo7BadKeyException
     */
    public void acquireKeySignatureFromMusicXMLFile() throws Modulo7InvalidCircleOfFifthsDistance, Modulo7BadKeyException {

        // The type of scale and key in the music xml file
        final ScaleType scaleType = getScaleType();
        final String key = getKey(scaleType);

        // If both pieces of information are present than create a key signature element for this piece
        if (scaleType != null && key != null)
            keySignature = new KeySignature(key, scaleType);
    }

    /**
     * Gets the type of scale from the music xml file
     * @return The type of scale
     */
    public ScaleType getScaleType() {
        // Acquire the scale information
        for (Element thisKey : this.doc.getElementsByTag("mode")) {
            final String mode = thisKey.text();
            logger.debug("Mode :" + mode);

            // TODO : Introduce cases for other scale types
            if (mode.equalsIgnoreCase("minor"))
                return ScaleType.MINOR;
            else if (mode.equalsIgnoreCase("major"))
                return ScaleType.MAJOR;
        }

        // Return null if no scale types are found in the music xml file
        return null;
    }

    /**
     * Acquire the key information from the music xml file
     *
     * @param typeOfScale
     * @return
     * @throws Modulo7InvalidCircleOfFifthsDistance
     */
    private String getKey(final ScaleType typeOfScale) throws Modulo7InvalidCircleOfFifthsDistance {

        // Acquire the key information from the music xml file
        for (Element thisKey : this.doc.getElementsByTag("fifths")) {
            final int fifthsAwayFromMode = Integer.parseInt(thisKey.text());
            logger.debug("Fifth : " + fifthsAwayFromMode);
            return CircleOfFifths.getKeyGivenFifthDistance(typeOfScale, fifthsAwayFromMode);
        }

        // Return a null if no key is found
        return null;
    }

    /**
     * Gets the number of divisions and a multiplier for each division in a given
     * music XML file and populates it
     */
    private void getDivisionInformation() {
        for (Element thisdiv : this.doc.getElementsByTag("divisions")) {
            divisions.add(Integer.valueOf(thisdiv.text()));
        }

        if (!this.doc.getElementsByTag("divisions").isEmpty()) {

            long lcm = Modulo7Utils.lcm(divisions);

            //set the multiplier for each division.
            for (Integer i : divisions) {
                divMultiplier.put(i, (int) lcm/i);
            }
        } else {
            divMultiplier.put(1,1);
        }
    }

    /**
     * Gets the notes from the song
     */
    private void getNotes() {

        // Assume the number of divisions in a song to be 1 by default
        Integer divisions = 1;

        // Gets the parts in the music xml file
        for (Element thisPart : this.doc.select("part")) {

            // Gets the measure in each part
            for (Element thisMeasure : thisPart.getElementsByTag("measure")) {

                if (!thisMeasure.getElementsByTag("divisions").isEmpty()) {
                    divisions = Integer.valueOf(thisMeasure.getElementsByTag("divisions").text());
                }

                for (Element thisNote : thisMeasure.children()) {
                    if (thisNote.tagName().equals("note")) {

                        // The voice associated with the note
                        final String voiceOfNote = thisNote.getElementsByTag("voice").text();

                        int currentVoiceIndex;

                        if (voiceOfNote.length() == 0) {
                            currentVoiceIndex = 1;
                        } else {
                            currentVoiceIndex = Integer.valueOf(voiceOfNote);
                        }

                        //get the pitch for the given note, by design a correct pitch will always contain the pitch element
                        if (!thisNote.getElementsByTag("pitch").isEmpty()) {
                            for (Element thisPitch : thisNote.getElementsByTag("pitch")) {

                                // Acquire the note and the octave infomration, you can construct the note from these two pieces of information
                                final String note = thisPitch.getElementsByTag("step").text();
                                final int octave = Integer.parseInt(thisPitch.getElementsByTag("octave").text());

                                // An alteration of the note
                                final String alter = String.valueOf(thisPitch.getElementsByTag("alter").text());

                                // Gets the note
                                try {
                                    Accidental accidental = null;

                                    // Check if an alternation element is present or not
                                    if (!StringUtils.isEmpty(alter)) {
                                        if (alter.equals("1")) {
                                            accidental = Accidental.SHARP;
                                        } else if (alter.equals("-1")) {
                                            accidental = Accidental.FLAT;
                                        } else if (alter.equals("2")) {
                                            accidental = Accidental.DOUBLESHARP;
                                        } else if (alter.equals("-2")) {
                                            accidental = Accidental.DOUBLEFLAT;
                                        } else if (alter.equals("0")) {
                                            accidental = Accidental.NONE;
                                        }
                                    } else {
                                        accidental = Accidental.NONE;
                                    }

                                    // Get the base Note based on both the octave and note value of the music xml parser
                                    final Note baseNote = Note.getNoteValue(note, octave);
                                    final Note actualNote = frequencyNoteMap.getModifiedNoteGivenAccidental(baseNote, accidental);

                                    // The duration
                                    final int duration;

                                    // Get the duration of the note
                                    if (thisNote.getElementsByTag("duration").text().isEmpty()) {
                                        duration = 0;
                                    } else {
                                        duration = Integer.valueOf(thisNote.getElementsByTag("duration").text()) * divMultiplier.get(divisions);
                                    }

                                    Set<Note> setOfNotes = new HashSet<>();
                                    setOfNotes.add(actualNote);

                                    VoiceInstant voiceInstant = new VoiceInstant(setOfNotes, duration);

                                    Modulo7Utils.addVoiceInstantToVoiceMap(voiceIndextoVoiceMap, voiceInstant, currentVoiceIndex);
                                } catch (Modulo7BadNoteException | Modulo7BadAccidentalException | Modulo7InvalidLineInstantSizeException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Gets the key signature object
     * @return
     */
    public KeySignature getKeySignature() {
        return keySignature;
    }

    /**
     * Gets the division given the index
     * A song can contain multiple divisions
     * so get the division given the position in
     * which appears in the music xml file
     *
     * @param divisionIndex
     * @return
     */
    public int getDivision(final int divisionIndex) {
        return divisions.get(divisionIndex);
    }

    /**
     * Gets the time signature associated
     * @return
     */
    public TimeSignature getTimeSignature() {
        return timeSignature;
    }
}
