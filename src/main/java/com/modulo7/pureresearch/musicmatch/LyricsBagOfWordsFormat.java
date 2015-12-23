package com.modulo7.pureresearch.musicmatch;

import java.io.IOException;

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
     * Gets the bag of words for a MSD track ID
     * @param trackID
     * @return
     */
    public BagOfWordsDataElement getBagOfWords(final String trackID) {
        return groundTruthDataSet.getBagOfWords(trackID);
    }
}
