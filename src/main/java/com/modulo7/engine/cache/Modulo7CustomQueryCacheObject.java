package com.modulo7.engine.cache;

import java.util.Set;

/**
 * Created by asanyal on 11/2/15.
 *
 * A cached modulo7 object, i.e a custom query and relevant results to that query
 */
public class Modulo7CustomQueryCacheObject extends Modulo7CacheObject<Set<String>> {

    /**
     * Basic constructor of the cache object
     *
     * @param queryResults
     */
    public Modulo7CustomQueryCacheObject(final Set<String> queryResults) {
        super(queryResults);
    }
}
