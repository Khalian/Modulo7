package com.modulo7.musicstatmodels.representation.metadata;

import com.modulo7.common.utils.Modulo7Globals;

/**
 * Created by asanyal on 7/25/2015.
 * <p>
 *
 * Metadata associated with the time signature of the song
 */
public class TimeSignature {

    // Which note of the measure is the associated with the beat, e,g
    // if val = 1 then whole notes get the beat, if val = 4, then quarter note gets
    // the beat
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimeSignature)) return false;

        TimeSignature that = (TimeSignature) o;

        if (beatsPerMeasure != that.beatsPerMeasure) return false;
        if (noteValIsBeat != that.noteValIsBeat) return false;
        if (!timeSignatureType.equals(that.timeSignatureType)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = noteValIsBeat;
        result = 31 * result + beatsPerMeasure;
        result = 31 * result + timeSignatureType.hashCode();
        return result;
    }

    /**
     * Getter for time signature type

     * @return
     */
    public String getTimeSignatureType() {
        return timeSignatureType;
    }
}
