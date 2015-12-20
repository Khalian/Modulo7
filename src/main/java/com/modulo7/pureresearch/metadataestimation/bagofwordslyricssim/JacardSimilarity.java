package com.modulo7.pureresearch.metadataestimation.bagofwordslyricssim;

import java.util.Map;

/**
 * Created by asanyal on 12/19/15.
 *
 * Jacard similarity for bag of words representation
 */
public class JacardSimilarity extends BOWSimilarity {
    /**
     * Base constructor
     *
     * @param bog1
     * @param bog2
     */
    public JacardSimilarity(Map<String, Integer> bog1, Map<String, Integer> bog2) {
        super(bog1, bog2);
    }

    @Override
    public double getSimVal() {
        double dotProd = v1.dotProduct(v2);
        return dotProd / (getVectorSum(v1) + getVectorSum(v2) - dotProd);
    }
}
