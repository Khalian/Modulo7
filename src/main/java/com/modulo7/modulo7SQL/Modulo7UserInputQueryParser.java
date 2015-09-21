package com.modulo7.modulo7SQL;

import com.modulo7.common.exceptions.Modulo7MalformedM7SQLQuery;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by asanyal on 8/5/2015.
 *
 * A class for parsing queries provided to the query engine
 * of the
 */
public class Modulo7UserInputQueryParser {

    /**
     * Parses a query given to the query engine
     * The parser is a programming language interface for Moudlo7 as for now will
     * support basic query structures
     *
     * @param query
     */
    public static Modulo7QueryComponents parseQuery(final String query) throws Modulo7MalformedM7SQLQuery {

        String queryLowerCase = query.toLowerCase();

        ANTLRInputStream in = new ANTLRInputStream(queryLowerCase);
        Modulo7SQLBase lexer = new Modulo7SQLBase(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Modulo7SQLParser parser = new Modulo7SQLParser(tokens);

        Modulo7SQLParser.Select_clauseContext context = parser.select_clause();
        TerminalNode selectElem = context.select_key().SELECT();

        if (selectElem == null) {
            throw new Modulo7MalformedM7SQLQuery("Must contain a select statement at the start of the query");
        }

        List<String> expressionsInSequence = new ArrayList<>();
        List<String> exprOpsInSequence = new ArrayList<>();
        Set<String> inputList = new HashSet<>();
        String dbName = null;

        Modulo7SQLParser.Input_list_clauseContext inputClause = context.input_list_clause();

        List<Modulo7SQLParser.Input_nameContext> inputNames = inputClause.input_name();

        for (Modulo7SQLParser.Input_nameContext inputName : inputNames) {
            final String input = inputName.getText();
            inputList.add(input);
        }

        Modulo7SQLParser.From_clauseContext fromClauseContext = context.from_clause();

        if (fromClauseContext != null) {
            Modulo7SQLParser.Table_nameContext tableNameContext = fromClauseContext.table_name();
            dbName = tableNameContext.getText();

            Modulo7SQLParser.Where_clauseContext whereClausContext = context.where_clause();

            if (whereClausContext != null) {
                Modulo7SQLParser.ExpressionContext expressionContext = whereClausContext.expression();

                List<Modulo7SQLParser.Expr_opContext> exprContexts = expressionContext.expr_op();

                for (Modulo7SQLParser.Expr_opContext exprContext : exprContexts) {
                    exprOpsInSequence.add(exprContext.getText());
                }

                List<Modulo7SQLParser.Simple_expressionContext> simpleContextList = expressionContext.simple_expression();

                if (simpleContextList.size() > 0) {

                    for (Modulo7SQLParser.Simple_expressionContext simpleContext : simpleContextList) {

                        String stringRep = "";

                        if (simpleContext.children != null) {
                            for (ParseTree tree : simpleContext.children) {
                                stringRep += tree.getText() + " ";
                            }

                            expressionsInSequence.add(stringRep);
                        }
                    }
                }
            }
        }

        return new Modulo7QueryComponents(inputList, expressionsInSequence, exprOpsInSequence, dbName);
    }
}
