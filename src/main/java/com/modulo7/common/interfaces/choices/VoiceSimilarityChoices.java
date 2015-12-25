package com.modulo7.common.interfaces.choices;

import com.modulo7.musicstatmodels.similarity.voicesimilarity.GrossContourSimilarity;
import com.modulo7.musicstatmodels.similarity.voicesimilarity.SCMNGramSimilarity;
import com.modulo7.musicstatmodels.similarity.voicesimilarity.UkkonnenSimilarity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by asanyal on 10/16/15.
 *
 * A enumeration and helper methods for all the voice similarity measures available
 * and classes associated with them
 */
public enum VoiceSimilarityChoices {

    GROSS_VOICE_CONTOUR_SIMILARITY("grossvoicecontour"),
    SCM_TRIGRAM_VOICE_SIMILARITY("scmtrigram"),
    UKKONNEN_VOICE_SIMILARITY("ukkonenmeasure");

    private String voiceSimMeasure;

    VoiceSimilarityChoices(final String voiceSimMeasure) {
         this.voiceSimMeasure = voiceSimMeasure;
    }

    // Regular expression detailing one of the choices for song similarity
    public static final String REGEXP_REP;

    // A list of all the song similarity choices
    private static final Set<String> VOICE_SIMILARITY_CHOICES = new HashSet<>();

    // Song similarity to class , useful for dynamically calling classes during similarity metric analysis
    private static final Map<String, Class> VOICE_SIMILARITY_TO_CLASS_MAP = new HashMap<String, Class>() {{
        put("grossvoicecontour", GrossContourSimilarity.class);
        put("scmtrigram", SCMNGramSimilarity.class);
        put("ukkonenmeasure", UkkonnenSimilarity.class);
    }};

    /**
     * Build up the global data structures
     */
    static {
        VoiceSimilarityChoices[] choices = VoiceSimilarityChoices.class.getEnumConstants();

        for (VoiceSimilarityChoices choice : choices) {
            VOICE_SIMILARITY_CHOICES.add(choice.getChoice());
        }

        StringBuilder builder = new StringBuilder();
        builder.append("(");
        for (final String choice : VOICE_SIMILARITY_CHOICES) {
            builder.append(choice);
            builder.append("|");
        }

        builder.deleteCharAt(builder.length() - 1);
        builder.append(")");
        REGEXP_REP = builder.toString();
    }

    public String getChoice() {
        return voiceSimMeasure;
    }

    /**
     * Gets song similarity class
     * @param choice
     * @return
     */
    public static Class getVoiceSimilarityGivenChoice(final String choice) {
        return VOICE_SIMILARITY_TO_CLASS_MAP.get(choice);
    }

    /**
     * List all the available voice similarity measures
     */
    public static void listAllSimilarityMeasures() {
        System.out.println("The available similarity measure choices are :");
        // VOICE_SIMILARITY_CHOICES.forEach(System.out::println);

        for (final String simChoice : VOICE_SIMILARITY_CHOICES) {
            System.out.println(simChoice);
        }
    }
}
