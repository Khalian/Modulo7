package com.modulo7.pureresearch.lastfm;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by asanyal on 11/9/15.
 *
 * Song similarity set for an individual entry
 */
public class SongSimilaritySet {

    // The set of the songs (IDs and similarity values together)
    private Set<SongSimilarityElement> similarSet = new HashSet<>();

    // The name of the artist associated with this song
    private String artist;

    // The last fm track ID
    private String trackID;

    // Title of the song
    private String songTitle;

    /**
     * Default constructor
     *
     * @param artist
     * @param trackID
     * @param songTitle
     */
    public SongSimilaritySet(final String artist, final String trackID, final String songTitle) {
        this.artist = artist;
        this.trackID = trackID;
        this.songTitle = songTitle;
    }

    /**
     * Check for the set of similar elements
     * @param element
     */
    public void addSongSimilarityElement(final SongSimilarityElement element) {
        similarSet.add(element);
    }

    /**
     * Gets the artist
     * @return
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Getter for track ID
     * @return
     */
    public String getTrackID() {
        return trackID;
    }

    /**
     * Getter for song title
     * @return
     */
    public String getSongTitle() {
        return songTitle;
    }
}
