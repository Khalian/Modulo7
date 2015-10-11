package com.modulo7.nlp.models;

import com.likethecolor.alchemy.api.entity.SentimentAlchemyEntity;

/**
 * Created by asanyal on 10/10/15.
 *
 * Modulo7 representation of the sentiment analysis of lyrics
 */
public class SentimentModel {

    private double score;

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

    public double getScore() {
        return score;
    }

    public SentimentAlchemyEntity.TYPE getIntent() {
        return intent;
    }
}
