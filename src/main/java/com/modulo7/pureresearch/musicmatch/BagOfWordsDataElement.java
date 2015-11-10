package com.modulo7.pureresearch.musicmatch;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by asanyal on 11/3/15.
 *
 * Encoding for the music match dataset
 */
public class BagOfWordsDataElement {

    // The track ID
    private String trackID;

    // Music match track ID
    private String mxmTrackID;

    // Top words and their counts
    private Map<Integer, Integer> topWordsCount = new HashMap<>();

    /**
     * Construct music match data element from the test or train file
     * @param dataElem
     */
    public BagOfWordsDataElement(final String dataElem) {
        String[] elements = dataElem.split(",");
        trackID = elements[0];
        mxmTrackID = elements[1];
        for (int i = 2; i < elements.length; i++) {
            String count = elements[i];
            String[] elementsOfCount = count.split(":");
            topWordsCount.put(Integer.parseInt(elementsOfCount[0]), Integer.parseInt(elementsOfCount[1]));
        }
    }

    /**
     * Getter for track ID
     * @return
     */
    public String getTrackID() {
        return trackID;
    }

    /**
     * Getter for the top word counts for the music match dataset
     * @return
     */
    public Map<Integer, Integer> getTopWordsCount() {
        return topWordsCount;
    }

    /**
     * Getter for the music match track ID
     * @return
     */
    public String getMxmTrackID() {
        return mxmTrackID;
    }
}
