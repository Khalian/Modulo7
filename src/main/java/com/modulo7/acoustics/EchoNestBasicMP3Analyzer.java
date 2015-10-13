package com.modulo7.acoustics;

import com.echonest.api.v4.*;
import com.modulo7.common.exceptions.Modulo7BadIntervalException;
import com.modulo7.common.exceptions.Modulo7BadKeyException;
import com.modulo7.common.exceptions.Modulo7InvalidVoiceInstantSizeException;
import com.modulo7.common.exceptions.Modulo7NoSuchFileOrDirectoryException;
import com.modulo7.common.interfaces.AbstractAnalyzer;
import com.modulo7.common.utils.Modulo7Utils;
import com.modulo7.crawler.utils.CrawlerHelper;
import com.modulo7.crawler.utils.MusicSources;
import com.modulo7.musicstatmodels.representation.metadata.TimeSignature;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;
import com.modulo7.musicstatmodels.representation.metadata.KeySignature;
import com.modulo7.musicstatmodels.representation.metadata.SongMetadata;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;
import com.modulo7.musicstatmodels.representation.monophonic.VoiceInstant;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;

/**
 * Created by asanyal on 7/3/2015.
 *
 * The basic metadata analyzer gets certain pieces of information
 * for mp3 tracks
 *
 * It acquires the following pieces of information
 *
 * 1. Tempo of the track
 * 2. Title of the track
 * 3. The loudness of the track
 * 4. The key signature and time signature of the track
 * 5. The notes (and by extension chords) from the chroma gram representation
 */
public class EchoNestBasicMP3Analyzer implements AbstractAnalyzer {

    // Echo nest basic MP3 analyzer logger
    final static Logger logger = Logger.getLogger(EchoNestBasicMP3Analyzer.class);

    // The echo nest API
    private EchoNestAPI en;

    // An instance of the mp3 File
    private File mp3File;

    // Key signature extracted from the mp3 file
    private KeySignature keySignature = null;

    /**
     * Constructor of the basic MP3 metadata analyzer
     *
     * @throws EchoNestException
     */
    public EchoNestBasicMP3Analyzer(final String filePath) throws EchoNestException, Modulo7NoSuchFileOrDirectoryException {

        en = new EchoNestAPI(CrawlerHelper.ECHO_NEST_API_KEY);

        mp3File = new File(filePath);

        if (!mp3File.exists()) {
            throw new Modulo7NoSuchFileOrDirectoryException("No file :" + filePath);
        }
    }

    /**
     * Method to return a modulo7 Song from an MP3 recording using the
     * Echo Nest API
     *
     * @return The song representiation of the echo nest Analysis of mp3 file
     * @throws EchoNestException
     */
    @Override
    public Song getSongRepresentation() {

        try {
            final Track track = en.uploadTrack(mp3File, true);

            // Wait for a predefined period of time in which the track is analyzed
            track.waitForAnalysis(30000);

            if (track.getStatus() == Track.AnalysisStatus.COMPLETE) {

                final double tempo = track.getTempo();
                final String title = Modulo7Utils.stringAssign(track.getTitle());
                final String artistName = Modulo7Utils.stringAssign(track.getArtistName());

                // Gets the time signature
                final int timeSignatureRatio = track.getTimeSignature();
                TimeSignature timeSignature =  guessTimeSigntureRatio(timeSignatureRatio);

                // Getting the key signature information from the echo nest meta data analysis in integer format
                final int key = track.getKey();
                final int mode = track.getMode();

                try {
                    keySignature = EchoNestKeySignatureEstimator.estimateKeySignature(key, mode);
                } catch (Modulo7BadKeyException e) {
                    logger.error(e.getMessage());
                }

                // Gets  the duration of the track
                final double duration = track.getDuration();

                TrackAnalysis analysis = track.getAnalysis();

                Voice voiceOfSong = new Voice();

                /**
                 * There is no clear distinguishing way of acquiring timbral approximations
                 * Hence the only possible approximation I can think of it call the a part of a
                 * single voice
                 */
                for (final Segment segment : analysis.getSegments()) {
                    VoiceInstant songInstant = ChromaAnalysis.getLineInstantFromVector(segment.getPitches(), segment.getDuration());
                    // TODO : Figure out what to do with the timbral information
                    // double[] timbreVector = segment.getTimbre();
                    voiceOfSong.addVoiceInstant(songInstant);
                }
                if (keySignature == null) {
                    return new Song(voiceOfSong, new SongMetadata(artistName, title, (int) tempo), MusicSources.MP3, duration);
                } else {
                    if (timeSignature == null) {
                        return new Song(voiceOfSong, new SongMetadata(keySignature, artistName, title, (int) tempo),
                                    MusicSources.MP3, duration);
                    } else {
                        return new Song(voiceOfSong, new SongMetadata(keySignature, timeSignature, artistName, title,
                                (int) tempo), MusicSources.MP3, duration);
                    }
                }

            } else {
                logger.error("Trouble analysing track " + track.getStatus());
                return null;
            }
        } catch (IOException e) {
            logger.error("Trouble uploading file to track analyzer" + e.getMessage());
        } catch (Modulo7InvalidVoiceInstantSizeException | EchoNestException | Modulo7BadIntervalException e) {
            logger.error(e.getMessage());
        }

        // Return null if no song is inferred
        return null;
    }

    /**
     * Returns the time singatures numerator and denominator based on
     * @param timeSignatureRatio
     * @return
     */
    private TimeSignature guessTimeSigntureRatio(final int timeSignatureRatio) {
        if (timeSignatureRatio == 1) {
            // Common time sig
            return new TimeSignature(4, 4);
        }

        return null;
    }
}
