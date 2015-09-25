package enginetests;

import com.echonest.api.v4.EchoNestException;
import com.modulo7.common.exceptions.*;
import com.modulo7.engine.DatabaseEngine;
import com.modulo7.engine.Modulo7Indexer;
import com.modulo7.musicstatmodels.representation.metadata.KeySignature;
import com.modulo7.musicstatmodels.representation.metadata.ScaleType;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;
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
     *
     * @throws InvalidMidiDataException
     * @throws Modulo7InvalidMusicXMLFile
     * @throws EchoNestException
     * @throws Modulo7NoSuchFileException
     * @throws Modulo7DataBaseNotSerializedException
     * @throws IOException
     * @throws Modulo7InvalidFileOperationExeption
     * @throws Modulo7ParseException
     */
    @Test
    public void dataBaseSantiyTest() throws InvalidMidiDataException, Modulo7InvalidMusicXMLFile, EchoNestException, Modulo7NoSuchFileException,
            Modulo7DataBaseNotSerializedException, IOException, Modulo7InvalidFileOperationExeption, Modulo7ParseException, Modulo7InvalidArgsException {
        File file = new File("./src/test/testdataSerialization/");
        file.mkdir();
        DatabaseEngine engine = new DatabaseEngine("./src/test/testdata", "./src/test/testdataSerialization/");
        engine.buildInMemoryDataBaseFromScratch();
        engine.serializeDataSetAndMoveToDisk();
        engine.deserializeDataSetAndBuildInMemory(true);
        FileUtils.deleteDirectory(file);
    }


    /**
     * Sanity testing for the modulo 7 indexer engine
     *
     * @throws InvalidMidiDataException
     * @throws Modulo7InvalidMusicXMLFile
     * @throws EchoNestException
     * @throws Modulo7NoSuchFileException
     * @throws Modulo7BadKeyException
     * @throws Modulo7IndexingDirError
     * @throws IOException
     * @throws Modulo7InvalidFileOperationExeption
     * @throws Modulo7ParseException
     */
    @Test
    public void m7IndexerSanityTest() throws InvalidMidiDataException, Modulo7InvalidMusicXMLFile, EchoNestException,
            Modulo7NoSuchFileException, Modulo7BadKeyException, Modulo7IndexingDirError, IOException, Modulo7InvalidFileOperationExeption,
            Modulo7ParseException, Modulo7InvalidArgsException {
        File file = new File("./src/test/testdataSerialization/");
        file.mkdir();
        Modulo7Indexer indexer = new Modulo7Indexer("./src/test/testdata", "./src/test/testdataSerialization/");
        indexer.indexData();

        KeySignature keySignature = new KeySignature("C#", ScaleType.MINOR);

        Set<Song> songSet = indexer.getKeySignatureIndexedSet(keySignature);

        Assert.assertTrue(songSet.size() >= 1);

        FileUtils.deleteDirectory(file);
    }
}
