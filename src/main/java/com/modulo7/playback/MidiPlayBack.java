package com.modulo7.playback;

import org.apache.log4j.Logger;
import org.jfugue.midi.MidiParser;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
import org.staccato.StaccatoParserListener;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import java.io.File;
import java.io.IOException;

/**
 * Created by asanyal on 10/22/15.
 *
 * Midi playback module
 */
public class MidiPlayBack implements AbstractPlayBack {

    private File midiFile;

    private static final Logger logger = Logger.getLogger(MidiPlayBack.class);

    public MidiPlayBack(final String fileName) {
        midiFile = new File(fileName);
    }

    @Override
    public void play() {
        MidiParser parser = new MidiParser();
        StaccatoParserListener listener = new StaccatoParserListener();
        parser.addParserListener(listener);

        try {
            parser.parse(MidiSystem.getSequence(midiFile));
        } catch (InvalidMidiDataException | IOException e) {
            logger.error(e.getMessage());
        }

        Pattern staccatoPattern = listener.getPattern();
        Player player = new Player();
        player.play(staccatoPattern);
    }
}
