package com.modulo7.common.exceptions;

/**
 * Created by asanyal on 7/23/2015.
 *
 * Exception indicating that the modulo7 file input is of invalid music
 * xml format
 */
public class Modulo7InvalidMusicXMLFile extends Modulo7BaseException {
    public Modulo7InvalidMusicXMLFile(String message) {
        super(message);
    }

    public Modulo7InvalidMusicXMLFile(Throwable cause) {
        super(cause);
    }

    public Modulo7InvalidMusicXMLFile(String message, Throwable cause) {
        super(message, cause);
    }
}
