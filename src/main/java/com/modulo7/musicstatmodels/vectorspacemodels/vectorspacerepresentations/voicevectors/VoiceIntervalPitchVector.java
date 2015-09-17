package com.modulo7.musicstatmodels.vectorspacemodels.vectorspacerepresentations.voicevectors;

import com.modulo7.common.exceptions.Modulo7BadIntervalException;
import com.modulo7.common.exceptions.Modulo7WrongNoteType;
import com.modulo7.common.interfaces.AbstractVoiceVector;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;
import com.modulo7.musicstatmodels.vectorspacemodels.datastructures.VoiceIntervalPitchList;
import org.apache.log4j.Logger;

/**
 * Created by asanyal on 9/8/15.
 *
 * Interval pitch vector representation of a given voice
 */
public class VoiceIntervalPitchVector implements AbstractVoiceVector<VoiceIntervalPitchList> {

    // Pitch List element in the voice interval pitch vector
    private VoiceIntervalPitchList pitchList = new VoiceIntervalPitchList();

    // Logger for voice interval pitch vector representation
    private static final Logger logger = Logger.getLogger(VoiceIntervalPitchVector.class);

    @Override
    public int getVectorLength() {
        return pitchList.length();
    }

    @Override
    public void computeVectorRepresentation(final Voice voice) {
        try {
            pitchList.computeVoicePitchSet(voice);
        } catch (Modulo7WrongNoteType | Modulo7BadIntervalException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public VoiceIntervalPitchList getInternalRepresentation() {
        return pitchList;
    }
}
