package com.modulo7.musicstatmodels.representation;

/**
 * Created by asanyal on 7/28/2015.
 *
 * The metadata information associated with a song
 *
 * Typically the following pieces of metadata are generally associated with this song:
 *
 * 1. l
 */
public class SongMetadata {

    // Name of the artist who wrote this song
    private String artistName;

    // Title of the track
    private String titleOfTrack;

    // The time signature associated with this song
    private TimeSignature timeSignature;

    // The key signature associated with this song
    private KeySignature keySignature;

    // The timbre associated with the song
    // TODO : Find out a better representation of what timbre means, look at echo nest documentation
    private double timbre;

    // The beats per minute, or tempo associated with this song
    private int tempo;

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
