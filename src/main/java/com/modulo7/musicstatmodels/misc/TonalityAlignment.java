package com.modulo7.musicstatmodels.misc;

/**
 * Created by asanyal on 1/2/16.
 *
 * A class which dictates the members of the tonality alignment concept
 * (An example of which would be the smith waterman algorithm)
 */
public class TonalityAlignment {

    // One string
    private String firstStr;

    // Other string
    private String secondStr;

    /**
     * Default constructor
     * @param firstStr
     * @param secondStr
     */
    public TonalityAlignment(String firstStr, String secondStr) {
        this.firstStr = firstStr;
        this.secondStr = secondStr;
    }

    /**
     * Displays the alignment as determined by an alignment algorithm
     */
    public void displayAlignment() {
        System.out.println(firstStr);
        System.out.println(secondStr);
    }
}
