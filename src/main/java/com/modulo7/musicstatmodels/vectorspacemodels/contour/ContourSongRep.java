package com.modulo7.musicstatmodels.vectorspacemodels.contour;

import com.modulo7.common.exceptions.Modulo7BadIntervalException;
import com.modulo7.common.exceptions.Modulo7BadNoteException;
import com.modulo7.common.exceptions.Modulo7WrongNoteType;
import com.modulo7.common.interfaces.AbstractContour;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;
import org.apache.commons.lang3.SerializationUtils;

import java.util.HashSet;

/**
 * Created by asanyal on 10/4/15.
 *
 * The contourized representation of every voice in a song
 */
public class ContourSongRep<T extends AbstractContour> {

    // The abstract contour representation internally
    private T internalContourRepresentation;

    /**
     * Init a contour song representation
     * @param internalContourRepresentation
     */
    public ContourSongRep(final T internalContourRepresentation) {
        this.internalContourRepresentation = internalContourRepresentation;
    }

    /**
     * Gets the contourized representation of the a song (i.e contour for every voice)
     *
     * @param oldSong
     * @return
     * @throws Modulo7BadIntervalException
     * @throws Modulo7WrongNoteType
     */
    public Song getContourizedSongRep(final Song oldSong) throws Modulo7BadIntervalException, Modulo7WrongNoteType, Modulo7BadNoteException {

        ContourGradient<T> gradientRep = new ContourGradient<>(internalContourRepresentation);

        HashSet<Voice> newVoiceSet = new HashSet<>();
        for (final Voice voice : oldSong.getVoices()) {
            final Voice newVoice = gradientRep.getGradient(voice);
            newVoiceSet.add(newVoice);
        }

        return new Song(newVoiceSet, oldSong.getMetadata(), oldSong.getSource());
    }
}
