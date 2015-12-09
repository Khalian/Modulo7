package com.modulo7.crawler.datacrawler;

import com.modulo7.common.exceptions.Modulo7InvalidFileOperationException;
import com.modulo7.common.exceptions.Modulo7ParseException;
import com.modulo7.common.utils.Modulo7Globals;
import com.modulo7.common.utils.Modulo7Utils;
import com.modulo7.nlp.lyrics.Lyrics;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Lyrics gatherer given a band and a song Title get the lyrics of a song
 */
public class LyricsGatherer {

    private final static String songLyricsURL = "http://www.songlyrics.com";

    /**
     * Gets the song lyrics for a given band
     * @param artist
     * @param songTitle
     * @return
     * @throws IOException
     */
    public static Lyrics getSongLyrics(final String artist, final String songTitle) throws IOException, Modulo7InvalidFileOperationException, Modulo7ParseException {
        StringBuilder lyricsConcat = new StringBuilder();
        final Document doc = Jsoup.connect(songLyricsURL+ "/" + artist.replace(" ", "-").toLowerCase()+"/"
                + songTitle.replace(" ", "-").toLowerCase()+"-lyrics/").get();
        Element p = doc.select("p.songLyricsV14").get(0);
        lyricsConcat.append(p.childNodes().stream().filter(e -> e instanceof TextNode).map(e -> ((TextNode) e).getWholeText()).collect(Collectors.toList()));
        return new Lyrics(songTitle, artist, Modulo7Globals.UNKNOWNSTRING, lyricsConcat.toString());
    }

    public static void main(String[] args) throws IOException, Modulo7InvalidFileOperationException, Modulo7ParseException {
        System.out.println(LyricsGatherer.getSongLyrics("U2", "With or Without You"));
        System.out.println(LyricsGatherer.getSongLyrics("Billy Joel", "Allentown"));
        System.out.println(LyricsGatherer.getSongLyrics("Tori Amos", "Winter"));
    }
}
