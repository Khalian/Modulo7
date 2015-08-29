package com.modulo7.musicstatmodels.statistics.results;

/**
 * Created by asanyal on 8/29/15.
 *
 * The statistics result returned by a statistic computation
 */
public interface StatisticResult<T> {

    /**
     * Gets the resultant statistic object
     */
    public T getStatisticResultObject();
}
