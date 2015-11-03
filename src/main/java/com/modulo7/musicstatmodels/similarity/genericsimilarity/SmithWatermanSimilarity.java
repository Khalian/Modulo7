package com.modulo7.musicstatmodels.similarity.genericsimilarity;

import com.modulo7.common.interfaces.AbstractVoiceSimilarity;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;

/**
 * Created by asanyal on 10/14/15.
 *
 * Implementation for the smith waterman similarity measure
 * used typically for melody alignment
 */
public class SmithWatermanSimilarity<T extends AbstractVoiceSimilarity> implements AbstractVoiceSimilarity {

    // An internal voice similarity measure
    private T internalVoiceSimilarityMeasure;

    /**
     * Internal voice similarity is acquired in the constructor
     *
     * @param internalVoiceSimilarityMeasure ( the internal measure used for similarity computation)
     */
    public SmithWatermanSimilarity(T internalVoiceSimilarityMeasure) {
        this.internalVoiceSimilarityMeasure = internalVoiceSimilarityMeasure;
    }

    @Override
    public double getSimilarity(final Voice first, final Voice second) {

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

        return computeSmithWaterSonBestSum(shorterVoice, longerVoice);
    }

    /**
     * The main method which gives the answer to
     *
     * @param shorterVoice
     * @param longerVoice
     * @return
     */
    private double computeSmithWaterSonBestSum(final Voice shorterVoice, final Voice longerVoice) {

        int longerLength = longerVoice.getNumVoiceInstantsOfVoice();
        int shorterLength = shorterVoice.getNumVoiceInstantsOfVoice();

        double[][] smithWaterSonMatrix = new double[shorterLength][longerLength];


        // Initializing the smith water son matrix first columns
        for (int i = 0; i < shorterLength; i++) {
            smithWaterSonMatrix[i][0] = 0;
        }

        for (int i = 0; i < longerLength; i++) {
            smithWaterSonMatrix[0][i] = 0;
        }

        for (int i = 1; i < shorterLength; i++) {
            for (int j = 1; j < longerLength; j++) {
                final Voice instantAtI = getSubVoice(shorterVoice, i, i + 1);
                final Voice instantAtJ = getSubVoice(longerVoice, j, j + 1);

                double sIJ = internalVoiceSimilarityMeasure.getSimilarity(instantAtI, instantAtJ);

                smithWaterSonMatrix[i][j] = Math.max(smithWaterSonMatrix[i - 1 ][j - 1]
                        + sIJ, Math.max(smithWaterSonMatrix[i][j - 1] + 1, smithWaterSonMatrix[i - 1][j] + 1));
            }
        }

        return smithWaterSonMatrix[shorterLength - 1][longerLength - 1] / longerLength;
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
