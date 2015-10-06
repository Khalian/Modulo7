// Generated from /home/asanyal/git_projects/Modulo7/src/main/antlr/Modulo7SQL.g4 by ANTLR 4.5.1

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
public class Modulo7SQLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SELECT=1, MIDI=2, SHEET=3, MP3=4, MUSICXML=5, PREPROCESS=6, NATURALCONTOUR=7, 
		STEINBECKCONTOUR=8, MULLENFESTEINCONTOUR=9, ON=10, FROM=11, WHERE=12, 
		AND=13, OR=14, IS=15, NULL=16, IN=17, TRUE=18, FALSE=19, DIVIDE=20, MOD=21, 
		PLUS=22, MINUS=23, NEGATION=24, VERTBAR=25, BITAND=26, POWER_OP=27, BINARY=28, 
		ESCAPE=29, ASTERISK=30, RPAREN=31, LPAREN=32, RBRACK=33, LBRACK=34, COLON=35, 
		ALL_FIELDS=36, EQ=37, LTH=38, GTH=39, NOT_EQ=40, NOT=41, LET=42, GET=43, 
		SEMI=44, COMMA=45, DOT=46, COLLATE=47, USING=48, INDEX=49, BETWEEN=50, 
		POLYPHONIC=51, HAPPINESSINDEX=52, SADNESSINDEX=53, POWERINDEX=54, MAXMELODICREPREATINGFACTOR=55, 
		ID=56, INT=57, DOUBLE=58, DATABASENAME=59, NEWLINE=60, WS=61, USER_VAR=62;
	public static final int
		RULE_select_clause = 0, RULE_preprocess_clause = 1, RULE_preprocess_criteria = 2, 
		RULE_from_clause = 3, RULE_table_name = 4, RULE_input_name = 5, RULE_column_name_alias = 6, 
		RULE_index_name = 7, RULE_input_list_clause = 8, RULE_select_key = 9, 
		RULE_where_clause = 10, RULE_expression = 11, RULE_element = 12, RULE_right_element = 13, 
		RULE_left_element = 14, RULE_target_element = 15, RULE_relational_op = 16, 
		RULE_expr_op = 17, RULE_between_op = 18, RULE_is_or_is_not = 19, RULE_either_true_or_false = 20, 
		RULE_simple_expression = 21, RULE_criteria = 22, RULE_statistic = 23;
	public static final String[] ruleNames = {
		"select_clause", "preprocess_clause", "preprocess_criteria", "from_clause", 
		"table_name", "input_name", "column_name_alias", "index_name", "input_list_clause", 
		"select_key", "where_clause", "expression", "element", "right_element", 
		"left_element", "target_element", "relational_op", "expr_op", "between_op", 
		"is_or_is_not", "either_true_or_false", "simple_expression", "criteria", 
		"statistic"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'select'", "'midi'", "'sheet'", "'mp3'", "'musicxml'", "'preprocess'", 
		"'naturalcontour'", "'steinbeckcontour'", "' mullenfesteincontour'", "'on'", 
		"'from'", "'where'", null, null, "'is'", "'null'", "'in'", "'true'", "'false'", 
		null, null, "'+'", "'-'", "'~'", "'|'", "'&'", "'^'", "'binary'", "'escape'", 
		"'*'", "')'", "'('", "']'", "'['", "':'", "'.*'", "'='", "'<'", "'>'", 
		"'!='", "'not'", "'<='", "'>='", "';'", "','", "'.'", "'collate'", "'using'", 
		"'index'", "'between'", "'polyphonic'", "'happinessindex'", "'sadnessindex'", 
		"'powerindex'", "'maxmelodicrepeatingfactor'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "SELECT", "MIDI", "SHEET", "MP3", "MUSICXML", "PREPROCESS", "NATURALCONTOUR", 
		"STEINBECKCONTOUR", "MULLENFESTEINCONTOUR", "ON", "FROM", "WHERE", "AND", 
		"OR", "IS", "NULL", "IN", "TRUE", "FALSE", "DIVIDE", "MOD", "PLUS", "MINUS", 
		"NEGATION", "VERTBAR", "BITAND", "POWER_OP", "BINARY", "ESCAPE", "ASTERISK", 
		"RPAREN", "LPAREN", "RBRACK", "LBRACK", "COLON", "ALL_FIELDS", "EQ", "LTH", 
		"GTH", "NOT_EQ", "NOT", "LET", "GET", "SEMI", "COMMA", "DOT", "COLLATE", 
		"USING", "INDEX", "BETWEEN", "POLYPHONIC", "HAPPINESSINDEX", "SADNESSINDEX", 
		"POWERINDEX", "MAXMELODICREPREATINGFACTOR", "ID", "INT", "DOUBLE", "DATABASENAME", 
		"NEWLINE", "WS", "USER_VAR"
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
	public String getGrammarFileName() { return "Modulo7SQL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Modulo7SQLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class Select_clauseContext extends ParserRuleContext {
		public Select_keyContext select_key() {
			return getRuleContext(Select_keyContext.class,0);
		}
		public Input_list_clauseContext input_list_clause() {
			return getRuleContext(Input_list_clauseContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(Modulo7SQLParser.SEMI, 0); }
		public From_clauseContext from_clause() {
			return getRuleContext(From_clauseContext.class,0);
		}
		public Where_clauseContext where_clause() {
			return getRuleContext(Where_clauseContext.class,0);
		}
		public Preprocess_clauseContext preprocess_clause() {
			return getRuleContext(Preprocess_clauseContext.class,0);
		}
		public Select_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Modulo7SQLListener ) ((Modulo7SQLListener)listener).enterSelect_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Modulo7SQLListener ) ((Modulo7SQLListener)listener).exitSelect_clause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Modulo7SQLVisitor ) return ((Modulo7SQLVisitor<? extends T>)visitor).visitSelect_clause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Select_clauseContext select_clause() throws RecognitionException {
		Select_clauseContext _localctx = new Select_clauseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_select_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			select_key();
			setState(49);
			input_list_clause();
			setState(51);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(50);
				from_clause();
				}
			}

			setState(54);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(53);
				where_clause();
				}
			}

			setState(57);
			_la = _input.LA(1);
			if (_la==AND) {
				{
				setState(56);
				preprocess_clause();
				}
			}

			setState(59);
			match(SEMI);
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

	public static class Preprocess_clauseContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(Modulo7SQLParser.AND, 0); }
		public TerminalNode PREPROCESS() { return getToken(Modulo7SQLParser.PREPROCESS, 0); }
		public TerminalNode ON() { return getToken(Modulo7SQLParser.ON, 0); }
		public List<Preprocess_criteriaContext> preprocess_criteria() {
			return getRuleContexts(Preprocess_criteriaContext.class);
		}
		public Preprocess_criteriaContext preprocess_criteria(int i) {
			return getRuleContext(Preprocess_criteriaContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Modulo7SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Modulo7SQLParser.COMMA, i);
		}
		public Preprocess_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preprocess_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Modulo7SQLListener ) ((Modulo7SQLListener)listener).enterPreprocess_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Modulo7SQLListener ) ((Modulo7SQLListener)listener).exitPreprocess_clause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Modulo7SQLVisitor ) return ((Modulo7SQLVisitor<? extends T>)visitor).visitPreprocess_clause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Preprocess_clauseContext preprocess_clause() throws RecognitionException {
		Preprocess_clauseContext _localctx = new Preprocess_clauseContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_preprocess_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			match(AND);
			setState(62);
			match(PREPROCESS);
			setState(63);
			match(ON);
			setState(64);
			preprocess_criteria();
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(65);
				match(COMMA);
				setState(66);
				preprocess_criteria();
				}
				}
				setState(71);
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

	public static class Preprocess_criteriaContext extends ParserRuleContext {
		public TerminalNode NATURALCONTOUR() { return getToken(Modulo7SQLParser.NATURALCONTOUR, 0); }
		public TerminalNode STEINBECKCONTOUR() { return getToken(Modulo7SQLParser.STEINBECKCONTOUR, 0); }
		public TerminalNode MULLENFESTEINCONTOUR() { return getToken(Modulo7SQLParser.MULLENFESTEINCONTOUR, 0); }
		public Preprocess_criteriaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preprocess_criteria; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Modulo7SQLListener ) ((Modulo7SQLListener)listener).enterPreprocess_criteria(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Modulo7SQLListener ) ((Modulo7SQLListener)listener).exitPreprocess_criteria(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Modulo7SQLVisitor ) return ((Modulo7SQLVisitor<? extends T>)visitor).visitPreprocess_criteria(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Preprocess_criteriaContext preprocess_criteria() throws RecognitionException {
		Preprocess_criteriaContext _localctx = new Preprocess_criteriaContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_preprocess_criteria);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NATURALCONTOUR) | (1L << STEINBECKCONTOUR) | (1L << MULLENFESTEINCONTOUR))) != 0)) ) {
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

	public static class From_clauseContext extends ParserRuleContext {
		public TerminalNode FROM() { return getToken(Modulo7SQLParser.FROM, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public From_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_from_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Modulo7SQLListener ) ((Modulo7SQLListener)listener).enterFrom_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Modulo7SQLListener ) ((Modulo7SQLListener)listener).exitFrom_clause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Modulo7SQLVisitor ) return ((Modulo7SQLVisitor<? extends T>)visitor).visitFrom_clause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final From_clauseContext from_clause() throws RecognitionException {
		From_clauseContext _localctx = new From_clauseContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_from_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(FROM);
			setState(75);
			table_name();
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
		public TerminalNode ID() { return getToken(Modulo7SQLParser.ID, 0); }
		public Table_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Modulo7SQLListener ) ((Modulo7SQLListener)listener).enterTable_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Modulo7SQLListener ) ((Modulo7SQLListener)listener).exitTable_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Modulo7SQLVisitor ) return ((Modulo7SQLVisitor<? extends T>)visitor).visitTable_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Table_nameContext table_name() throws RecognitionException {
		Table_nameContext _localctx = new Table_nameContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_table_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
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
		public TerminalNode MIDI() { return getToken(Modulo7SQLParser.MIDI, 0); }
		public TerminalNode SHEET() { return getToken(Modulo7SQLParser.SHEET, 0); }
		public TerminalNode MP3() { return getToken(Modulo7SQLParser.MP3, 0); }
		public TerminalNode MUSICXML() { return getToken(Modulo7SQLParser.MUSICXML, 0); }
		public Input_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_input_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Modulo7SQLListener ) ((Modulo7SQLListener)listener).enterInput_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Modulo7SQLListener ) ((Modulo7SQLListener)listener).exitInput_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Modulo7SQLVisitor ) return ((Modulo7SQLVisitor<? extends T>)visitor).visitInput_name(this);
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
			setState(79);
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
		public TerminalNode ID() { return getToken(Modulo7SQLParser.ID, 0); }
		public Column_name_aliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_name_alias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Modulo7SQLListener ) ((Modulo7SQLListener)listener).enterColumn_name_alias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Modulo7SQLListener ) ((Modulo7SQLListener)listener).exitColumn_name_alias(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Modulo7SQLVisitor ) return ((Modulo7SQLVisitor<? extends T>)visitor).visitColumn_name_alias(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Column_name_aliasContext column_name_alias() throws RecognitionException {
		Column_name_aliasContext _localctx = new Column_name_aliasContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_column_name_alias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
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
		public TerminalNode ID() { return getToken(Modulo7SQLParser.ID, 0); }
		public Index_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_index_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Modulo7SQLListener ) ((Modulo7SQLListener)listener).enterIndex_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Modulo7SQLListener ) ((Modulo7SQLListener)listener).exitIndex_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Modulo7SQLVisitor ) return ((Modulo7SQLVisitor<? extends T>)visitor).visitIndex_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Index_nameContext index_name() throws RecognitionException {
		Index_nameContext _localctx = new Index_nameContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_index_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
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
		public List<TerminalNode> COMMA() { return getTokens(Modulo7SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Modulo7SQLParser.COMMA, i);
		}
		public Input_list_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_input_list_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Modulo7SQLListener ) ((Modulo7SQLListener)listener).enterInput_list_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Modulo7SQLListener ) ((Modulo7SQLListener)listener).exitInput_list_clause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Modulo7SQLVisitor ) return ((Modulo7SQLVisitor<? extends T>)visitor).visitInput_list_clause(this);
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
			setState(85);
			input_name();
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(86);
				match(COMMA);
				setState(87);
				input_name();
				}
				}
				setState(92);
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
		public TerminalNode SELECT() { return getToken(Modulo7SQLParser.SELECT, 0); }
		public Select_keyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_key; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Modulo7SQLListener ) ((Modulo7SQLListener)listener).enterSelect_key(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Modulo7SQLListener ) ((Modulo7SQLListener)listener).exitSelect_key(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Modulo7SQLVisitor ) return ((Modulo7SQLVisitor<? extends T>)visitor).visitSelect_key(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Select_keyContext select_key() throws RecognitionException {
		Select_keyContext _localctx = new Select_keyContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_select_key);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(SELECT);
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
		public TerminalNode WHERE() { return getToken(Modulo7SQLParser.WHERE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Where_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_where_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Modulo7SQLListener ) ((Modulo7SQLListener)listener).enterWhere_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Modulo7SQLListener ) ((Modulo7SQLListener)listener).exitWhere_clause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Modulo7SQLVisitor ) return ((Modulo7SQLVisitor<? extends T>)visitor).visitWhere_clause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Where_clauseContext where_clause() throws RecognitionException {
		Where_clauseContext _localctx = new Where_clauseContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_where_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(WHERE);
			setState(96);
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
			if ( listener instanceof Modulo7SQLListener ) ((Modulo7SQLListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Modulo7SQLListener ) ((Modulo7SQLListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Modulo7SQLVisitor ) return ((Modulo7SQLVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			simple_expression();
			setState(104);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(99);
					expr_op();
					setState(100);
					simple_expression();
					}
					} 
				}
				setState(106);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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
		public TerminalNode INT() { return getToken(Modulo7SQLParser.INT, 0); }
		public TerminalNode DOUBLE() { return getToken(Modulo7SQLParser.DOUBLE, 0); }
		public ElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Modulo7SQLListener ) ((Modulo7SQLListener)listener).enterElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Modulo7SQLListener ) ((Modulo7SQLListener)listener).exitElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Modulo7SQLVisitor ) return ((Modulo7SQLVisitor<? extends T>)visitor).visitElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementContext element() throws RecognitionException {
		ElementContext _localctx = new ElementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_element);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==DOUBLE) ) {
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
			if ( listener instanceof Modulo7SQLListener ) ((Modulo7SQLListener)listener).enterRight_element(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Modulo7SQLListener ) ((Modulo7SQLListener)listener).exitRight_element(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Modulo7SQLVisitor ) return ((Modulo7SQLVisitor<? extends T>)visitor).visitRight_element(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Right_elementContext right_element() throws RecognitionException {
		Right_elementContext _localctx = new Right_elementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_right_element);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
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
			if ( listener instanceof Modulo7SQLListener ) ((Modulo7SQLListener)listener).enterLeft_element(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Modulo7SQLListener ) ((Modulo7SQLListener)listener).exitLeft_element(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Modulo7SQLVisitor ) return ((Modulo7SQLVisitor<? extends T>)visitor).visitLeft_element(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Left_elementContext left_element() throws RecognitionException {
		Left_elementContext _localctx = new Left_elementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_left_element);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
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
			if ( listener instanceof Modulo7SQLListener ) ((Modulo7SQLListener)listener).enterTarget_element(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Modulo7SQLListener ) ((Modulo7SQLListener)listener).exitTarget_element(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Modulo7SQLVisitor ) return ((Modulo7SQLVisitor<? extends T>)visitor).visitTarget_element(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Target_elementContext target_element() throws RecognitionException {
		Target_elementContext _localctx = new Target_elementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_target_element);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
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
		public TerminalNode EQ() { return getToken(Modulo7SQLParser.EQ, 0); }
		public TerminalNode LTH() { return getToken(Modulo7SQLParser.LTH, 0); }
		public TerminalNode GTH() { return getToken(Modulo7SQLParser.GTH, 0); }
		public TerminalNode NOT_EQ() { return getToken(Modulo7SQLParser.NOT_EQ, 0); }
		public Relational_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relational_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Modulo7SQLListener ) ((Modulo7SQLListener)listener).enterRelational_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Modulo7SQLListener ) ((Modulo7SQLListener)listener).exitRelational_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Modulo7SQLVisitor ) return ((Modulo7SQLVisitor<? extends T>)visitor).visitRelational_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Relational_opContext relational_op() throws RecognitionException {
		Relational_opContext _localctx = new Relational_opContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_relational_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << LTH) | (1L << GTH) | (1L << NOT_EQ))) != 0)) ) {
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
		public TerminalNode AND() { return getToken(Modulo7SQLParser.AND, 0); }
		public TerminalNode OR() { return getToken(Modulo7SQLParser.OR, 0); }
		public TerminalNode NOT() { return getToken(Modulo7SQLParser.NOT, 0); }
		public Expr_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Modulo7SQLListener ) ((Modulo7SQLListener)listener).enterExpr_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Modulo7SQLListener ) ((Modulo7SQLListener)listener).exitExpr_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Modulo7SQLVisitor ) return ((Modulo7SQLVisitor<? extends T>)visitor).visitExpr_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_opContext expr_op() throws RecognitionException {
		Expr_opContext _localctx = new Expr_opContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_expr_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
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
		public TerminalNode BETWEEN() { return getToken(Modulo7SQLParser.BETWEEN, 0); }
		public Between_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_between_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Modulo7SQLListener ) ((Modulo7SQLListener)listener).enterBetween_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Modulo7SQLListener ) ((Modulo7SQLListener)listener).exitBetween_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Modulo7SQLVisitor ) return ((Modulo7SQLVisitor<? extends T>)visitor).visitBetween_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Between_opContext between_op() throws RecognitionException {
		Between_opContext _localctx = new Between_opContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_between_op);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
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
		public TerminalNode IS() { return getToken(Modulo7SQLParser.IS, 0); }
		public TerminalNode NOT() { return getToken(Modulo7SQLParser.NOT, 0); }
		public Is_or_is_notContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_is_or_is_not; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Modulo7SQLListener ) ((Modulo7SQLListener)listener).enterIs_or_is_not(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Modulo7SQLListener ) ((Modulo7SQLListener)listener).exitIs_or_is_not(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Modulo7SQLVisitor ) return ((Modulo7SQLVisitor<? extends T>)visitor).visitIs_or_is_not(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Is_or_is_notContext is_or_is_not() throws RecognitionException {
		Is_or_is_notContext _localctx = new Is_or_is_notContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_is_or_is_not);
		try {
			setState(124);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(121);
				match(IS);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(122);
				match(IS);
				setState(123);
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

	public static class Either_true_or_falseContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(Modulo7SQLParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(Modulo7SQLParser.FALSE, 0); }
		public Either_true_or_falseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_either_true_or_false; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Modulo7SQLListener ) ((Modulo7SQLListener)listener).enterEither_true_or_false(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Modulo7SQLListener ) ((Modulo7SQLListener)listener).exitEither_true_or_false(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Modulo7SQLVisitor ) return ((Modulo7SQLVisitor<? extends T>)visitor).visitEither_true_or_false(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Either_true_or_falseContext either_true_or_false() throws RecognitionException {
		Either_true_or_falseContext _localctx = new Either_true_or_falseContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_either_true_or_false);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
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

	public static class Simple_expressionContext extends ParserRuleContext {
		public CriteriaContext criteria() {
			return getRuleContext(CriteriaContext.class,0);
		}
		public Is_or_is_notContext is_or_is_not() {
			return getRuleContext(Is_or_is_notContext.class,0);
		}
		public Either_true_or_falseContext either_true_or_false() {
			return getRuleContext(Either_true_or_falseContext.class,0);
		}
		public StatisticContext statistic() {
			return getRuleContext(StatisticContext.class,0);
		}
		public Relational_opContext relational_op() {
			return getRuleContext(Relational_opContext.class,0);
		}
		public ElementContext element() {
			return getRuleContext(ElementContext.class,0);
		}
		public Between_opContext between_op() {
			return getRuleContext(Between_opContext.class,0);
		}
		public Left_elementContext left_element() {
			return getRuleContext(Left_elementContext.class,0);
		}
		public TerminalNode AND() { return getToken(Modulo7SQLParser.AND, 0); }
		public Right_elementContext right_element() {
			return getRuleContext(Right_elementContext.class,0);
		}
		public Simple_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Modulo7SQLListener ) ((Modulo7SQLListener)listener).enterSimple_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Modulo7SQLListener ) ((Modulo7SQLListener)listener).exitSimple_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Modulo7SQLVisitor ) return ((Modulo7SQLVisitor<? extends T>)visitor).visitSimple_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Simple_expressionContext simple_expression() throws RecognitionException {
		Simple_expressionContext _localctx = new Simple_expressionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_simple_expression);
		try {
			setState(142);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(128);
				criteria();
				setState(129);
				is_or_is_not();
				setState(130);
				either_true_or_false();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(132);
				statistic();
				setState(133);
				relational_op();
				setState(134);
				element();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(136);
				statistic();
				setState(137);
				between_op();
				setState(138);
				left_element();
				setState(139);
				match(AND);
				setState(140);
				right_element();
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

	public static class CriteriaContext extends ParserRuleContext {
		public TerminalNode POLYPHONIC() { return getToken(Modulo7SQLParser.POLYPHONIC, 0); }
		public CriteriaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_criteria; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Modulo7SQLListener ) ((Modulo7SQLListener)listener).enterCriteria(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Modulo7SQLListener ) ((Modulo7SQLListener)listener).exitCriteria(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Modulo7SQLVisitor ) return ((Modulo7SQLVisitor<? extends T>)visitor).visitCriteria(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CriteriaContext criteria() throws RecognitionException {
		CriteriaContext _localctx = new CriteriaContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_criteria);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(POLYPHONIC);
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

	public static class StatisticContext extends ParserRuleContext {
		public TerminalNode HAPPINESSINDEX() { return getToken(Modulo7SQLParser.HAPPINESSINDEX, 0); }
		public TerminalNode SADNESSINDEX() { return getToken(Modulo7SQLParser.SADNESSINDEX, 0); }
		public TerminalNode POWERINDEX() { return getToken(Modulo7SQLParser.POWERINDEX, 0); }
		public TerminalNode MAXMELODICREPREATINGFACTOR() { return getToken(Modulo7SQLParser.MAXMELODICREPREATINGFACTOR, 0); }
		public StatisticContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statistic; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Modulo7SQLListener ) ((Modulo7SQLListener)listener).enterStatistic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Modulo7SQLListener ) ((Modulo7SQLListener)listener).exitStatistic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Modulo7SQLVisitor ) return ((Modulo7SQLVisitor<? extends T>)visitor).visitStatistic(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatisticContext statistic() throws RecognitionException {
		StatisticContext _localctx = new StatisticContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_statistic);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << HAPPINESSINDEX) | (1L << SADNESSINDEX) | (1L << POWERINDEX) | (1L << MAXMELODICREPREATINGFACTOR))) != 0)) ) {
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3@\u0097\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\3\2\3\2\3\2\5\2\66\n\2\3\2\5\29\n\2\3\2\5\2<\n\2\3\2\3\2\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\7\3F\n\3\f\3\16\3I\13\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\7\3"+
		"\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\7\n[\n\n\f\n\16\n^\13\n\3\13\3\13\3\f\3"+
		"\f\3\f\3\r\3\r\3\r\3\r\7\ri\n\r\f\r\16\rl\13\r\3\16\3\16\3\17\3\17\3\20"+
		"\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\5\25\177"+
		"\n\25\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\5\27\u0091\n\27\3\30\3\30\3\31\3\31\3\31\2\2\32\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\2\t\3\2\t\13\3\2\4\7\3\2"+
		";<\3\2\'*\4\2\17\20++\3\2\24\25\3\2\669\u0087\2\62\3\2\2\2\4?\3\2\2\2"+
		"\6J\3\2\2\2\bL\3\2\2\2\nO\3\2\2\2\fQ\3\2\2\2\16S\3\2\2\2\20U\3\2\2\2\22"+
		"W\3\2\2\2\24_\3\2\2\2\26a\3\2\2\2\30d\3\2\2\2\32m\3\2\2\2\34o\3\2\2\2"+
		"\36q\3\2\2\2 s\3\2\2\2\"u\3\2\2\2$w\3\2\2\2&y\3\2\2\2(~\3\2\2\2*\u0080"+
		"\3\2\2\2,\u0090\3\2\2\2.\u0092\3\2\2\2\60\u0094\3\2\2\2\62\63\5\24\13"+
		"\2\63\65\5\22\n\2\64\66\5\b\5\2\65\64\3\2\2\2\65\66\3\2\2\2\668\3\2\2"+
		"\2\679\5\26\f\28\67\3\2\2\289\3\2\2\29;\3\2\2\2:<\5\4\3\2;:\3\2\2\2;<"+
		"\3\2\2\2<=\3\2\2\2=>\7.\2\2>\3\3\2\2\2?@\7\17\2\2@A\7\b\2\2AB\7\f\2\2"+
		"BG\5\6\4\2CD\7/\2\2DF\5\6\4\2EC\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2"+
		"H\5\3\2\2\2IG\3\2\2\2JK\t\2\2\2K\7\3\2\2\2LM\7\r\2\2MN\5\n\6\2N\t\3\2"+
		"\2\2OP\7:\2\2P\13\3\2\2\2QR\t\3\2\2R\r\3\2\2\2ST\7:\2\2T\17\3\2\2\2UV"+
		"\7:\2\2V\21\3\2\2\2W\\\5\f\7\2XY\7/\2\2Y[\5\f\7\2ZX\3\2\2\2[^\3\2\2\2"+
		"\\Z\3\2\2\2\\]\3\2\2\2]\23\3\2\2\2^\\\3\2\2\2_`\7\3\2\2`\25\3\2\2\2ab"+
		"\7\16\2\2bc\5\30\r\2c\27\3\2\2\2dj\5,\27\2ef\5$\23\2fg\5,\27\2gi\3\2\2"+
		"\2he\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2k\31\3\2\2\2lj\3\2\2\2mn\t\4"+
		"\2\2n\33\3\2\2\2op\5\32\16\2p\35\3\2\2\2qr\5\32\16\2r\37\3\2\2\2st\5\32"+
		"\16\2t!\3\2\2\2uv\t\5\2\2v#\3\2\2\2wx\t\6\2\2x%\3\2\2\2yz\7\64\2\2z\'"+
		"\3\2\2\2{\177\7\21\2\2|}\7\21\2\2}\177\7+\2\2~{\3\2\2\2~|\3\2\2\2\177"+
		")\3\2\2\2\u0080\u0081\t\7\2\2\u0081+\3\2\2\2\u0082\u0083\5.\30\2\u0083"+
		"\u0084\5(\25\2\u0084\u0085\5*\26\2\u0085\u0091\3\2\2\2\u0086\u0087\5\60"+
		"\31\2\u0087\u0088\5\"\22\2\u0088\u0089\5\32\16\2\u0089\u0091\3\2\2\2\u008a"+
		"\u008b\5\60\31\2\u008b\u008c\5&\24\2\u008c\u008d\5\36\20\2\u008d\u008e"+
		"\7\17\2\2\u008e\u008f\5\34\17\2\u008f\u0091\3\2\2\2\u0090\u0082\3\2\2"+
		"\2\u0090\u0086\3\2\2\2\u0090\u008a\3\2\2\2\u0091-\3\2\2\2\u0092\u0093"+
		"\7\65\2\2\u0093/\3\2\2\2\u0094\u0095\t\b\2\2\u0095\61\3\2\2\2\n\658;G"+
		"\\j~\u0090";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}