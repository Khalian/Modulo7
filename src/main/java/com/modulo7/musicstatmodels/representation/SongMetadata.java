package com.modulo7.musicstatmodels.representation;

import com.modulo7.common.utils.Modulo7Globals;

/**
 * Created by asanyal on 7/28/2015.
 *
 * The metadata information associated with a song
 *
 * Typically the following pieces of metadata are generally associated with this song:
 *
 */
public class SongMetadata {

    // Name of the artist who wrote this song
    private String artistName = Modulo7Globals.UNKNOWNSTRING;

    // Title of the track
    private String titleOfTrack = Modulo7Globals.UNKNOWNSTRING;

    // The time signature associated with this song
    private TimeSignature timeSignature = new TimeSignature();

    // The key signature associated with this song
    private KeySignature keySignature = new KeySignature();

    // The timbre associated with the song
    // TODO : Find out a better representation of what timbre means, look at echo nest documentation
    private double timbre = Modulo7Globals.UNKNOWN;

    // The beats per minute, or tempo associated with this song
    private int tempo = Modulo7Globals.UNKNOWN;

    public SongMetadata() {

    }

    /**
     * Basic constructor with only artist Name known
     * @param artistName
     */
    public SongMetadata(final String artistName) {
        this.artistName = artistName;
    }

    /**
     * Basic constructor with only artist Name and title of track known
     * @param artistName
     * @param titleOfTrack
     */
    public SongMetadata(final String artistName, final String titleOfTrack)     {
        this.artistName = artistName;
        this.titleOfTrack = titleOfTrack;
    }

    /**
     * Basic constructor with only artist Name known
     * @param tempo
     */
    public SongMetadata(final int tempo, final double timbre) {
        this.tempo = tempo;
        this.timbre = timbre;
    }

    /**
     * Basic constructor with only timeSignature and key Signature known
     * @param keySignature
     * @param timeSignature
     */
    public SongMetadata(final KeySignature keySignature, final TimeSignature timeSignature) {
        this.keySignature = keySignature;
        this.timeSignature = timeSignature;
    }

    /**
     * Basic constructor with only timeSignature and key Signature known
     * @param keySignature
     * @param timeSignature
     */
    public SongMetadata(final KeySignature keySignature, final TimeSignature timeSignature,
                        final String artistName, final  String titleOfTrack) {
        this.keySignature = keySignature;
        this.timeSignature = timeSignature;

        this.artistName = artistName;
        this.titleOfTrack = titleOfTrack;
    }

    /**
     * Basic constructor with time signature unknown but key signature, artist and title of track are know params
     * @param keySignature
     * @param artistName
     * @param title
     */
    public SongMetadata(final KeySignature keySignature, final String artistName, final String title) {
        this.keySignature = keySignature;
        this.artistName = artistName;
        this.titleOfTrack = title;
    }

    /**
     * Getter for artist Name
     * @return
     */
    public String getArtistName() {
        return artistName;
    }

    /**
     * Getter for title of track
     * @return
     */
    public String getTitleOfTrack() {
        return titleOfTrack;
    }

    /**
     * Getter for time signature
     * @return
     */
    public TimeSignature getTimeSignature() {
        return timeSignature;
    }

    /**
     * Getter for timbre
     * @return
     */
    public double getTimbre() {
        return timbre;
    }

    /**
     * Getter for tempo
     * @return
     */
    public int getTempo() {
        return tempo;
    }

    /**
     * Getter for keysignature
     * @return
     */
    public KeySignature getKeySignature() {
        return keySignature;
    }
}
