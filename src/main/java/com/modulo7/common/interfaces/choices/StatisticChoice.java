package com.modulo7.common.interfaces.choices;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by asanyal on 9/23/15.
 *
 * Different types of statistics defined
 */
public enum StatisticChoice {

    HAPPINESSINDEX("happinessIndex"),
    SADNESSINDEX("sadnessIndex"),
    POWERINDEX("powerIndex"),
    MAXMELODICREPEATINGFACTOR("maxMelodicRepeatingFactor");

    // A list of all the statistic choices as defined
    private static final Set<String> STATISTIC_CHOICES = new HashSet<>();

    public static final String REGEXP_REP;

    static {

        StatisticChoice[] allChoices = StatisticChoice.class.getEnumConstants();

        for (StatisticChoice choice : allChoices) {
            STATISTIC_CHOICES.add(choice.getChoice());
        }

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

    private String choice;

    StatisticChoice(final String choice) {
        this.choice = choice;
    }

    public String getChoice() {
        return choice;
    }
}
