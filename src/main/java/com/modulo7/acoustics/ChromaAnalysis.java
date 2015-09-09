package com.modulo7.acoustics;

import com.modulo7.common.exceptions.Modulo7BadChordException;
import com.modulo7.common.exceptions.Modulo7BadIntervalException;
import com.modulo7.common.exceptions.Modulo7InvalidLineInstantSizeException;
import com.modulo7.common.utils.FrequencyNoteMap;
import com.modulo7.musicstatmodels.representation.Note;
import com.modulo7.musicstatmodels.representation.VoiceInstant;
import org.apache.log4j.Logger;

import java.util.HashSet;

/**
 * Created by asanyal on 9/9/15.
 *
 * Static helper for analysis of chroma vectors
 */
public class ChromaAnalysis {

    // An instance of the frequency note map object
    private static final FrequencyNoteMap noteMap = FrequencyNoteMap.getInstance();

    // Logger for the chroma analysis class
    private static final Logger logger = Logger.getLogger(ChromaAnalysis.class);

    /**
     * This method takes the output of the Echo Nest API's note
     * vector : which they name as the chroma vector and ascertain the
     * note or the chord associated with that chroma vector
     *
     * @param noteChromaVector
     * @param duration
     *
     * @return The line Instant representation of the chroma vector
     */
    public static VoiceInstant getLineInstantFromVector(final double[] noteChromaVector, final double duration)
            throws Modulo7InvalidLineInstantSizeException, Modulo7BadIntervalException {

        // First check whether the chroma vector is valid
        assert (noteChromaVector.length == 12);

        // Conclude a note if one of the vector indices have value higher
        // than the rest of the vector
        double sum = 0.0;
        double maxVal = -Double.MAX_VALUE;

        int maxIndex = 0;

        // Construct a note Set from a chroma vector
        final HashSet<Note> chromaNotes = new HashSet<>();

        // Parse through the note Vector to acquire the requisite notes,
        for (int i = 0; i < noteChromaVector.length; i++) {
            sum += noteChromaVector[i];
            if (noteChromaVector[i] > maxVal) {
                maxVal = noteChromaVector[i];
                maxIndex = i;
            }
        }

        // Sanity check to ensure note ranges go 12 for basic position acquisition
        assert (maxIndex >= 0 && maxIndex < 12);

        //check whether its correct or not that this chroma vector can be classified as a note
        if (maxVal >= sum - maxIndex)
            chromaNotes.add(noteMap.getBasicNoteGivenPosition(maxIndex));
        else {
            ChordEstimator estimator = new ChordEstimator(noteChromaVector);
            HashSet<Note> chordNotes;
            try {
                chordNotes = ChordEstimator.estimateChordGivenQualityAndRootNote(estimator.getRootNote(), estimator.getQuality(), estimator.getIntervals());
                for (final Note noteInChord : chordNotes) {
                    chromaNotes.add(noteInChord);
                }
                return new VoiceInstant(chromaNotes, duration, estimator.getQuality());
            } catch (Modulo7BadChordException e) {
                logger.error(e.getMessage());
            }

        }

        return new VoiceInstant(chromaNotes, duration);
    }

}
