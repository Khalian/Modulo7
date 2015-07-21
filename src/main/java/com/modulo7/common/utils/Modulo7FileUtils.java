package com.modulo7.common.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by asanyal on 7/20/2015.
 *
 * File Utilities for Modulo7
 */
public class Modulo7FileUtils {

    /**
     * Processes a text file and removes duplicates from the file
     *
     * This will be used to remove duplicate artists from crawled artists etc
     */
    public static void removeDuplicateLinesFromFile(String fileName) throws IOException {
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
}
