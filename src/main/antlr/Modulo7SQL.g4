grammar Modulo7SQL;

// Check out the examples from https://github.com/antlr/grammars-v4/blob/master/mysql/MySQL.g4

options {
	tokenVocab = Modulo7SQLBase;

	// antlr will generate java lexer and parser
    language = Java;

    // generated parser should create abstract syntax tree
    output = AST;
}

@header {
    package  com.modulo7.modulo7SQL;
}

select_clause:
		select_key
		input_list_clause
		(from_clause)?
		(where_clause)?
		(preprocess_clause)?
		SEMI
		;

preprocess_clause:
        AND PREPROCESS ON preprocess_criteria (COMMA preprocess_criteria)*
    ;

preprocess_criteria:
        NATURALCONTOUR
    |   STEINBECKCONTOUR
    |   MULLENFESTEINCONTOUR
    ;

from_clause:
    FROM table_name
    ;

table_name:
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
		INT | DOUBLE
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
		EQ | LTH | GTH | NOT_EQ ;

expr_op:
		AND | OR | NOT ;

between_op:
		BETWEEN
	;

is_or_is_not:
		IS | IS NOT
	;

either_true_or_false:
        TRUE | FALSE
    ;

simple_expression:
		criteria is_or_is_not either_true_or_false |
		statistic relational_op element |
		statistic between_op left_element AND right_element
	;

criteria:
    POLYPHONIC
;

statistic:
    HAPPINESSINDEX |
    SADNESSINDEX |
    POWERINDEX |
    MAXMELODICREPREATINGFACTOR
;