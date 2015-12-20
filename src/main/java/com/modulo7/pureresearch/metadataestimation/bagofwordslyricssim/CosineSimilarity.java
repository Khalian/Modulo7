package com.modulo7.pureresearch.metadataestimation.bagofwordslyricssim;

import java.util.Map;

/**
 * Created by asanyal on 12/19/15.
 */
public class CosineSimilarity extends BOWSimilarity {

    /**
     * Base constructor
     *
     * @param bog1
     * @param bog2
     */
    public CosineSimilarity(Map<String, Integer> bog1, Map<String, Integer> bog2) {
        super(bog1, bog2);
    }

    @Override
    public double getSimVal() {
        return (v1.dotProduct(v2)) / (v1.getNorm() * v2.getNorm());
    }
}
