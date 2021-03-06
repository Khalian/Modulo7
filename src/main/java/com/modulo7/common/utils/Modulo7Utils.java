package com.modulo7.common.utils;

import com.modulo7.common.exceptions.Modulo7InvalidArgsException;
import com.modulo7.common.exceptions.Modulo7NoSuchFileOrDirectoryException;
import com.modulo7.common.exceptions.Modulo7VectorSizeMismatchException;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;
import com.modulo7.musicstatmodels.representation.monophonic.VoiceInstant;
import com.modulo7.othersources.NoteAndIsChordDual;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by asanyal on 7/20/2015.
 *
 * Various Utilities for Modulo7
 */
public class Modulo7Utils {

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
    public static void removeDuplicateFilesFromDirectory(final String directoryName) throws Modulo7InvalidArgsException {

        final File dirFileHandle = new File(directoryName);

        // Gets all the files including the ones in the subdirectory
        final List<File> files =
                (List<File>) FileUtils.listFiles(dirFileHandle, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);

        // A handle to keep a track of distinct files
        final Set<String> distinctFiles = new HashSet<>();

        if (dirFileHandle == files) {
            throw new Modulo7InvalidArgsException("No such source file by the name:" + directoryName);
        }

        for (final File file : files) {

            String fileName = file.getName();

            if (!distinctFiles.contains(fileName)) {
                distinctFiles.add(fileName);
            } else {
                file.delete();
            }
        }
    }

