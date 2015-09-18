package com.modulo7.common.interfaces;

import com.modulo7.musicstatmodels.representation.monophonic.Voice;

/**
 * Created by asanyal on 9/18/15.
 *
 * A similarity metric between two voices
 */
public interface AbstractVoiceSimilarity {

    // Acquire the similarity between any two modulo7 voice representations
    public double getSimilarity(final Voice first, final Voice second);
}
