import com.modulo7.common.exceptions.Modulo7BadIntervalException;
import com.modulo7.musicstatmodels.musictheorymodels.Interval;
import com.modulo7.musicstatmodels.musictheorymodels.IntervalEnum;
import com.modulo7.musicstatmodels.representation.buildingblocks.ChordQuality;
import com.modulo7.musicstatmodels.representation.buildingblocks.Note;
import junit.framework.Assert;
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
        Assert.assertEquals(Interval.getInterval(Note.A0, Note.B0).getIntervalEnum(), IntervalEnum.MAJOR_SECOND);
        Assert.assertEquals(Interval.getInterval(Note.A1, Note.CSHARP1).getIntervalEnum(), IntervalEnum.MAJOR_THIRD);
        Assert.assertEquals(Interval.getInterval(Note.A2, Note.DSHARP2).getIntervalEnum(), IntervalEnum.AUGMENTED_FOURTH);
        Assert.assertEquals(Interval.getInterval(Note.B0, Note.B0).getIntervalEnum(), IntervalEnum.PERFECT_UNISON);
        Assert.assertEquals(Interval.getInterval(Note.CSHARP4, Note.GSHARP4).getIntervalEnum(), IntervalEnum.PERFECT_FIFTH);
    }

    /**
     * Unit test cases to test for chord auality identification
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
}
