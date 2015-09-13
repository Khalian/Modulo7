package com.modulo7.musicstatmodels.vectorspacemodels.datastructures;

import com.modulo7.musicstatmodels.musictheorymodels.IntervalEnum;

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
    private Map<IntervalEnum, Double> intervalHistogram = new HashMap<>();

    /**
     * Tonal Histogram scratch representation
     */
    public TonalDurationHistogramData() {
        intervalHistogram.put(IntervalEnum.PERFECT_UNISON, 0.0);
        intervalHistogram.put(IntervalEnum.MINOR_SECOND, 0.0);
        intervalHistogram.put(IntervalEnum.MAJOR_SECOND, 0.0);
        intervalHistogram.put(IntervalEnum.MINOR_THIRD, 0.0);
        intervalHistogram.put(IntervalEnum.MAJOR_THIRD, 0.0);
        intervalHistogram.put(IntervalEnum.PERFECT_FOURTH, 0.0);
        intervalHistogram.put(IntervalEnum.AUGMENTED_FOURTH, 0.0);
        intervalHistogram.put(IntervalEnum.PERFECT_FIFTH, 0.0);
        intervalHistogram.put(IntervalEnum.MINOR_SIXTH, 0.0);
        intervalHistogram.put(IntervalEnum.MAJOR_SIXTH, 0.0);
        intervalHistogram.put(IntervalEnum.MINOR_SEVENTH, 0.0);
        intervalHistogram.put(IntervalEnum.MAJOR_SEVENTH, 0.0);
        intervalHistogram.put(IntervalEnum.PERFECT_OCTAVE, 0.0);
    }

    /**
     * Gets an array representation of the vectorized data
     * @return
     */
    public List<Double> getArrayRepresentation() {
        Double[] array = new Double[13];

        for (Map.Entry<IntervalEnum, Double> histogramElem : intervalHistogram.entrySet()) {
            final Integer index = histogramElem.getKey().getIntervalQuantity();
            final Double value = histogramElem.getValue();

            array[index] = value;
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

        for (Map.Entry<IntervalEnum, Double> entry : intervalHistogram.entrySet()) {
            duration += entry.getValue();
        }

        return duration;
    }


    /**
     * This method acquires duration for a particular interval
     *
     * @param intervalEnum
     * @return
     */
    public double getCumulativeDurationForInterval(final IntervalEnum intervalEnum) {
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
     * Gets a durational data from histogram for a particular interval
     * @param interval
     * @return
     */
    public Double getData(final IntervalEnum interval) {
        return intervalHistogram.get(interval);
    }

    /**
     * Sets durational data in histogram for a particular interval
     * @param interval
     * @param value
     */
    public void setData(final IntervalEnum interval, final double value) {
        intervalHistogram.put(interval, value);
    }
}
