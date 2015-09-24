package com.modulo7.common.interfaces.choices;

import com.modulo7.musicstatmodels.similarity.songsimilarity.GenericMaximalVoiceSimilarity;
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
    
    GENERIC_MAXIMAL_VOICE_SIMILARITY("generic_maximal_voice_similarity"),
    TONAL_HISTOGRAM_SIMILARITY("tonalhistogramsimilarity");

    public static final String REGEXP_REP;

    private static final Set<String> SONG_SIMILARITY_CHOICES = new HashSet<String>() {{
        add("generic_maximal_voice_similarity"); add("tonalhistogramsimilarity");
    }};

    // Song similarity to class map
    public static final Map<String, Class> SONG_SIMILARITY_TO_CLASS_MAP = new HashMap<String, Class>() {{
        put("generic_maximal_voice_similarity", GenericMaximalVoiceSimilarity.class);
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
}
