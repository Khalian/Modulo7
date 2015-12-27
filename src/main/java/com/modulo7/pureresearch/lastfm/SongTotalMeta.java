package com.modulo7.pureresearch.lastfm;

import com.modulo7.musicstatmodels.representation.polyphonic.Song;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by asanyal on 12/26/15.
 *
 * A super class containing song meta data, lyrics bag of words and the song object
 * bundled into one super object
 */
public class SongTotalMeta implements Serializable {

    // Song object
    private Song song;

    // Its corresponding meta data
    private SongBagLyricsAndMetadata metadata;

    // The genres associated with this song
    private Set<String> genres;

    /**
     * Default constructor for song total meta
     * @param song
     * @param metadata
     */
    public SongTotalMeta(final Song song, final SongBagLyricsAndMetadata metadata) {
        this.song = song;
        this.metadata = metadata;
    }

    /**
     * Getter for song object
     * @return
     */
    public Song getSong() {
        return song;
    }

    /**
     * Getter for meta data
     * @return
     */
    public SongBagLyricsAndMetadata getMetadata() {
        return metadata;
    }

    /**
     * Add the genres to meta
     * @param genres
     */
    public void addGenres(final Set<String> genres) {
        this.genres = genres;
    }

    /**
     * Getter for genres
     * @return
     */
    public Set<String> getGenres() {
        return genres;
    }
}
