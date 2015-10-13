package com.modulo7.musicstatmodels.representation.metadata;

import com.modulo7.common.exceptions.Modulo7BadKeyException;
import com.modulo7.common.utils.Modulo7Globals;
import com.modulo7.musicstatmodels.musictheorymodels.KKTonalityProfiles;
import com.modulo7.musicstatmodels.vectorspacemodels.vectorspacerepresentations.songvectors.TonalDurationHistogram;

import java.io.Serializable;

/**
 * Created by asanyal on 7/28/2015.
 *
 * The metadata information associated with a song
 *
 * Typically the following pieces of metadata are generally associated with this song:
 *
 * Artist name
 * Title of track
 * Time Signature
 * Key Signature
 * Tempo of a song (or Beats per minute on the song)
 */
public class SongMetadata implements Serializable {

    // Name of the artist who wrote this song
    private String artistName = Modulo7Globals.UNKNOWNSTRING;

    // Title of the track
    private String titleOfTrack = Modulo7Globals.UNKNOWNSTRING;

    // The time signature associated with this song
    private TimeSignature timeSignature = new TimeSignature();

    // The key signature associated with this song
    private KeySignature keySignature = new KeySignature();

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
    public SongMetadata(final String artistName, final String titleOfTrack) {
        this.artistName = artistName;
        this.titleOfTrack = titleOfTrack;
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
     * @param titleOfTrack
     */
    public SongMetadata(final KeySignature keySignature, final TimeSignature timeSignature,
                        final String artistName, final String titleOfTrack) {
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
     * Basic constructor with time signature unknown but key signature, artist, title of track and tempo are know params
     * @param keySignature
     * @param artistName
     * @param title
     * @param tempo
     */
    public SongMetadata(final KeySignature keySignature, final String artistName, final String title, final int tempo) {
        this.keySignature = keySignature;
        this.artistName = artistName;
        this.titleOfTrack = title;
        this.tempo = tempo;
    }

    /**
     * Basic constructor with artist name, title of track and tempo of track known
     * @param artistName
     * @param title
     * @param tempo
     */
    public SongMetadata(final String artistName, final String title, final int tempo) {
        this.artistName = artistName;
        this.titleOfTrack = title;
        this.tempo = tempo;
    }

    /**
     * Basic constructor with only the song key signature known
     * @param keySignature
     */
    public SongMetadata(final KeySignature keySignature) {
        this.keySignature = keySignature;
    }

    /**
     * Constructor containing every element for song metadata
     * @param keySignature
     * @param timeSignature
     * @param artistName
     * @param title
     * @param tempo
     */
    public SongMetadata(final KeySignature keySignature, final TimeSignature timeSignature,
                        final String artistName, final String title, final int tempo) {
        this.keySignature = keySignature;
        this.timeSignature = timeSignature;
        this.artistName = artistName;
        this.titleOfTrack = title;
        this.tempo = tempo;
    }

    /**
     * Setter for key signature
     * @param keySignature
     */
    public void setKeySignature(final KeySignature keySignature) {
        this.keySignature = keySignature;
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
