package com.modulo7.common.exceptions;

/**
 * Created by asanyal on 9/20/15.
 *
 * Wrapper on top of lucene parse exception
 */
public class Modulo7ParseException extends Modulo7BaseException {

    public Modulo7ParseException(Throwable cause) {
        super(cause);
    }
}
