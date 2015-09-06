package com.modulo7.engine;

import com.echonest.api.v4.EchoNestException;
import com.modulo7.common.interfaces.AbstractAnalyzer;
import com.modulo7.acoustics.EchoNestBasicMP3Analyzer;
import com.modulo7.acoustics.MidiToSongConverter;
import com.modulo7.common.exceptions.Modulo7InvalidMusicXMLFile;
import com.modulo7.common.exceptions.Modulo7NoSuchFileException;
import com.modulo7.common.utils.Modulo7Utils;
import com.modulo7.image.AudiverisSheetAnalyzer;
import com.modulo7.musicstatmodels.representation.Song;
import com.modulo7.othersources.BasicMusicXMLParser;

import javax.sound.midi.InvalidMidiDataException;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by asanyal on 8/31/15.
 *
 * Builds a complete Modulo7 Serialized database
 *
 */
public class DatabaseEngine {

    // Source Directory or base location from all types of files are loaded by the parsers
    private String sourceDirectory;

    // Destination Directory
    private String destinationDirectory;

    // The song set along with a hashmap between location and songs and
    private Map<String, Song> songLocationMap = new HashMap<>();

    // All song locations
    private Set<String> allSongLocations = new HashSet<>();

    /**
     * Basic directory
     * @param sourceDirectory
     * @param destinationDirectory
     */
    public DatabaseEngine(final String sourceDirectory, final String destinationDirectory) {
        this.destinationDirectory = destinationDirectory;
        this.sourceDirectory = sourceDirectory;

        Modulo7Utils.removeDuplicateFilesFromDirectory(sourceDirectory);

        allSongLocations = Modulo7Utils.listAllFiles(sourceDirectory);
    }

    /**
     * Method which builds in memory database from scratch and populates
     *
     * The map for songs, in can later be used to serialize if required
     */
    public void buildInMemoryDataBaseFromScratch() throws InvalidMidiDataException, IOException,
            EchoNestException, Modulo7NoSuchFileException, Modulo7InvalidMusicXMLFile {
        for (final String songLocation : allSongLocations) {
            if (songLocation.endsWith("midi") || songLocation.endsWith("mid")) {
                AbstractAnalyzer analyzer = new MidiToSongConverter(songLocation);
                final Song song = analyzer.getSongRepresentation();
                songLocationMap.put(songLocation, song);
            } else if (songLocation.endsWith("mp3")) {
                AbstractAnalyzer analyzer = new EchoNestBasicMP3Analyzer(songLocation);
                final Song song = analyzer.getSongRepresentation();
                songLocationMap.put(songLocation, song);
            } else if (songLocation.endsWith("xml")) {
                AbstractAnalyzer analyzer = new BasicMusicXMLParser(songLocation);
                final Song song = analyzer.getSongRepresentation();
                songLocationMap.put(songLocation, song);
            } else if (songLocation.endsWith("png") || songLocation.endsWith("jpg")) {
                AbstractAnalyzer analyzer = new AudiverisSheetAnalyzer(songLocation);
                final Song song = analyzer.getSongRepresentation();
                songLocationMap.put(songLocation, song);
            }
        }
    }

    /**
     * Gets the source directory
     * @return
     */
    public String getSourceDirectory() {
        return sourceDirectory;
    }

    public String getDestinationDirectory() {
        return destinationDirectory;
    }
}
