package com.modulo7.musicstatmodels.representation.buildingblocks;

import com.modulo7.musicstatmodels.representation.metadata.KeySignature;
import com.modulo7.musicstatmodels.representation.monophonic.VoiceInstant;

import java.util.Set;

/**
 * Created by asanyal on 10/2/15.
 *
 * A chord progression is a basic data structure that
 * takes into account some prevalent chord sequences that
 * are present in music in general
 */
public class ChordProgression {

    private static final String NOT_A_PROGRESSION = "NOTPROGRESSION";

    private static String getChordProgressionString(final Set<VoiceInstant> candidateChordProgession, final KeySignature signature) {

        final String key = signature.getKey();

        for (final VoiceInstant voiceInstant : candidateChordProgession) {
            if (!voiceInstant.isChord()) {
                return NOT_A_PROGRESSION;
            } else {

            }
        }

        return null;
    }
}
