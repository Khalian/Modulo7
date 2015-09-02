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
        AbstractStatistic<TonalHistogramResult> statistic = new TonalHistogramStatistic();
        StatisticResult<TonalHistogram> result = statistic.getStatistic(song);

        TonalHistogram histogram = result.getStatisticResultObject();

        final int totalSum = histogram.getHistogramTotalSum();

        int majorSum = 0;

        // Add perfect intervals to perfect sum
        majorSum += histogram.getCountForInterval(IntervalEnum.MAJOR_SECOND);
        majorSum += histogram.getCountForInterval(IntervalEnum.MAJOR_THIRD);
        majorSum += histogram.getCountForInterval(IntervalEnum.MAJOR_SIXTH);
        majorSum += histogram.getCountForInterval(IntervalEnum.MAJOR_SEVENTH);

        return (double)(majorSum / totalSum);
    }
}
