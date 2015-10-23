package com.modulo7.musicstatmodels.representation.monophonic;

import com.modulo7.common.exceptions.Modulo7WrongNoteType;
import com.modulo7.common.utils.Modulo7Globals;
import com.modulo7.musicstatmodels.representation.buildingblocks.ChordQuality;
import com.modulo7.musicstatmodels.representation.buildingblocks.Note;
import com.modulo7.musicstatmodels.statistics.MaxRangeOfSong;
import org.apache.log4j.Logger;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by asanyal on 7/18/2015.
 *
 * A line is modulo7's representation of what is
 * a sequence of line instants
 *
 * A song is comprised of multiple voices. Think of a rhythm
 * guitar being played in the background or a lead guitarist going
 * through a riff. Each of those are a different voice.
 *
 * A song is an interplay of distinct voices. Rules can be specific to a voice
 * or can be at a song level (also called voice interplay rules)
 */
public class Voice implements Serializable {

    // A voice sequence is the sequence of line instance
    // That are being played
    private ArrayList<VoiceInstant> voiceSequence;

    // Metadata specific to a voice independent of metadata with other
    // voices in teh song
    private VoiceTag voiceTag = new VoiceTag();

    // Member indicating how long the entire voice was played
    private double totalVoiceDuration = (double) Modulo7Globals.UNKNOWN;

    // Logger instance for voice
    private static final Logger logger = Logger.getLogger(Voice.class);

    /**
     * Basic constructor for line by accepting a set of line
     * instants
     *
     * @param voiceSequence
     */
    public Voice(final ArrayList<VoiceInstant> voiceSequence) {
        this.voiceSequence = voiceSequence;
        inferTotalLineDuration();
    }

    /**
     * Infers the total line duration
     */
    private void inferTotalLineDuration() {
        totalVoiceDuration = 0.0;

        // Add up the line instant durations one after the other
        for (VoiceInstant instant : voiceSequence) {

            double duration = instant.getDuration();

            if (duration != -1.0)
                totalVoiceDuration += instant.getDuration();
        }
    }

    /**
     * A document representation for a single voice
     * with just the note values as a string
     *
     * This simple measure gives the notes as a set of
     * characters
     *
     * @return
     */
    public String getDocumentRepresentation() {

        StringBuilder noteString = new StringBuilder();

        for (VoiceInstant instant : voiceSequence) {

            if (!instant.isChord()) {
                try {
                    final Note note = instant.getNote();
                    final String noteValue = note.getNoteValue();
                    noteString.append(noteValue);
                    noteString.append(" ");
                } catch (Modulo7WrongNoteType e) {
                    logger.error(e.getMessage());
                }
            } else {
                final Note chordRootNote = ChordQuality.getRootNoteFromChord(instant.getAllNotesofInstant());
                final String chordRootNoteStringRep = chordRootNote.getNoteValue();
                final String chordType = instant.getChordQuality().getStringRepresentation();
                noteString.append(chordRootNoteStringRep);
                noteString.append(chordType);
                noteString.append(" ");
            }
        }

        return noteString.toString().trim();
    }

    /**
     * This form of the constuctor should be used when
     * the line is being constructor via the add VoiceInstant method
     *
     * This is discouraged practice if the entire line is known to the
     * crawler before hand
     */
    public Voice() {
        this.voiceSequence = new ArrayList<>();
    }

    /**
     * Dynamically adds a line instant to a line
     * This method should be used when modolu7 is receiving
     * a line as being composed on the spotp
     *
     * @param instant
     */
    public void addVoiceInstant(final VoiceInstant instant) {
        voiceSequence.add(instant);
        addDurationToTotal(instant);
    }

    /**
     * While incrementally building voices, add the duration as well
     * add the duration only if its known beforehand
     *
     * @param instant
     */
    private void addDurationToTotal(final VoiceInstant instant) {
        double duration = instant.getDuration();

        if (duration != -1.0) {
            totalVoiceDuration += duration;
        }
    }

    /**
     * Basic getter for the voice sequence
     *
     * @return
     */
    public List<VoiceInstant> getVoiceSequence() {
        return voiceSequence;
    }

    /**
     * Gets the total line duration for this song
     * x`@return
     */
    public double getTotalVoiceDuration() {
        return totalVoiceDuration;
    }

    /**
     * Gets the number of voice instants in the voice
     * @return
     */
    public int getNumVoiceInstantsOfVoice() {
        return voiceSequence.size();
    }

    /**
     * Gets the voice instant at a given position in the voice
     * @param pos
     * @return
     */
    public VoiceInstant getVoiceInstantAtPostion(final int pos) {
        return voiceSequence.get(pos);
    }

    /**
     * Gettter for the voice tag object
     * @return
     */
    public VoiceTag getVoiceTag() {
        return voiceTag;
    }

    /**
     * Setter for the voice tag
     * @param voiceTag
     */
    public void setVoiceTag(VoiceTag voiceTag) {
        this.voiceTag = voiceTag;
    }

    /**
     * Alter a voice instance at a given position
     * @param shiftedInstance
     * @param position
     */
    public void reassignVoiceInstance(final VoiceInstant shiftedInstance, final int position) {
        voiceSequence.set(position, shiftedInstance);
    }

    /**
     * Given a constructed voice, estimate its voice class
     * @return
     */
    public VoiceClass estimateVoiceClass() {
        Note[] topAndBottom = MaxRangeOfSong.getTopAndBottomNote(this);

        Note bottomNote = topAndBottom[0];
        Note topNote = topAndBottom[1];

        boolean isSoprano = Note.isHigherPitch(bottomNote, Note.B4) && Note.isLowerPitch(topNote, Note.ASHARP5);

        if (isSoprano) {
            return VoiceClass.SOPRAN0;
        }

        boolean isAlto = Note.isHigherPitch(bottomNote, Note.FSHARP3) && Note.isLowerPitch(topNote, Note.FSHARP5);

        if (isAlto) {
            return VoiceClass.ALTO;
        }

        boolean isTenor = Note.isHigherPitch(bottomNote, Note.B3) && Note.isLowerPitch(topNote, Note.ASHARP4);

        if (isTenor) {
            return VoiceClass.TENOR;
        }

        boolean isBass = Note.isHigherPitch(bottomNote, Note.B2) && Note.isLowerPitch(topNote, Note.F4);

        if (isBass) {
            return VoiceClass.BASS;
        }

        return VoiceClass.GENERIC;
    }
}
