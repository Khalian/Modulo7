package com.modulo7.musicstatmodels.similarity;

import com.modulo7.common.exceptions.Modulo7VectorSizeMismatchException;
import com.modulo7.common.interfaces.AbstractSimilarity;
import com.modulo7.common.utils.Modulo7Globals;
import com.modulo7.common.utils.Modulo7Utils;
import com.modulo7.musicstatmodels.musictheorymodels.IntervalEnum;
import com.modulo7.musicstatmodels.representation.Song;
import com.modulo7.musicstatmodels.vectorspacemodels.datastructures.TonalHistogramData;
import com.modulo7.musicstatmodels.vectorspacemodels.vectorspacerepresentations.AbstractVector;
import com.modulo7.musicstatmodels.vectorspacemodels.vectorspacerepresentations.TonalHistogram;

import java.util.Map;

/**
 * Created by asanyal on 8/30/15.
 *
 * Tonal histogram similarity measure is based on the fact that the tonal histogram
 * can act as an vectorized representation of the song. As such the cosine similarity
 * or any other such measure can also be used
 */
public class TonalHistogramSimilarity implements AbstractSimilarity {

    @Override
    public double getSimilarity(final Song first, final Song second) {
        AbstractVector<TonalHistogramData> tonalHistogram = new TonalHistogram();
        tonalHistogram.computeVectorRepresentation(first);
        TonalHistogramData internalVectorOne = tonalHistogram.getInternalRepresentation();

        AbstractVector<TonalHistogramData> tonalHistogramSecond = new TonalHistogram();
        tonalHistogramSecond.computeVectorRepresentation(second);
        TonalHistogramData internalVectorTwo = tonalHistogram.getInternalRepresentation();

        try {
            return Modulo7Utils.cosineSimilarity(internalVectorOne.getArrayRepresentation(), internalVectorTwo.getArrayRepresentation());
        } catch (Modulo7VectorSizeMismatchException e) {
            e.printStackTrace();
        }

        // If things fail return an unknown value, unlikely it will reach this code path
        return Modulo7Globals.UNKNOWN;
    }
}
