package com.modulo7.engine.processing;

import com.modulo7.common.exceptions.Modulo7MalformedM7SQLQuery;
import com.modulo7.common.exceptions.Modulo7QueryProcessingException;
import com.modulo7.common.interfaces.AbstractCriteria;
import com.modulo7.common.interfaces.AbstractStatistic;
import com.modulo7.common.interfaces.choices.CriteriaChoice;
import com.modulo7.common.interfaces.choices.StatisticChoice;
import com.modulo7.engine.storage.Modulo7Indexer;
import com.modulo7.modulo7SQL.Modulo7QueryComponents;
import com.modulo7.modulo7SQL.Modulo7QueryParser;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;
import org.apache.log4j.Logger;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
    public static final Pattern CRITERIA_PATTERNS = Pattern.compile(CriteriaChoice.REGEXP_REP);

    // Regular expression pattern for statistics
    public static final Pattern STATISTIC_PATTERNS = Pattern.compile(StatisticChoice.STAT_REGEXP_REP);

    // Logger for the query processing engine
    public static final Logger logger = Logger.getLogger(Modulo7QueryProcessingEngine.class);

    /**
     * Basic construtor for modulo7 processor
     *
     * @param query
     * @param indexer
     * @throws Modulo7MalformedM7SQLQuery
     */
    public Modulo7QueryProcessingEngine(final String query, final Modulo7Indexer indexer) throws Modulo7MalformedM7SQLQuery {
        this.query = query;
        this.componentsOfQuery = Modulo7QueryParser.parseQuery(query);

        if (componentsOfQuery == null) {
            throw new Modulo7MalformedM7SQLQuery("The query was bad");
        }

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

        if (componentsOfQuery == null) {
            throw new Modulo7QueryProcessingException("Malformed query, try again");
        }

        // First check if both databases have the same name, if not fail with an exception
        if (!indexer.getInternalDBName().toLowerCase().equals(componentsOfQuery.getDbName())) {
            throw new Modulo7QueryProcessingException("Input database " + componentsOfQuery.getDbName() +
                    "is not same as " + indexer.getInternalDBName().toLowerCase());
        }

        // First acquire all songs, we need to return only a subset of these as per the query requirements
        final Set<Song> allSongs = indexer.getAllSongs();

        // The set of all relevant songs
        Set<Song> requisiteSourceSongs = new HashSet<>();

        // From the query, extract the input types to be returned
        final Set<String> inputTypes = componentsOfQuery.getInputs();

        // Get only those songs that are asked as a part of the input types
        requisiteSourceSongs.addAll(allSongs.stream().filter(song -> inputTypes.contains(song.getSource().getStringRepresentation())).collect(Collectors.toList()));

        List<String> exprList = componentsOfQuery.getExprList();
        List<String> exprOprs = componentsOfQuery.getExprOprList();

        Set<Song> bestSet = requisiteSourceSongs;
        Set<Song> candidateSet = requisiteSourceSongs;
        Set<Song> relevantSongs = new HashSet<>();

        for (int i = 0; i < exprList.size(); i++) {

            final String expr = exprList.get(i);

            final Matcher criteriaMatcher = CRITERIA_PATTERNS.matcher(expr);
            final Matcher statisticMatcher = STATISTIC_PATTERNS.matcher(expr);

            if (statisticMatcher.find()) {
                final String[] components = expr.split(" ");
                final String statistic = components[0];
                final String relationalOp = components[1];
                final Double value = Double.parseDouble(components[2]);

                bestSet = evaluateBestSetFromStatistic(statistic, relationalOp, value, candidateSet);

            } else if (criteriaMatcher.find()) {
                String[] components = expr.split(" ");
                final String criteria = components[0];
                final String assertion = components[1];
                final String predicate = components[2];

                bestSet = evaluateBestSetFromCriteria(criteria, assertion, predicate, candidateSet);
            }

            if (exprOprs.size() > 0 && i < exprOprs.size()) {
                final String exprOpr = exprOprs.get(i);

                if (exprOpr.equals("or")) {
                    relevantSongs.addAll(bestSet);
                    candidateSet = requisiteSourceSongs;
                } else {
                    relevantSongs = bestSet;
                    candidateSet = relevantSongs;
                }
            } else if (exprOprs.size() == 0) {
                relevantSongs = bestSet;
            } else {
                if (exprOprs.get(exprOprs.size() - 1).equals("or")) {
                    relevantSongs.addAll(bestSet);
                } else {
                    relevantSongs = bestSet;
                }
            }
        }

        // Special case in which no expressions are present
        if (exprList.size() == 0) {
            relevantSongs.addAll(requisiteSourceSongs);
        }

        return relevantSongs;
    }

    /**
     * Returns the relevant set of songs from a candidate which satisfy a given criteria
     * @param criteria
     * @param assertion
     * @param predicate
     * @param candidateSet
     * @return
     */
    private Set<Song> evaluateBestSetFromCriteria(final String criteria, final String assertion,
            final String predicate, final Set<Song> candidateSet) {

        final Set<Song> relevantSet = new HashSet<>();

        try {
            AbstractCriteria criteriaObj = (AbstractCriteria) CriteriaChoice.getCriteriaClassGivenStringRep(criteria).newInstance();
            relevantSet.addAll(candidateSet.stream().filter(song -> criteriaSatisfied(song, criteriaObj, assertion, predicate)).collect(Collectors.toList()));

            return relevantSet;

        } catch (InstantiationException | IllegalAccessException e) {
            logger.error(e.getMessage());
        }

        return relevantSet;
    }

    /**
     * Helper method to return whether a criteria satisfies given an assertion and a predicate
     * @param song
     * @param criteriaObj
     * @param assertion
     * @param predicate
     * @return
     */
    private boolean criteriaSatisfied(final Song song, final AbstractCriteria criteriaObj, final String assertion, final String predicate) {
        final boolean criteriaEval = criteriaObj.getCriteriaEvaluation(song);

        if (assertion.equals("is") && predicate.equals("true")) {
            return criteriaEval;
        } else if (assertion.equals("is not") && predicate.equals("true")) {
            return !criteriaEval;
        } else if (assertion.equals("is") && predicate.equals("false")) {
            return !criteriaEval;
        } else {
            return criteriaEval;
        }
    }

    /**
     * Evaluate best set given statistic
     * @param statistic
     * @param relationalOp
     * @param value
     * @param candidateSet
     * @return
     */
    private Set<Song> evaluateBestSetFromStatistic(final String statistic, final String relationalOp, final Double value, final Set<Song> candidateSet) {
        final Set<Song> relevantSet = new HashSet<>();

        try {
            AbstractStatistic statisticObj = (AbstractStatistic) StatisticChoice.getStatisticMapGivenChoiceString(statistic).newInstance();

            for (final Song song : candidateSet) {
                final Double statisticEval = statisticObj.getStatistic(song);
                if (doubleEval(statisticEval, value, relationalOp)) {
                    relevantSet.add(song);
                }
            }
        } catch (InstantiationException | IllegalAccessException e) {
            logger.error(e.getMessage());
        }

        return relevantSet;
    }

    /**
     * Return double Evaluation for statistic
     * @param operand1
     * @param operand2
     * @param relationalOp
     * @return
     */
    private boolean doubleEval(final Double operand1, final Double operand2, final String relationalOp) {
        if (relationalOp.equals("<"))
            return operand1 < operand2;
        else if (relationalOp.equals(">"))
            return operand1 > operand2;
        else if (relationalOp.equals(">="))
            return operand1 >= operand2;
        else if (relationalOp.equals("<="))
            return operand1 <= operand2;
        else if (relationalOp.equals("=="))
            return operand1.equals(operand2);

        return false;
    }

    /**
     * Getter for the query
     * @return
     */
    public String getQuery() {
        return query;
    }
}
