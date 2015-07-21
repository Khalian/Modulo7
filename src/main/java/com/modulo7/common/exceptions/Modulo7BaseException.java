package com.modulo7.common.exceptions;

/**
 * Created by asanyal on 6/29/2015.
 */
public class Modulo7BaseException extends Exception {
    public Modulo7BaseException (String message) {
        super (message);
    }

    public Modulo7BaseException (Throwable cause) {
        super (cause);
    }

    public Modulo7BaseException (String message, Throwable cause) {
        super (message, cause);
    }
}
