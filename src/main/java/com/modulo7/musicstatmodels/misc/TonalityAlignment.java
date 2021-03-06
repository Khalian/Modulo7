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

    // Maximal alignment noticed
    private int maxContiguousTonalCommonality;

    /**
     * Default constructor
     * @param firstStr
     * @param secondStr
     * @param maxContiguousTonalCommonality
     */
    public TonalityAlignment(String firstStr, String secondStr, final int maxContiguousTonalCommonality) {
        this.firstStr = firstStr;
        this.secondStr = secondStr;
        this.maxContiguousTonalCommonality = maxContiguousTonalCommonality;
    }

    /**
     * Displays the alignment as determined by an alignment algorithm
     */
    public void displayAlignment() {
        System.out.println("The alignment is displayed below");
        System.out.println(firstStr);
        System.out.println(secondStr);
        System.out.println("The maximal contiguous alignment score" + maxContiguousTonalCommonality);
    }
}
