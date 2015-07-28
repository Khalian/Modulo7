package com.modulo7.acoustics;

/**
 * Created by asanyal on 6/28/2015.
 */
import com.modulo7.common.utils.Modulo7Globals;

import java.io.File;
import java.io.IOException;

import javax.sound.midi.*;

/**
 * A class to convert midi files to Notes
 */
public class MidiToNoteConverter {

    // Midi Byte representation of on note
    public static final int NOTE_ON = 0x90;

    // Midi Byte representation of off note
    public static final int NOTE_OFF = 0x80;

    /**
     * Gets the data of the entire song
     * from a midi file
     *
     * @param midiFileLocation
     * @throws InvalidMidiDataException
     * @throws IOException
     */
    public void getNotesFromMidiFile(final String midiFileLocation) throws InvalidMidiDataException, IOException {

        Sequence sequence = MidiSystem.getSequence(new File(midiFileLocation));

        int trackNumber = 0;

        for (Track track :  sequence.getTracks()) {

            trackNumber++;
            System.out.println("Track " + trackNumber + ": size = " + track.size());

            for (int i=0; i < track.size(); i++) {

                MidiEvent event = track.get(i);
                System.out.print("@" + event.getTick() + " ");
                MidiMessage message = event.getMessage();

                if (message instanceof ShortMessage) {
                    ShortMessage sm = (ShortMessage) message;
                    System.out.print("Channel: " + sm.getChannel() + " ");

                    if (sm.getCommand() == NOTE_ON) {
                        int key = sm.getData1();
                        int octave = (key / 12)-1;
                        int note = key % 12;
                        String noteName = Modulo7Globals.NOTE_NAMES[note];
                        int velocity = sm.getData2();
                        System.out.println("Note on, " + noteName + octave + " key=" + key + " velocity: " + velocity);
                    } else if (sm.getCommand() == NOTE_OFF) {
                        int key = sm.getData1();
                        int octave = (key / 12)-1;
                        int note = key % 12;
                        String noteName = Modulo7Globals.NOTE_NAMES[note];
                        int velocity = sm.getData2();
                        System.out.println("Note off, " + noteName + octave + " key=" + key + " velocity: " + velocity);
                    } else {
                        // We ignore the command elements of
                    }
                } else {
                    System.out.println("Other message: " + message.getClass());
                }
            }

            System.out.println();
        }

    }

    /**
     * Test code for Midi converter, taking a basic midi file and converting to
     * notes
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        MidiToNoteConverter converter = new MidiToNoteConverter();
        converter.getNotesFromMidiFile("C:\\Users\\asanyal\\Downloads\\01A-1__Good_Times_Bad_Times.mid");
    }
}
