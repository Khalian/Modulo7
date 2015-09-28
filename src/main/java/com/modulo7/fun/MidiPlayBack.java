package com.modulo7.fun;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;
import java.io.*;

/**
 * Created by asanyal on 9/27/15.
 *
 * A fun class which plays back a midi file
 */
public class MidiPlayBack {

    /**
     * Just a fun method to playback a midi file
     * Use this to make Modulo7 behave like a recorder
     *
     * @param midiFile
     * @throws MidiUnavailableException
     * @throws IOException
     * @throws InvalidMidiDataException
     */
    private static void playBack(final String midiFile) throws MidiUnavailableException, IOException, InvalidMidiDataException {
        // Obtains the default Sequencer connected to a default device.
        final Sequencer sequencer = MidiSystem.getSequencer();

        // Opens the device, indicating that it should now acquire any
        // system resources it requires and become operational.
        sequencer.open();

        // create a stream from a file
        final InputStream is = new BufferedInputStream(new FileInputStream(new File(midiFile)));

        // Sets the current sequence on which the sequencer operates.
        // The stream must point to MIDI file data.
        sequencer.setSequence(is);

        // Starts playback of the MIDI data in the currently loaded sequence.
        sequencer.start();
    }
}
