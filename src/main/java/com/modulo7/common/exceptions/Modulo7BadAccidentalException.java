package com.modulo7.common.exceptions;

/**
 * Created by asanyal on 8/17/15.
 *
 * A exception which states that the bad exception has been thrown
 */
public class Modulo7BadAccidentalException extends Modulo7BaseException {
    public Modulo7BadAccidentalException(String message) {
        super(message);
    }

    public Modulo7BadAccidentalException(Throwable cause) {
        super(cause);
    }

    public Modulo7BadAccidentalException(String message, Throwable cause) {
        super(message, cause);
    }
}
