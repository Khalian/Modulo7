package com.modulo7.musicstatmodels.representation;

import com.modulo7.common.exceptions.Modulo7BadAccidentalException;

/**
 * Created by asanyal on 8/17/15.
 *
 * A class which represents the accidental on a note
 *
 * An accidental is a modification on the root note
 */
public enum Accidental {
    NONE,
    FLAT,
    SHARP,
    DOUBLEFLAT,
    DOUBLESHARP;

    // Empty constructor for the accidental
    Accidental() {

    }

    /**
     * Static method to acquire the delta from a base note given the type of accidental
     *
     * @param accidental
     * @return
     * @throws com.modulo7.common.exceptions.Modulo7BadAccidentalException
     */
    public static int getPositionDelta(Accidental accidental) throws Modulo7BadAccidentalException {
        if (accidental.equals(Accidental.NONE))
            return 0;
        else if (accidental.equals(Accidental.FLAT))
            return -1;
        else if (accidental.equals(Accidental.SHARP))
            return 1;
        else if (accidental.equals(Accidental.DOUBLEFLAT))
            return -2;
        else if (accidental.equals(Accidental.DOUBLESHARP))
            return 2;
        else
            throw new Modulo7BadAccidentalException("Bad accidental value passed");

    }
}
