package com.modulo7.pureresearch.musicmatch;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by asanyal on 11/3/15.
 *
 * Encoding for the music match dataset
 */
public class BagOfWordsDataElement implements Serializable {

    // The track ID
    private String trackID;

    // Music match track ID
    private String mxmTrackID;

    // Top words and their counts
    private Map<Integer, Integer> topWordsCount = new HashMap<>();

    // Words to count map
    private Map<String, Integer> wordToCountMap = new HashMap<>();

    /**
     * Construct music match data element from the test or train file
     * @param dataElem
     * @param topWords
     */
    public BagOfWordsDataElement(final String dataElem, final List<String> topWords) {
        String[] elements = dataElem.split(",");
        trackID = elements[0];
        mxmTrackID = elements[1];
        for (int i = 2; i < elements.length; i++) {
            String count = elements[i];
            String[] elementsOfCount = count.split(":");

            final Integer index = Integer.parseInt(elementsOfCount[0]);
            final Integer countOfWord = Integer.parseInt(elementsOfCount[1]);

            topWordsCount.put(index, countOfWord);
            wordToCountMap.put(topWords.get(index - 1), countOfWord);
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
     * Gets the word to counts map
     * @return
     */
    public Map<String, Integer> getWordToCountsMap() {
        return wordToCountMap;
    }
}
