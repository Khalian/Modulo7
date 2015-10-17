package com.modulo7.common.exceptions;

/**
 * Created by asanyal on 10/16/15.
 *
 * When you have no such voice similarity measure in the list of implemented measures
 */
public class Modulo7NoSuchVoiceSimilarityMeasureException extends Modulo7BaseException {
    public Modulo7NoSuchVoiceSimilarityMeasureException(String s) {
        super(s);
    }
}
