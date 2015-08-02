package com.modulo7.musicstatmodels.representation;

import com.modulo7.common.exceptions.Modulo7InvalidLineInstantSizeException;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by asanyal on 6/16/2015.
 *
 * A voice instant is a basic class that encapsulates all the information at a particular
 * instant in a voice within a song.
 *
 * Typically a song can be expressed with multiple voice being played (an example would be
 * a rock song with 4 lines - a guitar line, a bass line, a vocal line and a drums (percussion line)
 *
 * Each line of a song can be distinctly used for custom similarity analysis
 *
 * An instance is either a chord or a melodic note in western music. It only refers
 * to be percussive sound.
 *
 */
public class VoiceInstant {

    // Whether the note is a part of a chord or a melody
    private VoiceInstantType noteType;

    // Is the instant sustained or played for an imperceptible instant
    private boolean isSustained;

    // The duration for which the instant is played
    private double duration;

    // An expression of the velocity of the key being struck, or how the
    // string was struck. Attack is a good objective indicator of the loudness of that
    // particular note. If the attack is unknown, its assumed a default value
    private double attack;

    // This set of notes is an expression of how many notes are present in this instant
    // For example in pure melodies, this set would always
    private Set<Note> setOfNotes = new HashSet<>();

    // Denotes an unknown in either attack or duration
    private static final double UNKNOWN = -1.0;

    /**
     * Basic constructor of the line instant class with both the attack and duration clearly defined
     *
     * @param noteSet
     * @param attack
     * @param duration
     */
    public VoiceInstant(final Set<Note> noteSet, final double duration, final double attack)
            throws Modulo7InvalidLineInstantSizeException {

        if (noteSet.size() == 0) {
            throw new Modulo7InvalidLineInstantSizeException("Voice Instant Cannot be of size" + noteSet.size());
        }

        setOfNotes = noteSet;

        if (setOfNotes.size() == 1) {
            noteType = VoiceInstantType.SINGLE_NOTE;
        } else {
            noteType = VoiceInstantType.CHORD;
        }

        this.duration = duration;
        this.attack = attack;
    }

    /**
     *
     * This constructor denotes uncertainty in the duration and attack
     *
     * @param noteSet
     */
    public VoiceInstant(final Set<Note> noteSet) throws Modulo7InvalidLineInstantSizeException {

        if (noteSet.size() == 0) {
            throw new Modulo7InvalidLineInstantSizeException("Voice Instant Cannot be of size" + noteSet.size());
        }

        setOfNotes = noteSet;

        if (setOfNotes.size() == 1) {
            noteType = VoiceInstantType.SINGLE_NOTE;
        } else {
            noteType = VoiceInstantType.CHORD;
        }

        duration = UNKNOWN;
        attack = UNKNOWN;
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

    public void setIsSustained(final boolean isSustained) {
        this.isSustained = isSustained;
    }

    public VoiceInstantType getNoteType() {
        return noteType;
    }

    public void setNoteType(final VoiceInstantType noteType) {
        this.noteType = noteType;
    }

    public double getAttack() {
        return attack;
    }
}
