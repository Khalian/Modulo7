package com.modulo7.playback;

import nu.xom.ParsingException;
import org.apache.log4j.Logger;
import org.jfugue.integration.MusicXmlParser_R;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
import org.staccato.StaccatoParserListener;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by asanyal on 10/22/15.
 *
 * Playback for music xml
 */
public class MusicXMLPlayback implements AbstractPlayBack {

    // File location of music xml file
    private String musicXMLFileName;

    // Logger for music xml playback
    private static final Logger logger = Logger.getLogger(MusicXMLPlayback.class);

    /**
     * Default constructor
     * @param fileName
     */
    public MusicXMLPlayback(final String fileName) {
        this.musicXMLFileName = fileName;
    }

    @Override
    public void play() {
        try {
            MusicXmlParser_R parser = new MusicXmlParser_R();
            StaccatoParserListener listener = new StaccatoParserListener();
            parser.addParserListener(listener);
            parser.parse(musicXMLFileName);
            Player player = new Player();
            final Pattern musicXMLPattern = listener.getPattern();
            player.play(musicXMLPattern);
        } catch (ParserConfigurationException | IOException | ParsingException e) {
            logger.error(e);
        }
    }
}
