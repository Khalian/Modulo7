package com.modulo7.musicstatmodels.statistics;

import com.modulo7.common.interfaces.AbstractSongVector;
import com.modulo7.common.interfaces.AbstractStatistic;
import com.modulo7.musicstatmodels.musictheorymodels.IntervalEnum;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;
import com.modulo7.musicstatmodels.vectorspacemodels.datastructures.TonalHistogramData;
import com.modulo7.musicstatmodels.vectorspacemodels.vectorspacerepresentations.songvectors.TonalHistogram;

/**
 * Created by asanyal on 8/29/15.
 *
 * Similar to power index but counts the minor intervals and divides by total number
 *
 * Similar weighting scheme could be done as power index
 */
public class SadnessIndex implements AbstractStatistic<Double> {
    /**
     * Default constructor of power index
     */
    public SadnessIndex() {

    }

    /**
     * Gets the perfect intervals vs total intervals ratio
     * @param song
     * @return
     */
    @Override
    public Double getStatistic(final Song song) {
        AbstractSongVector<TonalHistogramData> tonalHistogram = new TonalHistogram();
        tonalHistogram.computeVectorRepresentation(song);
        TonalHistogramData histogramData = tonalHistogram.getInternalRepresentation();

        final int totalSum = histogramData.getHistogramTotalSum();

        int minorSum = 0;

        // Add perfect intervals to perfect sum
        minorSum += histogramData.getCountForInterval(IntervalEnum.MINOR_SECOND);
        minorSum += histogramData.getCountForInterval(IntervalEnum.MINOR_THIRD);
        minorSum += histogramData.getCountForInterval(IntervalEnum.MINOR_SIXTH);
        minorSum += histogramData.getCountForInterval(IntervalEnum.MINOR_SEVENTH);

        return (double)(minorSum / totalSum);
    }
}
