package com.modulo7.musicstatmodels.vectorspacemodels.datastructures;

import com.modulo7.common.exceptions.Modulo7BadIntervalException;
import com.modulo7.common.exceptions.Modulo7WrongNoteType;
import com.modulo7.musicstatmodels.musictheorymodels.Interval;
import com.modulo7.musicstatmodels.musictheorymodels.IntervalEnum;
import com.modulo7.musicstatmodels.representation.Voice;
import com.modulo7.musicstatmodels.representation.VoiceInstant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asanyal on 9/8/15.
 *
 * A data structure that contains the pitch intervals
 */
public class VoiceIntervalPitchList {

    // Pitches on the voices in sequence
    private List<IntervalEnum> pitcheIntervalsInSequenceOfVoice = new ArrayList<>();

    /**
     * Computes the voice pitches in sequence
     * @param voice
     */
    public void computeVoicePitchSet(final Voice voice) throws Modulo7WrongNoteType, Modulo7BadIntervalException {

        final List<VoiceInstant> voiceInstants = voice.getVoiceSequence();

        for (int i = 0; i < voiceInstants.size() - 1; i++) {
            final VoiceInstant currInstant = voice.getVoiceInstantAtPostion(i);
            final VoiceInstant nextInstant = voice.getVoiceInstantAtPostion(i + 1);

            final IntervalEnum interval = Interval.getInterval(currInstant, nextInstant).getIntervalEnum();
            pitcheIntervalsInSequenceOfVoice.add(interval);
        }
    }

    /**
     * Getter for pitches in sequence of voice
     * @return
     */
    private List<IntervalEnum> getPitchIntervalsInSequenceOfVoice() {
        return pitcheIntervalsInSequenceOfVoice;
    }

    /**
     * Length of the voice pitch sequence
     * @return
     */
    public int length() {
        return pitcheIntervalsInSequenceOfVoice.size();
    }
}
