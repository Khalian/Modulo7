package com.modulo7.musicstatmodels.similarity.songsimilarity;

import com.modulo7.musicstatmodels.similarity.genericsimilarity.GMVoiceSimIgnoreLengths;
import com.modulo7.musicstatmodels.similarity.voicesimilarity.UkkonnenSimilarity;

/**
 * Created by asanyal on 10/13/15.
 *
 * Ukkonnen similarity measure
 */
public class UkkonnenSongSimilarity extends GMVoiceSimIgnoreLengths<UkkonnenSimilarity> {
    /**
     * Basic constructor for UkkonnenSongSimilarity
     */
    public UkkonnenSongSimilarity() {
        super(new UkkonnenSimilarity());
    }
}
