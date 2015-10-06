package com.modulo7.musicstatmodels.similarity.songsimilarity;

import com.modulo7.common.exceptions.Modulo7BadIntervalException;
import com.modulo7.common.exceptions.Modulo7WrongNoteType;
import com.modulo7.common.interfaces.AbstractSongSimilarity;
import com.modulo7.common.interfaces.AbstractVoiceSimilarity;
import com.modulo7.common.utils.Modulo7Globals;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;
import com.modulo7.musicstatmodels.similarity.genericsimilarity.GenericMaximalVoiceSimilarity;
import com.modulo7.musicstatmodels.vectorspacemodels.contour.ContourSongRep;
import com.modulo7.musicstatmodels.vectorspacemodels.contour.voicecontour.NaturalContour;
import org.apache.log4j.Logger;

/**
 * Created by asanyal on 10/2/15.
 *
 * A similarity measure using natural song contour on arbitrary voice similarity measures
 */
public class NaturalSongContourSimilarity<T extends AbstractVoiceSimilarity> implements AbstractSongSimilarity {

    // Logger for natural song contour similarity measure
    private static Logger logger = Logger.getLogger(NaturalSongContourSimilarity.class);

    private T internalVoiceSimilarity;

    /**
     * Basic constructor for natural song contour similarity
     * @param internalVoiceSimilarity
     */
    public NaturalSongContourSimilarity(final T internalVoiceSimilarity) {
        this.internalVoiceSimilarity = internalVoiceSimilarity;
    }

    @Override
    public double getSimilarity(final Song first, final Song second) {

        ContourSongRep<NaturalContour> songRep = new ContourSongRep<>(new NaturalContour());

        try {
            Song firstContourRepSong = songRep.getContourizedSongRep(first);
            Song secondContourRepSong = songRep.getContourizedSongRep(second);

            GenericMaximalVoiceSimilarity<T> similarity = new GenericMaximalVoiceSimilarity<>(internalVoiceSimilarity);
            return similarity.getSimilarity(firstContourRepSong, secondContourRepSong);
        } catch (Modulo7BadIntervalException | Modulo7WrongNoteType e) {
            logger.error(e.getMessage());
        }

        return Modulo7Globals.UNKNOWN;
    }
}
