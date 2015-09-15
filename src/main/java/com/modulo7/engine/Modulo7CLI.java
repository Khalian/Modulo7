package com.modulo7.engine;

import com.echonest.api.v4.EchoNestException;
import com.modulo7.common.exceptions.Modulo7IndexingDirError;
import com.modulo7.common.exceptions.Modulo7InvalidArgsException;
import com.modulo7.common.exceptions.Modulo7InvalidMusicXMLFile;
import com.modulo7.common.exceptions.Modulo7NoSuchFileException;
import org.apache.commons.cli.*;

import javax.sound.midi.InvalidMidiDataException;

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
 *
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
            Modulo7InvalidMusicXMLFile, EchoNestException, Modulo7NoSuchFileException, Modulo7IndexingDirError {

        CommandLine commandLine = Modulo7CLI.getServerCommand(args);
        Modulo7Indexer indexer = new Modulo7Indexer(commandLine.getOptionValue(MUSIC_SOURCES_DIR), commandLine.getOptionValue(INDEX_DIR));
        indexer.indexData();

        System.out.println("Welcome to Modulo7 interactive prompt for analysis");
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
            throw new Modulo7InvalidArgsException("Invalid number of arguments : " + args.length);
        }

        // create Options object
        Options m7Options = new Options();

        // options currently supported by the indexer sub system
        m7Options.addOption(MUSIC_SOURCES_DIR, true,
                "The source files root directory to index files from");
        m7Options.addOption(INDEX_DIR, true,
                "The location in which indexed files are stored");
        m7Options.addOption(IS_DATABASE_IN_MEMORY, true,
                "Whether Modulo7 should keep the indexed data in memory or serialize it to disk/db");
        m7Options.addOption(IS_METADATA_FIX_NEEDED, true,
                "Whether Modulo7 attempts to complete its metadata or leaves it incomplete if unspecified in source file");

        CommandLineParser parser = new DefaultParser();

        return parser.parse(m7Options,args);
    }
}
