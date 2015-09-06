package com.modulo7.acoustics;

import com.modulo7.musicstatmodels.representation.ChordQuality;

/**
 * Created by asanyal on 9/5/15.
 * <p/>
 * A chord estimation algorithm from chroma vector output by echo nest
 * Once we have chromagram from echo nest
 *
 */
public class ChordEstimator {

    /**
     * The root note of the detected chord
     */
    private int rootNote;

    /**
     * The quality of the detected chord (Major, Minor, etc)
     */
    private ChordQuality quality = ChordQuality.UNKNOWN;

    /**
     * Any other intervals that describe the chord, e.g. 7th
     */
    private int intervals;

    // Bias parameter
    private double bias = 1.06;

    // A copy of the chromagram vector
    private double[] chromagram;

    // Scores for each chord profile computed for the given chromagram
    private double chord[] = new double[108];

    // An array reprentation of the chord profiles computed by the algorithm
    private static double[][] chordProfiles = new double[108][12];

    // The chord profiles are a global descriptor, make it static
    static {
        makeChordProfiles();
    }

    /**
     * Basic constructor
     * @param chromagram
     */
    public ChordEstimator(double[] chromagram) {

        this.chromagram = chromagram;
        classifyChromagram();
    }

    private static void makeChordProfiles() {
        int i, t, j = 0;
        int root, third, fifth, seventh;

        double v1 = 1;
        double v2 = 1;
        double v3 = 1;

        // set profiles matrix to all zeros
        for (j = 0; j < 108; j++) {
            for (t = 0; t < 12; t++) {
                chordProfiles[j][t] = 0;
            }
        }

        // reset j to zero to begin creating profiles
        j = 0;

        // major chords
        for (i = 0; i < 12; i++) {
            root = i % 12;
            third = (i + 4) % 12;
            fifth = (i + 7) % 12;

            chordProfiles[j][root] = v1;
            chordProfiles[j][third] = v2;
            chordProfiles[j][fifth] = v3;

            j++;
        }

        // minor chords
        for (i = 0; i < 12; i++) {
            root = i % 12;
            third = (i + 3) % 12;
            fifth = (i + 7) % 12;

            chordProfiles[j][root] = v1;
            chordProfiles[j][third] = v2;
            chordProfiles[j][fifth] = v3;

            j++;
        }

        // diminished chords
        for (i = 0; i < 12; i++) {
            root = i % 12;
            third = (i + 3) % 12;
            fifth = (i + 6) % 12;

            chordProfiles[j][root] = v1;
            chordProfiles[j][third] = v2;
            chordProfiles[j][fifth] = v3;

            j++;
        }

        // augmented chords
        for (i = 0; i < 12; i++) {
            root = i % 12;
            third = (i + 4) % 12;
            fifth = (i + 8) % 12;

            chordProfiles[j][root] = v1;
            chordProfiles[j][third] = v2;
            chordProfiles[j][fifth] = v3;

            j++;
        }

        // sus2 chords
        for (i = 0; i < 12; i++) {
            root = i % 12;
            third = (i + 2) % 12;
            fifth = (i + 7) % 12;

            chordProfiles[j][root] = v1;
            chordProfiles[j][third] = v2;
            chordProfiles[j][fifth] = v3;

            j++;
        }

        // sus4 chords
        for (i = 0; i < 12; i++) {
            root = i % 12;
            third = (i + 5) % 12;
            fifth = (i + 7) % 12;

            chordProfiles[j][root] = v1;
            chordProfiles[j][third] = v2;
            chordProfiles[j][fifth] = v3;

            j++;
        }

        // major 7th chords
        for (i = 0; i < 12; i++) {
            root = i % 12;
            third = (i + 4) % 12;
            fifth = (i + 7) % 12;
            seventh = (i + 11) % 12;

            chordProfiles[j][root] = v1;
            chordProfiles[j][third] = v2;
            chordProfiles[j][fifth] = v3;
            chordProfiles[j][seventh] = v3;

            j++;
        }

        // minor 7th chords
        for (i = 0; i < 12; i++) {
            root = i % 12;
            third = (i + 3) % 12;
            fifth = (i + 7) % 12;
            seventh = (i + 10) % 12;

            chordProfiles[j][root] = v1;
            chordProfiles[j][third] = v2;
            chordProfiles[j][fifth] = v3;
            chordProfiles[j][seventh] = v3;

            j++;
        }

        // dominant 7th chords
        for (i = 0; i < 12; i++) {
            root = i % 12;
            third = (i + 4) % 12;
            fifth = (i + 7) % 12;
            seventh = (i + 10) % 12;

            chordProfiles[j][root] = v1;
            chordProfiles[j][third] = v2;
            chordProfiles[j][fifth] = v3;
            chordProfiles[j][seventh] = v3;

            j++;
        }
    }

