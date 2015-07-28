package com.modulo7.common.exceptions;

/**
 * Created by asanyal on 7/23/2015.
 *
 * Exception indicating that the modulo7 file input is of invalid music
 * xml format
 */
public class Modulo7InvalidMusicXMLFile extends Modulo7BaseException {
    public Modulo7InvalidMusicXMLFile(final String message) {
        super(message);
    }

    public Modulo7InvalidMusicXMLFile(final Throwable cause) {
        super(cause);
    }

    public Modulo7InvalidMusicXMLFile(final String message, Throwable cause) {
        super(message, cause);
    }
}
