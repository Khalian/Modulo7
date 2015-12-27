package com.modulo7.common.interfaces.choices;

import com.modulo7.musicstatmodels.criteria.*;
import com.modulo7.musicstatmodels.statistics.HappinessIndex;
import com.modulo7.musicstatmodels.statistics.MaxMelodicRepeatingFactor;
import com.modulo7.musicstatmodels.statistics.PowerIndex;
import com.modulo7.musicstatmodels.statistics.SadnessIndex;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by asanyal on 9/23/15.
 *
 * A listing of all the criteria implemented in modulo7
 */
public enum CriteriaChoice {
    KEY_SIGNATURE_EQUALITY_CRITERIA("keysignatureequalto"),
    SCALE_EQUALITY_CRITERIA("scaleequalto"),
    POLYPHONIC_CRITERIA("polyphonic"),
    TIME_SIGNATURE_EQUALITY_CRITERIA("timesignatureequalto"),
    POSITIVE_LYRICAL_INTENT_CRITERIA("positivelyrics"),
    STAB_CLASSIFICATION_CRITERIA("stabvoiceclassification");

    // A set of all criteria choices
    private static final Set<String> CRITERIA_CHOICES = new HashSet<>();

    // Regular expression for criteria, so one of the choices are picked u[
    public static final String REGEXP_REP;

    static {
        CriteriaChoice[] choices = CriteriaChoice.class.getEnumConstants();

        for (CriteriaChoice choice : choices) {
            CRITERIA_CHOICES.add(choice.getCriteriaChoice());
        }

        StringBuilder builder = new StringBuilder();
        builder.append("(");
        for (final String choice : CRITERIA_CHOICES) {
            builder.append(choice);
            builder.append("|");
        }

        builder.deleteCharAt(builder.length() - 1);
        builder.append(")");
        REGEXP_REP = builder.toString();
    }

    // Criteria to class , useful for dynamically calling classes during similarity metric analysis
    private static final Map<String, Class> CRITERIA_TO_CLASS_MAP = new HashMap<String, Class>() {{
        put("keysignatureequalto", KeySignatureEqualityCriteria.class);
        put("polyphonic", PolyphonyCriteria.class);
        put("timesignatureequalto", TimeSignatureEqualityCriteria.class);
        put("positivelyrics", PositiveLyricsIntentCriteria.class);
        put("stabvoiceclassification", STABVoiceClassificationCriteria.class);
    }};

    private String criteriaChoice;

    CriteriaChoice(final String criteriaChoice) {

        this.criteriaChoice = criteriaChoice;
    }

    /**
     * Gets the criteria
     * @return
     */
    public String getCriteriaChoice() {
        return criteriaChoice;
    }

    /**
     * Get a criteria class given a choice
     * @param choice
     * @return
     */
    public static Class getCriteriaClassGivenStringRep(final String choice) {
        return CRITERIA_TO_CLASS_MAP.get(choice);
    }
}
