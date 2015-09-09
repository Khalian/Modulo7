package com.modulo7.musicstatmodels.vectorspacemodels.vectorspacerepresentations.songvectors;

import com.modulo7.common.interfaces.AbstractContour;
import com.modulo7.common.interfaces.AbstractSongVector;
import com.modulo7.musicstatmodels.representation.Song;

import java.util.List;

/**
 * Created by asanyal on 9/8/15.
 *
 * Expression giving the gradient
 */
public class ContourGradientVector implements AbstractSongVector<List<Double>> {

    // A contour algorithm input to the gradient vector
    private AbstractContour contour;

    /**
     * Basic constructor of the gradient vector representation of the voice
     * @param contour
     */
    public ContourGradientVector(final AbstractContour contour) {
        this.contour = contour;
    }

    @Override
    public void computeVectorRepresentation(final Song song) {

    }

    @Override
    public List<Double> getInternalRepresentation() {
        return null;
    }
}
