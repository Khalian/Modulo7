package com.modulo7.engine;

import com.echonest.api.v4.EchoNestException;
import com.modulo7.common.exceptions.*;
import org.apache.commons.cli.*;

import javax.sound.midi.InvalidMidiDataException;
import java.util.Scanner;

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
 */
public class Modulo7CLI {

    // Input directory, all files to be indexed are inside this root directory
    private static final String MUSIC_SOURCES_DIR = "input_src_dir";

    // Index destination directory, all indexed files (if serialization is enabled) are stored here
    private static final String INDEX_DIR = "index_dest_dir";

    // Is the data base in memory
    private static final String IS_DATABASE_IN_MEMORY = "in_memory";

    // Is metadata to be filled up by Modulo7, in order to compensate for missing information
    private static final String IS_METADATA_FIX_NEEDED = "complete_metadata";

    // Is the output during processing verbose or not
    private static final String VERBOSE_OUTPUT = "verbose";

    // A description string for music sources dir option
    private static final String MUSIC_SOURCE_DIR_DESC = "The source files root directory to index files from";

    // A description of the index dir option
    private static final String INDEX_DIR_DESC = "The location in which indexed files are stored";

    // A description of the is database in memory option
    private static final String IS_DATABASE_IN_MEMORY_DESC = "Whether Modulo7 should keep the indexed data in memory " +
            "or serialize it to disk/db";

    // A description of is a metadata fix needed option
    private static final String IS_METADATA_FIX_NEEDED_DESC = "Whether Modulo7 attempts to complete its metadata or leaves " +
            "it incomplete if unspecified in the music source files";

    // A description of the verbose output tags
    private static final String VERBOSE_OUTPUT_DESC = "Whether the output is verbose or not";

    // CLI spacing to separate discrete regions in descriptions
    private static final String CLI_SPACING = " : ";

    // An indexer element for the Modulo7 CLI driver class
    private static Modulo7Indexer indexer;

    /**
     * Entry point to modulo 7 CLI engine
     *
     * @param args
     * @throws ParseException
     * @throws Modulo7InvalidArgsException
     * @throws InvalidMidiDataException
     * @throws Modulo7InvalidMusicXMLFile
     * @throws EchoNestException
     * @throws Modulo7NoSuchFileException
     * @throws Modulo7IndexingDirError
     */
    public static void main(String args[]) throws ParseException, Modulo7InvalidArgsException, InvalidMidiDataException,
            Modulo7InvalidMusicXMLFile, EchoNestException, Modulo7NoSuchFileException, Modulo7IndexingDirError, Modulo7InvalidFIleOperationExeption {

        CommandLine commandLine = Modulo7CLI.getServerCommand(args);
        indexer = new Modulo7Indexer(commandLine.getOptionValue(MUSIC_SOURCES_DIR), commandLine.getOptionValue(INDEX_DIR));
        System.out.println("Indexing the given data");
        indexer.indexData();

        System.out.println("Welcome to Modulo7 interactive prompt for analysis of the vector space models");
        
        interactiveCLI();
    }

    /**
     * Driver method for the interactive CLI measures
     */
    private static void interactiveCLI() {
        System.out.println("Input choice:");
        viewChoices();
    }

    /**
     * View the choices that are available to modulo7 users for consumption
     */
    private static void viewChoices() {

        while (true) {
            System.out.println(Modulo7CLIChoices.RET_SONGS_FOR_GIVEN_ARTIST.choice + ", Return set of songs for a given artist");
            System.out.println(Modulo7CLIChoices.RET_SONGS_FOR_GIVEN_KEY_SIGNATURE.choice + ". Return set of songs for a given key signature");
            System.out.println(Modulo7CLIChoices.RET_SONGS_FOR_GIVEN_TIME_SIGNATURE.choice + ". Return set of songs for a given time signature");
            System.out.println(Modulo7CLIChoices.RET_LYRICS_GIVEN_SONG.choice + ". List out the lyrics of a song given the song name");
            System.out.println(Modulo7CLIChoices.LIST_NUM_SONGS_INDEXED.choice + ". List the number of songs indexed");
            System.out.println(Modulo7CLIChoices.INPUT_CUSTOM_QUERY.choice + ". Input a custom modulo7 SQL query");
            System.out.println(Modulo7CLIChoices.EXIT.choice + ". Exit from Modulo7");

            // Input a choice at this point
            System.out.print("Please Input choice:");
            Scanner in = new Scanner(System.in);

            int testNum = in.nextInt();
            exectuteChoice(testNum);
        }
    }

    /**
     * Method used to execute a choice
     * @param testNum
     */
    private static void exectuteChoice(final int testNum) {
        switch (testNum) {
            case 6 : System.out.println("There are " + indexer.getNumSongsIndexed() + "song sources indexed by Modulo7");
                     break;
            case 8 : System.out.println("Exitting Modulo7");
                     System.exit(0);
                     break;
            default: System.out.println("Does not match any of the choices, exitting"); System.exit(0);
        }
    }

    /**
     * Helper method to parse command line options via apache CLI for the server side CLI
     * @param args
     * @return
     * @throws Modulo7InvalidArgsException
     * @throws ParseException
     */
    public static CommandLine getServerCommand(final String[] args) throws Modulo7InvalidArgsException, ParseException {

        if (args == null || args.length < 1 || args[0] == null) {
            assert args != null;
            System.out.println("Invalid number of arguments : " + args.length + " must have one or more args");
            help();
            System.exit(0);
        }

        // create Options object
        Options m7Options = new Options();

        // options currently supported by the indexer sub system
        m7Options.addOption(MUSIC_SOURCES_DIR, true,
                MUSIC_SOURCE_DIR_DESC);
        m7Options.addOption(INDEX_DIR, true,
                INDEX_DIR_DESC);
        m7Options.addOption(IS_DATABASE_IN_MEMORY, true,
                IS_DATABASE_IN_MEMORY_DESC);
        m7Options.addOption(IS_METADATA_FIX_NEEDED, true,
                IS_METADATA_FIX_NEEDED_DESC);
        m7Options.addOption(VERBOSE_OUTPUT, true,
                VERBOSE_OUTPUT_DESC);

        CommandLineParser parser = new DefaultParser();

        return parser.parse(m7Options,args);
    }

    /**
     * Helper method for displaying help
     */
    private static void help() {
        System.out.println("Potential Arguments to Modulo7 prompt are:");
        System.out.println(MUSIC_SOURCES_DIR + CLI_SPACING +  MUSIC_SOURCE_DIR_DESC);
        System.out.println(INDEX_DIR + CLI_SPACING +INDEX_DIR_DESC);
        System.out.println(IS_DATABASE_IN_MEMORY + CLI_SPACING +IS_DATABASE_IN_MEMORY_DESC);
        System.out.println(IS_METADATA_FIX_NEEDED + CLI_SPACING + IS_METADATA_FIX_NEEDED_DESC);
        System.out.println(VERBOSE_OUTPUT + CLI_SPACING + VERBOSE_OUTPUT_DESC);
    }

}
