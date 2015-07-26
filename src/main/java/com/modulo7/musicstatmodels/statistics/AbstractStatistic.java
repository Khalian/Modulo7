package com.modulo7.musicstatmodels.statistics;

import com.modulo7.musicstatmodels.representation.Song;

/**
 * Created by asanyal on 7/25/2015.
 *
 * Base class to acquire a particular statistic on a song
 *
 * TODO : Impl this
 */
public abstract class AbstractStatistic {

    protected abstract void getStatistic(final Song song);
}
