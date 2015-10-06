package com.modulo7.musicstatmodels.similarity.voicesimilarity;

import com.modulo7.common.interfaces.AbstractVoiceSimilarity;
import com.modulo7.musicstatmodels.similarity.genericsimilarity.ContourSimilarity;
import com.modulo7.musicstatmodels.vectorspacemodels.contour.voicecontour.SteinbeckContour;

/**
 * Created by asanyal on 10/4/15.
 *
 * Steinbeck contour similarity measure for arbitrary voice similarities
 */
public class SteinbeckContourSimililarity extends ContourSimilarity {
    /**
     * Basic constructor
     *
     * @param internalVoiceSimilarity
     * @param internalContourRep
     */
    public SteinbeckContourSimililarity(AbstractVoiceSimilarity internalVoiceSimilarity, SteinbeckContour internalContourRep) {
        super(internalVoiceSimilarity, internalContourRep);
    }
}
