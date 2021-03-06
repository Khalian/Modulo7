package com.modulo7.cli;

import com.echonest.api.v4.EchoNestException;
import com.modulo7.common.exceptions.*;
import com.modulo7.common.interfaces.AbstractSongSimilarity;
import com.modulo7.common.interfaces.AbstractVoiceSimilarity;
import com.modulo7.common.interfaces.choices.SongSimilarityChoices;
import com.modulo7.common.interfaces.choices.VoiceSimilarityChoices;
import com.modulo7.engine.cache.Modulo7Cache;
import com.modulo7.engine.processing.Modulo7QueryProcessingEngine;
import com.modulo7.engine.processing.PlaybackEngine;
import com.modulo7.engine.processing.SimilarityRankingEngine;
import com.modulo7.engine.processing.TonalAlignmentEngine;
import com.modulo7.engine.storage.Modulo7Indexer;
import com.modulo7.musicstatmodels.representation.metadata.KeySignature;
import com.modulo7.musicstatmodels.representation.metadata.ScaleType;
import com.modulo7.musicstatmodels.representation.metadata.TimeSignature;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;
import com.modulo7.musicstatmodels.similarity.genericsimilarity.SongContourSimilarity;
import com.modulo7.nlp.lyrics.Lyrics;
import org.apache.commons.cli.*;
import org.apache.commons.cli.ParseException;
import org.apache.log4j.Logger;

import javax.sound.midi.InvalidMidiDataException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Created by asanyal on 9/11/15.
 *
 * The big daddy entry point of modulo7 indexing and server side operations
 *
 * Supported options:-
 *
 * input_src_dir - The input location of the sources
 * index_dest_dir - The indexed directory, where the indexed metadata can be serialized to disk
 * in_memory - A boolean flag which states whether data is purely in memory or should be serialized to disk
 * complete_metadata - In the event metadata is not present in music sources, whether modulo7 should guess it?
 * verbose - Should the output be verbose, when indexing and computing
 * num_threads - This argument would allow for an optional number of threads to spawn for java
 * playback - This argument would allow playback of query and
 *
 * This class supports all that modulo7 has to offer including an example standard query set and a custom query engine
 */
public class Modulo7CLI {

    // Input directory, all files to be indexed are inside this root directory
    private static final String MUSIC_SOURCES_DIR = "input_src_dir";

    // Index destination directory, all indexed files (if serialization is enabled) are stored here
    private static final String INDEX_DIR = "index_dest_dir";

    // Is the data base in memory, or should it also be persisted on disk
    private static final String PERSIST_ON_DISK = "in_memory";

    // Is metadata to be filled up by Modulo7, in order to compensate for missing information
    private static final String IS_METADATA_FIX_NEEDED = "complete_metadata";

    // Is metadata to be filled up by Modulo7, in order to compensate for missing information
    private static final String IS_CACHING_ENABLED = "caching_enabled";

    // Is the output during processing verbose or not
    private static final String VERBOSE_OUTPUT = "verbose";

    // Should Modulo7 invoke a playback for the similarity or query results
    private static final String DO_PLAYBACK = "playback";

    // A description string for music sources dir option
    private static final String MUSIC_SOURCE_DIR_DESC = "The source files root directory to index files from";

    // A description of the index dir option
    private static final String INDEX_DIR_DESC = "The location in which indexed files are stored";

    // A description of the is database in memory option
    private static final String PERSIST_ON_DISK_DESC = "Whether Modulo7 should keep the indexed data in memory " +
            "or serialize it to disk/db";

    // A description of is a metadata fix needed option
    private static final String IS_METADATA_FIX_NEEDED_DESC = "Whether Modulo7 attempts to complete its metadata or leaves " +
            "it incomplete if unspecified in the music source files";

    // A description of the is database in memory option
    private static final String IS_CACHING_ENABLED_DESC = "Is caching enabled for modulo7 queries";

    // A description of the verbose output tags
    private static final String VERBOSE_OUTPUT_DESC = "Whether the output is verbose or not";

    // Should Modulo7 invoke a playback for the similarity or query results
    private static final String DO_PLAYBACK_DESC = "Should Modulo7 invoke a playback for the similarity or query results";

    // CLI spacing to separate discrete regions in descriptions
    private static final String CLI_SPACING = " : ";

    // An engine to play back modules
    private static PlaybackEngine playBackEngine;

    // An indexer element for the Modulo7 CLI driver class
    private static Modulo7Indexer indexer;

