package com.modulo7.playback;

import com.modulo7.common.utils.JarRunner;
import com.modulo7.common.utils.Modulo7Utils;
import nu.xom.ParsingException;
import nu.xom.ValidityException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.jfugue.integration.MusicXmlParser;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
import org.staccato.StaccatoParserListener;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by asanyal on 10/24/15.
 *
 * Sheet music file playback class
 */
public class SheetMusicPlayBack implements AbstractPlayBack {

    // Sheet music file location
    private String sheetFileLocation;

    // Intermediate music xml location
    private String intermediateMusicXMLLocation;

    // Loaded audiveris jar
    private static JarRunner jr;

    // Logger for sheet music analyzer
    private static Logger logger = Logger.getLogger(SheetMusicPlayBack.class);

    /*
     * The jar needs to be loaded exactly once on the class path
     */
    static {
        final String audiverisJarLocation = Modulo7Utils.getAudiverisJarLocation() + File.separator + "audiveris.jar";
        try {
            jr = new JarRunner(new File(audiverisJarLocation));
        } catch (ClassNotFoundException | IOException | NoSuchMethodException e) {
            logger.error(e.getStackTrace());
        }
    }

    /**
     * Basic constructor for music xml playback
     * @param sheetFileLocation
     */
    public SheetMusicPlayBack(final String sheetFileLocation) {
        this.sheetFileLocation = sheetFileLocation;
        intermediateMusicXMLLocation = FileUtils.getTempDirectoryPath() +
                File.separator + FilenameUtils.getBaseName(sheetFileLocation) + ".xml";
    }

    @Override
    public void play() {
        try {
            jr.run(new String[]{"-batch", "-input", sheetFileLocation, "-export", intermediateMusicXMLLocation });
            MusicXmlParser parser = new MusicXmlParser();
            StaccatoParserListener listener = new StaccatoParserListener();
            parser.addParserListener(listener);
            parser.parse(intermediateMusicXMLLocation);
            Player player = new Player();
            final Pattern musicXMLPattern = listener.getPattern();
            player.play(musicXMLPattern);
        } catch (IllegalAccessException | InvocationTargetException | ParserConfigurationException | IOException| ParsingException e) {
            logger.error(e.getMessage());
        }
    }
}
