package com.modulo7.engine;

import com.modulo7.common.exceptions.Modulo7MalformedM7SQLQuery;
import com.modulo7.common.exceptions.Modulo7QueryProcessingException;
import com.modulo7.common.interfaces.choices.CriteriaChoices;
import com.modulo7.common.interfaces.choices.SongSimilarityChoices;
import com.modulo7.common.interfaces.choices.StatisticChoices;
import com.modulo7.modulo7SQL.Modulo7QueryComponents;
import com.modulo7.modulo7SQL.Modulo7UserInputQueryParser;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by asanyal on 9/21/15.
 *
 * Driver class for modulo7 query processing engine, allows for output of custom queries
 * and return a set or rank set of songs that satisfy a given query
 */
public class Modulo7QueryProcessingEngine {

    // A string copy of the query
    private String query;

    // The components of the query as determined
    private Modulo7QueryComponents componentsOfQuery;

    // A handle to the indexer engine
    private Modulo7Indexer indexer;

    // Regular expression pattern for criterion
    private static final Pattern CRITERIA_PATTERNS = Pattern.compile(CriteriaChoices.REGEXP_REP + " (is|isnot) " + "(true|false)");

    // Regular expression pattern for statistics ; TODO : Finish impl
    private static final Pattern STATISTIC_PATTERNS = Pattern.compile(StatisticChoices.REGEXP_REP);

    // Regular expression pattern for similarity measures : TODO : Finish impl
    private static final Pattern SIMILARITY_MEASURE_PATTERNS = Pattern.compile(SongSimilarityChoices.REGEXP_REP);

    /**
     * Basic construtor for modulo7 processor
     *
     * @param query
     * @param indexer
     * @throws Modulo7MalformedM7SQLQuery
     */
    public Modulo7QueryProcessingEngine(final String query, final Modulo7Indexer indexer) throws Modulo7MalformedM7SQLQuery {
        this.query = query;
        this.componentsOfQuery = Modulo7UserInputQueryParser.parseQuery(query);
        this.indexer = indexer;


    }

    /**
     * The method which actually processes a query and then prunes out songs which dont satisfy the query
     * thereby returning a set of songs which do
     *
     * TODO : Finish its implementation
     *
     * @return
     * @throws Modulo7QueryProcessingException
     */
    public Set<Song> processQuery() throws Modulo7QueryProcessingException {

        // First check if both databases have the same name, if not fail with an exception
        if (!indexer.getInternalDBName().toLowerCase().equals(componentsOfQuery.getDbName())) {
            throw new Modulo7QueryProcessingException("Input database " + componentsOfQuery.getDbName() +
                    "is not same as " + indexer.getInternalDBName().toLowerCase());
        }

        // First acquire all songs, we need to return only a subset of these as per the query requirements
        final Set<Song> allSongs = indexer.getAllSongs();

        // The set of all relevant songs
        Set<Song> relevantSongs = new HashSet<>();

        // From the query, extract the input types to be returned
        final Set<String> inputTypes = componentsOfQuery.getInputs();

        // Get only those songs that are asked as a part of the input types
        for (final Song song : allSongs) {
            if (inputTypes.contains(song.getSource().getStringRepresentation())) {
                relevantSongs.add(song);
            }
        }

        List<String> exprList = componentsOfQuery.getExprList();
        List<String> exprOprs = componentsOfQuery.getExprOprList();

        for (final String expr : exprList) {
            if (expr.matches(CRITERIA_PATTERNS.pattern())) {
                // TODO : Finish this
            } else if (expr.matches(STATISTIC_PATTERNS.pattern())) {
                // TODO : Finish this
            } else if (expr.matches(SIMILARITY_MEASURE_PATTERNS.pattern())) {
                // TODO : Finish this
            }
        }

        return relevantSongs;
    }

    public String getQuery() {
        return query;
    }
}
