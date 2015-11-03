package com.modulo7.engine.cache;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedHashSet;

/**
 * Created by asanyal on 10/28/15.
 *
 * Caching results for maximum performance for Modulo7 given a set of queries
 */
public class Modulo7Cache {

    // Logger for caching
    private static final Logger logger = Logger.getLogger(Modulo7Cache.class);

    /**
     * Method to cache query
     *
     * @param query
     * @param queryResults
     */
    public static void cacheQueryResults(final String query, final LinkedHashSet<String> queryResults) {
    }

    /**
     * Query caching system
     *
     * @param query
     * @return
     */
    public static LinkedHashSet<String> getCachedResults(final String query) {
        return null;
    }
}
