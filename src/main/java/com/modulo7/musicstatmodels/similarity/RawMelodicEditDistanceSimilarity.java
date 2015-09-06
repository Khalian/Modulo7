package com.modulo7.musicstatmodels.similarity;

import com.modulo7.common.interfaces.AbstractSimilarity;
import com.modulo7.musicstatmodels.representation.Song;
import org.apache.lucene.search.spell.LevensteinDistance;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by asanyal on 9/1/15.
 *
 * Raw edit distance between two strings with raw pitch values, returns the average
 * over all the melodic distances computed pariwise between the voices
 *
 * TODO : Ascertain a better tokenization scheme
 */
public class RawMelodicEditDistanceSimilarity implements AbstractSimilarity {

    @Override
    public double getSimilarity(final Song first, final Song second) {

        Set<Double> individualSims = new HashSet<>();

        Set<String> firstSetDoc = first.getDocumentRepresentation();
        Set<String> secondSetDoc = second.getDocumentRepresentation();

        LevensteinDistance distance = new LevensteinDistance();

        for (final String doc1 : firstSetDoc) {
            for (final String doc2 : secondSetDoc) {
                individualSims.add((double) distance.getDistance(doc1, doc2));
            }
        }

        double sum = 0;

        for (Double sim : individualSims) {
            sum += sim;
        }

        return sum/Math.pow(individualSims.size(), 2);
    }
}
