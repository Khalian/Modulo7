package com.modulo7.modulo7SQL;

import java.util.List;
import java.util.Set;

/**
 * Created by asanyal on 9/21/15.
 *
 * A data structure which contains query components being parsed
 */
public class Modulo7QueryComponents {

    // Input types to be queried
    private Set<String> inputs;

    // Expression List to be parsed
    private List<String> exprList;

    // Expr oprs like and/or in between expr List
    private List<String> exprOprList;

    // DB Name in the query components
    private String dbName;

    /**
     * Basic constructor
     *
     * @param inputs
     * @param exprList
     * @param exprOprList
     * @param dbName
     */
    public Modulo7QueryComponents(final Set<String> inputs, final List<String> exprList, final List<String> exprOprList, final String dbName) {
        this.inputs = inputs;
        this.exprList = exprList;
        this.exprOprList = exprOprList;
        this.dbName = dbName;

        assert (exprList.size() - 1 == exprOprList.size());
    }
}
