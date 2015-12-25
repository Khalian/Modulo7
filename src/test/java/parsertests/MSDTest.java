package parsertests;

import com.modulo7.common.interfaces.AbstractAnalyzer;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;
import com.modulo7.pureresearch.MSDSongParser;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by asanyal on 9/9/15.
 *
 * Test cases for million song data set input
 */
public class MSDTest {

    /**
     * Basic sanity test case for million song dataset parser
     */
    @Test
    public void msdSanityTest() {
        final String h5location = "./src/test/testdata/research/test.h5";
        AbstractAnalyzer analyzer = new MSDSongParser(h5location);
        final Song song = analyzer.getSongRepresentation();
        Assert.assertNotNull(song);
    }
}   
