package com.modulo7.common.exceptions;

/**
 * Created by asanyal on 8/21/15.
 *
 * Exception denoting the wrong type of note
 */
public class Modulo7WrongNoteType extends Modulo7BaseException {
    public Modulo7WrongNoteType(String message) {
        super(message);
    }

    public Modulo7WrongNoteType(Throwable cause) {
        super(cause);
    }

    public Modulo7WrongNoteType(String message, Throwable cause) {
        super(message, cause);
    }
}
