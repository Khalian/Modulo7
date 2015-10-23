package com.modulo7.playback;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;
import java.io.*;

/**
 * Created by asanyal on 10/22/15.
 */
public class MidiPlayBack implements AbstractPlayBack {


    private File midiFile;

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
            // create a stream from a file
            InputStream is = new BufferedInputStream(new FileInputStream(midiFile));
            sequencer.setSequence(is);
            sequencer.start();
        } catch (MidiUnavailableException | InvalidMidiDataException | IOException e) {
            e.printStackTrace();
        }
    }
}
