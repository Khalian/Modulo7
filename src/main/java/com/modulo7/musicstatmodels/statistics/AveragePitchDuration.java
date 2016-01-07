package com.modulo7.musicstatmodels.statistics;

import com.modulo7.common.interfaces.AbstractStatistic;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;
import com.modulo7.musicstatmodels.representation.monophonic.VoiceInstant;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;

/**
 * Created by asanyal on 1/6/16.
 *
 * Statistic for calculating the average pitch duration
 */
public class AveragePitchDuration implements AbstractStatistic<Double> {
    @Override
    public Double getStatistic(final Song song) {

        double averagePitchDuration = 0.0;
        int numDurations = 0;

        for (final Voice voice : song.getVoices()) {
            for (final VoiceInstant instant : voice.getVoiceSequence()) {
                averagePitchDuration += instant.getDuration();
                numDurations++;
            }
        }

        return averagePitchDuration / numDurations;
    }
}
