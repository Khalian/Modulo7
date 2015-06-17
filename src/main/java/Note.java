/**
 * Created by asanyal on 6/16/2015.
 *
 * This enum describes the notes available (TODO : Describe a validity check)
 */
public enum Note {

    A("A"),
    ASHARP("A#"),
    B("B"),
    C("C"),
    CSHARP("C#"),
    D("D"),
    DSHARP("D#"),
    E("E"),
    F("F"),
    FSHARP("F#"),
    G("G"),
    GSHARP("G#");

    private String noteValue;

    /**
     * Default constructor for note
     * @param noteValue
     */
    Note(String noteValue) {
        String baseNoteWithoutAccidental = noteValue.substring(0, 1).toUpperCase();
        String standardizedNode = baseNoteWithoutAccidental + noteValue.substring(1, 2);
        this.noteValue = standardizedNode;
        harmonicEquivalence(noteValue);
    }

    /**
     * Standarize notes via harmonic equivalence principles to sharps
     * instead of flats
     * @param noteValue
     */
    private void harmonicEquivalence(String noteValue) {
        if (noteValue.equals("Bb"))
            this.noteValue = "A#";
        else if (noteValue.equals("Db"))
            this.noteValue = "C#";
        else if (noteValue.equals("Gb"))
            this.noteValue = "F#";
        else if (noteValue.equals("Ab"))
            this.noteValue = "G#";
    }
}
