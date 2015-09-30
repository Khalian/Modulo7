// Generated from /home/asanyal/git_projects/Modulo7/src/main/antlr/Modulo7SQLBase.g4 by ANTLR 4.5.1

    package  com.modulo7.modulo7SQL;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Modulo7SQLBase extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SELECT=1, MIDI=2, SHEET=3, MP3=4, MUSICXML=5, FROM=6, WHERE=7, AND=8, 
		OR=9, IS=10, NULL=11, IN=12, TRUE=13, FALSE=14, DIVIDE=15, MOD=16, PLUS=17, 
		MINUS=18, NEGATION=19, VERTBAR=20, BITAND=21, POWER_OP=22, BINARY=23, 
		ESCAPE=24, ASTERISK=25, RPAREN=26, LPAREN=27, RBRACK=28, LBRACK=29, COLON=30, 
		ALL_FIELDS=31, EQ=32, LTH=33, GTH=34, NOT_EQ=35, NOT=36, LET=37, GET=38, 
		SEMI=39, COMMA=40, DOT=41, COLLATE=42, USING=43, INDEX=44, BETWEEN=45, 
		POLYPHONIC=46, HAPPINESSINDEX=47, SADNESSINDEX=48, POWERINDEX=49, MAXMELODICREPREATINGFACTOR=50, 
		ID=51, INT=52, DOUBLE=53, DATABASENAME=54, NEWLINE=55, WS=56, USER_VAR=57;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"SELECT", "MIDI", "SHEET", "MP3", "MUSICXML", "FROM", "WHERE", "AND", 
		"OR", "IS", "NULL", "IN", "TRUE", "FALSE", "DIVIDE", "MOD", "PLUS", "MINUS", 
		"NEGATION", "VERTBAR", "BITAND", "POWER_OP", "BINARY", "ESCAPE", "ASTERISK", 
		"RPAREN", "LPAREN", "RBRACK", "LBRACK", "COLON", "ALL_FIELDS", "EQ", "LTH", 
		"GTH", "NOT_EQ", "NOT", "LET", "GET", "SEMI", "COMMA", "DOT", "COLLATE", 
		"USING", "INDEX", "BETWEEN", "POLYPHONIC", "HAPPINESSINDEX", "SADNESSINDEX", 
		"POWERINDEX", "MAXMELODICREPREATINGFACTOR", "ID", "INT", "DOUBLE", "DATABASENAME", 
		"NEWLINE", "WS", "USER_VAR", "USER_VAR_SUBFIX1", "USER_VAR_SUBFIX2", "USER_VAR_SUBFIX3", 
		"USER_VAR_SUBFIX4"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'select'", "'midi'", "'sheet'", "'mp3'", "'musicxml'", "'from'", 
		"'where'", null, null, "'is'", "'null'", "'in'", "'true'", "'false'", 
		null, null, "'+'", "'-'", "'~'", "'|'", "'&'", "'^'", "'binary'", "'escape'", 
		"'*'", "')'", "'('", "']'", "'['", "':'", "'.*'", "'='", "'<'", "'>'", 
		"'!='", "'not'", "'<='", "'>='", "';'", "','", "'.'", "'collate'", "'using'", 
		"'index'", "'between'", "'polyphonic'", "'happinessindex'", "'sadnessindex'", 
		"'powerindex'", "'maxmelodicrepeatingfactor'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "SELECT", "MIDI", "SHEET", "MP3", "MUSICXML", "FROM", "WHERE", "AND", 
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


	public Modulo7SQLBase(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Modulo7SQLBase.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2;\u01cd\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3"+
		"\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\5\t\u00ad\n\t\3"+
		"\n\3\n\3\n\3\n\5\n\u00b3\n\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3"+
		"\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20"+
		"\3\20\3\20\5\20\u00cf\n\20\3\21\3\21\3\21\3\21\5\21\u00d5\n\21\3\22\3"+
		"\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\33\3"+
		"\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3 \3!\3!\3\"\3\"\3#"+
		"\3#\3$\3$\3$\3%\3%\3%\3%\3&\3&\3&\3\'\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+"+
		"\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-\3-\3.\3.\3.\3.\3."+
		"\3.\3.\3.\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3"+
		"\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3"+
		"\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3"+
		"\62\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3"+
		"\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3"+
		"\63\3\63\3\63\3\63\3\64\6\64\u0182\n\64\r\64\16\64\u0183\3\65\6\65\u0187"+
		"\n\65\r\65\16\65\u0188\3\66\6\66\u018c\n\66\r\66\16\66\u018d\3\66\3\66"+
		"\6\66\u0192\n\66\r\66\16\66\u0193\3\67\6\67\u0197\n\67\r\67\16\67\u0198"+
		"\38\58\u019c\n8\38\38\38\38\39\69\u01a3\n9\r9\169\u01a4\39\39\3:\3:\3"+
		":\3:\3:\5:\u01ae\n:\3;\3;\6;\u01b2\n;\r;\16;\u01b3\3;\3;\3<\3<\6<\u01ba"+
		"\n<\r<\16<\u01bb\3<\3<\3=\3=\6=\u01c2\n=\r=\16=\u01c3\3=\3=\3>\3>\6>\u01ca"+
		"\n>\r>\16>\u01cb\2\2?\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
		"\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63"+
		"e\64g\65i\66k\67m8o9q:s;u\2w\2y\2{\2\3\2\b\5\2C\\aac|\5\2\13\f\17\17\""+
		"\"\3\2bb\3\2))\3\2$$\7\2&&\62;C\\aac|\u01db\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2"+
		"\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2"+
		"\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2"+
		"M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3"+
		"\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2"+
		"\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2"+
		"s\3\2\2\2\3}\3\2\2\2\5\u0084\3\2\2\2\7\u0089\3\2\2\2\t\u008f\3\2\2\2\13"+
		"\u0093\3\2\2\2\r\u009c\3\2\2\2\17\u00a1\3\2\2\2\21\u00ac\3\2\2\2\23\u00b2"+
		"\3\2\2\2\25\u00b4\3\2\2\2\27\u00b7\3\2\2\2\31\u00bc\3\2\2\2\33\u00bf\3"+
		"\2\2\2\35\u00c4\3\2\2\2\37\u00ce\3\2\2\2!\u00d4\3\2\2\2#\u00d6\3\2\2\2"+
		"%\u00d8\3\2\2\2\'\u00da\3\2\2\2)\u00dc\3\2\2\2+\u00de\3\2\2\2-\u00e0\3"+
		"\2\2\2/\u00e2\3\2\2\2\61\u00e9\3\2\2\2\63\u00f0\3\2\2\2\65\u00f2\3\2\2"+
		"\2\67\u00f4\3\2\2\29\u00f6\3\2\2\2;\u00f8\3\2\2\2=\u00fa\3\2\2\2?\u00fc"+
		"\3\2\2\2A\u00ff\3\2\2\2C\u0101\3\2\2\2E\u0103\3\2\2\2G\u0105\3\2\2\2I"+
		"\u0108\3\2\2\2K\u010c\3\2\2\2M\u010f\3\2\2\2O\u0112\3\2\2\2Q\u0114\3\2"+
		"\2\2S\u0116\3\2\2\2U\u0118\3\2\2\2W\u0120\3\2\2\2Y\u0126\3\2\2\2[\u012c"+
		"\3\2\2\2]\u0134\3\2\2\2_\u013f\3\2\2\2a\u014e\3\2\2\2c\u015b\3\2\2\2e"+
		"\u0166\3\2\2\2g\u0181\3\2\2\2i\u0186\3\2\2\2k\u018b\3\2\2\2m\u0196\3\2"+
		"\2\2o\u019b\3\2\2\2q\u01a2\3\2\2\2s\u01a8\3\2\2\2u\u01af\3\2\2\2w\u01b7"+
		"\3\2\2\2y\u01bf\3\2\2\2{\u01c9\3\2\2\2}~\7u\2\2~\177\7g\2\2\177\u0080"+
		"\7n\2\2\u0080\u0081\7g\2\2\u0081\u0082\7e\2\2\u0082\u0083\7v\2\2\u0083"+
		"\4\3\2\2\2\u0084\u0085\7o\2\2\u0085\u0086\7k\2\2\u0086\u0087\7f\2\2\u0087"+
		"\u0088\7k\2\2\u0088\6\3\2\2\2\u0089\u008a\7u\2\2\u008a\u008b\7j\2\2\u008b"+
		"\u008c\7g\2\2\u008c\u008d\7g\2\2\u008d\u008e\7v\2\2\u008e\b\3\2\2\2\u008f"+
		"\u0090\7o\2\2\u0090\u0091\7r\2\2\u0091\u0092\7\65\2\2\u0092\n\3\2\2\2"+
		"\u0093\u0094\7o\2\2\u0094\u0095\7w\2\2\u0095\u0096\7u\2\2\u0096\u0097"+
		"\7k\2\2\u0097\u0098\7e\2\2\u0098\u0099\7z\2\2\u0099\u009a\7o\2\2\u009a"+
		"\u009b\7n\2\2\u009b\f\3\2\2\2\u009c\u009d\7h\2\2\u009d\u009e\7t\2\2\u009e"+
		"\u009f\7q\2\2\u009f\u00a0\7o\2\2\u00a0\16\3\2\2\2\u00a1\u00a2\7y\2\2\u00a2"+
		"\u00a3\7j\2\2\u00a3\u00a4\7g\2\2\u00a4\u00a5\7t\2\2\u00a5\u00a6\7g\2\2"+
		"\u00a6\20\3\2\2\2\u00a7\u00a8\7c\2\2\u00a8\u00a9\7p\2\2\u00a9\u00ad\7"+
		"f\2\2\u00aa\u00ab\7(\2\2\u00ab\u00ad\7(\2\2\u00ac\u00a7\3\2\2\2\u00ac"+
		"\u00aa\3\2\2\2\u00ad\22\3\2\2\2\u00ae\u00af\7q\2\2\u00af\u00b3\7t\2\2"+
		"\u00b0\u00b1\7~\2\2\u00b1\u00b3\7~\2\2\u00b2\u00ae\3\2\2\2\u00b2\u00b0"+
		"\3\2\2\2\u00b3\24\3\2\2\2\u00b4\u00b5\7k\2\2\u00b5\u00b6\7u\2\2\u00b6"+
		"\26\3\2\2\2\u00b7\u00b8\7p\2\2\u00b8\u00b9\7w\2\2\u00b9\u00ba\7n\2\2\u00ba"+
		"\u00bb\7n\2\2\u00bb\30\3\2\2\2\u00bc\u00bd\7k\2\2\u00bd\u00be\7p\2\2\u00be"+
		"\32\3\2\2\2\u00bf\u00c0\7v\2\2\u00c0\u00c1\7t\2\2\u00c1\u00c2\7w\2\2\u00c2"+
		"\u00c3\7g\2\2\u00c3\34\3\2\2\2\u00c4\u00c5\7h\2\2\u00c5\u00c6\7c\2\2\u00c6"+
		"\u00c7\7n\2\2\u00c7\u00c8\7u\2\2\u00c8\u00c9\7g\2\2\u00c9\36\3\2\2\2\u00ca"+
		"\u00cb\7f\2\2\u00cb\u00cc\7k\2\2\u00cc\u00cf\7x\2\2\u00cd\u00cf\7\61\2"+
		"\2\u00ce\u00ca\3\2\2\2\u00ce\u00cd\3\2\2\2\u00cf \3\2\2\2\u00d0\u00d1"+
		"\7o\2\2\u00d1\u00d2\7q\2\2\u00d2\u00d5\7f\2\2\u00d3\u00d5\7\'\2\2\u00d4"+
		"\u00d0\3\2\2\2\u00d4\u00d3\3\2\2\2\u00d5\"\3\2\2\2\u00d6\u00d7\7-\2\2"+
		"\u00d7$\3\2\2\2\u00d8\u00d9\7/\2\2\u00d9&\3\2\2\2\u00da\u00db\7\u0080"+
		"\2\2\u00db(\3\2\2\2\u00dc\u00dd\7~\2\2\u00dd*\3\2\2\2\u00de\u00df\7(\2"+
		"\2\u00df,\3\2\2\2\u00e0\u00e1\7`\2\2\u00e1.\3\2\2\2\u00e2\u00e3\7d\2\2"+
		"\u00e3\u00e4\7k\2\2\u00e4\u00e5\7p\2\2\u00e5\u00e6\7c\2\2\u00e6\u00e7"+
		"\7t\2\2\u00e7\u00e8\7{\2\2\u00e8\60\3\2\2\2\u00e9\u00ea\7g\2\2\u00ea\u00eb"+
		"\7u\2\2\u00eb\u00ec\7e\2\2\u00ec\u00ed\7c\2\2\u00ed\u00ee\7r\2\2\u00ee"+
		"\u00ef\7g\2\2\u00ef\62\3\2\2\2\u00f0\u00f1\7,\2\2\u00f1\64\3\2\2\2\u00f2"+
		"\u00f3\7+\2\2\u00f3\66\3\2\2\2\u00f4\u00f5\7*\2\2\u00f58\3\2\2\2\u00f6"+
		"\u00f7\7_\2\2\u00f7:\3\2\2\2\u00f8\u00f9\7]\2\2\u00f9<\3\2\2\2\u00fa\u00fb"+
		"\7<\2\2\u00fb>\3\2\2\2\u00fc\u00fd\7\60\2\2\u00fd\u00fe\7,\2\2\u00fe@"+
		"\3\2\2\2\u00ff\u0100\7?\2\2\u0100B\3\2\2\2\u0101\u0102\7>\2\2\u0102D\3"+
		"\2\2\2\u0103\u0104\7@\2\2\u0104F\3\2\2\2\u0105\u0106\7#\2\2\u0106\u0107"+
		"\7?\2\2\u0107H\3\2\2\2\u0108\u0109\7p\2\2\u0109\u010a\7q\2\2\u010a\u010b"+
		"\7v\2\2\u010bJ\3\2\2\2\u010c\u010d\7>\2\2\u010d\u010e\7?\2\2\u010eL\3"+
		"\2\2\2\u010f\u0110\7@\2\2\u0110\u0111\7?\2\2\u0111N\3\2\2\2\u0112\u0113"+
		"\7=\2\2\u0113P\3\2\2\2\u0114\u0115\7.\2\2\u0115R\3\2\2\2\u0116\u0117\7"+
		"\60\2\2\u0117T\3\2\2\2\u0118\u0119\7e\2\2\u0119\u011a\7q\2\2\u011a\u011b"+
		"\7n\2\2\u011b\u011c\7n\2\2\u011c\u011d\7c\2\2\u011d\u011e\7v\2\2\u011e"+
		"\u011f\7g\2\2\u011fV\3\2\2\2\u0120\u0121\7w\2\2\u0121\u0122\7u\2\2\u0122"+
		"\u0123\7k\2\2\u0123\u0124\7p\2\2\u0124\u0125\7i\2\2\u0125X\3\2\2\2\u0126"+
		"\u0127\7k\2\2\u0127\u0128\7p\2\2\u0128\u0129\7f\2\2\u0129\u012a\7g\2\2"+
		"\u012a\u012b\7z\2\2\u012bZ\3\2\2\2\u012c\u012d\7d\2\2\u012d\u012e\7g\2"+
		"\2\u012e\u012f\7v\2\2\u012f\u0130\7y\2\2\u0130\u0131\7g\2\2\u0131\u0132"+
		"\7g\2\2\u0132\u0133\7p\2\2\u0133\\\3\2\2\2\u0134\u0135\7r\2\2\u0135\u0136"+
		"\7q\2\2\u0136\u0137\7n\2\2\u0137\u0138\7{\2\2\u0138\u0139\7r\2\2\u0139"+
		"\u013a\7j\2\2\u013a\u013b\7q\2\2\u013b\u013c\7p\2\2\u013c\u013d\7k\2\2"+
		"\u013d\u013e\7e\2\2\u013e^\3\2\2\2\u013f\u0140\7j\2\2\u0140\u0141\7c\2"+
		"\2\u0141\u0142\7r\2\2\u0142\u0143\7r\2\2\u0143\u0144\7k\2\2\u0144\u0145"+
		"\7p\2\2\u0145\u0146\7g\2\2\u0146\u0147\7u\2\2\u0147\u0148\7u\2\2\u0148"+
		"\u0149\7k\2\2\u0149\u014a\7p\2\2\u014a\u014b\7f\2\2\u014b\u014c\7g\2\2"+
		"\u014c\u014d\7z\2\2\u014d`\3\2\2\2\u014e\u014f\7u\2\2\u014f\u0150\7c\2"+
		"\2\u0150\u0151\7f\2\2\u0151\u0152\7p\2\2\u0152\u0153\7g\2\2\u0153\u0154"+
		"\7u\2\2\u0154\u0155\7u\2\2\u0155\u0156\7k\2\2\u0156\u0157\7p\2\2\u0157"+
		"\u0158\7f\2\2\u0158\u0159\7g\2\2\u0159\u015a\7z\2\2\u015ab\3\2\2\2\u015b"+
		"\u015c\7r\2\2\u015c\u015d\7q\2\2\u015d\u015e\7y\2\2\u015e\u015f\7g\2\2"+
		"\u015f\u0160\7t\2\2\u0160\u0161\7k\2\2\u0161\u0162\7p\2\2\u0162\u0163"+
		"\7f\2\2\u0163\u0164\7g\2\2\u0164\u0165\7z\2\2\u0165d\3\2\2\2\u0166\u0167"+
		"\7o\2\2\u0167\u0168\7c\2\2\u0168\u0169\7z\2\2\u0169\u016a\7o\2\2\u016a"+
		"\u016b\7g\2\2\u016b\u016c\7n\2\2\u016c\u016d\7q\2\2\u016d\u016e\7f\2\2"+
		"\u016e\u016f\7k\2\2\u016f\u0170\7e\2\2\u0170\u0171\7t\2\2\u0171\u0172"+
		"\7g\2\2\u0172\u0173\7r\2\2\u0173\u0174\7g\2\2\u0174\u0175\7c\2\2\u0175"+
		"\u0176\7v\2\2\u0176\u0177\7k\2\2\u0177\u0178\7p\2\2\u0178\u0179\7i\2\2"+
		"\u0179\u017a\7h\2\2\u017a\u017b\7c\2\2\u017b\u017c\7e\2\2\u017c\u017d"+
		"\7v\2\2\u017d\u017e\7q\2\2\u017e\u017f\7t\2\2\u017ff\3\2\2\2\u0180\u0182"+
		"\t\2\2\2\u0181\u0180\3\2\2\2\u0182\u0183\3\2\2\2\u0183\u0181\3\2\2\2\u0183"+
		"\u0184\3\2\2\2\u0184h\3\2\2\2\u0185\u0187\4\62;\2\u0186\u0185\3\2\2\2"+
		"\u0187\u0188\3\2\2\2\u0188\u0186\3\2\2\2\u0188\u0189\3\2\2\2\u0189j\3"+
		"\2\2\2\u018a\u018c\4\62;\2\u018b\u018a\3\2\2\2\u018c\u018d\3\2\2\2\u018d"+
		"\u018b\3\2\2\2\u018d\u018e\3\2\2\2\u018e\u018f\3\2\2\2\u018f\u0191\7\60"+
		"\2\2\u0190\u0192\4\62;\2\u0191\u0190\3\2\2\2\u0192\u0193\3\2\2\2\u0193"+
		"\u0191\3\2\2\2\u0193\u0194\3\2\2\2\u0194l\3\2\2\2\u0195\u0197\t\2\2\2"+
		"\u0196\u0195\3\2\2\2\u0197\u0198\3\2\2\2\u0198\u0196\3\2\2\2\u0198\u0199"+
		"\3\2\2\2\u0199n\3\2\2\2\u019a\u019c\7\17\2\2\u019b\u019a\3\2\2\2\u019b"+
		"\u019c\3\2\2\2\u019c\u019d\3\2\2\2\u019d\u019e\7\f\2\2\u019e\u019f\3\2"+
		"\2\2\u019f\u01a0\b8\2\2\u01a0p\3\2\2\2\u01a1\u01a3\t\3\2\2\u01a2\u01a1"+
		"\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4\u01a2\3\2\2\2\u01a4\u01a5\3\2\2\2\u01a5"+
		"\u01a6\3\2\2\2\u01a6\u01a7\b9\2\2\u01a7r\3\2\2\2\u01a8\u01ad\7B\2\2\u01a9"+
		"\u01ae\5u;\2\u01aa\u01ae\5w<\2\u01ab\u01ae\5y=\2\u01ac\u01ae\5{>\2\u01ad"+
		"\u01a9\3\2\2\2\u01ad\u01aa\3\2\2\2\u01ad\u01ab\3\2\2\2\u01ad\u01ac\3\2"+
		"\2\2\u01aet\3\2\2\2\u01af\u01b1\7b\2\2\u01b0\u01b2\n\4\2\2\u01b1\u01b0"+
		"\3\2\2\2\u01b2\u01b3\3\2\2\2\u01b3\u01b1\3\2\2\2\u01b3\u01b4\3\2\2\2\u01b4"+
		"\u01b5\3\2\2\2\u01b5\u01b6\7b\2\2\u01b6v\3\2\2\2\u01b7\u01b9\7)\2\2\u01b8"+
		"\u01ba\n\5\2\2\u01b9\u01b8\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01b9\3\2"+
		"\2\2\u01bb\u01bc\3\2\2\2\u01bc\u01bd\3\2\2\2\u01bd\u01be\7)\2\2\u01be"+
		"x\3\2\2\2\u01bf\u01c1\7$\2\2\u01c0\u01c2\n\6\2\2\u01c1\u01c0\3\2\2\2\u01c2"+
		"\u01c3\3\2\2\2\u01c3\u01c1\3\2\2\2\u01c3\u01c4\3\2\2\2\u01c4\u01c5\3\2"+
		"\2\2\u01c5\u01c6\7$\2\2\u01c6z\3\2\2\2\u01c7\u01ca\t\7\2\2\u01c8\u01ca"+
		"\5S*\2\u01c9\u01c7\3\2\2\2\u01c9\u01c8\3\2\2\2\u01ca\u01cb\3\2\2\2\u01cb"+
		"\u01c9\3\2\2\2\u01cb\u01cc\3\2\2\2\u01cc|\3\2\2\2\24\2\u00ac\u00b2\u00ce"+
		"\u00d4\u0183\u0188\u018d\u0193\u0198\u019b\u01a4\u01ad\u01b3\u01bb\u01c3"+
		"\u01c9\u01cb\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}