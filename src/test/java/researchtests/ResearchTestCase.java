package researchtests;

import com.echonest.api.v4.EchoNestException;
import com.modulo7.common.exceptions.*;
import com.modulo7.common.utils.AvroUtils;
import com.modulo7.common.utils.Modulo7Globals;
import com.modulo7.common.utils.Modulo7Utils;
import com.modulo7.engine.Modulo7CLI;
import com.modulo7.engine.Modulo7Indexer;
import com.modulo7.engine.Modulo7QueryProcessingEngine;
import com.modulo7.musicstatmodels.representation.metadata.ScaleType;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;
import com.modulo7.pureresearch.MSDSongParser;
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
import org.apache.commons.compress.compressors.FileNameUtil;
import org.apache.commons.io.FilenameUtils;
import org.junit.Test;

import javax.sound.midi.InvalidMidiDataException;
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

    /*
    @Test
    public void maxFrequencyTagTest() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("./src/test/researchData/lyricsGenreEXPT.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        final Set<SongBagLyricsGenreMap> lyricsMappedToGenreEntries = (HashSet<SongBagLyricsGenreMap>) ois.readObject();
        final List<SongBagLyricsGenreMap> lyricsMetaBagList = new ArrayList<>(lyricsMappedToGenreEntries);
        Collections.sort(lyricsMetaBagList, new SongBagLyricsGenreComparator());

        double doubleTotalSize = lyricsMetaBagList.size() / 5.0;
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

        //PrintWriter writer = new PrintWriter("./src/test/researchData/maxFreqROC.csv");
        //writer.println("TPR, FPR");

        for (double threshold = 0.00; threshold <= 0.3 ; threshold += 0.01) {
            GenreEstimation estimation = new MaxFrequencyGenreEstimation(testSet, trainSet, threshold);
            final Map<SongBagLyricsGenreMap, Set<String>> maxFreqEstimates = estimation.getEstimatedGenres();
            Set<String> allSeenGenres = estimation.getAllSeenGenres();
            final ROCDataPoint point = getROCDataPoint(maxFreqEstimates, allSeenGenres);
            System.out.println(point.getTruePositiveRate() + ", " + point.getFalsePositiveRate());
            //writer.flush();
        }

        //writer.close();
    }
    */

    /**
     * Gets the average precision and recall values as appropriate
     * @param genreEstimates
     * @return
     */
    /*
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
    */

    /**
     * Gets an ROC data point
     * @param genreEstimates
     * @param allSeenGenres
     * @return
     */
    /*
    private ROCDataPoint getROCDataPoint(final Map<SongBagLyricsGenreMap, Set<String>> genreEstimates, final Set<String> allSeenGenres) {
        double tpr = 0.0;
        double fpr = 0.0;

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

            fpr += (double) notRelevantRetrieved.size() / notRelevant.size();
        }

        return new ROCDataPoint(tpr / genreEstimates.size(), fpr / genreEstimates.size());
    }
    */

    /**
     * Bench press the msd subset on one comp
     */
    /*
    @Test
    public void benchPressTest() {
        try {
            Set<String> msdFiles = Modulo7Utils.listAllFiles("./src/test/researchData/MillionSongSubset");
            Set<String> alreadyDone = Modulo7Utils.listAllFileNames("./src/test/researchData/MillionSongSubset");

            for (final String msdFile : msdFiles) {
                final MSDSongParser parser = new MSDSongParser(msdFile);
                if (parser.getNumSongs() == 1) {
                    final Song song = parser.getSongRepresentation();
                    AvroUtils.serialize("./src/test/researchData/MillionSongSubsetSerialized/" + parser.getTrackId() +
                            Modulo7Globals.EXTENSION_TO_SERIALIZED_FILES, song);
                }
            }
        } catch (Exception e) {
            // I dont care
        }
    }
    */

    /**
     * This test case is effectively building a similarity block which discards non present songs
     * from the similar song indices
     */
    /*
    @Test
    public void simMaps() throws Modulo7NoSuchFileOrDirectoryException, IOException {
        LastFMDataSet dataSet = new LastFMDataSet("./src/test/researchData/lastfm_subset");
        Map<String, SongBagLyricsAndMetadata> songSims = dataSet.getSongSimilaritySet();
        Set<String> actualSet = Modulo7Utils.listAllFileNames("./src/test/researchData/MillionSongSubsetSerialized");

        Map<String, SongBagLyricsAndMetadata> relevantSongSims = new HashMap<>();

        for (Map.Entry<String, SongBagLyricsAndMetadata> songSim : songSims.entrySet()) {
            final String trackId = songSim.getKey();
            final SongBagLyricsAndMetadata metadata = songSim.getValue();
            if (actualSet.contains(trackId) && metadata.getNumSongSimilars() > 0) {
                relevantSongSims.put(trackId, metadata);
            }
        }

        final Set<String> relevantSongTrackIds = relevantSongSims.keySet();

        for (Map.Entry<String, SongBagLyricsAndMetadata> relevantSong : relevantSongSims.entrySet()) {
            final SongBagLyricsAndMetadata metadata = relevantSong.getValue();
            final Set<SongSimilarityElement> simSet = metadata.getSimilars();
            final Set<SongSimilarityElement> availableSims = new HashSet<>();

            for (final SongSimilarityElement sim : simSet) {
                if (relevantSongTrackIds.contains(sim.getSongID())) {
                    availableSims.add(sim);
                }
            }

            metadata.resetSims(availableSims);
        }

        final Map<String, SongBagLyricsAndMetadata> finalMap = new HashMap<>();

        for (Map.Entry<String, SongBagLyricsAndMetadata> songSim : relevantSongSims.entrySet()) {
            final SongBagLyricsAndMetadata metadata = songSim.getValue();
            if (metadata.getNumSongSimilars() > 0) {
                finalMap.put(songSim.getKey(), metadata);
            }
        }

        FileOutputStream fos = new FileOutputStream("./src/test/researchData/sims.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(finalMap);
        oos.close();
        fos.close();
        System.out.printf("Serialized tag mapped data sims.ser");
    }
    */

    @Test
    public void queryTest() throws IOException, ClassNotFoundException, Modulo7NoSuchFileOrDirectoryException, Modulo7InvalidArgsException,
            InterruptedException, EchoNestException, Modulo7InvalidFileOperationException, Modulo7InvalidMusicXMLFile,
            Modulo7IndexingDirError, Modulo7ParseException, InvalidMidiDataException, Modulo7MalformedM7SQLQuery,
            Modulo7QueryProcessingException, Modulo7DataBaseNotSerializedException {

        FileInputStream fis = new FileInputStream("./src/test/researchData/sims.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        final Map<String, SongBagLyricsAndMetadata> mappedEntries = (HashMap<String, SongBagLyricsAndMetadata>) ois.readObject();
        final Set<String> keys = mappedEntries.keySet();
        final Map<String, SongTotalMeta> semicompleteMapping = new HashMap<>();

        final Set<String> allFiles = Modulo7Utils.listAllFiles("./src/test/researchData/MillionSongSubsetSerialized");

        for (final String file : allFiles) {
            final String trackId = FilenameUtils.getBaseName(file);
            if (keys.contains(trackId)) {
                final Song song = AvroUtils.deserialize(file);
                final SongTotalMeta totalMeta = new SongTotalMeta(song, mappedEntries.get(trackId));
                semicompleteMapping.put(trackId, totalMeta);
                AvroUtils.serialize("./src/test/researchData/MillionSongSubsetFinal/" + trackId + Modulo7Globals.EXTENSION_TO_SERIALIZED_FILES, song);
            }
        }

        FileInputStream fis2 = new FileInputStream("./src/test/researchData/lyricsGenreEXPT.ser");
        ObjectInputStream ois2 = new ObjectInputStream(fis2);
        final Set<SongBagLyricsGenreMap> lyricsToGenreEntries = (HashSet<SongBagLyricsGenreMap>) ois2.readObject();
        final Map<String, SongBagLyricsGenreMap> lyricsMapToGenre = new HashMap<>();

        for (final SongBagLyricsGenreMap map : lyricsToGenreEntries) {
            lyricsMapToGenre.put(map.getTrackID(), map);
        }

        final Map<String, SongTotalMeta> completeMapping = new HashMap<>();
        Map<String, Integer> allSeenGenres = new HashMap<>();

        for (Map.Entry<String, SongTotalMeta> total : semicompleteMapping.entrySet()) {
            final String trackId = total.getKey();
            final SongTotalMeta totalMeta = total.getValue();
            SongBagLyricsGenreMap lyricsMeta = lyricsMapToGenre.get(trackId);
            if (lyricsMeta != null) {
                Set<String> allGenres = lyricsMeta.getLabels().getGenreList();

                for (final String genre : allGenres) {
                    Modulo7Utils.addToCount(genre, allSeenGenres);
                }

                totalMeta.addGenres(lyricsMeta.getLabels().getGenreList());
                completeMapping.put(trackId, totalMeta);
            }
        }

        final Modulo7Indexer indexer = new Modulo7Indexer("./src/test/researchData/MillionSongSubsetFinal/", "/src/test/researchData/idontcare");
        final Set<String> queries = new HashSet<>();

        queries.add("select mp3 from default_database where happinessindex > 0.11 and sadnessindex < 0.05;");

        for (final String query : queries) {
            final Modulo7QueryProcessingEngine processingEngine = new Modulo7QueryProcessingEngine(query, indexer);
            final Set<Song> returnedSongs = processingEngine.processQuery();
            final Set<Song> returnedSongsWithRightMode = new HashSet<>();

            for (final Song song : returnedSongs) {
                if (song.getMetadata().getKeySignature().getScale().equals(ScaleType.MAJOR)) {
                    returnedSongsWithRightMode.add(song);
                }
            }

            final Set<String> songLocations = indexer.getLocationsGivenRelevantSongs(returnedSongsWithRightMode);
            PrecRec blah = crossCheckAccuracy(completeMapping, songLocations);
            System.out.println("haha");
        }
    }

    private PrecRec crossCheckAccuracy(final Map<String, SongTotalMeta> completeMapping, final Set<String> songLocations) {

        final Set<String> predictedTrackIds = new HashSet<>();
        for (final String location : songLocations) {
            final String trackId = FilenameUtils.getBaseName(location);
            predictedTrackIds.add(trackId);
        }

        final Set<String> actualTrackIds = new HashSet<>();

        for (Map.Entry<String, SongTotalMeta> completeMappingElem : completeMapping.entrySet()) {
            final String trackId = completeMappingElem.getKey();
            final SongTotalMeta totalMeta = completeMappingElem.getValue();

            if (totalMeta.getMetadata().getTags().containsKey("happy") || totalMeta.getMetadata().getTags().containsKey("Happy") ||
                    totalMeta.getMetadata().getTags().containsKey("happy song") || totalMeta.getMetadata().getTags().containsKey("Happy song")) {
                actualTrackIds.add(trackId);
            }
        }

        final Set<String> intersection = new HashSet<>(predictedTrackIds);
        intersection.retainAll(actualTrackIds);

        double prec = (double) intersection.size() / predictedTrackIds.size();
        double rec = (double) intersection.size() / actualTrackIds.size();

        return new PrecRec(prec, rec);
    }
}
