package com.modulo7.common.exceptions;

/**
 * Created by asanyal on 8/9/15.
 *
 * This exception is thrown if any reference on the circle of fifths i
 */
public class Modulo7InvalidCircleOfFifthsDistance extends Modulo7BaseException {
    public Modulo7InvalidCircleOfFifthsDistance(String message) {
        super(message);
    }

    public Modulo7InvalidCircleOfFifthsDistance(Throwable cause) {
        super(cause);
    }

    public Modulo7InvalidCircleOfFifthsDistance(String message, Throwable cause) {
        super(message, cause);
    }
}
