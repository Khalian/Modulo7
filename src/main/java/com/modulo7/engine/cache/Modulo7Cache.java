package com.modulo7.engine.cache;

import org.apache.commons.jcs.JCS;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.commons.jcs.access.CacheAccess;

/**
 * Created by asanyal on 10/28/15.
 *
 * Caching results for maximum performance for Modulo7 given a set of queries
 */
public class Modulo7Cache {

    // Gets a class level cache, a singleton for all instance (although by design its only used in Modulo7 CLI)
    private static final CacheAccess<String, Modulo7CacheObject> cache = JCS.getInstance(Modulo7Cache.class.getName());

    /**
     * Method to cache custom
     *
     * @param query
     * @param queryResults
     */
    public void cacheQueryResults(final String query, final Set<String> queryResults) {
        final Modulo7CustomQueryCacheObject object = new Modulo7CustomQueryCacheObject(queryResults);
        cache.put(query, object);
    }

    /**
     * Method to cache similarity query
     *
     * @param query
     * @param queryResults
     */
    public void cacheQueryResults(final String query, final LinkedHashMap<String, Double> queryResults) {
        final Modulo7SimilarityResultCacheObject object = new Modulo7SimilarityResultCacheObject(queryResults);
        cache.put(query, object);
    }

    /**
     * Query caching system
     *
     * @param query
     * @return
     */
    public Object getCachedResults(final String query) {
        Modulo7CacheObject results = cache.get(query);

        if (results != null) {
            return results.getQueryResults();
        } else {
            return null;
        }
    }

    /**
     * A powerful method that invalidates the cache completely
     */
    public void invalidateCache() {
        cache.clear();
    }
}
