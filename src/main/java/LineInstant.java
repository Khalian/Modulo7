import java.util.HashSet;
import java.util.Set;

/**
 * Created by asanyal on 6/16/2015.
 *
 * A line instant is a basic class that encapsulates all the information at a particular
 * instant in a line within a song.
 *
 * Typically a song can be expressed with multiple lines being played (an example would be
 * a rock song with 4 lines - a guitar line, a bass line, a vocal line and a drums (percussion line)
 */
public class LineInstant {

    // Whether the note is a part of a chord or a melody
    private LineInstantType noteType;

    // Is the instant sustained or played for an imperceptible instant
    private boolean isSustained;

    // The duration for which the instant is played
    private double duration;

    // This set of notes is an expression of how many notes are present in this instant
    // For example in pure melodies, this set would always
    private Set<Note> setOfNotes;

    /**
     * Basic constructor of note
     * @param noteType
     */
    public LineInstant(LineInstantType noteType) {
        this.noteType = noteType;
        setOfNotes = new HashSet<>();
    }
}
