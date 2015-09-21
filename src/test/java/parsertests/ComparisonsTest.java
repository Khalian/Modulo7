package parsertests;

import com.echonest.api.v4.EchoNestException;
import com.modulo7.acoustics.EchoNestBasicMP3Analyzer;
import com.modulo7.acoustics.MidiToSongConverter;
import com.modulo7.common.exceptions.Modulo7NoSuchFileException;
import com.modulo7.common.interfaces.AbstractAnalyzer;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;
import org.junit.Assert;
import org.junit.Test;

import javax.sound.midi.InvalidMidiDataException;
import java.io.IOException;

/**
 * Created by asanyal on 9/6/15.
 *
 * Basic comparison tests for midi and mp3 on data that is perfectly aligned
 *
 * In general this class will include checks on different sources that are aligned
 */
public class ComparisonsTest {

    @Test
    public void midiMp3Comparison() throws EchoNestException, Modulo7NoSuchFileException, InvalidMidiDataException, IOException {

        final String mp3Location = "./src/test/testdata/mp3/Bach_SMD.mp3";
        AbstractAnalyzer mp3Analyzer = new EchoNestBasicMP3Analyzer(mp3Location);
        final Song mp3Song = mp3Analyzer.getSongRepresentation();

        final String midiLocation = "./src/test/testdata/midi/Bach_SMD.mid";
        AbstractAnalyzer midiAnalyzer = new MidiToSongConverter(midiLocation);
        final Song midiSong = midiAnalyzer.getSongRepresentation();

        // Since the tracks are aligned the number of voices should be the same
        Assert.assertEquals(mp3Song.getNumVoices(), midiSong.getNumVoices());
    }
}
