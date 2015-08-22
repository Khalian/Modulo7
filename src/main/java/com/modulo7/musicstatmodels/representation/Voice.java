package com.modulo7.musicstatmodels.representation;

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
public class Voice {

    // A voice sequence is the sequence of line instances
    // That are being played
    private List<VoiceInstant> voiceSequence;

    // Member indicating how long the entire voice was played
    private double totalVoiceDuration;

    // The voice's scale, major, minor, blues etc
    private ScaleType scaleOfVoice;

    /**
     * Basic constructor for line by accepting a set of line
     * instants
     *
     * @param voiceSequence
     */
    public Voice(final List<VoiceInstant> voiceSequence) {
        this.voiceSequence = voiceSequence;
        inferTotalLineDuration();
    }

    /**
     * Basic Constructor which takes into account the scale of a given voice
     * as well as the line sequence itself
     *
     * @param voiceSequence
     * @param scaleType
     */
    public Voice(final List<VoiceInstant> voiceSequence, final ScaleType scaleType) {
        this.voiceSequence = voiceSequence;
        this.scaleOfVoice = scaleType;
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
     * Basic getter for acquiring the scale of the song
     * @return
     */
    public ScaleType getScaleOfVoice() {
        return scaleOfVoice;
    }
}
