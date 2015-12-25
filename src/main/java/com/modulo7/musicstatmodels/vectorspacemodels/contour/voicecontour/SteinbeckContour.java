package com.modulo7.musicstatmodels.vectorspacemodels.contour.voicecontour;

import com.modulo7.common.exceptions.Modulo7WrongNoteType;
import com.modulo7.common.interfaces.AbstractContour;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;
import com.modulo7.musicstatmodels.representation.monophonic.VoiceInstant;
import org.apache.log4j.Logger;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * Created by asanyal on 9/6/15.
 *
 * The steinbeck contour as described in the similie documentation for contourization
 * procedures for re - representing a voice so that contour gradients can be created for
 * new vector space models
 */
public class SteinbeckContour implements AbstractContour {

    // Logger for steinbeck contour
    private Logger logger = Logger.getLogger(SteinbeckContour.class);

    public SteinbeckContour() {

    }

    @Override
    public LinkedHashMap<Integer, VoiceInstant> getContourRepresentaionOfVoice(final Voice voice) {

        AbstractContour naturalContour = new NaturalContour();

        LinkedHashMap<Integer, VoiceInstant> naturalExtemumNotes = naturalContour.getContourRepresentaionOfVoice(voice);

        final Set<Integer> changingNoteIndices = new HashSet<>();

        int voiceInstantIndex = 0;

        final int numVoiceInstantsOfVoice = voice.getNumVoiceInstantsOfVoice();

        for (final VoiceInstant voiceInstant : voice.getVoiceSequence()) {

            if (voiceInstantIndex >= 2 && voiceInstantIndex < numVoiceInstantsOfVoice - 2) {
                final VoiceInstant nMinusTwo = voice.getVoiceInstantAtPostion(voiceInstantIndex - 2);
                final VoiceInstant nMinusOne = voice.getVoiceInstantAtPostion(voiceInstantIndex - 1);
                final VoiceInstant nPlusOne = voice.getVoiceInstantAtPostion(voiceInstantIndex + 1);
                final VoiceInstant nPlusTwo = voice.getVoiceInstantAtPostion(voiceInstantIndex + 2);

                try {
                    final boolean isAllBelow = VoiceInstant.isLowerPitch(voiceInstant, nMinusTwo) && VoiceInstant.isLowerPitch(voiceInstant, nMinusOne) &&
                            VoiceInstant.isLowerPitch(voiceInstant, nPlusOne) && VoiceInstant.isLowerPitch(voiceInstant, nPlusTwo);

                    final boolean isAllAbove = VoiceInstant.isHigherPitch(voiceInstant, nMinusTwo) && VoiceInstant.isHigherPitch(voiceInstant, nMinusOne) &&
                            VoiceInstant.isHigherPitch(voiceInstant, nPlusOne) && VoiceInstant.isHigherPitch(voiceInstant, nPlusTwo);

                    if (isAllAbove || isAllBelow) {
                        changingNoteIndices.add(voiceInstantIndex);
                    }
                } catch (Modulo7WrongNoteType e) {
                    logger.error(e.getMessage());
                }
            }
            voiceInstantIndex++;
        }

        for (final Integer changeNoteIndex : changingNoteIndices) {
            naturalExtemumNotes.remove(changeNoteIndex);
        }

        // changingNoteIndices.forEach(naturalExtemumNotes::remove);

        return naturalExtemumNotes;
    }
}
