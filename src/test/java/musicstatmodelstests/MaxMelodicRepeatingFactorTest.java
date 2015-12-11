package musicstatmodelstests;

import com.modulo7.common.exceptions.Modulo7BadNoteException;
import com.modulo7.common.exceptions.Modulo7InvalidVoiceInstantSizeException;
import com.modulo7.common.interfaces.AbstractStatistic;
import com.modulo7.common.utils.MusicSources;
import com.modulo7.musicstatmodels.representation.buildingblocks.Note;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;
import com.modulo7.musicstatmodels.representation.monophonic.VoiceInstant;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;
import com.modulo7.musicstatmodels.statistics.MaxMelodicRepeatingFactor;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by asanyal on 9/24/15.
 *
 * Test cases for max melodic repeating factor
 */
public class MaxMelodicRepeatingFactorTest {

    @Test
    public void maxMelodicRepeatingFactor() throws Modulo7InvalidVoiceInstantSizeException, Modulo7BadNoteException {
        AbstractStatistic<Double> maxMelodicRepeatingFactor = new MaxMelodicRepeatingFactor();

        Voice testVoice = new Voice();
        testVoice.addVoiceInstant(new VoiceInstant(Note.A0));
        testVoice.addVoiceInstant(new VoiceInstant(Note.A0));
        testVoice.addVoiceInstant(new VoiceInstant(Note.C0));
        testVoice.addVoiceInstant(new VoiceInstant(Note.A0));
        testVoice.addVoiceInstant(new VoiceInstant(Note.A0));

        Song testSong = new Song(testVoice, MusicSources.UNKNOWN);

        Double repeatingFraction = maxMelodicRepeatingFactor.getStatistic(testSong);

        Assert.assertEquals(repeatingFraction, 0.4, 0.0);
    }
}
