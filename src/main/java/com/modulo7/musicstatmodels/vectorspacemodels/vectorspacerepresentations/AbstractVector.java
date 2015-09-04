package com.modulo7.musicstatmodels.vectorspacemodels.vectorspacerepresentations;

import com.modulo7.musicstatmodels.representation.Song;

/**
 * Created by asanyal on 9/4/15.
 *
 * An abstraction of the vector space model in Modulo7's vector
 * space model definitions
 */
public interface AbstractVector<T> {

    /**
     * Getter for the vector length associated with this vector
     * @return
     */
    public int getVectorLength();

    /**
     * Computes the vector representation from the elements in
     * the song representation of Modulo7
     */
    public void computeVectorRepresentation(final Song song);

    /**
     * Gets the internal representation of the vector
     * @return
     */
    public T getInternalRepresentation();
}
