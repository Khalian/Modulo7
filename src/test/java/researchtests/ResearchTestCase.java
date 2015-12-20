package researchtests;

import com.modulo7.common.exceptions.Modulo7InvalidMusicXMLFile;
import com.modulo7.common.exceptions.Modulo7NoSuchFileOrDirectoryException;
import com.modulo7.common.utils.AvroUtils;
import com.modulo7.common.utils.Modulo7Globals;
import com.modulo7.common.utils.Modulo7Utils;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;
import com.modulo7.nlp.lyrics.Lyrics;
import com.modulo7.pureresearch.MXLReader;
import com.modulo7.pureresearch.lastfm.LastFMDataSet;
import com.modulo7.pureresearch.lastfm.SongBagLyricsAndMetadata;
import com.modulo7.pureresearch.lastfm.SongBagLyricsComparator;
import com.modulo7.pureresearch.metadataestimation.NaiveTagEstimation;
import com.modulo7.pureresearch.metadataestimation.TagEstimation;
import com.modulo7.pureresearch.musicmatch.BagOfWordsDataElement;
import com.modulo7.pureresearch.musicmatch.LyricsBagOfWordsFormat;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * Created by asanyal on 9/14/15.
 *
 * Research specific test cases, not meant for production grade code
 *
 * Uncomment only when you have the necessary setup for running the research test cases
 *
 */
public class ResearchTestCase {

    /*
    @Test
    public void smdTest() throws InvalidMidiDataException, Modulo7InvalidMusicXMLFile, EchoNestException, Modulo7NoSuchFileException {
        final String smdDir = "./src/test/researchData";
        DatabaseEngine engine = new DatabaseEngine(smdDir, smdDir);
        engine.dynamicBuildDataSet();
    }
    */

    /*
    @Test
    public void msdSubSetTest() {
        final String msdDir = "./src/test/researchData/msd";
        Set<String> allLocations = Modulo7Utils.listAllFiles(msdDir);

        for (final String location : allLocations) {
            AbstractAnalyzer analyzer = new MSDSongParser(location);
            final Song song = analyzer.getSongRepresentation();
            // AvroUtils.serialize(song, );
        }
    }
    */

    // The distribution of key signatures
    // private Map<KeySignature, Integer> countsOfKeySignatures = new HashMap<>();

    /**
     * Benchmarking for the mxl files, useful to test for the accuracy and efficacy of the tonal search
     * algorithm
     *
     * @throws Modulo7NoSuchFileOrDirectoryException
     * @throws Modulo7InvalidMusicXMLFile
     */

    /*
    @Test
    public void testAllMXLs() throws Modulo7NoSuchFileOrDirectoryException {
        // This is one giant ass test case

        final Set<String> wikifoniaDataset = Modulo7Utils.listAllFiles("/home/asanyal/Downloads/Wikifonia/");
        final Set<Song> allSongs = new HashSet<>();

        int inferred = 0;
        int correctInferred = 0;
        int keySigInFile = 0;

        for (final String location : wikifoniaDataset) {
            MXLReader analyzer;
            try {
                analyzer = new MXLReader(location, true);
                Song song = analyzer.getSongRepresentation();
                if (song != null) {
                    allSongs.add(song);
                    if (analyzer.isForceKeySigInfer()) {
                        inferred++;
                            if (analyzer.isKeySignatureInMusicXMLFile()) {
                            addToCountMap(analyzer.getActualKeySignature());
                            keySigInFile++;
                            if (analyzer.getActualKeySignature().equals(analyzer.getInferredKeySignature())) {
                                correctInferred++;
                            }
                        }
                    }
                }
            } catch (Modulo7InvalidMusicXMLFile e) {
                logger.error(e.getMessage());
            }
        }

        System.out.println("haha");
    }

    private void addToCountMap(final KeySignature actualKeySignature) {
        Integer count = countsOfKeySignatures.get(actualKeySignature);
        if (count == null) {
            countsOfKeySignatures.put(actualKeySignature, 1);
        } else {
            countsOfKeySignatures.put(actualKeySignature, count + 1);
        }
    }
    */

    /*
    @Test
    public void LyricsGroundTruthResults() throws IOException {
        LyricsBagOfWordsFormat formatLoad = new LyricsBagOfWordsFormat("./src/test/researchData/lyricsdata/mxm_dataset_train.txt");
    }
    */

