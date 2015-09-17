// Generated from /home/asanyal/git_projects/Modulo7/src/main/antlr/modulo7SQLBase.g4 by ANTLR 4.5.1

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
public class modulo7SQLBase extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SELECT=1, MIDI=2, SHEET=3, MP3=4, MUSICXML=5, FROM=6, WHERE=7, AND=8, 
		OR=9, IS=10, NULL=11, LIKE=12, IN=13, EXISTS=14, ALL=15, ANY=16, TRUE=17, 
		FALSE=18, DIVIDE=19, MOD=20, BETWEEN=21, REGEXP=22, PLUS=23, MINUS=24, 
		NEGATION=25, VERTBAR=26, BITAND=27, POWER_OP=28, BINARY=29, ESCAPE=30, 
		ASTERISK=31, RPAREN=32, LPAREN=33, RBRACK=34, LBRACK=35, COLON=36, ALL_FIELDS=37, 
		EQ=38, LTH=39, GTH=40, NOT_EQ=41, NOT=42, LET=43, GET=44, SEMI=45, COMMA=46, 
		DOT=47, COLLATE=48, INNER=49, OUTER=50, CROSS=51, USING=52, INDEX=53, 
		KEY=54, ORDER=55, GROUP=56, BY=57, FOR=58, USE=59, IGNORE=60, PARTITION=61, 
		OJ=62, ON=63, ID=64, INT=65, NEWLINE=66, WS=67, USER_VAR=68;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"SELECT", "MIDI", "SHEET", "MP3", "MUSICXML", "FROM", "WHERE", "AND", 
		"OR", "IS", "NULL", "LIKE", "IN", "EXISTS", "ALL", "ANY", "TRUE", "FALSE", 
		"DIVIDE", "MOD", "BETWEEN", "REGEXP", "PLUS", "MINUS", "NEGATION", "VERTBAR", 
		"BITAND", "POWER_OP", "BINARY", "ESCAPE", "ASTERISK", "RPAREN", "LPAREN", 
		"RBRACK", "LBRACK", "COLON", "ALL_FIELDS", "EQ", "LTH", "GTH", "NOT_EQ", 
		"NOT", "LET", "GET", "SEMI", "COMMA", "DOT", "COLLATE", "INNER", "OUTER", 
		"CROSS", "USING", "INDEX", "KEY", "ORDER", "GROUP", "BY", "FOR", "USE", 
		"IGNORE", "PARTITION", "OJ", "ON", "ID", "INT", "NEWLINE", "WS", "USER_VAR", 
		"USER_VAR_SUBFIX1", "USER_VAR_SUBFIX2", "USER_VAR_SUBFIX3", "USER_VAR_SUBFIX4"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'select'", "'midi'", "'sheet'", "'mp3'", "'musicxml'", "'from'", 
		"'where'", null, null, "'is'", "'null'", "'like'", "'in'", "'exists'", 
		"'all'", "'any'", "'true'", "'false'", null, null, "'between'", "'regexp'", 
		"'+'", "'-'", "'~'", "'|'", "'&'", "'^'", "'binary'", "'escape'", "'*'", 
		"')'", "'('", "']'", "'['", "':'", "'.*'", "'='", "'<'", "'>'", "'!='", 
		"'not'", "'<='", "'>='", "';'", "','", "'.'", "'collate'", "'inner'", 
		"'outer'", "'cross'", "'using'", "'index'", "'key'", "'order'", "'group'", 
		"'by'", "'for'", "'use'", "'ignore'", "'partition'", "'oj'", "'on'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "SELECT", "MIDI", "SHEET", "MP3", "MUSICXML", "FROM", "WHERE", "AND", 
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


	public modulo7SQLBase(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "modulo7SQLBase.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2F\u01e6\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7"+
		"\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\5\t\u00c3\n\t\3\n"+
		"\3\n\3\n\3\n\5\n\u00c9\n\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r"+
		"\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3"+
		"\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\5\24\u00f9\n\24\3\25\3\25\3\25"+
		"\3\25\5\25\u00ff\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34"+
		"\3\34\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3&\3\'\3\'"+
		"\3(\3(\3)\3)\3*\3*\3*\3+\3+\3+\3+\3,\3,\3,\3-\3-\3-\3.\3.\3/\3/\3\60\3"+
		"\60\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3"+
		"\62\3\63\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\3\65\3"+
		"\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3"+
		"\67\38\38\38\38\38\38\39\39\39\39\39\39\3:\3:\3:\3;\3;\3;\3;\3<\3<\3<"+
		"\3<\3=\3=\3=\3=\3=\3=\3=\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3?\3?\3?\3@\3@"+
		"\3@\3A\6A\u01ab\nA\rA\16A\u01ac\3B\6B\u01b0\nB\rB\16B\u01b1\3C\5C\u01b5"+
		"\nC\3C\3C\3C\3C\3D\6D\u01bc\nD\rD\16D\u01bd\3D\3D\3E\3E\3E\3E\3E\5E\u01c7"+
		"\nE\3F\3F\6F\u01cb\nF\rF\16F\u01cc\3F\3F\3G\3G\6G\u01d3\nG\rG\16G\u01d4"+
		"\3G\3G\3H\3H\6H\u01db\nH\rH\16H\u01dc\3H\3H\3I\3I\6I\u01e3\nI\rI\16I\u01e4"+
		"\2\2J\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67"+
		"m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083C\u0085D\u0087E\u0089F\u008b\2\u008d"+
		"\2\u008f\2\u0091\2\3\2\b\5\2C\\aac|\5\2\13\f\17\17\"\"\3\2bb\3\2))\3\2"+
		"$$\7\2&&\62;C\\aac|\u01f1\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3"+
		"\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2"+
		"\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67"+
		"\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2"+
		"\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2"+
		"\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]"+
		"\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2"+
		"\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2"+
		"\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2"+
		"\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\3"+
		"\u0093\3\2\2\2\5\u009a\3\2\2\2\7\u009f\3\2\2\2\t\u00a5\3\2\2\2\13\u00a9"+
		"\3\2\2\2\r\u00b2\3\2\2\2\17\u00b7\3\2\2\2\21\u00c2\3\2\2\2\23\u00c8\3"+
		"\2\2\2\25\u00ca\3\2\2\2\27\u00cd\3\2\2\2\31\u00d2\3\2\2\2\33\u00d7\3\2"+
		"\2\2\35\u00da\3\2\2\2\37\u00e1\3\2\2\2!\u00e5\3\2\2\2#\u00e9\3\2\2\2%"+
		"\u00ee\3\2\2\2\'\u00f8\3\2\2\2)\u00fe\3\2\2\2+\u0100\3\2\2\2-\u0108\3"+
		"\2\2\2/\u010f\3\2\2\2\61\u0111\3\2\2\2\63\u0113\3\2\2\2\65\u0115\3\2\2"+
		"\2\67\u0117\3\2\2\29\u0119\3\2\2\2;\u011b\3\2\2\2=\u0122\3\2\2\2?\u0129"+
		"\3\2\2\2A\u012b\3\2\2\2C\u012d\3\2\2\2E\u012f\3\2\2\2G\u0131\3\2\2\2I"+
		"\u0133\3\2\2\2K\u0135\3\2\2\2M\u0138\3\2\2\2O\u013a\3\2\2\2Q\u013c\3\2"+
		"\2\2S\u013e\3\2\2\2U\u0141\3\2\2\2W\u0145\3\2\2\2Y\u0148\3\2\2\2[\u014b"+
		"\3\2\2\2]\u014d\3\2\2\2_\u014f\3\2\2\2a\u0151\3\2\2\2c\u0159\3\2\2\2e"+
		"\u015f\3\2\2\2g\u0165\3\2\2\2i\u016b\3\2\2\2k\u0171\3\2\2\2m\u0177\3\2"+
		"\2\2o\u017b\3\2\2\2q\u0181\3\2\2\2s\u0187\3\2\2\2u\u018a\3\2\2\2w\u018e"+
		"\3\2\2\2y\u0192\3\2\2\2{\u0199\3\2\2\2}\u01a3\3\2\2\2\177\u01a6\3\2\2"+
		"\2\u0081\u01aa\3\2\2\2\u0083\u01af\3\2\2\2\u0085\u01b4\3\2\2\2\u0087\u01bb"+
		"\3\2\2\2\u0089\u01c1\3\2\2\2\u008b\u01c8\3\2\2\2\u008d\u01d0\3\2\2\2\u008f"+
		"\u01d8\3\2\2\2\u0091\u01e2\3\2\2\2\u0093\u0094\7u\2\2\u0094\u0095\7g\2"+
		"\2\u0095\u0096\7n\2\2\u0096\u0097\7g\2\2\u0097\u0098\7e\2\2\u0098\u0099"+
		"\7v\2\2\u0099\4\3\2\2\2\u009a\u009b\7o\2\2\u009b\u009c\7k\2\2\u009c\u009d"+
		"\7f\2\2\u009d\u009e\7k\2\2\u009e\6\3\2\2\2\u009f\u00a0\7u\2\2\u00a0\u00a1"+
		"\7j\2\2\u00a1\u00a2\7g\2\2\u00a2\u00a3\7g\2\2\u00a3\u00a4\7v\2\2\u00a4"+
		"\b\3\2\2\2\u00a5\u00a6\7o\2\2\u00a6\u00a7\7r\2\2\u00a7\u00a8\7\65\2\2"+
		"\u00a8\n\3\2\2\2\u00a9\u00aa\7o\2\2\u00aa\u00ab\7w\2\2\u00ab\u00ac\7u"+
		"\2\2\u00ac\u00ad\7k\2\2\u00ad\u00ae\7e\2\2\u00ae\u00af\7z\2\2\u00af\u00b0"+
		"\7o\2\2\u00b0\u00b1\7n\2\2\u00b1\f\3\2\2\2\u00b2\u00b3\7h\2\2\u00b3\u00b4"+
		"\7t\2\2\u00b4\u00b5\7q\2\2\u00b5\u00b6\7o\2\2\u00b6\16\3\2\2\2\u00b7\u00b8"+
		"\7y\2\2\u00b8\u00b9\7j\2\2\u00b9\u00ba\7g\2\2\u00ba\u00bb\7t\2\2\u00bb"+
		"\u00bc\7g\2\2\u00bc\20\3\2\2\2\u00bd\u00be\7c\2\2\u00be\u00bf\7p\2\2\u00bf"+
		"\u00c3\7f\2\2\u00c0\u00c1\7(\2\2\u00c1\u00c3\7(\2\2\u00c2\u00bd\3\2\2"+
		"\2\u00c2\u00c0\3\2\2\2\u00c3\22\3\2\2\2\u00c4\u00c5\7q\2\2\u00c5\u00c9"+
		"\7t\2\2\u00c6\u00c7\7~\2\2\u00c7\u00c9\7~\2\2\u00c8\u00c4\3\2\2\2\u00c8"+
		"\u00c6\3\2\2\2\u00c9\24\3\2\2\2\u00ca\u00cb\7k\2\2\u00cb\u00cc\7u\2\2"+
		"\u00cc\26\3\2\2\2\u00cd\u00ce\7p\2\2\u00ce\u00cf\7w\2\2\u00cf\u00d0\7"+
		"n\2\2\u00d0\u00d1\7n\2\2\u00d1\30\3\2\2\2\u00d2\u00d3\7n\2\2\u00d3\u00d4"+
		"\7k\2\2\u00d4\u00d5\7m\2\2\u00d5\u00d6\7g\2\2\u00d6\32\3\2\2\2\u00d7\u00d8"+
		"\7k\2\2\u00d8\u00d9\7p\2\2\u00d9\34\3\2\2\2\u00da\u00db\7g\2\2\u00db\u00dc"+
		"\7z\2\2\u00dc\u00dd\7k\2\2\u00dd\u00de\7u\2\2\u00de\u00df\7v\2\2\u00df"+
		"\u00e0\7u\2\2\u00e0\36\3\2\2\2\u00e1\u00e2\7c\2\2\u00e2\u00e3\7n\2\2\u00e3"+
		"\u00e4\7n\2\2\u00e4 \3\2\2\2\u00e5\u00e6\7c\2\2\u00e6\u00e7\7p\2\2\u00e7"+
		"\u00e8\7{\2\2\u00e8\"\3\2\2\2\u00e9\u00ea\7v\2\2\u00ea\u00eb\7t\2\2\u00eb"+
		"\u00ec\7w\2\2\u00ec\u00ed\7g\2\2\u00ed$\3\2\2\2\u00ee\u00ef\7h\2\2\u00ef"+
		"\u00f0\7c\2\2\u00f0\u00f1\7n\2\2\u00f1\u00f2\7u\2\2\u00f2\u00f3\7g\2\2"+
		"\u00f3&\3\2\2\2\u00f4\u00f5\7f\2\2\u00f5\u00f6\7k\2\2\u00f6\u00f9\7x\2"+
		"\2\u00f7\u00f9\7\61\2\2\u00f8\u00f4\3\2\2\2\u00f8\u00f7\3\2\2\2\u00f9"+
		"(\3\2\2\2\u00fa\u00fb\7o\2\2\u00fb\u00fc\7q\2\2\u00fc\u00ff\7f\2\2\u00fd"+
		"\u00ff\7\'\2\2\u00fe\u00fa\3\2\2\2\u00fe\u00fd\3\2\2\2\u00ff*\3\2\2\2"+
		"\u0100\u0101\7d\2\2\u0101\u0102\7g\2\2\u0102\u0103\7v\2\2\u0103\u0104"+
		"\7y\2\2\u0104\u0105\7g\2\2\u0105\u0106\7g\2\2\u0106\u0107\7p\2\2\u0107"+
		",\3\2\2\2\u0108\u0109\7t\2\2\u0109\u010a\7g\2\2\u010a\u010b\7i\2\2\u010b"+
		"\u010c\7g\2\2\u010c\u010d\7z\2\2\u010d\u010e\7r\2\2\u010e.\3\2\2\2\u010f"+
		"\u0110\7-\2\2\u0110\60\3\2\2\2\u0111\u0112\7/\2\2\u0112\62\3\2\2\2\u0113"+
		"\u0114\7\u0080\2\2\u0114\64\3\2\2\2\u0115\u0116\7~\2\2\u0116\66\3\2\2"+
		"\2\u0117\u0118\7(\2\2\u01188\3\2\2\2\u0119\u011a\7`\2\2\u011a:\3\2\2\2"+
		"\u011b\u011c\7d\2\2\u011c\u011d\7k\2\2\u011d\u011e\7p\2\2\u011e\u011f"+
		"\7c\2\2\u011f\u0120\7t\2\2\u0120\u0121\7{\2\2\u0121<\3\2\2\2\u0122\u0123"+
		"\7g\2\2\u0123\u0124\7u\2\2\u0124\u0125\7e\2\2\u0125\u0126\7c\2\2\u0126"+
		"\u0127\7r\2\2\u0127\u0128\7g\2\2\u0128>\3\2\2\2\u0129\u012a\7,\2\2\u012a"+
		"@\3\2\2\2\u012b\u012c\7+\2\2\u012cB\3\2\2\2\u012d\u012e\7*\2\2\u012eD"+
		"\3\2\2\2\u012f\u0130\7_\2\2\u0130F\3\2\2\2\u0131\u0132\7]\2\2\u0132H\3"+
		"\2\2\2\u0133\u0134\7<\2\2\u0134J\3\2\2\2\u0135\u0136\7\60\2\2\u0136\u0137"+
		"\7,\2\2\u0137L\3\2\2\2\u0138\u0139\7?\2\2\u0139N\3\2\2\2\u013a\u013b\7"+
		">\2\2\u013bP\3\2\2\2\u013c\u013d\7@\2\2\u013dR\3\2\2\2\u013e\u013f\7#"+
		"\2\2\u013f\u0140\7?\2\2\u0140T\3\2\2\2\u0141\u0142\7p\2\2\u0142\u0143"+
		"\7q\2\2\u0143\u0144\7v\2\2\u0144V\3\2\2\2\u0145\u0146\7>\2\2\u0146\u0147"+
		"\7?\2\2\u0147X\3\2\2\2\u0148\u0149\7@\2\2\u0149\u014a\7?\2\2\u014aZ\3"+
		"\2\2\2\u014b\u014c\7=\2\2\u014c\\\3\2\2\2\u014d\u014e\7.\2\2\u014e^\3"+
		"\2\2\2\u014f\u0150\7\60\2\2\u0150`\3\2\2\2\u0151\u0152\7e\2\2\u0152\u0153"+
		"\7q\2\2\u0153\u0154\7n\2\2\u0154\u0155\7n\2\2\u0155\u0156\7c\2\2\u0156"+
		"\u0157\7v\2\2\u0157\u0158\7g\2\2\u0158b\3\2\2\2\u0159\u015a\7k\2\2\u015a"+
		"\u015b\7p\2\2\u015b\u015c\7p\2\2\u015c\u015d\7g\2\2\u015d\u015e\7t\2\2"+
		"\u015ed\3\2\2\2\u015f\u0160\7q\2\2\u0160\u0161\7w\2\2\u0161\u0162\7v\2"+
		"\2\u0162\u0163\7g\2\2\u0163\u0164\7t\2\2\u0164f\3\2\2\2\u0165\u0166\7"+
		"e\2\2\u0166\u0167\7t\2\2\u0167\u0168\7q\2\2\u0168\u0169\7u\2\2\u0169\u016a"+
		"\7u\2\2\u016ah\3\2\2\2\u016b\u016c\7w\2\2\u016c\u016d\7u\2\2\u016d\u016e"+
		"\7k\2\2\u016e\u016f\7p\2\2\u016f\u0170\7i\2\2\u0170j\3\2\2\2\u0171\u0172"+
		"\7k\2\2\u0172\u0173\7p\2\2\u0173\u0174\7f\2\2\u0174\u0175\7g\2\2\u0175"+
		"\u0176\7z\2\2\u0176l\3\2\2\2\u0177\u0178\7m\2\2\u0178\u0179\7g\2\2\u0179"+
		"\u017a\7{\2\2\u017an\3\2\2\2\u017b\u017c\7q\2\2\u017c\u017d\7t\2\2\u017d"+
		"\u017e\7f\2\2\u017e\u017f\7g\2\2\u017f\u0180\7t\2\2\u0180p\3\2\2\2\u0181"+
		"\u0182\7i\2\2\u0182\u0183\7t\2\2\u0183\u0184\7q\2\2\u0184\u0185\7w\2\2"+
		"\u0185\u0186\7r\2\2\u0186r\3\2\2\2\u0187\u0188\7d\2\2\u0188\u0189\7{\2"+
		"\2\u0189t\3\2\2\2\u018a\u018b\7h\2\2\u018b\u018c\7q\2\2\u018c\u018d\7"+
		"t\2\2\u018dv\3\2\2\2\u018e\u018f\7w\2\2\u018f\u0190\7u\2\2\u0190\u0191"+
		"\7g\2\2\u0191x\3\2\2\2\u0192\u0193\7k\2\2\u0193\u0194\7i\2\2\u0194\u0195"+
		"\7p\2\2\u0195\u0196\7q\2\2\u0196\u0197\7t\2\2\u0197\u0198\7g\2\2\u0198"+
		"z\3\2\2\2\u0199\u019a\7r\2\2\u019a\u019b\7c\2\2\u019b\u019c\7t\2\2\u019c"+
		"\u019d\7v\2\2\u019d\u019e\7k\2\2\u019e\u019f\7v\2\2\u019f\u01a0\7k\2\2"+
		"\u01a0\u01a1\7q\2\2\u01a1\u01a2\7p\2\2\u01a2|\3\2\2\2\u01a3\u01a4\7q\2"+
		"\2\u01a4\u01a5\7l\2\2\u01a5~\3\2\2\2\u01a6\u01a7\7q\2\2\u01a7\u01a8\7"+
		"p\2\2\u01a8\u0080\3\2\2\2\u01a9\u01ab\t\2\2\2\u01aa\u01a9\3\2\2\2\u01ab"+
		"\u01ac\3\2\2\2\u01ac\u01aa\3\2\2\2\u01ac\u01ad\3\2\2\2\u01ad\u0082\3\2"+
		"\2\2\u01ae\u01b0\4\62;\2\u01af\u01ae\3\2\2\2\u01b0\u01b1\3\2\2\2\u01b1"+
		"\u01af\3\2\2\2\u01b1\u01b2\3\2\2\2\u01b2\u0084\3\2\2\2\u01b3\u01b5\7\17"+
		"\2\2\u01b4\u01b3\3\2\2\2\u01b4\u01b5\3\2\2\2\u01b5\u01b6\3\2\2\2\u01b6"+
		"\u01b7\7\f\2\2\u01b7\u01b8\3\2\2\2\u01b8\u01b9\bC\2\2\u01b9\u0086\3\2"+
		"\2\2\u01ba\u01bc\t\3\2\2\u01bb\u01ba\3\2\2\2\u01bc\u01bd\3\2\2\2\u01bd"+
		"\u01bb\3\2\2\2\u01bd\u01be\3\2\2\2\u01be\u01bf\3\2\2\2\u01bf\u01c0\bD"+
		"\2\2\u01c0\u0088\3\2\2\2\u01c1\u01c6\7B\2\2\u01c2\u01c7\5\u008bF\2\u01c3"+
		"\u01c7\5\u008dG\2\u01c4\u01c7\5\u008fH\2\u01c5\u01c7\5\u0091I\2\u01c6"+
		"\u01c2\3\2\2\2\u01c6\u01c3\3\2\2\2\u01c6\u01c4\3\2\2\2\u01c6\u01c5\3\2"+
		"\2\2\u01c7\u008a\3\2\2\2\u01c8\u01ca\7b\2\2\u01c9\u01cb\n\4\2\2\u01ca"+
		"\u01c9\3\2\2\2\u01cb\u01cc\3\2\2\2\u01cc\u01ca\3\2\2\2\u01cc\u01cd\3\2"+
		"\2\2\u01cd\u01ce\3\2\2\2\u01ce\u01cf\7b\2\2\u01cf\u008c\3\2\2\2\u01d0"+
		"\u01d2\7)\2\2\u01d1\u01d3\n\5\2\2\u01d2\u01d1\3\2\2\2\u01d3\u01d4\3\2"+
		"\2\2\u01d4\u01d2\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5\u01d6\3\2\2\2\u01d6"+
		"\u01d7\7)\2\2\u01d7\u008e\3\2\2\2\u01d8\u01da\7$\2\2\u01d9\u01db\n\6\2"+
		"\2\u01da\u01d9\3\2\2\2\u01db\u01dc\3\2\2\2\u01dc\u01da\3\2\2\2\u01dc\u01dd"+
		"\3\2\2\2\u01dd\u01de\3\2\2\2\u01de\u01df\7$\2\2\u01df\u0090\3\2\2\2\u01e0"+
		"\u01e3\t\7\2\2\u01e1\u01e3\5_\60\2\u01e2\u01e0\3\2\2\2\u01e2\u01e1\3\2"+
		"\2\2\u01e3\u01e4\3\2\2\2\u01e4\u01e2\3\2\2\2\u01e4\u01e5\3\2\2\2\u01e5"+
		"\u0092\3\2\2\2\21\2\u00c2\u00c8\u00f8\u00fe\u01ac\u01b1\u01b4\u01bd\u01c6"+
		"\u01cc\u01d4\u01dc\u01e2\u01e4\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}