package com.modulo7.musicstatmodels.criteria;

import com.modulo7.common.interfaces.AbstractCriteria;
import com.modulo7.musicstatmodels.representation.metadata.KeySignature;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;

/**
 * Created by asanyal on 9/16/15.
 *
 * A simple criteria based on whether the key signature is the same
 * as an input key signature
 */
public class KeySignatureEqualityCriteria implements AbstractCriteria {

    // Key signature element
    private KeySignature keySignature;

    /**
     * Constructor for key signature
     * @param requiredKeySignature
     */
    public KeySignatureEqualityCriteria(final KeySignature requiredKeySignature) {
        this.keySignature = requiredKeySignature;
    }

    @Override
    public boolean getCriteriaEvaluation(final Song song) {
        return song.getMetadata().getKeySignature().equals(keySignature);
    }
}
