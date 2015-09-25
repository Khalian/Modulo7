package com.modulo7.musicstatmodels.similarity.voicesimilarity;

import com.modulo7.common.interfaces.AbstractVoiceSimilarity;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;
import org.apache.lucene.search.spell.LevensteinDistance;

/**
 * Created by asanyal on 9/1/15.
 *
 * Raw edit distance between two strings with raw pitch values, returns the average
 * over all the melodic distances computed pariwise between the voices
 *
 * This assumes both voices are in the same key signature for the operation to work
 */
public class RawMelodicEditDistanceSimilarity implements AbstractVoiceSimilarity {

    @Override
    public double getSimilarity(final Voice first, final Voice second) {

        final String firstSetDoc = first.getDocumentRepresentation();
        final String secondSetDoc = second.getDocumentRepresentation();

        String[] firstSplit = firstSetDoc.split(" ");
        String[] secondSplit = secondSetDoc.split(" ");

        return (double) (1 - (levensteinDistanceOnArbitraryTokens(firstSplit, secondSplit)) / Math.max(firstSplit.length, secondSplit.length));
    }

    /**
     * Custom implementation of the levenstein distance based on tokens instead of characters
     * This is required because the tokens are non trivial sized strings, not just characters
     * for an arbitrary voice (e.g a chord cMaj is a token and not a character)
     *
     * @param first
     * @param second
     * @return
     */
    private int levensteinDistanceOnArbitraryTokens(final String[] first, final String[] second) {

        int [] costs = new int [second.length + 1];

        for (int j = 0; j < costs.length; j++)
            costs[j] = j;

        for (int i = 1; i <= first.length; i++) {
            costs[0] = i;
            int nw = i - 1;
            for (int j = 1; j <= second.length; j++) {
                int cj = Math.min(1 + Math.min(costs[j], costs[j - 1]), first[i - 1].equals(second[j - 1]) ? nw : nw + 1);
                nw = costs[j];
                costs[j] = cj;
            }
        }
        return costs[second.length];
    }
}
