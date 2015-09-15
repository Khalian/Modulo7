package com.modulo7.nlp;

import com.modulo7.common.exceptions.Modulo7IndexingDirError;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.apache.lucene.document.TextField;
import org.apache.lucene.analysis.standard.StandardAnalyzer;

import java.io.File;
import java.io.IOException;
import java.util.Set;

/**
 * Created by asanyal on 8/18/15.
 *
 * This class is responsible for creating a lucene index
 * for the lyrics object, this index can later be used for similarity searches etc
 */
public class LyricsIndexer {

    // An index writer entity for
    private IndexWriter indexWriter = null;

    // the File handle to the location in which index directory will be present
    private String indexDirLocation = null;

    // Default indexer dir for the lyrics indexer
    private static final String DEFAULT_INDEX_DIR = "default-lyrics-index-dir";

    /** Creates a new instance of Indexer with custom location for index dir*/
    public LyricsIndexer(final String indexDir) {
        this.indexDirLocation = indexDir;
    }

    /**
     * Default constructuror
     */
    public LyricsIndexer() {
        this.indexDirLocation = DEFAULT_INDEX_DIR;
    }

    /**
     * Acquires an index writer object for the indexer
     * @return
     * @throws IOException
     */
    public IndexWriter getIndexWriter() throws Modulo7IndexingDirError {

        if (indexWriter == null) {
            Directory indexDir;
            try {
                indexDir = FSDirectory.open(new File(indexDirLocation));
                IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_41, new StandardAnalyzer(Version.LUCENE_41));
                indexWriter = new IndexWriter(indexDir, config);
            } catch (IOException e) {
                throw new Modulo7IndexingDirError("Cant create lyrics index dir at location" + indexDirLocation);
            }
        }
        return indexWriter;
    }

    /**
     * Closes the index writer
     * @throws IOException
     */
    public void closeIndexWriter() throws IOException {
        if (indexWriter != null) {
            indexWriter.close();
        }
    }

    /**
     * Lucene indexer for the lyrics object
     * @throws Modulo7IndexingDirError
     * @param lyrics
     */
    public void indexLyrics(final Lyrics lyrics) throws Modulo7IndexingDirError {
        IndexWriter writer = getIndexWriter();
        Document doc = new Document();
        doc.add(new StringField("songName", lyrics.getArtist(), Field.Store.YES));
        doc.add(new StringField("artistName", lyrics.getArtist(), Field.Store.YES));
        doc.add(new StringField("albumName", lyrics.getAlbumName(), Field.Store.YES));
        doc.add(new TextField("lyricalContent", lyrics.getLyricsOfSong(), Field.Store.YES));
        String fullSearchableText = lyrics.getSongName() + lyrics.getArtist() + " " + lyrics.getAlbumName() + " " + lyrics.getLyricsOfSong();
        doc.add(new TextField("content", fullSearchableText, Field.Store.NO));
        try {
            writer.addDocument(doc);
            closeIndexWriter();
        } catch (IOException e) {
           throw new Modulo7IndexingDirError("Unable to add doc to index at location :" + indexDirLocation);
        }
    }

    /**
     * A batch version of the above index lyrics code to index a large number
     * of lyrics objects at the same time
     *
     * @param lyricsSet
     */
    public void bulkIndexLyrics(final Set<Lyrics> lyricsSet) throws Modulo7IndexingDirError {

        IndexWriter writer = getIndexWriter();

        for (Lyrics lyrics : lyricsSet) {
            Document doc = new Document();
            doc.add(new StringField("artistName", lyrics.getArtist(), Field.Store.YES));
            doc.add(new StringField("songName", lyrics.getArtist(), Field.Store.YES));
            doc.add(new StringField("albumName", lyrics.getAlbumName(), Field.Store.YES));
            doc.add(new StringField("lyricalContent", lyrics.getLyricsOfSong(), Field.Store.YES));
            String fullSearchableText = lyrics.getArtist() + " " + lyrics.getAlbumName() + " " + lyrics.getLyricsOfSong();
            doc.add(new TextField("content", fullSearchableText, Field.Store.NO));
            try {
                writer.addDocument(doc);
            } catch (IOException e) {
                throw new Modulo7IndexingDirError("Cant index at location" + indexDirLocation);
            }
        }
        try {
            closeIndexWriter();
        } catch (IOException e) {
            throw new Modulo7IndexingDirError("Cant close index writer at location" + indexDirLocation);
        }
    }

    /**
     * Simple getter for the default index dir
     * @return
     */
    public static String getDefaultIndexDir() {
        return DEFAULT_INDEX_DIR;
    }

    /**
     * Getter for index dir location
     * @return
     */
    public String getIndexDirLocation() {
        return indexDirLocation;
    }
}
