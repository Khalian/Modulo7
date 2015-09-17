// Generated from /home/asanyal/git_projects/Modulo7/src/main/antlr/modulo7SQL.g4 by ANTLR 4.5.1

    package  com.modulo7.modulo7SQL;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class modulo7SQLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, SELECT=1, MIDI=2, SHEET=3, MP3=4, MUSICXML=5, FROM=6, WHERE=7, 
		AND=8, OR=9, IS=10, NULL=11, LIKE=12, IN=13, EXISTS=14, ALL=15, ANY=16, 
		TRUE=17, FALSE=18, DIVIDE=19, MOD=20, BETWEEN=21, REGEXP=22, PLUS=23, 
		MINUS=24, NEGATION=25, VERTBAR=26, BITAND=27, POWER_OP=28, BINARY=29, 
		ESCAPE=30, ASTERISK=31, RPAREN=32, LPAREN=33, RBRACK=34, LBRACK=35, COLON=36, 
		ALL_FIELDS=37, EQ=38, LTH=39, GTH=40, NOT_EQ=41, NOT=42, LET=43, GET=44, 
		SEMI=45, COMMA=46, DOT=47, COLLATE=48, INNER=49, OUTER=50, CROSS=51, USING=52, 
		INDEX=53, KEY=54, ORDER=55, GROUP=56, BY=57, FOR=58, USE=59, IGNORE=60, 
		PARTITION=61, OJ=62, ON=63, ID=64, INT=65, NEWLINE=66, WS=67, USER_VAR=68;
	public static final int
		RULE_stat = 0, RULE_schema_name = 1, RULE_select_clause = 2, RULE_table_name = 3, 
		RULE_table_alias = 4, RULE_input_name = 5, RULE_column_name_alias = 6, 
		RULE_index_name = 7, RULE_input_list_clause = 8, RULE_from_clause = 9, 
		RULE_select_key = 10, RULE_where_clause = 11, RULE_expression = 12, RULE_element = 13, 
		RULE_right_element = 14, RULE_left_element = 15, RULE_target_element = 16, 
		RULE_relational_op = 17, RULE_expr_op = 18, RULE_between_op = 19, RULE_is_or_is_not = 20, 
		RULE_simple_expression = 21, RULE_table_references = 22, RULE_table_reference = 23, 
		RULE_table_atom = 24, RULE_index_hint_list = 25, RULE_index_options = 26, 
		RULE_index_hint = 27, RULE_index_list = 28, RULE_partition_clause = 29, 
		RULE_partition_names = 30, RULE_partition_name = 31, RULE_subquery_alias = 32, 
		RULE_subquery = 33;
	public static final String[] ruleNames = {
		"stat", "schema_name", "select_clause", "table_name", "table_alias", "input_name", 
		"column_name_alias", "index_name", "input_list_clause", "from_clause", 
		"select_key", "where_clause", "expression", "element", "right_element", 
		"left_element", "target_element", "relational_op", "expr_op", "between_op", 
		"is_or_is_not", "simple_expression", "table_references", "table_reference", 
		"table_atom", "index_hint_list", "index_options", "index_hint", "index_list", 
		"partition_clause", "partition_names", "partition_name", "subquery_alias", 
		"subquery"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'select'", "'midi'", "'sheet'", "'mp3'", "'musicxml'", "'from'", 
		"'where'", null, null, "'is'", "'null'", "'like'", "'in'", "'exists'", 
		"'all'", "'any'", "'true'", "'false'", null, null, "'between'", "'regexp'", 
		"'+'", "'-'", "'~'", null, "'&'", "'^'", "'binary'", "'escape'", "'*'", 
		"')'", "'('", "']'", "'['", "':'", "'.*'", "'='", "'<'", "'>'", "'!='", 
		"'not'", "'<='", "'>='", "';'", "','", "'.'", "'collate'", "'inner'", 
		"'outer'", "'cross'", "'using'", "'index'", "'key'", "'order'", "'group'", 
		"'by'", "'for'", "'use'", "'ignore'", "'partition'", "'oj'", "'on'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "MIDI", "SHEET", "MP3", "MUSICXML", "FROM", "WHERE", "AND", 
		"OR", "IS", "NULL", "LIKE", "IN", "EXISTS", "ALL", "ANY", "TRUE", "FALSE", 
		"DIVIDE", "MOD", "BETWEEN", "REGEXP", "PLUS", "MINUS", "NEGATION", "VERTBAR", 
		"BITAND", "POWER_OP", "BINARY", "ESCAPE", "ASTERISK", "RPAREN", "LPAREN", 
		"RBRACK", "LBRACK", "COLON", "ALL_FIELDS", "EQ", "LTH", "GTH", "NOT_EQ", 
		"NOT", "LET", "GET", "SEMI", "COMMA", "DOT", "COLLATE", "INNER", "OUTER", 
		"CROSS", "USING", "INDEX", "KEY", "ORDER", "GROUP", "BY", "FOR", "USE", 
		"IGNORE", "PARTITION", "OJ", "ON", "ID", "INT", "NEWLINE", "WS", "USER_VAR"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "modulo7SQL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public modulo7SQLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StatContext extends ParserRuleContext {
		public List<Select_clauseContext> select_clause() {
			return getRuleContexts(Select_clauseContext.class);
		}
		public Select_clauseContext select_clause(int i) {
			return getRuleContext(Select_clauseContext.class,i);
		}
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).exitStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof modulo7SQLVisitor ) return ((modulo7SQLVisitor<? extends T>)visitor).visitStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_stat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(68);
				select_clause();
				}
				}
				setState(71); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Schema_nameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(modulo7SQLParser.ID, 0); }
		public Schema_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_schema_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).enterSchema_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).exitSchema_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof modulo7SQLVisitor ) return ((modulo7SQLVisitor<? extends T>)visitor).visitSchema_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Schema_nameContext schema_name() throws RecognitionException {
		Schema_nameContext _localctx = new Schema_nameContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_schema_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Select_clauseContext extends ParserRuleContext {
		public TerminalNode SELECT() { return getToken(modulo7SQLParser.SELECT, 0); }
		public Input_list_clauseContext input_list_clause() {
			return getRuleContext(Input_list_clauseContext.class,0);
		}
		public TerminalNode FROM() { return getToken(modulo7SQLParser.FROM, 0); }
		public Table_referencesContext table_references() {
			return getRuleContext(Table_referencesContext.class,0);
		}
		public Where_clauseContext where_clause() {
			return getRuleContext(Where_clauseContext.class,0);
		}
		public Select_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).enterSelect_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).exitSelect_clause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof modulo7SQLVisitor ) return ((modulo7SQLVisitor<? extends T>)visitor).visitSelect_clause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Select_clauseContext select_clause() throws RecognitionException {
		Select_clauseContext _localctx = new Select_clauseContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_select_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(T__0);
			setState(76);
			input_list_clause();
			setState(79);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(77);
				match(FROM);
				setState(78);
				table_references();
				}
			}

			setState(82);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(81);
				where_clause();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_nameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(modulo7SQLParser.ID, 0); }
		public Table_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).enterTable_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).exitTable_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof modulo7SQLVisitor ) return ((modulo7SQLVisitor<? extends T>)visitor).visitTable_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Table_nameContext table_name() throws RecognitionException {
		Table_nameContext _localctx = new Table_nameContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_table_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_aliasContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(modulo7SQLParser.ID, 0); }
		public Table_aliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_alias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).enterTable_alias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).exitTable_alias(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof modulo7SQLVisitor ) return ((modulo7SQLVisitor<? extends T>)visitor).visitTable_alias(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Table_aliasContext table_alias() throws RecognitionException {
		Table_aliasContext _localctx = new Table_aliasContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_table_alias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Input_nameContext extends ParserRuleContext {
		public TerminalNode MIDI() { return getToken(modulo7SQLParser.MIDI, 0); }
		public TerminalNode SHEET() { return getToken(modulo7SQLParser.SHEET, 0); }
		public TerminalNode MP3() { return getToken(modulo7SQLParser.MP3, 0); }
		public TerminalNode MUSICXML() { return getToken(modulo7SQLParser.MUSICXML, 0); }
		public Input_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_input_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).enterInput_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).exitInput_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof modulo7SQLVisitor ) return ((modulo7SQLVisitor<? extends T>)visitor).visitInput_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Input_nameContext input_name() throws RecognitionException {
		Input_nameContext _localctx = new Input_nameContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_input_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MIDI) | (1L << SHEET) | (1L << MP3) | (1L << MUSICXML))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Column_name_aliasContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(modulo7SQLParser.ID, 0); }
		public Column_name_aliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_name_alias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).enterColumn_name_alias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).exitColumn_name_alias(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof modulo7SQLVisitor ) return ((modulo7SQLVisitor<? extends T>)visitor).visitColumn_name_alias(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Column_name_aliasContext column_name_alias() throws RecognitionException {
		Column_name_aliasContext _localctx = new Column_name_aliasContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_column_name_alias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Index_nameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(modulo7SQLParser.ID, 0); }
		public Index_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_index_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).enterIndex_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).exitIndex_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof modulo7SQLVisitor ) return ((modulo7SQLVisitor<? extends T>)visitor).visitIndex_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Index_nameContext index_name() throws RecognitionException {
		Index_nameContext _localctx = new Index_nameContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_index_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Input_list_clauseContext extends ParserRuleContext {
		public List<Input_nameContext> input_name() {
			return getRuleContexts(Input_nameContext.class);
		}
		public Input_nameContext input_name(int i) {
			return getRuleContext(Input_nameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(modulo7SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(modulo7SQLParser.COMMA, i);
		}
		public Input_list_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_input_list_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).enterInput_list_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).exitInput_list_clause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof modulo7SQLVisitor ) return ((modulo7SQLVisitor<? extends T>)visitor).visitInput_list_clause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Input_list_clauseContext input_list_clause() throws RecognitionException {
		Input_list_clauseContext _localctx = new Input_list_clauseContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_input_list_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			input_name();
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(95);
				match(COMMA);
				setState(96);
				input_name();
				}
				}
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class From_clauseContext extends ParserRuleContext {
		public TerminalNode FROM() { return getToken(modulo7SQLParser.FROM, 0); }
		public List<Table_nameContext> table_name() {
			return getRuleContexts(Table_nameContext.class);
		}
		public Table_nameContext table_name(int i) {
			return getRuleContext(Table_nameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(modulo7SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(modulo7SQLParser.COMMA, i);
		}
		public From_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_from_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).enterFrom_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).exitFrom_clause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof modulo7SQLVisitor ) return ((modulo7SQLVisitor<? extends T>)visitor).visitFrom_clause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final From_clauseContext from_clause() throws RecognitionException {
		From_clauseContext _localctx = new From_clauseContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_from_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(FROM);
			setState(103);
			table_name();
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(104);
				match(COMMA);
				setState(105);
				table_name();
				}
				}
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Select_keyContext extends ParserRuleContext {
		public TerminalNode SELECT() { return getToken(modulo7SQLParser.SELECT, 0); }
		public Select_keyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_key; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).enterSelect_key(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).exitSelect_key(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof modulo7SQLVisitor ) return ((modulo7SQLVisitor<? extends T>)visitor).visitSelect_key(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Select_keyContext select_key() throws RecognitionException {
		Select_keyContext _localctx = new Select_keyContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_select_key);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Where_clauseContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(modulo7SQLParser.WHERE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Where_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_where_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).enterWhere_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).exitWhere_clause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof modulo7SQLVisitor ) return ((modulo7SQLVisitor<? extends T>)visitor).visitWhere_clause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Where_clauseContext where_clause() throws RecognitionException {
		Where_clauseContext _localctx = new Where_clauseContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_where_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(WHERE);
			setState(114);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public List<Simple_expressionContext> simple_expression() {
			return getRuleContexts(Simple_expressionContext.class);
		}
		public Simple_expressionContext simple_expression(int i) {
			return getRuleContext(Simple_expressionContext.class,i);
		}
		public List<Expr_opContext> expr_op() {
			return getRuleContexts(Expr_opContext.class);
		}
		public Expr_opContext expr_op(int i) {
			return getRuleContext(Expr_opContext.class,i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof modulo7SQLVisitor ) return ((modulo7SQLVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			simple_expression();
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OR) | (1L << NOT))) != 0)) {
				{
				{
				setState(117);
				expr_op();
				setState(118);
				simple_expression();
				}
				}
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElementContext extends ParserRuleContext {
		public TerminalNode USER_VAR() { return getToken(modulo7SQLParser.USER_VAR, 0); }
		public TerminalNode ID() { return getToken(modulo7SQLParser.ID, 0); }
		public TerminalNode INT() { return getToken(modulo7SQLParser.INT, 0); }
		public ElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).enterElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).exitElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof modulo7SQLVisitor ) return ((modulo7SQLVisitor<? extends T>)visitor).visitElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementContext element() throws RecognitionException {
		ElementContext _localctx = new ElementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_element);
		try {
			setState(131);
			switch (_input.LA(1)) {
			case USER_VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(125);
				match(USER_VAR);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
				match(ID);
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(127);
				match(T__0);
				setState(128);
				match(ID);
				setState(129);
				match(T__0);
				}
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 4);
				{
				setState(130);
				match(INT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Right_elementContext extends ParserRuleContext {
		public ElementContext element() {
			return getRuleContext(ElementContext.class,0);
		}
		public Right_elementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_right_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).enterRight_element(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).exitRight_element(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof modulo7SQLVisitor ) return ((modulo7SQLVisitor<? extends T>)visitor).visitRight_element(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Right_elementContext right_element() throws RecognitionException {
		Right_elementContext _localctx = new Right_elementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_right_element);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			element();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Left_elementContext extends ParserRuleContext {
		public ElementContext element() {
			return getRuleContext(ElementContext.class,0);
		}
		public Left_elementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_left_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).enterLeft_element(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).exitLeft_element(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof modulo7SQLVisitor ) return ((modulo7SQLVisitor<? extends T>)visitor).visitLeft_element(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Left_elementContext left_element() throws RecognitionException {
		Left_elementContext _localctx = new Left_elementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_left_element);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			element();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Target_elementContext extends ParserRuleContext {
		public ElementContext element() {
			return getRuleContext(ElementContext.class,0);
		}
		public Target_elementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_target_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).enterTarget_element(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).exitTarget_element(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof modulo7SQLVisitor ) return ((modulo7SQLVisitor<? extends T>)visitor).visitTarget_element(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Target_elementContext target_element() throws RecognitionException {
		Target_elementContext _localctx = new Target_elementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_target_element);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			element();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Relational_opContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(modulo7SQLParser.EQ, 0); }
		public TerminalNode LTH() { return getToken(modulo7SQLParser.LTH, 0); }
		public TerminalNode GTH() { return getToken(modulo7SQLParser.GTH, 0); }
		public TerminalNode NOT_EQ() { return getToken(modulo7SQLParser.NOT_EQ, 0); }
		public TerminalNode LET() { return getToken(modulo7SQLParser.LET, 0); }
		public TerminalNode GET() { return getToken(modulo7SQLParser.GET, 0); }
		public Relational_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relational_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).enterRelational_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).exitRelational_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof modulo7SQLVisitor ) return ((modulo7SQLVisitor<? extends T>)visitor).visitRelational_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Relational_opContext relational_op() throws RecognitionException {
		Relational_opContext _localctx = new Relational_opContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_relational_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << LTH) | (1L << GTH) | (1L << NOT_EQ) | (1L << LET) | (1L << GET))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expr_opContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(modulo7SQLParser.AND, 0); }
		public TerminalNode OR() { return getToken(modulo7SQLParser.OR, 0); }
		public TerminalNode NOT() { return getToken(modulo7SQLParser.NOT, 0); }
		public Expr_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).enterExpr_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).exitExpr_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof modulo7SQLVisitor ) return ((modulo7SQLVisitor<? extends T>)visitor).visitExpr_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_opContext expr_op() throws RecognitionException {
		Expr_opContext _localctx = new Expr_opContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_expr_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OR) | (1L << NOT))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Between_opContext extends ParserRuleContext {
		public TerminalNode BETWEEN() { return getToken(modulo7SQLParser.BETWEEN, 0); }
		public Between_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_between_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).enterBetween_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).exitBetween_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof modulo7SQLVisitor ) return ((modulo7SQLVisitor<? extends T>)visitor).visitBetween_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Between_opContext between_op() throws RecognitionException {
		Between_opContext _localctx = new Between_opContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_between_op);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(BETWEEN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Is_or_is_notContext extends ParserRuleContext {
		public TerminalNode IS() { return getToken(modulo7SQLParser.IS, 0); }
		public TerminalNode NOT() { return getToken(modulo7SQLParser.NOT, 0); }
		public Is_or_is_notContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_is_or_is_not; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).enterIs_or_is_not(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).exitIs_or_is_not(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof modulo7SQLVisitor ) return ((modulo7SQLVisitor<? extends T>)visitor).visitIs_or_is_not(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Is_or_is_notContext is_or_is_not() throws RecognitionException {
		Is_or_is_notContext _localctx = new Is_or_is_notContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_is_or_is_not);
		try {
			setState(148);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				match(IS);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(146);
				match(IS);
				setState(147);
				match(NOT);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Simple_expressionContext extends ParserRuleContext {
		public Left_elementContext left_element() {
			return getRuleContext(Left_elementContext.class,0);
		}
		public Relational_opContext relational_op() {
			return getRuleContext(Relational_opContext.class,0);
		}
		public Right_elementContext right_element() {
			return getRuleContext(Right_elementContext.class,0);
		}
		public Target_elementContext target_element() {
			return getRuleContext(Target_elementContext.class,0);
		}
		public Between_opContext between_op() {
			return getRuleContext(Between_opContext.class,0);
		}
		public TerminalNode AND() { return getToken(modulo7SQLParser.AND, 0); }
		public Is_or_is_notContext is_or_is_not() {
			return getRuleContext(Is_or_is_notContext.class,0);
		}
		public TerminalNode NULL() { return getToken(modulo7SQLParser.NULL, 0); }
		public Simple_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).enterSimple_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).exitSimple_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof modulo7SQLVisitor ) return ((modulo7SQLVisitor<? extends T>)visitor).visitSimple_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Simple_expressionContext simple_expression() throws RecognitionException {
		Simple_expressionContext _localctx = new Simple_expressionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_simple_expression);
		try {
			setState(164);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(150);
				left_element();
				setState(151);
				relational_op();
				setState(152);
				right_element();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(154);
				target_element();
				setState(155);
				between_op();
				setState(156);
				left_element();
				setState(157);
				match(AND);
				setState(158);
				right_element();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(160);
				target_element();
				setState(161);
				is_or_is_not();
				setState(162);
				match(NULL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_referencesContext extends ParserRuleContext {
		public List<Table_referenceContext> table_reference() {
			return getRuleContexts(Table_referenceContext.class);
		}
		public Table_referenceContext table_reference(int i) {
			return getRuleContext(Table_referenceContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(modulo7SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(modulo7SQLParser.COMMA, i);
		}
		public Table_referencesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_references; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).enterTable_references(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).exitTable_references(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof modulo7SQLVisitor ) return ((modulo7SQLVisitor<? extends T>)visitor).visitTable_references(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Table_referencesContext table_references() throws RecognitionException {
		Table_referencesContext _localctx = new Table_referencesContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_table_references);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			table_reference();
			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				{
				setState(167);
				match(COMMA);
				setState(168);
				table_reference();
				}
				}
				}
				setState(173);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_referenceContext extends ParserRuleContext {
		public Table_atomContext table_atom() {
			return getRuleContext(Table_atomContext.class,0);
		}
		public Table_referenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_reference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).enterTable_reference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).exitTable_reference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof modulo7SQLVisitor ) return ((modulo7SQLVisitor<? extends T>)visitor).visitTable_reference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Table_referenceContext table_reference() throws RecognitionException {
		Table_referenceContext _localctx = new Table_referenceContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_table_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			table_atom();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_atomContext extends ParserRuleContext {
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public Partition_clauseContext partition_clause() {
			return getRuleContext(Partition_clauseContext.class,0);
		}
		public Table_aliasContext table_alias() {
			return getRuleContext(Table_aliasContext.class,0);
		}
		public Index_hint_listContext index_hint_list() {
			return getRuleContext(Index_hint_listContext.class,0);
		}
		public SubqueryContext subquery() {
			return getRuleContext(SubqueryContext.class,0);
		}
		public Subquery_aliasContext subquery_alias() {
			return getRuleContext(Subquery_aliasContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(modulo7SQLParser.LPAREN, 0); }
		public Table_referencesContext table_references() {
			return getRuleContext(Table_referencesContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(modulo7SQLParser.RPAREN, 0); }
		public Table_atomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).enterTable_atom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).exitTable_atom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof modulo7SQLVisitor ) return ((modulo7SQLVisitor<? extends T>)visitor).visitTable_atom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Table_atomContext table_atom() throws RecognitionException {
		Table_atomContext _localctx = new Table_atomContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_table_atom);
		int _la;
		try {
			setState(193);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(176);
				table_name();
				setState(178);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(177);
					partition_clause();
					}
				}

				setState(181);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(180);
					table_alias();
					}
				}

				setState(184);
				_la = _input.LA(1);
				if (_la==USE || _la==IGNORE) {
					{
					setState(183);
					index_hint_list();
					}
				}

				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(186);
				subquery();
				setState(187);
				subquery_alias();
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(189);
				match(LPAREN);
				setState(190);
				table_references();
				setState(191);
				match(RPAREN);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Index_hint_listContext extends ParserRuleContext {
		public List<Index_hintContext> index_hint() {
			return getRuleContexts(Index_hintContext.class);
		}
		public Index_hintContext index_hint(int i) {
			return getRuleContext(Index_hintContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(modulo7SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(modulo7SQLParser.COMMA, i);
		}
		public Index_hint_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_index_hint_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).enterIndex_hint_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).exitIndex_hint_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof modulo7SQLVisitor ) return ((modulo7SQLVisitor<? extends T>)visitor).visitIndex_hint_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Index_hint_listContext index_hint_list() throws RecognitionException {
		Index_hint_listContext _localctx = new Index_hint_listContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_index_hint_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			index_hint();
			setState(200);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(196);
					match(COMMA);
					setState(197);
					index_hint();
					}
					} 
				}
				setState(202);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Index_optionsContext extends ParserRuleContext {
		public TerminalNode INDEX() { return getToken(modulo7SQLParser.INDEX, 0); }
		public TerminalNode KEY() { return getToken(modulo7SQLParser.KEY, 0); }
		public TerminalNode FOR() { return getToken(modulo7SQLParser.FOR, 0); }
		public TerminalNode ORDER() { return getToken(modulo7SQLParser.ORDER, 0); }
		public TerminalNode BY() { return getToken(modulo7SQLParser.BY, 0); }
		public TerminalNode GROUP() { return getToken(modulo7SQLParser.GROUP, 0); }
		public Index_optionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_index_options; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).enterIndex_options(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).exitIndex_options(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof modulo7SQLVisitor ) return ((modulo7SQLVisitor<? extends T>)visitor).visitIndex_options(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Index_optionsContext index_options() throws RecognitionException {
		Index_optionsContext _localctx = new Index_optionsContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_index_options);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			_la = _input.LA(1);
			if ( !(_la==INDEX || _la==KEY) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(211);
			_la = _input.LA(1);
			if (_la==FOR) {
				{
				setState(204);
				match(FOR);
				setState(209);
				switch (_input.LA(1)) {
				case ORDER:
					{
					{
					setState(205);
					match(ORDER);
					setState(206);
					match(BY);
					}
					}
					break;
				case GROUP:
					{
					{
					setState(207);
					match(GROUP);
					setState(208);
					match(BY);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Index_hintContext extends ParserRuleContext {
		public TerminalNode USE() { return getToken(modulo7SQLParser.USE, 0); }
		public Index_optionsContext index_options() {
			return getRuleContext(Index_optionsContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(modulo7SQLParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(modulo7SQLParser.RPAREN, 0); }
		public Index_listContext index_list() {
			return getRuleContext(Index_listContext.class,0);
		}
		public TerminalNode IGNORE() { return getToken(modulo7SQLParser.IGNORE, 0); }
		public Index_hintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_index_hint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).enterIndex_hint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).exitIndex_hint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof modulo7SQLVisitor ) return ((modulo7SQLVisitor<? extends T>)visitor).visitIndex_hint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Index_hintContext index_hint() throws RecognitionException {
		Index_hintContext _localctx = new Index_hintContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_index_hint);
		int _la;
		try {
			setState(227);
			switch (_input.LA(1)) {
			case USE:
				enterOuterAlt(_localctx, 1);
				{
				setState(213);
				match(USE);
				setState(214);
				index_options();
				setState(215);
				match(LPAREN);
				setState(217);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(216);
					index_list();
					}
				}

				setState(219);
				match(RPAREN);
				}
				break;
			case IGNORE:
				enterOuterAlt(_localctx, 2);
				{
				setState(221);
				match(IGNORE);
				setState(222);
				index_options();
				setState(223);
				match(LPAREN);
				setState(224);
				index_list();
				setState(225);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Index_listContext extends ParserRuleContext {
		public List<Index_nameContext> index_name() {
			return getRuleContexts(Index_nameContext.class);
		}
		public Index_nameContext index_name(int i) {
			return getRuleContext(Index_nameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(modulo7SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(modulo7SQLParser.COMMA, i);
		}
		public Index_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_index_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).enterIndex_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).exitIndex_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof modulo7SQLVisitor ) return ((modulo7SQLVisitor<? extends T>)visitor).visitIndex_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Index_listContext index_list() throws RecognitionException {
		Index_listContext _localctx = new Index_listContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_index_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			index_name();
			setState(234);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(230);
				match(COMMA);
				setState(231);
				index_name();
				}
				}
				setState(236);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Partition_clauseContext extends ParserRuleContext {
		public TerminalNode PARTITION() { return getToken(modulo7SQLParser.PARTITION, 0); }
		public TerminalNode LPAREN() { return getToken(modulo7SQLParser.LPAREN, 0); }
		public Partition_namesContext partition_names() {
			return getRuleContext(Partition_namesContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(modulo7SQLParser.RPAREN, 0); }
		public Partition_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partition_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).enterPartition_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).exitPartition_clause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof modulo7SQLVisitor ) return ((modulo7SQLVisitor<? extends T>)visitor).visitPartition_clause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Partition_clauseContext partition_clause() throws RecognitionException {
		Partition_clauseContext _localctx = new Partition_clauseContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_partition_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			match(PARTITION);
			setState(238);
			match(LPAREN);
			setState(239);
			partition_names();
			setState(240);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Partition_namesContext extends ParserRuleContext {
		public List<Partition_nameContext> partition_name() {
			return getRuleContexts(Partition_nameContext.class);
		}
		public Partition_nameContext partition_name(int i) {
			return getRuleContext(Partition_nameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(modulo7SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(modulo7SQLParser.COMMA, i);
		}
		public Partition_namesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partition_names; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).enterPartition_names(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).exitPartition_names(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof modulo7SQLVisitor ) return ((modulo7SQLVisitor<? extends T>)visitor).visitPartition_names(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Partition_namesContext partition_names() throws RecognitionException {
		Partition_namesContext _localctx = new Partition_namesContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_partition_names);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			partition_name();
			setState(247);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(243);
				match(COMMA);
				setState(244);
				partition_name();
				}
				}
				setState(249);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Partition_nameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(modulo7SQLParser.ID, 0); }
		public Partition_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partition_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).enterPartition_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).exitPartition_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof modulo7SQLVisitor ) return ((modulo7SQLVisitor<? extends T>)visitor).visitPartition_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Partition_nameContext partition_name() throws RecognitionException {
		Partition_nameContext _localctx = new Partition_nameContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_partition_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Subquery_aliasContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(modulo7SQLParser.ID, 0); }
		public Subquery_aliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subquery_alias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).enterSubquery_alias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).exitSubquery_alias(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof modulo7SQLVisitor ) return ((modulo7SQLVisitor<? extends T>)visitor).visitSubquery_alias(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Subquery_aliasContext subquery_alias() throws RecognitionException {
		Subquery_aliasContext _localctx = new Subquery_aliasContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_subquery_alias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubqueryContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(modulo7SQLParser.LPAREN, 0); }
		public Select_clauseContext select_clause() {
			return getRuleContext(Select_clauseContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(modulo7SQLParser.RPAREN, 0); }
		public SubqueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subquery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).enterSubquery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof modulo7SQLListener ) ((modulo7SQLListener)listener).exitSubquery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof modulo7SQLVisitor ) return ((modulo7SQLVisitor<? extends T>)visitor).visitSubquery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubqueryContext subquery() throws RecognitionException {
		SubqueryContext _localctx = new SubqueryContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			match(LPAREN);
			setState(255);
			select_clause();
			setState(256);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3F\u0105\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\6\2H\n\2\r\2\16\2I\3\3\3\3\3\4\3\4\3\4\3\4\5\4R"+
		"\n\4\3\4\5\4U\n\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n"+
		"\7\nd\n\n\f\n\16\ng\13\n\3\13\3\13\3\13\3\13\7\13m\n\13\f\13\16\13p\13"+
		"\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\7\16{\n\16\f\16\16\16~\13"+
		"\16\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u0086\n\17\3\20\3\20\3\21\3\21"+
		"\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\26\5\26\u0097\n\26"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\5\27\u00a7\n\27\3\30\3\30\3\30\7\30\u00ac\n\30\f\30\16\30\u00af\13\30"+
		"\3\31\3\31\3\32\3\32\5\32\u00b5\n\32\3\32\5\32\u00b8\n\32\3\32\5\32\u00bb"+
		"\n\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u00c4\n\32\3\33\3\33\3\33"+
		"\7\33\u00c9\n\33\f\33\16\33\u00cc\13\33\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\5\34\u00d4\n\34\5\34\u00d6\n\34\3\35\3\35\3\35\3\35\5\35\u00dc\n\35\3"+
		"\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u00e6\n\35\3\36\3\36\3\36"+
		"\7\36\u00eb\n\36\f\36\16\36\u00ee\13\36\3\37\3\37\3\37\3\37\3\37\3 \3"+
		" \3 \7 \u00f8\n \f \16 \u00fb\13 \3!\3!\3\"\3\"\3#\3#\3#\3#\3#\2\2$\2"+
		"\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BD\2\6"+
		"\3\2\4\7\4\2(+-.\4\2\n\13,,\3\2\678\u00fb\2G\3\2\2\2\4K\3\2\2\2\6M\3\2"+
		"\2\2\bV\3\2\2\2\nX\3\2\2\2\fZ\3\2\2\2\16\\\3\2\2\2\20^\3\2\2\2\22`\3\2"+
		"\2\2\24h\3\2\2\2\26q\3\2\2\2\30s\3\2\2\2\32v\3\2\2\2\34\u0085\3\2\2\2"+
		"\36\u0087\3\2\2\2 \u0089\3\2\2\2\"\u008b\3\2\2\2$\u008d\3\2\2\2&\u008f"+
		"\3\2\2\2(\u0091\3\2\2\2*\u0096\3\2\2\2,\u00a6\3\2\2\2.\u00a8\3\2\2\2\60"+
		"\u00b0\3\2\2\2\62\u00c3\3\2\2\2\64\u00c5\3\2\2\2\66\u00cd\3\2\2\28\u00e5"+
		"\3\2\2\2:\u00e7\3\2\2\2<\u00ef\3\2\2\2>\u00f4\3\2\2\2@\u00fc\3\2\2\2B"+
		"\u00fe\3\2\2\2D\u0100\3\2\2\2FH\5\6\4\2GF\3\2\2\2HI\3\2\2\2IG\3\2\2\2"+
		"IJ\3\2\2\2J\3\3\2\2\2KL\7B\2\2L\5\3\2\2\2MN\7\3\2\2NQ\5\22\n\2OP\7\b\2"+
		"\2PR\5.\30\2QO\3\2\2\2QR\3\2\2\2RT\3\2\2\2SU\5\30\r\2TS\3\2\2\2TU\3\2"+
		"\2\2U\7\3\2\2\2VW\7B\2\2W\t\3\2\2\2XY\7B\2\2Y\13\3\2\2\2Z[\t\2\2\2[\r"+
		"\3\2\2\2\\]\7B\2\2]\17\3\2\2\2^_\7B\2\2_\21\3\2\2\2`e\5\f\7\2ab\7\60\2"+
		"\2bd\5\f\7\2ca\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2f\23\3\2\2\2ge\3\2"+
		"\2\2hi\7\b\2\2in\5\b\5\2jk\7\60\2\2km\5\b\5\2lj\3\2\2\2mp\3\2\2\2nl\3"+
		"\2\2\2no\3\2\2\2o\25\3\2\2\2pn\3\2\2\2qr\7\3\2\2r\27\3\2\2\2st\7\t\2\2"+
		"tu\5\32\16\2u\31\3\2\2\2v|\5,\27\2wx\5&\24\2xy\5,\27\2y{\3\2\2\2zw\3\2"+
		"\2\2{~\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\33\3\2\2\2~|\3\2\2\2\177\u0086\7F"+
		"\2\2\u0080\u0086\7B\2\2\u0081\u0082\7\3\2\2\u0082\u0083\7B\2\2\u0083\u0086"+
		"\7\3\2\2\u0084\u0086\7C\2\2\u0085\177\3\2\2\2\u0085\u0080\3\2\2\2\u0085"+
		"\u0081\3\2\2\2\u0085\u0084\3\2\2\2\u0086\35\3\2\2\2\u0087\u0088\5\34\17"+
		"\2\u0088\37\3\2\2\2\u0089\u008a\5\34\17\2\u008a!\3\2\2\2\u008b\u008c\5"+
		"\34\17\2\u008c#\3\2\2\2\u008d\u008e\t\3\2\2\u008e%\3\2\2\2\u008f\u0090"+
		"\t\4\2\2\u0090\'\3\2\2\2\u0091\u0092\7\27\2\2\u0092)\3\2\2\2\u0093\u0097"+
		"\7\f\2\2\u0094\u0095\7\f\2\2\u0095\u0097\7,\2\2\u0096\u0093\3\2\2\2\u0096"+
		"\u0094\3\2\2\2\u0097+\3\2\2\2\u0098\u0099\5 \21\2\u0099\u009a\5$\23\2"+
		"\u009a\u009b\5\36\20\2\u009b\u00a7\3\2\2\2\u009c\u009d\5\"\22\2\u009d"+
		"\u009e\5(\25\2\u009e\u009f\5 \21\2\u009f\u00a0\7\n\2\2\u00a0\u00a1\5\36"+
		"\20\2\u00a1\u00a7\3\2\2\2\u00a2\u00a3\5\"\22\2\u00a3\u00a4\5*\26\2\u00a4"+
		"\u00a5\7\r\2\2\u00a5\u00a7\3\2\2\2\u00a6\u0098\3\2\2\2\u00a6\u009c\3\2"+
		"\2\2\u00a6\u00a2\3\2\2\2\u00a7-\3\2\2\2\u00a8\u00ad\5\60\31\2\u00a9\u00aa"+
		"\7\60\2\2\u00aa\u00ac\5\60\31\2\u00ab\u00a9\3\2\2\2\u00ac\u00af\3\2\2"+
		"\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae/\3\2\2\2\u00af\u00ad"+
		"\3\2\2\2\u00b0\u00b1\5\62\32\2\u00b1\61\3\2\2\2\u00b2\u00b4\5\b\5\2\u00b3"+
		"\u00b5\5<\37\2\u00b4\u00b3\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b7\3\2"+
		"\2\2\u00b6\u00b8\5\n\6\2\u00b7\u00b6\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8"+
		"\u00ba\3\2\2\2\u00b9\u00bb\5\64\33\2\u00ba\u00b9\3\2\2\2\u00ba\u00bb\3"+
		"\2\2\2\u00bb\u00c4\3\2\2\2\u00bc\u00bd\5D#\2\u00bd\u00be\5B\"\2\u00be"+
		"\u00c4\3\2\2\2\u00bf\u00c0\7#\2\2\u00c0\u00c1\5.\30\2\u00c1\u00c2\7\""+
		"\2\2\u00c2\u00c4\3\2\2\2\u00c3\u00b2\3\2\2\2\u00c3\u00bc\3\2\2\2\u00c3"+
		"\u00bf\3\2\2\2\u00c4\63\3\2\2\2\u00c5\u00ca\58\35\2\u00c6\u00c7\7\60\2"+
		"\2\u00c7\u00c9\58\35\2\u00c8\u00c6\3\2\2\2\u00c9\u00cc\3\2\2\2\u00ca\u00c8"+
		"\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\65\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cd"+
		"\u00d5\t\5\2\2\u00ce\u00d3\7<\2\2\u00cf\u00d0\79\2\2\u00d0\u00d4\7;\2"+
		"\2\u00d1\u00d2\7:\2\2\u00d2\u00d4\7;\2\2\u00d3\u00cf\3\2\2\2\u00d3\u00d1"+
		"\3\2\2\2\u00d4\u00d6\3\2\2\2\u00d5\u00ce\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6"+
		"\67\3\2\2\2\u00d7\u00d8\7=\2\2\u00d8\u00d9\5\66\34\2\u00d9\u00db\7#\2"+
		"\2\u00da\u00dc\5:\36\2\u00db\u00da\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00dd"+
		"\3\2\2\2\u00dd\u00de\7\"\2\2\u00de\u00e6\3\2\2\2\u00df\u00e0\7>\2\2\u00e0"+
		"\u00e1\5\66\34\2\u00e1\u00e2\7#\2\2\u00e2\u00e3\5:\36\2\u00e3\u00e4\7"+
		"\"\2\2\u00e4\u00e6\3\2\2\2\u00e5\u00d7\3\2\2\2\u00e5\u00df\3\2\2\2\u00e6"+
		"9\3\2\2\2\u00e7\u00ec\5\20\t\2\u00e8\u00e9\7\60\2\2\u00e9\u00eb\5\20\t"+
		"\2\u00ea\u00e8\3\2\2\2\u00eb\u00ee\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed"+
		"\3\2\2\2\u00ed;\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ef\u00f0\7?\2\2\u00f0\u00f1"+
		"\7#\2\2\u00f1\u00f2\5> \2\u00f2\u00f3\7\"\2\2\u00f3=\3\2\2\2\u00f4\u00f9"+
		"\5@!\2\u00f5\u00f6\7\60\2\2\u00f6\u00f8\5@!\2\u00f7\u00f5\3\2\2\2\u00f8"+
		"\u00fb\3\2\2\2\u00f9\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa?\3\2\2\2"+
		"\u00fb\u00f9\3\2\2\2\u00fc\u00fd\7B\2\2\u00fdA\3\2\2\2\u00fe\u00ff\7B"+
		"\2\2\u00ffC\3\2\2\2\u0100\u0101\7#\2\2\u0101\u0102\5\6\4\2\u0102\u0103"+
		"\7\"\2\2\u0103E\3\2\2\2\27IQTen|\u0085\u0096\u00a6\u00ad\u00b4\u00b7\u00ba"+
		"\u00c3\u00ca\u00d3\u00d5\u00db\u00e5\u00ec\u00f9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}