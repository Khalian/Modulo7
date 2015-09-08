import com.modulo7.common.exceptions.Modulo7NoSuchFileException;
import com.modulo7.common.interfaces.AbstractAnalyzer;
import com.modulo7.acoustics.MidiToSongConverter;
import com.modulo7.musicstatmodels.representation.Song;
import junit.framework.Assert;
import org.junit.Test;

import javax.sound.midi.InvalidMidiDataException;
import java.io.IOException;

/**
 * Created by asanyal on 8/20/15.
 *
 * Test cases related to parsing the midi format
 */
public class MidiTest {

    /**
     * A basic test to sanity test whether a midi parser works or not
     *
     * @throws Modulo7NoSuchFileException
     * @throws InvalidMidiDataException
     */
    @Test
    public void midiSanityTest() throws InvalidMidiDataException, Modulo7NoSuchFileException {
        final String midiLocation = "./src/test/testdata/midi/test.mid";
        AbstractAnalyzer midiAnalyzer = new MidiToSongConverter(midiLocation);

        Song song = midiAnalyzer.getSongRepresentation();

        Assert.assertNotNull(song);
    }
}
