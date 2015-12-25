package com.modulo7.pureresearch.metadataestimation.genreestimation;

import com.modulo7.common.utils.Modulo7Utils;
import com.modulo7.pureresearch.lastfm.SongBagLyricsGenreMap;
import com.modulo7.pureresearch.metadataestimation.tagestimation.TagEstimation;
import com.modulo7.pureresearch.musicmatch.BagOfWordsDataElement;

import java.util.*;

/**
 * Created by asanyal on 12/23/15.
 *
 * Max frequency genre estimation
 */
public class MaxFrequencyGenreEstimation extends GenreEstimation {

    private static final int K_HYPER_PARAMETER = 2;

    // The thresh hold that is allowed for max frequency estimator to work with
    private double threshHold;

    /**
     * Tag estimator default constructor
     *
     * @param testSet
     * @param trainSet
     */
    public MaxFrequencyGenreEstimation(Set<SongBagLyricsGenreMap> testSet, Set<SongBagLyricsGenreMap> trainSet, final double threshHold) {
        super(testSet, trainSet);
        this.threshHold = threshHold;
    }

    @Override
    public Map<SongBagLyricsGenreMap, Set<String>> getEstimatedGenres() {

        // Init an estimated tags return object
        final Map<SongBagLyricsGenreMap, Set<String>> estimatedGenres = new HashMap<>();

        for (final SongBagLyricsGenreMap dataElem : testSet) {
            final BagOfWordsDataElement bogTest = dataElem.getBagOfWords();
            final Map<String, Integer> genreFrequency = new HashMap<>();

            for (final SongBagLyricsGenreMap trainElem : trainSet) {
                final Set<String> trainGenres= trainElem.getLabels().getGenreList();
                final BagOfWordsDataElement bogTrain = trainElem.getBagOfWords();
                double simVal = TagEstimation.simVal(bogTest, bogTrain, SIM_CHOICE);
                allSeenGenres.addAll(trainGenres);

                if (simVal >= threshHold) {
                    for (final String genreEntry : trainGenres) {
                        Modulo7Utils.addToCount(genreEntry, genreFrequency, 1);
                    }
                }
            }

            List<Map.Entry<String, Integer>> vals = new ArrayList<>(genreFrequency.entrySet());

            //Collections.sort(vals, (o1, o2) -> (o1.getValue())
            //        .compareTo(o2.getValue()));

            Collections.reverse(vals);

            Set<String> estimatedGenreLabels = new HashSet<>();

            int maxIndex = Math.min(K_HYPER_PARAMETER, vals.size());

           for (int i = 0; i < maxIndex; i++) {
                estimatedGenreLabels.add(vals.get(i).getKey());
            }

            estimatedGenres.put(dataElem, estimatedGenreLabels);
        }

        return estimatedGenres;
    }
}
