package com.modulo7.musicstatmodels.statistics.statistics;

import com.modulo7.common.interfaces.AbstractStatistic;
import com.modulo7.musicstatmodels.musictheorymodels.IntervalEnum;
import com.modulo7.musicstatmodels.representation.Song;
import com.modulo7.musicstatmodels.vectorspacemodels.datastructures.TonalHistogramData;
import com.modulo7.musicstatmodels.vectorspacemodels.vectorspacerepresentations.AbstractVector;
import com.modulo7.musicstatmodels.vectorspacemodels.vectorspacerepresentations.TonalHistogram;

/**
 * Created by asanyal on 8/29/15.
 *
 * The power index is a basic statistic which includes the number of perfect intervals
 * in a given song / total number of intervals or notes in the song (a mathematically precise
 * way of computing the number of
 *
 * The power index might be weighted in order to get a particular interval some more precedence.
 * These weights are based on user preference and Modulo7 does not claim to understand the meaning
 * or significance of these weights TODO : Implement this weighted version and figure out what it
 * would mean
 *
 * Power index is a rudimentary quantification of the neutrality/power associated with the song.
 * Rock songs generally tend to have higher power indices
 */
public class PowerIndex implements AbstractStatistic<Double> {

    /**
     * Default constructor of power index
     */
    public PowerIndex() {

    }

    /**
     * Gets the perfect intervals vs total intervals ratio
     * @param song
     * @return
     */
    @Override
    public Double getStatistic(final Song song) {
        AbstractVector<TonalHistogramData> tonalHistogram = new TonalHistogram();
        tonalHistogram.computeVectorRepresentation(song);
        TonalHistogramData histogramData = tonalHistogram.getInternalRepresentation();

        final int totalSum = histogramData.getHistogramTotalSum();

        int perfectSum = 0;

        // Add perfect intervals to perfect sum
        perfectSum += histogramData.getCountForInterval(IntervalEnum.PERFECT_UNISON);
        perfectSum += histogramData.getCountForInterval(IntervalEnum.PERFECT_FIFTH);
        perfectSum += histogramData.getCountForInterval(IntervalEnum.PERFECT_OCTAVE);
        perfectSum += histogramData.getCountForInterval(IntervalEnum.PERFECT_FOURTH);

        return (double)(perfectSum / totalSum);
    }
}
