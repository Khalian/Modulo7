package com.modulo7.crawler;

import com.modulo7.nlp.NLPUtils;
import org.apache.lucene.queryParser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.SocketException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

/**
 * This class processes a set of seed pages and extracts the relevant lyrics
 * from each of these files
 */
public class BasicLyricsCrawler implements Runnable {

    // Logger for basic lyrics crawler
    private static final Logger logger = Logger.getLogger(BasicLyricsCrawler.class.getName());

    // Maximum crawl depth for urls, so the crawler does not stray and indefinitely run
    private final int MAX_CRAWL_DEPTH = 50;

    // A predicate value that indicates whether stemming is to be performed or not
    private boolean isStemmingEnabled = false;

    private Set<String> stopList;

    private Set<String> nonLyricsWords;

    private Set<String> lyricsSeed;

    private Set<String> lyricsPages;

    private Set<String> crawledLyricsURLs;

    /**
     * The constructor loads files and its values and populates them into an instance of the basic crawler
     *
     * Takes default value of stemming configuration
     *
     * @throws FileNotFoundException
     */
    public BasicLyricsCrawler() throws IOException {
        // Loads the non lyrics words, stop words list
        init();
    }

    /**
     *
     * @param isStemmingEnabled
     * @throws IOException
     */
    public BasicLyricsCrawler(boolean isStemmingEnabled) throws IOException {
        this.isStemmingEnabled = isStemmingEnabled;

        // Loads the non lyrics words, stop words list
        init();
    }

    /**
     * The init method loads files and its values and populates them into an instance of the basic crawler
     *
     * @throws FileNotFoundException
     */
    private void init() throws IOException {
        BufferedReader stopWordsFileReader =
                new BufferedReader(new FileReader(new File(CrawlerHelper.STOP_WORDS_FILE)));

        BufferedReader nonLyricsFileReader =
                new BufferedReader(new FileReader(new File(CrawlerHelper.NON_LYRICS_WORDS_FILE)));

        BufferedReader lyricsSeedFileReader =
                new BufferedReader(new FileReader(new File(CrawlerHelper.LYRICS_SEED_FILE)));

        stopList = new HashSet<>();
        nonLyricsWords = new HashSet<>();
        lyricsSeed = new HashSet<>();
        crawledLyricsURLs = new HashSet<>();

        String word;

        // Read the various lines
        while ((word = stopWordsFileReader.readLine()) != null) {
            if (!stopList.contains(word))
                stopList.add(word.toLowerCase());
        }

        while ((word = nonLyricsFileReader.readLine()) != null) {
            if (!nonLyricsWords.contains(word.toLowerCase()))
                nonLyricsWords.add(word.toLowerCase());
        }

        while ((word = lyricsSeedFileReader.readLine()) != null) {
            if (!lyricsSeed.contains(word.toLowerCase()))
                lyricsSeed.add(word.toLowerCase());
        }
    }

    public static void main(String args[]) throws IOException {

        BasicLyricsCrawler crawler = new BasicLyricsCrawler();
        crawler.crawlSeedPages();
        crawler.processAllPages();
    }

    /**
     * Process all pages for lyrics after crawling them use
     * this method after running the crawlSeedPages method
     */
    private void processAllPages() throws IOException {
         for (String url : crawledLyricsURLs) {
             processPage(url);
         }
    }

    /**
     * Crawls all the seed pages present in the lyrics seed file
     * @throws IOException
     */
    private void crawlSeedPages() throws IOException {
        for (String url : lyricsSeed) {
            crawlPage(url, 1);
        }
    }

    /**
     * Process a given page by taking out the body and parsing the lyrics component
     * @param url
     * @throws IOException
     */
    public void processPage(final String url) throws IOException {

        //get the lyrics component from the html page
        String lyricsTxt = "";

        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select("body");

        for (Element ele : links)
        {
            String[] elementText = ele.text().split("\\s+");
            for (String elementWord : elementText) {
                String elementWordLC = elementWord.toLowerCase();
                if (!(stopList.contains(elementWordLC) || nonLyricsWords.contains(elementWordLC))) {
                    if (isStemmingEnabled) {
                        try {
                            lyricsTxt += NLPUtils.englishStemmer(elementWordLC) + " ";
                        } catch (ParseException pe) {
                            logger.fine("Unable to stem due to :" + pe.getMessage());
                        }
                    } else {
                        lyricsTxt += elementWord + " ";
                    }
                }
            }
        }

        // Uncomment this for debugging operation of stop words and non lyrics words logic
        // System.out.println(lyricsTxt);
    }

    /**
     * This method gets the seed pages and then crawls them upto a specified depth
     * @throws IOException
     */
    public void crawlPage(final String url, final int depth) throws IOException {

        if (depth <= MAX_CRAWL_DEPTH) {

            Document doc = null;

            try {
                doc = Jsoup.connect(url).get();
            } catch (SocketException exp) {
                // Do nothing, obviously either dead link or network timeout
            }

            if (doc != null) {
                Elements links = doc.select("a[href]");

                for (Element link : links) {
                    String relHref = link.attr("href");
                    if (relHref.startsWith("http") && relHref.endsWith("html")) {
                        if (!crawledLyricsURLs.contains(relHref)) {
                            crawledLyricsURLs.add(relHref);
                            System.out.println(relHref);
                            crawlPage(relHref, depth + 1);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void run() {

    }
}