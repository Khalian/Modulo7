package com.modulo7.common.utils;

import com.modulo7.common.exceptions.Modulo7BadKeyException;
import com.modulo7.common.exceptions.Modulo7VectorSizeMismatchException;
import com.modulo7.musicstatmodels.musictheorymodels.KKTonalityProfiles;
import com.modulo7.musicstatmodels.representation.KeySignature;
import com.modulo7.musicstatmodels.representation.ScaleType;
import com.modulo7.musicstatmodels.representation.Voice;
import com.modulo7.musicstatmodels.representation.VoiceInstant;
import com.modulo7.othersources.NoteAndIsChordDual;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
     * List all files in a directory recursively and returns their canonical path as a list
     * @param directoryName
     */
    public static Set<String> listAllFiles(final String directoryName) {
        final File dirFileHandle = new File(directoryName);

        // Gets all the files including the ones in the subdirectory
        final List<File> files =
                (List<File>) FileUtils.listFiles(dirFileHandle, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);

        Set<String> newReturnSet = new HashSet<>();

        for (File file : files) {
            newReturnSet.add(file.getAbsolutePath());
        }

        return newReturnSet;
    }

    /**
     * Acquires the cosine similarity between two vectors
     *
     * @param vectorA
     * @param vectorB
     * @return
     */
    public static double cosineSimilarity(final List<Integer> vectorA, final List<Integer> vectorB)
            throws Modulo7VectorSizeMismatchException {

        if (vectorA.size() != vectorB.size()) {
            throw new Modulo7VectorSizeMismatchException(vectorA.size(), vectorB.size());
        }

        double dotProduct = 0.0;
        double normA = 0.0;
        double normB = 0.0;
        for (int i = 0; i < vectorA.size(); i++) {
            dotProduct += vectorA.get(i) * vectorB.get(i);
            normA += Math.pow(vectorA.get(i), 2);
            normB += Math.pow(vectorB.get(i), 2);
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
            result = Modulo7Utils.gcd(result, input[i]);

        return result;
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
     * Estimate key signature based on weighted tonality histogram and its correlation to the KK best
     * tonality profile
     *
     * @param weightedTonalHistogram
     * @return
     */
    public static KeySignature estimateKeySignatureOnKKProfile(final double[] weightedTonalHistogram) throws Modulo7BadKeyException {

        assert (weightedTonalHistogram.length == 12);

        double bestCorrelation = -Double.MAX_VALUE;
        String bestKey = "C";
        ScaleType bestScaleType = ScaleType.MINOR;

        // Iterate over the major chord profiles and choose the best one of the lot
        for (Map.Entry<String, List<Double>> entry : KKTonalityProfiles.MAJOR_CHORD_PROFILES.entrySet()) {

            final String key = entry.getKey();
            final List<Double> profile = entry.getValue();

            double[] targetProfile = new double[profile.size()];
            for (int i = 0; i < targetProfile.length; i++) {
                targetProfile[i] = profile.get(i);
            }

            final double correlation = new PearsonsCorrelation().correlation(weightedTonalHistogram, targetProfile);

            if (correlation > bestCorrelation) {
                bestCorrelation = correlation;
                bestKey = key;
                bestScaleType = ScaleType.MAJOR;
            }
        }

        // Iterates over the minor chord profiles and choose the best one of the lot
        for (Map.Entry<String, List<Double>> entry : KKTonalityProfiles.MINOR_CHORD_PROFILES.entrySet()) {

            final String key = entry.getKey();
            final List<Double> profile = entry.getValue();

            double[] targetProfile = new double[profile.size()];
            for (int i = 0; i < targetProfile.length; i++) {
                targetProfile[i] = profile.get(i);
            }

            final double correlation = new PearsonsCorrelation().correlation(weightedTonalHistogram, targetProfile);

            if (correlation > bestCorrelation) {
                bestCorrelation = correlation;
                bestKey = key;
                bestScaleType = ScaleType.MINOR;
            }
        }

        return new KeySignature(bestKey, bestScaleType);
    }

    /**
     * A helper method to add an voice instant to a voice map
     *
     * @param voiceMap
     * @param instant
     * @param voiceNumber
     */
    public static void addVoiceInstantToVoiceMap(final Map<Integer, Voice> voiceMap,
                                                 final VoiceInstant instant, final int voiceNumber) {
        voiceMap.get(voiceNumber).addVoiceInstant(instant);
    }

    /**
     * A helper method to add an note to note dual map
     *  @param noteDualMap
     * @param note
     * @param voiceNumber
     */
    public static void addNoteDualToVoiceMap(final Map<Integer, List<NoteAndIsChordDual>> noteDualMap,
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
}
