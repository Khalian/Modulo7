package com.modulo7.musicstatmodels.vectorspacemodels.contour;

import com.modulo7.common.exceptions.Modulo7WrongNoteType;
import com.modulo7.common.interfaces.AbstractContour;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;
import com.modulo7.musicstatmodels.representation.monophonic.VoiceInstant;

/**
 * Created by asanyal on 9/18/15.
 *
 * The gross contour just takes into account upward and downward motion of notes,
 * it does not take into account the magnnitude of the motion
 *
 * Gross contour similarity can be used to understand similar and parallel motion
 * as well antiparallel motion but can distinguish between similar and parallel
 */
public class GrossContour implements AbstractContour<String> {

    @Override
    public String getContourRepresentaionOfVoice(final Voice voice) {

        String countourRep = "";

        int voiceInstantIndex = 0;
        final int maxVoiceInstantIndex = voice.getNumVoiceInstantsOfVoice();

        for (final VoiceInstant voiceInstant : voice.getVoiceSequence()) {

            if (voiceInstantIndex < maxVoiceInstantIndex - 1) {
                final VoiceInstant nPlusOne = voice.getVoiceInstantAtPostion(voiceInstantIndex + 1);

                try {
                    final boolean isBelow = VoiceInstant.isLowerPitch(nPlusOne, voiceInstant);
                    final boolean isAbove = VoiceInstant.isHigherPitch(nPlusOne, voiceInstant);

                    if (isBelow) {
                        countourRep += "D ";
                    } else if (isAbove) {
                        countourRep += "U ";
                    } else {
                        countourRep += "S ";
                    }
                } catch (Modulo7WrongNoteType e) {
                    e.printStackTrace();
                }
            }
            voiceInstantIndex++;
        }

        return  countourRep.trim();

    }
}
