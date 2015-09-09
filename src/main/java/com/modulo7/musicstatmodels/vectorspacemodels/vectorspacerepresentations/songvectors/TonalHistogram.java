package com.modulo7.musicstatmodels.vectorspacemodels.vectorspacerepresentations.songvectors;

import com.modulo7.common.exceptions.Modulo7BadIntervalException;
import com.modulo7.common.exceptions.Modulo7WrongNoteType;
import com.modulo7.common.interfaces.AbstractSongVector;
import com.modulo7.musicstatmodels.musictheorymodels.Interval;
import com.modulo7.musicstatmodels.musictheorymodels.IntervalEnum;
import com.modulo7.musicstatmodels.representation.Note;
import com.modulo7.musicstatmodels.representation.Song;
import com.modulo7.musicstatmodels.representation.Voice;
import com.modulo7.musicstatmodels.representation.VoiceInstant;
import com.modulo7.musicstatmodels.vectorspacemodels.datastructures.TonalHistogramData;

import java.util.List;

/**
 * Created by asanyal on 8/29/15.
 *
 * A tonal intervalHistogram data structure, containing absolute counts
 * of a tonal intervalHistogram
 *
 */
public class TonalHistogram implements AbstractSongVector<TonalHistogramData> {

    // Internal intervalHistogram representation
    private TonalHistogramData intervalHistogram;

    /**
     * Default constructor for tonal histogram and the only one present
     */
    public TonalHistogram() {
        intervalHistogram = new TonalHistogramData();
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
                    addIntervalToHistogram(intervalEnum);
                } catch (Modulo7WrongNoteType | Modulo7BadIntervalException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public TonalHistogramData getInternalRepresentation() {
        return intervalHistogram;
    }

    /**
     * Helper method to add interval to intervalHistogram
     *
     * @param interval
     */
    private synchronized void addIntervalToHistogram(final IntervalEnum interval) {
        Integer count = intervalHistogram.getData(interval);

        if (count == null) {
            count = 0;
        }

        intervalHistogram.setData(interval, count + 1);
    }
}
