package com.modulo7.musicstatmodels.vectorspacemodels.contour;

import com.modulo7.common.exceptions.Modulo7WrongNoteType;
import com.modulo7.common.interfaces.AbstractContour;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;
import com.modulo7.musicstatmodels.representation.monophonic.VoiceInstant;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by asanyal on 9/6/15.
 *
 * The steinbeck contour as described in the similie documentation for contourization
 * procedures for re - representing a voice so that contour gradients can be created for
 * new vector space models
 */
public class SteinbeckContour implements AbstractContour {

    @Override
    public Voice getContourRepresentaionOfVoice(final Voice voice) {

        AbstractContour naturalContour = new NaturalContour();
        Voice extemumNotes = naturalContour.getContourRepresentaionOfVoice(voice);

        Set<VoiceInstant> changingNoteIndices = new HashSet<>();

        int voiceInstantIndex = 0;
        final int maxVoiceInstantIndex = extemumNotes.getNumVoiceInstantsOfVoice();

        for (final VoiceInstant voiceInstant : extemumNotes.getVoiceSequence()) {

            if (voiceInstantIndex >= 2 && voiceInstantIndex < maxVoiceInstantIndex - 2) {
                final VoiceInstant nMinusTwo = extemumNotes.getVoiceInstantAtPostion(voiceInstantIndex - 2);
                final VoiceInstant nMinusOne = extemumNotes.getVoiceInstantAtPostion(voiceInstantIndex - 1);
                final VoiceInstant nPlusOne = extemumNotes.getVoiceInstantAtPostion(voiceInstantIndex + 1);
                final VoiceInstant nPlusTwo = extemumNotes.getVoiceInstantAtPostion(voiceInstantIndex + 2);

                try {
                    final boolean isAllBelow = VoiceInstant.isLowerPitch(voiceInstant, nMinusTwo) && VoiceInstant.isLowerPitch(voiceInstant, nMinusOne) &&
                            VoiceInstant.isLowerPitch(voiceInstant, nPlusOne) && VoiceInstant.isLowerPitch(voiceInstant, nPlusTwo);

                    final boolean isAllAbove = VoiceInstant.isHigherPitch(voiceInstant, nMinusTwo) && VoiceInstant.isHigherPitch(voiceInstant, nMinusOne) &&
                            VoiceInstant.isHigherPitch(voiceInstant, nPlusOne) && VoiceInstant.isHigherPitch(voiceInstant, nPlusTwo);

                    if (isAllAbove || isAllBelow) {
                        changingNoteIndices.add(voiceInstant);
                    }
                } catch (Modulo7WrongNoteType e) {
                    e.printStackTrace();
                }
            }
            voiceInstantIndex++;
        }

        Voice contourizedVoice = new Voice();

        for (final VoiceInstant voiceInstant : extemumNotes.getVoiceSequence()) {
            if (!changingNoteIndices.contains(voiceInstant)) {
                contourizedVoice.addVoiceInstant(voiceInstant);
            }
        }

        return contourizedVoice;
    }
}
