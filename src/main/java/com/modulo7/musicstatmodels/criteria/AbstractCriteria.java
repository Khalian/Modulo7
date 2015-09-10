package com.modulo7.musicstatmodels.criteria;

import com.modulo7.musicstatmodels.representation.Song;

/**
 * Created by asanyal on 8/29/15.
 *
 * Criteria's are predicates about a particular music theoretic assertion
 * that a song satisfies or not
 */
public abstract class AbstractCriteria {

    /**
     * Returns whether the song satisfies a particular criteria or not
     *
     * @param song
     * @return
     */
    protected abstract boolean getCriteriaEvaluation(final Song song);
}
