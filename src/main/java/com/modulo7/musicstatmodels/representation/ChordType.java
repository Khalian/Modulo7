package com.modulo7.musicstatmodels.representation;

import com.modulo7.common.exceptions.Modulo7BadIntervalException;
import com.modulo7.common.utils.FrequencyNoteMap;
import com.modulo7.musicstatmodels.musictheorymodels.Interval;
import com.modulo7.musicstatmodels.musictheorymodels.IntervalEnum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Created by asanyal on 9/2/15.
 *
 * A chord is a vertical stacking of notes with a specific interval
 * structure with a specific interval structure differentiating different
 * types of chords
 */
public enum ChordType {
    NOT_A_CHORD,
    MAJOR,
    MINOR,
    DIMINISHED,
    AUGMENTED;

    // Frequency note map instance associated with the chord type to ascertain absolute positions
    private static final FrequencyNoteMap noteMap = FrequencyNoteMap.getInstance();

    /**
     * A static helper method to estimate what type of chord is being played
     * at this element
     *
     * @return
     */
    public static ChordType estimateChordType(final Set<Note> noteSet) throws Modulo7BadIntervalException {

        if (noteSet.size() == 1) {
            return NOT_A_CHORD;
        }

        // TODO : write code for the other types of chords in existence
        if (estimateIfMajorChord(noteSet)) {
            return MAJOR;
        } else if (estimateIfMinorChord(noteSet)) {
            return MINOR;
        } else {
            return NOT_A_CHORD;
        }
    }

    /**
     * Estimate whether the chord is a minor chord or not
     * @param noteSet
     * @return
     */
    private static boolean estimateIfMajorChord(final Set<Note> noteSet) throws Modulo7BadIntervalException {

        // Major chords are triads
        if (!checkIfTriad(noteSet)) {
            return false;
        } else {

            List<IntervalEnum> intervalsList = ascertainIntervalSpacings(noteSet);

            if (intervalsList.get(0).equals(IntervalEnum.PERFECT_UNISON)
                    && intervalsList.get(1).equals(IntervalEnum.MAJOR_THIRD)
                    && intervalsList.get(2).equals(IntervalEnum.PERFECT_FIFTH))
                return true;
        }

        return false;
    }

    /**
     * Estimate if the chord is a minor chord or not
     *
     * @param noteSet
     * @return
     */
    private static boolean estimateIfMinorChord(final Set<Note> noteSet) throws Modulo7BadIntervalException {
        // Major chords are triads
        if (!checkIfTriad(noteSet)) {
            return false;
        } else {

            List<IntervalEnum> intervalsList = ascertainIntervalSpacings(noteSet);

            if (intervalsList.get(0).equals(IntervalEnum.PERFECT_UNISON)
                    && intervalsList.get(1).equals(IntervalEnum.MINOR_THIRD)
                    && intervalsList.get(2).equals(IntervalEnum.PERFECT_FIFTH))
                return true;
        }

        return false;
    }

    /**
     * Checks if the chord is a triad or not
     *
     * A triad has exactly 3 notes
     *
     * @return
     */
    private static boolean checkIfTriad(final Set<Note> noteSet) {
        return noteSet.size() == 3;
    }

    /**
     *
     * @param noteSet
     * @return
     * @throws Modulo7BadIntervalException
     */
    private static List<IntervalEnum> ascertainIntervalSpacings(final Set<Note> noteSet) throws Modulo7BadIntervalException {
        // Position the array
        List<Integer> notePositionArray = new ArrayList<>();

        for (final Note note : noteSet) {
            int positionOnKeyboard = noteMap.getPositionGivenNote(note);
            notePositionArray.add(positionOnKeyboard);
        }

        Collections.sort(notePositionArray);

        int minPosition = notePositionArray.get(0);

        // With this we get the intervals from the root note of the chord
        for (int i = 0; i < notePositionArray.size(); i++) {
            notePositionArray.set(i, notePositionArray.get(i) - minPosition);
        }

        List<IntervalEnum> intervalsList = new ArrayList<>();

        for (final Integer noteInterval : notePositionArray) {
            intervalsList.add(Interval.getInterval(noteInterval));
        }

        return intervalsList;
    }
}
