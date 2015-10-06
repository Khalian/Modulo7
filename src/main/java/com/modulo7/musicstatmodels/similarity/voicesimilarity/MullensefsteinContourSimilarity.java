package com.modulo7.musicstatmodels.similarity.voicesimilarity;

import com.modulo7.common.interfaces.AbstractVoiceSimilarity;
import com.modulo7.musicstatmodels.similarity.genericsimilarity.ContourSimilarity;
import com.modulo7.musicstatmodels.vectorspacemodels.contour.voicecontour.MullensiefenContour;

/**
 * Created by asanyal on 10/4/15.
 *
 * Mullefenstein contour similarity for arbitrary voice similarity
 */
public class MullensefsteinContourSimilarity extends ContourSimilarity {
    /**
     * Basic constructor
     *
     * @param internalVoiceSimilarity
     * @param internalContourRep
     */
    public MullensefsteinContourSimilarity(AbstractVoiceSimilarity internalVoiceSimilarity, MullensiefenContour internalContourRep) {
        super(internalVoiceSimilarity, internalContourRep);
    }
}
