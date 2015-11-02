package researchtests;

import com.modulo7.common.exceptions.Modulo7InvalidMusicXMLFile;
import com.modulo7.common.exceptions.Modulo7NoSuchFileOrDirectoryException;
import com.modulo7.common.utils.Modulo7Utils;
import com.modulo7.musicstatmodels.representation.metadata.KeySignature;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;
import com.modulo7.pureresearch.MXLReader;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by asanyal on 9/14/15.
 *
 * Research specific test cases, not meant for production grade code
 *
 * Uncomment only when you have the necessary setup for running the research test cases
 *
 */
public class ResearchTestCase {

    private static final Logger logger = Logger.getLogger(ResearchTestCase.class);

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
}
