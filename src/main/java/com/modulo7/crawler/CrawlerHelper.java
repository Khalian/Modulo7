package com.modulo7.crawler;

import java.io.File;

/**
 * Created by asanyal on 7/3/2015.
 *
 * A utility class storing globals and helper methods
 */
public class CrawlerHelper {

    // The API key, generally acquired : TODO : Externalize it and make it generic
    public static final String ECHO_NEST_API_KEY = "K54MGT0TONSDQDKXE";

    // Picks up the base directory on which modulo 7 resides
    public static final String MODULO7_ROOT = System.getenv("MODULO7_ROOT");

    // A file which contains words that cannot be part of any lyrics, yet appears
    // in lyrics sites
    public static final String NON_LYRICS_WORDS_FILE =
            MODULO7_ROOT + File.separator + "resources" + File.separator + "non_lyrics_words";

    // A file which contains the stop words, extremely common words that should not be
    // considered as part of the lyrics
    public static final String STOP_WORDS_FILE =
            MODULO7_ROOT + File.separator + "resources" + File.separator+ "stopwords";

    // A file which contains base urls for various lyrics sites which acts as a seed
    public static final String LYRICS_SEED_FILE =
            MODULO7_ROOT + File.separator + "resources" + File.separator+ "lyrics_seed";

    public static final String ARTISTS_SEED_FILE =
            MODULO7_ROOT + File.separator + "resources" + File.separator + "artists_seed";

    /**
     * Method used to clean up files of the following formats
     *
     */
    public void cleanUpCrawledFiles() {

    }
}
