package com.modulo7.musicstatmodels.vectorspacemodels.vectorspacerepresentations.songvectors;

import com.modulo7.common.interfaces.AbstractSongVector;
import com.modulo7.musicstatmodels.representation.buildingblocks.ChordQuality;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;
import com.modulo7.musicstatmodels.representation.monophonic.VoiceInstant;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;
import com.modulo7.musicstatmodels.vectorspacemodels.datastructures.PitchDurationHistogramData;

import java.util.List;

/**
 * Created by asanyal on 10/2/15.
 *
 * Vector representation of the pitch duration histogram
 */
public class PitchDurationHistogram implements AbstractSongVector<PitchDurationHistogramData> {

    // Internal pitchDurationHistogram representation
    private PitchDurationHistogramData pitchDurationHistogram;

    /**
     * Default constructor for tonal histogram and the only one present
     */
    public PitchDurationHistogram() {
        pitchDurationHistogram = new PitchDurationHistogramData();
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


                String noteValue = ChordQuality.getRootNoteFromChord(instant.getAllNotesofInstant()).getNoteValue();
                addPitchDurationToHistogram(noteValue, instant.getDuration());
            }
        }
    }

    @Override
    public PitchDurationHistogramData getInternalRepresentation() {
        return pitchDurationHistogram;
    }

    /**
     * Helper method to add interval duration to pitchDurationHistogram
     *
     * @param interval
     * @param duration
     */
    private synchronized void addPitchDurationToHistogram(final String interval, final double duration) {
        Double currCumulativeDuration = pitchDurationHistogram.getData(interval);
        pitchDurationHistogram.setData(interval, currCumulativeDuration + duration);
    }
}
