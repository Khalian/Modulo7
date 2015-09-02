package com.modulo7.musicstatmodels.statistics.statisticscompute;

import com.modulo7.common.interfaces.AbstractStatistic;
import com.modulo7.musicstatmodels.musictheorymodels.IntervalEnum;
import com.modulo7.musicstatmodels.representation.Song;
import com.modulo7.musicstatmodels.statistics.datatypes.TonalHistogram;
import com.modulo7.musicstatmodels.statistics.results.StatisticResult;
import com.modulo7.musicstatmodels.statistics.results.TonalHistogramResult;

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
        AbstractStatistic<TonalHistogramResult> statistic = new TonalHistogramStatistic();
        StatisticResult<TonalHistogram> result = statistic.getStatistic(song);

        TonalHistogram histogram = result.getStatisticResultObject();

        final int totalSum = histogram.getHistogramTotalSum();

        int minorSum = 0;

        // Add perfect intervals to perfect sum
        minorSum += histogram.getCountForInterval(IntervalEnum.MINOR_SECOND);
        minorSum += histogram.getCountForInterval(IntervalEnum.MINOR_THIRD);
        minorSum += histogram.getCountForInterval(IntervalEnum.MINOR_SIXTH);
        minorSum += histogram.getCountForInterval(IntervalEnum.MINOR_SEVENTH);

        return (double)(minorSum / totalSum);
    }
}
