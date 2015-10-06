// Generated from /home/asanyal/git_projects/Modulo7/src/main/antlr/Modulo7SQL.g4 by ANTLR 4.5.1

    package  com.modulo7.modulo7SQL;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Modulo7SQLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Modulo7SQLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Modulo7SQLParser#select_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect_clause(Modulo7SQLParser.Select_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link Modulo7SQLParser#preprocess_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreprocess_clause(Modulo7SQLParser.Preprocess_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link Modulo7SQLParser#preprocess_criteria}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreprocess_criteria(Modulo7SQLParser.Preprocess_criteriaContext ctx);
	/**
	 * Visit a parse tree produced by {@link Modulo7SQLParser#from_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFrom_clause(Modulo7SQLParser.From_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link Modulo7SQLParser#table_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_name(Modulo7SQLParser.Table_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link Modulo7SQLParser#input_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInput_name(Modulo7SQLParser.Input_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link Modulo7SQLParser#column_name_alias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn_name_alias(Modulo7SQLParser.Column_name_aliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link Modulo7SQLParser#index_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndex_name(Modulo7SQLParser.Index_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link Modulo7SQLParser#input_list_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInput_list_clause(Modulo7SQLParser.Input_list_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link Modulo7SQLParser#select_key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect_key(Modulo7SQLParser.Select_keyContext ctx);
	/**
	 * Visit a parse tree produced by {@link Modulo7SQLParser#where_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhere_clause(Modulo7SQLParser.Where_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link Modulo7SQLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(Modulo7SQLParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Modulo7SQLParser#element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElement(Modulo7SQLParser.ElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Modulo7SQLParser#right_element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRight_element(Modulo7SQLParser.Right_elementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Modulo7SQLParser#left_element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeft_element(Modulo7SQLParser.Left_elementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Modulo7SQLParser#target_element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTarget_element(Modulo7SQLParser.Target_elementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Modulo7SQLParser#relational_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelational_op(Modulo7SQLParser.Relational_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link Modulo7SQLParser#expr_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_op(Modulo7SQLParser.Expr_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link Modulo7SQLParser#between_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBetween_op(Modulo7SQLParser.Between_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link Modulo7SQLParser#is_or_is_not}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIs_or_is_not(Modulo7SQLParser.Is_or_is_notContext ctx);
	/**
	 * Visit a parse tree produced by {@link Modulo7SQLParser#either_true_or_false}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEither_true_or_false(Modulo7SQLParser.Either_true_or_falseContext ctx);
	/**
	 * Visit a parse tree produced by {@link Modulo7SQLParser#simple_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_expression(Modulo7SQLParser.Simple_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Modulo7SQLParser#criteria}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCriteria(Modulo7SQLParser.CriteriaContext ctx);
	/**
	 * Visit a parse tree produced by {@link Modulo7SQLParser#statistic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatistic(Modulo7SQLParser.StatisticContext ctx);
}