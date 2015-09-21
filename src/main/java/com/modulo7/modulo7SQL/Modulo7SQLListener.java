// Generated from /home/asanyal/git_projects/Modulo7/src/main/antlr/Modulo7SQL.g4 by ANTLR 4.5.1

    package  com.modulo7.modulo7SQL;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Modulo7SQLParser}.
 */
public interface Modulo7SQLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Modulo7SQLParser#select_clause}.
	 * @param ctx the parse tree
	 */
	void enterSelect_clause(Modulo7SQLParser.Select_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link Modulo7SQLParser#select_clause}.
	 * @param ctx the parse tree
	 */
	void exitSelect_clause(Modulo7SQLParser.Select_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link Modulo7SQLParser#from_clause}.
	 * @param ctx the parse tree
	 */
	void enterFrom_clause(Modulo7SQLParser.From_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link Modulo7SQLParser#from_clause}.
	 * @param ctx the parse tree
	 */
	void exitFrom_clause(Modulo7SQLParser.From_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link Modulo7SQLParser#table_name}.
	 * @param ctx the parse tree
	 */
	void enterTable_name(Modulo7SQLParser.Table_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link Modulo7SQLParser#table_name}.
	 * @param ctx the parse tree
	 */
	void exitTable_name(Modulo7SQLParser.Table_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link Modulo7SQLParser#input_name}.
	 * @param ctx the parse tree
	 */
	void enterInput_name(Modulo7SQLParser.Input_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link Modulo7SQLParser#input_name}.
	 * @param ctx the parse tree
	 */
	void exitInput_name(Modulo7SQLParser.Input_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link Modulo7SQLParser#column_name_alias}.
	 * @param ctx the parse tree
	 */
	void enterColumn_name_alias(Modulo7SQLParser.Column_name_aliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link Modulo7SQLParser#column_name_alias}.
	 * @param ctx the parse tree
	 */
	void exitColumn_name_alias(Modulo7SQLParser.Column_name_aliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link Modulo7SQLParser#index_name}.
	 * @param ctx the parse tree
	 */
	void enterIndex_name(Modulo7SQLParser.Index_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link Modulo7SQLParser#index_name}.
	 * @param ctx the parse tree
	 */
	void exitIndex_name(Modulo7SQLParser.Index_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link Modulo7SQLParser#input_list_clause}.
	 * @param ctx the parse tree
	 */
	void enterInput_list_clause(Modulo7SQLParser.Input_list_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link Modulo7SQLParser#input_list_clause}.
	 * @param ctx the parse tree
	 */
	void exitInput_list_clause(Modulo7SQLParser.Input_list_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link Modulo7SQLParser#select_key}.
	 * @param ctx the parse tree
	 */
	void enterSelect_key(Modulo7SQLParser.Select_keyContext ctx);
	/**
	 * Exit a parse tree produced by {@link Modulo7SQLParser#select_key}.
	 * @param ctx the parse tree
	 */
	void exitSelect_key(Modulo7SQLParser.Select_keyContext ctx);
	/**
	 * Enter a parse tree produced by {@link Modulo7SQLParser#where_clause}.
	 * @param ctx the parse tree
	 */
	void enterWhere_clause(Modulo7SQLParser.Where_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link Modulo7SQLParser#where_clause}.
	 * @param ctx the parse tree
	 */
	void exitWhere_clause(Modulo7SQLParser.Where_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link Modulo7SQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(Modulo7SQLParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Modulo7SQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(Modulo7SQLParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Modulo7SQLParser#element}.
	 * @param ctx the parse tree
	 */
	void enterElement(Modulo7SQLParser.ElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Modulo7SQLParser#element}.
	 * @param ctx the parse tree
	 */
	void exitElement(Modulo7SQLParser.ElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Modulo7SQLParser#right_element}.
	 * @param ctx the parse tree
	 */
	void enterRight_element(Modulo7SQLParser.Right_elementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Modulo7SQLParser#right_element}.
	 * @param ctx the parse tree
	 */
	void exitRight_element(Modulo7SQLParser.Right_elementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Modulo7SQLParser#left_element}.
	 * @param ctx the parse tree
	 */
	void enterLeft_element(Modulo7SQLParser.Left_elementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Modulo7SQLParser#left_element}.
	 * @param ctx the parse tree
	 */
	void exitLeft_element(Modulo7SQLParser.Left_elementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Modulo7SQLParser#target_element}.
	 * @param ctx the parse tree
	 */
	void enterTarget_element(Modulo7SQLParser.Target_elementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Modulo7SQLParser#target_element}.
	 * @param ctx the parse tree
	 */
	void exitTarget_element(Modulo7SQLParser.Target_elementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Modulo7SQLParser#relational_op}.
	 * @param ctx the parse tree
	 */
	void enterRelational_op(Modulo7SQLParser.Relational_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link Modulo7SQLParser#relational_op}.
	 * @param ctx the parse tree
	 */
	void exitRelational_op(Modulo7SQLParser.Relational_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link Modulo7SQLParser#expr_op}.
	 * @param ctx the parse tree
	 */
	void enterExpr_op(Modulo7SQLParser.Expr_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link Modulo7SQLParser#expr_op}.
	 * @param ctx the parse tree
	 */
	void exitExpr_op(Modulo7SQLParser.Expr_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link Modulo7SQLParser#between_op}.
	 * @param ctx the parse tree
	 */
	void enterBetween_op(Modulo7SQLParser.Between_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link Modulo7SQLParser#between_op}.
	 * @param ctx the parse tree
	 */
	void exitBetween_op(Modulo7SQLParser.Between_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link Modulo7SQLParser#is_or_is_not}.
	 * @param ctx the parse tree
	 */
	void enterIs_or_is_not(Modulo7SQLParser.Is_or_is_notContext ctx);
	/**
	 * Exit a parse tree produced by {@link Modulo7SQLParser#is_or_is_not}.
	 * @param ctx the parse tree
	 */
	void exitIs_or_is_not(Modulo7SQLParser.Is_or_is_notContext ctx);
	/**
	 * Enter a parse tree produced by {@link Modulo7SQLParser#either_true_or_false}.
	 * @param ctx the parse tree
	 */
	void enterEither_true_or_false(Modulo7SQLParser.Either_true_or_falseContext ctx);
	/**
	 * Exit a parse tree produced by {@link Modulo7SQLParser#either_true_or_false}.
	 * @param ctx the parse tree
	 */
	void exitEither_true_or_false(Modulo7SQLParser.Either_true_or_falseContext ctx);
	/**
	 * Enter a parse tree produced by {@link Modulo7SQLParser#simple_expression}.
	 * @param ctx the parse tree
	 */
	void enterSimple_expression(Modulo7SQLParser.Simple_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Modulo7SQLParser#simple_expression}.
	 * @param ctx the parse tree
	 */
	void exitSimple_expression(Modulo7SQLParser.Simple_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Modulo7SQLParser#criteria}.
	 * @param ctx the parse tree
	 */
	void enterCriteria(Modulo7SQLParser.CriteriaContext ctx);
	/**
	 * Exit a parse tree produced by {@link Modulo7SQLParser#criteria}.
	 * @param ctx the parse tree
	 */
	void exitCriteria(Modulo7SQLParser.CriteriaContext ctx);
	/**
	 * Enter a parse tree produced by {@link Modulo7SQLParser#statistic}.
	 * @param ctx the parse tree
	 */
	void enterStatistic(Modulo7SQLParser.StatisticContext ctx);
	/**
	 * Exit a parse tree produced by {@link Modulo7SQLParser#statistic}.
	 * @param ctx the parse tree
	 */
	void exitStatistic(Modulo7SQLParser.StatisticContext ctx);
	/**
	 * Enter a parse tree produced by {@link Modulo7SQLParser#subquery_alias}.
	 * @param ctx the parse tree
	 */
	void enterSubquery_alias(Modulo7SQLParser.Subquery_aliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link Modulo7SQLParser#subquery_alias}.
	 * @param ctx the parse tree
	 */
	void exitSubquery_alias(Modulo7SQLParser.Subquery_aliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link Modulo7SQLParser#subquery}.
	 * @param ctx the parse tree
	 */
	void enterSubquery(Modulo7SQLParser.SubqueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link Modulo7SQLParser#subquery}.
	 * @param ctx the parse tree
	 */
	void exitSubquery(Modulo7SQLParser.SubqueryContext ctx);
}