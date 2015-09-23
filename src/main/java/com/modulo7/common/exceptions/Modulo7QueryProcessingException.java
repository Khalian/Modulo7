package com.modulo7.common.exceptions;

/**
 * Created by asanyal on 9/21/15.
 *
 * This exception is thrown whenever query processing goes through
 * an error in the modulo7 engine
 */
public class Modulo7QueryProcessingException extends Modulo7BaseException {
    public Modulo7QueryProcessingException(String message) {
        super(message);
    }
}
