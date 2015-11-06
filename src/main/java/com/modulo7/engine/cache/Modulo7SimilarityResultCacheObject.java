package com.modulo7.engine.cache;

import java.util.LinkedHashMap;

/**
 * Created by asanyal on 11/6/15.
 *
 * A similarity measure result cache object
 */
public class Modulo7SimilarityResultCacheObject extends Modulo7CacheObject<LinkedHashMap<String, Double>> {
    /**
     * Basic constructor of the cache object
     *
     * @param queryResults
     */
    public Modulo7SimilarityResultCacheObject(LinkedHashMap<String, Double> queryResults) {
        super(queryResults);
    }
}
