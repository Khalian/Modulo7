package com.modulo7.common.interfaces.choices;

import com.modulo7.musicstatmodels.statistics.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by asanyal on 9/23/15.
 *
 * Different types of statistics defined as choices, acts as a mapping between choices
 * to locations
 */
public enum StatisticChoice {

    HAPPINESSINDEX("happinessindex"),
    SADNESSINDEX("sadnessindex"),
    POWERINDEX("powerindex"),
    MAXMELODICREPEATINGFACTOR("maxmelodicrepeatingfactor"),
    LONGESTCHORDPROGRESSION("longestchordprogression"),
    MAXRANGEOFSONG("maxrangeofsong"),
    LYRICALSEMANTICINTENT("lyricalsemanticintent"),
    NUMVOICES("numvoices"),
    MOST_FREQUENT_PITCH("mostfrequentpitch"),
    AVERAGE_PITCH_DURATION("averagepitchduration");

    // A list of all the statistic choices as defined
    private static final Set<String> STATISTIC_CHOICES = new HashSet<>();

    // The regular expression representation of statistic choice
    public static final String STAT_REGEXP_REP;

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
        STAT_REGEXP_REP = builder.toString();
    }

    // Statistic to class , useful for dynamically calling classes during similarity metric analysis
    private static final Map<String, Class> STATISTIC_TO_CLASS_MAP = new HashMap<String, Class>() {{
        put("happinessindex", HappinessIndex.class);
        put("sadnessindex", SadnessIndex.class);
        put("powerindex", PowerIndex.class);
        put("maxmelodicrepeatingfactor", MaxMelodicRepeatingFactor.class);
        put("maxrangeofsong", MaxRangeOfSong.class);
        put("longestchordprogression", LongestChordProgression.class);
        put("lyricalsemanticintent", LyricalSemanticIntent.class);
        put("numvoices", NumVoices.class);
        put("mostfrequentpitch", MostFrequentPitch.class);
        put("averagepitchduration", AveragePitchDuration.class);
    }};

    private String choice;

    StatisticChoice(final String choice) {
        this.choice = choice;
    }

    /**
     * Gets the string representation of the choice element
     * @return
     */
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
