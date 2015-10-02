package com.modulo7.musicstatmodels.representation.polyphonic;

import com.modulo7.common.utils.Modulo7Globals;
import com.modulo7.crawler.utils.MusicSources;
import com.modulo7.musicstatmodels.representation.metadata.KeySignature;
import com.modulo7.musicstatmodels.representation.metadata.SongMetadata;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;
import com.modulo7.nlp.Lyrics;

import java.io.Serializable;
import java.util.HashSet;
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
public class Song implements Serializable {

    // A description of the length of the song in question
    private HashSet<Voice> voicesOfSong = new HashSet<>();

    // Total duration of the song in question
    private double totalDurationOfSong = Modulo7Globals.UNKNOWN;

    // The metadata associated with the song
    private SongMetadata metadata = new SongMetadata();

    // Song source, depending on what medium the song has arisen from, modulo7 can expect certain ideas to work and certain
    private MusicSources source = MusicSources.UNKNOWN;

    // A basic lyrics object added to the song model    
    private Lyrics lyrics = new Lyrics();

    /**
     * Method to infer the song length as maximum of all the line duration
     * lengths as part of the song
     *
     * Since voices are interplayed with each other, the song's length
     * is maximum of all the voices
     */
    private void inferSongLength() {

        // From the voices of a song, extract the max duration
        // and call it the duration of the song
        for (final Voice voice : voicesOfSong) {
            double lineDuration = voice.getTotalVoiceDuration();

            if (totalDurationOfSong < lineDuration) {
                totalDurationOfSong = lineDuration;
            }
        }
    }

    /**
     * Basic constructor for deserialization
     */
    public Song() {

    }

    /**
     * Basic Constructor for a modulo7 song
     *
     * This constructor is for unknown pieces of information
     * regarding the metadata of the song
     *
     * @param voicesOfSong
     * @param source
     */
    public Song(final HashSet<Voice> voicesOfSong, final MusicSources source) {
        this.voicesOfSong = voicesOfSong;
        inferSongLength();

        this.source = source;
    }

    /**
     * Basic constructor for a modulo7 song with Song Metadata present
     *
     * @param voicesOfSong
     * @param songMetadata
     * @param source
     */
    public Song(final HashSet<Voice> voicesOfSong, final SongMetadata songMetadata, final MusicSources source) {

        this.voicesOfSong = voicesOfSong;
        inferSongLength();
        this.metadata = songMetadata;

        this.source = source;
    }

    /**
     * Basic constructor for a modulo7 song with the song metadata present as well as the total duration is precomputed
     * @param voicesOfSong
     * @param songMetadata
     * @param source
     * @param totalDurationOfSong
     */
    public Song (final HashSet<Voice> voicesOfSong, final SongMetadata songMetadata,
                 final MusicSources source, final double totalDurationOfSong) {
        this.voicesOfSong = voicesOfSong;
        this.totalDurationOfSong = totalDurationOfSong;
        this.metadata = songMetadata;

        this.source = source;
    }

    /**
     * Constructor with a single voice and metadata present
     *
     * @param voiceOfSong
     * @param songMetadata
     * @param source
     */
    public Song(final Voice voiceOfSong, final SongMetadata songMetadata, final MusicSources source) {
        this.voicesOfSong.add(voiceOfSong);
        inferSongLength();

        this.metadata = songMetadata;
        this.source = source;
    }

    /**
     * Basic constructor for a modulo7 song with the song metadata present as well as the total duration is precomputed
     * This version has only a single voice in its constructor
     *
     * @param voice
     * @param songMetadata
     * @param source
     * @param totalDurationOfSong
     */
    public Song (final Voice voice, final SongMetadata songMetadata,
                 final MusicSources source, final double totalDurationOfSong) {
        this.voicesOfSong.add(voice);
        this.totalDurationOfSong = totalDurationOfSong;
        this.metadata = songMetadata;

        this.source = source;
    }

    /**
     * Constructor which takes a single voice and its source as arugments
     *
     * @param voice
     * @param source
     */
    public Song(final Voice voice, final MusicSources source) {
        this.voicesOfSong.add(voice);
        inferSongLength();
        this.source = source;
    }

    /**
     * Constructor with the voice set, song metadata source of music and lyrics objects are known
     *
     * @param voiceSet
     * @param metadata
     * @param actualSource
     * @param lyrics
     */
    public Song(final HashSet<Voice> voiceSet, final SongMetadata metadata, final MusicSources actualSource, final Lyrics lyrics) {
        this.voicesOfSong = voiceSet;
        inferSongLength();
        this.metadata = metadata;
        this.source = actualSource;
        this.lyrics = lyrics;
    }

    /**
     * Gets the document representation of the song
     * @return
     */
    public Set<String> getDocumentRepresentation() {
        Set<String> doc = new HashSet<>();

        for (Voice voice : voicesOfSong) {
            doc.add(voice.getDocumentRepresentation());
        }

        return doc;
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

    /**
     * Basic getter for metadata
     * @return
     */
    public SongMetadata getMetadata() {
        return metadata;
    }

    /**
     * Basic getter for source of song
     * @return
     */
    public MusicSources getSource() {
        return source;
    }

    /**
     * Simple getter for number of voices in the song
     * @return
     */
    public int getNumVoices() {
        return voicesOfSong.size();
    }

    /**
     * Simple getter for the lyrics object
     *
     * @return
     */
    public Lyrics getLyrics() {
        return lyrics;
    }

    /**
     * Once the key signature is ascertained, you can add it to the song
     * @param keySignature
     */
    public void addSongMetadata(final KeySignature keySignature) {
        metadata = new SongMetadata(keySignature);
    }
}
