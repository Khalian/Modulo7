package com.modulo7.musicstatmodels.musictheorymodels;


import com.modulo7.common.exceptions.Modulo7InvalidCircleOfFifthsDistance;
import com.modulo7.musicstatmodels.representation.ScaleType;
import org.apache.commons.collections.Buffer;
import org.apache.commons.collections.BufferUtils;
import org.apache.commons.collections.buffer.CircularFifoBuffer;

import java.util.Iterator;

/**
 * Created by asanyal on 8/9/15.
 *
 * This class is a representation of the circle of fifths used commonly in music theory
 *
 * The circle of fifths is a handy reference for key signatures and denote the number of flats
 * or sharps that are present in various keys
 *
 * TODO: Finish this implementation
 */
public class CircleOfFifths {

    // The number of elements in the circle of fifths description
    private static final int CIRCLE_OF_FIFTHS_NUM_ELEMS = 8;

    // A circular fifo queue which stores the intel about the cirle of fifths information
    private static final Buffer circleOfFifthsElementClockwise =
            BufferUtils.synchronizedBuffer(new CircularFifoBuffer(CIRCLE_OF_FIFTHS_NUM_ELEMS));

    // A circular fifo queue which stores the intel about the cirle of fifths information
    private static final Buffer circleOfFifthsElementAntiClockwise =
            BufferUtils.synchronizedBuffer(new CircularFifoBuffer(CIRCLE_OF_FIFTHS_NUM_ELEMS));

    // Init the circle of fifths as a static init
    static {
        // Circle of fifths keys in ascending order to accomodate for sharps
        circleOfFifthsElementClockwise.add("C");
        circleOfFifthsElementClockwise.add("G");
        circleOfFifthsElementClockwise.add("D");
        circleOfFifthsElementClockwise.add("A");
        circleOfFifthsElementClockwise.add("E");
        circleOfFifthsElementClockwise.add("B");
        circleOfFifthsElementClockwise.add("F#");
        circleOfFifthsElementClockwise.add("C#");

        // Circle of fifths in descending order to accomodate for flats
        circleOfFifthsElementAntiClockwise.add("C");
        circleOfFifthsElementAntiClockwise.add("F");
        circleOfFifthsElementAntiClockwise.add("Bb");
        circleOfFifthsElementAntiClockwise.add("Eb");
        circleOfFifthsElementAntiClockwise.add("Ab");
        circleOfFifthsElementAntiClockwise.add("Db");
        circleOfFifthsElementAntiClockwise.add("Gb");
        circleOfFifthsElementAntiClockwise.add("Cb");
    }

    /**
     * Gets the key given the fifth distance from root in the cirle of fifths
     *
     * @param scaleType
     * @return
     */
    public static String getKeyGivenFifthDistance(final ScaleType scaleType, final int distanceFromRoot)
            throws Modulo7InvalidCircleOfFifthsDistance {

        if (Math.abs(distanceFromRoot) > 7)
            throw new Modulo7InvalidCircleOfFifthsDistance("Distance from root " + distanceFromRoot + " is not valid, please stick to ranges 0 to 7");

        int numIterered = 0;

        // An iterator for circle of fifths
        Iterator cofIter;

        // If its major scale, process from root which is 0
        if (scaleType.equals(ScaleType.MAJOR)) {
            if (distanceFromRoot > 0) {
                cofIter = circleOfFifthsElementClockwise.iterator();
            } else {
                cofIter = circleOfFifthsElementAntiClockwise.iterator();
            }

            while (cofIter.hasNext()) {
                final String keyAtCFLoc = (String) cofIter.next();

                if (numIterered == distanceFromRoot) {
                    return keyAtCFLoc;
                } else {
                    numIterered ++;
                }
            }
        }

        return null;
    }
}
