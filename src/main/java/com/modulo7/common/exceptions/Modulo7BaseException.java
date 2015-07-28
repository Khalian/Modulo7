package com.modulo7.common.exceptions;

/**
 * Created by asanyal on 6/29/2015.
 */
public class Modulo7BaseException extends Exception {
    public Modulo7BaseException (final String message) {
        super (message);
    }

    public Modulo7BaseException (final Throwable cause) {
        super (cause);
    }

    public Modulo7BaseException (final String message, final Throwable cause) {
        super (message, cause);
    }
}
