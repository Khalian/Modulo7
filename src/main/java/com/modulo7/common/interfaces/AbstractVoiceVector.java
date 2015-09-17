package com.modulo7.common.interfaces;

import com.modulo7.musicstatmodels.representation.monophonic.Voice;

/**
 * Created by asanyal on 9/8/15.
 *
 * Vector space models but for individual voices instead of songs
 */
public interface AbstractVoiceVector<T> {

    /**
     * Getter for the vector length associated with this vector
     * @return
     */
    public int getVectorLength();

    /**
     * Computes the vector representation from the elements in
     * the song representation of Modulo7
     */
    public void computeVectorRepresentation(final Voice voice);

    /**
     * Gets the internal representation of the vector
     * @return
     */
    public T getInternalRepresentation();
}
