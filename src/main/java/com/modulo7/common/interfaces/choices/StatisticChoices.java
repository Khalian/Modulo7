package com.modulo7.common.interfaces.choices;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by asanyal on 9/23/15.
 *
 * Different types of statistics defined
 */
public enum StatisticChoices {

    HAPPINESSINDEX("happinessIndex"),
    SADNESSINDEX("sadnessIndex"),
    POWERINDEX("powerIndex"),
    MAXMELODICREPEATINGFACTOR("maxMelodicRepeatingFactor");

    private static final Set<String> STATISTIC_CHOICES = new HashSet<String>() {{
        add("happinessIndex"); add("sadnessIndex"); add("ppwerIndex"); add("maxMelodicRepeatingFactor");
    }};

    public static final String REGEXP_REP;

    static {
        StringBuilder builder = new StringBuilder();
        builder.append("(");
        for (final String choice : STATISTIC_CHOICES) {
            builder.append(choice);
            builder.append("|");
        }

        builder.deleteCharAt(builder.length() - 1);
        builder.append(")");
        REGEXP_REP = builder.toString();
    }


    StatisticChoices(String happinessIndex) {

    }
}
