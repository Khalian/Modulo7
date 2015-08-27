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
    private IndexSearcher searcher = null;
    private QueryParser parser = null;

    /** Creates a new instance of SearchEngine */
    public LyricsQueryParser() throws IOException {
        searcher = new IndexSearcher(DirectoryReader.open(FSDirectory.open(new File("index-directory"))));
        parser = new QueryParser(Version.LUCENE_41, "", new StandardAnalyzer(Version.LUCENE_41));
    }

    /**
     * Performs a search on the query string
     * @param queryString
     * @param n
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public TopDocs performSearch(String queryString, int n) throws IOException, ParseException {
        Query query = parser.parse(queryString);
        return searcher.search(query, n);
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
