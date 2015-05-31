import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.awt.datatransfer.StringSelection;
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BasicLyricsCrawler {

    // Maximum crawl depth for urls, so the crawler does not stray and indefinitely run
    private final int MAX_CRAWL_DEPTH = 3;

    // A file which contains words that cannot be part of any lyrics, yet appears
    // in lyrics sites
    private static final String NON_LYRICS_WORDS_FILE =
            System.getenv("MODULO7_ROOT") + File.separator + "resources" + File.separator+ "non_lyrics_words";

    // A file which contains the stop words, extremely common words that should not be
    // considered as part of the lyrics
    private static final String STOP_WORDS_FILE =
            System.getenv("MODULO7_ROOT") + File.separator + "resources" + File.separator+ "stopwords";

    // A file which contains base urls for various lyrics sites which acts as a seed
    private static final String LYRICS_SEED_FILE =
            System.getenv("MODULO7_ROOT") + File.separator + "resources" + File.separator+ "lyrics_seed";

    private Set<String> stopList;

    private Set<String> nonLyricsWords;

    private Set<String> lyricsSeed;

    private Set<String> lyricsPages;

    /**
     * The constructor loads files and its values and populates them into an instance of the basic crawler
     * @throws FileNotFoundException
     */
    public BasicLyricsCrawler() throws IOException {
        // Loads the non lyrics words, stop words list
        BufferedReader stopWordsFileReader = new BufferedReader(new FileReader(new File(STOP_WORDS_FILE)));
        BufferedReader nonLyricsFileReader = new BufferedReader(new FileReader(new File(NON_LYRICS_WORDS_FILE)));
        BufferedReader lyricsSeedFileReader = new BufferedReader(new FileReader(new File(LYRICS_SEED_FILE)));

        stopList = new HashSet<>();
        nonLyricsWords = new HashSet<>();
        lyricsSeed = new HashSet<>();

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
        crawler.crawlSeedPages(1);
        crawler.processPage("http://www.mit.edu");
    }

    public void processPage(final String URL) throws IOException {

        //get useful information
        String url = "http://www.azlyrics.com/lyrics/hillsongunited/myredeemerlives.html";
        String lyricsTxt = "";

        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select("body");

        for (Element ele : links)
        {
            String[] elementText = ele.text().split("\\s+");
            for (String elementWord : elementText) {
                String elementWordLC = elementWord.toLowerCase();
                if (!(stopList.contains(elementWordLC) || nonLyricsWords.contains(elementWordLC)))
                    lyricsTxt += elementWordLC + " ";
            }
        }

        // Uncomment this for debugging operation of stop words and non lyrics words logic
        // System.out.println(lyricsTxt);
    }

    /**
     * This method gets the seed pages and then crawls them upto a specified depth
     * @throws IOException
     */
    public void crawlSeedPages(final int depth) throws IOException {

        if (depth <= MAX_CRAWL_DEPTH) {
            for (String url : lyricsSeed) {
                Document doc = Jsoup.connect(url).get();
                Elements links = doc.select("a[href]");

                for (Element link : links) {
                    String relHref = link.attr("href");
                    System.out.println(relHref);
                }
            }
        }
    }
}