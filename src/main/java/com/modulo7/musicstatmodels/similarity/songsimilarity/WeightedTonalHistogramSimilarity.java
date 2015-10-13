package com.modulo7.musicstatmodels.similarity.songsimilarity;

import com.modulo7.common.exceptions.Modulo7VectorSizeMismatchException;
import com.modulo7.common.interfaces.AbstractSongSimilarity;
import com.modulo7.common.interfaces.AbstractSongVector;
import com.modulo7.common.utils.Modulo7Globals;
import com.modulo7.common.utils.Modulo7Utils;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;
import com.modulo7.musicstatmodels.vectorspacemodels.datastructures.TonalDurationHistogramData;
import com.modulo7.musicstatmodels.vectorspacemodels.vectorspacerepresentations.songvectors.TonalDurationHistogram;
import org.apache.log4j.Logger;

/**
 * Created by asanyal on 10/11/15.
 *
 * Similar to the tonal histogram similarity measure, but weighted with the durations of intervals
 */
public class WeightedTonalHistogramSimilarity implements AbstractSongSimilarity {

    private static Logger logger = Logger.getLogger(WeightedTonalHistogramSimilarity.class);

    @Override
    public double getSimilarity(Song first, Song second) {
        AbstractSongVector<TonalDurationHistogramData> tonalHistogram = new TonalDurationHistogram();
        tonalHistogram.computeVectorRepresentation(first);
        TonalDurationHistogramData internalVectorOne = tonalHistogram.getInternalRepresentation();

        AbstractSongVector<TonalDurationHistogramData> tonalHistogramSecond = new TonalDurationHistogram();
        tonalHistogramSecond.computeVectorRepresentation(second);
        TonalDurationHistogramData internalVectorTwo = tonalHistogramSecond.getInternalRepresentation();

        try {
            return Modulo7Utils.cosineSimilarity(internalVectorOne.getArrayRepresentation(),
                    internalVectorTwo.getArrayRepresentation());
        } catch (Modulo7VectorSizeMismatchException e) {
            logger.error(e.getMessage());
        }

        // If things fail return an unknown value, unlikely it will reach this code path
        return Modulo7Globals.UNKNOWN;
    }
}