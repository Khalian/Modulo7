package com.modulo7.pureresearch.metadataestimation.genreestimation;

import com.modulo7.pureresearch.lastfm.SongBagLyricsGenreMap;
import com.modulo7.pureresearch.metadataestimation.bagofwordslyricssim.BOWSimilarityChoices;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by asanyal on 12/22/15.
 *
 * Skeletal genre estimation class
 *
 * All implementations must implement this class
 */
public abstract class GenreEstimation {

    // A set of song bagged lyrics and meta data mapped
    protected Set<SongBagLyricsGenreMap> lyricsMappedGenreEntries;

    // Train set split of the Tag Estimation algorithm
    protected Set<SongBagLyricsGenreMap> trainSet;

    // The test set split of the tag estimation algorithm
    protected Set<SongBagLyricsGenreMap> testSet;

    // All the seen genres
    public Set<String> allSeenGenres = new HashSet<>();

    // Choice of bag of words similarity
    protected static final BOWSimilarityChoices SIM_CHOICE = BOWSimilarityChoices.COSINE_SIMILARITY;

    // Thresh hold value for assessing similarities
    protected static final double THRESHHOLD = 0.7;

    /**
     * Tag estimator default constructor
     *
     * @param testSet
     * @param trainSet
     */
    public GenreEstimation(final Set<SongBagLyricsGenreMap> testSet, final Set<SongBagLyricsGenreMap> trainSet) {
        this.testSet = testSet;
        this.trainSet = trainSet;
    }

    /**
     * Gets the estimated tags for a given
     * @return
     */
    public abstract Map<SongBagLyricsGenreMap, Set<String>> getEstimatedGenres();

    /**
     * Gets all the seen genres
     * @return
     */
    public Set<String> getAllSeenGenres() {
        return allSeenGenres;
    }
}
