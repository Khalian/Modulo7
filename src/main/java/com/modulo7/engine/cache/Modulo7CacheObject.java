package com.modulo7.engine.cache;

/**
 * Created by asanyal on 11/6/15.
 *
 * A modulo7 cache object
 */
public class Modulo7CacheObject<T> {

    // Set of songs returned in a total order
    private T queryResults;

    /**
     * Basic constructor of the cache object
     *
     * @param queryResults
     */
    public Modulo7CacheObject(final T queryResults) {
        this.queryResults = queryResults;
    }

    /**
     * Get the query results
     * @return
     */
    public T getQueryResults() {
        return queryResults;
    }
}
