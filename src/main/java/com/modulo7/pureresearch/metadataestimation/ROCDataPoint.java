package com.modulo7.pureresearch.metadataestimation;

/**
 * Created by asanyal on 12/24/15.
 *
 * A particular data point that would be present in the
 * ROC curve for threshhold based measures
 */
public class ROCDataPoint {

    // True positive rate
    private double tpr;

    // False positive rate
    private double fpr;

    /**
     * Default constructor for the ROC data point
     * @param truePositiveRate
     * @param falsePositiveRate
     */
    public ROCDataPoint(final double truePositiveRate, final double falsePositiveRate) {
        this.tpr = truePositiveRate;
        this.fpr = falsePositiveRate;
    }

    /**
     * Getter for True positive rate
     * @return
     */
    public double getTruePositiveRate() {
        return tpr;
    }

    /**
     * Getter fro True negative rate
     * @return
     */
    public double getFalsePositiveRate() {
        return fpr;
    }
}
