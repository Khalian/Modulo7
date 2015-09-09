import com.modulo7.nlp.Lyrics;
import com.modulo7.nlp.LyricsIndexer;
import com.modulo7.nlp.LyricsQueryParser;
import org.apache.commons.io.FileUtils;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.TopDocs;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by asanyal on 8/27/15.
 *
 * Test cases for lyrics indexer
 */
public class LyricsIndexerTest {

    /**
     * A sanity test with indexing exactly one object and returning it based on a score
     * @throws IOException
     * @throws ParseException
     */
    @Test
    public void lyricsIndexerSanityTest() throws IOException, ParseException {
        LyricsIndexer indexer = new LyricsIndexer();

        Lyrics lyrics = new Lyrics("Barbie girl", "aqua", new File("./src/test/testdata/lyrics/barbie_girl"));

        indexer.indexLyrics(lyrics);

        LyricsQueryParser queryParser = new LyricsQueryParser(LyricsIndexer.getDefaultIndexDir());
        TopDocs docs = queryParser.performSearch("Barbie", 1);
        Assert.assertEquals(docs.totalHits, 1);

        FileUtils.deleteDirectory(new File(indexer.getIndexDirLocation()));
    }

    /**
     * A slightly more involved lyrics indexer test
     */
    @Test
    public void lyricsIndexerTest() throws IOException {
        LyricsIndexer indexer = new LyricsIndexer();

        Lyrics lyrics = new Lyrics("Barbie girl", "aqua", new File("./src/test/testdata/lyrics/barbie_girl"));
        Lyrics betterLyrics = new Lyrics("Stairway to Heaven", "Led Zepplin", new File("./src/test/testdata/lyrics/stairway_to_heaven"));

        Set<Lyrics> lyricsSet = new HashSet<>();

        lyricsSet.add(lyrics);
        lyricsSet.add(betterLyrics);

        indexer.bulkIndexLyrics(lyricsSet);
    }
}
