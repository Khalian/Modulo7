package com.modulo7.pureresearch.metadataestimation.bagofwordslyricssim;

import org.apache.lucene.search.similarities.BM25Similarity;

import java.util.Set;

/**
 * Created by asanyal on 12/12/15.
 *
 * Using the BM25 similarity measure on modulo7
 */
public class Modulo7BM25Similarity extends BOWSimilarity {

   public Modulo7BM25Similarity(final Set<String> bog1, final Set<String> bog2) {
       super(bog1, bog2);
       similarity = new BM25Similarity();
   }

    @Override
    public double getSimVal() {
        return 0;
    }
}
