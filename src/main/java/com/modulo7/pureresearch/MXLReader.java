package com.modulo7.pureresearch;

import com.modulo7.common.exceptions.Modulo7InvalidMusicXMLFile;
import com.modulo7.common.exceptions.Modulo7NoSuchFileOrDirectoryException;
import com.modulo7.common.interfaces.AbstractAnalyzer;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;
import com.modulo7.othersources.BasicMusicXMLParser;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by asanyal on 10/27/15.
 *
 * MXL files are very similar to musicxml files, with the slight difference in that its a compression format
 * on top of the standard music xml format
 */
public class MXLReader implements AbstractAnalyzer {

    // The file object from which the zip is extracted
    private File file;

    // The logger for MXL file reader
    private static final Logger logger = Logger.getLogger(MXLReader.class);

    public MXLReader(final String fileName) throws Modulo7InvalidMusicXMLFile {
        if (fileName.contains(".mxl")) {
            this.file = new File(fileName);
        } else {
            throw new Modulo7InvalidMusicXMLFile("This particular file is not a mxl compressed music xml file:" + fileName);
        }
    }

    @Override
    public Song getSongRepresentation() {

        FileInputStream input;
        try {
            input = new FileInputStream(file);
            ZipInputStream zip = new ZipInputStream(input);
            ZipEntry entry;

            while ((entry = zip.getNextEntry()) != null) {
                final String entryName =  entry.getName();
                if (entryName.equals("musicXML.xml")) {
                    final String outpath = FileUtils.getTempDirectoryPath() + File.separator + "/" + entryName;
                    FileOutputStream outputStream = new FileOutputStream(outpath);
                    int len;
                    byte[] buffer = new byte[2048];
                    while ((len = zip.read(buffer)) > 0) {
                        outputStream.write(buffer, 0, len);
                    }

                    AbstractAnalyzer analyzer = new BasicMusicXMLParser(outpath);
                    return analyzer.getSongRepresentation();
                }
            }
        } catch (IOException | Modulo7InvalidMusicXMLFile | Modulo7NoSuchFileOrDirectoryException e) {
            logger.error(e.getMessage());
        }

        return null;
    }

    /**
     * Test case
     * @param args
     */
    public static void main(String args[]) throws Modulo7InvalidMusicXMLFile {
        AbstractAnalyzer analyzer = new MXLReader("/home/asanyal/Downloads/Wikifonia/Nat Adderly - Teaneck.mxl");
        Song song = analyzer.getSongRepresentation();
        System.out.println(song.getNumVoices());
    }
}
