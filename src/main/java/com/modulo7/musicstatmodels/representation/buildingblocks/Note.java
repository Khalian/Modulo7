package com.modulo7.musicstatmodels.representation.buildingblocks;

import com.modulo7.common.exceptions.Modulo7BadNoteException;
import com.modulo7.common.exceptions.Modulo7InvalidOctaveRangeException;
import com.modulo7.common.utils.FrequencyNoteMap;

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

    // An instance of the frequency note map object
    private static FrequencyNoteMap noteMap = FrequencyNoteMap.getInstance();

    /**
     * Default constructor for note
     * @param noteValue
     */
    Note(final String noteValue, final int octaveNumber) {
        String baseNoteWithoutAccidental = noteValue.substring(0, 1).toUpperCase();
        String standardizedNode;

        // Add the accidental if it is present
        if (noteValue.length() > 1) {
            standardizedNode = baseNoteWithoutAccidental + noteValue.substring(1, 2);
        } else {
            standardizedNode = baseNoteWithoutAccidental;
        }

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
    public String getNoteValue() {
        return noteValue;
    }

    /**
     * Get the octave number associated with this
     * @return
     */
    public Integer getOctaveNumber() {
        return octaveNumber;
    }

    /**
     * Acquire a note enum given the noteValue, asssume the 4th octave as the default
     *
     * @param noteValue
     * @param octaveNumber
     * @return
     */
    public static Note getNoteValue(final String noteValue, final int octaveNumber) throws Modulo7BadNoteException {
        if (noteValue.equalsIgnoreCase("A") && octaveNumber == 1) {
            return Note.A1;
        } else if (noteValue.equalsIgnoreCase("A#") && octaveNumber == 1) {
            return Note.ASHARP1;
        } else if (noteValue.equalsIgnoreCase("B") && octaveNumber == 1) {
            return Note.B1;
        } else if (noteValue.equalsIgnoreCase("C") && octaveNumber == 1) {
            return Note.C1;
        } else if (noteValue.equalsIgnoreCase("C#") && octaveNumber == 1) {
            return Note.CSHARP1;
        } else if (noteValue.equalsIgnoreCase("D") && octaveNumber == 1) {
            return Note.D1;
        }  else if (noteValue.equalsIgnoreCase("D#") && octaveNumber == 1) {
            return Note.DSHARP1;
        } else if (noteValue.equalsIgnoreCase("E") && octaveNumber == 1) {
            return Note.E1;
        } else if (noteValue.equalsIgnoreCase("F") && octaveNumber == 1) {
            return Note.F1;
        } else if (noteValue.equalsIgnoreCase("F#") && octaveNumber == 1) {
            return Note.FSHARP1;
        } else if (noteValue.equalsIgnoreCase("G") && octaveNumber == 1) {
            return Note.G1;
        } else if (noteValue.equalsIgnoreCase("G#") && octaveNumber == 1) {
            return Note.GSHARP1;
        } else if (noteValue.equalsIgnoreCase("A") && octaveNumber == 2) {
            return Note.A2;
        } else if (noteValue.equalsIgnoreCase("A#") && octaveNumber == 2) {
            return Note.ASHARP2;
        } else if (noteValue.equalsIgnoreCase("B") && octaveNumber == 2) {
            return Note.B2;
        } else if (noteValue.equalsIgnoreCase("C") && octaveNumber == 2) {
            return Note.C2;
        } else if (noteValue.equalsIgnoreCase("C#") && octaveNumber == 2) {
            return Note.CSHARP2;
        } else if (noteValue.equalsIgnoreCase("D") && octaveNumber == 2) {
            return Note.D2;
        }  else if (noteValue.equalsIgnoreCase("D#") && octaveNumber == 2) {
            return Note.DSHARP2;
        } else if (noteValue.equalsIgnoreCase("E") && octaveNumber == 2) {
            return Note.E2;
        } else if (noteValue.equalsIgnoreCase("F") && octaveNumber == 2) {
            return Note.F2;
        } else if (noteValue.equalsIgnoreCase("F#") && octaveNumber == 2) {
            return Note.FSHARP2;
        } else if (noteValue.equalsIgnoreCase("G") && octaveNumber == 2) {
            return Note.G2;
        } else if (noteValue.equalsIgnoreCase("G#") && octaveNumber == 2) {
            return Note.GSHARP2;
        } else if (noteValue.equalsIgnoreCase("A") && octaveNumber == 3) {
            return Note.A3;
        } else if (noteValue.equalsIgnoreCase("A#") && octaveNumber == 3) {
            return Note.ASHARP3;
        } else if (noteValue.equalsIgnoreCase("B") && octaveNumber == 3) {
            return Note.B3;
        } else if (noteValue.equalsIgnoreCase("C") && octaveNumber == 3) {
            return Note.C3;
        } else if (noteValue.equalsIgnoreCase("C#") && octaveNumber == 3) {
            return Note.CSHARP3;
        } else if (noteValue.equalsIgnoreCase("D") && octaveNumber == 3) {
            return Note.D3;
        }  else if (noteValue.equalsIgnoreCase("D#") && octaveNumber == 3) {
            return Note.DSHARP3;
        } else if (noteValue.equalsIgnoreCase("E") && octaveNumber == 3) {
            return Note.E3;
        } else if (noteValue.equalsIgnoreCase("F") && octaveNumber == 3) {
            return Note.F3;
        } else if (noteValue.equalsIgnoreCase("F#") && octaveNumber == 3) {
            return Note.FSHARP3;
        } else if (noteValue.equalsIgnoreCase("G") && octaveNumber == 3) {
            return Note.G3;
        } else if (noteValue.equalsIgnoreCase("G#") && octaveNumber == 3) {
            return Note.GSHARP3;
        } else if (noteValue.equalsIgnoreCase("A") && octaveNumber == 4) {
            return Note.A4;
        } else if (noteValue.equalsIgnoreCase("A#") && octaveNumber == 4) {
            return Note.ASHARP4;
        } else if (noteValue.equalsIgnoreCase("B") && octaveNumber == 4) {
            return Note.B4;
        } else if (noteValue.equalsIgnoreCase("C") && octaveNumber == 4) {
            return Note.C4;
        } else if (noteValue.equalsIgnoreCase("C#") && octaveNumber == 4) {
            return Note.CSHARP4;
        } else if (noteValue.equalsIgnoreCase("D") && octaveNumber == 4) {
            return Note.D4;
        }  else if (noteValue.equalsIgnoreCase("D#") && octaveNumber == 4) {
            return Note.DSHARP4;
        } else if (noteValue.equalsIgnoreCase("E") && octaveNumber == 4) {
            return Note.E4;
        } else if (noteValue.equalsIgnoreCase("F") && octaveNumber == 4) {
            return Note.F4;
        } else if (noteValue.equalsIgnoreCase("F#") && octaveNumber == 4) {
            return Note.FSHARP4;
        } else if (noteValue.equalsIgnoreCase("G") && octaveNumber == 4) {
            return Note.G4;
        } else if (noteValue.equalsIgnoreCase("G#") && octaveNumber == 4) {
            return Note.GSHARP4;
        } else if (noteValue.equalsIgnoreCase("A") && octaveNumber == 5) {
            return Note.A5;
        } else if (noteValue.equalsIgnoreCase("A#") && octaveNumber == 5) {
            return Note.ASHARP5;
        } else if (noteValue.equalsIgnoreCase("B") && octaveNumber == 5) {
            return Note.B5;
        } else if (noteValue.equalsIgnoreCase("C") && octaveNumber == 5) {
            return Note.C5;
        } else if (noteValue.equalsIgnoreCase("C#") && octaveNumber == 5) {
            return Note.CSHARP5;
        } else if (noteValue.equalsIgnoreCase("D") && octaveNumber == 5) {
            return Note.D5;
        }  else if (noteValue.equalsIgnoreCase("D#") && octaveNumber == 5) {
            return Note.DSHARP5;
        } else if (noteValue.equalsIgnoreCase("E") && octaveNumber == 5) {
            return Note.E5;
        } else if (noteValue.equalsIgnoreCase("F") && octaveNumber == 5) {
            return Note.F5;
        } else if (noteValue.equalsIgnoreCase("F#") && octaveNumber == 5) {
            return Note.FSHARP5;
        } else if (noteValue.equalsIgnoreCase("G") && octaveNumber == 5) {
            return Note.G5;
        } else if (noteValue.equalsIgnoreCase("G#") && octaveNumber == 5) {
            return Note.GSHARP5;
        } else if (noteValue.equalsIgnoreCase("A") && octaveNumber == 6) {
            return Note.A6;
        } else if (noteValue.equalsIgnoreCase("A#") && octaveNumber == 6) {
            return Note.ASHARP6;
        } else if (noteValue.equalsIgnoreCase("B") && octaveNumber == 6) {
            return Note.B6;
        } else if (noteValue.equalsIgnoreCase("C") && octaveNumber == 6) {
            return Note.C6;
        } else if (noteValue.equalsIgnoreCase("C#") && octaveNumber == 6) {
            return Note.CSHARP6;
        } else if (noteValue.equalsIgnoreCase("D") && octaveNumber == 6) {
            return Note.D6;
        }  else if (noteValue.equalsIgnoreCase("D#") && octaveNumber == 6) {
            return Note.DSHARP6;
        } else if (noteValue.equalsIgnoreCase("E") && octaveNumber == 6) {
            return Note.E6;
        } else if (noteValue.equalsIgnoreCase("F") && octaveNumber == 6) {
            return Note.F6;
        } else if (noteValue.equalsIgnoreCase("F#") && octaveNumber == 6) {
            return Note.FSHARP6;
        } else if (noteValue.equalsIgnoreCase("G") && octaveNumber == 6) {
            return Note.G6;
        } else if (noteValue.equalsIgnoreCase("G#") && octaveNumber == 6) {
            return Note.GSHARP6;
        } else if (noteValue.equalsIgnoreCase("A") && octaveNumber == 7) {
            return Note.A7;
        } else if (noteValue.equalsIgnoreCase("A#") && octaveNumber == 7) {
            return Note.ASHARP7;
        } else if (noteValue.equalsIgnoreCase("B") && octaveNumber == 7) {
            return Note.B7;
        } else if (noteValue.equalsIgnoreCase("C") && octaveNumber == 7) {
            return Note.C7;
        } else if (noteValue.equalsIgnoreCase("C#") && octaveNumber == 7) {
            return Note.CSHARP7;
        } else if (noteValue.equalsIgnoreCase("D") && octaveNumber == 7) {
            return Note.D7;
        } else if (noteValue.equalsIgnoreCase("D#") && octaveNumber == 7) {
            return Note.DSHARP7;
        } else if (noteValue.equalsIgnoreCase("E") && octaveNumber == 7) {
            return Note.E7;
        } else if (noteValue.equalsIgnoreCase("F") && octaveNumber == 7) {
            return Note.F7;
        } else if (noteValue.equalsIgnoreCase("F#") && octaveNumber == 7) {
            return Note.FSHARP7;
        } else if (noteValue.equalsIgnoreCase("G") && octaveNumber == 7) {
            return Note.G7;
        } else if (noteValue.equalsIgnoreCase("G#") && octaveNumber == 7) {
            return Note.GSHARP7;
        } else if (noteValue.equalsIgnoreCase("A") && octaveNumber == 8) {
            return Note.A8;
        } else if (noteValue.equalsIgnoreCase("A#") && octaveNumber == 8) {
            return Note.ASHARP8;
        } else if (noteValue.equalsIgnoreCase("B") && octaveNumber == 8) {
            return Note.B8;
        } else if (noteValue.equalsIgnoreCase("C") && octaveNumber == 8) {
            return Note.C8;
        } else if (noteValue.equalsIgnoreCase("C#") && octaveNumber == 8) {
            return Note.CSHARP8;
        } else if (noteValue.equalsIgnoreCase("D") && octaveNumber == 8) {
            return Note.D8;
        }  else if (noteValue.equalsIgnoreCase("D#") && octaveNumber == 8) {
            return Note.DSHARP8;
        } else if (noteValue.equalsIgnoreCase("E") && octaveNumber == 8) {
            return Note.E8;
        } else if (noteValue.equalsIgnoreCase("F") && octaveNumber == 8) {
            return Note.F8;
        } else if (noteValue.equalsIgnoreCase("F#") && octaveNumber == 8) {
            return Note.FSHARP8;
        } else if (noteValue.equalsIgnoreCase("G") && octaveNumber == 8) {
            return Note.G8;
        } else if (noteValue.equalsIgnoreCase("G#") && octaveNumber == 8) {
            return Note.GSHARP8;
        } else {
            throw new Modulo7BadNoteException("Bad note: " + noteValue + "and " + octaveNumber);
        }
    }

    /**
     * Acquire a note enum given the noteValue, asssume the 4th octave as the default
     *
     * @param noteValue
     * @return
     */
    public static Note getNoteValue (final String noteValue) throws Modulo7BadNoteException {
        if (noteValue.equalsIgnoreCase("A")) {
            return Note.A4;
        } else if (noteValue.equalsIgnoreCase("A#")) {
            return Note.ASHARP4;
        } else if (noteValue.equalsIgnoreCase("B")) {
            return Note.B4;
        } else if (noteValue.equalsIgnoreCase("C")) {
            return Note.C4;
        } else if (noteValue.equalsIgnoreCase("C#")) {
            return Note.CSHARP4;
        } else if (noteValue.equalsIgnoreCase("D")) {
            return Note.D4;
        }  else if (noteValue.equalsIgnoreCase("D#")) {
            return Note.DSHARP4;
        } else if (noteValue.equalsIgnoreCase("E")) {
            return Note.E4;
        } else if (noteValue.equalsIgnoreCase("F")) {
            return Note.F4;
        } else if (noteValue.equalsIgnoreCase("F#")) {
            return Note.FSHARP4;
        } else if (noteValue.equalsIgnoreCase("G")) {
            return Note.G4;
        }  else if (noteValue.equalsIgnoreCase("G#")) {
            return Note.GSHARP4;
        } else {
            throw new Modulo7BadNoteException("Bad note: " + noteValue);
        }
    }

    /**
     * Method to ascertain whether the first argument pitch is higher than the
     * second argument pitch
     *
     * @param thisNote
     * @param thatNote
     * @return
     */
    public static boolean isHigherPitch(final Note thisNote, final Note thatNote) {
        final int positionOne = noteMap.getPositionGivenNote(thisNote);
        final int positionTwo = noteMap.getPositionGivenNote(thatNote);

        return positionOne > positionTwo;
    }

    /**
     * Method to ascertain whether the first argument pitch is lower than the
     * second argument pitch
     *
     * @param thisNote
     * @param thatNote
     * @return
     */
    public static boolean isLowerPitch(final Note thisNote, final Note thatNote) {
        final int positionOne = noteMap.getPositionGivenNote(thisNote);
        final int positionTwo = noteMap.getPositionGivenNote(thatNote);

        return positionOne < positionTwo;
    }

}
