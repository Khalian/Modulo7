package com.modulo7.common.exceptions;

/**
 * Created by asanyal on 9/8/15.
 *
 * Exception dictating the fact that the modulo7 database has not been serialized yet
 * and the operation being performed in code is invalid
 */
public class Modulo7DataBaseNotSerializedException extends Modulo7BaseException {
    public Modulo7DataBaseNotSerializedException(String message) {
        super(message);
    }
}
