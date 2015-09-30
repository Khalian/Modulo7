package com.modulo7.common.interfaces.choices;

import com.modulo7.musicstatmodels.similarity.songsimilarity.MaxMelodicEditDistanceSimilarity;
import com.modulo7.musicstatmodels.similarity.songsimilarity.TonalHistogramSimilarity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by asanyal on 9/23/15.
 *
 * Choices for song similarity exposed to the consumer
 */
public enum SongSimilarityChoices {

    MAX_MELODIC_EDIT_DISTANCE_SIMILARITY("maxmelodiceditdistance"),
    TONAL_HISTOGRAM_SIMILARITY("tonalhistogram");

    public static final String REGEXP_REP;

    // A list of all the song similarity choices
    private static final Set<String> SONG_SIMILARITY_CHOICES = new HashSet<>();

    // Song similarity to class , useful for dynamically calling classes during similarity metric analysis
    private static final Map<String, Class> SONG_SIMILARITY_TO_CLASS_MAP = new HashMap<String, Class>() {{
        put("maxmelodiceditdistance", MaxMelodicEditDistanceSimilarity.class);
        put("tonalhistogramsimilarity", TonalHistogramSimilarity.class);
    }};

    /**
     * Build up the global data structures
     */
    static {
        SongSimilarityChoices[] choices = SongSimilarityChoices.class.getEnumConstants();

        for (SongSimilarityChoices choice : choices) {
            SONG_SIMILARITY_CHOICES.add(choice.getChoice());
        }

        StringBuilder builder = new StringBuilder();
        builder.append("(");
        for (final String choice : SONG_SIMILARITY_CHOICES) {
            builder.append(choice);
            builder.append("|");
        }

        builder.deleteCharAt(builder.length() - 1);
        builder.append(")");
        REGEXP_REP = builder.toString();
    }

    private String choice;

    SongSimilarityChoices(final String choice) {
        this.choice = choice;
    }

    /**
     * List all the similarity measures that are available to the consumer
     */
    public static void listAllSimilarityMeasures() {
        System.out.println("The available similarity measure choices are :");
        for (final String simChoice : SONG_SIMILARITY_CHOICES) {
            System.out.println(simChoice);
        }
    }

    /**
     * Gets song similarity class
     * @param choice
     * @return
     */
    public static Class getSongSimilarityGivenChoice(final String choice) {
        return SONG_SIMILARITY_TO_CLASS_MAP.get(choice);
    }

    public String getChoice() {
        return choice;
    }
}
