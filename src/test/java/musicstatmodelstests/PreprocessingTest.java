package musicstatmodelstests;

import com.modulo7.common.exceptions.*;
import com.modulo7.common.utils.MusicSources;
import com.modulo7.musicstatmodels.preprocessing.TonalityAlignment;
import com.modulo7.musicstatmodels.preprocessing.VoiceToMelodyConversion;
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
 * Created by asanyal on 9/18/15.
 *
 * Test cases for preprocessing
 */
public class PreprocessingTest {

    /**
     * Test case for tonality alignment on a uniform voice
     * 
     * @throws com.modulo7.common.exceptions.Modulo7InvalidVoiceInstantSizeException
     * @throws Modulo7BadKeyException
     * @throws Modulo7BadIntervalException
     * @throws Modulo7BadNoteException
     * @throws Modulo7WrongNoteType
     */
    @Test
    public void tonalityAlignmentSanityTest() throws Modulo7InvalidVoiceInstantSizeException, Modulo7BadKeyException,
            Modulo7BadIntervalException, Modulo7BadNoteException, Modulo7WrongNoteType {

        final Voice voice = new Voice();
        voice.addVoiceInstant(new VoiceInstant(Note.A0));
        voice.addVoiceInstant(new VoiceInstant(Note.A0));
        voice.addVoiceInstant(new VoiceInstant(Note.A0));
        voice.addVoiceInstant(new VoiceInstant(Note.A0));

        Song newSong = TonalityAlignment.alignSong(new Song(voice, new SongMetadata(new KeySignature("A", ScaleType.MAJOR), null),
            MusicSources.UNKNOWN), new KeySignature("C", ScaleType.MAJOR));

        for (final Voice voiceNew : newSong.getVoices()) {
            for (VoiceInstant voiceInstant : voiceNew.getVoiceSequence()) {
                final Note note = voiceInstant.getNote();
                Assert.assertEquals(note, Note.C0);
            }
        }

        Song backTransform = TonalityAlignment.alignSong(newSong, new KeySignature("A", ScaleType.MAJOR));

        for (final Voice voiceOld : backTransform.getVoices()) {
            for (VoiceInstant voiceInstant : voiceOld.getVoiceSequence()) {
                final Note note = voiceInstant.getNote();
                Assert.assertEquals(note, Note.A0);
            }
        }
    }

    /**
     * Sanity test for preprocessing for voice to melody conversion
     *
     * @throws Modulo7InvalidVoiceInstantSizeException
     * @throws Modulo7BadIntervalException
     */
    @Test
    public void voiceToMelodyConversionSanityTest() throws Modulo7InvalidVoiceInstantSizeException, Modulo7BadIntervalException, Modulo7BadNoteException {

        final Voice voice = new Voice();

        voice.addVoiceInstant(new VoiceInstant(Note.A0));
        voice.addVoiceInstant(new VoiceInstant(Note.ASHARP0));
        voice.addVoiceInstant(new VoiceInstant(Note.B0));
        voice.addVoiceInstant(new VoiceInstant(Note.C0));

        HashSet<Note> chord = new HashSet<>();
        chord.add(Note.C0);
        chord.add(Note.E0);
        chord.add(Note.G0);

        voice.addVoiceInstant(new VoiceInstant(chord));

        voice.addVoiceInstant(new VoiceInstant(Note.A1));

        // First check if the doc representation is correct
        Assert.assertEquals(voice.getDocumentRepresentation(), "A A# B C Cmaj A");

        Voice melodicVersion = VoiceToMelodyConversion.melodyConversion(voice);

        Assert.assertEquals("A A# B C C A", melodicVersion.getDocumentRepresentation());
    }
}
