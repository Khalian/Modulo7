package com.modulo7.pureresearch.musicmatch;

import com.modulo7.common.utils.Modulo7Utils;
import com.modulo7.nlp.lyrics.Lyrics;
import org.apache.lucene.search.spell.LevensteinDistance;

import java.io.IOException;
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

    // The lyrics object as original version
    private Lyrics lyrics;

    // The ground truth dataset
    private MusicMatchDataSet groundTruthDataSet;

    /**
     * Construct the bag of words representation from lyrics
     *
     * @param lyrics
     */
    public void addLyrics(final Lyrics lyrics) {

        this.lyrics = lyrics;

        final String lyricsStr = lyrics.getLyricsOfSong();
        final String[] lyricsComponents = lyricsStr.split(" ");
        for (final String lyricsComponent : lyricsComponents) {
            if (lyricsComponent.equals(Lyrics.PHRASETERM))
            Modulo7Utils.addToCount(lyricsComponent, wordCount);
        }
    }

    public LyricsBagOfWordsFormat(final String groundTruthFile) throws IOException {
        groundTruthDataSet = new MusicMatchDataSet(groundTruthFile);
    }

    /**
     * Gets the lyrics content from song, back referencing to original lyrics object
     * @return
     */
    public String getLyricalContent() {
        return lyrics.getLyricsOfSong();
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


    /**
     * Compute the lyrics accuracy element
     * @param first
     * @return
     */
    public static Double lyricsAccuracy(final LyricsBagOfWordsFormat first) {
        return null;
    }

    /**
     * Gets the lyrics similarity in the original structural format of the lyrics
     * @param first
     * @param second
     * @return
     */
    public static Double lyricsSimilarity(final LyricsBagOfWordsFormat first, final LyricsBagOfWordsFormat second) {

        LevensteinDistance distance = new LevensteinDistance();

        final String lyricalContentFirst = first.getLyricalContent();
        final String lyricalContentSecond = second.getLyricalContent();
        return (double) distance.getDistance(lyricalContentFirst, lyricalContentSecond);
    }
}
