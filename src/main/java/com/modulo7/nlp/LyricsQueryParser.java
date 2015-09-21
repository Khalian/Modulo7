package com.modulo7.nlp;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import java.io.File;
import java.io.IOException;

/**
 * Created by asanyal on 8/27/15.
 *
 * A lyrics query parser : Ideas taken from : http://oak.cs.ucla.edu/cs144/projects/lucene/
 */
public class LyricsQueryParser {

    // A searcher element for the query parser
    private IndexSearcher searcher = null;

    // A parser for a given lucene query
    private QueryParser parser = null;

    /** Creates a new instance of SearchEngine */
    public LyricsQueryParser(final String indexDir) throws IOException {
        searcher = new IndexSearcher(DirectoryReader.open(FSDirectory.open(new File(indexDir))));
        parser = new QueryParser(Version.LUCENE_41, "lyricalContent", new StandardAnalyzer(Version.LUCENE_41));
    }

    /**
     * Performs a search on the query string based on the lyrics field, which is also the default
     *
     * @param queryString
     * @param numTopDocs
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public TopDocs performLyricsSearch(final String queryString, final int numTopDocs) throws IOException, ParseException {
        Query query = parser.parse(NLPUtils.stemmer(queryString));
        return searcher.search(query, numTopDocs);
    }

    /**
     * Performs a search on the query string on the song name field
     *
     * @param queryString
     * @param numTopDocs
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public TopDocs performSongNameSearch(final String queryString, final int numTopDocs) throws IOException, ParseException {
        Query query = parser.parse("songName: " + queryString);
        return searcher.search(query, numTopDocs);
    }

    /**
     * Gets the document associated with the id
     *
     * @param docId
     * @return
     * @throws IOException
     */
    public Document getDocument(int docId) throws IOException {
        return searcher.doc(docId);
    }
}
