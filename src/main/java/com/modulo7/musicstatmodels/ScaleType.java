package com.modulo7.musicstatmodels;

/**
 * Created by asanyal on 6/29/2015.
 *
 * Different types of scales that in existence in western music.
 *
 * Major Scale :
 */
public enum ScaleType {

    MAJOR("MAJOR"),
    MINOR("MINOR"),
    BLUES("BLUES"),
    MINOR_PENTATONIC("MINOR PENTATONIC"),
    MAJOR_PENTATONIC("MAJOR PENTATONIC");

    private final String scale;

    ScaleType(String scale) {
        this.scale = scale.toUpperCase();
    }
}