    // Logger element in Modulo7 CLI
    private static final Logger logger = Logger.getLogger(Modulo7CLI.class);

    // Is the output verbose or not
    private static boolean verboseOutput;

    // Define a modulo7 cache for queries
    private static Modulo7Cache cache;

    // Is caching enabled
    private static boolean isCachingEnabled;

    // Is the modulo7 CLI mode in playback mode
    private static boolean isPlayBackEnabled;

    /**
     * Entry point to the Modulo7 CLI engine
     *
     * @param args
     * @throws ParseException
     * @throws Modulo7InvalidArgsException
     * @throws com.modulo7.common.exceptions.Modulo7InvalidFileOperationException
     * @throws EchoNestException
     * @throws Modulo7InvalidMusicXMLFile
     * @throws Modulo7ParseException
     * @throws com.modulo7.common.exceptions.Modulo7NoSuchFileOrDirectoryException
     * @throws InvalidMidiDataException
     * @throws Modulo7IndexingDirError
     */
    public static void main(String args[]) throws ParseException, Modulo7InvalidArgsException,
            Modulo7InvalidFileOperationException, EchoNestException, Modulo7InvalidMusicXMLFile,
            Modulo7ParseException, Modulo7NoSuchFileOrDirectoryException, InvalidMidiDataException,
            Modulo7IndexingDirError, InterruptedException {

        CommandLine commandLine = Modulo7CLI.getServerCommand(args);
        System.out.println("Indexing the given data");

        final String srcDir = commandLine.getOptionValue(MUSIC_SOURCES_DIR);
        final String indexDir = commandLine.getOptionValue(INDEX_DIR);
        final boolean persistOnDisk = commandLine.hasOption(PERSIST_ON_DISK);
        isCachingEnabled = commandLine.hasOption(IS_CACHING_ENABLED);
        isPlayBackEnabled = commandLine.hasOption(DO_PLAYBACK);

        if (isPlayBackEnabled) {
            playBackEngine = new PlaybackEngine(indexer.getDataBaseEngine());
        }

        if (isCachingEnabled) {
            cache = new Modulo7Cache();
        }

        verboseOutput = commandLine.hasOption(VERBOSE_OUTPUT);

        // Init the database with a set number of threads
        indexer = new Modulo7Indexer(srcDir, indexDir, persistOnDisk, verboseOutput);

        playBackEngine = new PlaybackEngine(indexer.getDataBaseEngine());

        indexer.indexData();
        System.out.println("Welcome to Modulo7 interactive prompt for analysis of the vector space models");
        interactiveCLI();
    }

    /**
     * Driver method for the interactive CLI
     */
    private static void interactiveCLI() {
        viewChoices();
    }

