package com.modulo7.othersources;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.modulo7.common.exceptions.Modulo7BadKeyException;
import com.modulo7.common.exceptions.Modulo7InvalidCircleOfFifthsDistance;
import com.modulo7.common.exceptions.Modulo7InvalidMusicXMLFile;
import com.modulo7.musicstatmodels.musictheorymodels.CircleOfFifths;
import com.modulo7.musicstatmodels.representation.KeySignature;
import com.modulo7.musicstatmodels.representation.ScaleType;
import com.modulo7.musicstatmodels.representation.Voice;
import com.modulo7.musicstatmodels.representation.Song;
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

        // The set of lines that describe the song, mapped to line index
        Map<Integer, Voice> lineIndextoLineMap = new HashMap<>();

        // Init the lines as a map between line index (also called voice in music xml jargon)
        for (Element note : this.doc.getElementsByTag("Note")) {
            lineIndextoLineMap.put(Integer.valueOf(note.getElementsByTag("voice").text()), new Voice());
        }

        // get the number of divisions and the change throughout the piece, more often than not its just one
        // and divisional information does not change over the course of the song
        final List<Integer> divisions =  new ArrayList();

        for (Element thisdiv : this.doc.getElementsByTag("divisions")) {
            divisions.add(Integer.valueOf(thisdiv.text()));
        }

        // Acquires the key signature from the music xml file
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

        // Return a null if not key is found
        return null;
    }

    /**
     * Gets the notes from the song
     */
    private void getNotes() {

    }

    /**
     * Run test
     * @param args
     */
    public static void main(String args[]) {

    }
}
