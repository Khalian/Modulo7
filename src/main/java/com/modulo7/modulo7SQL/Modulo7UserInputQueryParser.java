package com.modulo7.modulo7SQL;

import com.echonest.api.v4.Term;
import com.modulo7.common.exceptions.Modulo7MalformedM7SQLQuery;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Created by asanyal on 8/5/2015.
 *
 * A class for parsing queries provided to the query engine
 * of the
 */
public class Modulo7UserInputQueryParser {

    /**
     * Parses a query given to the query engine
     * The parser is a programming language interface for
     *
     * @param query
     */
    public static void parseQuery(final String query) throws Modulo7MalformedM7SQLQuery {
        ANTLRInputStream in = new ANTLRInputStream(query);
        modulo7SQLBase lexer = new modulo7SQLBase(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        modulo7SQLParser parser = new modulo7SQLParser(tokens);

        ParseTreeListener listener = new modulo7SQLBaseListener();

        modulo7SQLParser.Select_clauseContext context = parser.select_clause();
        TerminalNode selectElem = context.SELECT();

        context.enterRule(listener);

        if (selectElem == null) {
            throw new Modulo7MalformedM7SQLQuery("Must contain a select statement at the start of the query");
        }
    }

    public static void main(String args[]) throws Modulo7MalformedM7SQLQuery {
        parseQuery("select");
    }
}
