package com.modulo7.musicstatmodels.similarity.voicesimilarity;

import com.modulo7.common.interfaces.AbstractVoiceSimilarity;
import com.modulo7.common.utils.Modulo7Utils;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by asanyal on 10/13/15.
 *
 * Ukkonnen measure as described in SIMILIE technical documentation
 */
public class UkkonnenSimilarity implements AbstractVoiceSimilarity {

    // Number of grams, default to 3
    private int N = 3;

    /**
     * Ukkonnen similarity measure constructor with custom number of grams
     * @param n
     */
    public UkkonnenSimilarity(final int n) {
        N = n;
    }

    /**
     * Ukkonnen default constructor
     */
    public  UkkonnenSimilarity() {
    }

    @Override
    public double getSimilarity(final Voice first, final Voice second) {

        // Compute the distinct N grams in the first voice
        final Map<String, Integer> distinctTrigramsInOne = new HashMap<>();

        // Compute the distinct N grams in the second voice
        final Map<String, Integer> distinctTrigramsInTwo = new HashMap<>();

        final String firstSetDoc = first.getDocumentRepresentation();
        final String secondSetDoc = second.getDocumentRepresentation();

        String[] firstSplit = firstSetDoc.split(" ");
        String[] secondSplit = secondSetDoc.split(" ");

        for (int i = 0; i < firstSplit.length - N; i++) {
            String ngram = "";
            for (int k = i; k < i + N; k++)
                ngram += firstSplit[k];
            Modulo7Utils.addToCount(ngram, distinctTrigramsInOne);
        }

        for (int i = 0; i < secondSplit.length - N; i++) {
            String ngram = "";
            for (int k = i; k < i + N; k++)
                ngram += secondSplit[k];
            Modulo7Utils.addToCount(ngram, distinctTrigramsInTwo);
        }

        return 1 - (double) (Math.abs(Modulo7Utils.sumOverNGramFreqs(distinctTrigramsInOne) - Modulo7Utils.sumOverNGramFreqs(distinctTrigramsInTwo)))
                / (firstSplit.length + secondSplit.length - 2*(N - 1));
    }
}