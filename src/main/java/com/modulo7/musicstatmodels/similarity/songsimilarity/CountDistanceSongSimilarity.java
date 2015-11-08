package com.modulo7.musicstatmodels.similarity.songsimilarity;

import com.modulo7.musicstatmodels.similarity.genericsimilarity.GMVoiceSimIgnoreLengths;
import com.modulo7.musicstatmodels.similarity.voicesimilarity.CountDistanceSimilarity;

/**
 * Created by asanyal on 11/7/15.
 *
 * The count distance similarity measure extended for songs
 */
public class CountDistanceSongSimilarity extends GMVoiceSimIgnoreLengths<CountDistanceSimilarity> {

    /**
     * Basic constructor for generic maximal similarity
     */
    public CountDistanceSongSimilarity() {
        super(new CountDistanceSimilarity());
    }
}
