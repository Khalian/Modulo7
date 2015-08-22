package com.modulo7.musicstatmodels.musictheorymodels;

import com.modulo7.common.exceptions.Modulo7BadIntervalException;
import com.modulo7.common.utils.FrequencyNoteMap;
import com.modulo7.musicstatmodels.representation.Note;

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
    private IntervalEnum interval;

    // The type of interval
    private IntervalType type;

    /**
     * Basic constructor
     * @param intervalEnum
     * @param type
     */
    private Interval(IntervalEnum intervalEnum, IntervalType type) {
        this.interval = intervalEnum;
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

        IntervalEnum intervalEnum = getInterval(Math.abs(secondPosition - firstPosition));

        return new Interval(intervalEnum, intervalType);
    }

    /**
     * Gets the interval given the number of half steps
     *
     * @param numHalfSteps
     * @return
     */
    private static IntervalEnum getInterval(final int numHalfSteps) throws Modulo7BadIntervalException {
        if (numHalfSteps % 13 == 0) {
            return IntervalEnum.PERFECT_UNISON;
        } else if (numHalfSteps % 13 == 1) {
            return IntervalEnum.MINOR_SECOND;
        } else if (numHalfSteps % 13 == 2) {
            return IntervalEnum.MAJOR_SECOND;
        } else if (numHalfSteps % 13 == 3) {
            return IntervalEnum.MINOR_THIRD;
        } else if (numHalfSteps % 13 == 4) {
            return IntervalEnum.MAJOR_THIRD;
        } else if (numHalfSteps % 13 == 5) {
            return IntervalEnum.PERFECT_FOURTH;
        } else if (numHalfSteps % 13 == 6) {
            return IntervalEnum.AUGMENTED_FOURTH;
        } else if (numHalfSteps % 13 == 7) {
            return IntervalEnum.PERFECT_FIFTH;
        } else if (numHalfSteps % 13 == 8) {
            return IntervalEnum.MINOR_SIXTH;
        } else if (numHalfSteps % 13 == 9) {
            return IntervalEnum.MAJOR_SIXTH;
        } else if (numHalfSteps % 13 == 10) {
            return IntervalEnum.MINOR_SEVENTH;
        } else if (numHalfSteps % 13 == 11) {
            return IntervalEnum.MAJOR_SEVENTH;
        } else if (numHalfSteps % 13 == 12) {
            return IntervalEnum.PERFECT_OCTAVE;
        } else {
            throw new Modulo7BadIntervalException("No interval associated with half step distance " + numHalfSteps);
        }
    }

    /**
     * Basic getter for interval
     * @return
     */
    public IntervalEnum getInterval() {
        return interval;
    }

    /**
     * Basic getter for interval type
     * @return
     */
    public IntervalType getType() {
        return type;
    }
}

