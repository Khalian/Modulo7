package com.modulo7.musicstatmodels.representation.monophonic;

import com.modulo7.common.exceptions.Modulo7BadIntervalException;
import com.modulo7.common.exceptions.Modulo7BadNoteException;
import com.modulo7.common.exceptions.Modulo7InvalidVoiceInstantSizeException;
import com.modulo7.common.exceptions.Modulo7WrongNoteType;
import com.modulo7.common.utils.Modulo7Globals;
import com.modulo7.musicstatmodels.musictheorymodels.Interval;
import com.modulo7.musicstatmodels.representation.buildingblocks.ChordQuality;
import com.modulo7.musicstatmodels.representation.buildingblocks.Note;
import com.modulo7.musicstatmodels.representation.buildingblocks.NoteDuration;
import com.modulo7.musicstatmodels.representation.buildingblocks.NoteType;
import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;
import java.util.HashSet;

/**
 * Created by asanyal on 6/16/2015.
 *
 * A voice instant is a basic class that encapsulates all the information at a particular
 * instant in a voice within a song. Think of it as taking a snapshot in the song
 *
 * Typically a song can be expressed with multiple voice being played (an example would be
 * a rock song with 4 lines - a guitar line, a bass line, a vocal line and a drums (percussion line)
 *
 * Each line of a song can be distinctly used for custom similarity analysis
 *
 * An instance is either a chord or a melodic note in western music.
 *
 * TODO : Rests in western music
 */
public class VoiceInstant implements Serializable {

    // Whether the note is a part of a chord or a melody
    private NoteType noteType = NoteType.UNKNOWN;

    // The duration for which the instant is actually played
    private double duration = Modulo7Globals.UNKNOWN;

    // The type of chord in the event the voice instant is a chord, by default assumed not a chord
    private ChordQuality chordQuality = ChordQuality.NOT_A_CHORD;

    // The duration of note that is played according to music theory, by default its unknown
    private NoteDuration theoreticalDuration = NoteDuration.UNKNOWN;

    // An expression of the velocity of the key being struck, or how the
    // string was struck. Attack is a good objective indicator of the loudness of that
    // particular note. If the attack is unknown, its assumed a default value
    private double attack = Modulo7Globals.UNKNOWN;

    // This set of notes is an expression of how many notes are present in this instant
    // For example in pure melodies, this set would always
    private HashSet<Note> setOfNotes = new HashSet<>();

    /**
     * Default constructor for avro
     */
    public VoiceInstant() {

    }

    /**
     * Basic constructor of the line instant class with both the attack and duration clearly defined
     *
     * @param noteSet
     * @param attack
     * @param duration
     */
    public VoiceInstant(final HashSet<Note> noteSet, final double duration, final double attack)
            throws Modulo7InvalidVoiceInstantSizeException, Modulo7BadIntervalException, Modulo7BadNoteException {

        if (noteSet.size() == 0) {
            throw new Modulo7InvalidVoiceInstantSizeException("Voice Instant Cannot be of size" + noteSet.size());
        }

        checkIfAllValidNotes(noteSet);

        setOfNotes = noteSet;

        if (setOfNotes.size() == 1) {
            noteType = NoteType.MELODIC_NOTE;
        } else {
            noteType = NoteType.CHORD;
            this.chordQuality = ChordQuality.estimateChordType(setOfNotes);
        }

        this.duration = duration;
        this.attack = attack;
    }

    /**
     * Basic constructor of the line instant class with both the attack and duration clearly defined
     * The type is a single note
     *
     * @param note
     * @param attack
     * @param duration
     */
    public VoiceInstant(final Note note, final double duration, final double attack)
            throws Modulo7InvalidVoiceInstantSizeException, Modulo7BadNoteException {

        checkIfValidNote(note);

        setOfNotes.add(note);

        noteType = NoteType.MELODIC_NOTE;

        this.duration = duration;
        this.attack = attack;
    }

    /**
     * Check if a single note is valid or not
     * @param note
     */
    private void checkIfValidNote(final Note note) throws Modulo7BadNoteException {
        if (note == null) {
            throw new Modulo7BadNoteException("You cannot add null note");
        }
    }

