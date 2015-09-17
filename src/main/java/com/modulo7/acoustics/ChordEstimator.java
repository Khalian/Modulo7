package com.modulo7.acoustics;

import com.modulo7.common.utils.FrequencyNoteMap;
import com.modulo7.common.exceptions.Modulo7BadChordException;
import com.modulo7.musicstatmodels.musictheorymodels.IntervalEnum;
import com.modulo7.musicstatmodels.representation.buildingblocks.ChordQuality;
import com.modulo7.musicstatmodels.representation.buildingblocks.Note;

import java.util.HashSet;

/**
 * Created by asanyal on 9/5/15.
 * <p/>
 * A chord estimation algorithm from chroma vector output by echo nest
 * Once we have chromagram from echo nest we can use this template based
 * chord estimation algorithm to estimate chords including tough ones like
 *
 * Ideas taken from but reimplemented : https://github.com/adamstark/Chord-Detector-and-Chromagram
 */
public class ChordEstimator {

    /**
     * The root note of the detected chord
     */
    private Note rootNote;

    /**
     * The quality of the detected chord (Major, Minor, etc)
     */
    private ChordQuality quality = ChordQuality.UNKNOWN;

    /**
     * Any other intervals that describe the chord, e.g. 7th
     * This methodoloty is useful for
     */
    private IntervalEnum intervals;

    // Bias parameter
    private double bias = 1.06;

    // A copy of the chromagram vector
    private double[] chromagram;

    // Scores for each chord profile computed for the given chromagram
    private double chord[] = new double[108];

    // An array reprentation of the chord profiles computed by the algorithm
    private static double[][] chordProfiles = new double[108][12];

    // Frequency note map instance
    private static final FrequencyNoteMap noteMap = FrequencyNoteMap.getInstance();

    // The chord profiles are a global descriptor, make it static
    static {
        makeChordProfiles();
    }

    private int chordIndex;

