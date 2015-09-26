package com.modulo7.musicstatmodels.similarity.voicesimilarity;

import com.modulo7.common.interfaces.AbstractVoiceSimilarity;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;
import com.modulo7.musicstatmodels.vectorspacemodels.contour.GrossContour;
import org.apache.lucene.search.spell.LevensteinDistance;

/**
 * Created by asanyal on 9/24/15.
 *
 * A similarity measure based on the gross contour of melodies and their
 * edit distance
 */
public class GrossCountourSimilarity implements AbstractVoiceSimilarity {

    /**
     * Returns similarity based on the gross contour representation of songs
     * @param first
     * @param second
     * @return
     */
    @Override
    public double getSimilarity(final Voice first, final Voice second) {
        GrossContour contour = new GrossContour();
        final String firstContourRep = contour.getContourRepresentaionOfVoice(first);
        final String secondContourRep = contour.getContourRepresentaionOfVoice(second);

        LevensteinDistance distance = new LevensteinDistance();

        // Leveinstein distance is a misnomer, its actually a similarity measure
        return distance.getDistance(firstContourRep, secondContourRep);
    }
}
