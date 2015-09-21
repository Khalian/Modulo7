package nlptests;

import com.modulo7.nlp.NLPUtils;
import junit.framework.Assert;
import org.junit.Test;
import org.apache.lucene.queryparser.classic.ParseException;

import java.io.IOException;

/**
 * Created by asanyal on 8/18/15.
 *
 * Junit tests
 */
public class NLPUtilsTest {

    /**
     * Basic test case for modulo7 porter for NLP
     */
    @Test
    public void stemmerTest() throws ParseException, IOException {

        String inputSetence = "Hello my name is Arunav Sanyal, I liked horse back riding since I was a child";
        String actualStemmedText =  "Hello my name Arunav Sanyal I like hors back ride sinc I child";

        String stemmedSentence = NLPUtils.stemmer(inputSetence);

        Assert.assertEquals(actualStemmedText, stemmedSentence);

        String nextInputSentence = "Baba black sheep have you any wool, yes sir, yes sir three bags full";
        String actualNextStemmedText = "Baba black sheep have you ani wool ye sir ye sir three bag full";

        String nextStemmedSentence = NLPUtils.stemmer(nextInputSentence);

        Assert.assertEquals(actualNextStemmedText, nextStemmedSentence);
    }
}