    /**
     * View the choices that are available to modulo7 users
     */
    private static void viewChoices() {

        Scanner in = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("");
                System.out.println("Welcome to the Modulo7 interactive window");
                System.out.println("Please input choice");
                System.out.println("");
                System.out.println(Modulo7CLIChoice.RET_SONGS_FOR_GIVEN_ARTIST.choice + ". Return set of songs for a given artist");
                System.out.println(Modulo7CLIChoice.RANK_ON_SIMILARITY_ORDER.choice + ". Return a ranked list of songs on a similarity measure");
                System.out.println(Modulo7CLIChoice.RET_SONGS_FOR_GIVEN_KEY_SIGNATURE.choice + ". Return set of songs for a given key signature");
                System.out.println(Modulo7CLIChoice.RET_SONGS_FOR_GIVEN_TIME_SIGNATURE.choice + ". Return set of songs for a given time signature");
                System.out.println(Modulo7CLIChoice.RET_LYRICS_GIVEN_SONG.choice + ". List out the lyrics of a song given the song name");
                System.out.println(Modulo7CLIChoice.LIST_NUM_SONGS_INDEXED.choice + ". List the number of songs indexed");
                System.out.println(Modulo7CLIChoice.INPUT_CUSTOM_QUERY.choice + ". Input a custom modulo7 SQL query");
                System.out.println(Modulo7CLIChoice.LYRICS_QUERY.choice + ". Input a lyrics snippet with options");
                System.out.println(Modulo7CLIChoice.MELODIC_ALIGNMENT_ANALYSIS.choice + ". Align melodies and check for submelodic similarity");
                System.out.println(Modulo7CLIChoice.SERIALIZE_DATABASE.choice + ". Serialize database into disk at a given location");
                System.out.println(Modulo7CLIChoice.PLAYBACK_SONG.choice + ". Playback a certain song in the Modulo7 database");
                System.out.println(Modulo7CLIChoice.EXIT.choice + ". Exit from Modulo7");
                System.out.println("");

                // Input a choice at this point
                System.out.print("Please Input choice:");
                Integer testNum = in.nextInt();
                executeChoice(Modulo7CLIChoice.parseChoice(testNum), in);
            } catch (Modulo7BaseException e) {
                System.out.println(e.getMessage());
                if (e instanceof Modulo7NoSuchSongSimilarityMeasureException) {
                    SongSimilarityChoices.listAllSimilarityMeasures();
                } else if (e instanceof  Modulo7NoSuchVoiceSimilarityMeasureException) {
                    VoiceSimilarityChoices.listAllSimilarityMeasures();
                }
            } catch (InvalidMidiDataException | EchoNestException | org.apache.lucene.queryparser.classic.ParseException | IOException e) {
                logger.error(e.getMessage());
            } catch (InputMismatchException ie) {
                System.out.println("Input to Modulo7 is wrong because " + ie.toString() + "exitting");
                System.exit(0);
            } catch (NoSuchElementException e) {
                System.out.println("Bad input in the CLI" + e + " exitting");
                System.exit(0);
            }
        }
    }

    /**
     * Method which executes a given choice in Modulo7, entry point to all the other sub components
     * of Modulo7
     *
     * @param testNum
     * @throws Modulo7BadKeyException
     * @throws Modulo7MalformedM7SQLQuery
     * @throws Modulo7QueryProcessingException
     * @throws Modulo7DataBaseNotSerializedException
     * @throws com.modulo7.common.exceptions.Modulo7NoSuchSongSimilarityMeasureException
     */
    private static void executeChoice(final Modulo7CLIChoice testNum, final Scanner in) throws Modulo7BadKeyException,
            Modulo7MalformedM7SQLQuery, Modulo7QueryProcessingException, Modulo7DataBaseNotSerializedException,
            Modulo7NoSuchSongSimilarityMeasureException, InvalidMidiDataException, Modulo7InvalidFileOperationException,
            EchoNestException, Modulo7IndexingDirError, Modulo7ParseException, Modulo7NoSuchFileOrDirectoryException,
            Modulo7InvalidMusicXMLFile, Modulo7NoSuchVoiceSimilarityMeasureException, IOException, org.apache.lucene.queryparser.classic.ParseException {
        switch (testNum) {
            // Process a custom query
            case INPUT_CUSTOM_QUERY:
                customQueryProcess();
                break;

            // Rank on a similarity order
            case RANK_ON_SIMILARITY_ORDER:
                similarityMeasureProcess(in);
                break;

            case MELODIC_ALIGNMENT_ANALYSIS:
                alignmentProcess(in);
                break;

            case LYRICS_QUERY:
                System.out.println("Enter a snippet of lyrics, Modulo7 will rank parsed lyrics");
                Scanner customLyricsIn = new Scanner(System.in);
                customLyricsIn.useDelimiter("\n");
                final String lyricsSnippet = customLyricsIn.nextLine();
                List<String> rankedOrderLyrics = indexer.rankLyrics(lyricsSnippet);

                if (rankedOrderLyrics.size() == 0) {
                    System.out.println("There are no lyrics that satisfy the query");
                    break ;
                }

                int rank = 1;

                System.out.println("Lyrics satisfying query in ranked order are:");

                for (final String lyrics : rankedOrderLyrics) {
                    System.out.println(rank + ":" + lyrics);
                    rank++;
                }

                break;

            // Case for returning all songs for a given key signature
            case RET_SONGS_FOR_GIVEN_KEY_SIGNATURE:
                System.out.print("Please enter the key:");
                final String key = in.next();
                System.out.print("Please enter the Scale:");
                final String inScale = in.next();
                ScaleType scaleType = ScaleType.getScaleTypeFromString(inScale);
                final KeySignature desiredKeySignature = new KeySignature(key, scaleType);
                final Set<Song> relevantSongObjects = indexer.getKeySignatureIndexedSet(desiredKeySignature);
                printAllRelevantSongLocations(relevantSongObjects);
                break;

            case RET_SONGS_FOR_GIVEN_TIME_SIGNATURE:
                System.out.print("Please enter the number of beats per measure:");
                final Integer num = in.nextInt();
                System.out.print("Please enter which note gets the beat:");
                final Integer dem = in.nextInt();
                final TimeSignature desiredTimeSignature = new TimeSignature(num, dem);
                final Set<Song> relevantSongs = indexer.getTimeSignatureIndexedSet(desiredTimeSignature);
                printAllRelevantSongLocations(relevantSongs);
                break;

            // Returns a list of songs for a given artist
            case RET_SONGS_FOR_GIVEN_ARTIST:
                System.out.print("Enter the name of the artist:");
                final String artist = in.next();
                final Set<Song> relevantArtistSongs = indexer.getArtistIndexedSet(artist);
                printAllRelevantSongLocations(relevantArtistSongs);
                break;

            // Returns the lyrics object for a given song
            case RET_LYRICS_GIVEN_SONG: System.out.print("Enter song name for which lyrics need to be acquired: ");
                String songName = in.next();
                final Song song = indexer.getSongObjectGivenSongName(songName);

                if (song != null) {

                    Lyrics lyrics = song.getLyrics();
                    if (lyrics != null) {
                        System.out.println(song.getLyrics().getLyricsOfSong());
                    }
                } else {
                    System.out.println("\n No such song");
                }
                break;

            case LIST_NUM_SONGS_INDEXED :
                     System.out.println("\nThere are " + indexer.getNumSongsIndexed() + " song sources indexed by Modulo7\n");
                     break;

            case SERIALIZE_DATABASE:
                     System.out.print("Input the root directory from which to serialize songs to:");
                     final String location = in.next();
                     indexer.putSongsToLocation(location);
                     System.out.println("Songs serialized, going to main menu");
                     break;

            case PLAYBACK_SONG:
                    System.out.print("Enter song location to play:");
                    final String playbackLocation = in.next();
                    playBackEngine.playSong(playbackLocation);

            case EXIT : System.out.println("Exitting from Modulo7");
                     System.exit(0);
                     break;

            default: System.out.println("\nDoes not match any of the choices, exitting"); System.exit(0);
        }
    }

    /**
     * Helper method to parse command line options via apache CLI for the server side CLI
     * @param args - Arguments passed on the command line
     * @throws Modulo7InvalidArgsException
     * @throws ParseException
     */
    public static CommandLine getServerCommand(final String[] args) throws Modulo7InvalidArgsException, ParseException {

        if (args == null || args.length < 1 || args[0] == null) {
            assert args != null;
            System.out.println("Invalid number of arguments : " + args.length + " must have one or more args. Printing help");
            help();
            System.exit(0);
        }

        try {
            // create Options object
            final Options m7Options = new Options();

            // options currently supported by the indexer sub system
            m7Options.addOption(MUSIC_SOURCES_DIR, true,
                    MUSIC_SOURCE_DIR_DESC);
            m7Options.addOption(INDEX_DIR, false,
                    INDEX_DIR_DESC);
            m7Options.addOption(PERSIST_ON_DISK, true,
                    PERSIST_ON_DISK_DESC);
            m7Options.addOption(IS_METADATA_FIX_NEEDED, false,
                    IS_METADATA_FIX_NEEDED_DESC);
            m7Options.addOption(VERBOSE_OUTPUT, false,
                    VERBOSE_OUTPUT_DESC);
            m7Options.addOption(IS_CACHING_ENABLED, false,
                    IS_CACHING_ENABLED_DESC);
            m7Options.addOption(DO_PLAYBACK, false,
                    DO_PLAYBACK_DESC);

            CommandLineParser parser = new DefaultParser();

            return parser.parse(m7Options,args);
        } catch (UnrecognizedOptionException e) {
            System.out.println(e.getMessage() + " Printing help");
            help();
            System.exit(0);
        }

        return null;
    }

    /**
     * Helper method for displaying help
     */
    private static void help() {
        System.out.println("Welcome to Modulo7 help");
        System.out.println("");
        System.out.println("Potential Arguments to Modulo7 prompt are:");
        System.out.println(MUSIC_SOURCES_DIR + CLI_SPACING +  MUSIC_SOURCE_DIR_DESC);
        System.out.println(INDEX_DIR + CLI_SPACING +INDEX_DIR_DESC);
        System.out.println(PERSIST_ON_DISK + CLI_SPACING + PERSIST_ON_DISK_DESC);
        System.out.println(IS_METADATA_FIX_NEEDED + CLI_SPACING + IS_METADATA_FIX_NEEDED_DESC);
        System.out.println(VERBOSE_OUTPUT + CLI_SPACING + VERBOSE_OUTPUT_DESC);
        System.out.println(IS_CACHING_ENABLED + CLI_SPACING + IS_CACHING_ENABLED_DESC);
        System.out.println(DO_PLAYBACK + CLI_SPACING + DO_PLAYBACK_DESC);
        System.out.println("");
    }

    /**
     * Prints all the relevant song locations given the relevant songs objects
     *
     * @param allRelevantSongs - a set of all the relevant songs
     * @throws Modulo7DataBaseNotSerializedException
     */
    private static void printAllRelevantSongLocations(final Set<Song> allRelevantSongs)
            throws Modulo7DataBaseNotSerializedException {
        final Set<String> locations = indexer.getLocationsGivenRelevantSongs(allRelevantSongs);

        if (isPlayBackEnabled) {
            System.out.println("Modulo7 will playback the songs because playback mode is enabled");
        }

        if (locations.size() == 0) {
            System.out.println("No songs are relevant to your query\n");
        } else {
            System.out.println("The locations of relevant songs are :");
            for (final String location : locations) {
                System.out.println(location);
                if (isPlayBackEnabled) {
                    playBackEngine.playSong(location);
                }
            }
        }
    }

    /**
     * Get all the relevant songs
     *
     * @param allRelevantSongs
     * @return
     * @throws Modulo7DataBaseNotSerializedException
     */
    private static Set<String> getAllRelevantSongLocations(final Set<Song> allRelevantSongs) throws Modulo7DataBaseNotSerializedException {
        return indexer.getLocationsGivenRelevantSongs(allRelevantSongs);
    }

    /**
     * Process a custom query
     */
    private static void customQueryProcess() {
        System.out.println("Consumer is going into custom query mode, now changing to Modulo7 SQL parser mode \n");
        System.out.print("Enter input query : ");
        Scanner customIn = new Scanner(System.in);

        customIn.useDelimiter("\n");

        final String queryStr = customIn.next();
        System.out.println("");
        Modulo7QueryProcessingEngine processingEngine;
        try {
            processingEngine = new Modulo7QueryProcessingEngine(queryStr, indexer);
            if (isCachingEnabled) {
                final Set<String> cachedSongResults = (Set<String>) cache.getCachedResults(queryStr);
                if (cachedSongResults == null) {
                    // Caching was bad revert to normal mode
                    final Set<Song> relevantSongs = processingEngine.processQuery();
                    final Set<String> relevantResults = getAllRelevantSongLocations(relevantSongs);
                    cache.cacheQueryResults(queryStr, new LinkedHashSet<>(relevantResults));
                } else {
                    System.out.println("The locations of relevant songs are :");
                    cachedSongResults.forEach(System.out::println);
                }
            }
            Set<Song> relevantSongs = processingEngine.processQuery();
            printAllRelevantSongLocations(relevantSongs);
        } catch (Modulo7MalformedM7SQLQuery | Modulo7QueryProcessingException | Modulo7DataBaseNotSerializedException e) {
            logger.error(e.getMessage());
        }
    }

    private static void alignmentProcess(final Scanner in) throws Modulo7NoSuchVoiceSimilarityMeasureException {
        System.out.println("You are in the tonal alingment mode");
        System.out.println("In this mode, Modulo7 looks for various snippets of songs that are alignment with each other and print the alignments");
        System.out.println("We use smith waterman algorithm for the alignment");


        try {
            System.out.print("Enter the location of a song to rank the rest of the database against:");
            final String candidateSongLocation = in.next();
            final Song song = indexer.getSongObjectGivenLocation(candidateSongLocation);
            TonalAlignmentEngine engine = new TonalAlignmentEngine();
            engine.align(indexer.getDataBaseEngine(), song);

        } catch (Modulo7DataBaseNotSerializedException e) {
            logger.error(e.getMessage());
        }
    }

    /**
     *  Process the similarity measure
     *
     * @param in
     * @throws Modulo7NoSuchSongSimilarityMeasureException
     */
    private static void similarityMeasureProcess(final Scanner in) throws Modulo7NoSuchSongSimilarityMeasureException {
        System.out.print("Enter a similarity measure:");
        final String similarityMeasure = in.next();
        String voiceSimilarity = "";

        Class similarityChoice = SongSimilarityChoices.getSongSimilarityGivenChoice(similarityMeasure);

        if (similarityChoice == null) {
            throw new Modulo7NoSuchSongSimilarityMeasureException("No such song similarity measure " + similarityMeasure);
        } else {
            try {
                AbstractSongSimilarity similarity;

                if (SongContourSimilarity.class.isAssignableFrom(similarityChoice)) {
                    System.out.print("You seem to have chosen a contour similarity class, in that case input a internal voice similarity measure:");
                    voiceSimilarity = in.next();
                    Class voiceSimClass = VoiceSimilarityChoices.getVoiceSimilarityGivenChoice(voiceSimilarity);

                    if (voiceSimClass == null) {
                        throw new Modulo7NoSuchVoiceSimilarityMeasureException("No such voice similarity measure" + voiceSimilarity);
                    }

                    AbstractVoiceSimilarity voiceSim = (AbstractVoiceSimilarity) voiceSimClass.newInstance();
                    similarity = (AbstractSongSimilarity) similarityChoice.getConstructor(AbstractVoiceSimilarity.class).newInstance(voiceSim);
                } else {
                    similarity = (AbstractSongSimilarity) similarityChoice.newInstance();
                }

                System.out.print("Do you wish to set a particular number of songs to be displayed as relevant(y/n)?:");

                String res = in.next();

                int maxNum = Integer.MAX_VALUE;

                if (res.equalsIgnoreCase("y")) {
                    System.out.print("Enter of relevant songs for viewing:");
                    maxNum = in.nextInt();
                }

                SimilarityRankingEngine engineOnSimilarity = new SimilarityRankingEngine(similarity);
                System.out.print("Enter the location of a song to rank the rest of the database against:");
                final String candidateSongLocation = in.next();

                final String query = constructSimilarityQuery(similarityMeasure, voiceSimilarity ,candidateSongLocation);

                if (isCachingEnabled) {
                    final LinkedHashMap<String, Double> cachedRankOrder = (LinkedHashMap<String, Double>) cache.getCachedResults(query);
                    if (cachedRankOrder == null) {
                        final LinkedHashMap<String, Double> rankedOrder =
                                engineOnSimilarity.relevantRankOrdering(indexer.getDataBaseEngine(), indexer.getSongObjectGivenLocation(candidateSongLocation));
                        cache.cacheQueryResults(query, rankedOrder);
                        printRankedOrder(rankedOrder, maxNum);
                    } else {
                        printRankedOrder(cachedRankOrder, maxNum);
                    }
                }

                indexer.addSingleAdditionalSongToIndex(candidateSongLocation);
                final LinkedHashMap<String, Double> rankedOrder =
                        engineOnSimilarity.relevantRankOrdering(indexer.getDataBaseEngine(), indexer.getSongObjectGivenLocation(candidateSongLocation));

                printRankedOrder(rankedOrder, maxNum);

            } catch (InstantiationException | IllegalAccessException | InvalidMidiDataException
                    | Modulo7InvalidFileOperationException | EchoNestException | Modulo7IndexingDirError
                    | Modulo7ParseException | Modulo7NoSuchFileOrDirectoryException | Modulo7InvalidMusicXMLFile
                    | NoSuchMethodException | InvocationTargetException | Modulo7DataBaseNotSerializedException
                    | Modulo7NoSuchVoiceSimilarityMeasureException e) {
                logger.error(e.getMessage());
            }
        }
    }

    /**
     * A query representation of modulo7 similarity queries
     *
     * @param similarityMeasure
     * @param voiceSimilarity
     * @param candidateSongLocation
     *
     * @return a similarity query
     */
    private static String constructSimilarityQuery(final String similarityMeasure,
                   final String voiceSimilarity, final String candidateSongLocation) {
        return "SIM:" + similarityMeasure + " VOICE_SIM:" + voiceSimilarity + " CANDIDATE:" + candidateSongLocation;
    }

    /**
     * Print the ranked order of similarity measures
     *
     * @param rankedOrder
     * @param maxNum
     */
    private static void printRankedOrder(final LinkedHashMap<String, Double> rankedOrder, final int maxNum) {
        System.out.println("The ranked order of the songs are");

        int rank = 1;

        // Print out the element in ranked order
        for (final Map.Entry<String, Double> entry : rankedOrder.entrySet()) {
            final String elem = entry.getKey();
            System.out.print(rank + ":" + elem);
            if (verboseOutput) {
                System.out.println(": SIM VAL :" + entry.getValue());
            } else {
                System.out.println("");
            }
            rank++;
            if (rank > maxNum) {
                break;
            }
        }
    }
}
