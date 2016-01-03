package com.modulo7.playback;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import org.apache.log4j.Logger;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by asanyal on 10/22/15.
 *
 * Class that plays back an mp3 file given as input
 */
public class MP3PlayBack implements AbstractPlayBack {

    private String mp3File;

    // Logger for mp3 playback
    private static final Logger logger =Logger.getLogger(MP3PlayBack.class);

    // Default playback constructor
    public MP3PlayBack(final String fileName) {
        mp3File = fileName;
    }

    @Override
    public void play() {
        FileInputStream fis;
        try {
            fis = new FileInputStream(mp3File);
            BufferedInputStream bis = new BufferedInputStream(fis);
            Player player = new Player(bis);
            player.play();
        } catch (FileNotFoundException | JavaLayerException e) {
            logger.error(e.getMessage());
        }
    }
}
