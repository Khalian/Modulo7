package com.modulo7.pureresearch.metadataestimation.genreestimation;

import com.modulo7.pureresearch.lastfm.SongBagLyricsGenreMap;
import com.modulo7.pureresearch.metadataestimation.tagestimation.TagEstimation;
import com.modulo7.pureresearch.musicmatch.BagOfWordsDataElement;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by asanyal on 12/22/15.
 */
public class NaiveGenreEstimation extends GenreEstimation {

    /**
     * Tag estimator default constructor
     *
     * @param testSet
     * @param trainSet
     */
    public NaiveGenreEstimation(Set<SongBagLyricsGenreMap> testSet, Set<SongBagLyricsGenreMap> trainSet) {
        super(testSet, trainSet);
    }

    @Override
    public Map<SongBagLyricsGenreMap, Set<String>> getEstimatedGenres() {

        // Init an estimated tags return object
        final Map<SongBagLyricsGenreMap, Set<String>> estimatedTags = new HashMap<>();

        for (final SongBagLyricsGenreMap dataElem : testSet) {

            final BagOfWordsDataElement testBOG = dataElem.getBagOfWords();

            final Set<String> unionOfGenres = new HashSet<>();

            for (final SongBagLyricsGenreMap trainElem : trainSet) {
                final BagOfWordsDataElement trainBOG = trainElem.getBagOfWords();
                double simVal = TagEstimation.simVal(testBOG, trainBOG, SIM_CHOICE);
                if (simVal >= THRESHHOLD) {
                    final Set<String> trainGenres = trainElem.getLabels().getGenreList();
                    unionOfGenres.addAll(trainGenres);
                    allSeenGenres.addAll(trainGenres);
                }
            }

            estimatedTags.put(dataElem, unionOfGenres);
        }

        return estimatedTags;
    }
}
