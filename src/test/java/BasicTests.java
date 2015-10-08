import com.modulo7.engine.Modulo7QueryProcessingEngine;
import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by asanyal on 10/8/15.
 *
 * Basic test cases to maintain internal consistency
 */
public class BasicTests {

    /**
     * Test to check if the regexps in Modulo7 actually work
     */
    @Test
    public void patternTest() {
        Pattern criteriaPattern = Modulo7QueryProcessingEngine.CRITERIA_PATTERNS;
        final String polyphonicExpr = "polyphonic is true";
        Matcher matcher = criteriaPattern.matcher(polyphonicExpr);
        Assert.assertTrue(matcher.find());

        final String badExpr = "blah is blah";
        Matcher matcher1 = criteriaPattern.matcher(badExpr);
        Assert.assertFalse(matcher1.find());
    }
}
