package com.modulo7.musicstatmodels.similarity.voicesimilarity;

import com.modulo7.common.interfaces.AbstractVoiceSimilarity;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by asanyal on 11/7/15.
 *
 * Based on the similie technical manual, the count distance similarity is
 * based on the count(number) of common trigrams, rather than the actual frequecies
 */
public class CountDistanceSimilarity implements AbstractVoiceSimilarity {

    // Number of grams, default to 3
    private int N = 3;

    /**
     * CountDistanceSimilarity measure constructor with custom number of grams
     * @param n
     */
    public CountDistanceSimilarity(final int n) {
        N = n;
    }

    /**
     * CountDistanceSimilarity default constructor
     */
    public  CountDistanceSimilarity() {
    }

    @Override
    public double getSimilarity(final Voice first, final Voice second) {

        // Compute the distinct N grams in the first voice
        final Set<String> distinctTrigramsInOne = new HashSet<>();

        // Compute the distinct N grams in the second voice
        final Set<String> distinctTrigramsInTwo = new HashSet<>();

        final String firstSetDoc = first.getDocumentRepresentation();
        final String secondSetDoc = second.getDocumentRepresentation();

        String[] firstSplit = firstSetDoc.split(" ");
        String[] secondSplit = secondSetDoc.split(" ");

        for (int i = 0; i < firstSplit.length - N; i++) {
            String ngram = "";
            for (int k = i; k < i + N; k++)
                ngram += firstSplit[k];
            distinctTrigramsInOne.add(ngram);
        }

        for (int i = 0; i < secondSplit.length - N; i++) {
            String ngram = "";
            for (int k = i; k < i + N; k++)
                ngram += secondSplit[k];
            distinctTrigramsInTwo.add(ngram);
        }

        // Intersection of both sets
        distinctTrigramsInOne.retainAll(distinctTrigramsInTwo);

        return (double) distinctTrigramsInOne.size() / Math.max(firstSplit.length, secondSplit.length);
    }

}
