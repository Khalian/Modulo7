package com.modulo7.musicstatmodels.representation.metadata;

import com.modulo7.common.exceptions.Modulo7BadIntervalException;
import com.modulo7.common.exceptions.Modulo7BadKeyException;
import com.modulo7.common.exceptions.Modulo7BadNoteException;
import com.modulo7.common.utils.FrequencyNoteMap;
import com.modulo7.common.utils.Modulo7Globals;
import com.modulo7.musicstatmodels.musictheorymodels.Interval;
import com.modulo7.musicstatmodels.musictheorymodels.IntervalEnum;
import com.modulo7.musicstatmodels.representation.buildingblocks.Note;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by asanyal on 7/25/2015.
 *
 * The key signature of the songo
 *
 * The key signature of the song recoginizes
 */
public class KeySignature {

    // The key of the key signature
    private String key = Modulo7Globals.UNKNOWNSTRING;

    // The scale associated with the key signature
    private ScaleType scale = ScaleType.UNKNOWN;

    // Available keys in western music theory
    private static final Set westernKeys =
            new HashSet<>(Arrays.asList(Modulo7Globals.NOTE_NAMES));

    // Frequency note map distance
    private static final FrequencyNoteMap noteMap = FrequencyNoteMap.getInstance();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KeySignature)) return false;

        KeySignature signature = (KeySignature) o;

        if (!key.equals(signature.key)) return false;
        return scale == signature.scale;

    }

    @Override
    public int hashCode() {
        int result = key.hashCode();
        result = 31 * result + scale.hashCode();
        return result;
    }

    public KeySignature() {

    }

    /**
     * The key and song of the key signature
     *
     * @param key
     * @param scale
     */
    public KeySignature(final String key, final ScaleType scale) throws Modulo7BadKeyException {
        // Check for bad key
        if (!KeySignature.westernKeys.contains(key)) {
            throw new Modulo7BadKeyException("Bad key : " + key + " Please init with valid key for key signature");
        }

        this.key = key.toUpperCase();
        this.scale = scale;
    }

    /**
     * A getter for the scale
     * @return
     */
    public ScaleType getScale() {
        return scale;
    }

    /**
     * A getter for the key
     * @return
     */
    public String getKey() {
        return key;
    }

    /**
     * Get the intervalic distant thiskey and thatkey
     * @param thisKey
     * @param thatKey
     * @return
     * @throws Modulo7BadNoteException
     * @throws Modulo7BadIntervalException
     */
    public static IntervalEnum getIntervalicDistance(final KeySignature thisKey, final KeySignature thatKey)
            throws Modulo7BadNoteException, Modulo7BadIntervalException {
        final String thisKeyValue = thisKey.getKey();
        final String thatKeyValue = thatKey.getKey();

        final Note thisNote = Note.getNoteValue(thatKeyValue, 4);
        final Note thatNote = Note.getNoteValue(thatKeyValue, 4);

        return Interval.getInterval(thatNote, thatNote).getIntervalEnum();
    }
}
