package com.modulo7.engine;

import com.echonest.api.v4.EchoNestException;
import com.modulo7.acoustics.EchoNestBasicMP3Analyzer;
import com.modulo7.acoustics.MidiToSongConverter;
import com.modulo7.common.exceptions.Modulo7DataBaseNotSerializedException;
import com.modulo7.common.exceptions.Modulo7InvalidMusicXMLFile;
import com.modulo7.common.exceptions.Modulo7NoSuchFileException;
import com.modulo7.common.interfaces.AbstractAnalyzer;
import com.modulo7.common.utils.AvroUtils;
import com.modulo7.common.utils.Modulo7Utils;
import com.modulo7.crawler.utils.MusicSources;
import com.modulo7.image.AudiverisSheetAnalyzer;
import com.modulo7.musicstatmodels.representation.Song;
import com.modulo7.othersources.BasicMusicXMLParser;
import org.apache.commons.io.FilenameUtils;

import javax.sound.midi.InvalidMidiDataException;
import java.io.File;
import java.util.*;

/**
 * Created by asanyal on 8/31/15.
 *
 * Builds a complete Modulo7 Serialized database
 */
public class DatabaseEngine {

    // Source Directory or base location from all types of files are loaded by the parsers
    private String sourceDirectory;

    // Destination Directory
    private String destinationDirectory;

    // Directory in which contents are serialized
    private String serializationDirectory;

    // The song set along with a hashmap between location and songs and
    private Map<String, Song> songLocationMap = new HashMap<>();

    // A map containing song location to the deserialized location
    private Map<String, String> serializedSongLocationSet = new HashMap<>();

    // The inverse of the previous set
    private Map<Song, String> inverseSongLocationMap = new HashMap<>();

    // All set of all the song locations acquired by this database engine during init
    private Set<String> songLocations = new HashSet<>();

    // A boolean flag which indicates in the data base is prepared in memory
    private boolean isDataBaseConstructedInMemory = false;

    // A boolean flag which indicates if the data base has been serialized on disk or not
    private boolean isDataBasePresentOnDisk = false;

    /**
     * Basic directory
     * @param sourceDirectory
     * @param destinationDirectory
     * @param serializationDirectory
     */
    public DatabaseEngine(final String sourceDirectory, final String destinationDirectory, final String serializationDirectory) {
        this.destinationDirectory = destinationDirectory;
        this.sourceDirectory = sourceDirectory;
        this.serializationDirectory = serializationDirectory;

        Modulo7Utils.removeDuplicateFilesFromDirectory(sourceDirectory);

        // Recursively descend and list all the files that
        Set<String> allSongLocations = Modulo7Utils.listAllFiles(sourceDirectory);

        for (final String location : allSongLocations) {
            if (MusicSources.checkIfSupportedExtension(location)) {
                allSongLocations.add(location);
            }
        }
    }

    /**
     * Method which builds in memory database from scratch and populates
     *
     * The map for songs, in can later be used to serialize if required
     */
    public synchronized void buildInMemoryDataBaseFromScratch() throws InvalidMidiDataException,
            EchoNestException, Modulo7NoSuchFileException, Modulo7InvalidMusicXMLFile {
        for (final String songLocation : songLocations) {
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

        for (Map.Entry<String, Song> entry : songLocationMap.entrySet()) {
            inverseSongLocationMap.put(entry.getValue(), entry.getKey());
        }

        isDataBaseConstructedInMemory = true;
    }

    /**
     * Serialize the contents and dump database to a serialized location
     */
    public synchronized void serializeDataSetAndMoveToDisk() throws Modulo7NoSuchFileException, InvalidMidiDataException, Modulo7InvalidMusicXMLFile, EchoNestException {
        if (!isDataBaseConstructedInMemory) {
            buildInMemoryDataBaseFromScratch();
        }

        for (Map.Entry<String, Song> entry : songLocationMap.entrySet()) {

            final String fullLocation = entry.getKey();
            final Song song = entry.getValue();

            final String finalSerializedLocation = serializationDirectory + File.separator + FilenameUtils.getBaseName(fullLocation) + ".m7";
            AvroUtils.serialize(finalSerializedLocation, song);
            serializedSongLocationSet.put(fullLocation, finalSerializedLocation);
        }

        isDataBasePresentOnDisk = true;
        songLocationMap = new HashMap<>();
        inverseSongLocationMap = new HashMap<>();
        isDataBaseConstructedInMemory = false;
    }

    /**
     * Deserialize the dataset and build an in memory copy
     * Depending on the flag keep the disk copy or destroy it
     *
     * @param keepDiskCopy
     */
    public synchronized void deserializeDataSetAndBuildInMemory(final boolean keepDiskCopy) throws Modulo7DataBaseNotSerializedException,
            Modulo7NoSuchFileException {

        if (!isDataBasePresentOnDisk) {
            throw new Modulo7DataBaseNotSerializedException("Engine database has not been serialized, " +
                    "please run serializeDataSetAndMoveToDisk method first");
        }

        songLocationMap = new HashMap<>();
        inverseSongLocationMap = new HashMap<>();

        // Since the construction is from the disk, its information is
        for (final Map.Entry<String, String> entry : serializedSongLocationSet.entrySet()) {
            final String actualLocation = entry.getKey();
            final String diskFileLocation = entry.getValue();
            final Song song = AvroUtils.deserialize(diskFileLocation);

            songLocationMap.put(actualLocation, song);
            inverseSongLocationMap.put(song, actualLocation);

            // Delete the serialized file if no longer required on disk
            if (!keepDiskCopy) {
                File serializedFile = new File(diskFileLocation);
                assert (serializedFile.delete());
            }
        }

        isDataBaseConstructedInMemory = true;

        if (!keepDiskCopy) {
            serializedSongLocationSet = new HashMap<>();
            isDataBasePresentOnDisk = false;
        }
    }

    /**
     * Gets actual source location given the song object
     * @param song
     * @return
     */
    public String getLocationGivenSongObject(final Song song) {
        return inverseSongLocationMap.get(song);
    }

    /**
     * Gets the song given location map
     *
     * @param location
     * @return
     * @throws Modulo7DataBaseNotSerializedException
     */
    public Song getSongGivenLocation(final String location) throws Modulo7DataBaseNotSerializedException {

        // This operation does not make sense if the database is not constructed in the first place
        if (!isDataBaseConstructedInMemory) {
            throw new Modulo7DataBaseNotSerializedException("Engine database has not been serialized, " +
                    "please run serializeDataSetAndMoveToDisk method first");
        } else {
            return songLocationMap.get(location);
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