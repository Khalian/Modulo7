package com.modulo7.crawler.utils;

import org.apache.commons.compress.compressors.FileNameUtil;
import org.apache.commons.io.FilenameUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by asanyal on 7/18/2015.
 *
 * This enumeration lists all the music sources that
 * can be acquired via modulo7
 *
 * As such a crawler can be configured to obtain a subset
 * of these sources for its processing or the database engine can
 * will be able to filter out only the songs that it needs based
 * on the extensions
 */
public enum MusicSources {

    // Acoustic sources
    MP3("mp3"),

    // Symbolic sources
    MUSIC_XML_FILE("musicxml"),
    MIDI("midi"),
    SHEET_MUSIC("sheet"),

    // Archaic research sources
    MSD("million_song_dataset"),

    // Unknown Source
    UNKNOWN("Unknown");

    // String representation of source
    private String source;

    /**
     * Basic constructor for music sources
     * @param source
     */
    MusicSources(final String source) {
        this.source = source;
    }

    // Supported file extensions for the modulo7 platform
    private static Set<String> SUPPORTED_FILE_EXTENSIONS = new HashSet<>(Arrays.asList("mid", "midi", "mp3", "png", "pdf", "jpeg", "xml", "h5", "m7"));

    /**
     * Check if modulo7 allows a particular file extension for
     * @param fileName
     * @return
     */
    public static boolean checkIfSupportedExtension(final String fileName) {
        final String fileExtension = FilenameUtils.getExtension(fileName);
        return SUPPORTED_FILE_EXTENSIONS.contains(fileExtension.toLowerCase());
    }

    /**
     * Gets the string representation of the music source
     * @return
     */
    public String getStringRepresentation() {
        return source;
    }
}
