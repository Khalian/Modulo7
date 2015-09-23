package com.modulo7.musicstatmodels.representation.metadata;

/**
 * Created by asanyal on 6/29/2015.
 *
 * Different types of scales that in existence in western music.
 *
 * Major Scale : Standard major scale, also called the happy sounding scale
 */
public enum ScaleType {

    MAJOR("MAJOR"),
    MINOR("MINOR"),
    UNKNOWN("UNKNOWN");

    private final String scale;

    ScaleType(final String scale) {
        this.scale = scale.toUpperCase();
    }

    /**
     * Gets the scale type given a string representation
     * @param inputStr
     * @return
     */
    public static ScaleType getScaleTypeFromString(final String inputStr) {
        String actualStr = inputStr.toUpperCase();

        if (actualStr.equals("MAJOR") || actualStr.equals("MAJ")) {
            return MAJOR;
        } else if (actualStr.equals("MINOR") || actualStr.equals("MIN")) {
            return MINOR;
        } else {
            return UNKNOWN;
        }
    }
}
