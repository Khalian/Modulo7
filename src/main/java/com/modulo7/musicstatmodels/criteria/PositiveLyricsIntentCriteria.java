package com.modulo7.musicstatmodels.criteria;

import com.likethecolor.alchemy.api.entity.SentimentAlchemyEntity;
import com.modulo7.common.interfaces.AbstractCriteria;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;
import com.modulo7.nlp.models.SentimentModel;
import com.modulo7.nlp.nlpengine.AlchemyEngine;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Created by asanyal on 10/10/15.
 *
 * Is the lyrical content positive in its semantic intent ? If so the criteria is satisfied
 */
public class PositiveLyricsIntentCriteria implements AbstractCriteria {

    // Logger for the positive lyrics intent
    private static Logger logger = Logger.getLogger(PositiveLyricsIntentCriteria.class);

    @Override
    public boolean getCriteriaEvaluation(final Song song) {
        try {
            AlchemyEngine engine = new AlchemyEngine();
            SentimentModel model = engine.sentimentAnalysis(song.getLyrics().getLyricsOfSong());
            return model.getIntent() == SentimentAlchemyEntity.TYPE.POSITIVE;
        } catch (IOException e) {
            logger.error(e.getMessage());
        }

        return false;
    }
}
