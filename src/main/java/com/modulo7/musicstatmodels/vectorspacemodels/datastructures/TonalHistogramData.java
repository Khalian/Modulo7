package com.modulo7.musicstatmodels.vectorspacemodels.datastructures;

import com.modulo7.musicstatmodels.musictheorymodels.IntervalQuantity;

import java.util.*;

/**
 * Created by asanyal on 9/4/15.
 *
 * The tonal histogram as a data structure
 */
public class TonalHistogramData {

    // Internal intervalHistogram representation
    private Map<IntervalQuantity, Integer> intervalHistogram = new HashMap<>();

    /**
     * Tonal Histogram scratch representation
     */
    public TonalHistogramData() {
        intervalHistogram.put(IntervalQuantity.PERFECT_UNISON, 0);
        intervalHistogram.put(IntervalQuantity.MINOR_SECOND, 0);
        intervalHistogram.put(IntervalQuantity.MAJOR_SECOND, 0);
        intervalHistogram.put(IntervalQuantity.MINOR_THIRD, 0);
        intervalHistogram.put(IntervalQuantity.MAJOR_THIRD, 0);
        intervalHistogram.put(IntervalQuantity.PERFECT_FOURTH, 0);
        intervalHistogram.put(IntervalQuantity.AUGMENTED_FOURTH, 0);
        intervalHistogram.put(IntervalQuantity.PERFECT_FIFTH, 0);
        intervalHistogram.put(IntervalQuantity.MINOR_SIXTH, 0);
        intervalHistogram.put(IntervalQuantity.MAJOR_SIXTH, 0);
        intervalHistogram.put(IntervalQuantity.MINOR_SEVENTH, 0);
        intervalHistogram.put(IntervalQuantity.MAJOR_SEVENTH, 0);
        intervalHistogram.put(IntervalQuantity.PERFECT_OCTAVE, 0);
    }


    /**
     * Gets an array representation of the vectorized data
     * @return
     */
    public List<Number> getArrayRepresentation() {
        Integer[] array = new Integer[13];

        for (Map.Entry<IntervalQuantity, Integer> histogramElem : intervalHistogram.entrySet()) {
            final Integer index = histogramElem.getKey().getQuantity();
            final Integer value = histogramElem.getValue();

            array[index] = value;
        }

        return Arrays.asList(array);
    }

    /**
     * Basic getter for the intervalHistogram total sum
     * @return
     */
    public int getHistogramTotalSum() {

        int histogramTotalSum = 0;

        for (Integer count : intervalHistogram.values()) {
            histogramTotalSum += count;
        }

        return histogramTotalSum;
    }

    /**
     * This method acquires count for a particular interval
     *
     * @param intervalQuantity
     * @return
     */
    public int getCountForInterval(final IntervalQuantity intervalQuantity) {
        return intervalHistogram.get(intervalQuantity);
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
    public Integer getData(final IntervalQuantity interval) {
        return intervalHistogram.get(interval);
    }

    /**
     * Sets positional data in histogram
     * @param interval
     * @param value
     */
    public void setData(final IntervalQuantity interval, final int value) {
        intervalHistogram.put(interval, value);
    }
}
