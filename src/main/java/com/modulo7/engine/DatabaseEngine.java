package com.modulo7.engine;

import com.echonest.api.v4.EchoNestException;
import com.modulo7.acoustics.EchoNestBasicMP3Analyzer;
import com.modulo7.acoustics.MidiToSongConverter;
import com.modulo7.common.exceptions.*;
import com.modulo7.common.interfaces.AbstractAnalyzer;
import com.modulo7.common.utils.AvroUtils;
import com.modulo7.common.utils.Modulo7Utils;
import com.modulo7.crawler.utils.MusicSources;
import com.modulo7.image.AudiverisSheetAnalyzer;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;
import com.modulo7.nlp.Lyrics;
import com.modulo7.othersources.BasicMusicXMLParser;
import org.apache.commons.io.FilenameUtils;

import javax.sound.midi.InvalidMidiDataException;
import java.io.File;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;
import java.util.stream.Collectors;

/**
 * Created by asanyal on 8/31/15.
 *
 * Builds a complete Modulo7 Serialized database from the various source files that modulo7
 * supports and optionally serialize it to disk
 *
 * TODO : Build a multithreaded version that performs better, in process
 */
public class DatabaseEngine implements Runnable {

    // Source Directory or base location from all types of files are loaded by the parsers
    private String sourceDirectory;

    // Destination Directory in which the serialization results are finally stored
    private String destinationDirectory;

    private static final String DEFAULT_ENGINE_NAME = "default_database";

    // The name of the database that this engine operates on
    private String databaseName = DEFAULT_ENGINE_NAME;

    // Whether there is verbose output during processing by the database
    private boolean verboseOutput = false;

    // A hash map between location and songs in Modulo7 format and
    private Map<String, Song> songLocationMap = new HashMap<>();

    // A hash map between indepedent lyrics object in Modulo7 format
    private Map<String, Lyrics> independentLyricsMap = new HashMap<>();

    // A map containing song location to the deserialized location
    private Map<String, String> serializedSongLocationSet = new HashMap<>();

    // The inverse of the song to location map
    private Map<Song, String> inverseSongLocationMap = new HashMap<>();

    // The inverse of the lyrics object to location map
    private Map<Lyrics, String> inverseIndependentLyricsMap = new HashMap<>();

    // All set of all the song locations acquired by this database engine during init
    private Set<String> songLocations = new HashSet<>();

    // A boolean flag which indicates in the data base is prepared in memory
    private boolean isDataBaseConstructedInMemory = false;

    // A boolean flag which indicates if the data base has been serialized on disk or not
    private boolean isDataBasePresentOnDisk = false;

    // A thread pool artifact that is created at run time
    private ExecutorService databaseThreadPool;

    /**
     * Basic database engine constructor, this constructors accepts a source directory
     * which is a root directory from all the required files  are fetched. Once its fetched
     *
     * @param sourceDirectory
     * @param destinationDirectory
     */
    public DatabaseEngine(final String sourceDirectory, final String destinationDirectory) throws Modulo7InvalidArgsException {
        this.destinationDirectory = destinationDirectory;
        this.sourceDirectory = sourceDirectory;
        this.databaseName = DEFAULT_ENGINE_NAME;

        Modulo7Utils.removeDuplicateFilesFromDirectory(sourceDirectory);

        // Recursively descend and list all the files that
        Set<String> allSongLocations = Modulo7Utils.listAllFiles(sourceDirectory);

        songLocations.addAll(allSongLocations.stream().filter(MusicSources::checkIfSupportedExtension).collect(Collectors.toList()));

        databaseThreadPool = Executors.newFixedThreadPool(1);
    }

    /**
     * Basic database engine constructor, this constructors accepts a source directory
     * which is a root directory from all the required files  are fetched. Once its fetched
     *
     * @param databaseName
     * @param sourceDirectory
     * @param destinationDirectory
     */
    public DatabaseEngine(final String databaseName, final String sourceDirectory, final String destinationDirectory) throws Modulo7InvalidArgsException {
        this.destinationDirectory = destinationDirectory;
        this.sourceDirectory = sourceDirectory;
        this.databaseName = databaseName;

        Modulo7Utils.removeDuplicateFilesFromDirectory(sourceDirectory);

        // Recursively descend and list all the files that
        Set<String> allSongLocations = Modulo7Utils.listAllFiles(sourceDirectory);

        songLocations.addAll(allSongLocations.stream().filter(MusicSources::checkIfSupportedExtension).collect(Collectors.toList()));

        databaseThreadPool = Executors.newFixedThreadPool(1);
    }

