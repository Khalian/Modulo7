package com.modulo7.pureresearch.metadataestimation.bagofwordslyricssim;

import org.apache.commons.math.linear.ArrayRealVector;
import org.apache.commons.math.linear.RealVector;
import org.apache.lucene.search.similarities.Similarity;

import java.util.Map;

/**
 * Created by asanyal on 12/12/15.
 *
 * An abstract bag of word similarity metric,
 * all measures as implementation of
 */
public  abstract class BOWSimilarity {

    // A given similarity metric derived from lucene similarity measures
    protected Similarity similarity;

    // Terms for bag of words for the first set
    protected RealVector v1;

    // Terms for bag of words for the second set
    protected RealVector v2;

    /**
     * Base constructor
     *
     * @param bog1
     * @param bog2
     */
    public BOWSimilarity(final Map<String, Integer> bog1, final Map<String, Integer> bog2) {
        v1 = toRealVector(bog1);
        v2 = toRealVector(bog2);
    }

    /**
     * Get the similarity between two elements based on particular
     * similarity criteria, implementation dependent on
     * @return
     */
    public abstract double getSimVal();

    /**
     * Gets the real vector representation of a set of terms
     * @param map
     * @return
     */
    private RealVector toRealVector(final Map<String, Integer> map) {
        RealVector vector = new ArrayRealVector(map.keySet().size());
        int i = 0;

        for (String term : map.keySet()) {
            int value = map.get(term);
            vector.setEntry(i++, value);
        }

        return vector.mapDivide(vector.getL1Norm());
    }

    /**
     * Gets vector sum
     * @param vector
     * @return
     */
    double getVectorSum(final RealVector vector) {

        double sum = 0.0;

        for (int i = 0; i < vector.getDimension(); i++) {
            sum += vector.getEntry(i);
        }

        return sum;
    }
}
