package com.modulo7.engine;

import com.echonest.api.v4.EchoNestException;
import com.modulo7.common.exceptions.Modulo7DataBaseNotSerializedException;
import com.modulo7.common.exceptions.Modulo7InvalidMusicXMLFile;
import com.modulo7.common.exceptions.Modulo7NoSuchFileException;
import com.modulo7.musicstatmodels.representation.KeySignature;
import com.modulo7.musicstatmodels.representation.Song;

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
    private DatabaseEngine engine;

    // Songs indexed on key signature
    private Map<KeySignature, Set<Song>> keySignatureIndex = new HashMap<>();

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
     */
    public Modulo7Indexer(final String srcDir, final String dstDir) throws InvalidMidiDataException, Modulo7InvalidMusicXMLFile,
            EchoNestException, Modulo7NoSuchFileException {
        engine = new DatabaseEngine(srcDir, dstDir);
        engine.buildInMemoryDataBaseFromScratch();

        indexKeySignatures();
    }

    /**
     * Helper method that indexes all the songs based on their key signature
     */
    private void indexKeySignatures() {
        final Set<String> songLocations = engine.getSongLocationSet();

        for (final String songLocation : songLocations) {
            final Song song = engine.getSongGivenLocationInMemoryVersion(songLocation);
            final KeySignature signature = song.getMetadata().getKeySignature();
            addSongToKeySignatureToIndex(signature, song);  
        }
    }

    /**
     * Helper method that adds song to key signature
     * @param keySignature
     * @param song
     */
    private void addSongToKeySignatureToIndex(final KeySignature keySignature, final Song song) {
        Set<Song> songSet = keySignatureIndex.get(keySignature);

        if (songSet == null)
            songSet = new HashSet<>();

        songSet.add(song);
        keySignatureIndex.put(keySignature, songSet);
    }
}