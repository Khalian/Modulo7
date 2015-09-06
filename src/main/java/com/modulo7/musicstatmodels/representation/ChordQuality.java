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
 *
 * Chords are the basic unit of harmony in western music. Harmonic elements are
 * constructed from chords
 */
public enum ChordQuality {
    NOT_A_CHORD("not_a_chord"),
    UNKNOWN("unknown"),
    MAJOR("maj"),
    MINOR("min"),
    DOMINANT("dom"),
    DIMINISHED5th("dim5th"),
    SUSPENDED("sus"),
    AUGMENTED5th("aug");

    // Frequency note map instance associated with the chord type to ascertain absolute positions
    private static final FrequencyNoteMap noteMap = FrequencyNoteMap.getInstance();

    // String representation of chordtype
    private String val;

    ChordQuality(String val) {
        this.val = val;
    }

    /**
     * A static helper method to estimate what type of chord is being played
     * at this element
     *
     * This method is most useful when the set of notes are symbolically given
     *
     * @return
     */
    public static ChordQuality estimateChordType(final Set<Note> noteSet) throws Modulo7BadIntervalException {

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
     * Gets the root note associated with the chord
     * @return
     */
    public static Note getRootNoteFromChord(final Set<Note> noteSet) {

        // Position the array
        List<Integer> notePositionArray = new ArrayList<>();

        for (final Note note : noteSet) {
            int positionOnKeyboard = noteMap.getPositionGivenNote(note);
            notePositionArray.add(positionOnKeyboard);
        }

        Collections.sort(notePositionArray);

        return noteMap.getNoteGivenPosition(notePositionArray.get(0));
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
     * Gets the interval spacings between the notes in ascending order
     *
     * This method is used as a helper class to facilitate acquiring interval spacings for analysis
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

    /**
     * Gets the string representation of the chord type
     * @return
     */
    public String getStringRepresentation() {
        return val;
    }

    /**
     * Estimate the notes of a chord given its chord quality and root note of the chord
     *
     * @param rootNote
     * @param quality
     * @return
     */
    public static Set<Note> estimateChordGivenQualityAndRootNote(final int rootNote, final ChordQuality quality) {
        return null;
    }
}
