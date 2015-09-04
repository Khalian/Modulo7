package com.modulo7.musicstatmodels.vectorspacemodels.datastructures;

import com.modulo7.musicstatmodels.musictheorymodels.IntervalEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by asanyal on 9/4/15.
 *
 * The tonal histogram as a data structure
 */
public class TonalHistogramData {

    // Internal intervalHistogram representation
    private Map<IntervalEnum, Integer> intervalHistogram = new HashMap<>();

    // A private member which keeps track of total intervalHistogram count
    private int histogramTotalSum = 0;

    /**
     * Tonal Histogram scratch representation
     */
    public TonalHistogramData() {
        intervalHistogram.put(IntervalEnum.PERFECT_UNISON, 0);
        intervalHistogram.put(IntervalEnum.MINOR_SECOND, 0);
        intervalHistogram.put(IntervalEnum.MAJOR_SECOND, 0);
        intervalHistogram.put(IntervalEnum.MINOR_THIRD, 0);
        intervalHistogram.put(IntervalEnum.MAJOR_THIRD, 0);
        intervalHistogram.put(IntervalEnum.PERFECT_FOURTH, 0);
        intervalHistogram.put(IntervalEnum.AUGMENTED_FOURTH, 0);
        intervalHistogram.put(IntervalEnum.PERFECT_FIFTH, 0);
        intervalHistogram.put(IntervalEnum.MINOR_SIXTH, 0);
        intervalHistogram.put(IntervalEnum.MAJOR_SIXTH, 0);
        intervalHistogram.put(IntervalEnum.MINOR_SEVENTH, 0);
        intervalHistogram.put(IntervalEnum.MAJOR_SEVENTH, 0);
        intervalHistogram.put(IntervalEnum.PERFECT_OCTAVE, 0);
    }


    /**
     * Gets an array representation of the vectorized data
     * @return
     */
    public List<Integer> getArrayRepresentation() {
        List<Integer> array = new ArrayList<>();

        for (Map.Entry<IntervalEnum, Integer> histogramElem : intervalHistogram.entrySet()) {
            Integer index = histogramElem.getKey().getIntervalQuantity();
            Integer value = histogramElem.getValue();

            array.add(index, value);
        }

        return array;
    }

    /**
     * Internal helper method to compute total sum over intervalHistogram
     */
    private void computeHistogramTotalSum() {
        for (Integer count : intervalHistogram.values()) {
            histogramTotalSum += count;
        }
    }

    /**
     * Basic getter for the intervalHistogram total sum
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
        return intervalHistogram.get(intervalEnum);
    }

    /**
     * Size of the interval histogram keyset
     * @return
     */
    public int getSize() {
        return intervalHistogram.size();
    }

    /**
     * Gets a positional data from histogram
     * @param interval
     * @return
     */
    public Integer getData(final IntervalEnum interval) {
        return intervalHistogram.get(interval);
    }

    /**
     * Sets positional data in histogram
     * @param interval
     * @param value
     */
    public void setData(final IntervalEnum interval, int value) {
        intervalHistogram.put(interval, value);
    }
}
