package com.modulo7.engine;

import com.echonest.api.v4.EchoNestException;
import com.modulo7.common.exceptions.*;
import com.modulo7.common.interfaces.AbstractCriteria;
import com.modulo7.common.utils.Modulo7Utils;
import com.modulo7.musicstatmodels.criteria.PolyphonyCriteria;
import com.modulo7.musicstatmodels.representation.metadata.KeySignature;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;
import com.modulo7.musicstatmodels.representation.metadata.TimeSignature;
import com.modulo7.nlp.Lyrics;
import com.modulo7.nlp.LyricsIndexer;

import javax.sound.midi.InvalidMidiDataException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by asanyal on 9/10/15.
 *
 * A modulo7 indexer indexes songs based on various criteria, these are pointers to objects
 * in memory and acts a a quick access point giving indexed lists
 */
public class Modulo7Indexer {

    // Database engine
    protected DatabaseEngine engine;

    // Songs indexed on key signature
    private Map<KeySignature, Set<Song>> keySignatureIndex = new HashMap<>();

    // Songs indexed on time signature
    private Map<TimeSignature, Set<Song>> timeSignatureIndex = new HashMap<>();

    // Songs indexed on artists playing
    private Map<String, Set<Song>> artistIndex = new HashMap<>();

    // Songs indexed on the fact that they are homophonic
    private Map<String, Song> mophonicIndex = new HashMap<>();

    // Songs indexed on the fact that they are polyphonic
    private Map<String, Song> polyphonicIndex = new HashMap<>();

    // Lyrics indexer for all the sub components
    private LyricsIndexer lyricsIndexer;

    // Is there verbose output while indexing
    private boolean verboseIndexing = false;

    /**
     * Default constructor for modulo7 indexer
     *
     * This constructor creates an in memory representation and indexes on various fields
     *
     * @param srcDir
     * @param dstDir
     * @throws InvalidMidiDataException
     * @throws Modulo7InvalidMusicXMLFile
     * @throws EchoNestException
     * @throws Modulo7NoSuchFileException
     * @throws Modulo7IndexingDirError
     * @throws Modulo7ParseException
     */
    public Modulo7Indexer(final String srcDir, final String dstDir) throws InvalidMidiDataException, Modulo7InvalidMusicXMLFile,
            EchoNestException, Modulo7NoSuchFileException, Modulo7IndexingDirError, Modulo7InvalidFileOperationExeption,
            Modulo7ParseException, Modulo7InvalidArgsException {
        engine = new DatabaseEngine(srcDir, dstDir);
        engine.buildInMemoryDataBaseFromScratch();
        lyricsIndexer = new LyricsIndexer();
    }

    /**
     * Constructor which takes argument whether to persist models on to disk and whetheer
     * verbose output is needed when indexing
     *
     * @param srcDir
     * @param dstDir
     * @param persistOnDisk
     * @param verboseIndexing
     *
     * @throws InvalidMidiDataException
     * @throws Modulo7InvalidMusicXMLFile
     * @throws EchoNestException
     * @throws Modulo7NoSuchFileException
     * @throws Modulo7ParseException
     */
    public Modulo7Indexer(final String srcDir, final String dstDir, final boolean persistOnDisk, final boolean verboseIndexing)
            throws InvalidMidiDataException, Modulo7InvalidMusicXMLFile, EchoNestException, Modulo7NoSuchFileException,
            Modulo7InvalidFileOperationExeption, Modulo7ParseException, Modulo7InvalidArgsException {
        engine = new DatabaseEngine(srcDir, dstDir, verboseIndexing);
        engine.buildInMemoryDataBaseFromScratch();
        lyricsIndexer = new LyricsIndexer();

        if (persistOnDisk) {
            engine.serializeDataSetAndMoveToDisk();
        }

        this.verboseIndexing = verboseIndexing;
    }

    /**
     * Method to initiate indexing of data and help build the indexed data structures
     * These indexes can later be used to query
     *
     * @throws Modulo7IndexingDirError
     */
    public void indexData() throws Modulo7IndexingDirError {
        indexKeySignatures();
        indexTimeSignatures();
        indexLyrics();
        indexArtists();
        indexPolyphony();
    }

    /**
     * Method to add additional songs to a given index
     * @param newDir
     */
    public void addAdditionalSongsToIndex(final String newDir) {
        final Set<String> newFilesToIndex = Modulo7Utils.listAllFiles(newDir);

        for (final String newFile : newFilesToIndex) {
            incrementalIndexArtists(newFile);
        }
    }

