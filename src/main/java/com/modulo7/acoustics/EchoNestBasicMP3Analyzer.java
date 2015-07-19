package com.modulo7.acoustics;

import com.echonest.api.v4.*;
import com.modulo7.common.InvalidLineInstantSizeException;
import com.modulo7.crawler.CrawlerHelper;
import com.modulo7.musicstatmodels.LineInstant;
import com.modulo7.musicstatmodels.Note;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by asanyal on 7/3/2015.
 *
 * The basic metadata analyzer gets certain pieces of information
 * for mp3 tracks
 *
 * It acquires the following pieces of information
 *
 * 1. Tempo of the track
 * 2.
 */
public class EchoNestBasicMP3Analyzer {

    // The echo nest API
    private EchoNestAPI en;

    // Number of milliseconds given for analysis
    // TODO : Dynamically configure the analysis duration
    private static final int DURATION_OF_ANALYSIS = 30000;

    private static FrequencyNoteMap noteMap = null;

    /**
     * Basic init method, all constructors should call it
     */
    private void init() {
        noteMap = FrequencyNoteMap.getInstance();
    }

    /**
     * Constructor of the basic MP3 metadata analyzer
     *
     * @throws EchoNestException
     */
    public EchoNestBasicMP3Analyzer() throws EchoNestException {

        init();
        en = new EchoNestAPI(CrawlerHelper.ECHO_NEST_API_KEY);
    }

    /**
     * Method to acquire the the details of an MP3 file
     *
     * @param filePath
     * @throws EchoNestException
     */
    private void getMP3MetaDataInfo(String filePath) throws EchoNestException {

        File file = new File(filePath);

        if (!file.exists()) {
            System.err.println("Can't find " + filePath);
        } else {
            try {
                Track track = en.uploadTrack(file, true);

                // Wait for a predefined period of time in which the track is analyzed
                track.waitForAnalysis(30000);

                if (track.getStatus() == Track.AnalysisStatus.COMPLETE) {
                    System.out.println("Tempo: " + track.getTempo());
                    System.out.println("Title: " + track.getTitle());
                    System.out.println("Time Signature:" + track.getTimeSignature());
                    System.out.println("Key of the track:" + track.getKey());
                    System.out.println("Artist" + track.getArtistName());
                    System.out.println("Loudness" + track.getLoudness());
                    System.out.println("Beat start times:");

                    TrackAnalysis analysis = track.getAnalysis();

                    System.out.println(analysis.getTimeSignature());
                    for (TimedEvent beat : analysis.getBeats()) {
                        System.out.println("beat " + beat.getStart());
                        System.out.println("Beat Duration" + beat.getDuration());
                    }

                    for (Segment segment : analysis.getSegments()) {
                        LineInstant songInstant = getLineInstantFromVector(segment.getPitches());
                    }
                } else {
                    System.err.println("Trouble analysing track " + track.getStatus());
                }
            } catch (IOException e) {
                System.err.println("Trouble uploading file");
            } catch (InvalidLineInstantSizeException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * This method takes the output of the Echo Nest API's note
     * vector : which they name as the chroma vector and ascertain the
     * note or the chord associated with that chroma vector
     *
     * For now I am considering the strong presence of a note if the
     * chroma element associated with is is above 0.75
     *
     * TODO : Figure out the interpretation of the chroma vector returned by the echo nest API
     *
     * @param noteChromaVector
     *
     * @return The line Instant representation of the chroma vector
     */
    private LineInstant getLineInstantFromVector(double[] noteChromaVector) throws InvalidLineInstantSizeException {

        // First check whether the chroma vector is valid
        assert (noteChromaVector.length == 12);

        // Construct a note Set from a chroma vector
        Set<Note> chromaNotes = new HashSet<>();

        // Parse through the note Vector to acquire the requisite notes
        for (int i = 0; i < noteChromaVector.length; i++) {
            if (noteChromaVector[i] >= 0.8) {
                chromaNotes.add(noteMap.getNoteGivenPosition(i));
            }
        }

        return new LineInstant(chromaNotes);
    }


    public static void main(String[] args) throws EchoNestException {
        EchoNestBasicMP3Analyzer analyzer = new EchoNestBasicMP3Analyzer();

        // Basic test case
        analyzer.getMP3MetaDataInfo("C:\\Led Zeppelin - Stairway To Heaven.mp3");
    }
}
