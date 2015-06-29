package com.modulo7.acoustics;

/**
 * Created by asanyal on 6/28/2015.
 */
import java.io.File;
import java.io.IOException;

import javax.sound.midi.*;

/**
 * A class to convert midi files to Notes
 */
public class MidiToNoteConverter {

    public static final int NOTE_ON = 0x90;
    public static final int NOTE_OFF = 0x80;

    public static final String[] NOTE_NAMES = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};

    /**
     * Gets the data from a midi file
     *
     * @param midiFileLocation
     * @throws InvalidMidiDataException
     * @throws IOException
     */
    public void getNotesFromMidiFile(String midiFileLocation) throws InvalidMidiDataException, IOException {

        Sequence sequence = MidiSystem.getSequence(new File(midiFileLocation));

        int trackNumber = 0;

        for (Track track :  sequence.getTracks()) {

            trackNumber++;
            System.out.println("Track " + trackNumber + ": size = " + track.size());
            System.out.println();

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
                        String noteName = NOTE_NAMES[note];
                        int velocity = sm.getData2();
                        System.out.println("Note on, " + noteName + octave + " key=" + key + " velocity: " + velocity);
                    } else if (sm.getCommand() == NOTE_OFF) {
                        int key = sm.getData1();
                        int octave = (key / 12)-1;
                        int note = key % 12;
                        String noteName = NOTE_NAMES[note];
                        int velocity = sm.getData2();
                        System.out.println("Note off, " + noteName + octave + " key=" + key + " velocity: " + velocity);
                    } else {
                        System.out.println("Command:" + sm.getCommand());
                    }
                } else {
                    System.out.println("Other message: " + message.getClass());
                }
            }

            System.out.println();
        }

    }

    public static void main(String[] args) throws Exception {
        MidiToNoteConverter converter = new MidiToNoteConverter();
        converter.getNotesFromMidiFile("C:\\Users\\asanyal\\Downloads\\01A-1__Good_Times_Bad_Times.mid");
    }
}
