package com.modulo7.musicstatmodels.similarity.genericsimilarity;

import com.modulo7.common.exceptions.Modulo7BadIntervalException;
import com.modulo7.common.exceptions.Modulo7BadNoteException;
import com.modulo7.common.exceptions.Modulo7WrongNoteType;
import com.modulo7.common.interfaces.AbstractContour;
import com.modulo7.common.interfaces.AbstractSongSimilarity;
import com.modulo7.common.interfaces.AbstractVoiceSimilarity;
import com.modulo7.common.utils.Modulo7Globals;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;
import com.modulo7.musicstatmodels.vectorspacemodels.contour.ContourSongRep;
import com.modulo7.musicstatmodels.vectorspacemodels.contour.voicecontour.NaturalContour;
import org.apache.log4j.Logger;

/**
 * Created by asanyal on 10/2/15.
 *
 * A similarity measure using natural song contour on arbitrary voice similarity measures
 */
public class SongContourSimilarity<T extends AbstractVoiceSimilarity, V extends AbstractContour>
        implements AbstractSongSimilarity {

    // Logger for natural song contour similarity measure
    private static Logger logger = Logger.getLogger(SongContourSimilarity.class);

    // The internal voice similarity used with the contour similarity
    private T internalVoiceSimilarity;

    // The internal contour representation used in the voice similarity
    private V internalContourRep;

    /**
     * Basic constructor for natural song contour similarity
     * @param internalVoiceSimilarity
     */
    public SongContourSimilarity(final T internalVoiceSimilarity, final V internalContourRep) {
        this.internalVoiceSimilarity = internalVoiceSimilarity;
        this.internalContourRep = internalContourRep;
    }

    @Override
    public double getSimilarity(final Song first, final Song second) {

        ContourSongRep<V> songRep = new ContourSongRep<>(internalContourRep);

        try {
            final Song firstContourRepSong = songRep.getContourizedSongRep(first);
            final Song secondContourRepSong = songRep.getContourizedSongRep(second);

            GenericMaximalVoiceSimilarity<T> similarity = new GenericMaximalVoiceSimilarity<T>(internalVoiceSimilarity);
            return similarity.getSimilarity(firstContourRepSong, secondContourRepSong);
        } catch (Modulo7BadIntervalException | Modulo7WrongNoteType | Modulo7BadNoteException e) {
            logger.error(e.getMessage());
        }

        return Modulo7Globals.UNKNOWN;
    }
}
