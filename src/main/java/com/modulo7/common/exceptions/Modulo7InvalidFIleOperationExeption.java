package com.modulo7.common.exceptions;

/**
 * Created by asanyal on 9/16/15.
 *
 * Exception to be used when there is an issue while modulo7 operates with a file
 */
public class Modulo7InvalidFIleOperationExeption extends Modulo7BaseException {

    public Modulo7InvalidFIleOperationExeption(String message) {
        super(message);
    }
}
