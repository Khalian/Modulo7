package com.modulo7.pureresearch.metadataestimation.tagestimation;

import com.modulo7.common.utils.Modulo7Utils;
import com.modulo7.pureresearch.lastfm.SongBagLyricsAndMetadata;
import com.modulo7.pureresearch.musicmatch.BagOfWordsDataElement;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by asanyal on 12/11/15.
 *
 * Tags estimated based on highest frequency of tags
 */
public class MaxFrequencyTagEstimation extends TagEstimation {
    /**
     * Default deserialization constructor for lyrics map to tags
     *
     * @param lyricsTagMapSerialized
     */
    public MaxFrequencyTagEstimation(String lyricsTagMapSerialized) throws IOException, ClassNotFoundException {
        super(lyricsTagMapSerialized);
    }

    /**
     * Constructor with the test and train sets already defined
     * @param testSet
     * @param trainSet
     */
    public MaxFrequencyTagEstimation(final Set<SongBagLyricsAndMetadata> testSet, final Set<SongBagLyricsAndMetadata> trainSet) {
        super(testSet, trainSet);
    }

    @Override
    public Map<SongBagLyricsAndMetadata, Map<String, Integer>> getEstimatedTags() {

        // Init an estimated tags return object
        final Map<SongBagLyricsAndMetadata, Map<String, Integer>> estimatedTags = new HashMap<>();

        for (final SongBagLyricsAndMetadata dataElem : testSet) {
            final BagOfWordsDataElement bogTest = dataElem.getBagOfWords();

            final Map<String, Integer> tagFrequency = new HashMap<>();
            for (final SongBagLyricsAndMetadata trainElem : trainSet) {
                final Map<String, Integer> trainTags = trainElem.getTags();
                final BagOfWordsDataElement bogTrain = trainElem.getBagOfWords();
                double simVal = simVal(bogTest, bogTrain, SIM_CHOICE);
                if (simVal >= THRESHHOLD) {
                    for (Map.Entry<String, Integer> tagEntry : trainTags.entrySet()) {
                        Modulo7Utils.addToCount(tagEntry.getKey(), trainTags, 1);
                    }
                }
            }

            estimatedTags.put(dataElem, tagFrequency);
        }

        return estimatedTags;
    }
}
