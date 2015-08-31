package com.modulo7.musicstatmodels.representation;

import com.modulo7.common.utils.Modulo7Globals;

/**
 * Created by asanyal on 7/25/2015.
 * <p>
 *
 * Metadata associated with the time signature of the song
 */
public class TimeSignature {

    // Which note of the measure is the associated with the beat
    private int noteValIsBeat;

    // How many beats are there per measure
    private int beatsPerMeasure;

    // A string expression of the type of time signature, also known as the meter
    // of a song
    private String timeSignatureType = Modulo7Globals.UNKNOWNSTRING;


    public TimeSignature() {

    }

    public TimeSignature(final int noteValIsBeat, final int beatsPerMeasure) {
        this.beatsPerMeasure = beatsPerMeasure;
        this.noteValIsBeat = noteValIsBeat;

        inferTimeSignatureType();
    }

    /**
     * Method which infers the type of the time singature depending on the
     * <p>
     * Information acquired from : http://openmusictheory.com/meter.html
     */
    private void inferTimeSignatureType() {
        if (beatsPerMeasure == 2)
            timeSignatureType = "Simple_Duple_Meter";
        else if (beatsPerMeasure == 3)
            timeSignatureType = "Simple_Triple_Meter";
        else if (beatsPerMeasure == 4)
            timeSignatureType = "Simple_Quadruple_Meter";
        else if (beatsPerMeasure == 6)
            timeSignatureType = "Compound_Duple_Meter";
        else if (beatsPerMeasure == 9)
            timeSignatureType = "Compound_Triple_Meter";
        else if (beatsPerMeasure == 12)
            timeSignatureType = "Compound_Quadruple_Meter";
        else
            timeSignatureType = "Complex_Meter";
    }

    /**
     * Gets which note of the measure is associated with the beat
     * @return
     */
    public int getNoteValIsBeat() {
        return noteValIsBeat;
    }

    /**
     * Gets the number of beats per measure
     * @return
     */
    public int getBeatsPerMeasure() {
        return beatsPerMeasure;
    }
}
