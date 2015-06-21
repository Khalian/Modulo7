package com.modulo7.crawler;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by asanyal on 6/20/2015.
 *
 * A miner class which mines music sheets to be later processed
 * by an image processing library for various work
 */
public class BasicImageCrawler implements Runnable {
    /**
     * Downloads a sheet music file
     * @param urlOfSheetFile
     */

    private static String STORAGE_LOCATION =
            System.getenv("MODULO7_ROOT") + File.separator + "resources" + File.separator + "crawledsheets" + File.separator;

    private void downloadSheetFile(final String urlOfSheetFile) {

        String fileName = extractFileNameFromURL(urlOfSheetFile);

        try {
            // Creating URL objects
            URL url = new URL(urlOfSheetFile);
            URLConnection urlConnection = url.openConnection();

            // creating the input stream from google image
            BufferedInputStream in = new BufferedInputStream(urlConnection.getInputStream());

            // my local file writer, output stream
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(STORAGE_LOCATION + fileName));

            // until the end of data, keep saving into file.
            int i;
            while ((i = in.read()) != -1) {
                out.write(i);
            }
            out.flush();

            // closing all the file handlers
            out.close();
            in.close();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    /**
     * Extracts the file name from the url
     * @return
     */
    private String extractFileNameFromURL(String urlOfSheetFile) {
        int indexOfFileNameStart = urlOfSheetFile.lastIndexOf('/') + 1;
        return urlOfSheetFile.substring(indexOfFileNameStart);
    }

    public static void test() throws IOException {
        BasicImageCrawler crawler = new BasicImageCrawler();
        // Sample test download
        crawler.downloadSheetFile("http://middle-ear-music.com/yahoo_site_admin/assets/images/Valse_et_Tro_Berlioz.58152010.gif");
    }

    @Override
    public void run() {

    }
}