    /**
     * Constructor defined with verbose output as well as source and destination
     * directories
     *
     * @param srcDir
     * @param dstDir
     * @param verboseOutput
     */
    public DatabaseEngine(final String srcDir, final String dstDir, final boolean verboseOutput) throws Modulo7InvalidArgsException {
        this.destinationDirectory = dstDir;
        this.sourceDirectory = srcDir;
        this.verboseOutput = verboseOutput;

        Modulo7Utils.removeDuplicateFilesFromDirectory(sourceDirectory);

        // Recursively descend and list all the files that
        Set<String> allSongLocations = Modulo7Utils.listAllFiles(sourceDirectory);

        songLocations.addAll(allSongLocations.stream().filter(MusicSources::checkIfSupportedExtension).collect(Collectors.toList()));

        databaseThreadPool = Executors.newFixedThreadPool(1);
    }

    /**
     * Init with number of threads in the executor pool
     *
     * @param srcDir
     * @param dstDir
     * @param verboseOutput
     * @param numThreads
     * @throws Modulo7InvalidArgsException
     */
    public DatabaseEngine(final String srcDir, final String dstDir, final boolean verboseOutput, final int numThreads)
            throws Modulo7InvalidArgsException {
        this.destinationDirectory = dstDir;
        this.sourceDirectory = srcDir;
        this.verboseOutput = verboseOutput;

        Modulo7Utils.removeDuplicateFilesFromDirectory(sourceDirectory);

        // Recursively descend and list all the files that
        Set<String> allSongLocations = Modulo7Utils.listAllFiles(sourceDirectory);

        songLocations.addAll(allSongLocations.stream().filter(MusicSources::checkIfSupportedExtension).collect(Collectors.toList()));

        databaseThreadPool = Executors.newFixedThreadPool(numThreads);
    }

    /**
     * A method to incrementatally add elements
     *
     * @param songLocation
     * @throws EchoNestException
     * @throws Modulo7NoSuchFileException
     * @throws InvalidMidiDataException
     * @throws Modulo7InvalidMusicXMLFile
     * @throws Modulo7InvalidFileOperationExeption
     * @throws Modulo7ParseException
     *
     * @return whether to incrementally add to database or not
     *
     */
    public synchronized boolean incrementalAddToDatabase(final String songLocation) throws EchoNestException, Modulo7NoSuchFileException,
            InvalidMidiDataException, Modulo7InvalidMusicXMLFile, Modulo7InvalidFileOperationExeption, Modulo7ParseException {

        if (songLocationMap.containsKey(songLocation)) {
            return false;
        }

        parseSource(songLocation);

        return true;
    }

    /**
     * A method to build and in memory database from scratch
     *
     * Consumer can serialize the information later on
     *
     * @throws InvalidMidiDataException
     * @throws EchoNestException
     * @throws Modulo7NoSuchFileException
     * @throws Modulo7InvalidMusicXMLFile
     * @throws Modulo7InvalidFileOperationExeption
     * @throws Modulo7ParseException
     */
    public synchronized void buildInMemoryDataBaseFromScratch() throws InvalidMidiDataException,
            EchoNestException, Modulo7NoSuchFileException, Modulo7InvalidMusicXMLFile, Modulo7InvalidFileOperationExeption,
            Modulo7ParseException {
        for (final String songLocation : songLocations) {
            parseSource(songLocation);
        }

        isDataBaseConstructedInMemory = true;
    }

    /**
     * Parse a given source
     * @param songLocation
     * @throws InvalidMidiDataException
     * @throws Modulo7NoSuchFileException
     * @throws EchoNestException
     * @throws Modulo7InvalidMusicXMLFile
     * @throws Modulo7ParseException
     * @throws Modulo7InvalidFileOperationExeption
     */
    private Song parseSource(final String songLocation) throws InvalidMidiDataException, Modulo7NoSuchFileException,
            EchoNestException, Modulo7InvalidMusicXMLFile, Modulo7ParseException, Modulo7InvalidFileOperationExeption {

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
        } else if (songLocation.endsWith("m7lyrics")) {
            // TODO : Fix these elements
            Lyrics lyrics = new Lyrics("Artist", "Album", new File(songLocation));
            independentLyricsMap.put(songLocation, lyrics);
            inverseIndependentLyricsMap.put(lyrics, songLocation);
        } else if (songLocation.endsWith("m7")) {
            // Build an in memory datbase from an already serialized one, fastest way to deal with preconstructed database
            song = AvroUtils.deserialize(songLocation);
            addToSongLocationMap(songLocation, song);
        }

