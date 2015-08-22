package com.modulo7.crawler.engine;

import com.modulo7.common.exceptions.Modulo7InvalidArgsException;
import com.modulo7.crawler.datacrawler.BasicImageCrawler;
import com.modulo7.crawler.datacrawler.BasicLyricsCrawler;
import com.modulo7.crawler.datacrawler.BasicMidiFileCrawler;
import org.apache.commons.cli.*;

import java.io.IOException;

/**
 * Created by asanyal on 7/18/2015.
 *
 * API to crawl the required music sources and
 * acquire the necessary source files
 *
 * This is the main entry point to the modulo7
 * crawling engine
 *
 */
public class CrawlMusicSources {

    // An instance of the image crawler
    private BasicImageCrawler imageCrawler;

    // An instance of the lyrics cralwer
    private BasicLyricsCrawler lyricsCrawler;

    // An instance of the midi crawler
    private BasicMidiFileCrawler midiCrawler;

    /**
     * Main entry point for the crawler engine
     *
     * @param args
     */
    public static void main(String args[]) throws Modulo7InvalidArgsException, ParseException {
        CommandLine m7CrawlerCommand = getCommand(args);

        String[] crawlerArguments = m7CrawlerCommand.getArgs();
    }

    /**
     * Basic constructor for the crawl music sources operation
     *
     * @throws IOException
     */
    private CrawlMusicSources() throws IOException {
        imageCrawler = new BasicImageCrawler();
        lyricsCrawler = new BasicLyricsCrawler();
        midiCrawler = new BasicMidiFileCrawler();
    }

    /**
     * Simple apache commons cli helper to get the command and getSongRepresentation it
     *
     * The options that are supported as of now are
     *
     * gen_artists
     * in_memory
     * time_limit
     * space_limit
     * crawl_sheets
     * crawl_acoustic_sources
     *
     * @param args
     * @return
     * @throws ParseException
     * @throws Modulo7InvalidArgsException
     */
    public static CommandLine getCommand(String[] args) throws Modulo7InvalidArgsException, ParseException {

        if (args == null || args.length < 1 || args[0] == null) {
            throw new Modulo7InvalidArgsException("Invalid number of arguments : " + args.length);
        }

        // create Options object
        Options m7Options = new Options();

        // options currently supported by the crawler sub system
        m7Options.addOption("gen_artists", false,
                "Whether Modulo7 crawler should generate additional artists from seed file");
        m7Options.addOption("in_memory", true,
                "Whether Modulo7 should keep the music stat model in memory or serialize it to disk/db");
        m7Options.addOption("time_limit", true,
                "How much of a time limit Modulo7 should keep a time limit as for processing for the engine");
        m7Options.addOption("space_limit", true,
                "How much disk space is Modulo7 allowed to consume before tapping out");
        m7Options.addOption("crawl_sheets", false,
                "Whether to crawl sheet music or not");
        m7Options.addOption("crawl_acoustic_sources", false,
                "Whether to crawl acoustic sources like mp3, midi etc");

        CommandLineParser parser = new DefaultParser();

        return parser.parse(m7Options,args);

    }
}
