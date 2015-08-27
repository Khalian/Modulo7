import com.modulo7.nlp.Lyrics;
import com.modulo7.nlp.LyricsIndexer;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by asanyal on 8/27/15.
 *
 * Test cases for lyrics indexer
 */
public class LyricsIndexerTest {

    @Test
    public void lyricsIndexerTest() throws IOException {
        LyricsIndexer indexer = new LyricsIndexer();

        Lyrics lyrics = new Lyrics("Barbie girl", "Some guy", new File("./src/test/testdata/lyrics/barbie_girl"));

        indexer.indexLyrics(lyrics);
    }
}
