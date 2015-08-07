package com.modulo7.common.exceptions;

/**
 * Created by asanyal on 8/6/2015.
 *
 * An exception from modulo7 which states no such file was found
 */
public class Modulo7NoSuchFileException extends Modulo7BaseException {
    public Modulo7NoSuchFileException(String message) {
        super(message);
    }

    public Modulo7NoSuchFileException(Throwable cause) {
        super(cause);
    }

    public Modulo7NoSuchFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
