package com.modulo7.pureresearch.metadataestimation.genreestimation;

import com.modulo7.pureresearch.lastfm.SongBagLyricsGenreMap;
import com.modulo7.pureresearch.metadataestimation.tagestimation.TagEstimation;
import com.modulo7.pureresearch.musicmatch.BagOfWordsDataElement;

import java.util.*;

/**
 * Created by asanyal on 12/23/15.
 *
 * Weighted genre esimation based on the number of top documents assumed as relevant
 */
public class WeightedGenreEstimation extends GenreEstimation {

    // Number of top documents that are assumed to be relevant
    private int topDocs;

    /**
     * Tag estimator default constructor
     *
     * @param testSet
     * @param trainSet
     * @param topDocNum
     */
    public WeightedGenreEstimation(final Set<SongBagLyricsGenreMap> testSet, final Set<SongBagLyricsGenreMap> trainSet, final int topDocNum) {
        super(testSet, trainSet);
        this.topDocs = topDocNum;
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

            // A kind of a hack here, double equality is so rare, that just sorting over key is sufficient for our work
            // and we dont have to pedantic over sorting the entire object, i am getting lazy so wont make a new comparator
            List<Double> allSims = new ArrayList<>(weightedGenreLabels.keySet());
            Collections.sort(allSims, Collections.reverseOrder());

            Set<String> unionOfGenres = new HashSet<>();
            int maxIndex = Math.min(topDocs, allSims.size());

            for (int i = 0; i < maxIndex; i++) {
                Double val = allSims.get(i);
                SongBagLyricsGenreMap lyricsGenreMap = weightedGenreLabels.get(val);
                unionOfGenres.addAll(lyricsGenreMap.getLabels().getGenreList());
            }

            estimatedGenres.put(dataElem, unionOfGenres);
        }

        return estimatedGenres;
    }
}
