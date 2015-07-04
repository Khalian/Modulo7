package com.modulo7.common;

/**
 * Created by asanyal on 6/29/2015.
 *
 * To be thrown by Modulo7 code when a wrong file format is encountered
 * in method
 */
public class FileFormatException extends Modulo7BaseException {
    public FileFormatException (String message) {
        super (message);
    }

    public FileFormatException (Throwable cause) {
        super (cause);
    }

    public FileFormatException (String message, Throwable cause) {
        super (message, cause);
    }
}
