package parsertests;

import com.modulo7.common.exceptions.Modulo7NoSuchFileOrDirectoryException;
import com.modulo7.common.interfaces.AbstractAnalyzer;
import com.modulo7.acoustics.MidiToSongConverter;
import com.modulo7.crawler.utils.MusicSources;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;
import org.junit.Assert;
import org.junit.Test;

import javax.sound.midi.InvalidMidiDataException;

/**
 * Created by asanyal on 8/20/15.
 *
 * Test cases related to parsing the midi format
 */
public class MidiTest {

    /**
     * A basic test to sanity test whether a midi parser works or not
     *
     * @throws com.modulo7.common.exceptions.Modulo7NoSuchFileOrDirectoryException
     * @throws InvalidMidiDataException
     */
    @Test
    public void midiSanityTest() throws InvalidMidiDataException, Modulo7NoSuchFileOrDirectoryException {
        final String midiLocation = "./src/test/testdata/midi/test.mid";
        AbstractAnalyzer midiAnalyzer = new MidiToSongConverter(midiLocation);

        Song song = midiAnalyzer.getSongRepresentation();

        Assert.assertNotNull(song);
        Assert.assertEquals(song.getSource(), MusicSources.MIDI);
    }
}
