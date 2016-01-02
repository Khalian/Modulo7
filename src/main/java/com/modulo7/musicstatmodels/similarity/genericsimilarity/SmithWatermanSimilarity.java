package com.modulo7.musicstatmodels.similarity.genericsimilarity;

import com.modulo7.common.interfaces.AbstractVoiceSimilarity;
import com.modulo7.common.utils.Modulo7Utils;
import com.modulo7.musicstatmodels.misc.TonalityAlignment;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by asanyal on 10/14/15.
 *
 * Implementation for the smith waterman similarity measure
 * used typically for melody alignment
 */
public class SmithWatermanSimilarity<T extends AbstractVoiceSimilarity> implements AbstractVoiceSimilarity {

    // An internal voice similarity measure
    private T internalVoiceSimilarityMeasure;

    // Alignments for each pair of voices
    // An assumption is that the voices are not identical to each other in a song providing a simple
    // voice to voice directions mapping
    private TonalityAlignment alignment;

    /**
     * Internal voice similarity is acquired in the constructor
     *
     * @param internalVoiceSimilarityMeasure ( the internal measure used for similarity computation)
     */
    public SmithWatermanSimilarity(final T internalVoiceSimilarityMeasure) {
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

        return computeSmithWatermanBestSum(shorterVoice, longerVoice);
    }

    /**
     * The main method which gives the answer to
     *
     * @param shorterVoice
     * @param longerVoice
     * @return
     */
    private double computeSmithWatermanBestSum(final Voice shorterVoice, final Voice longerVoice) {

        int longerLength = longerVoice.getNumVoiceInstantsOfVoice();
        int shorterLength = shorterVoice.getNumVoiceInstantsOfVoice();

        double[][] smithWaterSonMatrix = new double[shorterLength][longerLength];

        Direction[][] directions = new Direction[shorterLength][longerLength];

        // Initializing the smith water son matrix first columns
        for (int i = 0; i < shorterLength; i++) {
            smithWaterSonMatrix[i][0] = 0;
            directions[i][0] = Direction.ZERO;
        }

        for (int i = 0; i < longerLength; i++) {
            smithWaterSonMatrix[0][i] = 0;
            directions[0][i] = Direction.ZERO;
        }

        for (int i = 1; i < shorterLength; i++) {
            for (int j = 1; j < longerLength; j++) {
                final Voice instantAtI = getSubVoice(shorterVoice, i, i + 1);
                final Voice instantAtJ = getSubVoice(longerVoice, j, j + 1);

                double sIJ = internalVoiceSimilarityMeasure.getSimilarity(instantAtI, instantAtJ);

                smithWaterSonMatrix[i][j] = Math.max(smithWaterSonMatrix[i - 1 ][j - 1]
                        + sIJ, Math.max(smithWaterSonMatrix[i][j - 1] + 1, smithWaterSonMatrix[i - 1][j] + 1));

                if (smithWaterSonMatrix[i][j] == smithWaterSonMatrix[i - 1][j - 1]) {
                    directions[i][j] = Direction.UP_AND_LEFT;
                } else if(smithWaterSonMatrix[i][j] == smithWaterSonMatrix[i][j - 1] + 1) {
                    directions[i][j] = Direction.LEFT;
                } else if(smithWaterSonMatrix[i][j] == smithWaterSonMatrix[i - 1][j]) {
                    directions[i][j] = Direction.UP;
                }
            }
        }

        acuireAlignment(directions, shorterVoice, longerVoice);
        return smithWaterSonMatrix[shorterLength - 1][longerLength - 1] / longerLength;
    }

    /**
     * Computes and hashes a string representation of the alignments as computed by the smith water man algorithm
     * These alignments are per voice
     *
     * @param directions
     * @param shorterVoice
     * @param longerVoice
     */
    private void acuireAlignment(final Direction[][] directions, final Voice shorterVoice, final Voice longerVoice) {
        final List<String> firstDoc = shorterVoice.getDocumentElementsRepresentation();
        final List<String> secondDoc = longerVoice.getDocumentElementsRepresentation();

        int rowIndex = directions.length - 1;
        int colIndex = directions[0].length - 1;

        while (!directions[rowIndex][colIndex].equals(Direction.ZERO)) {
            if (directions[rowIndex][colIndex].equals(Direction.UP_AND_LEFT)) {
                rowIndex--;
                colIndex--;
            } else if (directions[rowIndex][colIndex].equals(Direction.LEFT)) {
                secondDoc.set(colIndex, "-");
                colIndex--;
            } else if (directions[rowIndex][colIndex].equals(Direction.UP)) {
                firstDoc.set(rowIndex, "-");
                rowIndex--;
            }
        }

        final String first = Modulo7Utils.buildStringOverList(firstDoc);
        final String second = Modulo7Utils.buildStringOverList(secondDoc);

        alignment = new TonalityAlignment(first, second);
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

    /**
     * Get the tonality alignment for these voices
     * @return
     */
    public TonalityAlignment getAlignment() {
        return alignment;
    }
}

/**
 * A helper enum for the direction of the smith waterman computations
 * as defined in https://en.wikipedia.org/wiki/Smith%E2%80%93Waterman_algorithm
 */
enum Direction {
    ZERO,
    UP,
    LEFT,
    UP_AND_LEFT
}
