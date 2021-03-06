package com.modulo7.pureresearch.musicmatch;

import com.modulo7.common.utils.Modulo7Utils;

import java.io.*;
import java.util.*;

/**
 * Created by asanyal on 11/3/15.
 *
 * The entire music match dataset
 */
public class BagOfWordsDataSet {

    // List of top words
    private List<String> topWords = new ArrayList<>();

    // Ground truth, all the music match data set elements, hashed against the
    private Map<String, BagOfWordsDataElement> groundTruth = new HashMap<>();

    // Total word count seen till now in the music match data set
    private Map<String, Integer> totalWordCount = new HashMap<>();

    // The estimated word count for a given word
    private Map<String, Double> estimatedWordCount = new HashMap<>();

    /**
     * Reading the ground truth file
     *
     * @param groundTruthFile
     * @throws IOException
     */
    public BagOfWordsDataSet(final String groundTruthFile) throws IOException {
        File file = new File(groundTruthFile);
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        while ((line = br.readLine()) != null) {

            // # is a comment in the music match file format
            if (!line.startsWith("#")) {
                if (line.startsWith("%")) {
                    line = line.replaceAll("%", "");
                    final String[] words = line.split(",");
                    Collections.addAll(topWords, words);
                } else {
                    BagOfWordsDataElement element = new BagOfWordsDataElement(line, topWords);
                    groundTruth.put(element.getTrackID(), element);
                }
            }
        }

        estimateTotalWordCount();
        estimateExpectedWordCount();
    }

    /**
     * Computes the expected word counts
     */
    private void estimateExpectedWordCount() {

        final int numUniqueWords = topWords.size();

        for (Map.Entry<String, Integer> totalCountEntry : totalWordCount.entrySet()) {
            final String word = totalCountEntry.getKey();
            final Double expectedCount = (double) totalCountEntry.getValue() / numUniqueWords;
            estimatedWordCount.put(word, expectedCount);
        }
    }

    /**
     * Build up the total word count for the ground truth database
     */
    private void estimateTotalWordCount() {
        for (final BagOfWordsDataElement dataSet : groundTruth.values()) {
            Map<Integer, Integer> entryWordCount = dataSet.getTopWordsCount();

            for (Map.Entry<Integer, Integer> entry : entryWordCount.entrySet()) {
                final Integer wordIndex = entry.getKey();
                final String word = topWords.get(wordIndex - 1);
                final Integer wordCountPerWord = entry.getValue();
                Modulo7Utils.addToCount(word, totalWordCount, wordCountPerWord);
            }
        }
    }

    /**
     * Gets the estimated word count from the ground truth data
     *
     * @param word
     * @return
     */
    public double getExpectedWordCount(final String word) {

        final Double val = estimatedWordCount.get(word);
        if (val != null) {
            return val;
        } else {
            return 0;
        }
    }

    /**
     * Gets the bag of words ground truth
     * @param trackID
     * @return
     */
    public BagOfWordsDataElement getBagOfWords(final String trackID) {
        return groundTruth.get(trackID);
    }
}
