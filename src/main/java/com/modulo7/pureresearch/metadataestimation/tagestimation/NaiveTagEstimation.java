package com.modulo7.pureresearch.metadataestimation.tagestimation;

import com.modulo7.pureresearch.lastfm.SongBagLyricsAndMetadata;
import com.modulo7.pureresearch.musicmatch.BagOfWordsDataElement;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by asanyal on 12/11/15.
 *
 * Implementation of the naive tag estimation algorithm defined in Modulo7
 */
public class NaiveTagEstimation extends TagEstimation {

    /**
     * Default deserialization constructor for lyrics map to tags
     *
     * @param lyricsTagMapSerialized
     */
    public NaiveTagEstimation(final String lyricsTagMapSerialized) throws IOException, ClassNotFoundException {
        super(lyricsTagMapSerialized);
    }


    /**
     * Constructor with the test and train sets already defined
     * @param testSet
     * @param trainSet
     */
    public NaiveTagEstimation(final Set<SongBagLyricsAndMetadata> testSet, final Set<SongBagLyricsAndMetadata> trainSet) {
        super(testSet, trainSet);
    }

    @Override
    public Map<SongBagLyricsAndMetadata, Map<String, Integer>> getEstimatedTags() {

        // Init an estimated tags return object
        final Map<SongBagLyricsAndMetadata, Map<String, Integer>> estimatedTags = new HashMap<>();

        for (final SongBagLyricsAndMetadata dataElem : testSet) {
            final BagOfWordsDataElement testBOG = dataElem.getBagOfWords();

            final Map<String, Integer> unionOfTags = new HashMap<>();
            final Map<String, Integer> unionTagSet = new HashMap<>();

            // A mapping from count to
            final Map<Integer, String> reverseUnion = new HashMap<>();


            for (final SongBagLyricsAndMetadata trainElem : trainSet) {
                final BagOfWordsDataElement trainBOG = trainElem.getBagOfWords();
                double simVal = simVal(testBOG, trainBOG, SIM_CHOICE);
                if (simVal > THRESHHOLD) {
                    final Map<String, Integer> trainTags = trainElem.getTags();
                    final Map<Integer, String> currReverseUnion = new HashMap<>();
                    for (Map.Entry<String, Integer> train : trainTags.entrySet()) {
                        currReverseUnion.put(train.getValue(), train.getKey());
                    }
                    unionOfTags.putAll(unionTagSet);
                    reverseUnion.putAll(currReverseUnion);
                }
            }

            estimatedTags.put(dataElem, unionOfTags);
        }

        return estimatedTags;
    }
}
