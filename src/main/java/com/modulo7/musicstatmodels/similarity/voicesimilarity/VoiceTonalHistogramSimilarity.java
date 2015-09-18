package com.modulo7.musicstatmodels.similarity.voicesimilarity;

import com.modulo7.common.interfaces.AbstractVoiceSimilarity;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;

/**
 * Created by asanyal on 9/18/15.
 */
public class VoiceTonalHistogramSimilarity implements AbstractVoiceSimilarity {


    @Override
    public double getSimilarity(final Voice first, final Voice second) {
        return 0;
    }
}
