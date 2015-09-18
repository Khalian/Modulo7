package com.modulo7.musicstatmodels.criteria;

import com.modulo7.common.interfaces.AbstractCriteria;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;

/**
 * Created by asanyal on 9/16/15lo
 *
 * A very simple criteria to judge whether a song is polyphonic or monophoic
 * This criteria is a basis on top of which many criteria is built on
 *
 * It returns whether the song is polyphonic or not
 */
public class PolyphonyCriteria implements AbstractCriteria {
    @Override
    public boolean getCriteriaEvaluation(final Song song) {
        return song.getNumVoices() == 1;
    }
}
