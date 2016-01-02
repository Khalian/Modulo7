package com.modulo7.common.interfaces.choices;

import com.modulo7.musicstatmodels.similarity.contoursimilarity.MullensefsteinContourSimilarity;
import com.modulo7.musicstatmodels.similarity.contoursimilarity.NaturalContourSimilarity;
import com.modulo7.musicstatmodels.similarity.contoursimilarity.SteinbeckContourSimililarity;
import com.modulo7.musicstatmodels.similarity.songsimilarity.*;
import com.modulo7.musicstatmodels.vectorspacemodels.contour.voicecontour.MullensiefenContour;
import com.modulo7.musicstatmodels.vectorspacemodels.contour.voicecontour.SteinbeckContour;

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
    TONAL_HISTOGRAM_SIMILARITY("tonalhistogram"),
    WEIGHTED_TONAL_HISTOGRAM_SIMILARITY("weighedtonalhistogram"),
    NATURAL_SONG_CONTOUR_SIMILARITY("naturalsongcontour"),
    MULLENSEFSTEIN_SONG_CONTOUR("mullensefsteincontour"),
    GROSS_SONG_CONTOUR_SIMILARITY("grosssongcontour"),
    SCM_TRIGRAM_SONG_SIMILARITY("scmtrigram"),
    UKKONNEN_SONG_SIMILARITY("ukkonenmeasure"),
    COUNT_DISTANCE_SIMILARITY("countdistancetrigram");

    // Regular expression detailing one of the choices for song similarity
    public static final String REGEXP_REP;

    // A list of all the song similarity choices
    private static final Set<String> SONG_SIMILARITY_CHOICES = new HashSet<>();

    // Song similarity to class , useful for dynamically calling classes during similarity metric analysis
    private static final Map<String, Class> SONG_SIMILARITY_TO_CLASS_MAP = new HashMap<String, Class>() {{
        put("maxmelodiceditdistance", MaxMelodicEditDistanceSimilarity.class);
        put("tonalhistogram", TonalHistogramSimilarity.class);
        put("weighedtonalhistogram", WeightedTonalHistogramSimilarity.class);
        put("naturalsongcontour", NaturalContourSimilarity.class);
        put("mullensefsteincontour", MullensefsteinContourSimilarity.class);
        put("steinbeckcontour", SteinbeckContourSimililarity.class);
        put("scmtrigram", SCMNGramSongSimilarity.class);
        put("grosssongcontour", GrossSongContourSilimarity.class);
        put("ukkonenmeasure", UkkonnenSongSimilarity.class);
        put("countdistancetrigram", CountDistanceSongSimilarity.class);
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
        SONG_SIMILARITY_CHOICES.forEach(System.out::println);
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
