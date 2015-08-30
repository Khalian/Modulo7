package com.modulo7.common.exceptions;

/**
 * Created by asanyal on 8/30/15.
 *
 * Exception detailing vector sizes are mismatched
 */
public class Modulo7VectorSizeMismatchException extends Modulo7BaseException {

    public Modulo7VectorSizeMismatchException(String message) {
        super(message);
    }

    public Modulo7VectorSizeMismatchException(int size1, int size2) {
        super("The vectors need to be of equal size. In this case First Vector Size :" + size1 + " Second Vector Size :" + size2);
    }
}
