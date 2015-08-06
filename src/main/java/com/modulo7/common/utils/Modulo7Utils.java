package com.modulo7.common.utils;

import com.modulo7.musicstatmodels.representation.Note;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by asanyal on 7/20/2015.
 *
 * Various Utilities for Modulo7
 *
 * Utility functions include :
 *
 * 1. removeDuplicateLinesFromFile : Useful for trimming artists crawled etc
 * 2. removeDuplicateFiles : Removing duplicate files from a root directory
 */
public class Modulo7Utils {

    // An instance of the frequency note map in the Modulo7 Utils classs
    private static final FrequencyNoteMap noteMap = FrequencyNoteMap.getInstance();

    /**
     * Processes a text file and removes duplicates from the file
     *
     * This will be used to remove duplicate artists from crawled artists etc
     *
     * @param fileName
     * @throws IOException
     */
    public static void removeDuplicateLinesFromFile(final String fileName) throws IOException {
        File file = new File(fileName);

        List<String> originalLines = FileUtils.readLines(file, "UTF-8");

        Set<String> removedDuplicateLines = new HashSet<>();

        for (String line : originalLines) {
            if (!removedDuplicateLines.contains(line))
                removedDuplicateLines.add(line);
        }

        file.delete();

        File newFile = new File(fileName);

        for (String newLine : removedDuplicateLines) {
            FileUtils.writeStringToFile(newFile, newLine);
        }
    }

    /**
     * Method that removes the duplicate files from a directory
     *
     * The method is powerful enough to remove all files inside subdirectories as well
     * which are duplicates
     *
     * This is needed as the crawler might accidentally crawl and get a sheet/mp3 etc twice
     * (or rather different threads of the crawler acquire the same file)
     *
     * @param directoryName
     */
    public static void removeDuplicateFilesFromDirectory(final String directoryName) {

        final File dirFileHandle = new File(directoryName);

        // Gets all the files including the ones in the subdirectory
        final List<File> files =
                (List<File>) FileUtils.listFiles(dirFileHandle, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);

        // A handle to keep a track of distinct files
        final Set<String> distinctFiles = new HashSet<>();

        for (File file : files) {

            String fileName = file.getName();

            if (!distinctFiles.contains(fileName)) {
                distinctFiles.add(fileName);
            } else {
                file.delete();
            }
        }
    }

    /**
     * Gets the interval distance between any two notes
     *
     * TODO : Check for modulo 128 in case of overflow
     *
     * @param first
     * @param second
     * @return
     */
    public int intervalDistance(final Note first, final Note second) {
        return Math.abs(noteMap.getPositionGivenNote(first) - noteMap.getPositionGivenNote(second));
    }
}
