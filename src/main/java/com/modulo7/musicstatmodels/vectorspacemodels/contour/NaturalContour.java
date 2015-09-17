package com.modulo7.musicstatmodels.vectorspacemodels.contour;

import com.modulo7.common.exceptions.Modulo7WrongNoteType;
import com.modulo7.common.interfaces.AbstractContour;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;
import com.modulo7.musicstatmodels.representation.monophonic.VoiceInstant;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by asanyal on 9/8/15.
 *
 * Contour extremum notes are computed and returned as elements of the contour
 * consider three voice instants : n_i , n_{i-1} and n_{i+1}, natural contour elements
 * are those in which n_i is either higher or lower than both n_{i-1} and n_{i+1} simultaneously
 */
public class NaturalContour implements AbstractContour {

    /**
     * Gets the voice representation of the natural contour only exressing the
     * contour extremum notes
     * @param voice
     * @return
     */
    @Override
    public Voice getContourRepresentaionOfVoice(final Voice voice) {
        Set<VoiceInstant> contourExtemum = new HashSet<>();

        int voiceInstantIndex = 0;
        final int maxVoiceInstantIndex = voice.getNumVoiceInstantsOfVoice();

        for (final VoiceInstant voiceInstant : voice.getVoiceSequence()) {

            if (voiceInstantIndex >= 1 && voiceInstantIndex < maxVoiceInstantIndex - 1) {
                final VoiceInstant nMinusOne = voice.getVoiceInstantAtPostion(voiceInstantIndex - 1);
                final VoiceInstant nPlusOne = voice.getVoiceInstantAtPostion(voiceInstantIndex + 1);

                try {
                    final boolean isAllBelow = VoiceInstant.isLowerPitch(voiceInstant, nMinusOne) &&
                            VoiceInstant.isLowerPitch(voiceInstant, nPlusOne);

                    final boolean isAllAbove = VoiceInstant.isHigherPitch(voiceInstant, nMinusOne) &&
                            VoiceInstant.isHigherPitch(voiceInstant, nPlusOne);

                    if (isAllAbove || isAllBelow) {
                        contourExtemum.add(voiceInstant);
                    }
                } catch (Modulo7WrongNoteType e) {
                    e.printStackTrace();
                }
            }
            voiceInstantIndex++;
        }

        final Voice contourizedVoice = new Voice();

        for (final VoiceInstant voiceInstant : voice.getVoiceSequence()) {
            if (contourExtemum.contains(voiceInstant)) {
                contourizedVoice.addVoiceInstant(voiceInstant);
            }
        }

        return contourizedVoice;
    }
}
