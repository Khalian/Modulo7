package com.modulo7.musicstatmodels.musictheorymodels;

import com.modulo7.common.utils.FrequencyNoteMap;
import com.modulo7.common.utils.Modulo7Globals;

import java.util.*;

/**
 * Created by asanyal on 9/1/15.
 *
 * The KK profile is metadata on which tonaility estimation (also called key
 * estimation is performed)
 *
 * Effectively a weighted interval density is compared with these profiles and the maximum
 * correlation result is chosen as the correct profile
 *
 * http://music.psych.cornell.edu/articles/tonality/TonalCognition.pdf
 */
public class KKTonalityProfiles {

    // A frequency note map representation for production of chord profiles
    private static final FrequencyNoteMap noteMap = FrequencyNoteMap.getInstance();

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
            MAJOR_CHORD_PROFILES.put(noteValue, copyOfCMinorProfile);
        }
    }
}
