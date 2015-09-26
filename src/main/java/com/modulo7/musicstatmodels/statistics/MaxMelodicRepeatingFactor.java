package com.modulo7.musicstatmodels.statistics;

import com.modulo7.common.exceptions.Modulo7InvalidVoiceInstantSizeException;
import com.modulo7.common.interfaces.AbstractStatistic;
import com.modulo7.musicstatmodels.preprocessing.VoiceToMelodyConversion;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;
import org.apache.log4j.Logger;

import java.util.Arrays;

/**
 * Created by asanyal on 9/23/15.
 *
 * Inside a melody, check for the longest repeating melody for all voices
 * and then returns the largest fraction
 *
 * The melodic fraction is defined as longest repeating melody / length of melody
 *
 * Helper code taken from : http://introcs.cs.princeton.edu/java/42sort/LRS.java.html
 * Thanks !!
 *
 * NOTE : This statistic implicitly applied a generic voice to melody preprocessing technique
 *
 * TODO: Fix it so that sharps dont cause problems
 */
public class MaxMelodicRepeatingFactor implements AbstractStatistic<Double> {

    // Logger for max melodic repeating factor
    final Logger logger = Logger.getLogger(MaxMelodicRepeatingFactor.class);

    /**
     * This particular statistic gives the max repeating factor for a melody
     * @param song
     * @return
     */
    @Override
    public Double getStatistic(final Song song) {
        double longestFactor = -Double.MAX_VALUE;

        for (final Voice voice : song.getVoices()) {
            final Voice melodicProprocessVoice;
            try {
                melodicProprocessVoice = VoiceToMelodyConversion.melodyConversion(voice);
                String voiceStringRep = melodicProprocessVoice.getDocumentRepresentation();
                String repeatingMelody = longestRepeatingString(voiceStringRep);

                double fractionOfRepeatation = (double) repeatingMelody.length() / voiceStringRep.length();

                longestFactor = Math.max(longestFactor, fractionOfRepeatation);

            } catch (Modulo7InvalidVoiceInstantSizeException e) {
                logger.error(e.getMessage());
            }
        }

        return longestFactor;
    }

    /**
     * Get the longest common prefix between two strings
     * @param s
     * @param t
     * @return
     */
    private String longestCommonPrefix(final String s, final String t) {
        int n = Math.min(s.length(), t.length());
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != t.charAt(i))
                return s.substring(0, i);
        }
        return s.substring(0, n);
    }

    /**
     * Returns the longest repeated string
     * @param s
     * @return
     */
    public String longestRepeatingString(final String s) {

        // form the N suffixes
        int N  = s.length();
        String[] suffixes = new String[N];
        for (int i = 0; i < N; i++) {
            suffixes[i] = s.substring(i, N);
        }

        // sort them
        Arrays.sort(suffixes);

        // find longest repeated substring by comparing adjacent sorted suffixes
        String lrs = "";
        for (int i = 0; i < N - 1; i++) {
            String x = longestCommonPrefix(suffixes[i], suffixes[i + 1]);
            if (x.length() > lrs.length())
                lrs = x;
        }
        return lrs;
    }
}
