package com.modulo7.musicstatmodels.similarity.voicesimilarity;

import com.modulo7.common.exceptions.Modulo7BadIntervalException;
import com.modulo7.common.exceptions.Modulo7WrongNoteType;
import com.modulo7.common.interfaces.AbstractContour;
import com.modulo7.common.interfaces.AbstractVoiceSimilarity;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;
import com.modulo7.musicstatmodels.vectorspacemodels.contour.ContourGradient;
import com.modulo7.musicstatmodels.vectorspacemodels.contour.NaturalContour;
import org.apache.log4j.Logger;


/**
 * Created by asanyal on 10/2/15.
 *
 * A similarity measure based on natural contour of a voice
 */
public class NaturalContourSimilarity implements AbstractVoiceSimilarity {

    // Basic logger definition for natural contour similarity
    private static final Logger logger = Logger.getLogger(NaturalContourSimilarity.class);


    @Override
    public double getSimilarity(final Voice first, final Voice second) {
        AbstractContour<Voice> contourExp = new NaturalContour();
        final Voice naturalContourFirst = contourExp.getContourRepresentaionOfVoice(first);
        final Voice naturalContourSecond = contourExp.getContourRepresentaionOfVoice(second);

        ContourGradient gradient = new ContourGradient<>(contourExp);

        try {
            gradient.getGradient(naturalContourFirst);
            gradient.getGradient(naturalContourSecond);
        } catch (Modulo7BadIntervalException | Modulo7WrongNoteType e) {
            logger.error(e.getMessage());
        }

        // TODO : Finish this

        return 0.0;
    }
}
