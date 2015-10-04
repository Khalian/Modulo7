package com.modulo7.musicstatmodels.similarity.genericsimilarity;

import com.modulo7.common.exceptions.Modulo7BadIntervalException;
import com.modulo7.common.exceptions.Modulo7WrongNoteType;
import com.modulo7.common.interfaces.AbstractContour;
import com.modulo7.common.interfaces.AbstractVoiceSimilarity;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;
import com.modulo7.musicstatmodels.vectorspacemodels.contour.ContourGradient;
import org.apache.log4j.Logger;

/**
 * Created by asanyal on 10/2/15.
 * A similarity measure based on natural contour of two voices
 */
public class ContourSimilarity<T extends AbstractVoiceSimilarity, C extends AbstractContour> implements AbstractVoiceSimilarity {

    // The internal voice similarity measure used
    private T internalVoiceSimilarity;

    // The internal contour representation used
    private C internalContourRep;

    /**
     * Basic constructor
     * @param internalVoiceSimilarity
     * @param internalContourRep
     */
    public ContourSimilarity(T internalVoiceSimilarity, C internalContourRep) {
        this.internalVoiceSimilarity = internalVoiceSimilarity;
        this.internalContourRep = internalContourRep;
    }

    // Basic logger definition for natural contour similarity
    private static final Logger logger = Logger.getLogger(ContourSimilarity.class);

    @Override
    public double getSimilarity(final Voice first, final Voice second) {

        MaxUnequalMelodicLenSimiMeasure<T> similarity = new MaxUnequalMelodicLenSimiMeasure<T>(internalVoiceSimilarity);
        ContourGradient<AbstractContour> gradient = new ContourGradient<>(internalContourRep);

        try {
            final Voice gradientVoiceFirst = gradient.getGradient(first);
            final Voice gradientVoiceSecond = gradient.getGradient(second);
            return similarity.getSimilarity(gradientVoiceFirst, gradientVoiceSecond);

        } catch (Modulo7BadIntervalException | Modulo7WrongNoteType e) {
            logger.error(e.getMessage());
        }

        return 0.0;
    }
}
