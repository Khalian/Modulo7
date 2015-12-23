package com.modulo7.pureresearch.metadataestimation;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by asanyal on 12/22/15.
 *
 * For a given track id, get the annotated list of genres
 */
public class GenreLabels implements Serializable {

    // Track id for particular track
    private String trackId;

    // List of genres that particular track belongs to
    private Set<String> genreList;

    /**
     * Default constructor
     *
     * @param trackId
     * @param genreList
     */
    public GenreLabels(final String trackId, final Set<String> genreList) {
        this.trackId = trackId;
        this.genreList = genreList;
    }

    /**
     * Get track ID
     * @return
     */
    public String getTrackId() {
        return trackId;
    }

    /**
     * Get genre list for this particular
     * @return
     */
    public Set<String> getGenreList() {
        return genreList;
    }
}
