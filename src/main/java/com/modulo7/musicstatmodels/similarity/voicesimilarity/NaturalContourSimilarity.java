package com.modulo7.musicstatmodels.similarity.voicesimilarity;

import com.modulo7.common.interfaces.AbstractVoiceSimilarity;
import com.modulo7.musicstatmodels.similarity.genericsimilarity.ContourSimilarity;
import com.modulo7.musicstatmodels.vectorspacemodels.contour.voicecontour.NaturalContour;

/**
 * Created by asanyal on 10/4/15.
 *
 * Simple natural contour similarity, extending any voice similarity to natural contour
 */
public class NaturalContourSimilarity extends ContourSimilarity {

    /**
     * Basic constructor
     *
     * @param internalVoiceSimilarity
     * @param internalContourRep
     */
    public NaturalContourSimilarity(AbstractVoiceSimilarity internalVoiceSimilarity, NaturalContour internalContourRep) {
        super(internalVoiceSimilarity, internalContourRep);
    }
}
