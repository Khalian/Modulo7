package com.modulo7.musicstatmodels.musictheorymodels;

import com.modulo7.common.exceptions.Modulo7BadIntervalException;
import com.modulo7.common.exceptions.Modulo7WrongNoteType;
import com.modulo7.common.utils.FrequencyNoteMap;
import com.modulo7.musicstatmodels.representation.buildingblocks.ChordQuality;
import com.modulo7.musicstatmodels.representation.buildingblocks.Note;
import com.modulo7.musicstatmodels.representation.monophonic.VoiceInstant;

/**
 * Created by asanyal on 8/20/15.
 *
 * An interval is the relative distance between two
 * consecutive notes played on a musical instrument
 *
 * Each interval is also of type descending or ascending
 * encoded in the member type
 */
public class Interval {

    // The interval entity
    private IntervalQuantity interval;

    // The type of interval
    private IntervalType type;

    /**
     * Basic constructor
     * @param intervalQuantity
     * @param type
     */
    private Interval(final IntervalQuantity intervalQuantity, final IntervalType type) {
        this.interval = intervalQuantity;
        this.type = type;
    }

    // Get an instance of the frequency note map construct
    private static FrequencyNoteMap frequencyNoteMap = FrequencyNoteMap.getInstance();

    /**
     * Gets the interval between two consecutive notes
     *
     * @param firstNote
     * @param secondNote
     * @return
     */
    public static Interval getInterval(final Note firstNote, final Note secondNote) throws Modulo7BadIntervalException {

        // Gets the keyboard position of both notes from the frequency note map
        final int firstPosition = frequencyNoteMap.getPositionGivenNote(firstNote);
        final int secondPosition = frequencyNoteMap.getPositionGivenNote(secondNote);

        // Figure out what type of an interval it is
        final IntervalType intervalType;

        if (firstPosition < secondPosition) {
            intervalType = IntervalType.ASCENDING;
        } else {
            intervalType = IntervalType.DESCENDING;
        }

        IntervalQuantity intervalQuantity = getIntervalQuantity(secondPosition - firstPosition);

        return new Interval(intervalQuantity, intervalType);
    }


    /**
     * Returns an interval given the number of half steps (negative sign meaning descending)
     * and positive sign meaning ascending
     *
     * @param numHalfStepsWithSign
     * @return
     * @throws Modulo7BadIntervalException
     */
    public static Interval getInterval(final int numHalfStepsWithSign) throws Modulo7BadIntervalException {
        // Figure out what type of an interval it is
        final IntervalType intervalType;

        if (numHalfStepsWithSign > 0) {
            intervalType = IntervalType.ASCENDING;
        } else {
            intervalType = IntervalType.DESCENDING;
        }

        IntervalQuantity intervalQuantity = getIntervalQuantity(numHalfStepsWithSign);

        return new Interval(intervalQuantity, intervalType);
    }

    /**
     * Gets the interval given the number of half steps
     *
     * @param numHalfStepsWithSign
     * @return
     */
    public static IntervalQuantity getIntervalQuantity(final int numHalfStepsWithSign) throws Modulo7BadIntervalException {

        int numHalfSteps = Math.abs(numHalfStepsWithSign);

        if (numHalfSteps == 0) {
            return IntervalQuantity.PERFECT_UNISON;
        } else if (numHalfSteps % 12 == 1) {
            return IntervalQuantity.MINOR_SECOND;
        } else if (numHalfSteps % 12 == 2) {
            return IntervalQuantity.MAJOR_SECOND;
        } else if (numHalfSteps % 12 == 3) {
            return IntervalQuantity.MINOR_THIRD;
        } else if (numHalfSteps % 12 == 4) {
            return IntervalQuantity.MAJOR_THIRD;
        } else if (numHalfSteps % 12 == 5) {
            return IntervalQuantity.PERFECT_FOURTH;
        } else if (numHalfSteps % 12 == 6) {
            return IntervalQuantity.AUGMENTED_FOURTH;
        } else if (numHalfSteps % 12 == 7) {
            return IntervalQuantity.PERFECT_FIFTH;
        } else if (numHalfSteps % 12 == 8) {
            return IntervalQuantity.MINOR_SIXTH;
        } else if (numHalfSteps % 12 == 9) {
            return IntervalQuantity.MAJOR_SIXTH;
        } else if (numHalfSteps % 12 == 10) {
            return IntervalQuantity.MINOR_SEVENTH;
        } else if (numHalfSteps % 12 == 11) {
            return IntervalQuantity.MAJOR_SEVENTH;
        } else if (numHalfSteps % 12 == 0) {
            return IntervalQuantity.PERFECT_OCTAVE;
        } else {
            throw new Modulo7BadIntervalException("No interval associated with half step distance " + numHalfSteps);
        }
    }

    /**
     * Basic getter for interval
     * @return
     */
    public IntervalQuantity getIntervalQuantity() {
        return interval;
    }

    /**
     * Getter for interval type
     * @return
     */
    public IntervalType getIntervalType() {
        return type;
    }

    /**
     * Basic getter for interval type
     * @return
     */
    public IntervalType getType() {
        return type;
    }

    /**
     * Get interval between current and next voice instant
     *
     * If the instant is a chord the root note is ascertained as interval is
     * calculated with respect to that note
     *
     * @param thisInstant
     * @param thatInstant
     *
     * @throws Modulo7WrongNoteType
     * @throws Modulo7BadIntervalException
     *
     * @return
     */
    public static Interval getInterval(final VoiceInstant thisInstant, final VoiceInstant thatInstant)
            throws Modulo7WrongNoteType, Modulo7BadIntervalException {

        final Note firstNote;

        if (thisInstant.isChord()) {
            firstNote = ChordQuality.getRootNoteFromChord(thatInstant.getAllNotesofInstant());
        } else {
            firstNote = thisInstant.getNote();
        }

        final Note secondNote;

        if (thatInstant.isChord()) {
            secondNote = ChordQuality.getRootNoteFromChord(thatInstant.getAllNotesofInstant());
        } else {
            secondNote = thatInstant.getNote();
        }

        return Interval.getInterval(firstNote, secondNote);
    }
}

