package com.modulo7.common.interfaces;

import com.modulo7.musicstatmodels.representation.monophonic.Voice;

/**
 * Created by asanyal on 9/6/15.
 *
 * A contour is a representation of a shape of the melody. Modulo7 represents it as a reimagined voice
 *
 * In order words certain operations are performed on the voice to reduce the number
 */
public interface AbstractContour {

    public Voice getContourRepresentaionOfVoice(final Voice voice);
}
