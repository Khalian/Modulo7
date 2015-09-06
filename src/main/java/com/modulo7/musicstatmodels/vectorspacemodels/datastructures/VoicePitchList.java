package com.modulo7.musicstatmodels.vectorspacemodels.datastructures;

import com.modulo7.common.exceptions.Modulo7WrongNoteType;
import com.modulo7.musicstatmodels.representation.Voice;
import com.modulo7.musicstatmodels.representation.VoiceInstant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asanyal on 9/4/15.
 *
 * This data structure contains pitches in sequence that occur in a voice
 * along with a tokenization scheme for different chords
 */
public class VoicePitchList {

    // Pitches on the voices in sequence
    private List<String> pitchesInSequenceOfVoice = new ArrayList<>();

    /**
     * Computes the voice pitches in sequence
     * @param voice
     */
    private void computeVoicePitchSet(final Voice voice) throws Modulo7WrongNoteType {

        // Iterate through the voice instants and acquire the necessary
        for (final VoiceInstant instant : voice.getVoiceSequence()) {
            pitchesInSequenceOfVoice.add(instant.getTokenRepresentation());
        }
    }

    /**
     * Getter for pitches in sequence of voice
     * @return
     */
    private List<String> getPitchesInSequenceOfVoice() {
        return pitchesInSequenceOfVoice;
    }
}
