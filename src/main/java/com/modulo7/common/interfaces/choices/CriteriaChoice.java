package com.modulo7.common.interfaces.choices;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by asanyal on 9/23/15.
 *
 * A listing of all the criteria implemented in modulo7
 */
public enum CriteriaChoice {
    KEY_SIGNATURE_EQUALITY_CRITERIA("keysignatureequalto"),
    POLYPHONIC_CRITERIA("polyphonic");

    // A set of all criteria choices
    private static final Set<String> CRITERIA_CHOICES = new HashSet<>();

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

    private String criteriaChoice;

    CriteriaChoice(final String criteriaChoice) {

        this.criteriaChoice = criteriaChoice;
    }

    public String getCriteriaChoice() {
        return criteriaChoice;
    }
}
