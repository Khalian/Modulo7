package com.modulo7.engine;

import com.modulo7.common.exceptions.Modulo7DataBaseNotSerializedException;
import com.modulo7.common.utils.MusicSources;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;
import com.modulo7.playback.*;

/**
 * Created by asanyal on 10/24/15.
 *
 * An engine class to play back songs, which allows modulo7 to handle
 * arbitrary music sources and play them back, this is necessary as the user
 */
public class PlaybackEngine {

    // A handle to the database engine, fast lookup on source and location of song
    private DatabaseEngine engine;

    /**
     * Constructor for the playback engine
     * @param engine
     */
    public PlaybackEngine(final DatabaseEngine engine) {
        this.engine = engine;
    }

    /**
     * Play a given song
     *
     * @param location
     * @throws Modulo7DataBaseNotSerializedException
     */
    public void playSong(final String location) throws Modulo7DataBaseNotSerializedException {

        final Song song = engine.getSongGivenLocation(location);
        if (song != null) {
            if (song.getSource().equals(MusicSources.MIDI)) {
                AbstractPlayBack playBack = new MidiPlayBack(location);
                playBack.play();
            } else if (song.getSource().equals(MusicSources.MP3)) {
                AbstractPlayBack playBack = new MP3PlayBack(location);
                playBack.play();
            } else if (song.getSource().equals(MusicSources.MUSIC_XML_FILE)) {
                AbstractPlayBack playBack = new MusicXMLPlayBack(location);
                playBack.play();
            } else if (song.getSource().equals(MusicSources.SHEET_MUSIC)) {
                AbstractPlayBack playBack = new SheetMusicPlayBack(location);
                playBack.play();
            }
        }
    }
}
