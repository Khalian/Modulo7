import com.echonest.api.v4.EchoNestException;
import com.modulo7.common.exceptions.Modulo7DataBaseNotSerializedException;
import com.modulo7.common.exceptions.Modulo7InvalidMusicXMLFile;
import com.modulo7.common.exceptions.Modulo7NoSuchFileException;
import com.modulo7.engine.DatabaseEngine;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import javax.sound.midi.InvalidMidiDataException;
import java.io.File;
import java.io.IOException;

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
        DatabaseEngine engine = new DatabaseEngine("./src/test/testdata", "./src/test/testdata", "./src/test/testdataSerialization/");
        engine.buildInMemoryDataBaseFromScratch();
        engine.serializeDataSetAndMoveToDisk();
        engine.deserializeDataSetAndBuildInMemory(true);
        FileUtils.deleteDirectory(file);
    }
}
