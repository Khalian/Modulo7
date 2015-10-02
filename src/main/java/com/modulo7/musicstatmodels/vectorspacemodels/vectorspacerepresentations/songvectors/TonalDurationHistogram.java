package com.modulo7.musicstatmodels.vectorspacemodels.vectorspacerepresentations.songvectors;

import com.modulo7.common.exceptions.Modulo7BadIntervalException;
import com.modulo7.common.exceptions.Modulo7WrongNoteType;
import com.modulo7.common.interfaces.AbstractSongVector;
import com.modulo7.musicstatmodels.musictheorymodels.Interval;
import com.modulo7.musicstatmodels.musictheorymodels.IntervalEnum;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;
import com.modulo7.musicstatmodels.representation.monophonic.VoiceInstant;
import com.modulo7.musicstatmodels.vectorspacemodels.datastructures.TonalDurationHistogramData;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by asanyal on 9/13/15.
 *
 * This is similar to the tonal histogram song vector but instead of number of times
 * an interval has occured, this vector keeps a tab on the total duration
 */
public class TonalDurationHistogram implements AbstractSongVector<TonalDurationHistogramData> {

    // Internal intervalDurationHistogram representation
    private TonalDurationHistogramData intervalDurationHistogram;

    // Logger for tonal duration histogram
    private static final Logger logger = Logger.getLogger(TonalDurationHistogram.class);

    /**
     * Default constructor for tonal histogram and the only one present
     */
    public TonalDurationHistogram() {
        intervalDurationHistogram = new TonalDurationHistogramData();
    }

    @Override
    public void computeVectorRepresentation(final Song song) {
        for (Voice voice : song.getVoices()) {
            List<VoiceInstant> voiceInstants = voice.getVoiceSequence();

            /**
             * Acquire each of the voice instants and if
             */
            for (int i = 0; i < voiceInstants.size() - 1; i++) {
                VoiceInstant instant = voiceInstants.get(i);
                VoiceInstant nextInstant = voiceInstants.get(i + 1);

                try {
                    // Compute intervals
                    IntervalEnum intervalEnum = Interval.getInterval(instant, nextInstant).getIntervalEnum();
                    addIntervalDurationToHistogram(intervalEnum, instant.getDuration());
                } catch (Modulo7WrongNoteType | Modulo7BadIntervalException e) {
                    logger.error(e.getMessage());
                }
            }
        }
    }

    @Override
    public TonalDurationHistogramData getInternalRepresentation() {
        return intervalDurationHistogram;
    }

    /**
     * Helper method to add interval duration to intervalDurationHistogram
     *
     * @param interval
     * @param duration
     */
    private synchronized void addIntervalDurationToHistogram(final IntervalEnum interval, final double duration) {
        Double currCumulativeDuration = intervalDurationHistogram.getData(interval);
        intervalDurationHistogram.setData(interval, currCumulativeDuration + duration);
    }
}
