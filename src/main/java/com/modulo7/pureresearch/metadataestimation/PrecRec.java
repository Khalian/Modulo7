package com.modulo7.pureresearch.metadataestimation;

/**
 * Created by asanyal on 12/23/15.
 *
 * Precision and recall bundled into one class
 */
public class PrecRec {

    private double precision;

    private double recall;

    public PrecRec(final double precision, final double recall) {
        this.precision = precision;
        this.recall = recall;
    }

    public double getPrecision() {
        return precision;
    }

    public double getRecall() {
        return recall;
    }

    /**
     * When the number of actually relevant documents = 0
     * recall can be NaN and precision can be 0
     *
     * A safety check against that outcome is the precRec
     *
     * @return
     */
    public boolean isValid() {
        return !(precision == 0.0 && Double.isNaN(recall));
    }
}
