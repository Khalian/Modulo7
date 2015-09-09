package com.modulo7.nlp;

import com.modulo7.musicstatmodels.representation.Note;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by asanyal on 9/1/15.
 *
 * This class can be used to create a string representation of
 * the input
 *
 * TODO : Finish this implementation
 *
 */
public class Modulo7SongTokenization {

    private Map<Note, String> noteTokenMapping = new HashMap<>();

    // A singleton instance of the note map
    private static Modulo7SongTokenization tokenizationMap = null;

    /**
     * Method to acquire the singleton instance of the note map class
     * @return
     */
    public static Modulo7SongTokenization getInstance() {
        if (tokenizationMap == null) {
            tokenizationMap = new Modulo7SongTokenization();
        }

        return tokenizationMap;
    }

    /**
     * Init constructor for the note map
     */
    private Modulo7SongTokenization() {

    }
}
