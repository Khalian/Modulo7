package com.modulo7.musicstatmodels.similarity.contoursimilarity;

import com.modulo7.common.interfaces.AbstractVoiceSimilarity;
import com.modulo7.musicstatmodels.similarity.genericsimilarity.SongContourSimilarity;
import com.modulo7.musicstatmodels.vectorspacemodels.contour.voicecontour.SteinbeckContour;

/**
 * Created by asanyal on 10/4/15.
 *
 * Steinbeck contour similarity measure for arbitrary voice similarities
 */
public class SteinbeckContourSimililarity extends SongContourSimilarity {
    /**
     * Basic constructor
     *
     * @param internalVoiceSimilarity
     */
    public SteinbeckContourSimililarity(final AbstractVoiceSimilarity internalVoiceSimilarity) {
        super(internalVoiceSimilarity, new SteinbeckContour());
    }
}