        return song;
    }

    /**
     * Method to serialize and both get a song
     *
     * @throws Modulo7InvalidMusicXMLFile
     * @throws Modulo7NoSuchFileException
     * @throws EchoNestException
     * @throws InvalidMidiDataException
     * @throws Modulo7InvalidFileOperationExeption
     * @throws Modulo7ParseException
     */
    public synchronized void dynamicBuildDataSet() throws Modulo7InvalidMusicXMLFile,
            Modulo7NoSuchFileException, EchoNestException, InvalidMidiDataException,
            Modulo7InvalidFileOperationExeption, Modulo7ParseException {
        for (final String songLocation : songLocations) {
            final Song song = parseSource(songLocation);
            serializeAndPutToDisk(songLocation, song);
        }

        isDataBasePresentOnDisk = true;
        isDataBaseConstructedInMemory = false;
    }

    /**
     * Method to serialize a song object and put to appropriate location in disk
     * @param songLocation
     * @param song
     * @throws Modulo7NoSuchFileException
     */
    private synchronized void serializeAndPutToDisk(final String songLocation, final Song song) throws Modulo7NoSuchFileException {
        final String finalSerializedLocation = destinationDirectory + File.separator + FilenameUtils.getBaseName(songLocation) + ".m7";
        AvroUtils.serialize(finalSerializedLocation, song);
        serializedSongLocationSet.put(songLocation, finalSerializedLocation);
    }

    /**
     * Serialize and put database in a given location
     *
     * @throws Modulo7NoSuchFileException
     * @throws InvalidMidiDataException
     * @throws Modulo7InvalidMusicXMLFile
     * @throws EchoNestException
     * @throws Modulo7InvalidFileOperationExeption
     * @throws Modulo7ParseException
     */
    public synchronized void serializeDataSetAndMoveToDisk() throws Modulo7NoSuchFileException, InvalidMidiDataException,
            Modulo7InvalidMusicXMLFile, EchoNestException, Modulo7InvalidFileOperationExeption, Modulo7ParseException {

        if (!isDataBaseConstructedInMemory) {
            buildInMemoryDataBaseFromScratch();
        }

        for (Map.Entry<String, Song> entry : songLocationMap.entrySet()) {

            final String fullLocation = entry.getKey();
            final Song song = entry.getValue();

            final String finalSerializedLocation = destinationDirectory + File.separator + FilenameUtils.getBaseName(fullLocation) + ".m7";
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

            addToSongLocationMap(actualLocation, song);

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
     * Method to add song object to location map and inverse location map
     * @param actualLocationOnDisk
     * @param songObject
     */
    private synchronized void addToSongLocationMap(final String actualLocationOnDisk, final Song songObject) {

        if (verboseOutput) {
            System.out.println("Indexed file " + actualLocationOnDisk);
        }

        songLocationMap.put(actualLocationOnDisk, songObject);
        inverseSongLocationMap.put(songObject, actualLocationOnDisk);
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
     * Gets the location from where the song has been parsed
     * @param song
     * @return
     * @throws Modulo7DataBaseNotSerializedException
     */
    public String getLocationGivenSong(final Song song) throws Modulo7DataBaseNotSerializedException {
        // This operation does not make sense if the database is not constructed in the first place
        if (!isDataBaseConstructedInMemory) {
            throw new Modulo7DataBaseNotSerializedException("Engine database has not been serialized, " +
                    "please run serializeDataSetAndMoveToDisk method first");
        } else {
            return inverseSongLocationMap.get(song);
        }
    }

    /**
     * Gets the source directory in which input sources are stored
     * @return
     */
    public String getSourceDirectory() {
        return sourceDirectory;
    }

    /**
     * Gets the destination directory in which all the indexed data is stored
     * @return
     */
    public String getDestinationDirectory() {
        return destinationDirectory;
    }

    /**
     * Getter for the song location mapping
     * @return
     */
    public Set<String> getSongLocationSet() {
        return songLocationMap.keySet();
    }

    /**
     * Same as getSongGivenLocation, but without the constraint of having serialized
     * the whole database
     *
     * @param location
     * @return
     */
    public Song getSongGivenLocationInMemoryVersion(final String location) {
        return songLocationMap.get(location);
    }

    /**
     * Getter for the number of songs parsed
     * @return
     */
    public int getNumSongsParsed() {
        return songLocationMap.size();
    }

    /**
     * Getter for the entire song location map
     * @return
     */
    protected Map<String, Song> getSongLocationMap() {
        return songLocationMap;
    }

    /**
     * Get the database name
     * @return
     */
    protected String getDatabaseName() {
        return databaseName;
    }

    /**
     * Gets all the songs
     * @return
     */
    protected Set<Song> getAllSongs() {
        return inverseSongLocationMap.keySet();
    }

    @Override
    public void run() {
        // TODO : Stub impl, need to implement
    }
}
