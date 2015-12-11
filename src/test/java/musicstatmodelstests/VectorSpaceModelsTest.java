package musicstatmodelstests;

import com.modulo7.common.exceptions.Modulo7BadNoteException;
import com.modulo7.common.exceptions.Modulo7InvalidVoiceInstantSizeException;
import com.modulo7.common.interfaces.*;
import com.modulo7.common.utils.MusicSources;
import com.modulo7.musicstatmodels.musictheorymodels.IntervalQuantity;
import com.modulo7.musicstatmodels.representation.buildingblocks.Note;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;
import com.modulo7.musicstatmodels.representation.monophonic.VoiceInstant;
import com.modulo7.musicstatmodels.similarity.voicesimilarity.VoiceTonalHistogramSimilarity;
import com.modulo7.musicstatmodels.vectorspacemodels.contour.voicecontour.GrossContour;
import com.modulo7.musicstatmodels.vectorspacemodels.contour.voicecontour.MullensiefenContour;
import com.modulo7.musicstatmodels.vectorspacemodels.contour.voicecontour.SteinbeckContour;
import com.modulo7.musicstatmodels.vectorspacemodels.datastructures.TonalDurationHistogramData;
import com.modulo7.musicstatmodels.vectorspacemodels.datastructures.TonalHistogramData;
import com.modulo7.musicstatmodels.vectorspacemodels.vectorspacerepresentations.songvectors.TonalDurationHistogram;
import com.modulo7.musicstatmodels.vectorspacemodels.vectorspacerepresentations.songvectors.TonalHistogram;
import com.modulo7.musicstatmodels.vectorspacemodels.vectorspacerepresentations.voicevectors.VoiceIntervalPitchVector;
import com.modulo7.musicstatmodels.vectorspacemodels.vectorspacerepresentations.voicevectors.VoiceRawPitchVector;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * Created by asanyal on 9/4/15.
 *
 * Test cases for vector space models
 */
public class VectorSpaceModelsTest {

    /**
     * Check if the steinbeck contour coded up is actually working or not
     * In this particular melody, there are no contour
     */
    @Test
    public void steinBeckContourSanityTest() throws Modulo7InvalidVoiceInstantSizeException, Modulo7BadNoteException {
        Voice testVoice = new Voice();
        testVoice.addVoiceInstant(new VoiceInstant(Note.ASHARP0));
        testVoice.addVoiceInstant(new VoiceInstant(Note.B0));
        testVoice.addVoiceInstant(new VoiceInstant(Note.C0));
        testVoice.addVoiceInstant(new VoiceInstant(Note.CSHARP0));
        testVoice.addVoiceInstant(new VoiceInstant(Note.D0));

        AbstractContour contour = new SteinbeckContour();
        Map<Integer, VoiceInstant> contourRep = contour.getContourRepresentaionOfVoice(testVoice);

        Assert.assertEquals(contourRep.size(), 0);
    }

    /**
     * A test in which there is a valid contour element present and that element is removed
     * There are two contour extremum notes in this melody
     *
     * @throws com.modulo7.common.exceptions.Modulo7InvalidVoiceInstantSizeException
     */
    @Test
    public void steinbeckContour() throws Modulo7InvalidVoiceInstantSizeException, Modulo7BadNoteException {
        Voice testVoice = new Voice();
        testVoice.addVoiceInstant(new VoiceInstant(Note.ASHARP1));
        testVoice.addVoiceInstant(new VoiceInstant(Note.B1));
        testVoice.addVoiceInstant(new VoiceInstant(Note.C0));
        testVoice.addVoiceInstant(new VoiceInstant(Note.CSHARP1));
        testVoice.addVoiceInstant(new VoiceInstant(Note.D1));

        AbstractContour contour = new SteinbeckContour();
        Map<Integer, VoiceInstant> contourRep = contour.getContourRepresentaionOfVoice(testVoice);

        Assert.assertEquals(contourRep.size(), 1);
    }

