import com.echonest.api.v4.EchoNestException;
import com.modulo7.common.interfaces.AbstractAnalyzer;
import com.modulo7.acoustics.EchoNestBasicMP3Analyzer;
import com.modulo7.common.exceptions.Modulo7NoSuchFileException;
import com.modulo7.crawler.utils.MusicSources;
import com.modulo7.musicstatmodels.representation.Song;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by asanyal on 8/29/15.
 *
 * Junit test cases for mp3 files
 */
public class MP3Test {

    @Test
    public void mp3SanityTest() {
        final String mp3Location = "./src/test/testdata/mp3/stairway_to_heaven.mp3";

        try {
            AbstractAnalyzer analyzer = new EchoNestBasicMP3Analyzer(mp3Location);
            Song song = analyzer.getSongRepresentation();
            Assert.assertNotNull(song);
            Assert.assertEquals(song.getSource(), MusicSources.MP3);
        } catch (EchoNestException | Modulo7NoSuchFileException e) {
            e.printStackTrace();
        }
    }
}
