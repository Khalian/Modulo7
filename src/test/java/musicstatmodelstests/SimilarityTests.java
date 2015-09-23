package musicstatmodelstests;

import com.modulo7.common.exceptions.Modulo7BadIntervalException;
import com.modulo7.common.exceptions.Modulo7InvalidVoiceInstantSizeException;
import com.modulo7.common.interfaces.AbstractVoiceSimilarity;
import com.modulo7.musicstatmodels.representation.buildingblocks.Note;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;
import com.modulo7.musicstatmodels.representation.monophonic.VoiceInstant;
import com.modulo7.musicstatmodels.similarity.voicesimilarity.RawMelodicEditDistanceSimilarity;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by asanyal on 9/17/15.
 *
 * Test cases for similarity measures
 */
public class SimilarityTests {

    @Test
    public void leveinsteinSanityTest() throws Modulo7InvalidVoiceInstantSizeException, Modulo7BadIntervalException {

        AbstractVoiceSimilarity similarity = new RawMelodicEditDistanceSimilarity();

        Voice newVoice = new Voice();
        newVoice.addVoiceInstant(new VoiceInstant(Note.A0));
        newVoice.addVoiceInstant(new VoiceInstant(Note.C0));
        newVoice.addVoiceInstant(new VoiceInstant(Note.B0));

        Assert.assertEquals(similarity.getSimilarity(newVoice, newVoice), 1.0);
    }
}