    /**
     * Basic constructor
     * @param chromagram
     */
    public ChordEstimator(double[] chromagram) {

        this.chromagram = chromagram;
        classifyChromagram();

        assert (rootNote != null);
        assert (quality != null);
        assert (intervals != null);
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

        chordIndex = minimumIndex(chord, 108);

        // major
        if (chordIndex < 12) {
            rootNote = noteMap.getBasicNoteGivenPosition(chordIndex);
            quality = ChordQuality.MAJOR;
            intervals = IntervalEnum.PERFECT_UNISON;
        }

        // minor
        if ((chordIndex >= 12) && (chordIndex < 24)) {
            rootNote = noteMap.getBasicNoteGivenPosition(chordIndex - 12);
            quality = ChordQuality.MINOR;
            intervals = IntervalEnum.PERFECT_UNISON;
        }

        // diminished 5th
        if ((chordIndex >= 24) && (chordIndex < 36)) {
            rootNote = noteMap.getBasicNoteGivenPosition(chordIndex - 24);
            quality = ChordQuality.DIMINISHED5th;
            intervals = IntervalEnum.PERFECT_UNISON;
        }

        // augmented 5th
        if ((chordIndex >= 36) && (chordIndex < 48)) {
            rootNote = noteMap.getBasicNoteGivenPosition(chordIndex - 36);
            quality = ChordQuality.AUGMENTED5th;
            intervals = IntervalEnum.PERFECT_UNISON;
        }

        // sus2
        if ((chordIndex >= 48) && (chordIndex < 60)) {
            rootNote = noteMap.getBasicNoteGivenPosition(chordIndex - 48);
            quality = ChordQuality.SUSPENDED;
            intervals = IntervalEnum.MAJOR_SECOND;
        }

        // sus4
        if ((chordIndex >= 60) && (chordIndex < 72)) {
            rootNote = noteMap.getBasicNoteGivenPosition(chordIndex - 60);
            quality = ChordQuality.SUSPENDED;
            intervals = IntervalEnum.MAJOR_THIRD;
        }

        // major 7th
        if ((chordIndex >= 72) && (chordIndex < 84)) {
            rootNote = noteMap.getBasicNoteGivenPosition(chordIndex - 72);
            quality = ChordQuality.MAJOR;
            intervals = IntervalEnum.MAJOR_SEVENTH;
        }

        // minor 7th
        if ((chordIndex >= 84) && (chordIndex < 96)) {
            rootNote = noteMap.getBasicNoteGivenPosition(chordIndex - 84);
            quality = ChordQuality.MINOR;
            intervals = IntervalEnum.MINOR_SEVENTH;
        }

        // dominant 7th
        if ((chordIndex >= 96) && (chordIndex < 108)) {
            rootNote = noteMap.getBasicNoteGivenPosition(chordIndex - 96);
            quality = ChordQuality.DOMINANT;
            intervals = IntervalEnum.MINOR_SEVENTH;
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

    /**
     * Estimate the notes of a chord given its chord quality and root note of the chord
     *
     * @param rootNote
     * @param quality
     * @return
     */
    public static HashSet<Note> estimateChordGivenQualityAndRootNote(final Note rootNote, final ChordQuality quality, final IntervalEnum additionalInterval)
            throws Modulo7BadChordException {

        final int rootPosition = noteMap.getPositionGivenBasicNote(rootNote);

        if (quality.equals(ChordQuality.MAJOR)) {
            final int thirdPosition = rootPosition + IntervalEnum.MAJOR_THIRD.getIntervalQuantity();
            final int fifthPosition = rootPosition + IntervalEnum.PERFECT_FIFTH.getIntervalQuantity();

            final Note thirdNote = noteMap.getBasicNoteGivenPosition(thirdPosition);
            final Note fifthNote = noteMap.getBasicNoteGivenPosition(fifthPosition);
            final Note additionalNote = getAdditionalNote(rootPosition, additionalInterval);

            HashSet<Note> newSet = new HashSet<>();
            assert (rootNote != null); assert (thirdNote != null); assert (fifthNote != null);

            newSet.add(rootNote); newSet.add(thirdNote); newSet.add(fifthNote);

            if (additionalNote != null)
                newSet.add(additionalNote);

            return newSet;
        } else if (quality.equals(ChordQuality.MINOR)) {
            final int thirdPosition = rootPosition + IntervalEnum.MINOR_THIRD.getIntervalQuantity();
            final int fifthPosition = rootPosition + IntervalEnum.PERFECT_FIFTH.getIntervalQuantity();

            final Note thirdNote = noteMap.getBasicNoteGivenPosition(thirdPosition);
            final Note fifthNote = noteMap.getBasicNoteGivenPosition(fifthPosition);
            final Note additionalNote = getAdditionalNote(rootPosition, additionalInterval);

            assert (rootNote != null); assert (thirdNote != null); assert (fifthNote != null);

            HashSet<Note> newSet = new HashSet<>();
            newSet.add(rootNote); newSet.add(thirdNote); newSet.add(fifthNote);

            if (additionalNote != null)
                newSet.add(additionalNote);

            return newSet;
        } else if (quality.equals(ChordQuality.DIMINISHED5th)) {
            final int thirdPosition = rootPosition + IntervalEnum.MINOR_THIRD.getIntervalQuantity();
            final int fifthPosition = rootPosition + IntervalEnum.DIMINISHED_FIFTH.getIntervalQuantity();

            final Note thirdNote = noteMap.getBasicNoteGivenPosition(thirdPosition);
            final Note fifthNote = noteMap.getBasicNoteGivenPosition(fifthPosition);

            assert (rootNote != null); assert (thirdNote != null); assert (fifthNote != null);

            HashSet<Note> newSet = new HashSet<>();
            newSet.add(rootNote); newSet.add(thirdNote); newSet.add(fifthNote);

            return newSet;
        } else if (quality.equals(ChordQuality.AUGMENTED5th)) {
            final int thirdPosition = rootPosition + IntervalEnum.MINOR_THIRD.getIntervalQuantity();
            final int fifthPosition = rootPosition + IntervalEnum.AUGMENTED_FIFTH.getIntervalQuantity();

            final Note thirdNote = noteMap.getBasicNoteGivenPosition(thirdPosition);
            final Note fifthNote = noteMap.getBasicNoteGivenPosition(fifthPosition);

            assert (rootNote != null); assert (thirdNote != null); assert (fifthNote != null);

            HashSet<Note> newSet = new HashSet<>();
            newSet.add(rootNote); newSet.add(thirdNote); newSet.add(fifthNote);

            return newSet;
        } else if (quality.equals(ChordQuality.SUSPENDED)) {
            final int fifthPosition = rootPosition + IntervalEnum.PERFECT_FIFTH.getIntervalQuantity();

            final Note fifthNote = noteMap.getBasicNoteGivenPosition(fifthPosition);
            final Note suspendedNote = getAdditionalNote(rootPosition, additionalInterval);

            assert (rootNote != null); assert (suspendedNote != null); assert (fifthNote != null);

            HashSet<Note> newSet = new HashSet<>();
            newSet.add(rootNote); newSet.add(suspendedNote); newSet.add(fifthNote);

            return newSet;
        } else if (quality.equals(ChordQuality.DOMINANT)) {
            final int thirdPosition = rootPosition + IntervalEnum.MAJOR_THIRD.getIntervalQuantity();
            final int fifthPosition = rootPosition + IntervalEnum.PERFECT_FIFTH.getIntervalQuantity();

            final Note thirdNote = noteMap.getBasicNoteGivenPosition(thirdPosition);
            final Note fifthNote = noteMap.getBasicNoteGivenPosition(fifthPosition);
            final Note additionalNote = getAdditionalNote(rootPosition, additionalInterval);

            assert (rootNote != null); assert (thirdNote != null); assert (additionalNote != null);

            HashSet<Note> newSet = new HashSet<>();
            newSet.add(rootNote); newSet.add(thirdNote); newSet.add(fifthNote);

            return newSet;
        } else {
            throw new Modulo7BadChordException("No chord can be formed from rootNote :" + rootNote.getNoteValue() + "and quality:" + quality.getStringRepresentation());
        }
    }

    /**
     * Gets the additional interval note given the root note
     *
     * @param rootPosition
     * @param additionalInterval
     * @return
     */
    public static Note getAdditionalNote(final int rootPosition, final IntervalEnum additionalInterval) {
        if (!additionalInterval.equals(IntervalEnum.PERFECT_UNISON)) {
            final int additionalPosition = rootPosition + additionalInterval.getIntervalQuantity();
            return noteMap.getBasicNoteGivenPosition(additionalPosition);
        } else {
            return null;
        }
    }


    /**
     * Getter for the root note of the chord
     * @return
     */
    public Note getRootNote() {
        return rootNote;
    }

    /**
     * Gets the chordquality associated with the chord
     * @return
     */
    public ChordQuality getQuality() {
        return quality;
    }

    /**
     * Gets the additional interval component associated with
     * the interval structure
     * @return
     */
    public IntervalEnum getIntervals() {
        return intervals;
    }
}
