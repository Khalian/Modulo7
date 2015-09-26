package com.modulo7.musicstatmodels.vectorspacemodels.contour;

import com.modulo7.common.exceptions.Modulo7BadIntervalException;
import com.modulo7.common.exceptions.Modulo7WrongNoteType;
import com.modulo7.common.interfaces.AbstractContour;
import com.modulo7.musicstatmodels.musictheorymodels.Interval;
import com.modulo7.musicstatmodels.musictheorymodels.IntervalType;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;
import com.modulo7.musicstatmodels.representation.monophonic.VoiceInstant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asanyal on 9/26/15.
 *
 * Given a contour, returns the gradient with respect to consecutive notes in the contour representation
 * The gradient is a quantitative representation of the direction and magnitude of successive elements in
 * the contour
 */
public class ContourGradient<T extends AbstractContour> {

    // The abstract contour representation internally
    private T internalContourRepresentation;

    /**
     * Init a contour gradient
     * @param internalContourRepresentation
     */
    public ContourGradient(final T internalContourRepresentation) {
        this.internalContourRepresentation = internalContourRepresentation;
    }

    /**
     * Method to get the gradient vector associated with a contour
     *
     * A gradient is a quantitative vectorized representation of a
     *
     * @param voice
     * @return
     * @throws Modulo7BadIntervalException
     * @throws Modulo7WrongNoteType
     */
    public List<Integer> getGradient(final Voice voice) throws Modulo7BadIntervalException, Modulo7WrongNoteType {

        // Gradient vector for
        final List<Integer> gradientVector = new ArrayList<>();

        if (internalContourRepresentation instanceof GrossContour) {
            final String contour = (String) internalContourRepresentation.getContourRepresentaionOfVoice(voice);
            final String[] contourSplit = contour.split(" ");
            for (int i = 0; i < contourSplit.length - 1; i++) {
                if (contourSplit[i].equals("U") && contourSplit[i + 1].equals("D")) {
                    gradientVector.add(-1);
                } else if (contourSplit[i].equals("D") && contourSplit[i+1].equals("U")) {
                    gradientVector.add(1);
                } else {
                    gradientVector.add(0);
                }
            }
        } else {
            final Voice newVoice = (Voice) internalContourRepresentation.getContourRepresentaionOfVoice(voice);
            final List<VoiceInstant> instantList = newVoice.getVoiceSequence();

            for (int i = 0; i < instantList.size() - 1; i++) {
                final VoiceInstant instant = instantList.get(i);
                final VoiceInstant nextInstant = instantList.get(i + 1);

                final Interval gradientInterval = Interval.getInterval(instant, nextInstant);

                // Add the intervalic distance to the contour gradient representation dep
                final int sign = (gradientInterval.getType().equals(IntervalType.ASCENDING)) ? 1 : -1;
                gradientVector.add(gradientInterval.getIntervalEnum().getIntervalQuantity() * sign);
            }
        }

        return gradientVector;
    }
}
