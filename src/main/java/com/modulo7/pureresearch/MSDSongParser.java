package com.modulo7.pureresearch;

import com.modulo7.acoustics.ChromaAnalysis;
import com.modulo7.common.interfaces.AbstractAnalyzer;
import com.modulo7.crawler.utils.MusicSources;
import com.modulo7.musicstatmodels.representation.*;
import ncsa.hdf.object.h5.H5File;
import org.apache.log4j.Logger;

import java.util.Arrays;

/**
 * Created by asanyal on 9/9/15.
 *
 * A research specific song parser in which input files are the MSD files
 */
public class MSDSongParser implements AbstractAnalyzer {

    // The hdf5 file that is taken as an input from the MSD Dataset
    private H5File hdf5File;

    public MSDSongParser(final String filename) {
        this.hdf5File = HDF5_GETTERS.hdf5_open_readonly(filename);
    }

    private KeySignature keySignature = null;

    // Logger for MSDSongparser
    private static final Logger logger = Logger.getLogger(MSDSongParser.class);

    @Override
    public Song getSongRepresentation() {
        try {
            final String titleTrack = HDF5_GETTERS.get_title(hdf5File);
            final String artistName = HDF5_GETTERS.get_artist_name(hdf5File);
            final double duration = HDF5_GETTERS.get_duration(hdf5File);

            final double[] segementsStart = HDF5_GETTERS.get_segments_start(hdf5File);
            final double[] segmentsPitches = HDF5_GETTERS.get_segments_pitches(hdf5File);

            Voice voice = new Voice();

            for (int i = 0; i < segementsStart.length - 1; i++) {
                double durationOfSegment = segementsStart[i + 1] = segementsStart[i];
                double[] noteChromaVector = Arrays.copyOfRange(segmentsPitches, i * 12, (i + 1) * 12);

                final VoiceInstant instant = ChromaAnalysis.getLineInstantFromVector(noteChromaVector, durationOfSegment);
                voice.addVoiceInstant(instant);
            }

            if (keySignature == null) {
                return new Song(voice, new SongMetadata(artistName, titleTrack), MusicSources.MP3, duration);
            } else {
                return new Song(voice, new SongMetadata(keySignature, artistName, titleTrack), MusicSources.MP3, duration);
            }

        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return null;
    }
}
