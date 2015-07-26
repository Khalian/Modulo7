package com.modulo7.crawler.utils;

/**
 * Created by asanyal on 7/18/2015.
 *
 * This enumeration lists all the music sources that
 * can be acquired via modulo7
 *
 * As such a crawler can be configured to obtain a subset
 * of these sources for its processing
 */
public enum MusicSources {

    // Sheet music sources
    PNGSHEET,
    JPEGSHEET,

    // Acoustic sources
    MP3,
    WAV,
    MIDI,

    // Other kinds of sources
    MUSIC_XML_FILE;
}
