package com.modulo7.musicstatmodels.similarity.songsimilarity;

import com.modulo7.common.interfaces.AbstractVoiceSimilarity;
import com.modulo7.musicstatmodels.similarity.genericsimilarity.GenericMaximalVoiceSimilarity;
import com.modulo7.musicstatmodels.similarity.genericsimilarity.SmithWatermanSimilarity;

/**
 * Created by asanyal on 12/30/15.
 *
 * Smith waterman similarity extended to songs
 */
public class SmithWatermanSongSimilarity<T extends AbstractVoiceSimilarity> extends GenericMaximalVoiceSimilarity {

    /**
     * Basic constructor for generic maximal similarity
     */
    public SmithWatermanSongSimilarity(final T similarityMeasure) {
        super(new SmithWatermanSimilarity<>(similarityMeasure));
    }
}
