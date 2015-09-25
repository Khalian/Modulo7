package com.modulo7.musicstatmodels.similarity.songsimilarity;

import com.modulo7.musicstatmodels.similarity.genericsimilarity.GenericMaximalVoiceSimilarity;
import com.modulo7.musicstatmodels.similarity.voicesimilarity.RawMelodicEditDistanceSimilarity;

/**
 * Created by asanyal on 9/24/15.
 *
 * Generalized version of the raw melodic edit distance
 */
public class MaxMelodicEditDistanceSimilarity extends GenericMaximalVoiceSimilarity<RawMelodicEditDistanceSimilarity> {

    /**
     * Edit distance over an entire song pairwise and then returns the maximum
     * @param similarityMeasure
     */
    public MaxMelodicEditDistanceSimilarity(final RawMelodicEditDistanceSimilarity similarityMeasure) {
        super(similarityMeasure);
    }
}