    /**
     * Basic constructor of the line instant class with the duration clearly defined
     * This constructor asserts attack for this instant is unknown
     *
     * @param noteSet
     * @param duration
     */
    public VoiceInstant(final HashSet<Note> noteSet, final double duration)
            throws Modulo7InvalidVoiceInstantSizeException, Modulo7BadIntervalException, Modulo7BadNoteException {

        if (noteSet.size() == 0) {
            throw new Modulo7InvalidVoiceInstantSizeException("Voice Instant Cannot be of size" + noteSet.size());
        }

        checkIfAllValidNotes(noteSet);

        setOfNotes = noteSet;

        if (setOfNotes.size() == 1) {
            noteType = NoteType.MELODIC_NOTE;
        } else {
            noteType = NoteType.CHORD;
            this.chordQuality = ChordQuality.estimateChordType(setOfNotes);
        }

        this.duration = duration;
        this.attack = Modulo7Globals.UNKNOWN;
    }

    /**
     * Basic constructor of the line instant class with the duration clearly defined
     * This constructor asserts attack for this instant is unknown but the chord quality is
     * apriori
     *
     * @param noteSet
     * @param duration
     * @param chordQuality
     */
    public VoiceInstant(final HashSet<Note> noteSet, final double duration, final ChordQuality chordQuality)
            throws Modulo7InvalidVoiceInstantSizeException, Modulo7BadIntervalException, Modulo7BadNoteException {

        if (noteSet.size() == 0) {
            throw new Modulo7InvalidVoiceInstantSizeException("Voice Instant Cannot be of size" + noteSet.size());
        }

        checkIfAllValidNotes(noteSet);

        setOfNotes = noteSet;

        if (setOfNotes.size() == 1) {
            noteType = NoteType.MELODIC_NOTE;
        } else {
            noteType = NoteType.CHORD;
            this.chordQuality = chordQuality;
        }

        this.duration = duration;
        this.attack = Modulo7Globals.UNKNOWN;
    }

    /**
     * Basic constructor of the line instant class with the duration clearly defined
     * This constructor asserts attack for this instant is unknown
     * The constructor asserts theoretical note duration is known
     *
     * @param noteSet
     * @param theoreticalDuration
     * @param duration
     */
    public VoiceInstant(final HashSet<Note> noteSet, final NoteDuration theoreticalDuration, final double duration)
            throws Modulo7InvalidVoiceInstantSizeException, Modulo7BadIntervalException, Modulo7BadNoteException {

        if (noteSet.size() == 0) {
            throw new Modulo7InvalidVoiceInstantSizeException("Voice Instant Cannot be of size" + noteSet.size());
        }

        checkIfAllValidNotes(noteSet);

        setOfNotes = noteSet;

        if (setOfNotes.size() == 1) {
            noteType = NoteType.MELODIC_NOTE;
        } else {
            noteType = NoteType.CHORD;
            this.chordQuality = ChordQuality.estimateChordType(setOfNotes);
        }

        this.theoreticalDuration = theoreticalDuration;

        this.duration = duration;
        this.attack = Modulo7Globals.UNKNOWN;
    }

    /**
     * Basic constructor of the line instant class with the duration clearly defined
     * This constructor asserts attack for this instant is unknown, and the note type is a single note
     *
     * @param note
     * @param duration
     */
    public VoiceInstant(final Note note, final double duration)
            throws Modulo7InvalidVoiceInstantSizeException, Modulo7BadNoteException {

        checkIfValidNote(note);

        setOfNotes.add(note);

        noteType = NoteType.MELODIC_NOTE;

        this.duration = duration;
        this.attack = Modulo7Globals.UNKNOWN;
    }

    /**
     * Basic constructor of the line instant class with the duration clearly defined
     * This constructor asserts attack for this instant is unknown, and the note type is a single note
     * This contstructor asserts theoretical note duration is known
     *
     * @param note
     * @param theoreticalDuration
     * @param duration
     */
    private VoiceInstant(final Note note, final NoteDuration theoreticalDuration, final double duration)
            throws Modulo7InvalidVoiceInstantSizeException, Modulo7BadNoteException {

        checkIfValidNote(note);

        setOfNotes.add(note);

        noteType = NoteType.MELODIC_NOTE;

        this.theoreticalDuration = theoreticalDuration;
        this.duration = duration;
        this.attack = Modulo7Globals.UNKNOWN;
    }

