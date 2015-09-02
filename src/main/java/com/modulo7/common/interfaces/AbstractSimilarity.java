package com.modulo7.common.interfaces;

import com.modulo7.musicstatmodels.representation.Song;

/**
 * Created by asanyal on 7/25/2015.
 *
 * The base class which denotes an extensible similarity
 * measures are to be used are to be performed
 *
 * TODO : Impl this
 */
public abstract class AbstractSimilarity {

    // Acquire the similarity between any two modulo7 song representations
    protected abstract double getSimilarity(final Song first, final Song second);
}
