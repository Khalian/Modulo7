package com.modulo7.musicstatmodels.statistics.results;

import com.modulo7.musicstatmodels.musictheorymodels.IntervalEnum;
import com.modulo7.musicstatmodels.statistics.datatypes.TonalHistogram;

import java.util.Map;

/**
 * Created by asanyal on 8/29/15.
 *
 * Gets the result on the tonal histogram
 */
public class TonalHistogramResult implements StatisticResult<TonalHistogram> {

    // Internal histogram representation
    private TonalHistogram histogram;

    /**
     * Basic constructor
     * @param histogram
     */
    public TonalHistogramResult(final Map<IntervalEnum, Integer> histogram) {
        this.histogram = new TonalHistogram(histogram);
    }

    @Override
    public TonalHistogram getStatisticResultObject() {
        return histogram;
    }
}
