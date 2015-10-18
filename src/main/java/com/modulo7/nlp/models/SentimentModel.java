package com.modulo7.nlp.models;

import com.likethecolor.alchemy.api.entity.SentimentAlchemyEntity;

/**
 * Created by asanyal on 10/10/15.
 *
 * Modulo7 representation of the sentiment analysis of lyrics
 */
public class SentimentModel {

    // The score the sentiment, positive scores are for happy lyrics and negative scores are for sad or angry lyrics
    private double score;

    // The intent of the sentiment
    private SentimentAlchemyEntity.TYPE intent;

    /**
     * Create a sentiment model for Modulo7
     * @param score
     * @param intent
     */
    public SentimentModel(final double score, final SentimentAlchemyEntity.TYPE intent) {
        this.intent = intent;

        this.score = score;
        assert (score >= -1.0 && score <= 1.0);
    }

    /**
     * Gets the score
     * @return
     */
    public double getScore() {
        return score;
    }

    /**
     * Gets the sentiment type
     * @return
     */
    public SentimentAlchemyEntity.TYPE getIntent() {
        return intent;
    }
}
