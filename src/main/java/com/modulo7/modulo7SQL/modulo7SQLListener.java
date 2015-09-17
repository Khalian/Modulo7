// Generated from /home/asanyal/git_projects/Modulo7/src/main/antlr/modulo7SQL.g4 by ANTLR 4.5.1

    package  com.modulo7.modulo7SQL;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link modulo7SQLParser}.
 */
public interface modulo7SQLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link modulo7SQLParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(modulo7SQLParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link modulo7SQLParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(modulo7SQLParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link modulo7SQLParser#schema_name}.
	 * @param ctx the parse tree
	 */
	void enterSchema_name(modulo7SQLParser.Schema_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link modulo7SQLParser#schema_name}.
	 * @param ctx the parse tree
	 */
	void exitSchema_name(modulo7SQLParser.Schema_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link modulo7SQLParser#select_clause}.
	 * @param ctx the parse tree
	 */
	void enterSelect_clause(modulo7SQLParser.Select_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link modulo7SQLParser#select_clause}.
	 * @param ctx the parse tree
	 */
	void exitSelect_clause(modulo7SQLParser.Select_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link modulo7SQLParser#table_name}.
	 * @param ctx the parse tree
	 */
	void enterTable_name(modulo7SQLParser.Table_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link modulo7SQLParser#table_name}.
	 * @param ctx the parse tree
	 */
	void exitTable_name(modulo7SQLParser.Table_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link modulo7SQLParser#table_alias}.
	 * @param ctx the parse tree
	 */
	void enterTable_alias(modulo7SQLParser.Table_aliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link modulo7SQLParser#table_alias}.
	 * @param ctx the parse tree
	 */
	void exitTable_alias(modulo7SQLParser.Table_aliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link modulo7SQLParser#input_name}.
	 * @param ctx the parse tree
	 */
	void enterInput_name(modulo7SQLParser.Input_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link modulo7SQLParser#input_name}.
	 * @param ctx the parse tree
	 */
	void exitInput_name(modulo7SQLParser.Input_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link modulo7SQLParser#column_name_alias}.
	 * @param ctx the parse tree
	 */
	void enterColumn_name_alias(modulo7SQLParser.Column_name_aliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link modulo7SQLParser#column_name_alias}.
	 * @param ctx the parse tree
	 */
	void exitColumn_name_alias(modulo7SQLParser.Column_name_aliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link modulo7SQLParser#index_name}.
	 * @param ctx the parse tree
	 */
	void enterIndex_name(modulo7SQLParser.Index_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link modulo7SQLParser#index_name}.
	 * @param ctx the parse tree
	 */
	void exitIndex_name(modulo7SQLParser.Index_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link modulo7SQLParser#input_list_clause}.
	 * @param ctx the parse tree
	 */
	void enterInput_list_clause(modulo7SQLParser.Input_list_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link modulo7SQLParser#input_list_clause}.
	 * @param ctx the parse tree
	 */
	void exitInput_list_clause(modulo7SQLParser.Input_list_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link modulo7SQLParser#from_clause}.
	 * @param ctx the parse tree
	 */
	void enterFrom_clause(modulo7SQLParser.From_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link modulo7SQLParser#from_clause}.
	 * @param ctx the parse tree
	 */
	void exitFrom_clause(modulo7SQLParser.From_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link modulo7SQLParser#select_key}.
	 * @param ctx the parse tree
	 */
	void enterSelect_key(modulo7SQLParser.Select_keyContext ctx);
	/**
	 * Exit a parse tree produced by {@link modulo7SQLParser#select_key}.
	 * @param ctx the parse tree
	 */
	void exitSelect_key(modulo7SQLParser.Select_keyContext ctx);
	/**
	 * Enter a parse tree produced by {@link modulo7SQLParser#where_clause}.
	 * @param ctx the parse tree
	 */
	void enterWhere_clause(modulo7SQLParser.Where_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link modulo7SQLParser#where_clause}.
	 * @param ctx the parse tree
	 */
	void exitWhere_clause(modulo7SQLParser.Where_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link modulo7SQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(modulo7SQLParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link modulo7SQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(modulo7SQLParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link modulo7SQLParser#element}.
	 * @param ctx the parse tree
	 */
	void enterElement(modulo7SQLParser.ElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link modulo7SQLParser#element}.
	 * @param ctx the parse tree
	 */
	void exitElement(modulo7SQLParser.ElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link modulo7SQLParser#right_element}.
	 * @param ctx the parse tree
	 */
	void enterRight_element(modulo7SQLParser.Right_elementContext ctx);
	/**
	 * Exit a parse tree produced by {@link modulo7SQLParser#right_element}.
	 * @param ctx the parse tree
	 */
	void exitRight_element(modulo7SQLParser.Right_elementContext ctx);
	/**
	 * Enter a parse tree produced by {@link modulo7SQLParser#left_element}.
	 * @param ctx the parse tree
	 */
	void enterLeft_element(modulo7SQLParser.Left_elementContext ctx);
	/**
	 * Exit a parse tree produced by {@link modulo7SQLParser#left_element}.
	 * @param ctx the parse tree
	 */
	void exitLeft_element(modulo7SQLParser.Left_elementContext ctx);
	/**
	 * Enter a parse tree produced by {@link modulo7SQLParser#target_element}.
	 * @param ctx the parse tree
	 */
	void enterTarget_element(modulo7SQLParser.Target_elementContext ctx);
	/**
	 * Exit a parse tree produced by {@link modulo7SQLParser#target_element}.
	 * @param ctx the parse tree
	 */
	void exitTarget_element(modulo7SQLParser.Target_elementContext ctx);
	/**
	 * Enter a parse tree produced by {@link modulo7SQLParser#relational_op}.
	 * @param ctx the parse tree
	 */
	void enterRelational_op(modulo7SQLParser.Relational_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link modulo7SQLParser#relational_op}.
	 * @param ctx the parse tree
	 */
	void exitRelational_op(modulo7SQLParser.Relational_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link modulo7SQLParser#expr_op}.
	 * @param ctx the parse tree
	 */
	void enterExpr_op(modulo7SQLParser.Expr_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link modulo7SQLParser#expr_op}.
	 * @param ctx the parse tree
	 */
	void exitExpr_op(modulo7SQLParser.Expr_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link modulo7SQLParser#between_op}.
	 * @param ctx the parse tree
	 */
	void enterBetween_op(modulo7SQLParser.Between_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link modulo7SQLParser#between_op}.
	 * @param ctx the parse tree
	 */
	void exitBetween_op(modulo7SQLParser.Between_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link modulo7SQLParser#is_or_is_not}.
	 * @param ctx the parse tree
	 */
	void enterIs_or_is_not(modulo7SQLParser.Is_or_is_notContext ctx);
	/**
	 * Exit a parse tree produced by {@link modulo7SQLParser#is_or_is_not}.
	 * @param ctx the parse tree
	 */
	void exitIs_or_is_not(modulo7SQLParser.Is_or_is_notContext ctx);
	/**
	 * Enter a parse tree produced by {@link modulo7SQLParser#simple_expression}.
	 * @param ctx the parse tree
	 */
	void enterSimple_expression(modulo7SQLParser.Simple_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link modulo7SQLParser#simple_expression}.
	 * @param ctx the parse tree
	 */
	void exitSimple_expression(modulo7SQLParser.Simple_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link modulo7SQLParser#table_references}.
	 * @param ctx the parse tree
	 */
	void enterTable_references(modulo7SQLParser.Table_referencesContext ctx);
	/**
	 * Exit a parse tree produced by {@link modulo7SQLParser#table_references}.
	 * @param ctx the parse tree
	 */
	void exitTable_references(modulo7SQLParser.Table_referencesContext ctx);
	/**
	 * Enter a parse tree produced by {@link modulo7SQLParser#table_reference}.
	 * @param ctx the parse tree
	 */
	void enterTable_reference(modulo7SQLParser.Table_referenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link modulo7SQLParser#table_reference}.
	 * @param ctx the parse tree
	 */
	void exitTable_reference(modulo7SQLParser.Table_referenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link modulo7SQLParser#table_atom}.
	 * @param ctx the parse tree
	 */
	void enterTable_atom(modulo7SQLParser.Table_atomContext ctx);
	/**
	 * Exit a parse tree produced by {@link modulo7SQLParser#table_atom}.
	 * @param ctx the parse tree
	 */
	void exitTable_atom(modulo7SQLParser.Table_atomContext ctx);
	/**
	 * Enter a parse tree produced by {@link modulo7SQLParser#index_hint_list}.
	 * @param ctx the parse tree
	 */
	void enterIndex_hint_list(modulo7SQLParser.Index_hint_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link modulo7SQLParser#index_hint_list}.
	 * @param ctx the parse tree
	 */
	void exitIndex_hint_list(modulo7SQLParser.Index_hint_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link modulo7SQLParser#index_options}.
	 * @param ctx the parse tree
	 */
	void enterIndex_options(modulo7SQLParser.Index_optionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link modulo7SQLParser#index_options}.
	 * @param ctx the parse tree
	 */
	void exitIndex_options(modulo7SQLParser.Index_optionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link modulo7SQLParser#index_hint}.
	 * @param ctx the parse tree
	 */
	void enterIndex_hint(modulo7SQLParser.Index_hintContext ctx);
	/**
	 * Exit a parse tree produced by {@link modulo7SQLParser#index_hint}.
	 * @param ctx the parse tree
	 */
	void exitIndex_hint(modulo7SQLParser.Index_hintContext ctx);
	/**
	 * Enter a parse tree produced by {@link modulo7SQLParser#index_list}.
	 * @param ctx the parse tree
	 */
	void enterIndex_list(modulo7SQLParser.Index_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link modulo7SQLParser#index_list}.
	 * @param ctx the parse tree
	 */
	void exitIndex_list(modulo7SQLParser.Index_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link modulo7SQLParser#partition_clause}.
	 * @param ctx the parse tree
	 */
	void enterPartition_clause(modulo7SQLParser.Partition_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link modulo7SQLParser#partition_clause}.
	 * @param ctx the parse tree
	 */
	void exitPartition_clause(modulo7SQLParser.Partition_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link modulo7SQLParser#partition_names}.
	 * @param ctx the parse tree
	 */
	void enterPartition_names(modulo7SQLParser.Partition_namesContext ctx);
	/**
	 * Exit a parse tree produced by {@link modulo7SQLParser#partition_names}.
	 * @param ctx the parse tree
	 */
	void exitPartition_names(modulo7SQLParser.Partition_namesContext ctx);
	/**
	 * Enter a parse tree produced by {@link modulo7SQLParser#partition_name}.
	 * @param ctx the parse tree
	 */
	void enterPartition_name(modulo7SQLParser.Partition_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link modulo7SQLParser#partition_name}.
	 * @param ctx the parse tree
	 */
	void exitPartition_name(modulo7SQLParser.Partition_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link modulo7SQLParser#subquery_alias}.
	 * @param ctx the parse tree
	 */
	void enterSubquery_alias(modulo7SQLParser.Subquery_aliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link modulo7SQLParser#subquery_alias}.
	 * @param ctx the parse tree
	 */
	void exitSubquery_alias(modulo7SQLParser.Subquery_aliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link modulo7SQLParser#subquery}.
	 * @param ctx the parse tree
	 */
	void enterSubquery(modulo7SQLParser.SubqueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link modulo7SQLParser#subquery}.
	 * @param ctx the parse tree
	 */
	void exitSubquery(modulo7SQLParser.SubqueryContext ctx);
}