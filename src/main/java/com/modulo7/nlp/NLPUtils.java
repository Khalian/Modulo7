package com.modulo7.nlp;

/**
 * Created by asanyal on 6/19/2015.
 * <p>
 * A utility class for natural language processing
 * work
 */

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.en.EnglishAnalyzer;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.util.Version;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NLPUtils {

    /*
    public static String translateToEnglish(String sourceString) {
        Translator translate = Translator.getInstance();
        String text = translate.translate("Hello!", Language.ENGLISH, Language.ROMANIAN);
        System.out.println(text); // "Bun? ziua!"
        return null;
    }
    */

    /**
     * A utility method to stem a sentence (argument of the form list or array of
     * strings)
     *
     * @param unstemmedText
     * @return
     * @throws ParseException
     */
    public static List<String> englishStemmer(final String... unstemmedText) throws ParseException {

        List<String> stemmedText = new ArrayList<>();

        EnglishAnalyzer en_an = new EnglishAnalyzer(Version.LUCENE_34);
        QueryParser parser = new QueryParser(Version.LUCENE_34, "", en_an);

        for (String unStemmedWord : unstemmedText) {
            stemmedText.add(parser.parse(unStemmedWord).toString());
        }

        return stemmedText;
    }

    /**
     *
     * Simple helper method that takes a string separated by spaces and
     * returns the words along with their counts
     *
     * @param inputString
     * @return
     */
    public Map<String, Integer> getVocabularyCounts(final String inputString) {
        Map<String, Integer> vocabCounts = new HashMap<>();

        String[] inputConstituents = inputString.split("\\s+");

        for (String inputConstituent : inputConstituents) {
            addCountToMap(vocabCounts, inputConstituent);
        }

        return vocabCounts;
    }

    /**
     * A sample test case for unit testing purposes for the english stemmer
     *
     * @throws ParseException
     */
    public static void test() throws ParseException {

        String inputSetence = "Hello my name is Arunav Sanyal, I liked horse back riding since I was a child";
        String[] inputSentenceList = inputSetence.split(" ");
        List<String> stemmedSentence = NLPUtils.englishStemmer(inputSentenceList);

        for (String word : stemmedSentence) {
            System.out.print(word + " ");
        }
    }

    /**
     * Unit addition of count to map
     *
     * @param map
     * @param word (Word whose count to increment)
     */
    private void addCountToMap(final Map<String, Integer> map, final String word) {
        if (map.containsKey(word)) {
            int currCount = map.get(word);
            map.put(word, currCount + 1);
        } else {
            map.put(word, 1);
        }
    }
}