    /*
    @Test
    public void lastFMTest() throws Modulo7NoSuchFileOrDirectoryException, IOException {
        LastFMDataSet dataSet = new LastFMDataSet("./src/test/researchData/lastfm_subset");

    }
    */

    /**
     * Load parts of the million song data set
     */
    /*
    @Test
    public void msdLoadAndBuildSubsetTest() throws Modulo7NoSuchFileOrDirectoryException {

        final String msdDir = "./src/test/researchData/MillionSongSubset";
        Set<String> allLocations = Modulo7Utils.listAllFiles(msdDir);

        final Map<String, Song> idSongMap = new HashMap<>();

        for (final String location : allLocations) {
            MSDSongParser analyzer = new MSDSongParser(location);
            final Song song = analyzer.getSongRepresentation();
            idSongMap.put(analyzer.getTrackId(), song);
        }

        final LastFMDataSet dataSet = new LastFMDataSet("./src/test/researchData/lastfm_subset");
    }
    */

    /*
    @Test
    public void lastFMTagPredictorForLyrics() throws IOException {
        LyricsBagOfWordsFormat formatLoad = new LyricsBagOfWordsFormat("./src/test/researchData/lyricsdata/mxm_dataset_train.txt");
        final LastFMDataSet dataSet = new LastFMDataSet("./src/test/researchData/lastfm_subset");
        dataSet.syncLyrics(formatLoad);
    }
    */


    /**
     * Wikifonia serialization test, producing a scatter plot of data set
     *
     * @throws Modulo7NoSuchFileOrDirectoryException
     * @throws Modulo7InvalidMusicXMLFile
     */
    /*
    @Test
    public void wikifoniaSerializationTest() throws Modulo7NoSuchFileOrDirectoryException, Modulo7InvalidMusicXMLFile, FileNotFoundException, UnsupportedEncodingException {
        Set<String> wikifoniaFiles = Modulo7Utils.listAllFiles("./src/test/researchData/Wikifonia");
        final Map<Long, Long> lenToSerializedLen = new HashMap<>();
        for (final String fileLoc : wikifoniaFiles) {
            final MXLReader reader = new MXLReader(fileLoc, false);
            final Song songRep = reader.getSongRepresentation();
            final String fileNameWithoutPath = FilenameUtils.getBaseName(fileLoc);
            final String serializeLocation = "./src/test/researchData/WikifoniaSerialized/" + fileNameWithoutPath + Modulo7Globals.EXTENSION_TO_SERIALIZED_FILES;
            AvroUtils.serialize(serializeLocation, songRep);

            File fileSer = new File(serializeLocation);
            File fileNormal = new File(fileLoc);

            long len = fileNormal.length();
            long serlen = fileSer.length();
            lenToSerializedLen.put(len, serlen);
        }

        final List<Long> lenList = new ArrayList<>(lenToSerializedLen.keySet());
        Collections.sort(lenList);

        PrintWriter writer = new PrintWriter("./src/test/researchData/NormalVsDeser.csv");

        writer.println("MXL File Size, M7 File Size");

        for (final Long longLen : lenList) {
            writer.println(longLen + "," + lenToSerializedLen.get(longLen));
        }

        writer.flush();
        writer.close();
    }
    */

    /**
     * Gets the last fm tag and lyrics map already serialized
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Test
    public void getlastFMTagsLyricsMap() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("./src/test/researchData/lyricsEXPT.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        final Set<SongBagLyricsAndMetadata> lyricsMappedTagEntries = (HashSet<SongBagLyricsAndMetadata>) ois.readObject();
        final List<SongBagLyricsAndMetadata> lyricsMetaBagList = new ArrayList<>(lyricsMappedTagEntries);
        Collections.sort(lyricsMetaBagList, new SongBagLyricsComparator());

        int totalSize = lyricsMetaBagList.size();
        int testSize = totalSize / 10;

        final Set<SongBagLyricsAndMetadata> testSet = new HashSet<>();
        final Set<SongBagLyricsAndMetadata> trainSet = new HashSet<>();

        for (int i = 0; i < testSize; i++) {
            testSet.add(lyricsMetaBagList.get(i));
        }

        for (int i = testSize + 1; i < totalSize; i++) {
            trainSet.add(lyricsMetaBagList.get(i));
        }

        TagEstimation estimation = new NaiveTagEstimation(testSet, trainSet)

        ois.close();
        fis.close();
    }
}