    /**
     * Sanity test cases for voice pitch vectors
     *
     * @throws com.modulo7.common.exceptions.Modulo7InvalidVoiceInstantSizeException
     */
    @Test
    public void voiceVectorPitchSanityTest() throws Modulo7InvalidVoiceInstantSizeException, Modulo7BadNoteException {
        Voice testVoice = new Voice();
        testVoice.addVoiceInstant(new VoiceInstant(Note.ASHARP1));
        testVoice.addVoiceInstant(new VoiceInstant(Note.B1));
        testVoice.addVoiceInstant(new VoiceInstant(Note.C0));
        testVoice.addVoiceInstant(new VoiceInstant(Note.CSHARP1));
        testVoice.addVoiceInstant(new VoiceInstant(Note.D1));

        AbstractVoiceVector pitchVector = new VoiceRawPitchVector();
        pitchVector.computeVectorRepresentation(testVoice);

        Assert.assertEquals(pitchVector.getVectorLength(), 5);

        AbstractVoiceVector intervalVector = new VoiceIntervalPitchVector();
        intervalVector.computeVectorRepresentation(testVoice);

        Assert.assertEquals(intervalVector.getVectorLength(), 4);
    }

    /**
     * Sanity test cases for song vectors
     * @throws com.modulo7.common.exceptions.Modulo7InvalidVoiceInstantSizeException
     */
    @Test
    public void songVectorSanityTest() throws Modulo7InvalidVoiceInstantSizeException, Modulo7BadNoteException {
        Voice testVoice1 = new Voice();

        testVoice1.addVoiceInstant(new VoiceInstant(Note.ASHARP1));
        testVoice1.addVoiceInstant(new VoiceInstant(Note.B1));
        testVoice1.addVoiceInstant(new VoiceInstant(Note.C0));
        testVoice1.addVoiceInstant(new VoiceInstant(Note.CSHARP1));
        testVoice1.addVoiceInstant(new VoiceInstant(Note.D1));

        Voice testVoice2 = new Voice();

        testVoice2.addVoiceInstant(new VoiceInstant(Note.ASHARP1));
        testVoice2.addVoiceInstant(new VoiceInstant(Note.B1));
        testVoice2.addVoiceInstant(new VoiceInstant(Note.C0));
        testVoice2.addVoiceInstant(new VoiceInstant(Note.CSHARP1));
        testVoice2.addVoiceInstant(new VoiceInstant(Note.D1));

        HashSet<Voice> voiceHashSet = new HashSet<>();
        voiceHashSet.add(testVoice1);
        voiceHashSet.add(testVoice2);

        Song song = new Song(voiceHashSet, MusicSources.UNKNOWN);

        AbstractSongVector<TonalHistogramData> histogram = new TonalHistogram();
        histogram.computeVectorRepresentation(song);

        TonalHistogramData data = histogram.getInternalRepresentation();

        Assert.assertEquals(data.getSize(), 13);
        List<Number> intervalArrayRep = data.getArrayRepresentation();
        Assert.assertEquals(intervalArrayRep.size(), 13);
        Assert.assertEquals(data.getCountForInterval(IntervalQuantity.MINOR_SECOND), 6);
        Assert.assertEquals(data.getHistogramTotalSum(), 8);    
    }

    /**
     * This method tests the tonal duration histogram vector model
     * and sanity tests whether the cumulative durations are properly accounted for
     */
    @Test
    public void tonalDurationHistogramDataSanityTest() throws Modulo7InvalidVoiceInstantSizeException, Modulo7BadNoteException {
        Voice testVoice1 = new Voice();

        testVoice1.addVoiceInstant(new VoiceInstant(Note.ASHARP1, 1.0));
        testVoice1.addVoiceInstant(new VoiceInstant(Note.B1, 1.0));
        testVoice1.addVoiceInstant(new VoiceInstant(Note.C0, 1.0));
        testVoice1.addVoiceInstant(new VoiceInstant(Note.CSHARP1, 1.0));
        testVoice1.addVoiceInstant(new VoiceInstant(Note.D1, 1.0));

        Voice testVoice2 = new Voice();

        testVoice2.addVoiceInstant(new VoiceInstant(Note.ASHARP1, 1.0));
        testVoice2.addVoiceInstant(new VoiceInstant(Note.B1, 1.0));
        testVoice2.addVoiceInstant(new VoiceInstant(Note.C0, 1.0));
        testVoice2.addVoiceInstant(new VoiceInstant(Note.CSHARP1, 1.0));
        testVoice2.addVoiceInstant(new VoiceInstant(Note.D1, 1.0));

        HashSet<Voice> setOfVoices = new HashSet<>();
        setOfVoices.add(testVoice1);
        setOfVoices.add(testVoice2);

        final Song song = new Song(setOfVoices, MusicSources.UNKNOWN);

        AbstractSongVector<TonalDurationHistogramData> histogram = new TonalDurationHistogram();
        histogram.computeVectorRepresentation(song);

        TonalDurationHistogramData data = histogram.getInternalRepresentation();
        Assert.assertEquals(data.getCumulativeDuration(), 8.0, 0.0);

        // Max of both is voice lenths = max (4, 4)
        Assert.assertEquals(song.getTotalSongDuration(), 4.0, 0.0);

        // The minor seconds have a total tonal histogram duration of 6.0 in the above test creation
        Assert.assertEquals(histogram.getInternalRepresentation().getData(IntervalQuantity.MINOR_SECOND), 6.0, 0.0);
    }

