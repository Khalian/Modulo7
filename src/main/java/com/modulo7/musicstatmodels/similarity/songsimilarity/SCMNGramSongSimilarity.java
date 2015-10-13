package com.modulo7.musicstatmodels.similarity.songsimilarity;

import com.modulo7.musicstatmodels.similarity.genericsimilarity.GMVoiceSimIgnoreLengths;
import com.modulo7.musicstatmodels.similarity.voicesimilarity.SCMNGramSimilarity;

/**
 * Created by asanyal on 10/13/15.
 *
 * Song similarity version of scn n gram similarity
 */
public class SCMNGramSongSimilarity extends GMVoiceSimIgnoreLengths<SCMNGramSimilarity> {

    /**
     * Basic constructor for SCMNGramSongSimilarity
     */
    public SCMNGramSongSimilarity() {
        super(new SCMNGramSimilarity());
    }
}
