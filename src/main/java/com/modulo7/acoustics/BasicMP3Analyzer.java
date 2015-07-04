package com.modulo7.acoustics;

import com.echonest.api.v4.*;

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
 * 2.
 */
public class BasicMP3Analyzer {

    // The echo nest API
    private EchoNestAPI en;

    // The API key, generally acquired
    private String ECHO_NEST_API_KEY;

    // Number of milliseconds given for analysis
    // TODO : Dynamically configure the analysis duration
    private static final int DURATION_OF_ANALYSIS = 30000;

    /**
     * Method to acquire API Key
     */
    private void acquireEchoNestAPIKey() {
        ECHO_NEST_API_KEY = "K54MGT0TONSDQDKXE";
    }

    private void init() {
        acquireEchoNestAPIKey();
    }


    /**
     * Constructor of the basic MP3 metadata analyzer
     *
     * @throws EchoNestException
     */
    public BasicMP3Analyzer() throws EchoNestException {

        init();
        en = new EchoNestAPI(ECHO_NEST_API_KEY);
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
                        System.out.println(segment.getPitches().length);
                    }
                } else {
                    System.err.println("Trouble analysing track " + track.getStatus());
                }
            } catch (IOException e) {
                System.err.println("Trouble uploading file");
            }
        }
    }

    public static void main(String[] args) throws EchoNestException {
        BasicMP3Analyzer analyzer = new BasicMP3Analyzer();

        // Basic test case
        analyzer.getMP3MetaDataInfo("C:\\Led Zeppelin - Stairway To Heaven.mp3");
    }
}
