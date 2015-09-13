package com.modulo7.image;

import com.modulo7.common.exceptions.Modulo7InvalidMusicXMLFile;
import com.modulo7.common.interfaces.AbstractAnalyzer;
import com.modulo7.common.utils.JarRunner;
import com.modulo7.common.utils.Modulo7Utils;
import com.modulo7.crawler.utils.MusicSources;
import com.modulo7.musicstatmodels.representation.Song;
import com.modulo7.othersources.BasicMusicXMLParser;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by asanyal on 9/1/15.
 *
 * Sheet analyzer using audiveris followed by my musicxml parser
 * of modulo7
 *
 * Its a difficult process and slowest of the lot and it can only
 * parse modern notation (common practice period and beyond) formats
 * of sheet music
 */
public class AudiverisSheetAnalyzer implements AbstractAnalyzer {

    // Location for sheet music file
    private String sheetFileLocation;

    // Intermediate location for the music XML File
    private String intermediateMusicXMLLocation;

    // Loaded audiveris jar
    private static JarRunner jr;

    /**
     * Sheet file location
     * @param sheetFileLocation
     */
    public AudiverisSheetAnalyzer(final String sheetFileLocation) {
        this.sheetFileLocation = sheetFileLocation;
        intermediateMusicXMLLocation = FileUtils.getTempDirectoryPath() + File.separator + FilenameUtils.getBaseName(sheetFileLocation) + ".xml";
    }

    /*
     * The jar needs to be loaded exactly once on the class path
     */
    static {
        final String audiverisJarLocation = Modulo7Utils.getAudiverisJarLocation() + File.separator + "audiveris.jar";
        try {
            jr = new JarRunner(new File(audiverisJarLocation));
        } catch (ClassNotFoundException | IOException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Song getSongRepresentation() {
        try {
            jr.run(new String[]{"-batch", "-input", sheetFileLocation, "-export", intermediateMusicXMLLocation });
            AbstractAnalyzer musicXXMLAnalyzer = new BasicMusicXMLParser(intermediateMusicXMLLocation, MusicSources.SHEET_MUSIC);
            return musicXXMLAnalyzer.getSongRepresentation();

        } catch (IOException | InvocationTargetException | IllegalAccessException | Modulo7InvalidMusicXMLFile e) {
            e.printStackTrace();
        } finally {
             FileUtils.deleteQuietly(new File(intermediateMusicXMLLocation));
        }

        // Wont reach here but for the sake of completeness
        return null;
    }
}
