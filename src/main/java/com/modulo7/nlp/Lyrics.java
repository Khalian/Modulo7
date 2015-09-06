package com.modulo7.nlp;

import com.modulo7.common.utils.Modulo7Globals;

import java.io.*;

/**
 * Created by asanyal on 8/17/15.
 *
 * The lyrics class is the modulo7 representation of the lyrics of a song
 */
public class Lyrics {

    // The name of the artist
    private String artist = Modulo7Globals.UNKNOWNSTRING;

    // The name of the album from which this song is played
    private String albumName = Modulo7Globals.UNKNOWNSTRING;

    // String representation of the lyrics of a song
    private String lyricsOfSong = Modulo7Globals.UNKNOWNSTRING;

    // A specialized term for denoting terminating phrases, useful for acquring other pieces
    // of analysis like acquiring the lyrical structure
    private static final String PHRASETERM = " PHRASETERM ";

    /**
     * Default constructor
     */
    public Lyrics() {

    }

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
     * Basic getter for artist
     * @return
     */
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     * Basic getter for album
     * @return
     */
    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    /**
     * Basic getter for lyrics
     * @return
     */
    public String getLyricsOfSong() {
        return lyricsOfSong;
    }

    /**
     * Adds a string element to a lyrics object
     * @param lyricsElem
     */
    public void addLyricsElementToSong(final String lyricsElem) {
        if (lyricsOfSong.equals(Modulo7Globals.UNKNOWNSTRING)) {
            lyricsOfSong = lyricsElem;
        } else {
            lyricsOfSong += lyricsElem + " ";
        }
    }
}
