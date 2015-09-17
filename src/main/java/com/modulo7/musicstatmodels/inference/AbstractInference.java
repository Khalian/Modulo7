package com.modulo7.musicstatmodels.inference;

import com.modulo7.musicstatmodels.representation.polyphonic.Song;

/**
 * Created by asanyal on 7/28/2015.
 *
 * Base class for infering a quantity from a song
 */
public abstract class AbstractInference {

    /**
     * Basic method that all implementations must inherit
     * @param song
     * @return
     */
    public abstract InferenceResult infer(final Song song);
}
