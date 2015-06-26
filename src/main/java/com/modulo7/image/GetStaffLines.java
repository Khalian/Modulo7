package com.modulo7.image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by asanyal on 6/21/2015.
 *
 * Basic class for getting the staff lines on a sheet
 * using the hogue lines algorithm
 *
 * Inspired by and refactored from : https://github.com/sarahwalters/piano-poe
 * Special thanks to Sarah Walters for the logic
 *
 */
public class GetStaffLines {

    static {
        // System.loadLibrary(org.opencv.core.Core.NATIVE_LIBRARY_NAME);
    }

    private void extractStaffLines(String imageFilePath) throws IOException {
        File input = new File(imageFilePath);
        BufferedImage image = ImageIO.read(input);

        //convert Buffered Image to Mat.

    }
}
