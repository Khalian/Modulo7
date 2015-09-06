package com.modulo7.musicstatmodels.representation;

import com.modulo7.common.exceptions.Modulo7WrongNoteType;
import com.modulo7.common.utils.Modulo7Globals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
public class Voice {

    // A voice sequence is the sequence of line instance
    // That are being played
    private ArrayList<VoiceInstant> voiceSequence;

    // Member indicating how long the entire voice was played
    private double totalVoiceDuration = (double) Modulo7Globals.UNKNOWN;

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

        String noteString = "";

        for (VoiceInstant instant : voiceSequence) {

            if (!instant.getIsChord()) {
                try {
                    final Note note = instant.getNote();
                    final String noteValue = note.getNoteValue();
                    noteString += noteValue + " ";
                } catch (Modulo7WrongNoteType e) {
                    e.printStackTrace();
                }
            }
        }

        return noteString.trim();
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
     * @return
     */
    public double getTotalVoiceDuration() {
        return totalVoiceDuration;
    }

    /**
     * Gets the number of voice instants in the voice
     * @return
     */
    public int getNumVoiceInstantsofVoice() {
        return voiceSequence.size();
    }
}
