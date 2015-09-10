import com.modulo7.common.exceptions.Modulo7InvalidLineInstantSizeException;
import com.modulo7.common.interfaces.AbstractContour;
import com.modulo7.common.interfaces.AbstractSongVector;
import com.modulo7.common.interfaces.AbstractVoiceVector;
import com.modulo7.crawler.utils.MusicSources;
import com.modulo7.musicstatmodels.musictheorymodels.IntervalEnum;
import com.modulo7.musicstatmodels.representation.Note;
import com.modulo7.musicstatmodels.representation.Song;
import com.modulo7.musicstatmodels.representation.Voice;
import com.modulo7.musicstatmodels.representation.VoiceInstant;
import com.modulo7.musicstatmodels.vectorspacemodels.contour.SteinbeckContour;
import com.modulo7.musicstatmodels.vectorspacemodels.datastructures.TonalHistogramData;
import com.modulo7.musicstatmodels.vectorspacemodels.vectorspacerepresentations.songvectors.TonalHistogram;
import com.modulo7.musicstatmodels.vectorspacemodels.vectorspacerepresentations.voicevectors.VoiceIntervalPitchVector;
import com.modulo7.musicstatmodels.vectorspacemodels.vectorspacerepresentations.voicevectors.VoiceRawPitchVector;
import junit.framework.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;

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
    public void steinBeckContourSanityTest() throws Modulo7InvalidLineInstantSizeException {
        Voice testVoice = new Voice();
        testVoice.addVoiceInstant(new VoiceInstant(Note.ASHARP0));
        testVoice.addVoiceInstant(new VoiceInstant(Note.B0));
        testVoice.addVoiceInstant(new VoiceInstant(Note.C0));
        testVoice.addVoiceInstant(new VoiceInstant(Note.CSHARP0));
        testVoice.addVoiceInstant(new VoiceInstant(Note.D0));

        AbstractContour contour = new SteinbeckContour();
        Voice newContourizedVoice = contour.getContourRepresentaionOfVoice(testVoice);

        Assert.assertEquals(newContourizedVoice.getNumVoiceInstantsOfVoice(), 0);
    }

    /**
     * A test in which there is a valid contour element present and that element is removed
     * There are two contour extremum notes in this melody
     *
     * @throws Modulo7InvalidLineInstantSizeException
     */
    @Test
    public void contourizedVoiceTest() throws Modulo7InvalidLineInstantSizeException{
        Voice testVoice = new Voice();
        testVoice.addVoiceInstant(new VoiceInstant(Note.ASHARP1));
        testVoice.addVoiceInstant(new VoiceInstant(Note.B1));
        testVoice.addVoiceInstant(new VoiceInstant(Note.C0));
        testVoice.addVoiceInstant(new VoiceInstant(Note.CSHARP1));
        testVoice.addVoiceInstant(new VoiceInstant(Note.D1));

        AbstractContour contour = new SteinbeckContour();
        Voice newContourizedVoice = contour.getContourRepresentaionOfVoice(testVoice);

        Assert.assertEquals(newContourizedVoice.getNumVoiceInstantsOfVoice(), 2);
    }

    /**
     * Sanity test cases for voice pitch vectors
     *
     * @throws Modulo7InvalidLineInstantSizeException
     */
    @Test
    public void voiceVectorPitchSanityTest() throws Modulo7InvalidLineInstantSizeException {
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
     * @throws Modulo7InvalidLineInstantSizeException
     */
    @Test
    public void songVectorSanityTest() throws Modulo7InvalidLineInstantSizeException {
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
        List<Integer> intervalArrayRep = data.getArrayRepresentation();
        Assert.assertEquals(intervalArrayRep.size(), 13);
        Assert.assertEquals(data.getCountForInterval(IntervalEnum.MINOR_SECOND), 6);
        Assert.assertEquals(data.getHistogramTotalSum(), 8);    
    }
}
