package com.modulo7.pureresearch;

import com.modulo7.common.utils.Modulo7Utils;
import com.modulo7.nlp.lyrics.Lyrics;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by asanyal on 11/2/15.
 *
 * This is the bag of words format as used by music match dataset
 */
public class LyricsBagOfWordsFormat {

    // Word count in lyrics
    private Map<String, Integer> wordCount = new HashMap<>();

    /**
     * Construct the bag of words representation
     *
     * @param lyrics
     */
    public LyricsBagOfWordsFormat(final Lyrics lyrics) {
        final String lyricsStr = lyrics.getLyricsOfSong();
        final String[] lyricsComponents = lyricsStr.split(" ");
        for (final String lyricsComponent : lyricsComponents) {
            if (lyricsComponent.equals(Lyrics.PHRASETERM))
            Modulo7Utils.addToCount(lyricsComponent, wordCount);
        }
    }

    /**
     * Gets the bag of words count
     * 
     * @param word
     * @return
     */
    public Integer getBagOfWordsCount(final String word) {
        return wordCount.get(word);
    }
}
