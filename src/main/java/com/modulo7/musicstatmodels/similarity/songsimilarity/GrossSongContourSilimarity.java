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
     * Basic constructor for gross contour similarity
     */
    public GrossSongContourSilimarity() {
        super(new GrossContourSimilarity());
    }
}
