package com.modulo7.nlp;

/**
 * Created by asanyal on 8/17/15.
 *
 * The lyrics class is the modulo7 representation of the lyrics of a song
 */
public class Lyrics {

    // The name of the artist
    private String artist;

    // The name of the album from which this song is played
    private String albumName;

    // String representation of the lyrics of a song
    private String lyricsOfSong;

    /**
     * Basic constructor for the lyrics of the song
     *
     * @param artist
     * @param album
     * @param lyricsOfSong
     */
    public Lyrics(final String artist, final String album, final String lyricsOfSong) {
        this.artist = artist;
        this.albumName = album;
        this.lyricsOfSong = lyricsOfSong;
    }

    /**
     * Gets the artist name for this lyrics object
     * @return
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Gets the album name for this lyrics object
     * @return
     */
    public String getAlbumName() {
        return albumName;
    }

    /**
     * Gets the actual lyrics content
     * @return
     */
    public String getLyricsOfSong() {
        return lyricsOfSong;
    }
}
