package com.modulo7.common;

/**
 * Created by asanyal on 7/14/2015.
 *
 * Exception thrown when invalid octave ranges are given which
 * modulo7 does not understand (octave ranges are numbers between
 * 0 to 8 for standard musical instruments)
 *
 */
public class Modulo7InvalidOctaveRangeException extends Modulo7BaseException {
    public Modulo7InvalidOctaveRangeException(String message) {
        super(message);
    }

    public Modulo7InvalidOctaveRangeException(Throwable cause) {
        super(cause);
    }

    public Modulo7InvalidOctaveRangeException(String message, Throwable cause) {
        super(message, cause);
    }
}
