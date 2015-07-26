package com.modulo7.musicstatmodels.representation;

import com.modulo7.musicstatmodels.representation.Line;

import java.util.Set;

/**
 * Created by asanyal on 7/23/2015.
 *
 * A song is modulo7's representation of a model that describes and entire
 * song in any format of recording : Midi, sheet music, mp3 etc
 *
 * A song is basically an interplay of multiple lines being played together
 * As such it encapsulates a set of modulo7 lines and metadata like artistname,
 */
public class Song {

    // A description of the length of the song in question
    private Set<Line> linesOfSong;

    // Total duration of the song in question
    private double totalDurationOfSong;

    // Name of the artist who wrote this song
    private String artistName;

    // The tempo associated with this song
    private int tempo;

    /**
     * Method to infer the song length as maximum of all the line duration
     * lengths as part of the song
     */
    private void inferSongLength() {
        totalDurationOfSong = -1;

        // From the lines of a song, extract the max duration
        // and call it the duration of the song
        for (Line line : linesOfSong) {
            double lineDuration = line.getTotalLineDuration();

            if (totalDurationOfSong < lineDuration) {
                totalDurationOfSong = lineDuration;
            }
        }
    }

    /**
     * Basic Constructor for a modulo7 song
     *
     * This constructor is for unknown pieces of information
     * regarding the metadata of the song
     *
     * @param linesOfSong
     */
    public Song(final Set<Line> linesOfSong) {
        this.linesOfSong = linesOfSong;
        inferSongLength();
    }

    /**
     * Basic constructor for a modulo7 song with artist name present
     *
     * @param linesOfSong
     * @param artistName
     */
    public Song(final Set<Line> linesOfSong, String artistName) {
        this.linesOfSong = linesOfSong;
        inferSongLength();
        this.artistName = artistName;
    }
}
