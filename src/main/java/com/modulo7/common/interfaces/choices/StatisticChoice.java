package com.modulo7.common.interfaces.choices;

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
 * Different types of statistics defined
 */
public enum StatisticChoice {

    HAPPINESSINDEX("happinessindex"),
    SADNESSINDEX("sadnessindex"),
    POWERINDEX("powerindex"),
    MAXMELODICREPEATINGFACTOR("maxmelodicrepeatingfactor");

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

    // Statistic to class , useful for dynamically calling classes during similarity metric analysis
    private static final Map<String, Class> STATISTIC_TO_CLASS_MAP = new HashMap<String, Class>() {{
        put("happinessindex", HappinessIndex.class);
        put("sadnessindex", SadnessIndex.class);
        put("powerindex", PowerIndex.class);
        put("maxmelodicrepeatingfactor", MaxMelodicRepeatingFactor.class);
    }};

    private String choice;

    StatisticChoice(final String choice) {
        this.choice = choice;
    }

    public String getChoice() {
        return choice;
    }

    /**
     * Returns a statistic type class given the string rep
     *
     * @param statistic
     * @return
     */
    public static Class getStatisticMapGivenChoiceString(final String statistic) {
        return STATISTIC_TO_CLASS_MAP.get(statistic);
    }
}
