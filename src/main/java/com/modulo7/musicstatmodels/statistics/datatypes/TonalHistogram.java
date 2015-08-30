package com.modulo7.musicstatmodels.statistics.datatypes;

import com.modulo7.musicstatmodels.musictheorymodels.Interval;
import com.modulo7.musicstatmodels.musictheorymodels.IntervalEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by asanyal on 8/29/15.
 *
 * A tonal histogram data structure, containing absolute counts
 * of a tonal histogram
 *
 */
public class TonalHistogram {

    // Internal histogram representation
    private Map<IntervalEnum, Integer> histogram;

    // A private member which keeps track of total histogram count
    private int histogramTotalSum = 0;

    /**
     * Default constructor
     * @param histogram
     */
    public TonalHistogram(Map<IntervalEnum, Integer> histogram) {
        this.histogram = histogram;
        computeHistogramTotalSum();
    }

    /**
     * Internal helper method to compute total sum over histogram
     */
    private void computeHistogramTotalSum() {
        for (Integer count : histogram.values()) {
            histogramTotalSum += count;
        }
    }

    /**
     * Basic getter for the histogram total sum
     * @return
     */
    public int getHistogramTotalSum() {
        return histogramTotalSum;
    }

    /**
     * This method acquires count for a particular interval
     *
     * @param intervalEnum
     * @return
     */
    public int getCountForInterval(final IntervalEnum intervalEnum) {
        return histogram.get(intervalEnum);
    }

    /**
     * Gets the vectorized representation of the tonal histogram concept
     * as an array of 12 integers
     *
     * @return
     */
    public List<Integer> getVectorizedRepresentation() {
        Integer[] array = new Integer[12];

        for (Map.Entry<IntervalEnum, Integer> histogramElem : histogram.entrySet()) {
            array[histogramElem.getKey().getIntervalQuantity()] = histogramElem.getValue();
        }

        return Arrays.asList(array);
    }
}
