package com.modulo7.othersources;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.modulo7.common.exceptions.Modulo7InvalidMusicXMLFile;
import com.modulo7.musicstatmodels.representation.Line;
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
 * TODO : Stub impl, need to actually implement this
 */
public class BasicMusicXMLParser {

    // JSoup document element containing the required document entities
    private Document doc;

    // Logger
    final static Logger logger = Logger.getLogger(BasicMusicXMLParser.class.getName());

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
    private Song parse() {

        // The set of lines that describe the song, mapped to line index
        Map<Integer, Line> lineIndextoLineMap = new HashMap<>();

        // Init the lines as a map between line index (also called voice in music xml jargon)
        for (Element note : this.doc.getElementsByTag("Note")) {
            lineIndextoLineMap.put(Integer.valueOf(note.getElementsByTag("voice").text()), new Line());
        }



        return null;
    }

    /**
     * Run test
     * @param args
     */
    public static void main(String args[]) {

    }
}
