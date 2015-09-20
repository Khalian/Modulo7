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
 * This assumes both voices are in the same key signature
 *
 * TODO : Ascertain a better tokenization scheme
 */
public class RawMelodicEditDistanceSimilarity implements AbstractVoiceSimilarity {

    @Override
    public double getSimilarity(final Voice first, final Voice second) {

        final String firstSetDoc = first.getDocumentRepresentation();
        final String secondSetDoc = second.getDocumentRepresentation();

        final LevensteinDistance distance = new LevensteinDistance();

        return (double) distance.getDistance(firstSetDoc, secondSetDoc);
    }
}
