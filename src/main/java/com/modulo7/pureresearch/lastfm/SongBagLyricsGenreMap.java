package com.modulo7.pureresearch.lastfm;

import com.modulo7.pureresearch.metadataestimation.GenreLabels;
import com.modulo7.pureresearch.musicmatch.BagOfWordsDataElement;

import java.io.Serializable;

/**
 * Created by asanyal on 12/22/15.
 *
 * An association between the lyrics of a song and its bag of words
 * lyrics format
 */
public class SongBagLyricsGenreMap implements Serializable {

    // The last fm track ID
    private String trackID;

    // The genre labels associated with the track id
    private GenreLabels labels;

    // The bag of words representation of a song
    private BagOfWordsDataElement bagOfWords;

    /**
     *
     * @param trackID
     * @param labels
     * @param bagOfWords
     */
    public SongBagLyricsGenreMap(final String trackID, final GenreLabels labels, final BagOfWordsDataElement bagOfWords) {
        this.trackID = trackID;
        this.labels = labels;
        this.bagOfWords = bagOfWords;
    }

    public String getTrackID() {
        return trackID;
    }

    public GenreLabels getLabels() {
        return labels;
    }

    public BagOfWordsDataElement getBagOfWords() {
        return bagOfWords;
    }
}
