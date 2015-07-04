package com.modulo7.musicstatmodels;

/**
 * Created by asanyal on 6/29/2015.
 *
 * This class expresses the configurations associated with the song
 * which is true for the song throughout
 */
public class SongConfiguration {

    // Tempo of the song, another alias for this is BPM (beats per minute)
    private int tempo;

    // The time signature associated with this song
    private TimeSignature timeSignature;




}

/**
 * Metadata associated with the time signature of a song
 */
class TimeSignature {

    // Which note of the measure is the associated with the beat
    private int noteValIsBeat;

    // How many beats are there per measure
    private int beatsPerMeasure;

    // A string expression of the type of time signature, also known as the meter
    // of a song
    private String timeSignatureType;

    public TimeSignature(final int noteValIsBeat, final int beatsPerMeasure) {
        this.beatsPerMeasure = beatsPerMeasure;
        this.noteValIsBeat = noteValIsBeat;
        
        inferTimeSignatureType();
    }

    /**
     * Method which infers the type of the time singature depending on the
     *
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
}


/**
 * Most songs are assoicated with a key signature in western music
 *
 * A key signature defines the tonic of the song (also called the root note of the song)
 */
class KeySigntaure {

    // The key of the key signature
    private Note key;

    // The scale associated with this song
    private ScaleType scale;

    public KeySigntaure(Note key, ScaleType scale) {

    }
}
