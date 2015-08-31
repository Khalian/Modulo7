package com.modulo7.common.utils;

/**
 * Created by asanyal on 7/20/2015.
 *
 * Class which contains the globals associated with modulo 7
 */
public class Modulo7Globals {

    // Acquiring the host type allows for different types of ops
    public static final String MODULO7_HOST_OS_TYPE;

    // Notes in western music, both and sharps taken into account
    public static final String[] NOTE_NAMES = {"A", "A#", "B", "C", "C#", "D", "D#",
            "E", "F", "F#", "G", "G#", "Ab", "Bb", "Db", "Eb", "Gb"};

    // A place holder for unknown quantities
    public static final int UNKNOWN = -1;

    // A global place holder for unknown string
    public static final String UNKNOWNSTRING = "UNKNOWNSTRING";

    /**
     * Static block declaring all the gloabals
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
     * Assigns unknown if input is string, leaves it unchanged otherwise
     *
     * @param argument
     * @return
     */
    public static String stringAssign(final String argument) {
        if (argument == null) {
            return Modulo7Globals.UNKNOWNSTRING;
        }

        return argument;
    }
}
