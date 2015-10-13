package serializationtest;

import com.echonest.api.v4.EchoNestException;
import com.modulo7.common.exceptions.Modulo7InvalidFileOperationException;
import com.modulo7.common.exceptions.Modulo7NoSuchFileOrDirectoryException;
import com.modulo7.common.exceptions.Modulo7ParseException;
import com.modulo7.common.interfaces.AbstractAnalyzer;
import com.modulo7.acoustics.EchoNestBasicMP3Analyzer;
import com.modulo7.acoustics.MidiToSongConverter;
import com.modulo7.common.exceptions.Modulo7InvalidMusicXMLFile;
import com.modulo7.common.utils.AvroUtils;
import com.modulo7.common.utils.Modulo7Globals;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;
import com.modulo7.nlp.lyrics.Lyrics;
import com.modulo7.othersources.BasicMusicXMLParser;
import org.junit.Assert;
import org.junit.Test;

import javax.sound.midi.InvalidMidiDataException;
import java.io.File;

/**
 * Created by asanyal on 8/31/15.
 *
 * Avro utility test case, Sanity tests for serialization and deserialization of the
 * Song and Lyrics classes
 */
public class AvroUtilsTest {

    /**
     * Test if serialization and deserialization for midi files work without throwing exceptions
     *
     * @throws InvalidMidiDataException
     * @throws com.modulo7.common.exceptions.Modulo7NoSuchFileOrDirectoryException
     */
    @Test
    public void testMidiFileSerialization() throws InvalidMidiDataException, Modulo7NoSuchFileOrDirectoryException {
        final String midiLocation = "./src/test/testdata/midi/test.mid";
        AbstractAnalyzer midiAnalyzer = new MidiToSongConverter(midiLocation);

        Song song = midiAnalyzer.getSongRepresentation();

        AvroUtils.serialize("./src/test/tempMidiFile" + Modulo7Globals.EXTENSION_TO_SERIALIZED_FILES, song);
        Song deserializedSong = AvroUtils.deserialize("./src/test/tempMidiFile" + Modulo7Globals.EXTENSION_TO_SERIALIZED_FILES);
        Assert.assertNotNull(deserializedSong);

        File theAvroFile = new File("./src/test/tempMidiFile" + Modulo7Globals.EXTENSION_TO_SERIALIZED_FILES);
        Assert.assertTrue(theAvroFile.delete());

        // TODO : Write some code for proper equality check on song objects
        // Assert.assertEquals(song, deserializedSong);
    }

    /**
     * Test if serialization and deserialization for mp3 files work without throwing exceptions
     *
     * @throws EchoNestException
     * @throws com.modulo7.common.exceptions.Modulo7NoSuchFileOrDirectoryException
     * @throws com.modulo7.common.exceptions.Modulo7NoSuchFileOrDirectoryException
     */
    @Test
    public void testMp3FileSerialization() throws EchoNestException, Modulo7NoSuchFileOrDirectoryException {

        final String mp3Location = "./src/test/testdata/mp3/stairway_to_heaven.mp3";

        AbstractAnalyzer analyzer = new EchoNestBasicMP3Analyzer(mp3Location);
        Song mp3song = analyzer.getSongRepresentation();

        AvroUtils.serialize("./src/test/tempMp3File" + Modulo7Globals.EXTENSION_TO_SERIALIZED_FILES, mp3song);
        Song song = AvroUtils.deserialize("./src/test/tempMp3File" + Modulo7Globals.EXTENSION_TO_SERIALIZED_FILES);
        Assert.assertNotNull(song);

        File theAvroFile = new File("./src/test/tempMp3File" + Modulo7Globals.EXTENSION_TO_SERIALIZED_FILES);
        Assert.assertTrue(theAvroFile.delete());

        // Assert.assertEquals(mp3song, mp3DeserializedSong);
    }

    /**
     * Test if serialization and deserialization for music xml files work without throwing exceptions
     *
     * @throws com.modulo7.common.exceptions.Modulo7NoSuchFileOrDirectoryException
     * @throws Modulo7InvalidMusicXMLFile
     */
    @Test
    public void testMusicXMLFileSerialization() throws Modulo7InvalidMusicXMLFile, Modulo7NoSuchFileOrDirectoryException {
        final String musicXMLFileLocation = "./src/test/testdata/musicxml/musicXMLTest.xml";

        AbstractAnalyzer analyzer = new BasicMusicXMLParser(musicXMLFileLocation);
        Song musicXMLSong = analyzer.getSongRepresentation();

        AvroUtils.serialize("./src/test/tempXMLFile" + Modulo7Globals.EXTENSION_TO_SERIALIZED_FILES, musicXMLSong);
        Song song = AvroUtils.deserialize("./src/test/tempXMLFile" + Modulo7Globals.EXTENSION_TO_SERIALIZED_FILES);
        Assert.assertNotNull(song);

        File theAvroFile = new File("./src/test/tempXMLFile" + Modulo7Globals.EXTENSION_TO_SERIALIZED_FILES);
        Assert.assertTrue(theAvroFile.delete());

        // Assert.assertEquals(musicXMLSong, musicXMLDeserializedSong);
    }

    /**
     * A test case in an independent lyrics object can be serialized and deserialized correctly
     *
     * @throws com.modulo7.common.exceptions.Modulo7InvalidFileOperationException
     * @throws com.modulo7.common.exceptions.Modulo7NoSuchFileOrDirectoryException
     * @throws com.modulo7.common.exceptions.Modulo7ParseException
     */
    @Test
    public void testLyricsSerialization() throws Modulo7NoSuchFileOrDirectoryException, Modulo7InvalidFileOperationException, Modulo7ParseException {

         Lyrics lyrics = new Lyrics("Barbie girl", "aqua", new File("./src/test/testdata/lyrics/barbie_girl"));
         AvroUtils.serialize("./src/test/tempLyrics.m7Lyrics", lyrics);
         AvroUtils.deserializeLyricsObject("./src/test/tempLyrics.m7Lyrics");

         File theAvroFile = new File("./src/test/tempLyrics.m7Lyrics");
         Assert.assertTrue(theAvroFile.delete());
    }
}
