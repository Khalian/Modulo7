package com.modulo7.common.exceptions;

/**
 * Created by asanyal on 9/16/15.
 *
 * This exception is thrown when a malformed query is given to the m7 parser
 */
public class Modulo7MalformedM7SQLQuery extends Modulo7BaseException {

    public Modulo7MalformedM7SQLQuery(String message) {
        super(message);
    }
}
