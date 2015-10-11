package com.modulo7.musicstatmodels.similarity.lyricssimilarity;

import com.modulo7.common.interfaces.AbstractLyricsSimilarity;
import com.modulo7.nlp.lyrics.Lyrics;
import org.apache.lucene.search.similarities.DefaultSimilarity;
import org.apache.lucene.search.similarities.TFIDFSimilarity;

/**
 * Created by asanyal on 10/2/15.
 *
 * Classical lyrics simialarity on the TFIDF measure
 *
 * TODO : Complete this
 */
public class LyricsTFIDFSimilarity implements AbstractLyricsSimilarity {

    @Override
    public double getSimilarity(final Lyrics thisLyrics, final Lyrics thatLyrics) {


        TFIDFSimilarity similarity = new DefaultSimilarity();


        return 0.0;
    }
}
