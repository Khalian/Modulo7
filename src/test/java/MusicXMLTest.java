/**
 * Created by asanyal on 8/9/15.
 *
 * Test cases for music xml related operations and the parser in general
 */

import com.modulo7.common.exceptions.Modulo7BadKeyException;
import com.modulo7.common.exceptions.Modulo7InvalidCircleOfFifthsDistance;
import com.modulo7.common.exceptions.Modulo7InvalidMusicXMLFile;
import com.modulo7.musicstatmodels.representation.*;
import com.modulo7.othersources.BasicMusicXMLParser;
import junit.framework.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * Test cases for the music xml parser
 */
public class MusicXMLTest {


    /**
     * Check for the correct acquisition of metadata from the music xml file
     *
     * @throws IOException
     * @throws Modulo7InvalidMusicXMLFile
     * @throws Modulo7InvalidCircleOfFifthsDistance
     * @throws Modulo7BadKeyException
     */
    @Test
    public void musicXMLMetaDataAcquisitionTest() throws IOException, Modulo7InvalidMusicXMLFile,
            Modulo7InvalidCircleOfFifthsDistance, Modulo7BadKeyException {

        final String attributesTestData = "./src/test/testdata/musicxml/attributesTestData.xml";
        BasicMusicXMLParser xmlParser = new BasicMusicXMLParser(attributesTestData);

        // Acquire the song by parsing the music xml file
        Song song = xmlParser.getSongRepresentation();

        // Acquire the time signature
        KeySignature keySignature = xmlParser.getKeySignature();

        // Test if key signature has been correctly acquired
        Assert.assertEquals(keySignature.getKey(), "C");
        Assert.assertEquals(keySignature.getScale(), ScaleType.MINOR);

        // Asserts the number of divisions is the same as the one in the test case
        Assert.assertEquals(xmlParser.getDivision(0), 24);

        // Acuire the time signature infomration
        TimeSignature timeSignature = xmlParser.getTimeSignature();

        // Check if the time signature has been correctly acquired from the file
        Assert.assertEquals(timeSignature.getNoteValIsBeat(), 3);
        Assert.assertEquals(timeSignature.getBeatsPerMeasure(), 4);

        SongMetadata songMetadata = song.getMetadata();

        KeySignature keySignature1 = songMetadata.getKeySignature();

        // Test if key signature has been correctly acquired
        Assert.assertEquals(keySignature1.getKey(), "C");
        Assert.assertEquals(keySignature1.getScale(), ScaleType.MINOR);
    }

    /**
     * A test case to check for a sanity getSongRepresentation of a non trivial example for music xml parser
     *
     * @throws IOException
     * @throws Modulo7InvalidMusicXMLFile
     * @throws Modulo7InvalidCircleOfFifthsDistance
     * @throws Modulo7BadKeyException
     */
    @Test
    public void musicXMLSanityParseTest() throws IOException, Modulo7InvalidMusicXMLFile,
            Modulo7InvalidCircleOfFifthsDistance, Modulo7BadKeyException {

        final String basicScoreData = "./src/test/testdata/musicxml/musicXMLTest.xml";
        BasicMusicXMLParser xmlParser = new BasicMusicXMLParser(basicScoreData);

        Song song = xmlParser.getSongRepresentation();

        Assert.assertNotNull(song);
    }

    /**
     * Unit test case to parse whether a chord is present or not
     */
    @Test
    public void musicXMLChordParseTest() throws IOException, Modulo7InvalidMusicXMLFile {
        final String chordScoreData = "./src/test/testdata/musicxml/chord.xml";
        BasicMusicXMLParser xmlParser = new BasicMusicXMLParser(chordScoreData);

        Song song = xmlParser.getSongRepresentation();

        Assert.assertNotNull(song);

        Assert.assertEquals(song.getNumVoices(), 1);

        Set<Voice> setOfVoices = song.getVoices();

        // There is only one voice, but still as the representation we have to iterate
        for (Voice voice : setOfVoices) {
            List<VoiceInstant> voiceInstantList = voice.getVoiceSequence();
            Assert.assertEquals(voiceInstantList.size(), 2);

            VoiceInstant firstInstant = voiceInstantList.get(0);
            VoiceInstant secondInstant = voiceInstantList.get(1);

            Assert.assertEquals(firstInstant.getChordType(), ChordType.MINOR);
            Assert.assertEquals(secondInstant.getChordType(), ChordType.NOT_A_CHORD);
        }
    }
}
