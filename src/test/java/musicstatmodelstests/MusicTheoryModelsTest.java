package musicstatmodelstests;

import com.modulo7.common.exceptions.Modulo7BadIntervalException;
import com.modulo7.musicstatmodels.musictheorymodels.Interval;
import com.modulo7.musicstatmodels.musictheorymodels.IntervalQuantity;
import com.modulo7.musicstatmodels.musictheorymodels.KKTonalityProfiles;
import com.modulo7.musicstatmodels.representation.buildingblocks.ChordQuality;
import com.modulo7.musicstatmodels.representation.buildingblocks.Note;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by asanyal on 8/21/15.
 *
 * This class represents the test cases associated with music theory models
 */
public class MusicTheoryModelsTest {

    /**
     * Test cases for intervals
     * @throws Modulo7BadIntervalException
     */
    @Test
    public void testIntervals() throws Modulo7BadIntervalException {
        Assert.assertEquals(Interval.getInterval(Note.A0, Note.B0).getIntervalQuantity(), IntervalQuantity.MAJOR_SECOND);
        Assert.assertEquals(Interval.getInterval(Note.A1, Note.CSHARP1).getIntervalQuantity(), IntervalQuantity.MAJOR_THIRD);
        Assert.assertEquals(Interval.getInterval(Note.A2, Note.DSHARP2).getIntervalQuantity(), IntervalQuantity.AUGMENTED_FOURTH);
        Assert.assertEquals(Interval.getInterval(Note.B0, Note.B0).getIntervalQuantity(), IntervalQuantity.PERFECT_UNISON);
        Assert.assertEquals(Interval.getInterval(Note.CSHARP4, Note.GSHARP4).getIntervalQuantity(), IntervalQuantity.PERFECT_FIFTH);
    }

    /**
     * Unit test cases for chord quality Identification
     * @throws Modulo7BadIntervalException
     */
    @Test
    public void testChordQualityID() throws Modulo7BadIntervalException {
        Set<Note> setOfMajorNotes = new HashSet<>();

        setOfMajorNotes.add(Note.G1);
        setOfMajorNotes.add(Note.B2);
        setOfMajorNotes.add(Note.D2);

        Assert.assertEquals(ChordQuality.MAJOR, ChordQuality.estimateChordType(setOfMajorNotes));

        Set<Note> setOfMinorNotes = new HashSet<>();

        setOfMinorNotes.add(Note.G1);
        setOfMinorNotes.add(Note.ASHARP2);
        setOfMinorNotes.add(Note.D2);

        Assert.assertEquals(ChordQuality.MINOR, ChordQuality.estimateChordType(setOfMinorNotes));

        // Construct a bad triad and test it
        Set<Note> badNotes = new HashSet<>();
        badNotes.add(Note.A0);
        badNotes.add(Note.ASHARP0);
        badNotes.add(Note.B0);

        Assert.assertNotSame(ChordQuality.MINOR, ChordQuality.estimateChordType(badNotes));
        Assert.assertNotSame(ChordQuality.MAJOR, ChordQuality.estimateChordType(badNotes));
    }

    /**
     * Test cases for the KK Tonality profiles models
     */
    @Test
    public void kkTonalityProfilesTest() {
        Double[] array = {2.88, 6.35, 2.23, 3.48, 2.33, 4.38, 4.09, 2.52, 5.19, 2.39, 3.66, 2.29};

        Assert.assertArrayEquals(KKTonalityProfiles.MAJOR_CHORD_PROFILES.get("C#").
                toArray(new Double[KKTonalityProfiles.MAJOR_CHORD_PROFILES.get("C#").size()]), array);
    }
}
