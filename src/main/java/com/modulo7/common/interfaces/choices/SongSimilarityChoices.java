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

    private static final Set<String> SONG_SIMILARITY_CHOICES = new HashSet<String>() {{
        add("maxmelodiceditdistance");
        add("tonalhistogramsimilarity");
    }};

    // Song similarity to class , useful for dynamically calling classes during similarity metric analysis
    public static final Map<String, Class> SONG_SIMILARITY_TO_CLASS_MAP = new HashMap<String, Class>() {{
        put("maxmelodiceditdistance", MaxMelodicEditDistanceSimilarity.class);
        put("tonalhistogramsimilarity", TonalHistogramSimilarity.class);
    }};

    static {
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

    SongSimilarityChoices(String generic_maximal_voice_similarity) {
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
}
