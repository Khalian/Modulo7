package com.modulo7.pureresearch.metadataestimation;

import com.modulo7.pureresearch.lastfm.SongBagLyricsAndMetadata;

import java.io.IOException;
import java.util.*;

/**
 * Created by asanyal on 12/11/15.
 *
 * A more sophisticated tag estimation strategy which takes into account the weights of the tags
 * along with the similarity order
 */
public class WeightedTagEstimation extends TagEstimation {

    /**
     * Default deserialization constructor for lyrics map to tags
     *
     * @param lyricsTagMapSerialized
     */
    public WeightedTagEstimation(final String lyricsTagMapSerialized) throws IOException, ClassNotFoundException {
        super(lyricsTagMapSerialized);
    }

    @Override
    public Map<SongBagLyricsAndMetadata, Map<String, Integer>> getEstimatedTags() {

        final int trainDataSize = trainSet.size();

        // Init an estimated tags return object
        final Map<SongBagLyricsAndMetadata, Map<String, Integer>> estimatedTags = new HashMap<>();

        for (final SongBagLyricsAndMetadata dataElem : testSet) {
            final Map<String, Integer> tags = dataElem.getTags();
            final Map<Double, Map<String, Integer>> weightedTagSet = new HashMap<>();

            for (final SongBagLyricsAndMetadata trainElem : trainSet) {
                final Map<String, Integer> trainTags = trainElem.getTags();
                final double simVal = simVal(tags, trainTags, SIM_CHOICE);
                weightedTagSet.put(simVal, trainTags);
            }

            final List<Double> sortedSims = new ArrayList<>(weightedTagSet.keySet());
            int counter = 0;

            for (final Double val : sortedSims) {
                final Map<String, Integer> weightedSims = weightedTagSet.get(val);
                final double alpha = (double) (trainDataSize - counter) / trainDataSize;

                for (Map.Entry<String, Integer> weightedSim : weightedSims.entrySet()) {
                    Double newSim = weightedSim.getValue() * alpha;
                    weightedSim.setValue(newSim.intValue());
                }

                counter++;
            }
        }

        return estimatedTags;
    }
}
