package com.modulo7.musicstatmodels.statistics;

import com.modulo7.common.interfaces.AbstractStatistic;
import com.modulo7.common.utils.FrequencyNoteMap;
import com.modulo7.musicstatmodels.representation.buildingblocks.ChordQuality;
import com.modulo7.musicstatmodels.representation.buildingblocks.Note;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;
import com.modulo7.musicstatmodels.representation.monophonic.VoiceInstant;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;

/**
 * Created by asanyal on 10/13/15.
 *
 * Gets the maximum range between note values between two any two points within a voice
 * This statistic allows us to chose songs that dont move beyond a certain range for songs
 */
public class MaxRangeOfSong implements AbstractStatistic {

    // A copy of the frequency note map
    private static final FrequencyNoteMap noteMap = FrequencyNoteMap.getInstance();

    /**
     * Returns the max range in any voice over the whole song
     * @param song
     * @return
     */
    @Override
    public Double getStatistic(final Song song) {

        int overallMin = Integer.MAX_VALUE;
        int overallMax = Integer.MIN_VALUE;

        for (final Voice voice : song.getVoices()) {
            int minLoc = Integer.MAX_VALUE;
            int maxLoc = -Integer.MAX_VALUE;

            for (final VoiceInstant instant : voice.getVoiceSequence()) {
                final Note topNote = ChordQuality.getTopNoteFromChord(instant.getAllNotesofInstant());
                final Note rootNote = ChordQuality.getRootNoteFromChord(instant.getAllNotesofInstant());

                minLoc = Math.min(minLoc, noteMap.getPositionGivenNote(rootNote));
                maxLoc = Math.max(maxLoc, noteMap.getPositionGivenNote(topNote));
            }

            overallMax = Math.max(overallMax, maxLoc);
            overallMin = Math.min(overallMin, minLoc);
        }

        return (double) (overallMax - overallMin);
    }

    /**
     * Gets the highest and lowest note in a voice
     * Useful for voice classification
     *
     * @param voice
     * @return
     */
    public static Note[] getTopAndBottomNote(final Voice voice) {
        int minLoc = Integer.MAX_VALUE;
        int maxLoc = -Integer.MAX_VALUE;

        for (final VoiceInstant instant : voice.getVoiceSequence()) {
            final Note topNote = ChordQuality.getTopNoteFromChord(instant.getAllNotesofInstant());
            final Note rootNote = ChordQuality.getRootNoteFromChord(instant.getAllNotesofInstant());

            minLoc = Math.min(minLoc, noteMap.getPositionGivenNote(rootNote));
            maxLoc = Math.max(maxLoc, noteMap.getPositionGivenNote(topNote));
        }

        final Note bottomNote = noteMap.getNoteGivenPosition(minLoc);
        final Note topNote = noteMap.getNoteGivenPosition(maxLoc);

        Note[] topAndBottom = new Note[2];
        topAndBottom[0] = bottomNote;
        topAndBottom[1] = topNote;

        return topAndBottom;
    }
}
