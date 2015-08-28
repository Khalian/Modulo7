package com.modulo7.nlp;

import java.io.*;

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

    // A specialized term for denoting terminating phrases, useful for acquring other pieces
    // of analysis like acquiring the lyrical structure
    private static final String PHRASETERM = " PHRASETERM ";

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
     * Lyrics object parsed from file
     *
     * @param artist
     * @param albumName
     * @param fileLyrics
     */
    public Lyrics(final String artist, final String albumName, final File fileLyrics) throws IOException {

        FileInputStream fstream = new FileInputStream(fileLyrics);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String lyricsInSingleLine = "";
        String lyricsLine;

        //Read File Line By Line
        while ((lyricsLine = br.readLine()) != null)   {
            lyricsInSingleLine += lyricsLine + PHRASETERM;
        }

        //Close the input stream
        br.close();

        this.artist = artist;
        this.albumName = albumName;
        this.lyricsOfSong = lyricsInSingleLine;
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
