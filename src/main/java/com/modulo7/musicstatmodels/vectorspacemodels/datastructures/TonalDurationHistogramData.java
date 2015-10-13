package com.modulo7.musicstatmodels.vectorspacemodels.datastructures;

import com.modulo7.musicstatmodels.musictheorymodels.IntervalQuantity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by asanyal on 9/13/15.
 *
 * This data structure is very similar to the tonal histogram data
 * but the values are the cumulative tonal durations
 */
public class TonalDurationHistogramData {

    // Internal intervalHistogram representation
    private Map<IntervalQuantity, Double> intervalHistogram = new HashMap<>();

    /**
     * Tonal Histogram scratch representation
     */
    public TonalDurationHistogramData() {
        intervalHistogram.put(IntervalQuantity.PERFECT_UNISON, 0.0);
        intervalHistogram.put(IntervalQuantity.MINOR_SECOND, 0.0);
        intervalHistogram.put(IntervalQuantity.MAJOR_SECOND, 0.0);
        intervalHistogram.put(IntervalQuantity.MINOR_THIRD, 0.0);
        intervalHistogram.put(IntervalQuantity.MAJOR_THIRD, 0.0);
        intervalHistogram.put(IntervalQuantity.PERFECT_FOURTH, 0.0);
        intervalHistogram.put(IntervalQuantity.AUGMENTED_FOURTH, 0.0);
        intervalHistogram.put(IntervalQuantity.PERFECT_FIFTH, 0.0);
        intervalHistogram.put(IntervalQuantity.MINOR_SIXTH, 0.0);
        intervalHistogram.put(IntervalQuantity.MAJOR_SIXTH, 0.0);
        intervalHistogram.put(IntervalQuantity.MINOR_SEVENTH, 0.0);
        intervalHistogram.put(IntervalQuantity.MAJOR_SEVENTH, 0.0);
        intervalHistogram.put(IntervalQuantity.PERFECT_OCTAVE, 0.0);
    }

    /**
     * Gets an array representation of the vectorized data
     * @return
     */
    public List<Number> getArrayRepresentation() {
        Double[] array = new Double[12];

        for (Map.Entry<IntervalQuantity, Double> histogramElem : intervalHistogram.entrySet()) {
            final Integer index = histogramElem.getKey().getQuantity();
            final Double value = histogramElem.getValue();

            // Perfect unison and perfect octave are considered the same
            array[index % 12] = value;
        }

        return Arrays.asList(array);
    }

    /**
     * Gets the cumulative duration of the tonal duration
     * histogram
     *
     * @return
     */
    public double getCumulativeDuration() {

        double duration = 0.0;

        for (Map.Entry<IntervalQuantity, Double> entry : intervalHistogram.entrySet()) {
            duration += entry.getValue();
        }

        return duration;
    }

    /**
     * Size of the interval histogram keyset
     * @return
     */
    public int getSize() {
        return intervalHistogram.size();
    }

    /**
     * Gets a durational data from histogram for a particular interval
     * @param interval
     * @return
     */
    public Double getData(final IntervalQuantity interval) {
        return intervalHistogram.get(interval);
    }

    /**
     * Sets durational data in histogram for a particular interval
     * @param interval
     * @param value
     */
    public void setData(final IntervalQuantity interval, final double value) {
        intervalHistogram.put(interval, value);
    }
}
