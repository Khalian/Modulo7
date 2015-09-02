package com.modulo7.common.interfaces;

import com.modulo7.musicstatmodels.representation.Song;

/**
 * Created by asanyal on 7/25/2015.
 *
 * Base class to acquire a particular statistic on a song
 *
 */
public interface AbstractStatistic<T> {

    public T getStatistic(final Song song);
}
