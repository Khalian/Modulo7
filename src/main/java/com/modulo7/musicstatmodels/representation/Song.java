package com.modulo7.musicstatmodels.representation;

import java.util.HashSet;
import java.util.List;
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
    private Set<Voice> voicesOfSong;

    // Total duration of the song in question
    private double totalDurationOfSong;

    // The metadata associated with the song
    private SongMetadata metadata;

    /**
     * Method to infer the song length as maximum of all the line duration
     * lengths as part of the song
     */
    private void inferSongLength() {
        totalDurationOfSong = -1;

        // From the lines of a song, extract the max duration
        // and call it the duration of the song
        for (Voice line : voicesOfSong) {
            double lineDuration = line.getTotalVoiceDuration();

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
     * @param voicesOfSong
     */
    public Song(final Set<Voice> voicesOfSong) {
        this.voicesOfSong = voicesOfSong;
        inferSongLength();

        // TODO : Whether to put a default value to metadata or declare
        // Unknowns
    }

    /**
     * Basic constructor for a modulo7 song with Song Metadata present
     *
     * @param voicesOfSong
     * @param songMetadata
     */
    public Song(final Set<Voice> voicesOfSong, final SongMetadata songMetadata) {

        this.voicesOfSong = voicesOfSong;
        this.metadata = songMetadata;
    }

    /**
     * Constructor with a single voice and metadata present
     *
     * @param voiceOfSong
     * @param songMetadata
     */
    public Song(final Voice voiceOfSong, final SongMetadata songMetadata) {
        this.voicesOfSong = new HashSet<>();
        this.voicesOfSong.add(voiceOfSong);

        this.metadata = songMetadata;
    }

    /**
     * Basic getter for getting voices associated with this song
     * @return
     */
    public Set<Voice> getVoices() {
        return voicesOfSong;
    }

    /**
     * Returns the total song duration
     * @return
     */
    public double getTotalSongDuration() {
        return totalDurationOfSong;
    }
}
