package com.modulo7.pureresearch.metadataestimation;

import com.modulo7.pureresearch.lastfm.SongBagLyricsGenreMap;
import com.modulo7.pureresearch.musicmatch.BagOfWordsDataElement;
import com.modulo7.pureresearch.musicmatch.LyricsBagOfWordsFormat;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by asanyal on 12/22/15.
 *
 * Builds the tag tratum database from the ground truth data
 */
public class TagTratumDatabase implements Serializable {

    // The map of track ID to genre objects
    private Map<String, GenreLabels> songGenreMap = new HashMap<>();

    /**
     * Reading the ground truth file
     *
     * @param groundTruthFile
     * @throws java.io.IOException
     */
    public TagTratumDatabase(final String groundTruthFile) throws IOException {
        File file = new File(groundTruthFile);
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        while ((line = br.readLine()) != null) {

            // # is a comment in the music match file format
            if (!line.startsWith("#")) {
                final String[] elements = line.split("\\s+");
                final String trackId = elements[0];

                Set<String> genres = new HashSet<>();
                for (int i = 1; i < elements.length; i++) {
                    genres.add(elements[i]);
                }

                songGenreMap.put(trackId, new GenreLabels(trackId, genres));
            }
        }
    }

    public void syncLyrics(final LyricsBagOfWordsFormat bagOfWordsLyrics) throws IOException {
        final Set<SongBagLyricsGenreMap> lyricsMappedToGenreEntries = new HashSet<>();

        int count = 0;

        for (Map.Entry<String, GenreLabels> entry : songGenreMap.entrySet()) {
            final String trackId = entry.getKey();
            final BagOfWordsDataElement element = bagOfWordsLyrics.getBagOfWords(trackId);
            if (element != null) {
                final GenreLabels songBagLyrics = entry.getValue();
                SongBagLyricsGenreMap songBagLyricsGenreMap = new SongBagLyricsGenreMap(trackId, songBagLyrics, element);
                lyricsMappedToGenreEntries.add(songBagLyricsGenreMap);
                count++;
            }
        }

        FileOutputStream fos = new FileOutputStream("./src/test/researchData/lyricsGenreEXPT.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(lyricsMappedToGenreEntries);
        oos.close();
        fos.close();
        System.out.printf("Serialized tag mapped data hashmap.ser");

        System.out.println(count);
    }
}
