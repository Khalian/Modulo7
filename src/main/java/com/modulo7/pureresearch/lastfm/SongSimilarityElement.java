package com.modulo7.pureresearch.lastfm;

/**
 * Created by asanyal on 11/9/15.
 *
 * An element of song similarity
 */
public class SongSimilarityElement {

    // Similarity value
    private double similarityValue;

    // Song ID
    private String songID;

    /**
     * Default constructor for element
     * @param songID
     * @param similarityValue
     */
    public SongSimilarityElement(final String songID, final double similarityValue) {
        this.songID = songID;
        this.similarityValue = similarityValue;
    }

    /**
     * Gets the similarity value
     * @return
     */
    public double getSimilarityValue() {
        return similarityValue;
    }

    /**
     * Gets the song id for a given song
     * @return
     */
    public String getSongID() {
        return songID;
    }
}
