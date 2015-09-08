import com.modulo7.common.exceptions.Modulo7InvalidLineInstantSizeException;
import com.modulo7.common.interfaces.AbstractContour;
import com.modulo7.musicstatmodels.representation.Note;
import com.modulo7.musicstatmodels.representation.Voice;
import com.modulo7.musicstatmodels.representation.VoiceInstant;
import com.modulo7.musicstatmodels.vectorspacemodels.contour.SteinbeckContour;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by asanyal on 9/4/15.
 *
 * Test cases for vector space models coded
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
}
