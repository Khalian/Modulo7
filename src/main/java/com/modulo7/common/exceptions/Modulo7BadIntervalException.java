package com.modulo7.common.exceptions;

/**
 * Created by asanyal on 8/20/15.
 *
 * Exception stating that bad interval is encountered
 */
public class Modulo7BadIntervalException extends Modulo7BaseException {
    public Modulo7BadIntervalException(String message) {
        super(message);
    }

    public Modulo7BadIntervalException(Throwable cause) {
        super(cause);
    }

    public Modulo7BadIntervalException(String message, Throwable cause) {
        super(message, cause);
    }
}