    /**
     * Method to index songs as monophonic and polyphonic
     */
    private synchronized void indexPolyphony() {

        final AbstractCriteria polyphonyCriteria = new PolyphonyCriteria();

        for (final String songLocation : engine.getSongLocationSet()) {
            final Song song = engine.getSongGivenLocationInMemoryVersion(songLocation);

            // If the song is polyphonic
            if (polyphonyCriteria.getCriteriaEvaluation(song)) {
                polyphonicIndex.put(songLocation, song);
            } else {
                mophonicIndex.put(songLocation, song);
            }
        }
    }

    /**
     * Helper method to index lyrics on apache lucene
     * @throws Modulo7IndexingDirError
     */
    private void indexLyrics() throws Modulo7IndexingDirError {

        final Set<String> songLocations = engine.getSongLocationSet();
        final Set<Lyrics> newLyricsSet = new HashSet<>();

        for (final String songLocation : songLocations) {
            final Song song = engine.getSongGivenLocationInMemoryVersion(songLocation);
            newLyricsSet.add(song.getLyrics());
        }

        lyricsIndexer.bulkIndexLyrics(newLyricsSet);
    }

    /**
     * Helper method that indexes all the songs based on their key signature
     */
    private synchronized void indexKeySignatures() {
        final Set<String> songLocations = engine.getSongLocationSet();

        for (final String songLocation : songLocations) {
            final Song song = engine.getSongGivenLocationInMemoryVersion(songLocation);
            final KeySignature signature = song.getMetadata().getKeySignature();
            addSongToKeySignatureIndex(signature, song);
        }
    }

    /**
     * Helper method that indexes based on artist
     */
    private synchronized void indexArtists() {
        final Set<String> songLocations = engine.getSongLocationSet();

        for (final String songLocation : songLocations) {
            final Song song = engine.getSongGivenLocationInMemoryVersion(songLocation);
            final String artist = song.getMetadata().getArtistName();
            addSongToArtistIndex(artist, song);
        }
    }

    /**
     * Helper method to index all the time signatures
     */
    private synchronized void indexTimeSignatures() {
        final Set<String> songLocations = engine.getSongLocationSet();

        for (final String songLocation : songLocations) {
            final Song song = engine.getSongGivenLocationInMemoryVersion(songLocation);
            final TimeSignature signature = song.getMetadata().getTimeSignature();
            addSongToTimeSignatureIndex(signature, song);
        }
    }

    /**
     * Helper method that adds song to key signature
     * @param keySignature
     * @param song
     */
    private synchronized void addSongToKeySignatureIndex(final KeySignature keySignature, final Song song) {
        Set<Song> songSet = keySignatureIndex.get(keySignature);

        if (songSet == null)
            songSet = new HashSet<>();

        songSet.add(song);
        keySignatureIndex.put(keySignature, songSet);
    }

    /**
     * Helper method that adds song to key signature
     * @param timeSignature
     * @param song
     */
    private synchronized void addSongToTimeSignatureIndex(final TimeSignature timeSignature, final Song song) {
        Set<Song> songSet = timeSignatureIndex.get(timeSignature);

        if (songSet == null)
            songSet = new HashSet<>();

        songSet.add(song);
        timeSignatureIndex.put(timeSignature, songSet);
    }

    private synchronized void addSongToArtistIndex(final String artist, final Song song) {
        Set<Song> songSet = artistIndex.get(artist);

        if (songSet == null)
            songSet = new HashSet<>();

        songSet.add(song);
        artistIndex.put(artist, songSet);
    }

    /**
     * Gets the time signature indexed set of songs given a time signature element
     * @param signature
     * @return
     */
    public Set<Song> getTimeSignatureIndexedSet(final TimeSignature signature) {
        return timeSignatureIndex.get(signature);
    }

    /**
     * Gets the set of songs given a key signature element
     * @param signature
     * @return
     */
    public Set<Song> getKeySignatureIndexedSet(final KeySignature signature) {
        return keySignatureIndex.get(signature);
    }

    /**
     * Gets the set of songs given an artist
     * @param artist
     * @return
     */
    public Set<Song> getArtistIndexedSet(final String artist) {
        return artistIndex.get(artist);
    }

    /**
     * A simple getter for the number of songs parsed
     * @return
     */
    public int getNumSongsIndexed() {
        return engine.getNumSongsParsed();
    }

