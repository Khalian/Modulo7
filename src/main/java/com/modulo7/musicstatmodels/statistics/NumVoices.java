package com.modulo7.musicstatmodels.statistics;

import com.modulo7.common.interfaces.AbstractStatistic;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;

/**
 * Created by asanyal on 9/26/15.
 *
 * Simple criteria which returns the number of voices in the song
 */
public class NumVoices implements AbstractStatistic<Double> {
    @Override
    public Double getStatistic(final Song song) {
        return (double) song.getNumVoices();
    }
}
