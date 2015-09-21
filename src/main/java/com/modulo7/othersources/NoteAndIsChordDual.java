package com.modulo7.othersources;

import com.modulo7.musicstatmodels.representation.buildingblocks.Note;
import com.modulo7.musicstatmodels.representation.buildingblocks.NoteDuration;

/**
 * A helper class for crunching chords in music xml in basic XML
 *
 * This class contains a note as it appears in music xml note tag and
 * a boolean which states whether note tag is also tagged with chord tag
 */
public class NoteAndIsChordDual {

    private Note note;

    private boolean isChordElement;

    private double duration;

    private NoteDuration theoreticalDuration = NoteDuration.UNKNOWN;

    public NoteAndIsChordDual(final Note note, final boolean isChordElement) {
        this.note = note;
        this.isChordElement = isChordElement;
    }

    /**
     * Full constructor
     * @param note
     * @param isChordElement
     * @param duration
     * @param theoreticalDuration
     */
    public NoteAndIsChordDual(final Note note, final boolean isChordElement, final double duration, final NoteDuration theoreticalDuration) {
        this.note = note;
        this.isChordElement = isChordElement;
        this.duration = duration;
        this.theoreticalDuration = theoreticalDuration;
    }

    public Note getNote() {
        return note;
    }

    public boolean isChordElement() {
        return isChordElement;
    }

    public double getDuration() {
        return duration;
    }

    public NoteDuration getTheoreticalDuration() {
        return theoreticalDuration;
    }
}
