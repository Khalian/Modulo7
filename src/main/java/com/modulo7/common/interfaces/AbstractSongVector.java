package com.modulo7.common.interfaces;

import com.modulo7.musicstatmodels.representation.polyphonic.Song;

/**
 * Created by asanyal on 9/4/15.
 *
 * An abstraction of the vector space model in Modulo7's vector
 * space model definitions
 */
public interface AbstractSongVector<T> {

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
