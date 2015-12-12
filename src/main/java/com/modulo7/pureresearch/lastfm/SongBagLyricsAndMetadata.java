package com.modulo7.pureresearch.lastfm;

import com.modulo7.pureresearch.musicmatch.BagOfWordsDataElement;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by asanyal on 11/9/15.
 *
 * Song similarity set for an individual entry
 */
public class SongBagLyricsAndMetadata implements Serializable {

    // The set of the songs (IDs and similarity values together)
    private Set<SongSimilarityElement> similarSet = new HashSet<>();

    // Tags for a given song
    private Map<String, Integer> tags = new HashMap<>();

    // The name of the artist associated with this song
    private String artist;

    // The last fm track ID
    private String trackID;

    // Title of the song
    private String songTitle;

    // The bag of words representation of a song
    private BagOfWordsDataElement bagOfWords;

    /**
     * Default constructor
     *
     * @param artist
     * @param trackID
     * @param songTitle
     */
    public SongBagLyricsAndMetadata(final String artist, final String trackID, final String songTitle) {
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
     * Puts a tag element
     * @param key
     * @param value
     */
    public void addTagElem(final String key, final Integer value) {
        tags.put(key, value);
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

    /**
     * Associate a bag of words element with a music meta data element
     * @param element
     */
    public void addBagOfWords(final BagOfWordsDataElement element) {
        this.bagOfWords = element;
    }

    /**
     * Get the bag of words element for this data set
     * @return
     */
    public BagOfWordsDataElement getBagOfWords() {
        return bagOfWords;
    }

    /**
     * Method to return all tags
     * @return
     */
    public Map<String, Integer> getTags() {
        return tags;
    }

}
