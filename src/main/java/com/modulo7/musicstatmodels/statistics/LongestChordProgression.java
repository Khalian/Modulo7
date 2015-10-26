package com.modulo7.musicstatmodels.statistics;

import com.modulo7.common.interfaces.AbstractStatistic;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;
import com.modulo7.musicstatmodels.representation.monophonic.VoiceInstant;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;

/**
 * Created by asanyal on 10/25/15.
 *
 * The longest chord progression seen in a song in any voice
 * This is a coarse measure on how harmonically dominated the song is
 * (typically occurs for songs with accompanyments with large number of chords)
 *
 * This measure does not take into account repeating chord sequences which is a separate measure in
 * its own right
 */
public class LongestChordProgression implements AbstractStatistic<Double> {

    @Override
    public Double getStatistic(final Song song) {
        double longestSeenSoFar = 0;

        for (final Voice voice : song.getVoices()) {

            int bestSeen = 0;

            for (final VoiceInstant instant : voice.getVoiceSequence()) {
                if (instant.isChord()) {
                    bestSeen += 1;
                } else {
                    longestSeenSoFar = Math.max(longestSeenSoFar, bestSeen);
                    // Rest best Seen to 0, the reason is, chord progression seen ends here
                    bestSeen = 0;
                }
            }
        }

        return longestSeenSoFar;
    }
}
