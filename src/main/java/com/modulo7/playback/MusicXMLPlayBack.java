package com.modulo7.playback;

import nu.xom.ParsingException;
import nu.xom.ValidityException;
import org.apache.log4j.Logger;
import org.jfugue.integration.MusicXmlParser;
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
public class MusicXMLPlayBack implements AbstractPlayBack {

    private String musicXMLFileName;

    private static final Logger logger = Logger.getLogger(MusicXMLPlayBack.class);

    public MusicXMLPlayBack(final String fileName) {
        this.musicXMLFileName = fileName;
    }

    @Override
    public void play() {
        try {
            MusicXmlParser parser = new MusicXmlParser();
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
