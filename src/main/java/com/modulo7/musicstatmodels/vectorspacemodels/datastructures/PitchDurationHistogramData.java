package com.modulo7.musicstatmodels.vectorspacemodels.datastructures;

import com.modulo7.common.utils.Modulo7Globals;
import com.modulo7.musicstatmodels.musictheorymodels.IntervalEnum;

import java.util.*;

/**
 * Created by asanyal on 10/2/15.
 *
 * Similar to tonal duration histogram, but for individual pitches
 */
public class PitchDurationHistogramData {

    // Internal intervalHistogram representation
    private Map<String, Double> pitchHistogram = new HashMap<>();

    /**
     * Tonal Histogram scratch representation
     */
    public PitchDurationHistogramData() {
        for (final String pitch : Modulo7Globals.NOTE_NAMES_ONLY_SHARPS) {
            pitchHistogram.put(pitch, 0.0);
        }
    }

    /**
     * Gets an array representation of the vectorized data
     * @return
     */
    public List<Double> getArrayRepresentation() {
        Double[] array = new Double[12];

        for (Map.Entry<String, Double> histogramElem : pitchHistogram.entrySet()) {

            final String note = histogramElem.getKey();
            final int position = Modulo7Globals.getIndexOfNote(note);
            array[position] = histogramElem.getValue();
        }

        List<Double> values = Arrays.asList(array);

        Collections.rotate(values, -3);

        return values;
    }

    /**
     * Gets a durational data from histogram for a particular note
     * @param interval
     * @return
     */
    public Double getData(final String interval) {
        return pitchHistogram.get(interval);
    }

    /**
     * Sets durational data in histogram for a particular note
     * @param noteVal
     * @param value
     */
    public void setData(final String noteVal, final double value) {
        pitchHistogram.put(noteVal, value);
    }
}
