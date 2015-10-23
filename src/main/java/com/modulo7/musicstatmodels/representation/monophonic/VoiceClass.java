package com.modulo7.musicstatmodels.representation.monophonic;

/**
 * Created by asanyal on 10/18/15.
 *
 * Classifications of voices in choral music
 */
public enum VoiceClass {
    SOPRAN0("soprano"),
    ALTO("alto"),
    TENOR("tenor"),
    BASS("bass"),
    GENERIC("generic");         // Generic voices are also voices which dont fit into any particular criteria

    final String voiceClass;

    VoiceClass(String voice) {
        voiceClass = voice;
    }

    /**
     * Gets the voice class string representation of the voice
     * @return
     */
    public String getVoiceClassStringRep() {
        return voiceClass;
    }

    /**
     * Returns the voice class enum representation given string representation
     * @param strForm
     * @return
     */
    public static VoiceClass getVoiceClassGivenString(final String strForm) {
        if (strForm.equalsIgnoreCase("soprano")) {
            return SOPRAN0;
        } else  if (strForm.equalsIgnoreCase("alto")) {
            return ALTO;
        } else if (strForm.equalsIgnoreCase("tenor")) {
            return TENOR;
        } else if (strForm.equalsIgnoreCase("bass")) {
            return BASS;
        } else {
            return GENERIC;
        }
    }
}