    /**
     * Sanity test case for gross contour
     * @throws com.modulo7.common.exceptions.Modulo7InvalidVoiceInstantSizeException
     */
    @Test
    public void grossContourSanityTest() throws Modulo7InvalidVoiceInstantSizeException, Modulo7BadNoteException {
        Voice testVoice1 = new Voice();

        testVoice1.addVoiceInstant(new VoiceInstant(Note.ASHARP1, 1.0));
        testVoice1.addVoiceInstant(new VoiceInstant(Note.B1, 1.0));
        testVoice1.addVoiceInstant(new VoiceInstant(Note.C0, 1.0));
        testVoice1.addVoiceInstant(new VoiceInstant(Note.CSHARP1, 1.0));
        testVoice1.addVoiceInstant(new VoiceInstant(Note.D1, 1.0));

        AbstractStringContour contour = new GrossContour();

        String contourRep = contour.getContourRepresentaionOfVoice(testVoice1);

        Assert.assertEquals(contourRep, "U D U U");
    }

    /**
     * Sanity test for voice tonal histogram similarity
     * @throws Modulo7InvalidVoiceInstantSizeException
     */
    @Test
    public void voiceTonalSanitylHistogramSimilarity() throws Modulo7InvalidVoiceInstantSizeException, Modulo7BadNoteException {
        Voice testVoice1 = new Voice();

        testVoice1.addVoiceInstant(new VoiceInstant(Note.ASHARP1, 1.0));
        testVoice1.addVoiceInstant(new VoiceInstant(Note.B1, 1.0));
        testVoice1.addVoiceInstant(new VoiceInstant(Note.C1, 1.0));
        testVoice1.addVoiceInstant(new VoiceInstant(Note.CSHARP1, 1.0));
        testVoice1.addVoiceInstant(new VoiceInstant(Note.D1, 1.0));

        // Similarity based on voices having the same tonal histogram
        AbstractVoiceSimilarity similarity = new VoiceTonalHistogramSimilarity();

        Voice testVoice2 = new Voice();

        testVoice2.addVoiceInstant(new VoiceInstant(Note.B1, 1.0));
        testVoice2.addVoiceInstant(new VoiceInstant(Note.C1, 1.0));
        testVoice2.addVoiceInstant(new VoiceInstant(Note.CSHARP1, 1.0));
        testVoice2.addVoiceInstant(new VoiceInstant(Note.D1, 1.0));
        testVoice2.addVoiceInstant(new VoiceInstant(Note.DSHARP1, 1.0));

        // Check if they both have the exact same histogram
        Assert.assertEquals(similarity.getSimilarity(testVoice1, testVoice2), 1.0, 0.0);
    }

    /**
     * Test case for mullensiefen contour
     */
    @Test
    public void mullensiefenContourTest() throws Modulo7InvalidVoiceInstantSizeException, Modulo7BadNoteException {
        Voice testVoice = new Voice();
        testVoice.addVoiceInstant(new VoiceInstant(Note.ASHARP1));
        testVoice.addVoiceInstant(new VoiceInstant(Note.B1));
        testVoice.addVoiceInstant(new VoiceInstant(Note.C0));
        testVoice.addVoiceInstant(new VoiceInstant(Note.B1));
        testVoice.addVoiceInstant(new VoiceInstant(Note.D1));

        AbstractContour contour = new MullensiefenContour();
        Map<Integer, VoiceInstant> contourRep = contour.getContourRepresentaionOfVoice(testVoice);

        Assert.assertEquals(contourRep.size(), 1);
    }
}