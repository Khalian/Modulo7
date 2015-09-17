grammar modulo7SQL;

// Check out the examples from https://github.com/antlr/grammars-v4/blob/master/mysql/MySQL.g4

options {
	tokenVocab = modulo7SQLBase;

	// antlr will generate java lexer and parser
    language = Java;

    // generated parser should create abstract syntax tree
    output = AST;
}

@header {
    package  com.modulo7.modulo7SQL;
}

stat:
		select_clause+
	;

schema_name:
    ID
    ;

select_clause:
		SELECT
		input_list_clause
		(FROM table_references)?
		(where_clause)?
		;

table_name:
	ID
	;

table_alias:
    ID
    ;

input_name:
        MIDI
    |   SHEET
    |   MP3
    |   MUSICXML;

column_name_alias:
	ID
	;

index_name:
    ID
    ;

input_list_clause:
		input_name (COMMA input_name)*
	;

from_clause:
		FROM table_name (COMMA table_name)*
	;

select_key:
		SELECT
	;

where_clause:
		WHERE expression
		;

expression:
		simple_expression (expr_op simple_expression)*
	;

element:
		USER_VAR | ID | ('|' ID '|') | INT
	;

right_element:
		element
	;

left_element:
		element
	;

target_element:
		element
	;

relational_op:
		EQ | LTH | GTH | NOT_EQ | LET | GET  ;

expr_op:
		AND | OR | NOT ;

between_op:
		BETWEEN
	;

is_or_is_not:
		IS | IS NOT
	;

simple_expression:
		left_element relational_op right_element
	|
		target_element between_op left_element AND right_element
	|
		target_element is_or_is_not NULL
	;

table_references:
        table_reference ( (COMMA table_reference) )*
;

table_reference:
	 table_atom
;

table_atom:
	  ( table_name (partition_clause)? (table_alias)? (index_hint_list)? )
	| ( subquery subquery_alias )
	| ( LPAREN table_references RPAREN )
;

index_hint_list:
	index_hint (COMMA index_hint)*
;

index_options:
	(INDEX | KEY) (FOR ((ORDER BY) | (GROUP BY)))?
;

index_hint:
	  USE    index_options LPAREN (index_list)? RPAREN
	| IGNORE index_options LPAREN index_list RPAREN
;

index_list:
	index_name (COMMA index_name)*
;

partition_clause:
	PARTITION LPAREN partition_names RPAREN
;

partition_names:
	partition_name (COMMA partition_name)* ;

partition_name:
    ID
    ;

subquery_alias:
    ID
    ;

subquery:
	LPAREN select_clause RPAREN
;