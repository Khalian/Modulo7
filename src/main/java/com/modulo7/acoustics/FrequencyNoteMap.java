package com.modulo7.acoustics;

import com.modulo7.musicstatmodels.representation.Note;

import java.util.*;

/**
 * Created by asanyal on 7/14/2015.
 *
 * This class inits a map between note numbers and frequencies
 * and vice versa
 *
 * Values taken from : http://www.phy.mtu.edu/~suits/notefreqs.html
 */
public class FrequencyNoteMap {

    // A map with notes as key and frequencies as values
    private static final Map<Note, Double> noteToFrequencyMap = new HashMap<>();

    // A map which notes the frequencies as key and notes as values, the opposite
    // of the map above
    private static final Map<Double, Note> frequencyToNoteMap = new HashMap<>();

    // The notes listed in ascending order
    private static final List<Double> notesInOrder = new ArrayList<Double>();

    // A singleton instance of the note map
    private static FrequencyNoteMap frequencyNoteMap = null;

    // Note to position Map
    private static final Map<Note, Integer> notePositionMap = new HashMap<>();

    // Position to note Map
    private static final Map<Integer, Note> positionNoteMap = new HashMap<>();

    /**
     * Method to acquire the singleton instance of the note map class
     * @return
     */
    public static FrequencyNoteMap getInstance() {
        if (frequencyNoteMap == null) {
            frequencyNoteMap = new FrequencyNoteMap();
        }

        return frequencyNoteMap;
    }

