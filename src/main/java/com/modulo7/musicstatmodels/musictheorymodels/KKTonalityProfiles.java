package com.modulo7.musicstatmodels.musictheorymodels;

import com.modulo7.common.exceptions.Modulo7BadKeyException;
import com.modulo7.common.utils.FrequencyNoteMap;
import com.modulo7.common.utils.Modulo7Globals;
import com.modulo7.musicstatmodels.representation.metadata.KeySignature;
import com.modulo7.musicstatmodels.representation.metadata.ScaleType;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;
import com.modulo7.musicstatmodels.vectorspacemodels.vectorspacerepresentations.songvectors.PitchDurationHistogram;
import com.modulo7.musicstatmodels.vectorspacemodels.vectorspacerepresentations.songvectors.TonalDurationHistogram;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;

import java.util.*;

/**
 * Created by asanyal on 9/1/15.
 *
 * The KK profile is metadata on which tonality estimation (also called key
 * estimation is performed)
 *
 * Effectively a weighted interval density is compared with these profiles and the maximum
 * correlation result is chosen as the correct profile
 *
 * http://music.psych.cornell.edu/articles/tonality/TonalCognition.pdf
 */
public class KKTonalityProfiles {

    // C major chord profile
    private static final Double[] CMAJOR_CHORD_PROFILE_INTERNALARRAYREP =
            {6.35, 2.23, 3.48, 2.33, 4.38, 4.09, 2.52, 5.19, 2.39, 3.66, 2.29, 2.88};

    // C major chord profile List representation
    public static final List<Double> CMAJOR_CHORD_PROFILE =
            new ArrayList<>(Arrays.asList(CMAJOR_CHORD_PROFILE_INTERNALARRAYREP));

    // C minor chord profile
    private static final Double[] CMINOR_CHORD_PROFILE_INTERNALARRAYREP =
            {6.33, 2.68, 3.52, 5.38, 2.60, 3.53, 2.54, 4.75, 3.98, 2.69, 3.34, 3.17};

    // C minor chord profile List representation
    public static final List<Double> CMINOR_CHORD_PROFILE =
            new ArrayList<>(Arrays.asList(CMINOR_CHORD_PROFILE_INTERNALARRAYREP));

    // Major chord profiles
    public static final Map<String, List<Double>> MAJOR_CHORD_PROFILES = new HashMap<>();

    // Minor chord profiles
    public static final Map<String, List<Double>> MINOR_CHORD_PROFILES = new HashMap<>();

    // Initiatializing the profiles by rotation from base profile.
    static {
        for (int i = 0; i < Modulo7Globals.NOTE_NAMES.length; i++) {
            final String noteValue = Modulo7Globals.NOTE_NAMES[i];

            // Compute Major KK Profiles
            List<Double> copyOfCMajorProfile = new ArrayList<>(CMAJOR_CHORD_PROFILE);
            Collections.rotate(copyOfCMajorProfile, i - 3);
            MAJOR_CHORD_PROFILES.put(noteValue, copyOfCMajorProfile);

            // Compute Major KK Profiles
            List<Double> copyOfCMinorProfile = new ArrayList<>(CMINOR_CHORD_PROFILE);
            Collections.rotate(copyOfCMinorProfile, i - 3);
            MINOR_CHORD_PROFILES.put(noteValue, copyOfCMinorProfile);
        }
    }

    /**
     * Best profile match for tonal duration histogram to all the key profiles
     * precomputed using the KK probe tone method
     *
     * @param durations
     * @return
     */
    public static KeySignature estimateBestKeySignature(final PitchDurationHistogram durations) throws Modulo7BadKeyException {

        final List<Double> pithDurationsList = durations.getInternalRepresentation().getArrayRepresentation();
        Double[] tonalDurationsHistogramArray = pithDurationsList.toArray(new Double[pithDurationsList.size()]);
        double[] tonalDurationsArray = ArrayUtils.toPrimitive(tonalDurationsHistogramArray);

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

            final double correlation = new PearsonsCorrelation().correlation(tonalDurationsArray, targetProfile);

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

            final double correlation = new PearsonsCorrelation().correlation(tonalDurationsArray, targetProfile);

            if (correlation > bestCorrelation) {
                bestCorrelation = correlation;
                bestKey = key;
                bestScaleType = ScaleType.MINOR;
            }
        }

        return new KeySignature(bestKey, bestScaleType);
    }

    /**
     * In certain cases (for example when only the number of flats or sharps are known)
     * Modulo7 faces a choice between two a major and a minor key. This method resolves
     * that choice
     *
     * @param thisOne
     * @param thatOne
     * @param song
     * @return true if thisOne is a better profile than that one
     */
    public static boolean estimateBetterKeySignature(final KeySignature thisOne, final KeySignature thatOne,
           final Song song) {

        TonalDurationHistogram durationHistogram = new TonalDurationHistogram();
        durationHistogram.computeVectorRepresentation(song);

        final List<Number> tonalDurationsList = durationHistogram.getInternalRepresentation().getArrayRepresentation();
        Double[] tonalDurationsnHistogramArray = new Double[tonalDurationsList.size()];

        for (int i = 0; i < tonalDurationsList.size(); i++) {
            tonalDurationsnHistogramArray[i] = tonalDurationsList.get(i).doubleValue();
        }

        double[] tonalDurationsArray = ArrayUtils.toPrimitive(tonalDurationsnHistogramArray);
        assert (tonalDurationsArray.length == 12);

        final double thisScore, thatScore;

        if (thisOne.getScale().equals(ScaleType.MAJOR)) {
            List<Double> thisProfileList = KKTonalityProfiles.MAJOR_CHORD_PROFILES.get(thisOne.getKey());
            double[] thisProfileArray = ArrayUtils.toPrimitive(thisProfileList.toArray(new Double[thisProfileList.size()]));
            thisScore = new PearsonsCorrelation().correlation(thisProfileArray, tonalDurationsArray);
        } else {
            List<Double> thisProfileList = KKTonalityProfiles.MINOR_CHORD_PROFILES.get(thisOne.getKey());
            double[] thisProfileArray = ArrayUtils.toPrimitive(thisProfileList.toArray(new Double[thisProfileList.size()]));
            thisScore = new PearsonsCorrelation().correlation(thisProfileArray, tonalDurationsArray);
        }

        if (thatOne.getScale().equals(ScaleType.MAJOR)) {
            List<Double> thisProfileList = KKTonalityProfiles.MAJOR_CHORD_PROFILES.get(thatOne.getKey());
            double[] thisProfileArray = ArrayUtils.toPrimitive(thisProfileList.toArray(new Double[thisProfileList.size()]));
            thatScore = new PearsonsCorrelation().correlation(thisProfileArray, tonalDurationsArray);
        } else {
            List<Double> thisProfileList = KKTonalityProfiles.MINOR_CHORD_PROFILES.get(thatOne.getKey());
            double[] thisProfileArray = ArrayUtils.toPrimitive(thisProfileList.toArray(new Double[thisProfileList.size()]));
            thatScore = new PearsonsCorrelation().correlation(thisProfileArray, tonalDurationsArray);
        }

        return thisScore > thatScore;
    }
}
