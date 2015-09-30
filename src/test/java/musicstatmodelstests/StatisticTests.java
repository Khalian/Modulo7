package musicstatmodelstests;

import com.modulo7.common.interfaces.AbstractStatistic;
import com.modulo7.crawler.utils.MusicSources;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;
import com.modulo7.musicstatmodels.statistics.NumVoices;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by asanyal on 9/30/15.
 *
 * Test cases for statistics
 */
public class StatisticTests {

    /**
     * A sanity test case for statistic for number of voices
     */
    @Test
    public void numVoicesSanityTest() {
        Voice v1 = new Voice();

        final Song newSong = new Song(v1, MusicSources.UNKNOWN);

        AbstractStatistic<Double> numVoiceStat = new NumVoices();

        Assert.assertEquals(numVoiceStat.getStatistic(newSong), 1.0, 0.0);
    }
}
