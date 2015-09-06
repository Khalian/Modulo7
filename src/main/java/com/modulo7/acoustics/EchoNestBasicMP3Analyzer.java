package com.modulo7.acoustics;

import com.echonest.api.v4.*;

import com.modulo7.common.exceptions.Modulo7BadIntervalException;
import com.modulo7.common.interfaces.AbstractAnalyzer;
import com.modulo7.common.exceptions.Modulo7InvalidLineInstantSizeException;
import com.modulo7.common.exceptions.Modulo7NoSuchFileException;
import com.modulo7.common.utils.FrequencyNoteMap;
import com.modulo7.common.utils.Modulo7Globals;
import com.modulo7.common.utils.Modulo7Utils;
import com.modulo7.crawler.utils.CrawlerHelper;
import com.modulo7.crawler.utils.MusicSources;
import com.modulo7.musicstatmodels.representation.*;
import com.modulo7.musicstatmodels.representation.Song;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;

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
 */
public class EchoNestBasicMP3Analyzer implements AbstractAnalyzer {

    // Echo nest basic MP3 analyzer logger
    final static Logger logger = Logger.getLogger(EchoNestBasicMP3Analyzer.class);

    // The echo nest API
    private EchoNestAPI en;

    // An instance of the mp3 File
    private File mp3File;

    // An instance of the frequency note map
    private static FrequencyNoteMap noteMap = FrequencyNoteMap.getInstance();

    /**
     * Constructor of the basic MP3 metadata analyzer
     *
     * @throws EchoNestException
     */
    public EchoNestBasicMP3Analyzer(final String filePath) throws EchoNestException, Modulo7NoSuchFileException {

        en = new EchoNestAPI(CrawlerHelper.ECHO_NEST_API_KEY);

        mp3File = new File(filePath);

        if (!mp3File.exists()) {
            throw new Modulo7NoSuchFileException("No file :" + filePath);
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
                final int timeSignature = track.getTimeSignature();

                // Getting the key signature information from the echo nest meta data analysis
                final int key = track.getKey();
                final int mode = track.getMode();

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
                    VoiceInstant songInstant = getLineInstantFromVector(segment.getPitches(), segment.getDuration());
                    // TODO : Figure out what to do with the timbral information
                    // double[] timbreVector = segment.getTimbre();
                    voiceOfSong.addVoiceInstant(songInstant);
                }

                return new Song(voiceOfSong, new SongMetadata(artistName, title), MusicSources.MP3);
            } else {
                logger.error("Trouble analysing track " + track.getStatus());
                return null;
            }
        } catch (IOException e) {
            logger.error("Trouble uploading file to track analyzer" + e.getMessage());
        } catch (Modulo7InvalidLineInstantSizeException | EchoNestException | Modulo7BadIntervalException e) {
            e.printStackTrace();
        }

        // Return null if no song is inferred
        return null;
    }
    /**
     * This method takes the output of the Echo Nest API's note
     * vector : which they name as the chroma vector and ascertain the
     * note or the chord associated with that chroma vector
     *
     * For now I am considering the strong presence of a note if the
     * chroma element associated with is is above 0.75
     *
     * TODO : Implement the chord detection algorithm properly, either via JNI
     * or rewrite code in Java
     *
     * @param noteChromaVector
     * @param duration
     *
     * @return The line Instant representation of the chroma vector
     */
    private VoiceInstant getLineInstantFromVector(final double[] noteChromaVector, final double duration)
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

        final int actualNoteMapMaxIndex = maxIndex + 1;

        //check whether its correct or not that this chroma vector can be classified as a note
        if (maxVal >= sum - maxIndex)
            chromaNotes.add(noteMap.getBasicNoteGivenPosition(actualNoteMapMaxIndex));
        else {
            // TODO : Estimation of chord code, for now hack and put the note with highest position
            ChordEstimator estimator = new ChordEstimator(noteChromaVector);
            chromaNotes.add(noteMap.getBasicNoteGivenPosition(actualNoteMapMaxIndex));
        }

        return new VoiceInstant(chromaNotes, duration);
    }
}
