// Generated from /home/asanyal/git_projects/Modulo7/src/main/antlr/modulo7SQL.g4 by ANTLR 4.5.1

    package  com.modulo7.modulo7SQL;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link modulo7SQLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface modulo7SQLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link modulo7SQLParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(modulo7SQLParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link modulo7SQLParser#schema_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSchema_name(modulo7SQLParser.Schema_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link modulo7SQLParser#select_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect_clause(modulo7SQLParser.Select_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link modulo7SQLParser#table_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_name(modulo7SQLParser.Table_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link modulo7SQLParser#table_alias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_alias(modulo7SQLParser.Table_aliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link modulo7SQLParser#input_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInput_name(modulo7SQLParser.Input_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link modulo7SQLParser#column_name_alias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn_name_alias(modulo7SQLParser.Column_name_aliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link modulo7SQLParser#index_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndex_name(modulo7SQLParser.Index_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link modulo7SQLParser#input_list_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInput_list_clause(modulo7SQLParser.Input_list_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link modulo7SQLParser#from_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFrom_clause(modulo7SQLParser.From_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link modulo7SQLParser#select_key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect_key(modulo7SQLParser.Select_keyContext ctx);
	/**
	 * Visit a parse tree produced by {@link modulo7SQLParser#where_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhere_clause(modulo7SQLParser.Where_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link modulo7SQLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(modulo7SQLParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link modulo7SQLParser#element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElement(modulo7SQLParser.ElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link modulo7SQLParser#right_element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRight_element(modulo7SQLParser.Right_elementContext ctx);
	/**
	 * Visit a parse tree produced by {@link modulo7SQLParser#left_element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeft_element(modulo7SQLParser.Left_elementContext ctx);
	/**
	 * Visit a parse tree produced by {@link modulo7SQLParser#target_element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTarget_element(modulo7SQLParser.Target_elementContext ctx);
	/**
	 * Visit a parse tree produced by {@link modulo7SQLParser#relational_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelational_op(modulo7SQLParser.Relational_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link modulo7SQLParser#expr_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_op(modulo7SQLParser.Expr_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link modulo7SQLParser#between_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBetween_op(modulo7SQLParser.Between_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link modulo7SQLParser#is_or_is_not}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIs_or_is_not(modulo7SQLParser.Is_or_is_notContext ctx);
	/**
	 * Visit a parse tree produced by {@link modulo7SQLParser#simple_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_expression(modulo7SQLParser.Simple_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link modulo7SQLParser#table_references}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_references(modulo7SQLParser.Table_referencesContext ctx);
	/**
	 * Visit a parse tree produced by {@link modulo7SQLParser#table_reference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_reference(modulo7SQLParser.Table_referenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link modulo7SQLParser#table_atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_atom(modulo7SQLParser.Table_atomContext ctx);
	/**
	 * Visit a parse tree produced by {@link modulo7SQLParser#index_hint_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndex_hint_list(modulo7SQLParser.Index_hint_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link modulo7SQLParser#index_options}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndex_options(modulo7SQLParser.Index_optionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link modulo7SQLParser#index_hint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndex_hint(modulo7SQLParser.Index_hintContext ctx);
	/**
	 * Visit a parse tree produced by {@link modulo7SQLParser#index_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndex_list(modulo7SQLParser.Index_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link modulo7SQLParser#partition_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartition_clause(modulo7SQLParser.Partition_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link modulo7SQLParser#partition_names}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartition_names(modulo7SQLParser.Partition_namesContext ctx);
	/**
	 * Visit a parse tree produced by {@link modulo7SQLParser#partition_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartition_name(modulo7SQLParser.Partition_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link modulo7SQLParser#subquery_alias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubquery_alias(modulo7SQLParser.Subquery_aliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link modulo7SQLParser#subquery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubquery(modulo7SQLParser.SubqueryContext ctx);
}