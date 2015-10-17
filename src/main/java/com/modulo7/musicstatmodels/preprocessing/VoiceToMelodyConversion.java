package com.modulo7.musicstatmodels.preprocessing;

import com.modulo7.common.exceptions.Modulo7BadNoteException;
import com.modulo7.common.exceptions.Modulo7InvalidVoiceInstantSizeException;
import com.modulo7.musicstatmodels.representation.buildingblocks.ChordQuality;
import com.modulo7.musicstatmodels.representation.buildingblocks.Note;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;
import com.modulo7.musicstatmodels.representation.monophonic.VoiceInstant;
import org.apache.commons.lang3.SerializationUtils;

import java.util.List;

/**
 * Created by asanyal on 9/21/15.
 *
 * Preprocessing step to convert a voice to a pure melodic transcription
 * This step is necessary in pure melodic similarity measures and statistic
 * computations
 */
public class VoiceToMelodyConversion {

    /**
     * Method that converts a generic voice to a pure melody by replacing chords with their root
     * notes in a voice
     *
     * @param inputVoice
     * @return
     * @throws Modulo7InvalidVoiceInstantSizeException
     */
    public static Voice melodyConversion(final Voice inputVoice) throws Modulo7InvalidVoiceInstantSizeException, Modulo7BadNoteException {

        Voice copyOfVoice = SerializationUtils.clone(inputVoice);
        List<VoiceInstant> voiceSequence = copyOfVoice.getVoiceSequence();

        for (int i = 0; i < voiceSequence.size(); i++) {
            VoiceInstant voiceInstant = voiceSequence.get(i);

            if (voiceInstant.isChord()) {
                Note rootNote = ChordQuality.getRootNoteFromChord(voiceInstant.getAllNotesofInstant());
                VoiceInstant newInstant = new VoiceInstant(rootNote);

                voiceSequence.set(i, newInstant);
            }
        }

        return copyOfVoice;
    }
}
