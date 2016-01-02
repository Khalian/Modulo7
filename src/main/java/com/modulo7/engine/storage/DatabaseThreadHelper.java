package com.modulo7.engine.storage;

import com.echonest.api.v4.EchoNestException;
import com.modulo7.acoustics.EchoNestBasicMP3Analyzer;
import com.modulo7.acoustics.MidiToSongConverter;
import com.modulo7.common.exceptions.Modulo7InvalidFileOperationException;
import com.modulo7.common.exceptions.Modulo7InvalidMusicXMLFile;
import com.modulo7.common.exceptions.Modulo7NoSuchFileOrDirectoryException;
import com.modulo7.common.exceptions.Modulo7ParseException;
import com.modulo7.common.interfaces.AbstractAnalyzer;
import com.modulo7.common.utils.AvroUtils;
import com.modulo7.image.AudiverisSheetAnalyzer;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;
import com.modulo7.othersources.BasicMusicXMLParser;
import com.modulo7.pureresearch.MSDSongParser;
import org.apache.log4j.Logger;

import javax.sound.midi.InvalidMidiDataException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by asanyal on 10/27/15.
 *
 * A supporting thread class
 */
public class DatabaseThreadHelper implements Runnable {

    // A hash map between location and songs in Modulo7 format and
    private Map<String, Song> songLocationMap = new HashMap<>();

    // The inverse of the song and locations
    private Map<Song, String> inverseSongLocationMap = new HashMap<>();

    private Set<String> inputLocations = new HashSet<>();

    // Whether there is verbose output in the thread helper
    private boolean verboseOutput = false;

    // Logger for Database thread helper
    private static final Logger logger = Logger.getLogger(DatabaseThreadHelper.class);

    /**
     * The constructor of database thread helper
     *
     * @param verboseOutput
     */
    public DatabaseThreadHelper(final boolean verboseOutput) {
        this.verboseOutput = verboseOutput;
    }

    @Override
    public void run() {
        for (final String location : inputLocations) {
            try {
                parseSource(location);
            } catch (InvalidMidiDataException | Modulo7NoSuchFileOrDirectoryException | EchoNestException | Modulo7InvalidMusicXMLFile
                    | Modulo7ParseException | Modulo7InvalidFileOperationException e) {
                logger.error(e.getMessage());
            }
        }
    }

    /**
     * Parse a given source for a song location
     * @param songLocation
     * @throws javax.sound.midi.InvalidMidiDataException
     * @throws com.modulo7.common.exceptions.Modulo7NoSuchFileOrDirectoryException
     * @throws com.echonest.api.v4.EchoNestException
     * @throws com.modulo7.common.exceptions.Modulo7InvalidMusicXMLFile
     * @throws com.modulo7.common.exceptions.Modulo7ParseException
     * @throws com.modulo7.common.exceptions.Modulo7InvalidFileOperationException
     */
    private Song parseSource(final String songLocation) throws InvalidMidiDataException, Modulo7NoSuchFileOrDirectoryException,
            EchoNestException, Modulo7InvalidMusicXMLFile, Modulo7ParseException, Modulo7InvalidFileOperationException {

        Song song = null;

        if (songLocation.endsWith("midi") || songLocation.endsWith("mid")) {
            AbstractAnalyzer analyzer = new MidiToSongConverter(songLocation);
            song = analyzer.getSongRepresentation();
            addToSongLocationMap(songLocation, song);
        } else if (songLocation.endsWith("mp3")) {
            AbstractAnalyzer analyzer = new EchoNestBasicMP3Analyzer(songLocation);
            song = analyzer.getSongRepresentation();
            addToSongLocationMap(songLocation, song);
        } else if (songLocation.endsWith("xml")) {
            AbstractAnalyzer analyzer = new BasicMusicXMLParser(songLocation);
            song = analyzer.getSongRepresentation();
            addToSongLocationMap(songLocation, song);
        } else if (songLocation.endsWith("png") || songLocation.endsWith("jpg")) {
            AbstractAnalyzer analyzer = new AudiverisSheetAnalyzer(songLocation);
            song = analyzer.getSongRepresentation();
            addToSongLocationMap(songLocation, song);
        } else if (songLocation.endsWith("m7")) {
            // Build an in memory database from an already serialized one, fastest way to deal with pre constructed database
            song = AvroUtils.deserialize(songLocation);
            addToSongLocationMap(songLocation, song);
        } else if (songLocation.endsWith("h5")) {
            AbstractAnalyzer analyzer = new MSDSongParser(songLocation);
            song = analyzer.getSongRepresentation();
            addToSongLocationMap(songLocation, song);
        }

        return song;
    }

    /**
     * Method to add song object to location map and inverse location map
     * @param actualLocationOnDisk
     * @param songObject
     */
    private void addToSongLocationMap(final String actualLocationOnDisk, final Song songObject) {

        if (verboseOutput) {
            System.out.println("Indexed file " + actualLocationOnDisk);
        }

        songLocationMap.put(actualLocationOnDisk, songObject);
        inverseSongLocationMap.put(songObject, actualLocationOnDisk);
    }

    /**
     * Getter for song location map
     * @return
     */
    public Map<String, Song> getSongLocationMap() {
        return songLocationMap;
    }

    /**
     * Getter for inverse song location map
     * @return
     */
    public Map<Song, String> getInverseSongLocationMap() {
        return inverseSongLocationMap;
    }

    /**
     * Adding song source location
     * @param location
     */
    public void addSongSourceLocation(final String location) {
        inputLocations.add(location);
    }
}
