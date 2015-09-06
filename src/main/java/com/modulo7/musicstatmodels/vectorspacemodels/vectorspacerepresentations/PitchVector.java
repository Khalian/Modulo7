package com.modulo7.musicstatmodels.vectorspacemodels.vectorspacerepresentations;

import com.modulo7.musicstatmodels.representation.Song;
import com.modulo7.musicstatmodels.vectorspacemodels.datastructures.VoicePitchList;

import java.util.Map;

/**
 * Created by asanyal on 9/4/15.
 *
 * The pitch vector is a vector space representation with the raw pitches
 * as a sequence of strings / characters in sequence
 *
 * This pitch vector is a generalization of the pitch vector in Similie which
 * is per melody, pitch vector here is with respect to entire song
 */
public class PitchVector implements AbstractVector<Map<Integer, VoicePitchList>> {

    @Override
    public int getVectorLength() {
        return 0;
    }

    @Override
    public void computeVectorRepresentation(final Song song) {

    }

    @Override
    public Map<Integer, VoicePitchList> getInternalRepresentation() {
        return null;
    }
}
