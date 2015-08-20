/**
 * Created by asanyal on 8/9/15.
 *
 * Test cases for music xml related operations and the parser in general
 */

import com.modulo7.common.exceptions.Modulo7BadKeyException;
import com.modulo7.common.exceptions.Modulo7InvalidCircleOfFifthsDistance;
import com.modulo7.common.exceptions.Modulo7InvalidMusicXMLFile;
import com.modulo7.musicstatmodels.representation.KeySignature;
import com.modulo7.musicstatmodels.representation.ScaleType;
import com.modulo7.musicstatmodels.representation.Song;
import com.modulo7.musicstatmodels.representation.TimeSignature;
import com.modulo7.othersources.BasicMusicXMLParser;
import junit.framework.Assert;
import org.junit.Test;

import java.io.IOException;
import java.sql.Time;

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
        Song song = xmlParser.parse();

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

    }

    /**
     * A test case to check for a sanity parse of a non trivial example for music xml parser
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

        Song song = xmlParser.parse();

    }
}
