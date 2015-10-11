package parsertests; /**
 * Created by asanyal on 8/9/15.
 *
 * Test cases for music xml related operations and the parser in general
 */

import com.modulo7.common.exceptions.*;
import com.modulo7.crawler.utils.MusicSources;
import com.modulo7.musicstatmodels.representation.buildingblocks.ChordQuality;
import com.modulo7.musicstatmodels.representation.buildingblocks.Note;
import com.modulo7.musicstatmodels.representation.metadata.KeySignature;
import com.modulo7.musicstatmodels.representation.metadata.ScaleType;
import com.modulo7.musicstatmodels.representation.metadata.SongMetadata;
import com.modulo7.musicstatmodels.representation.metadata.TimeSignature;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;
import com.modulo7.musicstatmodels.representation.monophonic.VoiceInstant;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;
import com.modulo7.nlp.lyrics.Lyrics;
import com.modulo7.othersources.BasicMusicXMLParser;
import org.junit.Assert;
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
     * @throws Modulo7InvalidMusicXMLFile
     * @throws Modulo7InvalidCircleOfFifthsDistance
     * @throws Modulo7BadKeyException
     */
    @Test
    public void musicXMLMetaDataAcquisitionTest() throws Modulo7InvalidMusicXMLFile,
            Modulo7InvalidCircleOfFifthsDistance, Modulo7BadKeyException, Modulo7NoSuchFileException {

        final String attributesTestData = "./src/test/testdata/musicxml/attributesTestData.xml";
        BasicMusicXMLParser xmlParser = new BasicMusicXMLParser(attributesTestData);

        // Acquire the song by parsing the music xml file
        Song song = xmlParser.getSongRepresentation();

        SongMetadata metadata = song.getMetadata();

        // Acquire the time signature
        KeySignature keySignature = metadata.getKeySignature();

        // Test if key signature has been correctly acquired
        Assert.assertEquals(keySignature.getKey(), "C");
        Assert.assertEquals(keySignature.getScale(), ScaleType.MINOR);

        // Asserts the number of divisions is the same as the one in the test case
        Assert.assertEquals(xmlParser.getDivision(0), 24);

        // Acuire the time signature infomration
        TimeSignature timeSignature = metadata.getTimeSignature();

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
    public void musicXMLSanityParseTest() throws Modulo7InvalidMusicXMLFile,
            Modulo7InvalidCircleOfFifthsDistance, Modulo7BadKeyException, Modulo7NoSuchFileException {

        final String basicScoreData = "./src/test/testdata/musicxml/musicXMLTest.xml";
        BasicMusicXMLParser xmlParser = new BasicMusicXMLParser(basicScoreData);

        Song song = xmlParser.getSongRepresentation();

        Assert.assertNotNull(song);
        Assert.assertEquals(song.getSource(), MusicSources.MUSIC_XML_FILE);
    }

    /**
     * Unit test case to parse whether a chord is present or not
     */
    @Test
    public void musicXMLChordParseTest() throws Modulo7InvalidMusicXMLFile, Modulo7NoSuchFileException {
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

            Assert.assertEquals(firstInstant.getChordQuality(), ChordQuality.MINOR);
            Assert.assertEquals(secondInstant.getChordQuality(), ChordQuality.NOT_A_CHORD);
        }
    }


    /**
     * A more complicated music xml parser test, involving melody along with harmony elements like chords interspersed
     * together
     *
     * @throws Modulo7InvalidMusicXMLFile
     * @throws Modulo7NoSuchFileException
     * @throws Modulo7WrongNoteType
     */
    @Test
    public void musicXMLComplicatedChordParseTest() throws Modulo7InvalidMusicXMLFile, Modulo7NoSuchFileException, Modulo7WrongNoteType {
        final String chordScoreData = "./src/test/testdata/musicxml/complicatedChord.xml";
        BasicMusicXMLParser xmlParser = new BasicMusicXMLParser(chordScoreData);

        Song song = xmlParser.getSongRepresentation();

        Assert.assertNotNull(song);

        Assert.assertEquals(song.getNumVoices(), 1);

        Set<Voice> setOfVoices = song.getVoices();

        for (Voice voice : setOfVoices) {
            List<VoiceInstant> voiceInstantList = voice.getVoiceSequence();

            Assert.assertEquals(voiceInstantList.size(), 7);

            VoiceInstant firstInstant = voiceInstantList.get(0);

            Assert.assertEquals(firstInstant.getChordQuality(), ChordQuality.MINOR);

            VoiceInstant secondInstant = voiceInstantList.get(1);

            Assert.assertEquals(secondInstant.getNote(), Note.B4);

            VoiceInstant thirdInstant = voiceInstantList.get(2);

            Assert.assertEquals(thirdInstant.getChordQuality(), ChordQuality.MINOR);
        }
    }

    /**
     * Test if the music xml parser is able to correctly acquire the lyrics tags from the music
     * xml file
     *
     * @throws Modulo7InvalidMusicXMLFile
     * @throws Modulo7NoSuchFileException
     */
    @Test
    public void musicXMLLyricsParseTest() throws Modulo7InvalidMusicXMLFile, Modulo7NoSuchFileException {

        final String basicScoreData = "./src/test/testdata/musicxml/musicXMLTest.xml";
        BasicMusicXMLParser xmlParser = new BasicMusicXMLParser(basicScoreData);

        Song song = xmlParser.getSongRepresentation();

        Lyrics lyrics = song.getLyrics();
        Assert.assertEquals(lyrics.getLyricsOfSong().split("\\s+").length, 4);
    }
}