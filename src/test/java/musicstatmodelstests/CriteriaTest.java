package musicstatmodelstests;

import com.modulo7.common.exceptions.Modulo7BadKeyException;
import com.modulo7.common.exceptions.Modulo7InvalidVoiceInstantSizeException;
import com.modulo7.crawler.utils.MusicSources;
import com.modulo7.common.interfaces.AbstractCriteria;
import com.modulo7.musicstatmodels.criteria.KeySignatureEqualityCriteria;
import com.modulo7.musicstatmodels.criteria.PolyphonyCriteria;
import com.modulo7.musicstatmodels.representation.buildingblocks.Note;
import com.modulo7.musicstatmodels.representation.metadata.KeySignature;
import com.modulo7.musicstatmodels.representation.metadata.ScaleType;
import com.modulo7.musicstatmodels.representation.metadata.SongMetadata;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;
import com.modulo7.musicstatmodels.representation.monophonic.VoiceInstant;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

/**
 * Created by asanyal on 9/16/15
 *
 * This test
 */
public class CriteriaTest {

    /**
     * Check if a song is polyphonic and or homophonic
     * @throws com.modulo7.common.exceptions.Modulo7InvalidVoiceInstantSizeException
     */
    @Test
    public void polyphonyCriteriaTest() throws Modulo7InvalidVoiceInstantSizeException {
        AbstractCriteria criteria = new PolyphonyCriteria();

        Voice voice = new Voice();
        voice.addVoiceInstant(new VoiceInstant(Note.A0));

        Song song = new Song(voice, MusicSources.UNKNOWN);

        Assert.assertFalse(criteria.getCriteriaEvaluation(song));

        Voice voice1 = new Voice();
        voice1.addVoiceInstant(new VoiceInstant(Note.A1));

        HashSet<Voice> newSongSet = new HashSet<>();
        newSongSet.add(voice);
        newSongSet.add(voice1);

        Song newSong = new Song(newSongSet, MusicSources.UNKNOWN);

        Assert.assertTrue(criteria.getCriteriaEvaluation(newSong));
    }

    /**
     * Checks the key signature equality criteria
     *
     * @throws Modulo7BadKeyException
     * @throws com.modulo7.common.exceptions.Modulo7InvalidVoiceInstantSizeException
     */
    @Test
    public void keySignatureCriteriaTest() throws Modulo7BadKeyException, Modulo7InvalidVoiceInstantSizeException {
        AbstractCriteria criteria = new KeySignatureEqualityCriteria(new KeySignature("C", ScaleType.MAJOR));

        Voice voice = new Voice();
        voice.addVoiceInstant(new VoiceInstant(Note.A0));

        Song song = new Song(voice, new SongMetadata(new KeySignature("C", ScaleType.MAJOR), null), MusicSources.UNKNOWN);

        Assert.assertTrue(criteria.getCriteriaEvaluation(song));

        Song anotherSong = new Song(voice, new SongMetadata(new KeySignature("B", ScaleType.MINOR), null), MusicSources.UNKNOWN);

        Assert.assertFalse(criteria.getCriteriaEvaluation(anotherSong));
    }
}
