package com.modulo7.image;

import com.modulo7.common.exceptions.Modulo7InvalidMusicXMLFile;
import com.modulo7.common.interfaces.AbstractAnalyzer;
import com.modulo7.common.utils.JarRunner;
import com.modulo7.common.utils.Modulo7Utils;
import com.modulo7.musicstatmodels.representation.Song;
import com.modulo7.othersources.BasicMusicXMLParser;

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
    private String intermediateMusicXMLLocation = "/home/asanyal/mySheet.xml";

    /**
     * Sheet file location
     * @param sheetFileLocation
     */
    public AudiverisSheetAnalyzer(final String sheetFileLocation) {
        this.sheetFileLocation = sheetFileLocation;
    }

    @Override
    public Song getSongRepresentation() {
        final String audiverisJar = Modulo7Utils.getAudiverisJarLocation() + File.separator + "audiveris.jar";

        JarRunner jr;

        try {
            jr = new JarRunner(new File(audiverisJar));
            jr.run(new String[]{"-batch", "-input", sheetFileLocation, "-export", intermediateMusicXMLLocation });
            AbstractAnalyzer musicXXMLAnalyzer = new BasicMusicXMLParser(intermediateMusicXMLLocation);
            return musicXXMLAnalyzer.getSongRepresentation();

        } catch (ClassNotFoundException | IOException | NoSuchMethodException | InvocationTargetException | IllegalAccessException | Modulo7InvalidMusicXMLFile e) {
            e.printStackTrace();
        }

        // TODO : Fix this
        return null;
    }

    public static void main(String args[]) {
        AbstractAnalyzer sheetAnalyzer = new AudiverisSheetAnalyzer("/usr/bin/audiveris/AudiverisApp/examples/allegretto.png");
        sheetAnalyzer.getSongRepresentation();
    }
}
