package com.modulo7.musicstatmodels;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asanyal on 7/18/2015.
 *
 * A line is modulo7's representation of what is
 * a sequence of line instants
 *
 * A song is comprised of multiple lines. Think of a rhythm
 * guitar being played in the background or a lead guitarist going
 * through a riff. Each of those are lines.
 *
 * A song is an interplay of lines. Rules can be specific to a line
 * or can be at a song level (also called line interplay rules)
 */
public class Line {

    // A line sequence is the sequence of line instances
    // That are being played
    private List<LineInstant> lineSequence;

    // Member indicating how long the entire line was played
    private double totalLineDuration;

    /**
     * Basic constructor for line by accepting a set of line
     * instants
     *
     * @param lineSequence
     */
    public Line(final List<LineInstant> lineSequence) {
        this.lineSequence = lineSequence;
        inferTotalLineDuration();
    }

    /**
     * Infers the total line duration
     */
    private void inferTotalLineDuration() {
        totalLineDuration = 0.0;

        // Add up the line instant durations one after the other
        for (LineInstant instant : lineSequence) {
            totalLineDuration += instant.getDuration();
        }
    }

    /**
     * This form of the constuctor should be used when
     * the line is being constructor via the add LineInstant method
     *
     * This is discouraged practice if the entire line is known to the
     * crawler before hand
     */
    public Line() {
        this.lineSequence = new ArrayList<>();
    }

    /**
     * Dynamically adds a line instant to a line
     * This method should be used when modolu7 is receiving
     * a line as being composed on the spotp
     *
     * @param instant
     */
    public void addLineInstant(final LineInstant instant) {
        lineSequence.add(instant);
    }

    /**
     * Gets the total line duration for this song
     * @return
     */
    public double getTotalLineDuration() {
        return totalLineDuration;
    }
}
