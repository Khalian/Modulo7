package com.modulo7.common.exceptions;

/**
 * Created by asanyal on 9/8/15.
 *
 * This exception is thrown when a bad chord construction takes place in modulo7
 */
public class Modulo7BadChordException extends Modulo7BaseException {
    public Modulo7BadChordException(String message) {
        super(message);
    }
}
