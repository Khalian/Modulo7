package com.modulo7.musicstatmodels.similarity.voicesimilarity;

import com.modulo7.common.interfaces.AbstractSongSimilarity;
import com.modulo7.common.interfaces.AbstractVoiceSimilarity;
import com.modulo7.crawler.utils.MusicSources;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;
import com.modulo7.musicstatmodels.similarity.songsimilarity.TonalHistogramSimilarity;

/**
 * Created by asanyal on 9/18/15.
 *
 * Tonal histogram similarity between two voices
 */
public class VoiceTonalHistogramSimilarity implements AbstractVoiceSimilarity {

    /**
     * Gets the tonal histogram similarity between two voices
     * @param first
     * @param second
     * @return
     */
    @Override
    public double getSimilarity(final Voice first, final Voice second) {

        final Song firstSong = new Song(first, MusicSources.UNKNOWN);
        final Song secondSong = new Song(second, MusicSources.UNKNOWN);

        AbstractSongSimilarity similarity = new TonalHistogramSimilarity();

        return similarity.getSimilarity(firstSong, secondSong);
    }
}
