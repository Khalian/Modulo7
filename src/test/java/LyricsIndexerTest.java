import com.modulo7.nlp.Lyrics;
import com.modulo7.nlp.LyricsIndexer;
import com.modulo7.nlp.LyricsQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.TopDocs;
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
    public void lyricsIndexerTest() throws IOException, ParseException {
        LyricsIndexer indexer = new LyricsIndexer();

        Lyrics lyrics = new Lyrics("Barbie girl", "Some guy", new File("./src/test/testdata/lyrics/barbie_girl"));

        indexer.indexLyrics(lyrics);

        LyricsQueryParser queryParser = new LyricsQueryParser(LyricsIndexer.getDefaultIndexDir());
        TopDocs docs = queryParser.performSearch("Barbie", 1);
    }
}