    /**
     * This constructor denotes uncertainty in the duration and attack
     *
     * @param noteSet
     */
    public VoiceInstant(final HashSet<Note> noteSet) throws Modulo7InvalidVoiceInstantSizeException, Modulo7BadIntervalException, Modulo7BadNoteException {

        if (noteSet.size() == 0) {
            throw new Modulo7InvalidVoiceInstantSizeException("Voice Instant Cannot be of size" + noteSet.size());
        }

        checkIfAllValidNotes(noteSet);

        setOfNotes = noteSet;

        if (setOfNotes.size() == 1) {
            noteType = NoteType.MELODIC_NOTE;
        } else {
            noteType = NoteType.CHORD;
            this.chordQuality = ChordQuality.estimateChordType(setOfNotes);
        }

        duration = Modulo7Globals.UNKNOWN;
        attack = Modulo7Globals.UNKNOWN;
    }

    /**
     * This constructor denotes uncertainty in the duration and attack and the note type is a single note
     *
     * @param note
     */
    public VoiceInstant(final Note note) throws Modulo7InvalidVoiceInstantSizeException, Modulo7BadNoteException {

        checkIfValidNote(note);

        setOfNotes = new HashSet<>();
        setOfNotes.add(note);

        noteType = NoteType.MELODIC_NOTE;

        duration = Modulo7Globals.UNKNOWN;
        attack = Modulo7Globals.UNKNOWN;
    }

    /**
     * Gets the fact that the voice instant is actually
     * a chord or not
     *
     * @return
     */
    public boolean isChord() {
        return noteType.equals(NoteType.CHORD);
    }

    /**
     * Getter for duration of the note
     * @return
     */
    public double getDuration() {
        return duration;
    }

    /**
     * Getter for note type
     * @return
     */
    public NoteType getNoteType() {
        return noteType;
    }

    /**
     * Gets the attack associated with the note
     * @return
     */
    public double getAttack() {
        return attack;
    }


    /**
     * Returns all the notes associated with this voice
     * instant
     *
     * @return
     */
    public HashSet<Note> getAllNotesofInstant() {
        return setOfNotes;
    }

    /**
     * Gets the note value if its a melodic note
     * @return
     * @throws Modulo7WrongNoteType
     */
    public Note getNote() throws Modulo7WrongNoteType {
        if (noteType.equals(NoteType.MELODIC_NOTE)) {
            for (Note note : setOfNotes) {
                return note;
            }
        } else {
            throw new Modulo7WrongNoteType("Note should be a melodic note and not a chord");
        }

        // For the sake of complilation, actually dead code
        return null;
    }

    /**
     * Check if all valid notes are present, i.e sanity test for notes being not null
     * @param notes
     */
    private void checkIfAllValidNotes(HashSet<Note> notes) throws Modulo7BadNoteException {
       for (Note note : notes) {
           checkIfValidNote(note);
       }
    }

    /**
     * Getter for theorectical note duration, as is it should be played by performer
     * and not how it is actually played
     *
     * @return
     */
    public NoteDuration getTheoreticalDuration() {
        return theoreticalDuration;
    }

    /**
     * Acquires the chord type for this instant
     * @return
     */
    public ChordQuality getChordQuality() {
        return chordQuality;
    }

    /**
     * Get a string representation of the voice instant
     * @return
     */
    public String getTokenRepresentation() throws Modulo7WrongNoteType {
        // If its a melodic note then just return the note value representation
        // we eschew octave representation
        if (noteType.equals(NoteType.MELODIC_NOTE)) {
            final Note note = getNote();
            return note.getNoteValue();
        } else {
            final Note rootNote = ChordQuality.getRootNoteFromChord(this.setOfNotes);
            return rootNote.getNoteValue() + chordQuality.getStringRepresentation();
        }
    }

