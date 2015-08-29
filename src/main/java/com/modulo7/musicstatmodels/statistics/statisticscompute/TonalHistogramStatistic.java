package com.modulo7.musicstatmodels.statistics.statisticscompute;

import com.modulo7.common.exceptions.Modulo7BadIntervalException;
import com.modulo7.common.exceptions.Modulo7WrongNoteType;
import com.modulo7.musicstatmodels.musictheorymodels.Interval;
import com.modulo7.musicstatmodels.musictheorymodels.IntervalEnum;
import com.modulo7.musicstatmodels.representation.Note;
import com.modulo7.musicstatmodels.representation.Song;
import com.modulo7.musicstatmodels.representation.Voice;
import com.modulo7.musicstatmodels.representation.VoiceInstant;
import com.modulo7.musicstatmodels.statistics.results.TonalHistogramResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by asanyal on 8/21/15.
 *
 * Given a song, the tonal histogram class acquires the intervals
 */
public class TonalHistogramStatistic implements AbstractStatistic<TonalHistogramResult> {

    // A map of all the intervals to their counts in the song
    private Map<IntervalEnum, Integer> intervalHistogram = new HashMap<>();

    /**
     * Basic constructor for the tonal histogram
     *
     * Put all histogram counts to zero
     */
    public TonalHistogramStatistic() {
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
     * Acquires the tonal histogram statistic for the song
     * @param song
     * @return
     */
    @Override
    public TonalHistogramResult getStatistic(final Song song) {
        for (Voice voice : song.getVoices()) {
            List<VoiceInstant> voiceInstants = voice.getVoiceSequence();

            /**
             * Acquire each of the voice instants and if
             */
            for (int i = 0; i < voiceInstants.size() - 1; i++) {
                VoiceInstant instant = voiceInstants.get(i);
                VoiceInstant nextInstant = voiceInstants.get(i + 1);

                // Intervals are only truly defined if both voice Instants are melodic pieces
                if (!instant.getIsChord() && !nextInstant.getIsChord()) {
                    try {
                        Note firstNote = instant.getNote();
                        Note secondNote = instant.getNote();

                        // Acquire the interval between two melodic notes
                        IntervalEnum interval = Interval.getInterval(firstNote, secondNote).getInterval();
                        addIntervalToHistogram(interval);
                    } catch (Modulo7WrongNoteType | Modulo7BadIntervalException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return new TonalHistogramResult(intervalHistogram);
    }

    /**
     * Helper method to add interval to histogram
     *
     * @param interval
     */
    private synchronized void addIntervalToHistogram(final IntervalEnum interval) {
        Integer count = intervalHistogram.get(interval);

        if (count == null) {
            count = 0;
        }

        intervalHistogram.put(interval, count + 1);
    }
}
