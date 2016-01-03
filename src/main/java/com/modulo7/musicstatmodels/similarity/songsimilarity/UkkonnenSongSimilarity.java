package com.modulo7.musicstatmodels.similarity.songsimilarity;

import com.modulo7.musicstatmodels.similarity.genericsimilarity.GeneralMaximalVoiceSimilarity;
import com.modulo7.musicstatmodels.similarity.voicesimilarity.UkkonnenSimilarity;

/**
 * Created by asanyal on 10/13/15.
 *
 * Ukkonnen similarity measure
 */
public class UkkonnenSongSimilarity extends GeneralMaximalVoiceSimilarity<UkkonnenSimilarity> {
    /**
     * Basic constructor for UkkonnenSongSimilarity
     */
    public UkkonnenSongSimilarity() {
        super(new UkkonnenSimilarity());
    }
}