    /**
     * Change the notes in the note seet
     * @param newNoteSet
     */
    public void reassignNotes(final HashSet<Note> newNoteSet) {
        setOfNotes = newNoteSet;
    }

    /**
     * Similar to is higher pitch in note module, for chords considers the
     * root note versus other melodic note
     *
     * @param thisInstant
     * @param thatInstant
     * @return
     * @throws Modulo7WrongNoteType
     */
    public static boolean isHigherPitch(final VoiceInstant thisInstant, final VoiceInstant thatInstant) throws Modulo7WrongNoteType {

        final Note thisNote;

        if (thisInstant.isChord()) {
            thisNote = ChordQuality.getRootNoteFromChord(thisInstant.setOfNotes);
        } else {
            thisNote = thisInstant.getNote();
        }

        final Note thatNote;

        if (thatInstant.isChord()) {
            thatNote = ChordQuality.getRootNoteFromChord(thisInstant.setOfNotes);
        } else {
            thatNote = thatInstant.getNote();
        }

        return Note.isHigherPitch(thisNote, thatNote);
    }

    /**
     * Gets a new Voice Instant from older instance based on intervalic distance
     *
     * @param thisInstant
     * @param intervalInt
     * @return
     * @throws Modulo7WrongNoteType
     * @throws Modulo7BadIntervalException
     */
    public static VoiceInstant getShiftedInstance(final VoiceInstant thisInstant, final int intervalInt) throws Modulo7WrongNoteType, Modulo7BadIntervalException {
        VoiceInstant newInstant = SerializationUtils.clone(thisInstant);

        HashSet<Note> allNotes = newInstant.getAllNotesofInstant();
        HashSet<Note> shiftedNotes = new HashSet<>();

        Interval shiftInterval = Interval.getInterval(intervalInt);

        for (final Note note: allNotes) {
            final Note newNote = Note.getShiftedNote(note, shiftInterval);
            shiftedNotes.add(newNote);
        }

        newInstant.reassignNotes(shiftedNotes);

        return newInstant;
    }

    /**
     * Checks whether two voice instants have the same pith. For chords ,the root note of a chord
     * is considered
     *
     * @param thisInstant
     * @param thatInstant
     * @return
     * @throws Modulo7WrongNoteType
     */
    public static boolean isLowerPitch(final VoiceInstant thisInstant, final VoiceInstant thatInstant) throws Modulo7WrongNoteType {

        final Note thisNote;

        if (thisInstant.isChord()) {
            thisNote = ChordQuality.getRootNoteFromChord(thisInstant.setOfNotes);
        } else {
            thisNote = thisInstant.getNote();
        }

        final Note thatNote;

        if (thatInstant.isChord()) {
            thatNote = ChordQuality.getRootNoteFromChord(thisInstant.setOfNotes);
        } else {
            thatNote = thatInstant.getNote();
        }

        return Note.isLowerPitch(thisNote, thatNote);
    }

    /**
     * Similar to is equal in  pitch in note module, for chords considers the
     *
     * @param thisInstant
     * @param thatInstant
     * @return
     * @throws Modulo7WrongNoteType
     */
    public static boolean isEqualPitch(final VoiceInstant thisInstant, final VoiceInstant thatInstant) throws Modulo7WrongNoteType {

        final Note thisNote;

        if (thisInstant.isChord()) {
            thisNote = ChordQuality.getRootNoteFromChord(thisInstant.setOfNotes);
        } else {
            thisNote = thisInstant.getNote();
        }

        final Note thatNote;

        if (thatInstant.isChord()) {
            thatNote = ChordQuality.getRootNoteFromChord(thisInstant.setOfNotes);
        } else {
            thatNote = thatInstant.getNote();
        }

        return thisNote.getNoteValue().equals(thatNote.getNoteValue());
    }

    /**
     * Check if all notes are actually valid
     * @return
     */
    public boolean isAllValid() {

        if (setOfNotes == null) {
            return false;
        }

        for (Note note : setOfNotes) {
            if (note == null)
                return false;
        }

        return true;
    }
}
