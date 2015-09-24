lexer grammar Modulo7SQLBase;

@header {
    package  com.modulo7.modulo7SQL;
}

SELECT: 'select';
MIDI: 'midi';
SHEET: 'sheet';
MP3: 'mp3';
MUSICXML: 'musicxml';
FROM: 'from';
WHERE: 'where';
AND: 'and' | '&&';
OR: 'or' | '||';
IS: 'is';
NULL: 'null';
LIKE: 'like';
IN: 'in';
EXISTS: 'exists';
ALL: 'all';
ANY: 'any';
TRUE: 'true';
FALSE: 'false';
DIVIDE	: 'div' | '/' ;
MOD: 'mod' | '%' ;
PLUS	: '+' ;
MINUS	: '-' ;
NEGATION: '~' ;
VERTBAR	: '|' ;
BITAND	: '&' ;
POWER_OP: '^' ;
BINARY: 'binary';
ESCAPE: 'escape';
ASTERISK: '*' ;
RPAREN	: ')' ;
LPAREN	: '(' ;
RBRACK	: ']' ;
LBRACK	: '[' ;
COLON	: ':' ;
ALL_FIELDS	: '.*' ;
EQ: '=';
LTH: '<';
GTH: '>';
NOT_EQ: '!=';
NOT: 'not';
LET: '<=';
GET: '>=';
SEMI: ';';
COMMA: ',';
DOT: '.';
COLLATE: 'collate';
USING: 'using';
INDEX: 'index';
BETWEEN: 'between';


POLYPHONIC: 'polyphonic';

HAPPINESSINDEX : 'happinessindex';
SADNESSINDEX : 'sadnessindex';
POWERINDEX : 'powerindex';
MAXMELODICREPREATINGFACTOR: 'maxmelodicrepeatingfactor';

ID: ('a'..'z' | 'A' .. 'Z' | '_')+ ;
INT: '0'..'9'+ ;
DOUBLE  : '0'..'9'+'.''0'..'9'+ ;
DATABASENAME: ('a'..'z' | 'A' .. 'Z' | '_')+ ;

NEWLINE: '\r' ? '\n' -> skip;
WS: (' ' | '\t' | '\n' | '\r')+ -> skip;

USER_VAR:
	'@' (USER_VAR_SUBFIX1 | USER_VAR_SUBFIX2 | USER_VAR_SUBFIX3 | USER_VAR_SUBFIX4)
;

fragment USER_VAR_SUBFIX1:	(  '`' (~'`' )+ '`'  ) ;
fragment USER_VAR_SUBFIX2:	( '\'' (~'\'')+ '\'' ) ;
fragment USER_VAR_SUBFIX3:	( '\"' (~'\"')+ '\"' ) ;
fragment USER_VAR_SUBFIX4:	( 'A'..'Z' | 'a'..'z' | '_' | '$' | '0'..'9' | DOT )+ ;