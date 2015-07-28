package com.modulo7.common.exceptions;

/**
 * Created by asanyal on 7/25/2015.
 */
public class Modulo7BadKeyException extends Modulo7BaseException {
    public Modulo7BadKeyException(final String message) {
        super(message);
    }

    public Modulo7BadKeyException(final Throwable cause) {
        super(cause);
    }
}
