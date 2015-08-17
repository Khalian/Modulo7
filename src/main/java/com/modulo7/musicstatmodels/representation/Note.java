package com.modulo7.musicstatmodels.representation;

import com.modulo7.common.exceptions.Modulo7BadNoteException;
import com.modulo7.common.exceptions.Modulo7InvalidOctaveRangeException;

/**
 * Created by asanyal on 6/16/2015.
 *
 * This enum describes the notes in western music theory
 *
 * Typically a note is Note is a representation of a set frequency, notes are arranged
 * in octaves
 */
public enum Note {

    // All the notes
    A0("A", 0), ASHARP0("A#", 0), B0("B", 0), C0("C", 0), CSHARP0("C#", 0), D0("D", 0), DSHARP0("D#", 0), E0("E", 0),
    F0("F", 0), FSHARP0("F#", 0), G0("G", 0), GSHARP0("G#", 0),

    A1("A", 1), ASHARP1("A#", 1), B1("B", 1), C1("C", 1), CSHARP1("C#", 1), D1("D", 1), DSHARP1("D#", 1), E1("E", 1),
    F1("F", 1), FSHARP1("F#", 1), G1("G", 1), GSHARP1("G#", 1),

    A2("A", 2), ASHARP2("A#", 2), B2("B", 2), C2("C", 2), CSHARP2("C#", 2), D2("D", 2), DSHARP2("D#", 2), E2("E", 2),
    F2("F", 2), FSHARP2("F#", 2), G2("G", 2), GSHARP2("G#", 2),

    A3("A", 3), ASHARP3("A#", 3), B3("B", 3), C3("C", 3), CSHARP3("C#", 3), D3("D", 3), DSHARP3("D#", 3), E3("E", 3),
    F3("F", 3), FSHARP3("F#", 3), G3("G", 3), GSHARP3("G#", 3),

    A4("A", 4), ASHARP4("A#", 4), B4("B", 4), C4("C", 4), CSHARP4("C#", 4), D4("D", 4), DSHARP4("D#", 4), E4("E", 4),
    F4("F", 4), FSHARP4("F#", 4), G4("G", 4), GSHARP4("G#", 4),

    A5("A", 5), ASHARP5("A#", 5), B5("B", 5), C5("C", 5), CSHARP5("C#", 5), D5("D", 5), DSHARP5("D#", 5), E5("E", 5),
    F5("F", 5), FSHARP5("F#", 5), G5("G", 5), GSHARP5("G#", 5),

    A6("A", 6), ASHARP6("A#", 6), B6("B", 6), C6("C", 6), CSHARP6("C#", 6), D6("D", 6), DSHARP6("D#", 6), E6("E", 6),
    F6("F", 6), FSHARP6("F#", 6), G6("G", 6), GSHARP6("G#", 6),

    A7("A", 7), ASHARP7("A#", 7), B7("B", 7), C7("C", 7), CSHARP7("C#", 7), D7("D", 7), DSHARP7("D#", 7), E7("E", 7),
    F7("F", 7), FSHARP7("F#", 7), G7("G", 7), GSHARP7("G#", 7),

    A8("A", 8), ASHARP8("A#", 8), B8("B", 8), C8("C", 8), CSHARP8("C#", 0), D8("D", 8), DSHARP8("D#", 8), E8("E", 8),
    F8("F", 8), FSHARP8("F#", 8), G8("G", 8), GSHARP8("G#", 8);

    // The value of the node
    private String noteValue;

    // The octave associated with this node
    private Integer octaveNumber;

    /**
     * Default constructor for note
     * @param noteValue
     */
    Note(final String noteValue, final int octaveNumber) {
        String baseNoteWithoutAccidental = noteValue.substring(0, 1).toUpperCase();
        String standardizedNode = baseNoteWithoutAccidental + noteValue.substring(1, 2);
        this.noteValue = standardizedNode;
        harmonicEquivalence(noteValue);

        try {
            validOctaveNumberCheck(octaveNumber);
        } catch (Modulo7InvalidOctaveRangeException ie) {
            ie.printStackTrace();
        }

        this.octaveNumber = octaveNumber;
    }

    /**
     * Method to check whether the octave number is correct
     * or not
     */
    private void validOctaveNumberCheck(final int octaveNumber) throws Modulo7InvalidOctaveRangeException {
        if (octaveNumber >= 0 && octaveNumber <= 8) {

        } else {
            throw new Modulo7InvalidOctaveRangeException("Octave Number :" + octaveNumber + " is not in range" +
                    "in between 0 and 8");
        }
    }

    /**
     * Standardize notes via harmonic equivalence principles to sharps
     * instead of flats, allowing for easier processing by catering to
     * only one standard
     *
     * @param noteValue
     */
    private void harmonicEquivalence(final String noteValue) {
        if (noteValue.equals("Bb"))
            this.noteValue = "A#";
        else if (noteValue.equals("Db"))
            this.noteValue = "C#";
        else if (noteValue.equals("Gb"))
            this.noteValue = "F#";
        else if (noteValue.equals("Ab"))
            this.noteValue = "G#";
    }

    /**
     * Gets the note value associated with note
     * @return
     */
    private String getNoteValue() {
        return noteValue;
    }

    public Integer getOctaveNumber() {
        return octaveNumber;
    }

    /**
     * Acquire a note enum given the noteValue, asssume the 4th octave as the default
     *
     * TODO : Complete this implementation with a new method which also takes into  account the octave number
     *
     * @param noteValue
     * @return
     */
    public static Note getNoteValue (final String noteValue) throws Modulo7BadNoteException {
        if (noteValue.equalsIgnoreCase("A")) {
            return Note.A4;
        } else if (noteValue.equalsIgnoreCase("B")) {
            return Note.B4;
        } else if (noteValue.equalsIgnoreCase("C")) {
            return Note.C4;
        } else if (noteValue.equalsIgnoreCase("D")) {
            return Note.D4;
        } else if (noteValue.equalsIgnoreCase("E")) {
            return Note.E4;
        } else if (noteValue.equalsIgnoreCase("F")) {
            return Note.F4;
        } else if (noteValue.equalsIgnoreCase("G")) {
            return Note.G4;
        } else {
            throw new Modulo7BadNoteException("Bad note: " + noteValue);
        }
    }
}
