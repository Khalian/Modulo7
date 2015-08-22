import com.modulo7.common.exceptions.Modulo7BadIntervalException;
import com.modulo7.musicstatmodels.musictheorymodels.Interval;
import com.modulo7.musicstatmodels.musictheorymodels.IntervalEnum;
import com.modulo7.musicstatmodels.representation.Note;
import junit.framework.Assert;
import org.junit.Test;

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
        Assert.assertEquals(Interval.getInterval(Note.A1, Note.B3).getInterval(), );
    }
}
