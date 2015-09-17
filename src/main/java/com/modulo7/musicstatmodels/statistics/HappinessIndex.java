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
 * Similar to power index but counts the major intervals and divides by total number
 *
 * Similar weighting scheme could be done as power index
 */
public class HappinessIndex implements AbstractStatistic<Double> {
    /**
     * Default constructor of power index
     */
    public HappinessIndex() {

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

        int majorSum = 0;

        // Add perfect intervals to perfect sum
        majorSum += histogramData.getCountForInterval(IntervalEnum.MAJOR_SECOND);
        majorSum += histogramData.getCountForInterval(IntervalEnum.MAJOR_THIRD);
        majorSum += histogramData.getCountForInterval(IntervalEnum.MAJOR_SIXTH);
        majorSum += histogramData.getCountForInterval(IntervalEnum.MAJOR_SEVENTH);

        return (double)(majorSum / totalSum);
    }
}
