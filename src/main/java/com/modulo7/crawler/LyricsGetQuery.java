package com.modulo7.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by asanyal on 7/12/2015.
 *
 * Class to acquire the lyrics of a given song via Lyric Wiki Rest Interface
 */
public class LyricsGetQuery {

    // A basic string
    private static final String LYRICS_GET_REQUEST =
            "http://lyrics.wikia.com/api.php?func=getSong&artist=ARGARTIST&song=ARGSONG&fmt=xml";

    private static final String DISCOGRAPHY_GET_REQUEST =
            "http://lyrics.wikia.com/api.php?func=getArtist&artist=ARGARTIST";

    /**
     * Method to get the lyrics of a song
     */
    private void getLyrics(final String artistName, final String songName) {
        String getQuery = LYRICS_GET_REQUEST;
        getQuery = getQuery.replace("ARGARTIST", artistName);
        getQuery = getQuery.replace("ARGSONG", songName);

        try {
            Document doc = Jsoup.connect(getQuery).get();
            System.out.println(doc);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to get URLS to list of songs for a given artist
     * @param artistName
     */
    private void getDiscoGraphy(final String artistName) {
        String getQuery = DISCOGRAPHY_GET_REQUEST;
        getQuery = getQuery.replace("ARGARTIST", artistName);

        Document doc = null;
        try {
            doc = Jsoup.connect(getQuery).get();
            System.out.println(doc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Running test cases right now in Main
     *
     * TODO : Fix this by including new method for testing
     * @param args
     */
    public static void main(String args[]) {
        LyricsGetQuery getQuery = new LyricsGetQuery();
        getQuery.getLyrics("Dime", "Cake");
        getQuery.getDiscoGraphy("Led_Zepplin");
    }
}
