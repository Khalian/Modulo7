package com.modulo7.nlp;

/**
 * Created by asanyal on 6/19/2015.
 * <p>
 * A utility class for natural language processing
 * work
 */

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.core.StopFilter;
import org.apache.lucene.analysis.en.PorterStemFilter;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.queryparser.classic.ParseException;
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
    public static String stemmer(final String unstemmedText) throws ParseException, IOException {

        TokenStream tokenStream = new StandardTokenizer(Version.LUCENE_41, new StringReader(unstemmedText));
        tokenStream = new StopFilter(Version.LUCENE_41, tokenStream, StandardAnalyzer.STOP_WORDS_SET);
        tokenStream = new PorterStemFilter(tokenStream);

        StringBuilder sb = new StringBuilder();
        CharTermAttribute charTermAttr = tokenStream.getAttribute(CharTermAttribute.class);

        tokenStream.reset();
        while (tokenStream.incrementToken()) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(charTermAttr.toString());
        }
        tokenStream.close();

        return sb.toString();
    }

    /**
     * A utility method to stem a sentence (argument of the form list or array of
     * strings) for a list of strings
     *
     * @param unstemmedText
     * @return
     * @throws ParseException
     */
    public static List<String> stemmer(final String ... unstemmedText) throws ParseException {

        List<String> resultList = new ArrayList<>();

        for (String unstemmed : unstemmedText) {
            try {
                resultList.add(NLPUtils.stemmer(unstemmed));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return resultList;
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
        List<String> stemmedSentence = NLPUtils.stemmer(inputSentenceList);

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

