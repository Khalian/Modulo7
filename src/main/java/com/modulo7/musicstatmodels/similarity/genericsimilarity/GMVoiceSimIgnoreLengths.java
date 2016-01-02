package com.modulo7.musicstatmodels.similarity.genericsimilarity;

import com.modulo7.common.interfaces.AbstractSongSimilarity;
import com.modulo7.common.interfaces.AbstractVoiceSimilarity;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;

/**
 * Created by asanyal on 10/13/15.
 *
 * Similar to the generic maximalvoicesimilarity, but here we dont care
 * about unequal lengths of voices
 */
public class GMVoiceSimIgnoreLengths <T extends AbstractVoiceSimilarity> implements AbstractSongSimilarity {

    // The internal voice similarity measure
    private T internalVoiceSimilarity;

    /**
     * Basic constructor for generic maximal similarity
     * @param similarityMeasure (The internal similarity measure used inside generic maximal voice similarity)
     */
    public GMVoiceSimIgnoreLengths(final T similarityMeasure) {
        internalVoiceSimilarity = similarityMeasure;
    }

    @Override
    public double getSimilarity(Song first, Song second) {
        double bestSim = -Double.MAX_VALUE;

        for (final Voice firstVoice : first.getVoices()) {
            for (final Voice secondVoice : second.getVoices()) {
                final double currSim = internalVoiceSimilarity.getSimilarity(firstVoice, secondVoice);
                bestSim = Math.max(bestSim, currSim);
            }
        }

        return bestSim;
    }
}
