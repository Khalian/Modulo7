package com.modulo7.pureresearch.metadataestimation.bagofwordslyricssim;

import java.util.Map;

/**
 * Created by asanyal on 12/19/15.
 */
public class DiceSimilarity extends BOWSimilarity {
    /**
     * Base constructor
     *
     * @param bog1
     * @param bog2
     */
    public DiceSimilarity(final Map<String, Integer> bog1, final Map<String, Integer> bog2) {
        super(bog1, bog2);
    }

    @Override
    public double getSimVal() {
        return 2 * v1.dotProduct(v2) / (getVectorSum(v1) + getVectorSum(v2));
    }
}
