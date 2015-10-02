package com.modulo7.common.interfaces;

import com.modulo7.nlp.Lyrics;

/**
 * Created by asanyal on 10/2/15.
 *
 * An interface for lyrics similarity
 */
public interface AbstractLyricsSimilarity {

    public double getSimilarity(final Lyrics thisLyrics, final Lyrics thatLyrics);
}
