package com.modulo7.nlp;

import com.modulo7.common.exceptions.Modulo7InvalidFileOperationExeption;
import com.modulo7.common.exceptions.Modulo7ParseException;
import com.modulo7.common.utils.Modulo7Globals;
import org.apache.lucene.queryparser.classic.ParseException;

import java.io.*;

/**
 * Created by asanyal on 8/17/15.
 *
 * The lyrics class is the modulo7 representation of the lyrics of a song
 *
 * A lyrics object can live independently of the song object or a part of it
 * depending on the parsing from sources (if normal text files are provided for indexing
 * then lyrics are standalone objects
 */
public class Lyrics implements Serializable {

    // Name of the song
    private String songName = Modulo7Globals.UNKNOWNSTRING;

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
     * @param songName
     * @param artist
     * @param album
     * @param lyricsOfSong
     */
    public Lyrics(final String songName, final String artist, final String album, final String lyricsOfSong) {
        this.songName = songName;
        this.artist = artist;
        this.albumName = album;
        this.lyricsOfSong = lyricsOfSong;
    }

    /**
     * Basic constructor with the songname and lyrics of the song known beforehand
     * and params like artist and album name are unknown
     * @param songName
     * @param lyricsOfSong
     */
    public Lyrics(final String songName, final String lyricsOfSong) {
        this.songName = songName;
        this.lyricsOfSong = lyricsOfSong;
    }

    /**
     * Lyrics object parsed from file
     *
     * @param artist
     * @param albumName
     * @param fileLyrics
     *
     * @throws Modulo7InvalidFileOperationExeption
     * @throws Modulo7ParseException
     */
    public Lyrics(final String artist, final String albumName, final File fileLyrics) throws Modulo7InvalidFileOperationExeption, Modulo7ParseException {

        try {
            FileInputStream fstream = new FileInputStream(fileLyrics);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

            StringBuilder lyricsInSingleLine = new StringBuilder();
            String lyricsLine;

            //Read File Line By Line and parse the lyrics
            while ((lyricsLine = br.readLine()) != null) {
                //lyricsInSingleLine += lyricsLine + PHRASETERM;
                lyricsInSingleLine.append(lyricsLine);
                lyricsInSingleLine.append(PHRASETERM);
            }

            br.close();

            this.artist = artist;
            this.albumName = albumName;

            // Introducing basic stemming into lyrics object, removing redundant words
            this.lyricsOfSong = NLPUtils.stemmer(lyricsInSingleLine.toString());
        } catch (IOException ie) {
            throw new Modulo7InvalidFileOperationExeption(ie.getMessage());
        } catch (ParseException e) {
           throw new Modulo7ParseException(e);
        }
    }

    /**
     * Basic getter for artist
     * @return
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Basic getter for album
     * @return
     */
    public String getAlbumName() {
        return albumName;
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

    public String getSongName() {
        return songName;
    }
}
