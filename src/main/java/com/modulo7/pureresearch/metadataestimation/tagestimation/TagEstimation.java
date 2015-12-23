package com.modulo7.pureresearch.metadataestimation.tagestimation;

import com.modulo7.pureresearch.lastfm.SongBagLyricsAndMetadata;
import com.modulo7.pureresearch.metadataestimation.bagofwordslyricssim.*;
import com.modulo7.pureresearch.musicmatch.BagOfWordsDataElement;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by asanyal on 12/11/15.
 *
 * The tag estimation class for a given data set
 */
public abstract class TagEstimation {

    // A set of song bagged lyrics and meta data mapped
    protected Set<SongBagLyricsAndMetadata> lyricsMappedTagEntries;

    // Train set split of the Tag Estimation algorithm
    protected Set<SongBagLyricsAndMetadata> trainSet;

    // The test set split of the tag estimation algorithm
    protected Set<SongBagLyricsAndMetadata> testSet;

    // Choice of bag of words similarity
    protected static final BOWSimilarityChoices SIM_CHOICE = BOWSimilarityChoices.COSINE_SIMILARITY;

    // Thresh hold value for assessing similarities
    protected static final double THRESHHOLD = 0.6;

    /**
     * Default deserialization constructor for lyrics map to tags
     * @param lyricsTagMapSerialized
     */
    public TagEstimation(final String lyricsTagMapSerialized) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(lyricsTagMapSerialized);
        ObjectInputStream ois = new ObjectInputStream(fis);
        lyricsMappedTagEntries = (HashSet<SongBagLyricsAndMetadata>) ois.readObject();
        ois.close();
        fis.close();

        final int sizeOfDataSet = lyricsMappedTagEntries.size();
        final int fraction = sizeOfDataSet / 10;
        int currCounter = 0;

        for (final SongBagLyricsAndMetadata lyricsAndMetadata : lyricsMappedTagEntries) {
            if (currCounter < fraction) {
                testSet.add(lyricsAndMetadata);
            } else {
                trainSet.add(lyricsAndMetadata);
            }
            currCounter++;
        }
    }

    /**
     * Naive tag estimator
     * @param testSet
     * @param trainSet
     */
    public TagEstimation(final Set<SongBagLyricsAndMetadata> testSet, final Set<SongBagLyricsAndMetadata> trainSet) {
        this.testSet = testSet;
        this.trainSet = trainSet;
    }

    /**
     * Gets the estimated tags for a given
     * @return
     */
    public abstract Map<SongBagLyricsAndMetadata, Map<String, Integer>> getEstimatedTags();

    /**
     * A comparison between a couple of bag of words data elements
     * @param firstLyrics
     * @param secondLyrics
     * @return
     */
    protected double simVal(final BagOfWordsDataElement firstLyrics, final BagOfWordsDataElement secondLyrics, final BOWSimilarityChoices similarityChoice) {

        final Map<String, Integer> first = firstLyrics.getWordToCountsMap();
        final Map<String, Integer> second = secondLyrics.getWordToCountsMap();

        final BOWSimilarity similarity;

        if (similarityChoice.equals(BOWSimilarityChoices.COSINE_SIMILARITY)) {
            similarity = new CosineSimilarity(first, second);
        }  else if (similarityChoice.equals(BOWSimilarityChoices.DICE_SIMILARITY)) {
            similarity = new DiceSimilarity(first, second);
        } else if (similarityChoice.equals(BOWSimilarityChoices.JACARD_SIMILARITY)) {
            similarity = new JacardSimilarity(first, second);
        } else if (similarityChoice.equals(BOWSimilarityChoices.OVERLAP_SIMILARITY)) {
            similarity = new OverLapSimilarity(first, second);
        } else {
            // Defaults to cosine similarity
            similarity = new CosineSimilarity(first, second);
        }

        return similarity.getSimVal();
    }
}
