package com.modulo7.musicstatmodels.similarity.genericsimilarity;

import com.modulo7.common.interfaces.AbstractVoiceSimilarity;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;

/**
 * Created by asanyal on 9/24/15.
 *
 * A generic similarity measure on comparing similarity measures on unequal sized melodies / voices
 *
 * Used as a subroutine inside generic maximal voice similarity
 */
public class MaxUnequalMelodicLenSimiMeasure<T extends AbstractVoiceSimilarity> implements AbstractVoiceSimilarity {

    // An internal voice similarity measure
    private T internalVoiceSimilarityMeasure;

    /**
     * Internal voice similarity is acquired in the constructor
     *
     * @param internalVoiceSimilarityMeasure ( the internal measure used for similarity computation)
     */
    public MaxUnequalMelodicLenSimiMeasure(T internalVoiceSimilarityMeasure) {
        this.internalVoiceSimilarityMeasure = internalVoiceSimilarityMeasure;
    }

    @Override
    public double getSimilarity(final Voice first, final Voice second) {

        double bestSim = -Double.MAX_VALUE;

        final Voice longerVoice;
        final Voice shorterVoice;

        final int lenFirst = first.getNumVoiceInstantsOfVoice();
        final int lenSecond = second.getNumVoiceInstantsOfVoice();

        if (lenFirst > lenSecond) {
            longerVoice = first;
            shorterVoice = second;
        } else {
            longerVoice = second;
            shorterVoice = first;
        }

        int longerLength = longerVoice.getNumVoiceInstantsOfVoice();
        int shorterLength = shorterVoice.getNumVoiceInstantsOfVoice();

        for (int i = 0; i < longerLength - shorterLength; i++) {
            Voice subVoice = getSubVoice(longerVoice, i, i + shorterLength);
            bestSim = Math.max(bestSim, internalVoiceSimilarityMeasure.getSimilarity(subVoice, shorterVoice));
        }

        return bestSim;
    }

    /**
     * Method to return a sub voice (a generalization of the sub melody concept in SIMILIE)
     *
     * @param originalVoice
     * @param firstVoiceInstant
     * @param lastVoiceInstant
     * @return
     */
    private Voice getSubVoice(final Voice originalVoice, final int firstVoiceInstant, final int lastVoiceInstant) {
        final Voice newVoice = new Voice();

        for (int i = firstVoiceInstant; i < lastVoiceInstant; i++) {
            newVoice.addVoiceInstant(originalVoice.getVoiceInstantAtPostion(i));
        }

        newVoice.setVoiceTag(originalVoice.getVoiceTag());

        return newVoice;
    }
}
