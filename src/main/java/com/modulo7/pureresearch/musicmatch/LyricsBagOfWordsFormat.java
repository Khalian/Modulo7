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

    // The ground truth dataset
    private BagOfWordsDataSet groundTruthDataSet;

    /**
     * Basic constructor for lyrics
     *
     * @param groundTruthFile
     * @throws IOException
     */
    public LyricsBagOfWordsFormat(final String groundTruthFile) throws IOException {
        groundTruthDataSet = new BagOfWordsDataSet(groundTruthFile);
    }

    /**
     * Compute the lyrics accuracy of a song's lyrics with respect to the
     * ground truth data
     *
     * @param first
     * @return
     */
    public double lyricsAccuracy(final Lyrics first) {
        final String actualLyrics = first.getLyricsOfSongNoDelimiters().trim();
        final String[] lyricsComponents = actualLyrics.split(" ");
        Map<String, Integer> values = new HashMap<>();

        for (final String lyricsComponent : lyricsComponents) {
            Modulo7Utils.addToCount(lyricsComponent, values);
        }

        int denom = 0;
        double num = 0;

        for (Map.Entry<String, Integer> entry : values.entrySet()) {
            final int observedCount = entry.getValue();
            final String lyricsComponent = entry.getKey();
            final double expectedCount = groundTruthDataSet.getExpectedWordCount(lyricsComponent);

            denom += observedCount;
            num += Math.max(observedCount - Math.abs(expectedCount - observedCount), 0);
        }

        return num / denom;
    }

    /**
     * Gets the lyrics similarity in the original structural format of the lyrics
     *
     * @param first
     * @param second
     * @return
     */
    public static Double lyricsSimilarity(final Lyrics first, final Lyrics second) {

        LevensteinDistance distance = new LevensteinDistance();

        final String lyricalContentFirst = first.getLyricsOfSong();
        final String lyricalContentSecond = second.getLyricsOfSong();
        return (double) distance.getDistance(lyricalContentFirst, lyricalContentSecond);
    }
}
