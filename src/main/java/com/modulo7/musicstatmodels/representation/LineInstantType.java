package com.modulo7.musicstatmodels.representation;

/**
 * Created by asanyal on 6/16/2015.
 *
 * Expressing the type of an instant of a line within a song
 *
 * two types exist, either a single frequency is played at that moment
 * or an set of notes being stacked on top of each other (called a chord)
 */
public enum LineInstantType {
    SINGLE_NOTE,
    CHORD
}
