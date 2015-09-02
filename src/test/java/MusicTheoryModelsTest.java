import com.modulo7.common.exceptions.Modulo7BadIntervalException;
import com.modulo7.musicstatmodels.musictheorymodels.Interval;
import com.modulo7.musicstatmodels.musictheorymodels.IntervalEnum;
import com.modulo7.musicstatmodels.representation.ChordType;
import com.modulo7.musicstatmodels.representation.Note;
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
        Assert.assertEquals(Interval.getInterval(Note.A0, Note.B0).getInterval(), IntervalEnum.MAJOR_SECOND);
        Assert.assertEquals(Interval.getInterval(Note.A1, Note.CSHARP1).getInterval(), IntervalEnum.MAJOR_THIRD);
    }

    /**
     * Unit test cases to test for chord
     */
    @Test
    public void testChordID() throws Modulo7BadIntervalException {
        Set<Note> setOfMajorNotes = new HashSet<>();

        setOfMajorNotes.add(Note.G1);
        setOfMajorNotes.add(Note.B2);
        setOfMajorNotes.add(Note.D2);

        Assert.assertEquals(ChordType.MAJOR, ChordType.estimateChordType(setOfMajorNotes));

        Set<Note> setOfMinorNotes = new HashSet<>();

        setOfMinorNotes.add(Note.G1);
        setOfMinorNotes.add(Note.ASHARP2);
        setOfMinorNotes.add(Note.D2);

        Assert.assertEquals(ChordType.MINOR, ChordType.estimateChordType(setOfMinorNotes));

        // Construct a bad triad and test it
        Set<Note> badNotes = new HashSet<>();
        badNotes.add(Note.A0);
        badNotes.add(Note.ASHARP0);
        badNotes.add(Note.B0);

        Assert.assertNotSame(ChordType.MINOR, ChordType.estimateChordType(badNotes));
        Assert.assertNotSame(ChordType.MAJOR, ChordType.estimateChordType(badNotes));
    }
}
