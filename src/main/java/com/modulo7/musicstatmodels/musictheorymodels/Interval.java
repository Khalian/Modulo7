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
            intervalType = IntervalType.DESCENDING;
        } else {
            intervalType = IntervalType.ASCENDING;
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
}

/**
 * A declaration of all the intervals present in western music theory
 */
enum IntervalEnum {
    
    PERFECT_UNISON(0),
    MINOR_SECOND(1),
    MAJOR_SECOND(2),
    MINOR_THIRD(3),
    MAJOR_THIRD(4),
    PERFECT_FOURTH(5),
    AUGMENTED_FOURTH(6),
    PERFECT_FIFTH(7),
    MINOR_SIXTH(8),
    MAJOR_SIXTH(9),
    MINOR_SEVENTH(10),
    MAJOR_SEVENTH(11),
    PERFECT_OCTAVE(12);

    // The octave associated with this node
    private int intervalQuantity;

    // The interval quality associated with the 
    private IntervalQuality intervalQuality;

    // The interval type associated with this interval
    private IntervalType intervalType;

    /**
     * Basic constructor with only interval quantity
     * @param intervalQuantity
     */
    IntervalEnum(final int intervalQuantity) {
        this.intervalQuantity = intervalQuantity;
        inferIntervalQuality();
    }

    /**
     * Infer the interval Quality given the quantity
     */
    private void inferIntervalQuality() {
        if (intervalQuantity == MINOR_SECOND.getIntervalQuantity() ||
                intervalQuantity == MINOR_THIRD.getIntervalQuantity() ||
                intervalQuantity == MINOR_SIXTH.getIntervalQuantity() ||
                intervalQuantity == MINOR_SEVENTH.getIntervalQuantity()) {

            intervalQuality = IntervalQuality.MINOR;
        } else if (intervalQuantity == MAJOR_SECOND.getIntervalQuantity() ||
                    intervalQuantity == MAJOR_THIRD.getIntervalQuantity() ||
                    intervalQuantity == MAJOR_SIXTH.getIntervalQuantity() ||
                    intervalQuantity == MAJOR_SEVENTH.getIntervalQuantity()) {

            intervalQuality = IntervalQuality.MAJOR;
        } else if (intervalQuantity == PERFECT_UNISON.getIntervalQuantity() ||
                   intervalQuantity == PERFECT_FOURTH.getIntervalQuantity() ||
                   intervalQuantity == PERFECT_FIFTH.getIntervalQuantity() ||
                   intervalQuantity == PERFECT_OCTAVE.getIntervalQuantity()) {
            intervalQuality = IntervalQuality.PERFECT;
        } else if (intervalQuantity == AUGMENTED_FOURTH.getIntervalQuantity()) {
            intervalQuality = IntervalQuality.AUGMENTED;
        }
    }

    /**
     * Getter for interval quantity
     * @return
     */
    public int getIntervalQuantity() {
        return intervalQuantity;
    }

    /**
     * Getter for interval quality
     * @return
     */
    public IntervalQuality getIntervalQuality() {
        return intervalQuality;
    }

    /**
     * Gets the interval type of this interval
     * @return
     */
    public IntervalType getIntervalType() {
        return intervalType;
    }
}
