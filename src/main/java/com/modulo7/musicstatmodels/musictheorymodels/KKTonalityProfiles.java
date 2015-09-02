package com.modulo7.musicstatmodels.musictheorymodels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by asanyal on 9/1/15.
 *
 * The KK profile is metadata on which tonaility estimation (also called key
 * estimation is performed)
 *
 * Effectively a weighted interval
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


}
