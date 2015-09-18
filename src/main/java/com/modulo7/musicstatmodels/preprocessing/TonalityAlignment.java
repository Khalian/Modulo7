package com.modulo7.musicstatmodels.preprocessing;

import com.modulo7.common.exceptions.Modulo7BadIntervalException;
import com.modulo7.common.exceptions.Modulo7BadNoteException;
import com.modulo7.common.utils.FrequencyNoteMap;
import com.modulo7.musicstatmodels.musictheorymodels.Interval;
import com.modulo7.musicstatmodels.representation.buildingblocks.Note;
import com.modulo7.musicstatmodels.representation.metadata.KeySignature;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;
import com.modulo7.musicstatmodels.representation.monophonic.VoiceInstant;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;
import org.apache.commons.lang3.SerializationUtils;

import java.util.HashSet;

/**
 * Created by asanyal on 9/17/15.
 *
 * Bring a song to a given key as a proprocessing step
 * This is necessary for execution of certain similarity measures
 */
public class TonalityAlignment {

    private static FrequencyNoteMap noteMap = FrequencyNoteMap.getInstance();

    /**
     * Method which aligns songs to a particular key signature
     * @param song
     * @param desiredKeySignature
     * @throws Modulo7BadIntervalException
     * @throws Modulo7BadNoteException
     */
    public static void alignSong(final Song song, KeySignature desiredKeySignature) throws Modulo7BadIntervalException,
            Modulo7BadNoteException {
        final KeySignature currentKeySignature = song.getMetadata().getKeySignature();
        final Interval interval = KeySignature.getIntervalicDistance(currentKeySignature, desiredKeySignature);

        Song newSong = SerializationUtils.clone(song);

        for (final Voice voice : newSong.getVoices()) {
            for (final VoiceInstant instant : voice.getVoiceSequence()) {

                HashSet<Note> newNoteSet = new HashSet<>();

                for (final Note note : instant.getAllNotesofInstant()) {
                    newNoteSet.add(noteMap.getNoteGivenBaseAndInterval(note, interval));
                }

                instant.reassignNotes(newNoteSet);
            }
        }
    }
}
