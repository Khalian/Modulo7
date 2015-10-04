package com.modulo7.musicstatmodels.musictheorymodels;

/**
 * A declaration of all the intervals present in western music theory
 */
public enum IntervalQuantity {

    PERFECT_UNISON(0),
    MINOR_SECOND(1),
    MAJOR_SECOND(2),
    MINOR_THIRD(3),
    MAJOR_THIRD(4),
    PERFECT_FOURTH(5),
    AUGMENTED_FOURTH(6),
    DIMINISHED_FIFTH(6),
    PERFECT_FIFTH(7),
    AUGMENTED_FIFTH(8),
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

    // The number of distinct intervals that are present in the interval
    private static final int NUMBER_OF_DISTINCT_INTERVALS = 12;

    /**
     * Basic constructor with only interval quantity
     * @param intervalQuantity
     */
    IntervalQuantity(final int intervalQuantity) {
        this.intervalQuantity = intervalQuantity;
        inferIntervalQuality();
    }

    /**
     * Infer the interval Quality given the quantity
     */
    private void inferIntervalQuality() {
        if (intervalQuantity == 1 ||
                intervalQuantity == 3 ||
                intervalQuantity == 8 ||
                intervalQuantity == 10) {

            intervalQuality = IntervalQuality.MINOR;
        } else if (intervalQuantity == 2 ||
                    intervalQuantity == 4 ||
                    intervalQuantity == 9 ||
                    intervalQuantity == 11) {

            intervalQuality = IntervalQuality.MAJOR;
        } else if (intervalQuantity == 0 ||
                   intervalQuantity == 5 ||
                   intervalQuantity == 7 ||
                   intervalQuantity == 12) {
            intervalQuality = IntervalQuality.PERFECT;
        } else if (intervalQuantity == 6) {
            intervalQuality = IntervalQuality.AUGMENTED;
        }
    }

    /**
     * Getter for interval quantity
     * @return
     */
    public int getQuantity() {
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
