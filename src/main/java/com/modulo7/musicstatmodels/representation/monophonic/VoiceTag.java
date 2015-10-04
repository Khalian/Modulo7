package com.modulo7.musicstatmodels.representation.monophonic;

import com.modulo7.common.utils.Modulo7Globals;
import com.modulo7.musicstatmodels.representation.metadata.Clef;

import java.io.Serializable;

/**
 * Created by asanyal on 9/8/15.
 *
 * Metadata associated with voices ;
 *
 * TODO : Expand on this with meaningful abstractions
 */
public class VoiceTag implements Serializable {

    // The type of instrument being played
    private String instrumentName = Modulo7Globals.UNKNOWNSTRING;

    // In which clef is this voice
    private Clef clef = Clef.Unknown;

    public VoiceTag() {

    }

    /**
     * Standard voice tag constructor
     * @param instrumentName
     * @param clef
     */
    public VoiceTag(final String instrumentName, final Clef clef) {
        this.instrumentName = instrumentName;
        this.clef = clef;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public Clef getClef() {
        return clef;
    }
}
