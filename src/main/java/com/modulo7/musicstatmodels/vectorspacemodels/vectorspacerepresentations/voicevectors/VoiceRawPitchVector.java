package com.modulo7.musicstatmodels.vectorspacemodels.vectorspacerepresentations.voicevectors;

import com.modulo7.common.exceptions.Modulo7WrongNoteType;
import com.modulo7.common.interfaces.AbstractVoiceVector;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;
import com.modulo7.musicstatmodels.vectorspacemodels.datastructures.VoicePitchList;
import org.apache.log4j.Logger;

/**
 * Created by asanyal on 9/8/15.
 *
 * Raw pitch list for a voice
 */
public class VoiceRawPitchVector implements AbstractVoiceVector<VoicePitchList>{

    // Voice raw pitch vector logger
    private static final Logger logger = Logger.getLogger(VoiceRawPitchVector.class);

    // A pitch list representation for
    private VoicePitchList pitchList = new VoicePitchList();

    @Override
    public int getVectorLength() {
        return pitchList.length();
    }

    @Override
    public void computeVectorRepresentation(final Voice voice) {
        try {
            pitchList.computeVoicePitchSet(voice);
        } catch (Modulo7WrongNoteType e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public VoicePitchList getInternalRepresentation() {
        return null;
    }
}
