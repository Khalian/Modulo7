import com.echonest.api.v4.EchoNestException;
import com.modulo7.common.interfaces.AbstractAnalyzer;
import com.modulo7.acoustics.EchoNestBasicMP3Analyzer;
import com.modulo7.acoustics.MidiToSongConverter;
import com.modulo7.common.exceptions.Modulo7InvalidMusicXMLFile;
import com.modulo7.common.exceptions.Modulo7NoSuchFileException;
import com.modulo7.common.utils.AvroUtils;
import com.modulo7.musicstatmodels.representation.Song;
import com.modulo7.othersources.BasicMusicXMLParser;
import org.junit.Assert;
import org.junit.Test;

import javax.sound.midi.InvalidMidiDataException;
import java.io.File;
import java.io.IOException;

/**
 * Created by asanyal on 8/31/15.
 *
 * Avro utility test case, sanity test for serialize and deserialize of the
 * Song class
 */
public class AvroUtilsTest {

    /**
     * Test if serialization and deserialization for midi files work without throwing exceptions
     *
     * @throws InvalidMidiDataException
     * @throws Modulo7NoSuchFileException
     */
    @Test
    public void testMidiFileSerialization() throws InvalidMidiDataException, Modulo7NoSuchFileException {
        final String midiLocation = "./src/test/testdata/midi/test.mid";
        AbstractAnalyzer midiAnalyzer = new MidiToSongConverter(midiLocation);

        Song song = midiAnalyzer.getSongRepresentation();

        AvroUtils.serialize("./src/test/tempMidiFile.avro", song);
        AvroUtils.deserialize("./src/test/tempMidiFile.avro");

        File theAvroFile = new File("./src/test/tempMidiFile.avro");
        Assert.assertTrue(theAvroFile.delete());

        // TODO : Write some code for proper equality check on song objects
        // Assert.assertEquals(song, deserializedSong);
    }

    /**
     * Test if serialization and deserialization for mp3 files work without throwing exceptions
     *
     * @throws EchoNestException
     * @throws Modulo7NoSuchFileException
     * @throws Modulo7NoSuchFileException
     */
    @Test
    public void testMp3FileSerialization() throws EchoNestException, Modulo7NoSuchFileException {

        final String mp3Location = "./src/test/testdata/mp3/stairway_to_heaven.mp3";

        AbstractAnalyzer analyzer = new EchoNestBasicMP3Analyzer(mp3Location);
        Song mp3song = analyzer.getSongRepresentation();

       AvroUtils.serialize("./src/test/tempMp3File.avro", mp3song);
       AvroUtils.deserialize("./src/test/tempMp3File.avro");

        File theAvroFile = new File("./src/test/tempMp3File.avro");
        Assert.assertTrue(theAvroFile.delete());

        // Assert.assertEquals(mp3song, mp3DeserializedSong);
    }

    /**
     * Test if serialization and deserialization for music xml files work without throwing exceptions
     *
     * @throws Modulo7NoSuchFileException
     * @throws Modulo7InvalidMusicXMLFile
     */
    @Test
    public void testMusicXMLFileSerialization() throws Modulo7InvalidMusicXMLFile, Modulo7NoSuchFileException {
        final String musicXMLFileLocation = "./src/test/testdata/musicxml/musicXMLTest.xml";

        AbstractAnalyzer analyzer = new BasicMusicXMLParser(musicXMLFileLocation);
        Song musicXMLSong = analyzer.getSongRepresentation();

        AvroUtils.serialize("./src/test/tempXMLFile.avro", musicXMLSong);
        AvroUtils.deserialize("./src/test/tempXMLFile.avro");

        File theAvroFile = new File("./src/test/tempXMLFile.avro");
        Assert.assertTrue(theAvroFile.delete());

        // Assert.assertEquals(musicXMLSong, musicXMLDeserializedSong);
    }
}
