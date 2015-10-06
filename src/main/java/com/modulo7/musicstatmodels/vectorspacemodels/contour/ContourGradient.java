package com.modulo7.musicstatmodels.vectorspacemodels.contour;

import com.modulo7.common.exceptions.Modulo7BadIntervalException;
import com.modulo7.common.exceptions.Modulo7WrongNoteType;
import com.modulo7.common.interfaces.AbstractContour;
import com.modulo7.musicstatmodels.musictheorymodels.Interval;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;
import com.modulo7.musicstatmodels.representation.monophonic.VoiceInstant;
import org.apache.commons.lang3.SerializationUtils;

import java.util.*;

/**
 * Created by asanyal on 9/26/15.
 *
 * Given a contour, returns the gradient with respect to consecutive notes in the contour representation
 * The gradient is a quantitative representation of the direction and magnitude of successive elements in
 * the contour
 *
 * Once the gradient is computed, all notes are shifted in between two extremum notes by the gradient amount
 * by the equation
 *
 * p_(i + k) = p_i + m (t_{i+k} - t(i)) for natural contour, steinbeck contour and mullensefstein contour
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
    public Voice getGradient(final Voice voice) throws Modulo7BadIntervalException, Modulo7WrongNoteType {

        // Gradient vector for
        final LinkedHashMap<Integer, VoiceInstant> extemumNotes = internalContourRepresentation.getContourRepresentaionOfVoice(voice);

        // This ensures a deep copy of the voice so that the original voi
        Voice newVoice = SerializationUtils.clone(voice);

        final List<Integer> extremumNotesInOrder = new ArrayList<>(extemumNotes.keySet());

        for (int i = 1; i < extremumNotesInOrder.size(); i++) {
            int location1 = extremumNotesInOrder.get(i - 1);
            int location2 = extremumNotesInOrder.get(i);

            VoiceInstant v1 = extemumNotes.get(location1);
            VoiceInstant v2 = extemumNotes.get(location2);

            final int interval = Interval.getInterval(v2, v1).getIntervalQuantity().getQuantity();
            final double durationDiff = v2.getDuration() - v1.getDuration();

            final double gradient = interval / durationDiff;

            // Alter the voice based on contour computation
            for (int j = location1; j <= location2; j++) {
                final VoiceInstant currInstant = voice.getVoiceInstantAtPostion(j);
                final double currDifference = currInstant.getDuration() - v1.getDuration();
                final int estimatedInterval = (int) (currDifference * gradient);
                VoiceInstant shiftedInstance = VoiceInstant.getShiftedInstance(currInstant, estimatedInterval);
                voice.reassignVoiceInstance(shiftedInstance, j);
            }
        }

        return newVoice;
    }
}