    /**
     * Init constructor for the note map
     */
    private FrequencyNoteMap() {

        // Manually populate the notes to frequencies, quite a mundane way, comment on how
        // to make this more efficient in code level
        noteToFrequencyMap.put(Note.C0, 16.35); noteToFrequencyMap.put(Note.CSHARP0, 17.32);
        noteToFrequencyMap.put(Note.D0, 18.35); noteToFrequencyMap.put(Note.DSHARP0, 19.45);
        noteToFrequencyMap.put(Note.E0, 20.60); noteToFrequencyMap.put(Note.F0, 21.83);
        noteToFrequencyMap.put(Note.FSHARP0, 23.12); noteToFrequencyMap.put(Note.G0, 24.50);
        noteToFrequencyMap.put(Note.GSHARP0, 25.96); noteToFrequencyMap.put(Note.A0, 27.50);
        noteToFrequencyMap.put(Note.ASHARP0, 29.14); noteToFrequencyMap.put(Note.B0, 30.87);

        noteToFrequencyMap.put(Note.C1, 32.70); noteToFrequencyMap.put(Note.CSHARP1, 34.65);
        noteToFrequencyMap.put(Note.D1, 36.71); noteToFrequencyMap.put(Note.DSHARP1, 38.89);
        noteToFrequencyMap.put(Note.E1, 41.20); noteToFrequencyMap.put(Note.F1, 43.61);
        noteToFrequencyMap.put(Note.FSHARP1, 46.25); noteToFrequencyMap.put(Note.G1, 49.00);
        noteToFrequencyMap.put(Note.GSHARP1, 51.91); noteToFrequencyMap.put(Note.A1, 55.00);
        noteToFrequencyMap.put(Note.ASHARP1, 58.35); noteToFrequencyMap.put(Note.B1, 61.74);

        noteToFrequencyMap.put(Note.C2, 65.41); noteToFrequencyMap.put(Note.CSHARP2, 69.30);
        noteToFrequencyMap.put(Note.D2, 73.42); noteToFrequencyMap.put(Note.DSHARP2, 77.78);
        noteToFrequencyMap.put(Note.E2, 82.41); noteToFrequencyMap.put(Note.F2, 87.31);
        noteToFrequencyMap.put(Note.FSHARP2, 92.50); noteToFrequencyMap.put(Note.G2, 98.00);
        noteToFrequencyMap.put(Note.GSHARP2, 108.83); noteToFrequencyMap.put(Note.A2, 110.00);
        noteToFrequencyMap.put(Note.ASHARP2, 116.54); noteToFrequencyMap.put(Note.B2, 123.47);

        noteToFrequencyMap.put(Note.C3, 130.81); noteToFrequencyMap.put(Note.CSHARP3, 138.59);
        noteToFrequencyMap.put(Note.D3, 146.83); noteToFrequencyMap.put(Note.DSHARP3, 155.56);
        noteToFrequencyMap.put(Note.E3, 164.81); noteToFrequencyMap.put(Note.F3, 174.61);
        noteToFrequencyMap.put(Note.FSHARP3, 185.00); noteToFrequencyMap.put(Note.G3, 196.00);
        noteToFrequencyMap.put(Note.GSHARP3, 207.65); noteToFrequencyMap.put(Note.A3, 220.00);
        noteToFrequencyMap.put(Note.ASHARP3, 233.08); noteToFrequencyMap.put(Note.B3, 246.94);

        noteToFrequencyMap.put(Note.C4, 261.63); noteToFrequencyMap.put(Note.CSHARP4, 277.18);
        noteToFrequencyMap.put(Note.D4, 293.66); noteToFrequencyMap.put(Note.DSHARP4, 311.13);
        noteToFrequencyMap.put(Note.E4, 329.63); noteToFrequencyMap.put(Note.F4, 349.23);
        noteToFrequencyMap.put(Note.FSHARP4, 369.99); noteToFrequencyMap.put(Note.G4, 392.00);
        noteToFrequencyMap.put(Note.GSHARP4, 415.30); noteToFrequencyMap.put(Note.A4, 440.00);
        noteToFrequencyMap.put(Note.ASHARP4, 466.16); noteToFrequencyMap.put(Note.B4, 493.88);

        noteToFrequencyMap.put(Note.C5, 523.25); noteToFrequencyMap.put(Note.CSHARP5, 554.37);
        noteToFrequencyMap.put(Note.D5, 587.33); noteToFrequencyMap.put(Note.DSHARP5, 622.25);
        noteToFrequencyMap.put(Note.E5, 659.25); noteToFrequencyMap.put(Note.F5, 698.46);
        noteToFrequencyMap.put(Note.FSHARP5, 739.99); noteToFrequencyMap.put(Note.G5, 783.99);
        noteToFrequencyMap.put(Note.GSHARP5, 830.61); noteToFrequencyMap.put(Note.A5, 880.00);
        noteToFrequencyMap.put(Note.ASHARP5, 932.33); noteToFrequencyMap.put(Note.B5, 987.77);

        noteToFrequencyMap.put(Note.C6, 1046.50); noteToFrequencyMap.put(Note.CSHARP6, 1108.73);
        noteToFrequencyMap.put(Note.D6, 1174.66); noteToFrequencyMap.put(Note.DSHARP6, 1244.51);
        noteToFrequencyMap.put(Note.E6, 1318.51); noteToFrequencyMap.put(Note.F6, 1396.91);
        noteToFrequencyMap.put(Note.FSHARP6, 1479.98); noteToFrequencyMap.put(Note.G6, 1567.98);
        noteToFrequencyMap.put(Note.GSHARP6, 1661.22); noteToFrequencyMap.put(Note.A6, 1760.00);
        noteToFrequencyMap.put(Note.ASHARP6, 1864.66); noteToFrequencyMap.put(Note.B6, 1975.53);

        noteToFrequencyMap.put(Note.C7, 2093.00); noteToFrequencyMap.put(Note.CSHARP7, 2217.46);
        noteToFrequencyMap.put(Note.D7, 2349.32); noteToFrequencyMap.put(Note.DSHARP7, 2489.02);
        noteToFrequencyMap.put(Note.E7, 2637.02); noteToFrequencyMap.put(Note.F7, 2793.83);
        noteToFrequencyMap.put(Note.FSHARP7, 2959.96); noteToFrequencyMap.put(Note.G7, 3135.96);
        noteToFrequencyMap.put(Note.GSHARP7, 3322.44); noteToFrequencyMap.put(Note.A7, 3520.00);
        noteToFrequencyMap.put(Note.ASHARP7, 3729.31); noteToFrequencyMap.put(Note.B7, 3951.07);

        noteToFrequencyMap.put(Note.C8, 4186.01); noteToFrequencyMap.put(Note.CSHARP8, 4434.92);
        noteToFrequencyMap.put(Note.D8, 4698.63); noteToFrequencyMap.put(Note.DSHARP8, 4978.03);
        noteToFrequencyMap.put(Note.E8, 5274.04); noteToFrequencyMap.put(Note.F8, 5587.65);
        noteToFrequencyMap.put(Note.FSHARP8, 5919.91); noteToFrequencyMap.put(Note.G8, 6271.93);
        noteToFrequencyMap.put(Note.GSHARP8, 6644.88); noteToFrequencyMap.put(Note.A8, 7040.00);
        noteToFrequencyMap.put(Note.ASHARP8, 7458.62); noteToFrequencyMap.put(Note.B8, 7902.13);

        // Construct the reverse of the frequency of the note to frequency map
        // for faster note value lookups and linear interpolation
        for (Map.Entry<Note, Double> entry : noteToFrequencyMap.entrySet()) {
            Note note = entry.getKey();
            Double frequency = entry.getValue();

            frequencyToNoteMap.put(frequency, note);
        }

        // Get the sorted order of nodes for purposes of linear interpolation etc
        Set<Double> noteValues = frequencyToNoteMap.keySet();
        List<Double> notesInOrder = new ArrayList<>(noteValues);
        Collections.sort(notesInOrder);

        // Temporary, put the note map to note position
        // TODO : Figure out the actual meaning of the chroma vector
        notePositionMap.put(Note.A4, 1);
        notePositionMap.put(Note.ASHARP4, 2);
        notePositionMap.put(Note.B4, 3);
        notePositionMap.put(Note.C4, 4);
        notePositionMap.put(Note.CSHARP4, 5);
        notePositionMap.put(Note.D4, 6);
        notePositionMap.put(Note.DSHARP4, 7);
        notePositionMap.put(Note.E4, 8);
        notePositionMap.put(Note.F4, 9);
        notePositionMap.put(Note.FSHARP4, 10);
        notePositionMap.put(Note.G4, 11);
        notePositionMap.put(Note.GSHARP4, 12);

        for (Map.Entry<Note, Integer> entry : notePositionMap.entrySet()) {
            Note note = entry.getKey();
            Integer position = entry.getValue();

            positionNoteMap.put(position, note);
        }
    }

    public Note getNoteGivenPosition(int position) {
        return positionNoteMap.get(position);
    }

    public int getPositionGivenNote(Note note) {
        return notePositionMap.get(note);
    }
}