    /**
     * List all files in a directory recursively and returns their canonical path as a list
     * @param directoryName
     */
    public static Set<String> listAllFiles(final String directoryName) throws Modulo7NoSuchFileOrDirectoryException {
        final File dirFileHandle = new File(directoryName);

        try {
            // Gets all the files including the ones in the subdirectory
            final List<File> files =
                    (List<File>) FileUtils.listFiles(dirFileHandle, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
            return files.stream().map(File::getAbsolutePath).collect(Collectors.toSet());
        } catch (IllegalArgumentException e) {
            throw new Modulo7NoSuchFileOrDirectoryException("No such directory" + directoryName);
        }
    }

    /**
     * Acquires the cosine similarity between two vectors for arbitrary numbers
     *
     *
     * @param vectorA
     * @param vectorB
     * @return
     */
    public static double cosineSimilarity(final List<Number> vectorA, final List<Number> vectorB)
            throws Modulo7VectorSizeMismatchException {

        if (vectorA.size() != vectorB.size()) {
            throw new Modulo7VectorSizeMismatchException(vectorA.size(), vectorB.size());
        }

        double dotProduct = 0.0;
        double normA = 0.0;
        double normB = 0.0;
        for (int i = 0; i < vectorA.size(); i++) {
            dotProduct += vectorA.get(i).doubleValue() * vectorB.get(i).doubleValue();
            normA += Math.pow(vectorA.get(i).doubleValue(), 2);
            normB += Math.pow(vectorB.get(i).doubleValue(), 2);
        }
        return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
    }

    /**
     * Gets the GCD for an arbitrary number of inputs
     *
     * @param input
     * @return
     */
    public static long gcd(long ... input) {
        long result = input[0];

        for (int i = 1; i < input.length; i++)
            result = Modulo7Utils.gcdTwoNums(result, input[i]);

        return result;
    }

    public static long gcdTwoNums(long a, long b) {
        while (b > 0) {
            long temp = b;
            b = a % b; // % is remainder
            a = temp;
        }
        return a;
    }

    /**
     * Gets the lcm for any two numbers
     * @param a
     * @param b
     * @return
     */
    public static long lcm(long a, long b) {
        return a * (b / gcd(a, b));
    }

    /**
     * LCM of an arbitrary list of numbers
     *
     * @param divisions
     * @return
     */
    public static long lcm(List<Integer> divisions) {
        long[] input = new long[divisions.size()];

        for (int i = 0; i <  divisions.size(); i++){
            input[i] = divisions.get(i);
        }

        long result = input[0];

        for (int i = 1; i < input.length; i++)
            result = lcm(result, input[i]);

        return ((int) result);
    }

    /**
     * A helper method to add an voice instant to a voice map
     *
     * @param voiceMap
     * @param instant
     * @param voiceNumber
     */
    public static synchronized void addVoiceInstantToVoiceMap(final Map<Integer, Voice> voiceMap,
                                                 final VoiceInstant instant, final int voiceNumber) {
        voiceMap.get(voiceNumber).addVoiceInstant(instant);
    }

    /**
     * A helper method to add an note to note dual map
     *  @param noteDualMap
     * @param note
     * @param voiceNumber
     */
    public static synchronized void addNoteDualToVoiceMap(final Map<Integer, List<NoteAndIsChordDual>> noteDualMap,
                                                 final NoteAndIsChordDual note, final int voiceNumber) {
        noteDualMap.get(voiceNumber).add(note);
    }

    /**
     * Assigns unknown if input is string, leaves it unchanged otherwise
     *
     * @param argument
     * @return
     */
    public static String stringAssign(final String argument) {
        if (argument == null) {
            return Modulo7Globals.UNKNOWNSTRING;
        }

        return argument;
    }

    /**
     * Simple helper to get audiveris jar location
     * @return
     */
    public static String getAudiverisJarLocation() {
        return Modulo7Globals.AUDIVERIS_JAR_LOCATION;
    }

    /**
     * Add a count to a map by a certain amount
     *
     * @param entity
     * @param entityMap
     * @param byAmount
     */
    public static void addToCount(final String entity, final Map<String, Integer> entityMap, final Integer byAmount) {
        if (entityMap.containsKey(entity)) {
            Integer currCount = entityMap.get(entity);
            entityMap.put(entity, currCount + byAmount);
        } else {
            entityMap.put(entity, byAmount);
        }
    }

    /**
     * Incremental add to the count
     *
     * @param entity
     * @param entityMap
     */
    public static void addToCount(final String entity, final Map<String, Integer> entityMap) {
        addToCount(entity, entityMap, 1);
    }

    /**
     * Get the sum over a map of n grams
     * @param ngramMap
     * @return
     */
    public static int sumOverNGramFreqs(final Map<String, Integer> ngramMap) {

        int total = 0;

        for (Map.Entry<String, Integer> entry : ngramMap.entrySet()) {
            total += entry.getValue();
        }

        return total;
    }

    /**
     * Get the sum over a map of n grams but only over the terms
     * @param ngramMap
     * @param terms
     * @return
     */
    public static int sumOverNGramFreqs(final Map<String, Integer> ngramMap, final Set<String> terms) {

        int total = 0;

        for (final String term : terms) {
            Integer val = ngramMap.get(term);
            if (val == null) {
                val = 0;
            }

            total += val;
        }

        return total;
    }

    /**
     * Gets the length of a particular file in bytes, its used in the research code
     *
     * @param fileName
     * @return
     * @throws FileNotFoundException
     */
    public static long getFileSize(final String fileName) throws FileNotFoundException {
        final File file = new File(fileName);
        if (file.exists()) {
           return file.length();
        } else {
            throw new FileNotFoundException("File" + fileName + "not found");
        }
    }

    /**
     * Build string from the list
     * @param args
     * @return
     */
    public static String buildStringOverList(final List<String> args) {
        StringBuilder builder = new StringBuilder();

        for (final String arg : args) {
            builder.append(arg);
            builder.append(" ");
        }

        return builder.toString();
    }

    /**
     * Custom implementation of the levenstein distance based on tokens instead of characters
     * This is required because the tokens are non trivial sized strings, not just characters
     * for an arbitrary voice (e.g a chord cMaj is a token and not a character)
     *
     * @param first
     * @param second
     * @return
     */
    public static int levensteinDistanceOnArbitraryTokens(final String[] first, final String[] second) {

        int [] costs = new int [second.length + 1];

        for (int j = 0; j < costs.length; j++)
            costs[j] = j;

        for (int i = 1; i <= first.length; i++) {
            costs[0] = i;
            int nw = i - 1;
            for (int j = 1; j <= second.length; j++) {
                int cj = Math.min(1 + Math.min(costs[j], costs[j - 1]), first[i - 1].equals(second[j - 1]) ? nw : nw + 1);
                nw = costs[j];
                costs[j] = cj;
            }
        }
        return costs[second.length];
    }

    /**
     * Same as the above levenstein distance but based on list<String> as args instead of string[]
     * @param first
     * @param second
     * @return
     */
    public static int levensteinDistanceOnArbitraryTokens(final List<String> first, final List<String> second) {
        final String[] firstElems = first.toArray(new String[first.size()]);
        final String[] secondElems = second.toArray(new String[second.size()]);

        return levensteinDistanceOnArbitraryTokens(firstElems, secondElems);
    }

    /**
     * Same as the above levenstein similarity but based on list<String> as args instead of string[]
     * Also includes a boost element which boosts a similar score and a penalty which penalizes a score
     *
     * @param first
     * @param second
     * @return
     */
    public static int levensteinSimilarity(final List<String> first, final List<String> second, final int boost, final int penalty) {
        final int val =  levensteinDistanceOnArbitraryTokens(first, second);

        if (val == 0)
            return boost;
        else
            return penalty;
    }
}
