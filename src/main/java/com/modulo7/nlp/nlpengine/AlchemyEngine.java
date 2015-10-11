package com.modulo7.nlp.nlpengine;

import com.likethecolor.alchemy.api.Client;
import com.likethecolor.alchemy.api.call.AbstractCall;
import com.likethecolor.alchemy.api.call.LanguageCall;
import com.likethecolor.alchemy.api.call.SentimentCall;
import com.likethecolor.alchemy.api.call.type.CallTypeText;
import com.likethecolor.alchemy.api.entity.LanguageAlchemyEntity;
import com.likethecolor.alchemy.api.entity.Response;
import com.likethecolor.alchemy.api.entity.SentimentAlchemyEntity;
import com.modulo7.nlp.models.SentimentModel;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by asanyal on 10/10/15.
 *
 * The engine class to acquire semantics/language ID and other information from lyrics
 */
public class AlchemyEngine {

    // Alchemy's API key (atleast for me, TODO: Make this externalized and generic)
    private static final String apiKey = "1b080ed87a8bcf157d19e3f08a48a9b10fd113ba";

    // The alchemy client object
    private Client alchemyClient;

    /**
     * Default constructor for alchemy
     * @throws IOException
     */
    public AlchemyEngine() throws IOException {
        alchemyClient = new Client();
        alchemyClient.setAPIKey(apiKey);
    }

    /**
     * Gets the semantic score for a line of text
     *
     * @param text
     * @return
     * @throws IOException
     */
    public SentimentModel sentimentAnalysis(final String text) throws IOException {
        final AbstractCall<SentimentAlchemyEntity> sentimentCall = new SentimentCall(new CallTypeText(text));
        Response<SentimentAlchemyEntity> response = alchemyClient.call(sentimentCall);

        Iterator<SentimentAlchemyEntity> iterator = response.iterator();

        while (iterator.hasNext()) {
            SentimentAlchemyEntity entity = iterator.next();
            return new SentimentModel(entity.getScore(), entity.getType());
        }

        return new SentimentModel(0.0, SentimentAlchemyEntity.TYPE.UNSET);
    }

    /**
     * Gets the languages involved in a given text
     * @return
     * @throws IOException
     */
    public Set<String> languageCall(final String text) throws IOException {
        final AbstractCall<LanguageAlchemyEntity> languageCall = new LanguageCall(new CallTypeText(text));
        Response<LanguageAlchemyEntity> response = alchemyClient.call(languageCall);

        Iterator<LanguageAlchemyEntity> iterator = response.iterator();

        Set<String> languages = new HashSet<>();

        while (iterator.hasNext()) {
            LanguageAlchemyEntity entity = iterator.next();
            languages.add(entity.getLanguage());
        }

        return languages;
    }
}
