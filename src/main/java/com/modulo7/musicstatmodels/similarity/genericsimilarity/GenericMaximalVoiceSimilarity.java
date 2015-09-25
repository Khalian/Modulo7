package com.modulo7.musicstatmodels.similarity.genericsimilarity;

import com.modulo7.common.interfaces.AbstractSongSimilarity;
import com.modulo7.common.interfaces.AbstractVoiceSimilarity;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;

/**
 * Created by asanyal on 9/18/15.
 *
 * Generic maximal voice similarity is based on similarity
 * between pairs of voices and then returning
 */
public class GenericMaximalVoiceSimilarity<T extends AbstractVoiceSimilarity> implements AbstractSongSimilarity {

    // The internal voice similarity measure
    private T internalVoiceSimilarity;

    /**
     * Basic constructor for generic maximal similarity
     * @param similarityMeasure
     */
    public GenericMaximalVoiceSimilarity(final T similarityMeasure) {
        internalVoiceSimilarity = similarityMeasure;
    }

    @Override
    public double getSimilarity(final Song first, final  Song second) {
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
