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
 * or can be 
 */
public class Line {

    // A line sequence is the sequence of line instances
    // That are being played
    private List<LineInstant> lineSequence;

    // Member indicating how
    private double totalLineDuration;

    /**
     * Basic constructor for line instants
     * @param lineSequence
     */
    public Line(List<LineInstant> lineSequence) {
        this.lineSequence = lineSequence;
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
     * @param instant
     */
    public void addLineInstant(LineInstant instant) {
        lineSequence.add(instant);
    }
}
