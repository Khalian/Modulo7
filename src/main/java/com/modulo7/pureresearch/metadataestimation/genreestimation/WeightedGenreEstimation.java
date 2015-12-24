package com.modulo7.pureresearch.metadataestimation.genreestimation;
import com.modulo7.pureresearch.lastfm.SongBagLyricsAndMetadata;
import com.modulo7.pureresearch.lastfm.SongBagLyricsGenreMap;
import com.modulo7.pureresearch.metadataestimation.tagestimation.TagEstimation;
import com.modulo7.pureresearch.musicmatch.BagOfWordsDataElement;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by asanyal on 12/23/15.
 */
public class WeightedGenreEstimation extends GenreEstimation {

    /**
     * Tag estimator default constructor
     *
     * @param testSet
     * @param trainSet
     */
    public WeightedGenreEstimation(Set<SongBagLyricsGenreMap> testSet, Set<SongBagLyricsGenreMap> trainSet) {
        super(testSet, trainSet);
    }

    @Override
    public Map<SongBagLyricsGenreMap, Set<String>> getEstimatedGenres() {
        // Init an estimated tags return object
        final Map<SongBagLyricsGenreMap, Set<String>> estimatedGenres = new HashMap<>();

        for (final SongBagLyricsGenreMap dataElem : testSet) {
            final BagOfWordsDataElement bogTest = dataElem.getBagOfWords();
            final Map<Double, SongBagLyricsGenreMap> weightedGenreLabels = new HashMap<>();

            for (final SongBagLyricsGenreMap trainElem : trainSet) {
                final BagOfWordsDataElement bogTrain = trainElem.getBagOfWords();
                final double simVal = TagEstimation.simVal(bogTest, bogTrain, SIM_CHOICE);
                weightedGenreLabels.put(simVal, trainElem);
            }


        }

        // TODO : Fix this later
        return null;
    }
}
