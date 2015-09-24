package com.modulo7.common.interfaces.choices;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by asanyal on 9/23/15.
 *
 * A listing of all the criteria implemented in modulo7
 */
public enum  CriteriaChoices {
    KEY_SIGNATURE_EQUALITY_CRITERIA("keysignatureequalto"),
    POLYPHONIC_CRITERIA("polyphonic");

    private static final Set<String> CRITERIA_CHOICES = new HashSet<String>() {{
        add("keysignatureequalto"); add("polyphonic");
    }};

    public static final String REGEXP_REP;

    static {
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


    CriteriaChoices(String polyphonic) {

    }

}
