package com.modulo7.musicstatmodels.similarity.contoursimilarity;

import com.modulo7.common.interfaces.AbstractVoiceSimilarity;
import com.modulo7.musicstatmodels.similarity.genericsimilarity.SongContourSimilarity;
import com.modulo7.musicstatmodels.vectorspacemodels.contour.voicecontour.MullensiefenContour;

/**
 * Created by asanyal on 10/4/15.
 *
 * Mullefenstein contour similarity for arbitrary voice similarity
 */
public class MullensefsteinContourSimilarity extends SongContourSimilarity {
    /**
     * Basic constructor
     *
     * @param internalVoiceSimilarity
     */
    public MullensefsteinContourSimilarity(final AbstractVoiceSimilarity internalVoiceSimilarity) {
        super(internalVoiceSimilarity, new MullensiefenContour());
    }
}
