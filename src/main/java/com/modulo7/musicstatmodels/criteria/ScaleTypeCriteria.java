package com.modulo7.musicstatmodels.criteria;

import com.modulo7.common.interfaces.AbstractCriteria;
import com.modulo7.musicstatmodels.representation.metadata.ScaleType;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;

/**
 * Created by asanyal on 12/26/15.
 *
 * Cross check for the scale being of a particular type
 */
public class ScaleTypeCriteria implements AbstractCriteria {

    // The scale type for this criteria
    private ScaleType scaleType;

    /**
     * Constructor for key signature
     * @param requiredScale
     */
    public ScaleTypeCriteria(final ScaleType requiredScale) {
        this.scaleType = requiredScale;
    }

    @Override
    public boolean getCriteriaEvaluation(final Song song) {
        return song.getMetadata().getKeySignature().getScale().equals(scaleType);
    }
}
