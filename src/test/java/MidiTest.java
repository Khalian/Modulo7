import com.modulo7.acoustics.AbstractAnalyzer;
import com.modulo7.acoustics.MidiToSongConverter;
import com.modulo7.musicstatmodels.representation.Song;
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
     * @throws InvalidMidiDataException
     * @throws IOException
     */
    @Test
    public void midiSanityTest() throws InvalidMidiDataException, IOException {
        final String midiLocation = "./src/test/testdata/midi/test.mid";
        AbstractAnalyzer acousticsAnalyzer = new MidiToSongConverter(midiLocation);

        Song song = acousticsAnalyzer.getSongRepresentation();
    }
}
