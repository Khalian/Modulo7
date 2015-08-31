package com.modulo7.musicstatmodels.representation;

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
    BLUES("BLUES"),
    MINOR_PENTATONIC("MINOR PENTATONIC"),
    MAJOR_PENTATONIC("MAJOR PENTATONIC"),
    UNKNOWN("UNKNOWN");

    private final String scale;

    ScaleType(final String scale) {
        this.scale = scale.toUpperCase();
    }
}
