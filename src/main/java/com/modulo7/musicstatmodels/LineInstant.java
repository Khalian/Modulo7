package com.modulo7.musicstatmodels;

import com.modulo7.common.Modulo7InvalidLineInstantSizeException;

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
 *
 * Each line of a song can be distinctly used for custom similarity analysis
 *
 * An instance is either a chord or a melodic note in western music. It only refers
 * to be percussive sound.
 *
 */
public class LineInstant {

    // Whether the note is a part of a chord or a melody
    private LineInstantType noteType;

    // Is the instant sustained or played for an imperceptible instant
    private boolean isSustained;

    // The duration for which the instant is played
    private double duration;

    // An expression of the velocity of the key being struck, or how the
    // string was struck. Attack is a good objective indicator of the loudness of that
    // particular node
    private double attack;

    // This set of notes is an expression of how many notes are present in this instant
    // For example in pure melodies, this set would always
    private Set<Note> setOfNotes;

    /**
     * Basic constructor of the line instant class
     * This class can
     *
     * @param noteType
     */
    public LineInstant(LineInstantType noteType) {
        this.noteType = noteType;
        setOfNotes = new HashSet<>();
    }

    /**
     *
     * @param noteSet
     */
    public LineInstant(Set<Note> noteSet) throws Modulo7InvalidLineInstantSizeException {

        if (noteSet.size() == 0) {
            throw new Modulo7InvalidLineInstantSizeException("Line Instant Cannot be of size" + noteSet.size());
        }

        setOfNotes = noteSet;

        if (setOfNotes.size() == 1) {
            noteType = LineInstantType.SINGLE_NOTE;
        } else {
            noteType = LineInstantType.CHORD;
        }
    }

    /**
     * Getter for duration of the note
     * @return
     */
    public double getDuration() {
        return duration;
    }

    public boolean isSustained() {
        return isSustained;
    }

    public void setIsSustained(boolean isSustained) {
        this.isSustained = isSustained;
    }

    public LineInstantType getNoteType() {
        return noteType;
    }

    public void setNoteType(LineInstantType noteType) {
        this.noteType = noteType;
    }
}
