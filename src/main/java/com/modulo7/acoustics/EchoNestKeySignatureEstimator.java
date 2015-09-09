package com.modulo7.acoustics;

import com.modulo7.common.exceptions.Modulo7BadKeyException;
import com.modulo7.common.utils.Modulo7Globals;
import com.modulo7.musicstatmodels.representation.KeySignature;
import com.modulo7.musicstatmodels.representation.ScaleType;

/**
 * Created by asanyal on 9/9/15.
 *
 * Helper class for estimation for key signature
 */
public class EchoNestKeySignatureEstimator {

    /**
     * Helper method for acquiring key signature from a song
     * @param key
     * @param mode
     * @return
     * @throws Modulo7BadKeyException
     */
    public static KeySignature estimateKeySignature(final int key, final int mode) throws Modulo7BadKeyException {

        if (key == -1 || mode == -1) {
            return null;
        }

        // Type of scale
        final ScaleType scaleType;

        if (mode == 1) {
            scaleType = ScaleType.MAJOR;
        } else if (mode == 0) {
            scaleType = ScaleType.MINOR;
        } else {
            scaleType = ScaleType.UNKNOWN;
        }

        final String keyStringRep = Modulo7Globals.NOTE_NAMES[(key + 3) % Modulo7Globals.NOTE_NAMES.length];

        return new KeySignature(keyStringRep, scaleType);
    }
}
