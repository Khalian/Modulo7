package com.modulo7.pureresearch.lastfm;

import com.modulo7.common.exceptions.Modulo7NoSuchFileOrDirectoryException;
import com.modulo7.common.utils.Modulo7Utils;
import com.modulo7.pureresearch.musicmatch.BagOfWordsDataElement;
import com.modulo7.pureresearch.musicmatch.LyricsBagOfWordsFormat;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by asanyal on 11/9/15.
 *
 * This data set contains the last fm data for song level similarity
 */
public class LastFMDataSet {

    // The set of similar objects
    private Map<String, SongBagLyricsAndMetadata> songSimilaritySet = new HashMap<>();

    // Logger for the last fm data set
    private static final Logger logger = Logger.getLogger(LastFMDataSet.class);

    /**
     * Last FM dataset constructor, given a root directory construct a set of similar songs along with
     * similar songs
     *
     * @param dirOfSims
     * @throws Modulo7NoSuchFileOrDirectoryException
     * @throws IOException
     */
    public LastFMDataSet(final String dirOfSims) {

        try {
            final Set<String> allSimFiles = Modulo7Utils.listAllFiles(dirOfSims);
            for (final String simFile : allSimFiles) {
                String line;
                StringBuilder builder = new StringBuilder();
                FileReader reader = new FileReader(simFile);
                BufferedReader br = new BufferedReader(reader);
                while ((line = br.readLine()) != null) {
                    builder.append(line);
                }

                reader.close();
                br.close();

                try {
                    JSONObject json = new JSONObject(builder.toString());
                    final String artist = json.getString("artist");
                    final String trackID = json.getString("track_id");
                    final String title = json.getString("title");
                    final SongBagLyricsAndMetadata newSet = new SongBagLyricsAndMetadata(artist, trackID, title);
                    final JSONArray similars = json.getJSONArray("similars");
                    final JSONArray tags = json.getJSONArray("tags");

                    for (int i = 0; i < similars.length(); i++) {
                        JSONArray similar = similars.getJSONArray(i);
                        final String simSongID = similar.getString(0);
                        final double simValue = similar.getDouble(1);
                        newSet.addSongSimilarityElement(new SongSimilarityElement(simSongID, simValue));
                    }

                    for (int i = 0; i < tags.length(); i++) {
                        JSONArray tagPair = tags.getJSONArray(i);
                        newSet.addTagElem(tagPair.getString(0), tagPair.getInt(1));
                    }

                    songSimilaritySet.put(trackID, newSet);
                } catch (JSONException e) {
                    logger.error(e.getMessage());
                }
            }
        } catch (Modulo7NoSuchFileOrDirectoryException | IOException e) {
            logger.error(e.getMessage());
        }
    }

    /**
     * Sync the lyrics objects (bag of words format) given the last fm and music match data set
     */
    public void syncLyrics(final LyricsBagOfWordsFormat bagOfWordsLyrics) {
        for (Map.Entry<String, SongBagLyricsAndMetadata> entry : songSimilaritySet.entrySet()) {
            final String trackId = entry.getKey();
            final BagOfWordsDataElement element = bagOfWordsLyrics.getBagOfWords(trackId);
            if (element != null) {
                final SongBagLyricsAndMetadata similaritySet = entry.getValue();
                similaritySet.addBagOfWords(element);
            }
        }
    }
}