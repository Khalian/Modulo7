package com.modulo7.pureresearch.metadataestimation.bagofwordslyricssim;

import org.apache.commons.math.linear.RealVector;
import org.apache.commons.math.linear.ArrayRealVector;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.similarities.Similarity;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by asanyal on 12/12/15.
 *
 * An abstract bag of word similarity metric,
 * all measures as implementation of
 */
public  abstract class BOWSimilarity {

    private static final String LYRICS_FIELD = "lyrics";

    // A given similarity metric derived from lucene similarity measures
    protected Similarity similarity;

    // Terms for bag of words for the first set
    protected Set<Term> bog1Terms;

    // Terms for bag of words for the second set
    protected Set<Term> bog2Terms;

    /**
     * Base constructor
     *
     * @param bog1
     * @param bog2
     */
    public BOWSimilarity(final Set<String> bog1, final Set<String> bog2) {
        bog1Terms.addAll(bog1.stream().map(bog1word -> new Term(LYRICS_FIELD, bog1word)).collect(Collectors.toList()));
        bog2Terms.addAll(bog2.stream().map(bog2word -> new Term(LYRICS_FIELD, bog2word)).collect(Collectors.toList()));
    }

    /**
     *
     * @return
     */
    public abstract double getSimVal();

    /**
     * Gets the real vector representation of a set of terms
     * @param map
     * @param terms
     * @return
     */
    RealVector toRealVector(final Map<String, Integer> map, final Set<String> terms) {
        RealVector vector = new ArrayRealVector(terms.size());
        int i = 0;

        for (String term : terms) {
            int value = map.containsKey(term) ? map.get(term) : 0;
            vector.setEntry(i++, value);
        }

        return vector.mapDivide(vector.getL1Norm());
    }
}
