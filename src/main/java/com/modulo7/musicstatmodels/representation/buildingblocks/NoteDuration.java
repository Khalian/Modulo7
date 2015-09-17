package com.modulo7.musicstatmodels.representation.buildingblocks;

/**
 * Created by asanyal on 8/31/15.
 *
 * A mathematically precise duration element
 *
 * If a voice instant contains this element, its a more precise
 * representation than what is actually played (the double duration element)
 *
 * Information taken from http://www.musicxml.com/UserManuals/MusicXML/Content/ST-MusicXML-note-type-value.htm
 */
public enum NoteDuration {
    WHOLE,
    HALF,
    QUARTER,
    EIGHTH,
    SIXTEENTH,
    THIRTYSECOND,
    SIXTYFOURTH,
    UNKNOWN;

    NoteDuration() {

    }

    /**
     * Static getter for note duration element from the note duration string argument
     *
     * Ususally found in Music XML files
     *
     * @param noteDuration
     * @return
     */
    public static NoteDuration getNoteDurationFromMusicXML(final String noteDuration) {
        if (noteDuration.equalsIgnoreCase("whole"))
            return WHOLE;
        else if (noteDuration.equalsIgnoreCase("half"))
            return HALF;
        else if (noteDuration.equalsIgnoreCase("quarter"))
            return QUARTER;
        else if (noteDuration.equalsIgnoreCase("eighth"))
            return EIGHTH;
        else if (noteDuration.equalsIgnoreCase("16th"))
            return SIXTEENTH;
        else if (noteDuration.equalsIgnoreCase("32nd"))
            return THIRTYSECOND;
        else if (noteDuration.equalsIgnoreCase("64th"))
            return SIXTYFOURTH;
        else
            return UNKNOWN;
    }
}
