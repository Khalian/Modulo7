package com.modulo7.musicstatmodels.statistics;

import com.modulo7.common.interfaces.AbstractStatistic;
import com.modulo7.common.utils.FrequencyNoteMap;
import com.modulo7.common.utils.Modulo7Utils;
import com.modulo7.musicstatmodels.representation.buildingblocks.Note;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;
import com.modulo7.musicstatmodels.representation.monophonic.VoiceInstant;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;

import java.util.*;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/**
 * Created by asanyal on 1/6/16.
 *
 * Extracts the most frequently occuring pitch in numeric format
 *
 * The output is an integer which maps to the keyboard location for that note
 * Unknowns map to -1
 */
public class MostFrequentPitch implements AbstractStatistic<Double> {

    // Map storing notes with their associated counters
    private Map<Note, Integer> noteCounts = new HashMap<>();

    // A handle to the static note map instant, used for ascertaining position given
    private static final FrequencyNoteMap noteMap = FrequencyNoteMap.getInstance();

    @Override
    public Double getStatistic(final Song song) {
        for (final Voice voice : song.getVoices()) {
            for (final VoiceInstant instant : voice.getVoiceSequence()) {
                Set<Note> noteSet = instant.getAllNotesofInstant();
                noteSet.forEach(this::addToNoteCount);
            }
        }

        return noteMap.getPositionGivenNote(Collections.max(noteCounts.entrySet(), new MapFreqComparator()).getKey()) * 1.0;
    }

    /**
     * Addition to note counter
     * @param note
     */
    private void addToNoteCount(final Note note) {
        final Integer count = noteCounts.get(note);
        if (count != null) {
            noteCounts.put(note, count + 1);
        } else {
            noteCounts.put(note, 1);
        }
    }
}

/**
 * Implements a comparator for max frequency of note occuring in the
 */
class MapFreqComparator implements Comparator<Map.Entry<Note, Integer>> {

    @Override
    public int compare(Map.Entry<Note, Integer> thisNoteEntry, Map.Entry<Note, Integer> thatNoteEntry) {
        return thisNoteEntry.getValue() > thatNoteEntry.getValue()? 1:-1;
    }
}
