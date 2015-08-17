package com.modulo7.common.exceptions;

/**
 * Created by asanyal on 8/17/15. s
 *
 * Exception which states that the exception is bad
 */
public class Modulo7BadNoteException extends Modulo7BaseException {
    public Modulo7BadNoteException(String message) {
        super(message);
    }

    public Modulo7BadNoteException(Throwable cause) {
        super(cause);
    }

    public Modulo7BadNoteException(String message, Throwable cause) {
        super(message, cause);
    }
}
