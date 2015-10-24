package com.modulo7.playback;

import org.apache.log4j.Logger;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;
import java.io.*;

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
        // Obtains the default Sequencer connected to a default device.
        Sequencer sequencer;
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            InputStream is = new BufferedInputStream(new FileInputStream(midiFile));
            sequencer.setSequence(is);
            sequencer.start();
        } catch (MidiUnavailableException | InvalidMidiDataException | IOException e) {
            logger.error(e.getMessage());
        }
    }
}
