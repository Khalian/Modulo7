package com.modulo7.common.exceptions;

import com.modulo7.common.exceptions.Modulo7BaseException;

/**
 * Created by asanyal on 6/29/2015.
 *
 * To be thrown by Modulo7 code when a wrong file format is encountered
 * in method
 */
public class Modulo7FileFormatException extends Modulo7BaseException {
    public Modulo7FileFormatException(final String message) {
        super (message);
    }

    public Modulo7FileFormatException(final Throwable cause) {
        super (cause);
    }

    public Modulo7FileFormatException(final String message, Throwable cause) {
        super (message, cause);
    }
}
