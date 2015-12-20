package com.modulo7.pureresearch.metadataestimation;

import com.modulo7.common.utils.Modulo7Utils;
import com.modulo7.pureresearch.lastfm.SongBagLyricsAndMetadata;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

    @Override
    public Map<SongBagLyricsAndMetadata, Map<String, Integer>> getEstimatedTags() {

        // Init an estimated tags return object
        final Map<SongBagLyricsAndMetadata, Map<String, Integer>> estimatedTags = new HashMap<>();

        for (final SongBagLyricsAndMetadata dataElem : testSet) {
            final Map<String, Integer> tags = dataElem.getTags();

            final Map<String, Integer> tagFrequency = new HashMap<>();
            for (final SongBagLyricsAndMetadata trainElem : trainSet) {
                final Map<String, Integer> trainTags = trainElem.getTags();
                if (simVal(tags, trainTags, SIM_CHOICE) == 1.0) {
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
