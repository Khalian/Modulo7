package com.modulo7.musicstatmodels.similarity.songsimilarity;

import com.modulo7.musicstatmodels.similarity.genericsimilarity.GenericMaximalVoiceSimilarity;
import com.modulo7.musicstatmodels.similarity.voicesimilarity.GrossContourSimilarity;

/**
 * Created by asanyal on 10/2/15.
 *
 * Maximal gross contour over the songs similarity measure
 */
public class GrossSongContourSilimarity extends GenericMaximalVoiceSimilarity<GrossContourSimilarity> {

    /**
     * Basic constructor for generic maximal similarity
     *
     * @param similarityMeasure (The internal similarity measure used inside generic maximal voice similarity)
     * must be of type gross contour similarity
     */
    public GrossSongContourSilimarity(final GrossContourSimilarity similarityMeasure) {
        super(similarityMeasure);
    }
}
