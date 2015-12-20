package com.modulo7.pureresearch.metadataestimation;

import com.modulo7.pureresearch.lastfm.SongBagLyricsAndMetadata;
import com.modulo7.pureresearch.metadataestimation.bagofwordslyricssim.BOWSimilarityChoices;
import com.modulo7.pureresearch.musicmatch.BagOfWordsDataElement;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
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
            final Map<String, Integer> tags = dataElem.getTags();

            final Set<String> unionOfTags = new HashSet<>();
            final Map<String, Integer> unionTagSet = new HashMap<>();
            for (final SongBagLyricsAndMetadata trainElem : trainSet) {
                final Map<String, Integer> trainTags = trainElem.getTags();
                if (simVal(tags, trainTags, SIM_CHOICE) == 1.0) {
                    unionOfTags.addAll(trainTags.keySet());
                }
            }

            for (final String tag : unionOfTags) {
                unionTagSet.put(tag, 1);
            }

            estimatedTags.put(dataElem, unionTagSet);
        }

        return estimatedTags;
    }
}
