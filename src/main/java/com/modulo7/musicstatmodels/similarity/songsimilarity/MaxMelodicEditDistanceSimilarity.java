package com.modulo7.musicstatmodels.similarity.songsimilarity;

import com.modulo7.musicstatmodels.similarity.genericsimilarity.GeneralMaximalVoiceSimilarity;
import com.modulo7.musicstatmodels.similarity.voicesimilarity.RawMelodicEditDistanceSimilarity;

/**
 * Created by asanyal on 9/24/15.
 *
 * Generalized version of the raw melodic edit distance
 */
public class MaxMelodicEditDistanceSimilarity extends GeneralMaximalVoiceSimilarity<RawMelodicEditDistanceSimilarity> {

    /**
     * Edit distance over an entire song pairwise and then returns the maximum
     */
    public MaxMelodicEditDistanceSimilarity() {
        super(new RawMelodicEditDistanceSimilarity());
    }
}
