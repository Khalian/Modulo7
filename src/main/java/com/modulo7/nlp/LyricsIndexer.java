package com.modulo7.nlp;

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

/**
 * Created by asanyal on 8/18/15.
 *
 * This class is responsible for creating a lucene index
 * for the lyrics object, this index can later be used for similarity searches etc
 */
public class LyricsIndexer {

    // An index writer entity for
    private IndexWriter indexWriter = null;

    /** Creates a new instance of Indexer */
    public LyricsIndexer() {
    }

    public IndexWriter getIndexWriter(boolean create) throws IOException {
        if (indexWriter == null) {
            Directory indexDir = FSDirectory.open(new File("index-directory"));
            IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_41, new StandardAnalyzer(Version.LUCENE_41));
            indexWriter = new IndexWriter(indexDir, config);
        }
        return indexWriter;
    }

    /**
     * Lucene indexer for the lyrics object
     * @param lyrics
     */
    public void indexLyrics(final Lyrics lyrics) throws IOException {
        IndexWriter writer = getIndexWriter(false);
        Document doc = new Document();
        doc.add(new StringField("artistName", lyrics.getArtist(), Field.Store.YES));
        doc.add(new StringField("albumName", lyrics.getAlbumName(), Field.Store.YES));
        doc.add(new StringField("lyricalContent", lyrics.getLyricsOfSong(), Field.Store.YES));
        String fullSearchableText = lyrics.getArtist() + " " + lyrics.getAlbumName() + " " + lyrics.getLyricsOfSong();
        doc.add(new TextField("content", fullSearchableText, Field.Store.NO));
        writer.addDocument(doc);
    }
}
