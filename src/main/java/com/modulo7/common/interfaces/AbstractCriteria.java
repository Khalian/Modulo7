package com.modulo7.common.interfaces;

import com.modulo7.musicstatmodels.representation.polyphonic.Song;

/**
 * Created by asanyal on 8/29/15.
 *
 * Criteria's are predicates about a particular music theoretic assertion
 * that a song satisfies or not
 */
public interface AbstractCriteria {

    /**
     * Returns whether the song satisfies a particular criteria or not
     *
     * @param song
     * @return
     */
    public boolean getCriteriaEvaluation(final Song song);
}
