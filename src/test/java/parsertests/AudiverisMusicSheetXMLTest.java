package parsertests;

import com.modulo7.common.interfaces.AbstractAnalyzer;
import com.modulo7.image.AudiverisSheetAnalyzer;
import org.junit.Test;

/**
 * Created by asanyal on 9/9/15.
 *
 * Audiveris test cases for Optical Music recognition
 *
 * TODO : Fix this
 */
public class AudiverisMusicSheetXMLTest {

    /**
     * Sanity test case for audiveris test case
     */
    @Test
    public void audiverisSanityTest() {
        final String sheetLocation = "./src/test/testdata/sheet/allegretto.png";
        AbstractAnalyzer analyzer = new AudiverisSheetAnalyzer(sheetLocation);
        // final Song song = analyzer.getSongRepresentation();
        // Assert.assertNotNull(song);
    }
}
