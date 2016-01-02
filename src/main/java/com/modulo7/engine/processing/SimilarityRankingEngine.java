package com.modulo7.engine.processing;

import com.modulo7.common.interfaces.AbstractSongSimilarity;
import com.modulo7.engine.storage.DatabaseEngine;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;

import java.util.*;

/**
 * Created by asanyal on 8/30/15.
 *
 * This class is the big daddy of similarity computations
 *
 * In short all similarities are computed and a ranked order to documents are presented
 * the user can choose then to list all the relevant documetns he/she needs
 *
 */
public class SimilarityRankingEngine {

    private AbstractSongSimilarity abstractSimilarity;

    /**
     * Define a similarity engine by first inputting a similarity metric
     * @param similarity
     */
    public SimilarityRankingEngine(final AbstractSongSimilarity similarity) {
        this.abstractSimilarity = similarity;
    }

    /**
     * Rank order the entire database and return the documents on the rank order
     * @param engine
     * @param refSong
     * @return
     */
    public LinkedHashMap<String, Double> relevantRankOrdering(final DatabaseEngine engine, final Song refSong) {

        final Map<String, Song> songMap = engine.getSongLocationMap();
        final Map<Double, String> similarityScore = new HashMap<>();

        for (Map.Entry<String, Song> entry : songMap.entrySet()) {
            final Double similarity = abstractSimilarity.getSimilarity(refSong, entry.getValue());
            similarityScore.put(similarity, entry.getKey());
        }

        Double[] similarityScoreVals = similarityScore.keySet().toArray(new Double[similarityScore.keySet().size()]);
        Arrays.sort(similarityScoreVals, Collections.reverseOrder());

        final LinkedHashMap<String, Double> rankOrderMap = new LinkedHashMap<>();

        for (Double key : similarityScoreVals) {
            rankOrderMap.put(similarityScore.get(key), key);
        }

        return rankOrderMap;
    }

    /**
     * Rank order the entire database and return the documents on the rank order but return only
     * the top n documents
     *
     * @param engine
     * @param refSong
     * @param n
     * @return
     */
    public List<String> relevantRankOrdering(final DatabaseEngine engine, final Song refSong, final int n) {

        final Map<String, Song> songMap = engine.getSongLocationMap();
        final Map<Double, String> similarityScore = new HashMap<>();

        final List<String> rankOrder = new ArrayList<>();

        for (Map.Entry<String, Song> entry : songMap.entrySet()) {
            final Double similarity = abstractSimilarity.getSimilarity(refSong, entry.getValue());
            similarityScore.put(similarity, entry.getKey());
        }

        Double[] similarityScoreVals = similarityScore.keySet().toArray(new Double[similarityScore.keySet().size()]);
        Arrays.sort(similarityScoreVals);

        int count = 0;

        for (final Double key : similarityScoreVals) {

            if (count < n)
                rankOrder.add(similarityScore.get(key));
            else {
                break;
            }
            count++;
        }

        return rankOrder;
    }
}
