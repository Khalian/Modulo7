package com.modulo7.common.exceptions;

/**
 * Created by asanyal on 9/24/15.
 *
 * Exception which states no such similarity measure was found
 */
public class Modulo7NoSuchSongSimilarityMeasureException extends Modulo7BaseException {

    public Modulo7NoSuchSongSimilarityMeasureException(final String message) {
        super(message);
    }
}
