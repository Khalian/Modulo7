import com.echonest.api.v4.EchoNestException;
import com.modulo7.common.exceptions.Modulo7BadKeyException;
import com.modulo7.common.exceptions.Modulo7DataBaseNotSerializedException;
import com.modulo7.common.exceptions.Modulo7InvalidMusicXMLFile;
import com.modulo7.common.exceptions.Modulo7NoSuchFileException;
import com.modulo7.engine.DatabaseEngine;
import com.modulo7.engine.Modulo7Indexer;
import com.modulo7.musicstatmodels.representation.KeySignature;
import com.modulo7.musicstatmodels.representation.ScaleType;
import com.modulo7.musicstatmodels.representation.Song;
import junit.framework.Assert;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import javax.sound.midi.InvalidMidiDataException;
import java.io.File;
import java.io.IOException;
import java.util.Set;

/**
 * Created by asanyal on 9/9/15.
 *
 * Test cases for the database engine
 */
public class DatabaseEngineTest {

    /**
     * Sanity test case for database engine init
     * @throws InvalidMidiDataException
     * @throws Modulo7InvalidMusicXMLFile
     * @throws EchoNestException
     * @throws Modulo7NoSuchFileException
     */
    @Test
    public void dataBaseSantiyTest() throws InvalidMidiDataException, Modulo7InvalidMusicXMLFile, EchoNestException, Modulo7NoSuchFileException,
            Modulo7DataBaseNotSerializedException, IOException {
        File file = new File("./src/test/testdataSerialization/");
        file.mkdir();
        DatabaseEngine engine = new DatabaseEngine("./src/test/testdata", "./src/test/testdataSerialization/");
        engine.buildInMemoryDataBaseFromScratch();
        engine.serializeDataSetAndMoveToDisk();
        engine.deserializeDataSetAndBuildInMemory(true);
        FileUtils.deleteDirectory(file);
    }

    /**
     * Sanity test for the m7 indexer
     */
    @Test
    public void m7IndexerSanityTest() throws InvalidMidiDataException, Modulo7InvalidMusicXMLFile, EchoNestException,
            Modulo7NoSuchFileException, IOException, Modulo7BadKeyException {
        File file = new File("./src/test/testdataSerialization/");
        file.mkdir();
        Modulo7Indexer indexer = new Modulo7Indexer("./src/test/testdata", "./src/test/testdataSerialization/");

        KeySignature keySignature = new KeySignature("C#", ScaleType.MINOR);

        Set<Song> songSet = indexer.getKeySignatureIndexedSet(keySignature);

        Assert.assertTrue(songSet.size() >= 1);

        FileUtils.deleteDirectory(file);
    }
}
