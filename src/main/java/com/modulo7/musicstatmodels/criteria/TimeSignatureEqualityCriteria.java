package com.modulo7.musicstatmodels.criteria;

import com.modulo7.common.interfaces.AbstractCriteria;
import com.modulo7.musicstatmodels.representation.metadata.SongMetadata;
import com.modulo7.musicstatmodels.representation.metadata.TimeSignature;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;

/**
 * Created by asanyal on 10/10/15
 *
 * To check if a song has the same time signature as a desired value
 */
public class TimeSignatureEqualityCriteria implements AbstractCriteria {

    // The desired time signature of a song
    private TimeSignature timeSignature;

    /**
     * Basic constructor that takes as an argument the desired time signature
     * @param signature
     */
    public TimeSignatureEqualityCriteria(final TimeSignature signature) {
        this.timeSignature = signature;
    }

    @Override
    public boolean getCriteriaEvaluation(final Song song) {
        SongMetadata metadata = song.getMetadata();

        if (metadata != null) {
            TimeSignature currSig = metadata.getTimeSignature();
            return currSig == timeSignature;
        }

        return false;
    }
}
