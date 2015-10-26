package com.modulo7.musicstatmodels.statistics;

import com.modulo7.common.exceptions.Modulo7BadNoteException;
import com.modulo7.common.exceptions.Modulo7InvalidVoiceInstantSizeException;
import com.modulo7.common.interfaces.AbstractStatistic;
import com.modulo7.musicstatmodels.preprocessing.VoiceToMelodyConversion;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.Comparator;

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
            final Voice melodicPreprocessVoice;
            try {
                melodicPreprocessVoice = VoiceToMelodyConversion.melodyConversion(voice);
                String voiceStringRep = melodicPreprocessVoice.getDocumentRepresentation();

                String[] voiceComponents = voiceStringRep.split(" ");

                String[] repeatingMelody = longestRepeatingString(voiceStringRep);

                double fractionOfRepeatation = (double) repeatingMelody.length / voiceComponents.length;

                longestFactor = Math.max(longestFactor, fractionOfRepeatation);

            } catch (Modulo7InvalidVoiceInstantSizeException | Modulo7BadNoteException e) {
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
    private String[] longestCommonPrefix(final String[] s, final String[] t) {
        int n = Math.min(s.length, t.length);
        for (int i = 0; i < n; i++) {
            if (!s[i].equals(t[i]))
                return subcomponentOfString(s, 0, i);
        }
        return subcomponentOfString(s, 0, n);
    }

    /**
     * An analogue to substring but over chunked strings instead of string itself
     *
     * @param baseComponents
     * @param firstIndex
     * @param secondIndex
     * @return
     */
    private String[] subcomponentOfString(final String[] baseComponents, final int firstIndex, final int secondIndex) {
        String[] subcomponents = new String[secondIndex - firstIndex];

        int j = 0;

        for (int i = firstIndex; i < secondIndex; i++) {
            subcomponents[j] = baseComponents[i];
            j++;
        }

        return subcomponents;
    }

    /**
     * Returns the longest repeated string
     * @param s
     * @return
     */
    public String[] longestRepeatingString(final String s) {

        // form the N suffixes

        String[] components = s.split(" ");
        int N  = components.length;

        String[][] suffixes = new String[N][N];
        for (int i = 0; i < N; i++) {
            suffixes[i] = subcomponentOfString(components, i, N);
        }

        // sort them
        Arrays.sort(suffixes, new ComponentComparator());

        // find longest repeated substring by comparing adjacent sorted suffixes
        String[] lrs = new String[0];
        for (int i = 0; i < N - 1; i++) {
            String[] x = longestCommonPrefix(suffixes[i], suffixes[i + 1]);
            if (x.length > lrs.length)
                lrs = x;
        }
        return lrs;
    }
}

class ComponentComparator implements Comparator<String[]> {

    @Override
    public int compare(final String[] firstString, final String[] secondString) {

        String first = totalStringRep(firstString);
        String second = totalStringRep(secondString);

        return first.compareTo(second);
    }

    private String totalStringRep(final String[] components) {
        StringBuilder builder = new StringBuilder();

        for (final String component: components) {
            builder.append(component);
        }

        return builder.toString();
    }
}
