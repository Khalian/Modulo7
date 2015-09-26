package musicstatmodelstests;

import com.modulo7.common.exceptions.Modulo7BadIntervalException;
import com.modulo7.common.exceptions.Modulo7InvalidVoiceInstantSizeException;
import com.modulo7.common.interfaces.AbstractContour;
import com.modulo7.common.interfaces.AbstractVoiceSimilarity;
import com.modulo7.musicstatmodels.representation.buildingblocks.Note;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;
import com.modulo7.musicstatmodels.representation.monophonic.VoiceInstant;
import com.modulo7.musicstatmodels.similarity.voicesimilarity.GrossCountourSimilarity;
import com.modulo7.musicstatmodels.similarity.voicesimilarity.RawMelodicEditDistanceSimilarity;
import com.modulo7.musicstatmodels.vectorspacemodels.contour.GrossContour;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by asanyal on 9/17/15.
 *
 * Test cases for similarity measures
 */
public class SimilarityTests {

    /**
     * Sanity test for the leveinstein distance measure
     *
     * @throws Modulo7InvalidVoiceInstantSizeException
     * @throws Modulo7BadIntervalException
     */
    @Test
    public void leveinsteinSimilaritySanityTest() throws Modulo7InvalidVoiceInstantSizeException, Modulo7BadIntervalException {

        AbstractVoiceSimilarity similarity = new RawMelodicEditDistanceSimilarity();

        Voice newVoice = new Voice();
        newVoice.addVoiceInstant(new VoiceInstant(Note.A0));
        newVoice.addVoiceInstant(new VoiceInstant(Note.C0));
        newVoice.addVoiceInstant(new VoiceInstant(Note.B0));

        Assert.assertEquals(similarity.getSimilarity(newVoice, newVoice), 1.0, 0.0);
    }

    /**
     * Sanity tests for gross contour similarity measure
     * @throws Modulo7InvalidVoiceInstantSizeException
     */
    @Test
    public void grossContourSimilaritySanityTest() throws Modulo7InvalidVoiceInstantSizeException {
        Voice newVoice = new Voice();

        newVoice.addVoiceInstant(new VoiceInstant(Note.A0));
        newVoice.addVoiceInstant(new VoiceInstant(Note.B0));
        newVoice.addVoiceInstant(new VoiceInstant(Note.C0));

        Voice newVoice2 = new Voice();

        newVoice2.addVoiceInstant(new VoiceInstant(Note.A0));
        newVoice2.addVoiceInstant(new VoiceInstant(Note.C0));
        newVoice2.addVoiceInstant(new VoiceInstant(Note.E0));

        AbstractContour<String> grossContour = new GrossContour();
        final String contour1 = grossContour.getContourRepresentaionOfVoice(newVoice);
        final String contour2 = grossContour.getContourRepresentaionOfVoice(newVoice2);

        // First check if both contours are same or not
        Assert.assertEquals(contour1, contour2);

        AbstractVoiceSimilarity contourSim = new GrossCountourSimilarity();

        Assert.assertEquals(contourSim.getSimilarity(newVoice, newVoice2), 1.0, 0.0);
    }
}
