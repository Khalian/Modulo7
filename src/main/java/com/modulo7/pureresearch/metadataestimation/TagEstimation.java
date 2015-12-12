package com.modulo7.pureresearch.metadataestimation;

import com.modulo7.pureresearch.lastfm.SongBagLyricsAndMetadata;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by asanyal on 12/11/15.
 *
 * The tag estimation class for a given data set
 */
public abstract class TagEstimation {

    // A set of song bagged lyrics and meta data mapped
    protected Set<SongBagLyricsAndMetadata> lyricsMappedTagEntries;

    // Train set split of the Tag Estimation algorithm
    protected Set<SongBagLyricsAndMetadata> trainSet;

    // The test set split of the tag estimation algorithm
    protected Set<SongBagLyricsAndMetadata> testSet;

    /**
     * Default deserialization constructor for lyrics map to tags
     * @param lyricsTagMapSerialized
     */
    public TagEstimation(final String lyricsTagMapSerialized) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(lyricsTagMapSerialized);
        ObjectInputStream ois = new ObjectInputStream(fis);
        lyricsMappedTagEntries = (HashSet<SongBagLyricsAndMetadata>) ois.readObject();
        ois.close();
        fis.close();

        final int sizeOfDataSet = lyricsMappedTagEntries.size();
        final int fraction = sizeOfDataSet / 10;
        int currCounter = 0;

        for (final SongBagLyricsAndMetadata lyricsAndMetadata : lyricsMappedTagEntries) {
            if (currCounter < fraction) {
                testSet.add(lyricsAndMetadata);
            } else {
                trainSet.add(lyricsAndMetadata);
            }
            currCounter++;
        }
    }

    /**
     * Gets the estimated tags for a given
     * @return
     */
    public abstract Map<SongBagLyricsAndMetadata, Map<String, Integer>> getEstimatedTags();

    /**
     * A comparison between a couple of bag of words data elements
     * @param first
     * @param second
     * @return
     */
    public abstract double isSim(final Map<String, Integer> first, final Map<String, Integer> second);
}
