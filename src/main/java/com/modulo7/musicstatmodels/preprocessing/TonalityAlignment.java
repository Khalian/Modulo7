package com.modulo7.musicstatmodels.preprocessing;

import com.modulo7.common.exceptions.Modulo7BadIntervalException;
import com.modulo7.common.exceptions.Modulo7BadNoteException;
import com.modulo7.musicstatmodels.musictheorymodels.IntervalEnum;
import com.modulo7.musicstatmodels.representation.metadata.KeySignature;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;
import com.modulo7.musicstatmodels.representation.monophonic.VoiceInstant;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;
import org.apache.commons.lang3.SerializationUtils;

/**
 * Created by asanyal on 9/17/15.
 *
 * Bring a song to a given key as a proprocessing step
 *
 * TODO : Implement it
 */
public class TonalityAlignment {

    public static void alignSong(final Song song, KeySignature desiredKeySignature) throws Modulo7BadIntervalException,
            Modulo7BadNoteException {
        final KeySignature currentKeySignature = song.getMetadata().getKeySignature();
        final IntervalEnum intervalEnum = KeySignature.getIntervalicDistance(currentKeySignature, desiredKeySignature);

        Song newSong = SerializationUtils.clone(song);

        for (final Voice voice : newSong.getVoices()) {
            for (VoiceInstant instant : voice.getVoiceSequence()) {

            }
        }
    }
}
