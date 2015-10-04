package com.modulo7.musicstatmodels.vectorspacemodels.contour;

import com.modulo7.common.exceptions.Modulo7WrongNoteType;
import com.modulo7.common.interfaces.AbstractContour;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;
import com.modulo7.musicstatmodels.representation.monophonic.VoiceInstant;
import org.apache.log4j.Logger;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * Created by asanyal on 9/8/15.
 *
 * MullensiefenContour as described in SIMILE technical manual
 *
 * Removes notes that are in between notes that identical in pitch
 *
 */
public class MullensiefenContour implements AbstractContour {

    // Logger for mullensiefen contour
    private Logger logger = Logger.getLogger(MullensiefenContour.class);

    @Override
    public LinkedHashMap<Integer, VoiceInstant> getContourRepresentaionOfVoice(Voice voice) {

            AbstractContour naturalContour = new NaturalContour();
            LinkedHashMap<Integer, VoiceInstant> naturalExtemumNotes = naturalContour.getContourRepresentaionOfVoice(voice);

            Set<Integer> changingNoteIndices = new HashSet<>();

            final int maxVoiceInstantIndex = voice.getNumVoiceInstantsOfVoice();

            for (int voiceInstantIndex = 1 ; voiceInstantIndex < maxVoiceInstantIndex - 1; voiceInstantIndex++) {
                final VoiceInstant nMinusOne = voice.getVoiceInstantAtPostion(voiceInstantIndex - 1);
                final VoiceInstant nPlusOne = voice.getVoiceInstantAtPostion(voiceInstantIndex + 1);

                try {
                    if (VoiceInstant.isEqualPitch(nMinusOne, nPlusOne)) {
                        changingNoteIndices.add(voiceInstantIndex);
                    }
                } catch (Modulo7WrongNoteType e) {
                    logger.error(e.getMessage());
                }
            }

        changingNoteIndices.forEach(naturalExtemumNotes::remove);

        return naturalExtemumNotes;
    }
}
