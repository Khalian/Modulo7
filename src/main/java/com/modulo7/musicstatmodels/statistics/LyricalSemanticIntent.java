package com.modulo7.musicstatmodels.statistics;

import com.modulo7.common.interfaces.AbstractStatistic;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;
import com.modulo7.nlp.lyrics.Lyrics;
import com.modulo7.nlp.nlpengine.AlchemyEngine;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Created by asanyal on 10/10/15.
 *
 * Gets a semantic score for the lyrical content for a song
 */
public class LyricalSemanticIntent implements AbstractStatistic {

    // Logger for lyrical semantic intent
    private static Logger logger = Logger.getLogger(LyricalSemanticIntent.class);

    @Override
    public Double getStatistic(final Song song) {

        Lyrics lyrics = song.getLyrics();

        try {
            AlchemyEngine engine = new AlchemyEngine();
            return engine.sentimentAnalysis(lyrics.getLyricsOfSong()).getScore();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }

        return 0.0;
    }
}
