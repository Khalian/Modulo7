package com.modulo7.engine.cache;

import java.util.LinkedHashSet;

/**
 * Created by asanyal on 11/2/15.
 *
 * A cached modulo7 object, i.e a query and relevant results to that query
 */
public class Modulo7CacheObject {

    // The syntax of the query, i.e command line of the query
    private String query;

    // Set of songs returned in a total order
    private LinkedHashSet<String> queryResults;

    /**
     * Basic constructor of the cache object
     *
     * @param query
     * @param queryResults
     */
    public Modulo7CacheObject(final String query, final LinkedHashSet<String> queryResults) {
        this.query = query;
        this.queryResults = queryResults;
    }

    /**
     * Getter for query
     * @return
     */
    public String getQuery() {
        return query;
    }

    /**
     * Get the query results
     * @return
     */
    public LinkedHashSet<String> getQueryResults() {
        return queryResults;
    }
}
