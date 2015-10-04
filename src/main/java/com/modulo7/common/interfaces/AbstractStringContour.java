package com.modulo7.common.interfaces;

import com.modulo7.musicstatmodels.representation.monophonic.Voice;

/**
 * Created by asanyal on 10/4/15.
 *
 * Text represenatations of contour
 */
public interface AbstractStringContour {

    /**
     * Gets the string representation of contour
     * @param voice
     * @return
     */
    public String getContourRepresentaionOfVoice(final Voice voice);
}
