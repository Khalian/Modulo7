import com.modulo7.common.exceptions.Modulo7BadIntervalException;
import com.modulo7.common.exceptions.Modulo7InvalidLineInstantSizeException;
import com.modulo7.common.interfaces.AbstractSimilarity;
import com.modulo7.crawler.utils.MusicSources;
import com.modulo7.musicstatmodels.representation.buildingblocks.Note;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;
import com.modulo7.musicstatmodels.representation.monophonic.VoiceInstant;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;
import com.modulo7.musicstatmodels.similarity.RawMelodicEditDistanceSimilarity;
import junit.framework.Assert;
import org.junit.Test;

import java.util.HashSet;

/**
 * Created by asanyal on 9/17/15.
 *
 * Test cases for similarity measures
 */
public class SimilarityTests {

    @Test
    public void leveinsteinSanityTest() throws Modulo7InvalidLineInstantSizeException, Modulo7BadIntervalException {

        AbstractSimilarity similarity = new RawMelodicEditDistanceSimilarity();

        Voice newVoice = new Voice();
        newVoice.addVoiceInstant(new VoiceInstant(Note.A0));
        newVoice.addVoiceInstant(new VoiceInstant(Note.C0));
        newVoice.addVoiceInstant(new VoiceInstant(Note.B0));

        HashSet<Note> newNoteMap = new HashSet<>();
        newNoteMap.add(Note.C0);
        newNoteMap.add(Note.E0);
        newNoteMap.add(Note.G0);

        newVoice.addVoiceInstant(new VoiceInstant(newNoteMap));

        Song onlySong = new Song(newVoice, MusicSources.UNKNOWN);

        Assert.assertEquals(similarity.getSimilarity(onlySong, onlySong), 1.0);
    }
}
