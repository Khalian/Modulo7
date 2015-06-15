import org.pdfbox.pdmodel.PDDocument;
import org.pdfbox.pdmodel.PDPage;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

public class pdfToJPGConvert {

    final static Logger logger = Logger.getLogger(pdfToJPGConvert.class.getName());

    /*
    public static void main(String[] args) {
        final String location = System.getenv("MODULO7_ROOT") + File.separator
                + "resources" + File.separator + "samplesheets" + File.separator  + "jesu-joy-of-mans-desiring-piano-solo.pdf";
        selectPdf(location);
    }
    */

    //allow images selection for converting
    public static void selectPdfAndConvert(final String location) {

        convertPDFToJPG(location);

        /*
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF", "pdf");
        chooser.setFileFilter(filter);
        chooser.setMultiSelectionEnabled(false);
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            convertPDFToJPG(file.toString());
        }
        */
    }

    public static void convertPDFToJPG(final String src) {
        try {
            //load pdf file in the document object
            PDDocument doc = PDDocument.load(new FileInputStream(src));

            //Get all pages from document and store them in a list
            List<PDPage> pages = doc.getDocumentCatalog().getAllPages();

            //create iterator object so it is easy to access each page from the list
            Iterator<PDPage> pageIterator = pages.iterator();
            int count = 1; //count variable used to separate each image file

            //Convert every page of the pdf document to a unique image file
            logger.info("Converter:" + src);

            while (pageIterator.hasNext()) {
                PDPage page = pageIterator.next();
                BufferedImage bi = page.convertToImage();
                ImageIO.write(bi, "jpg", new File("pdfimage" + count + ".jpg"));
                count++;
            }

            logger.info("Conversion complete");
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}