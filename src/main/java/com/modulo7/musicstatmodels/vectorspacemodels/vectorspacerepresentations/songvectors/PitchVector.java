package com.modulo7.musicstatmodels.vectorspacemodels.vectorspacerepresentations.songvectors;

import com.modulo7.common.exceptions.Modulo7WrongNoteType;
import com.modulo7.common.interfaces.AbstractSongVector;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;
import com.modulo7.musicstatmodels.vectorspacemodels.datastructures.VoicePitchList;
import org.apache.log4j.Logger;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by asanyal on 9/4/15.
 *
 * The pitch vector is a vector space representation with the raw pitches
 * as a sequence of strings / characters in sequence
 *
 * This pitch vector is a generalization of the pitch vector in Similie which
 * is per melody, pitch vector here is with respect to entire song
 */
public class PitchVector implements AbstractSongVector<Set<VoicePitchList>> {

    // Voice pitch list
    private Set<VoicePitchList> voicePitchListSet = new HashSet<>();

    // Logger for the pitch vector class
    private static final Logger logger = Logger.getLogger(PitchVector.class);

    @Override
    public void computeVectorRepresentation(final Song song) {

        for (final Voice voice : song.getVoices()) {
            VoicePitchList list = new VoicePitchList();
            try {
                list.computeVoicePitchSet(voice);
                voicePitchListSet.add(list);
            } catch (Modulo7WrongNoteType e) {
                logger.error(e.getMessage());
            }
        }
    }

    @Override
    public Set<VoicePitchList> getInternalRepresentation() {
        return voicePitchListSet;
    }
}