    /**
     * Method to incrementally add songs to an index
     *
     * @param location
     * @throws InvalidMidiDataException
     * @throws Modulo7InvalidMusicXMLFile
     * @throws EchoNestException
     * @throws com.modulo7.common.exceptions.Modulo7InvalidFileOperationExeption
     * @throws Modulo7NoSuchFileException
     * @throws Modulo7IndexingDirError
     * @throws Modulo7ParseException
     */
    public void incrementalIndexASong(final String location) throws InvalidMidiDataException, Modulo7InvalidMusicXMLFile,
            EchoNestException, Modulo7InvalidFileOperationExeption, Modulo7NoSuchFileException, Modulo7IndexingDirError, Modulo7ParseException {
        boolean toIndex = engine.incrementalAddToDatabase(location);

        if (toIndex) {
            incrementalIndexKeySignatures(location);
            incrementalIndexTimeSignatures(location);
            incrementalIndexLyrics(location);
            incrementalIndexArtists(location);
            incrementatalIndexPolyphony(location);
        }
    }

    /**
     * Incremental version of the polyphony index
     * @param location
     */
    private synchronized void incrementatalIndexPolyphony(final String location) {

        final AbstractCriteria polyphonyCriteria = new PolyphonyCriteria();
        final Song song = engine.getSongGivenLocationInMemoryVersion(location);

        // If the song is polyphonic
        if (polyphonyCriteria.getCriteriaEvaluation(song)) {
            polyphonicIndex.put(location, song);
        } else {
            mophonicIndex.put(location, song);
        }
    }

    /**
     * Incremental version of the artist indexer
     * @param location
     */
    private synchronized void incrementalIndexArtists(final String location) {
        final Song song = engine.getSongGivenLocationInMemoryVersion(location);
        final TimeSignature signature = song.getMetadata().getTimeSignature();
        addSongToTimeSignatureIndex(signature, song);
    }

    /**
     * Incremental version of the lyrics indexer
     * @param location
     * @throws Modulo7IndexingDirError
     */
    private synchronized void incrementalIndexLyrics(final String location) throws Modulo7IndexingDirError {
        final Song song = engine.getSongGivenLocationInMemoryVersion(location);
        lyricsIndexer.indexLyrics(song.getLyrics());
    }

    /**
     * Incremental version of time signature indexing
     * @param location
     */
    private synchronized void incrementalIndexTimeSignatures(final String location) {
        final Song song = engine.getSongGivenLocationInMemoryVersion(location);
        final TimeSignature signature = song.getMetadata().getTimeSignature();
        addSongToTimeSignatureIndex(signature, song);
    }

    /**
     * Incremental version of the key signature indexing
     * @param location
     */
    private synchronized void incrementalIndexKeySignatures(final String location) {
        final Song song = engine.getSongGivenLocationInMemoryVersion(location);
        final KeySignature signature = song.getMetadata().getKeySignature();
        addSongToKeySignatureIndex(signature, song);
    }

    /**
     * Gets the database name of the internal database
     * @return
     */
    protected String getInternalDBName() {
        return engine.getDatabaseName();
    }

    /**
     * Gets handles all the songs from the internal database
     * @return
     */
    protected Set<Song> getAllSongs() {
        return engine.getAllSongs();
    }

    /**
     * Given the song name, returns the song object
     * @param songName
     * @return
     */
    protected Song getSongObjectGivenSongName(final String songName) {
        final Set<Song> allSongs = getAllSongs();

        for (Song song : allSongs) {
            if (songName.equals(song.getMetadata().getTitleOfTrack())) {
                return song;
            }
        }

        // If there are no songs whatsover with the given song name return null
        return null;
    }

    /**
     * Once a query obtains a set of relevant song objects, the next order
     * of business would be get the set of
     *
     * @param relevantSongs
     * @throws Modulo7DataBaseNotSerializedException
     *
     * @return
     */
    public Set<String> getLocationsGivenRelevantSongs(final Set<Song> relevantSongs) throws Modulo7DataBaseNotSerializedException {

        Set<String> allRelevantLocations = new HashSet<>();

        // Relevant songs is null when you dont have any elements returned as relevant
        if (relevantSongs != null) {
            for (final Song song : relevantSongs) {
                allRelevantLocations.add(engine.getLocationGivenSong(song));
            }
        }

        return allRelevantLocations;
    }

    /**
     * Gets a song given location
     *
     * @param candidateSongLocation
     * @return
     * @throws Modulo7DataBaseNotSerializedException
     */
    public Song getSongObjectGivenLocation(final String candidateSongLocation)
            throws Modulo7DataBaseNotSerializedException {
        return engine.getSongGivenLocation(candidateSongLocation);
    }
}