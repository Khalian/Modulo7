package com.modulo7.othersources;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.modulo7.common.exceptions.*;
import com.modulo7.common.utils.FrequencyNoteMap;
import com.modulo7.common.utils.Modulo7Utils;
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
public class BasicMusicXMLParser {

    // JSoup document element containing the required document entities
    private Document doc;

    // Logger
    final static Logger logger = Logger.getLogger(BasicMusicXMLParser.class.getName());

    // Key signature of the song if its present in the music xml encoding
    private KeySignature keySignature = null;

    // The set of lines that describe the song, mapped to line index
    private Map<Integer, Voice> voiceIndextoVoiceMap = new HashMap<>();

    // Get an instance of frequencies to the notes
    private FrequencyNoteMap frequencyNoteMap = FrequencyNoteMap.getInstance();

    //
    private Map<Integer, Integer> divMultiplier = new HashMap<>();

    /**
     * Basic constructor which keeps the information on
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
     * TODO : Implement this
     */
    private Song parse() throws Modulo7InvalidCircleOfFifthsDistance, Modulo7BadKeyException {

        // Init the lines as a map between line index (also called voice in music xml jargon)
        for (Element note : this.doc.getElementsByTag("Note")) {
            voiceIndextoVoiceMap.put(Integer.valueOf(note.getElementsByTag("voice").text()), new Voice());
        }

        // Gets the number of divisions and a multiplier for the length of the song
        getDivisionInformation();

        // Acquires the key signature from the music xml file and stores as the key signature element
        acquireKeySignatureFromMusicXMLFile();

        return null;
    }

    /**
     * Acquires the key signature from the music xml file
     *
     * Read the tutorial here for understanding : http://www.musicxml.com/tutorial/the-midi-compatible-part/attributes/
     *
     * @throws Modulo7InvalidCircleOfFifthsDistance
     * @throws Modulo7BadKeyException
     */
    private void acquireKeySignatureFromMusicXMLFile() throws Modulo7InvalidCircleOfFifthsDistance, Modulo7BadKeyException {
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
    private ScaleType getScaleType() {
        // Acquire the scale information
        for (Element thisKey : this.doc.getElementsByTag("mode")) {
            final String mode = thisKey.text();

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
        final List<Integer> divisions =  new ArrayList<Integer>();

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

                        // Identify to which voice this note belongs to, we will accordingly add the note to the voice
                        final int currentVoiceIndex = Integer.valueOf(thisNote.getElementsByTag("voice").text());

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

                                    final Note baseNote = Note.getNoteValue(note);
                                    final Note actualNote = frequencyNoteMap.getModifiedNoteGivenAccidental(baseNote, accidental);

                                    // The duration
                                    final int duration;

                                    // Get the duration of the note
                                    if (thisNote.getElementsByTag("duration").text().isEmpty()) {
                                        duration = 0;
                                    } else {
                                        duration = Integer.valueOf(thisNote.getElementsByTag("duration").text()) * divMultiplier.get(divisions);
                                    }

                                } catch (Modulo7BadNoteException | Modulo7BadAccidentalException e) {
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
     * Run test
     * @param args
     */
    public static void main(String args[]) {

    }
}
