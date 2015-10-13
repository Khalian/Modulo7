package com.modulo7.common.exceptions;

/**
 * Created by asanyal on 8/6/2015.
 *
 * An exception from modulo7 which states no such file was found
 */
public class Modulo7NoSuchFileOrDirectoryException extends Modulo7BaseException {
    public Modulo7NoSuchFileOrDirectoryException(String message) {
        super(message);
    }

    public Modulo7NoSuchFileOrDirectoryException(Throwable cause) {
        super(cause);
    }

    public Modulo7NoSuchFileOrDirectoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
