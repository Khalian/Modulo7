package com.modulo7.crawler;

import com.echonest.api.v4.Artist;
import com.echonest.api.v4.EchoNestAPI;
import com.echonest.api.v4.EchoNestException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Created by asanyal on 6/29/2015.
 *
 * This class has the capacity to randomly walk and acquire
 * artist names. These artist name seeds can then be used
 * to acquire various resources
 *
 * It uses the java Echo Nest API to accomplish this
 */
public class ConstructArtistsFileRandomWalk {

    // A handle to the API class
    private EchoNestAPI en;

    // Whether tracing is enabled for echo nest API
    private static boolean trace = false;

    // A list of all the crawled artists
    private Set<String> crawledArtists;

    // Number of iterations for random walks, TODO : Externalize this and make it configurable
    private static final int NUM_RANDOM_WALK_ITERS = 50;

    /**
     * Test code
     * @param args
     * @throws EchoNestException
     */
    public static void main(String[] args) throws EchoNestException, IOException {
        ConstructArtistsFileRandomWalk newWalk = new ConstructArtistsFileRandomWalk();

        newWalk.randomWalk("Lata Mangeshkar", 50);
    }

    /**
     * Acquires the rate limit, to be called when to ascertain how much rate is left and slow down accordingly
     *
     * This method is useful for dynamic adjustment of sleep times for the crawler
     */
    private void acquireRateLimit() throws IOException {
        // TODO : Fix this
        String queryURL =
                "http://developer.echonest.com/api/v4/artist/profile?api_key=" + CrawlerHelper.ECHO_NEST_API_KEY + "&name=";

        HttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://targethost/homepage");

        HttpResponse response = client.execute(httpGet);

        System.out.println(response.getAllHeaders());
    }

    /**
     * Default constructors with tracing of Echo Nest API calls disabled
     *
     * @throws EchoNestException
     */
    public ConstructArtistsFileRandomWalk() throws EchoNestException {

        // Init all data structures
        init();

        en = new EchoNestAPI(CrawlerHelper.ECHO_NEST_API_KEY);
        en.setTraceSends(trace);
        en.setTraceRecvs(trace);
    }

    /**
     * Basic init calls
     */
    private void init() {
        crawledArtists = new HashSet<>();
    }

    /**
     * Method to control a random walk to acquire artists
     *
     * @param seedName
     * @param count
     * @throws EchoNestException
     */
    private void randomWalk(final String seedName,final int count) throws EchoNestException {
        List<Artist> artists = en.searchArtists(seedName);

        try {
            // This sleep is added to ensure the rate limit is crossed over
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (artists.size() > 0) {
            Artist seed = artists.get(0);
            for (int i = 0; i < count; i++) {
                List<Artist> sims = seed.getSimilar(10);

                for (Artist artist : sims) {
                    System.out.println(artist.getName());
                }

                if (sims.size() > 0) {
                    Collections.shuffle(sims);
                    seed = sims.get(0);
                } else {
                    break;
                }
            }
        }
    }

    /**
     * Adds the artist crawled to a set, provided its not
     * already present in that list
     *
     * @param candidateArtist
     */
    private void addArtistToSet(String candidateArtist) {
        if (!crawledArtists.contains(candidateArtist))
            crawledArtists.add(candidateArtist);
    }

    /**
     * This method is used to dump the crawled artists to a given file
     *
     * @param filePath
     */
    private void dumpCrawledArtistSetToFile(String filePath) throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter(filePath));

        Iterator it = crawledArtists.iterator();

        while(it.hasNext()) {
            out.write(it.next()+"\n");
        }

        out.close();
    }

    /**
     * TODO : Finish this
     * @return
     */
    private List<String> readArtistSeedFile() {
        return null;
    }
}
