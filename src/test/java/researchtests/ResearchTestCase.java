package researchtests;

import com.modulo7.common.exceptions.Modulo7InvalidMusicXMLFile;
import com.modulo7.common.exceptions.Modulo7NoSuchFileOrDirectoryException;
import com.modulo7.pureresearch.lastfm.*;
import com.modulo7.pureresearch.metadataestimation.PrecRec;
import com.modulo7.pureresearch.metadataestimation.ROCDataPoint;
import com.modulo7.pureresearch.metadataestimation.TagTratumDatabase;
import com.modulo7.pureresearch.metadataestimation.genreestimation.GenreEstimation;
import com.modulo7.pureresearch.metadataestimation.genreestimation.MaxFrequencyGenreEstimation;
import com.modulo7.pureresearch.metadataestimation.genreestimation.NaiveGenreEstimation;
import com.modulo7.pureresearch.metadataestimation.genreestimation.WeightedGenreEstimation;
import com.modulo7.pureresearch.metadataestimation.tagestimation.MaxFrequencyTagEstimation;
import com.modulo7.pureresearch.metadataestimation.tagestimation.NaiveTagEstimation;
import com.modulo7.pureresearch.metadataestimation.tagestimation.TagEstimation;
import com.modulo7.pureresearch.metadataestimation.tagestimation.WeightedTagEstimation;
import com.modulo7.pureresearch.musicmatch.LyricsBagOfWordsFormat;
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

    /*
    @Test
    public void genrePredictorForLyrics() throws IOException {
        LyricsBagOfWordsFormat formatLoad = new LyricsBagOfWordsFormat("./src/test/researchData/lyricsdata/mxm_dataset_train.txt");
        final TagTratumDatabase genreLabels = new TagTratumDatabase("./src/test/researchData/genretags/msd_tagtraum_cd1.tag");
        genreLabels.syncLyrics(formatLoad);
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
     * @throws java.io.IOException
     * @throws ClassNotFoundException
     */
    /*
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

        final TagEstimation estimation = new NaiveTagEstimation(testSet, trainSet);
        final TagEstimation weightedTagEstimation = new WeightedTagEstimation(testSet, trainSet);
        final TagEstimation maxFreqTagEstimation = new MaxFrequencyTagEstimation(testSet, trainSet);

        Map<SongBagLyricsAndMetadata, Map<String, Integer>> naiveTags = estimation.getEstimatedTags();
        Map<SongBagLyricsAndMetadata, Map<String, Integer>> weightedTags = weightedTagEstimation.getEstimatedTags();
        Map<SongBagLyricsAndMetadata, Map<String, Integer>> maxFreqTags = maxFreqTagEstimation.getEstimatedTags();

        // Abandon track, not an efficient test case in the long term
        double estimatedTagHits = estimateTagHits(naiveTags);

        ois.close();
        fis.close();
    }
    */

    /*
    @Test
    public void genreTagLyricsTest() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("./src/test/researchData/lyricsGenreEXPT.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        final Set<SongBagLyricsGenreMap> lyricsMappedToGenreEntries = (HashSet<SongBagLyricsGenreMap>) ois. readObject();
        final List<SongBagLyricsGenreMap> lyricsMetaBagList = new ArrayList<>(lyricsMappedToGenreEntries);
        Collections.sort(lyricsMetaBagList, new SongBagLyricsGenreComparator());

        int totalSize = lyricsMetaBagList.size() / 5;
        int testSize = totalSize / 100;

        final Set<SongBagLyricsGenreMap> testSet = new HashSet<>();
        final Set<SongBagLyricsGenreMap> trainSet = new HashSet<>();

        for (int i = 0; i < testSize; i++) {
            testSet.add(lyricsMetaBagList.get(i));
        }

        for (int i = testSize + 1; i < totalSize; i++) {
            trainSet.add(lyricsMetaBagList.get(i));
        }

        // GenreEstimation estimation = new NaiveGenreEstimation(testSet, trainSet);
        // Map<SongBagLyricsGenreMap, Set<String>> naiveGenreEstimates = estimation.getEstimatedGenres();

        GenreEstimation estimation1 = new MaxFrequencyGenreEstimation(testSet, trainSet);
        Map<SongBagLyricsGenreMap, Set<String>> maxFreqEstimates = estimation1.getEstimatedGenres();

        final PrecRec maxFreqAverages = getAveragePrecRec(maxFreqEstimates);

        System.out.println("Recall is " + maxFreqAverages.getRecall() +","+ "Precision is" + maxFreqAverages.getPrecision());
        System.out.print("Hala");
    }
    */

    /*
    @Test
    public void weightedTagTest() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("./src/test/researchData/lyricsGenreEXPT.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        final Set<SongBagLyricsGenreMap> lyricsMappedToGenreEntries = (HashSet<SongBagLyricsGenreMap>) ois.readObject();
        final List<SongBagLyricsGenreMap> lyricsMetaBagList = new ArrayList<>(lyricsMappedToGenreEntries);
        Collections.sort(lyricsMetaBagList, new SongBagLyricsGenreComparator());

        double doubleTotalSize = lyricsMetaBagList.size() / 2.5;
        int totalSize = (int) doubleTotalSize;
        int testSize = totalSize / 100;
        final Set<SongBagLyricsGenreMap> testSet = new HashSet<>();
        final Set<SongBagLyricsGenreMap> trainSet = new HashSet<>();

        for (int i = 0; i < testSize; i++) {
            testSet.add(lyricsMetaBagList.get(i));
        }

        for (int i = testSize + 1; i < totalSize; i++) {
            trainSet.add(lyricsMetaBagList.get(i));
        }

        PrintWriter writer = new PrintWriter("./src/test/researchData/precRec.csv");
        writer.println("Precision, Recall");

        for (int i = 0; i < 100; i++) {
            GenreEstimation weightedGenreEstimation = new WeightedGenreEstimation(testSet, trainSet, i);
            final Map<SongBagLyricsGenreMap, Set<String>> maxFreqEstimates = weightedGenreEstimation.getEstimatedGenres();
            final PrecRec precRec = getAveragePrecRec(maxFreqEstimates);
            writer.println(precRec.getPrecision() + ", " + precRec.getRecall());
            writer.flush();
        }

        writer.close();
    }
    */

    @Test
    public void maxFrequencyTagTest() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("./src/test/researchData/lyricsGenreEXPT.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        final Set<SongBagLyricsGenreMap> lyricsMappedToGenreEntries = (HashSet<SongBagLyricsGenreMap>) ois.readObject();
        final List<SongBagLyricsGenreMap> lyricsMetaBagList = new ArrayList<>(lyricsMappedToGenreEntries);
        Collections.sort(lyricsMetaBagList, new SongBagLyricsGenreComparator());

        double doubleTotalSize = lyricsMetaBagList.size() / 2.5;
        int totalSize = (int) doubleTotalSize;
        int testSize = totalSize / 100;
        final Set<SongBagLyricsGenreMap> testSet = new HashSet<>();
        final Set<SongBagLyricsGenreMap> trainSet = new HashSet<>();

        for (int i = 0; i < testSize; i++) {
            testSet.add(lyricsMetaBagList.get(i));
        }

        for (int i = testSize + 1; i < totalSize; i++) {
            trainSet.add(lyricsMetaBagList.get(i));
        }

        // PrintWriter writer = new PrintWriter("./src/test/researchData/maxfreqROC.csv");

        for (int i = 0; i < 100; i++) {
            double threshHold = (double) (i / 100);
            GenreEstimation estimation = new MaxFrequencyGenreEstimation(testSet, trainSet,threshHold);
            final Map<SongBagLyricsGenreMap, Set<String>> maxFreqEstimates = estimation.getEstimatedGenres();
            Set<String> allSeenGenres = estimation.getAllSeenGenres();
            final ROCDataPoint point = getROCDataPoint(maxFreqEstimates, allSeenGenres);
            System.out.println(point.getFalsePositiveRate() )
        }
    }

    /**
     * Gets the average precision and recall values as appropriate
     * @param genreEstimates
     * @return
     */
    private PrecRec getAveragePrecRec(final Map<SongBagLyricsGenreMap, Set<String>> genreEstimates) {

        double recallSum = 0.0;
        double precisionSum = 0.0;

        for (Map.Entry<SongBagLyricsGenreMap, Set<String>> genreEstimate : genreEstimates.entrySet()) {
            Set<String> predictedLabels = genreEstimate.getValue();
            Set<String> actualLabels = genreEstimate.getKey().getLabels().getGenreList();

            Set<String> intersection = new HashSet<>(predictedLabels);
            intersection.retainAll(actualLabels);

            if (predictedLabels.size() != 0) {
                precisionSum += (double) intersection.size() / predictedLabels.size();
            }

            recallSum += (double) intersection.size() / actualLabels.size();
        }

        recallSum /= genreEstimates.size();
        precisionSum /= genreEstimates.size();

        return new PrecRec(precisionSum, recallSum);
    }

    /**
     * Gets an ROC data point
     * @param genreEstimates
     * @param allSeenGenres
     * @return
     */
    private ROCDataPoint getROCDataPoint(final Map<SongBagLyricsGenreMap, Set<String>> genreEstimates, final Set<String> allSeenGenres) {
        double tpr = 0.0;
        double tnr = 0.0;

        for (Map.Entry<SongBagLyricsGenreMap, Set<String>> genreEstimate : genreEstimates.entrySet()) {
            Set<String> predictedLabels = genreEstimate.getValue();
            Set<String> actualLabels = genreEstimate.getKey().getLabels().getGenreList();

            Set<String> intersection = new HashSet<>(predictedLabels);
            intersection.retainAll(actualLabels);

            tpr += (double) intersection.size() / actualLabels.size();

            final Set<String> notRelevant = new HashSet<>(allSeenGenres);
            notRelevant.removeAll(actualLabels);

            Set<String> notRelevantRetrieved = new HashSet<>(notRelevant);
            notRelevantRetrieved.retainAll(predictedLabels);

            tnr += (1.0 - notRelevantRetrieved.size() / notRelevant.size());
        }

        return new ROCDataPoint(tpr / genreEstimates.size(), tnr / genreEstimates.size());
    }
}
