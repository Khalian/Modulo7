package com.modulo7.engine.processing;

import com.modulo7.common.interfaces.AbstractVoiceSimilarity;
import com.modulo7.engine.storage.DatabaseEngine;
import com.modulo7.musicstatmodels.misc.TonalityAlignment;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;
import com.modulo7.musicstatmodels.similarity.genericsimilarity.SmithWatermanSimilarity;

import java.util.Set;

/**
 * Created by asanyal on 1/1/16.
 *
 * A specialist engine which procudes alignments based on tonality
 * and a given similarity measure
 *
 * Alignment looks for regions of songs that are similar to each other
 * and gives that as an output
 */
public class TonalAlginmentEngine {

    // The internal similarity measure used
    private AbstractVoiceSimilarity similarity;

    /**
     * Default constructor for tonal alignment engine
     * @param voiceSimilarity
     */
    public TonalAlginmentEngine(final AbstractVoiceSimilarity voiceSimilarity) {
        similarity = voiceSimilarity;
    }

    /**
     * Performs the tonality alignment operation
     * @param engine
     * @param refSong
     */
    public void align(final DatabaseEngine engine, final Song refSong) {
        final Set<Song> allSongs = engine.getAllSongs();

        for (final Song song : allSongs) {
            for (final Voice refVoice : refSong.getVoices()) {
                for (final Voice voice : song.getVoices()) {
                    SmithWatermanSimilarity<AbstractVoiceSimilarity> sim = new SmithWatermanSimilarity<>(similarity);
                    sim.getSimilarity(refVoice, voice);
                    TonalityAlignment alignment = sim.getAlignment();
                    alignment.displayAlignment();
                }
            }
        }
    }
}
