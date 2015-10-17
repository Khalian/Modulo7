package com.modulo7.musicstatmodels.similarity.contoursimilarity;

import com.modulo7.common.interfaces.AbstractVoiceSimilarity;
import com.modulo7.musicstatmodels.similarity.genericsimilarity.SongContourSimilarity;
import com.modulo7.musicstatmodels.vectorspacemodels.contour.voicecontour.NaturalContour;

/**
 * Created by asanyal on 10/4/15.
 *
 * Simple natural contour similarity, extending any voice similarity to natural contour
 */
public class NaturalContourSimilarity extends SongContourSimilarity {

    /**
     * Basic constructor
     *
     * @param internalVoiceSimilarity
     */
    public NaturalContourSimilarity(final AbstractVoiceSimilarity internalVoiceSimilarity) {
        super(internalVoiceSimilarity, new NaturalContour());
    }
}
