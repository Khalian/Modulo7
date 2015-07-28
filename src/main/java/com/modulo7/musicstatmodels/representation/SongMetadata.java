package com.modulo7.musicstatmodels.representation;

/**
 * Created by asanyal on 7/28/2015.
 *
 * The metadata information associated with a song
 */
public class SongMetadata {

    // Name of the artist who wrote this song
    private String artistName;

    // The tempo associated with this song, also called BPM (beats per minute)
    private int tempo;

    // The timbre associated with the song
    // TODO : Find out a better representation of what timbre means, look at echo nest documentation
    // and other sources
    private double timbre;

    // The key signature associated with this song
    private KeySignature keySignature;

    /**
     * Basic constructor with only artist Name known
     * @param artistName
     */
    public SongMetadata(final String artistName) {
        this.artistName = artistName;
    }

    /**
     * Basic constructor with only artist Name known
     * @param tempo
     */
    public SongMetadata(final int tempo, final double timbre) {
        this.tempo = tempo;
        this.timbre = timbre;
    }
}
