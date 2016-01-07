package com.modulo7.musicstatmodels.statistics;

import com.modulo7.common.exceptions.Modulo7BadIntervalException;
import com.modulo7.common.exceptions.Modulo7BadNoteException;
import com.modulo7.common.interfaces.AbstractStatistic;
import com.modulo7.musicstatmodels.musictheorymodels.Interval;
import com.modulo7.musicstatmodels.representation.buildingblocks.Note;
import com.modulo7.musicstatmodels.representation.metadata.KeySignature;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;
import com.modulo7.musicstatmodels.representation.monophonic.VoiceInstant;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by asanyal on 1/6/16.
 *
 * A statistic which captures the most frequent scale degree
 * Its a useful statistic as it can lead to some interesting observations
 * (for instance blues music has a prevalence of the worry note, absent in
 * other music)
 *
 * TODO : Finish this implementation
 */
public class MostFrequentScaleDegree implements AbstractStatistic<Double> {

    // Logger instance
    private static final Logger logger = Logger.getLogger(MostFrequentScaleDegree.class);

    // Scale degree frequency
    private Map<Interval, Integer> scaleDegreeFrequency = new HashMap<>();

    @Override
    public Double getStatistic(final Song song) {
        final KeySignature signature = song.getMetadata().getKeySignature();
        final String key = signature.getKey();

        for (final Voice voice : song.getVoices()) {
            for (final VoiceInstant instant : voice.getVoiceSequence()) {
                for (final Note note : instant.getAllNotesofInstant()) {
                    final String noteVal = note.getNoteValue();
                    try {
                        final Interval scaleDegree = Note.getInterval(noteVal, key);
                    } catch (Modulo7BadNoteException | Modulo7BadIntervalException e) {
                        logger.error(e.getMessage());
                    }
                }
            }
        }

        return null;
    }
}
