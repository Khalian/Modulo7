package com.modulo7.common.utils;

import com.modulo7.musicstatmodels.similarity.contoursimilarity.MullensefsteinContourSimilarity;
import com.modulo7.musicstatmodels.similarity.contoursimilarity.NaturalContourSimilarity;
import com.modulo7.musicstatmodels.similarity.songsimilarity.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by asanyal on 7/20/2015.
 *
 * Class which contains the globals associated with modulo 7
 */
public class Modulo7Globals {

    // Acquiring the host type allows for different types of ops
    public static final String MODULO7_HOST_OS_TYPE;

    // Notes in western music, both flats and sharps taken into account
    public static final String[] NOTE_NAMES = {"A", "A#", "B", "C", "C#", "D", "D#",
            "E", "F", "F#", "G", "G#", "Ab", "Bb", "Db", "Eb", "Fb" ,"Gb"};

    // Notes in western music, only sharps taken into account
    public static final String[] NOTE_NAMES_ONLY_SHARPS = {"A", "A#", "B", "C", "C#", "D", "D#",
            "E", "F", "F#", "G", "G#"};

    // Harmonic equivalency between flats and sharps
    public static final Map<String, String> HARMONIC_EQUIVALENT = new HashMap<String, String>() {{
        put("AB", "G#");
        put("BB", "A#");
        put("CB", "B");
        put("DB", "C#");
        put("EB", "D#");
        put("GB", "F#");
        put("FB", "E");
    }};

    // A place holder for unknown quantities
    public static final int UNKNOWN = -1;

    // A global place holder for unknown string
    public static final String UNKNOWNSTRING = "UNKNOWNSTRING";

    // Audiveris jar location
    public static final String AUDIVERIS_JAR_LOCATION = Modulo7Utils.stringAssign(System.getenv("AUDIVERIS_JAR_LOCATION"));

    // Extensions for avro serialized files via m7
    public static final String EXTENSION_TO_SERIALIZED_FILES = ".m7";

    // The number of processors available to Modulo7, this allows Modulo7 to build a simple threading model
    public static final int NUM_OF_CORES = Runtime.getRuntime().availableProcessors();

    /**
     * Static block declaring all the globals
     */
    static {
        final String osName = System.getProperty("os.name");
        final String osNameMatch = osName.toLowerCase();
        if (osNameMatch.contains("linux")) {
            MODULO7_HOST_OS_TYPE = "LINUX";
        } else if(osNameMatch.contains("windows")) {
            MODULO7_HOST_OS_TYPE = "WINDOWS";
        } else if(osNameMatch.contains("solaris") || osNameMatch.contains("sunos")) {
            MODULO7_HOST_OS_TYPE = "SOLARIS";
        } else if(osNameMatch.contains("mac os") || osNameMatch.contains("macos") || osNameMatch.contains("darwin")) {
            MODULO7_HOST_OS_TYPE = "OSX";
        } else {
            MODULO7_HOST_OS_TYPE = "UNSUPPORTED_OS";
        }
    }

    /**
     * Gets the index of a note given the note value
     * @param note
     * @return
     */
    public static int getIndexOfNote(final String note) {
        for (int i = 0; i < NOTE_NAMES_ONLY_SHARPS.length; i++) {
            if (NOTE_NAMES_ONLY_SHARPS[i].equals(note))
                return i;
        }

        return -1;
    }
}