    private void classifyChromagram() {
        int i;
        int j;
        int fifth;
        int chordindex;

        // remove some of the 5th note energy from chromagram
        for (i = 0; i < 12; i++) {
            fifth = (i + 7) % 12;
            chromagram[fifth] = chromagram[fifth] - (0.1 * chromagram[i]);

            if (chromagram[fifth] < 0) {
                chromagram[fifth] = 0;
            }

        }

        // major chords
        for (j = 0; j < 12; j++) {
            chord[j] = calculateChordScore(chromagram, chordProfiles[j], bias, 3);
        }

        // minor chords
        for (j = 12; j < 24; j++) {
            chord[j] = calculateChordScore(chromagram, chordProfiles[j], bias, 3);
        }

        // diminished 5th chords
        for (j = 24; j < 36; j++) {
            chord[j] = calculateChordScore(chromagram, chordProfiles[j], bias, 3);
        }

        // augmented 5th chords
        for (j = 36; j < 48; j++) {
            chord[j] = calculateChordScore(chromagram, chordProfiles[j], bias, 3);
        }

        // sus2 chords
        for (j = 48; j < 60; j++) {
            chord[j] = calculateChordScore(chromagram, chordProfiles[j], 1, 3);
        }

        // sus4 chords
        for (j = 60; j < 72; j++) {
            chord[j] = calculateChordScore(chromagram, chordProfiles[j], 1, 3);
        }

        // major 7th chords
        for (j = 72; j < 84; j++) {
            chord[j] = calculateChordScore(chromagram, chordProfiles[j], 1, 4);
        }

        // minor 7th chords
        for (j = 84; j < 96; j++) {
            chord[j] = calculateChordScore(chromagram, chordProfiles[j], bias, 4);
        }

        // dominant 7th chords
        for (j = 96; j < 108; j++) {
            chord[j] = calculateChordScore(chromagram, chordProfiles[j], bias, 4);
        }

        chordindex = minimumIndex(chord, 108);

        // major
        if (chordindex < 12) {
            rootNote = chordindex;
            quality = ChordQuality.MAJOR;
            intervals = 0;
        }

        // minor
        if ((chordindex >= 12) && (chordindex < 24)) {
            rootNote = chordindex - 12;
            quality = ChordQuality.MINOR;
            intervals = 0;
        }

        // diminished 5th
        if ((chordindex >= 24) && (chordindex < 36)) {
            rootNote = chordindex - 24;
            quality = ChordQuality.DIMINISHED5th;
            intervals = 0;
        }

        // augmented 5th
        if ((chordindex >= 36) && (chordindex < 48)) {
            rootNote = chordindex - 36;
            quality = ChordQuality.AUGMENTED5th;
            intervals = 0;
        }

        // sus2
        if ((chordindex >= 48) && (chordindex < 60)) {
            rootNote = chordindex - 48;
            quality = ChordQuality.SUSPENDED;
            intervals = 2;
        }

        // sus4
        if ((chordindex >= 60) && (chordindex < 72)) {
            rootNote = chordindex - 60;
            quality = ChordQuality.SUSPENDED;
            intervals = 4;
        }

        // major 7th
        if ((chordindex >= 72) && (chordindex < 84)) {
            rootNote = chordindex - 72;
            quality = ChordQuality.MAJOR;
            intervals = 7;
        }

        // minor 7th
        if ((chordindex >= 84) && (chordindex < 96)) {
            rootNote = chordindex - 84;
            quality = ChordQuality.MINOR;
            intervals = 7;
        }

        // dominant 7th
        if ((chordindex >= 96) && (chordindex < 108)) {
            rootNote = chordindex - 96;
            quality = ChordQuality.DOMINANT;
            intervals = 7;
        }
    }

    /**
     * Helper method to calculate the chord score given profile and chrome
     *
     * @param chroma
     * @param chordProfile
     * @param biasToUse
     * @param N
     * @return
     */
    private double calculateChordScore(final double[] chroma, final double[] chordProfile, final double biasToUse, final double N) {
        double sum = 0;
        double delta;

        for (int i = 0; i < 12; i++) {
            sum = sum + ((1 - chordProfile[i]) * (chroma[i] * chroma[i]));
        }

        delta = Math.sqrt(sum) / ((12 - N) * biasToUse);

        return delta;
    }

    private int minimumIndex(final double[] array, final int arrayLength) {
        double minValue = 100000;
        int minIndex = 0;
        int i;

        for (i = 0; i < arrayLength; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
                minIndex = i;
            }
        }

        return minIndex;
    }


    public int getRootNote() {
        return rootNote;
    }

    public ChordQuality getQuality() {
        return quality;
    }

    public int getIntervals() {
        return intervals;
    }
}
