package com.modulo7.pureresearch.lastfm;

import com.modulo7.musicstatmodels.representation.polyphonic.Song;

/**
 * Created by asanyal on 12/26/15.
 *
 * A super class containing song meta data, lyrics bag of words and the song object
 * bundled into one super object
 */
public class SongTotalMeta {

    // Song object
    private Song song;

    // Its corresponding meta data
    private SongBagLyricsAndMetadata metadata;

    public SongTotalMeta(final Song song, final SongBagLyricsAndMetadata metadata) {
        this.song = song;
        this.metadata = metadata;
    }
}
