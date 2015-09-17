package com.modulo7.engine;

/**
 * Created by asanyal on 9/17/15.
 *
 * The set of choices that are present for Modulo7
 */
public enum Modulo7CLIChoices {

    RET_SONGS_FOR_GIVEN_ARTIST(1),
    RET_SONGS_FOR_GIVEN_KEY_SIGNATURE(2),
    RET_SONGS_FOR_GIVEN_TIME_SIGNATURE(3),
    RET_LYRICS_GIVEN_SONG(4),
    LIST_NUM_SONGS_INDEXED(5),
    INPUT_CUSTOM_QUERY(6),
    EXIT(7);

    int choice;

    Modulo7CLIChoices(int choice) {
        this.choice = choice;
    }

    Modulo7CLIChoices() {

    }
}