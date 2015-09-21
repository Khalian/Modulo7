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
		OR=9, IS=10, NULL=11, LIKE=12, IN=13, EXISTS=14, ALL=15, ANY=16, TRUE=17, 
		FALSE=18, DIVIDE=19, MOD=20, REGEXP=21, PLUS=22, MINUS=23, NEGATION=24, 
		VERTBAR=25, BITAND=26, POWER_OP=27, BINARY=28, ESCAPE=29, ASTERISK=30, 
		RPAREN=31, LPAREN=32, RBRACK=33, LBRACK=34, COLON=35, ALL_FIELDS=36, EQ=37, 
		LTH=38, GTH=39, NOT_EQ=40, NOT=41, LET=42, GET=43, SEMI=44, COMMA=45, 
		DOT=46, COLLATE=47, USING=48, INDEX=49, KEY=50, ORDER=51, GROUP=52, BETWEEN=53, 
		POLYPHONIC=54, HAPPINESSINDEX=55, SADNESSINDEX=56, POWERINDEX=57, ID=58, 
		INT=59, DOUBLE=60, DATABASENAME=61, NEWLINE=62, WS=63, USER_VAR=64;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"SELECT", "MIDI", "SHEET", "MP3", "MUSICXML", "FROM", "WHERE", "AND", 
		"OR", "IS", "NULL", "LIKE", "IN", "EXISTS", "ALL", "ANY", "TRUE", "FALSE", 
		"DIVIDE", "MOD", "REGEXP", "PLUS", "MINUS", "NEGATION", "VERTBAR", "BITAND", 
		"POWER_OP", "BINARY", "ESCAPE", "ASTERISK", "RPAREN", "LPAREN", "RBRACK", 
		"LBRACK", "COLON", "ALL_FIELDS", "EQ", "LTH", "GTH", "NOT_EQ", "NOT", 
		"LET", "GET", "SEMI", "COMMA", "DOT", "COLLATE", "USING", "INDEX", "KEY", 
		"ORDER", "GROUP", "BETWEEN", "POLYPHONIC", "HAPPINESSINDEX", "SADNESSINDEX", 
		"POWERINDEX", "ID", "INT", "DOUBLE", "DATABASENAME", "NEWLINE", "WS", 
		"USER_VAR", "USER_VAR_SUBFIX1", "USER_VAR_SUBFIX2", "USER_VAR_SUBFIX3", 
		"USER_VAR_SUBFIX4"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'select'", "'midi'", "'sheet'", "'mp3'", "'musicxml'", "'from'", 
		"'where'", null, null, "'is'", "'null'", "'like'", "'in'", "'exists'", 
		"'all'", "'any'", "'true'", "'false'", null, null, "'regexp'", "'+'", 
		"'-'", "'~'", "'|'", "'&'", "'^'", "'binary'", "'escape'", "'*'", "')'", 
		"'('", "']'", "'['", "':'", "'.*'", "'='", "'<'", "'>'", "'!='", "'not'", 
		"'<='", "'>='", "';'", "','", "'.'", "'collate'", "'using'", "'index'", 
		"'key'", "'order'", "'group'", "'between'", "'polyphonic'", "'happinessindex'", 
		"'sadnessindex'", "'powerindex'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "SELECT", "MIDI", "SHEET", "MP3", "MUSICXML", "FROM", "WHERE", "AND", 
		"OR", "IS", "NULL", "LIKE", "IN", "EXISTS", "ALL", "ANY", "TRUE", "FALSE", 
		"DIVIDE", "MOD", "REGEXP", "PLUS", "MINUS", "NEGATION", "VERTBAR", "BITAND", 
		"POWER_OP", "BINARY", "ESCAPE", "ASTERISK", "RPAREN", "LPAREN", "RBRACK", 
		"LBRACK", "COLON", "ALL_FIELDS", "EQ", "LTH", "GTH", "NOT_EQ", "NOT", 
		"LET", "GET", "SEMI", "COMMA", "DOT", "COLLATE", "USING", "INDEX", "KEY", 
		"ORDER", "GROUP", "BETWEEN", "POLYPHONIC", "HAPPINESSINDEX", "SADNESSINDEX", 
		"POWERINDEX", "ID", "INT", "DOUBLE", "DATABASENAME", "NEWLINE", "WS", 
		"USER_VAR"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2B\u01ec\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\t\3\t\3\t\3\t\3\t\5\t\u00bb\n\t\3\n\3\n\3\n\3\n\5\n\u00c1\n\n"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24"+
		"\3\24\3\24\5\24\u00f1\n\24\3\25\3\25\3\25\3\25\5\25\u00f7\n\25\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3"+
		"\33\3\33\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3"+
		"\36\3\36\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3%"+
		"\3&\3&\3\'\3\'\3(\3(\3)\3)\3)\3*\3*\3*\3*\3+\3+\3+\3,\3,\3,\3-\3-\3.\3"+
		".\3/\3/\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3"+
		"\61\3\61\3\62\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\64\3\64\3"+
		"\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3"+
		"\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3"+
		"\67\38\38\38\38\38\38\38\38\38\38\38\38\38\38\38\39\39\39\39\39\39\39"+
		"\39\39\39\39\39\39\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3;\6;\u01a1\n;\r;"+
		"\16;\u01a2\3<\6<\u01a6\n<\r<\16<\u01a7\3=\6=\u01ab\n=\r=\16=\u01ac\3="+
		"\3=\6=\u01b1\n=\r=\16=\u01b2\3>\6>\u01b6\n>\r>\16>\u01b7\3?\5?\u01bb\n"+
		"?\3?\3?\3?\3?\3@\6@\u01c2\n@\r@\16@\u01c3\3@\3@\3A\3A\3A\3A\3A\5A\u01cd"+
		"\nA\3B\3B\6B\u01d1\nB\rB\16B\u01d2\3B\3B\3C\3C\6C\u01d9\nC\rC\16C\u01da"+
		"\3C\3C\3D\3D\6D\u01e1\nD\rD\16D\u01e2\3D\3D\3E\3E\6E\u01e9\nE\rE\16E\u01ea"+
		"\2\2F\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67"+
		"m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083\2\u0085\2\u0087\2\u0089\2\3\2\b\5"+
		"\2C\\aac|\5\2\13\f\17\17\"\"\3\2bb\3\2))\3\2$$\7\2&&\62;C\\aac|\u01fa"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3"+
		"\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2"+
		"\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2"+
		"{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\3\u008b\3\2\2\2\5\u0092"+
		"\3\2\2\2\7\u0097\3\2\2\2\t\u009d\3\2\2\2\13\u00a1\3\2\2\2\r\u00aa\3\2"+
		"\2\2\17\u00af\3\2\2\2\21\u00ba\3\2\2\2\23\u00c0\3\2\2\2\25\u00c2\3\2\2"+
		"\2\27\u00c5\3\2\2\2\31\u00ca\3\2\2\2\33\u00cf\3\2\2\2\35\u00d2\3\2\2\2"+
		"\37\u00d9\3\2\2\2!\u00dd\3\2\2\2#\u00e1\3\2\2\2%\u00e6\3\2\2\2\'\u00f0"+
		"\3\2\2\2)\u00f6\3\2\2\2+\u00f8\3\2\2\2-\u00ff\3\2\2\2/\u0101\3\2\2\2\61"+
		"\u0103\3\2\2\2\63\u0105\3\2\2\2\65\u0107\3\2\2\2\67\u0109\3\2\2\29\u010b"+
		"\3\2\2\2;\u0112\3\2\2\2=\u0119\3\2\2\2?\u011b\3\2\2\2A\u011d\3\2\2\2C"+
		"\u011f\3\2\2\2E\u0121\3\2\2\2G\u0123\3\2\2\2I\u0125\3\2\2\2K\u0128\3\2"+
		"\2\2M\u012a\3\2\2\2O\u012c\3\2\2\2Q\u012e\3\2\2\2S\u0131\3\2\2\2U\u0135"+
		"\3\2\2\2W\u0138\3\2\2\2Y\u013b\3\2\2\2[\u013d\3\2\2\2]\u013f\3\2\2\2_"+
		"\u0141\3\2\2\2a\u0149\3\2\2\2c\u014f\3\2\2\2e\u0155\3\2\2\2g\u0159\3\2"+
		"\2\2i\u015f\3\2\2\2k\u0165\3\2\2\2m\u016d\3\2\2\2o\u0178\3\2\2\2q\u0187"+
		"\3\2\2\2s\u0194\3\2\2\2u\u01a0\3\2\2\2w\u01a5\3\2\2\2y\u01aa\3\2\2\2{"+
		"\u01b5\3\2\2\2}\u01ba\3\2\2\2\177\u01c1\3\2\2\2\u0081\u01c7\3\2\2\2\u0083"+
		"\u01ce\3\2\2\2\u0085\u01d6\3\2\2\2\u0087\u01de\3\2\2\2\u0089\u01e8\3\2"+
		"\2\2\u008b\u008c\7u\2\2\u008c\u008d\7g\2\2\u008d\u008e\7n\2\2\u008e\u008f"+
		"\7g\2\2\u008f\u0090\7e\2\2\u0090\u0091\7v\2\2\u0091\4\3\2\2\2\u0092\u0093"+
		"\7o\2\2\u0093\u0094\7k\2\2\u0094\u0095\7f\2\2\u0095\u0096\7k\2\2\u0096"+
		"\6\3\2\2\2\u0097\u0098\7u\2\2\u0098\u0099\7j\2\2\u0099\u009a\7g\2\2\u009a"+
		"\u009b\7g\2\2\u009b\u009c\7v\2\2\u009c\b\3\2\2\2\u009d\u009e\7o\2\2\u009e"+
		"\u009f\7r\2\2\u009f\u00a0\7\65\2\2\u00a0\n\3\2\2\2\u00a1\u00a2\7o\2\2"+
		"\u00a2\u00a3\7w\2\2\u00a3\u00a4\7u\2\2\u00a4\u00a5\7k\2\2\u00a5\u00a6"+
		"\7e\2\2\u00a6\u00a7\7z\2\2\u00a7\u00a8\7o\2\2\u00a8\u00a9\7n\2\2\u00a9"+
		"\f\3\2\2\2\u00aa\u00ab\7h\2\2\u00ab\u00ac\7t\2\2\u00ac\u00ad\7q\2\2\u00ad"+
		"\u00ae\7o\2\2\u00ae\16\3\2\2\2\u00af\u00b0\7y\2\2\u00b0\u00b1\7j\2\2\u00b1"+
		"\u00b2\7g\2\2\u00b2\u00b3\7t\2\2\u00b3\u00b4\7g\2\2\u00b4\20\3\2\2\2\u00b5"+
		"\u00b6\7c\2\2\u00b6\u00b7\7p\2\2\u00b7\u00bb\7f\2\2\u00b8\u00b9\7(\2\2"+
		"\u00b9\u00bb\7(\2\2\u00ba\u00b5\3\2\2\2\u00ba\u00b8\3\2\2\2\u00bb\22\3"+
		"\2\2\2\u00bc\u00bd\7q\2\2\u00bd\u00c1\7t\2\2\u00be\u00bf\7~\2\2\u00bf"+
		"\u00c1\7~\2\2\u00c0\u00bc\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1\24\3\2\2\2"+
		"\u00c2\u00c3\7k\2\2\u00c3\u00c4\7u\2\2\u00c4\26\3\2\2\2\u00c5\u00c6\7"+
		"p\2\2\u00c6\u00c7\7w\2\2\u00c7\u00c8\7n\2\2\u00c8\u00c9\7n\2\2\u00c9\30"+
		"\3\2\2\2\u00ca\u00cb\7n\2\2\u00cb\u00cc\7k\2\2\u00cc\u00cd\7m\2\2\u00cd"+
		"\u00ce\7g\2\2\u00ce\32\3\2\2\2\u00cf\u00d0\7k\2\2\u00d0\u00d1\7p\2\2\u00d1"+
		"\34\3\2\2\2\u00d2\u00d3\7g\2\2\u00d3\u00d4\7z\2\2\u00d4\u00d5\7k\2\2\u00d5"+
		"\u00d6\7u\2\2\u00d6\u00d7\7v\2\2\u00d7\u00d8\7u\2\2\u00d8\36\3\2\2\2\u00d9"+
		"\u00da\7c\2\2\u00da\u00db\7n\2\2\u00db\u00dc\7n\2\2\u00dc \3\2\2\2\u00dd"+
		"\u00de\7c\2\2\u00de\u00df\7p\2\2\u00df\u00e0\7{\2\2\u00e0\"\3\2\2\2\u00e1"+
		"\u00e2\7v\2\2\u00e2\u00e3\7t\2\2\u00e3\u00e4\7w\2\2\u00e4\u00e5\7g\2\2"+
		"\u00e5$\3\2\2\2\u00e6\u00e7\7h\2\2\u00e7\u00e8\7c\2\2\u00e8\u00e9\7n\2"+
		"\2\u00e9\u00ea\7u\2\2\u00ea\u00eb\7g\2\2\u00eb&\3\2\2\2\u00ec\u00ed\7"+
		"f\2\2\u00ed\u00ee\7k\2\2\u00ee\u00f1\7x\2\2\u00ef\u00f1\7\61\2\2\u00f0"+
		"\u00ec\3\2\2\2\u00f0\u00ef\3\2\2\2\u00f1(\3\2\2\2\u00f2\u00f3\7o\2\2\u00f3"+
		"\u00f4\7q\2\2\u00f4\u00f7\7f\2\2\u00f5\u00f7\7\'\2\2\u00f6\u00f2\3\2\2"+
		"\2\u00f6\u00f5\3\2\2\2\u00f7*\3\2\2\2\u00f8\u00f9\7t\2\2\u00f9\u00fa\7"+
		"g\2\2\u00fa\u00fb\7i\2\2\u00fb\u00fc\7g\2\2\u00fc\u00fd\7z\2\2\u00fd\u00fe"+
		"\7r\2\2\u00fe,\3\2\2\2\u00ff\u0100\7-\2\2\u0100.\3\2\2\2\u0101\u0102\7"+
		"/\2\2\u0102\60\3\2\2\2\u0103\u0104\7\u0080\2\2\u0104\62\3\2\2\2\u0105"+
		"\u0106\7~\2\2\u0106\64\3\2\2\2\u0107\u0108\7(\2\2\u0108\66\3\2\2\2\u0109"+
		"\u010a\7`\2\2\u010a8\3\2\2\2\u010b\u010c\7d\2\2\u010c\u010d\7k\2\2\u010d"+
		"\u010e\7p\2\2\u010e\u010f\7c\2\2\u010f\u0110\7t\2\2\u0110\u0111\7{\2\2"+
		"\u0111:\3\2\2\2\u0112\u0113\7g\2\2\u0113\u0114\7u\2\2\u0114\u0115\7e\2"+
		"\2\u0115\u0116\7c\2\2\u0116\u0117\7r\2\2\u0117\u0118\7g\2\2\u0118<\3\2"+
		"\2\2\u0119\u011a\7,\2\2\u011a>\3\2\2\2\u011b\u011c\7+\2\2\u011c@\3\2\2"+
		"\2\u011d\u011e\7*\2\2\u011eB\3\2\2\2\u011f\u0120\7_\2\2\u0120D\3\2\2\2"+
		"\u0121\u0122\7]\2\2\u0122F\3\2\2\2\u0123\u0124\7<\2\2\u0124H\3\2\2\2\u0125"+
		"\u0126\7\60\2\2\u0126\u0127\7,\2\2\u0127J\3\2\2\2\u0128\u0129\7?\2\2\u0129"+
		"L\3\2\2\2\u012a\u012b\7>\2\2\u012bN\3\2\2\2\u012c\u012d\7@\2\2\u012dP"+
		"\3\2\2\2\u012e\u012f\7#\2\2\u012f\u0130\7?\2\2\u0130R\3\2\2\2\u0131\u0132"+
		"\7p\2\2\u0132\u0133\7q\2\2\u0133\u0134\7v\2\2\u0134T\3\2\2\2\u0135\u0136"+
		"\7>\2\2\u0136\u0137\7?\2\2\u0137V\3\2\2\2\u0138\u0139\7@\2\2\u0139\u013a"+
		"\7?\2\2\u013aX\3\2\2\2\u013b\u013c\7=\2\2\u013cZ\3\2\2\2\u013d\u013e\7"+
		".\2\2\u013e\\\3\2\2\2\u013f\u0140\7\60\2\2\u0140^\3\2\2\2\u0141\u0142"+
		"\7e\2\2\u0142\u0143\7q\2\2\u0143\u0144\7n\2\2\u0144\u0145\7n\2\2\u0145"+
		"\u0146\7c\2\2\u0146\u0147\7v\2\2\u0147\u0148\7g\2\2\u0148`\3\2\2\2\u0149"+
		"\u014a\7w\2\2\u014a\u014b\7u\2\2\u014b\u014c\7k\2\2\u014c\u014d\7p\2\2"+
		"\u014d\u014e\7i\2\2\u014eb\3\2\2\2\u014f\u0150\7k\2\2\u0150\u0151\7p\2"+
		"\2\u0151\u0152\7f\2\2\u0152\u0153\7g\2\2\u0153\u0154\7z\2\2\u0154d\3\2"+
		"\2\2\u0155\u0156\7m\2\2\u0156\u0157\7g\2\2\u0157\u0158\7{\2\2\u0158f\3"+
		"\2\2\2\u0159\u015a\7q\2\2\u015a\u015b\7t\2\2\u015b\u015c\7f\2\2\u015c"+
		"\u015d\7g\2\2\u015d\u015e\7t\2\2\u015eh\3\2\2\2\u015f\u0160\7i\2\2\u0160"+
		"\u0161\7t\2\2\u0161\u0162\7q\2\2\u0162\u0163\7w\2\2\u0163\u0164\7r\2\2"+
		"\u0164j\3\2\2\2\u0165\u0166\7d\2\2\u0166\u0167\7g\2\2\u0167\u0168\7v\2"+
		"\2\u0168\u0169\7y\2\2\u0169\u016a\7g\2\2\u016a\u016b\7g\2\2\u016b\u016c"+
		"\7p\2\2\u016cl\3\2\2\2\u016d\u016e\7r\2\2\u016e\u016f\7q\2\2\u016f\u0170"+
		"\7n\2\2\u0170\u0171\7{\2\2\u0171\u0172\7r\2\2\u0172\u0173\7j\2\2\u0173"+
		"\u0174\7q\2\2\u0174\u0175\7p\2\2\u0175\u0176\7k\2\2\u0176\u0177\7e\2\2"+
		"\u0177n\3\2\2\2\u0178\u0179\7j\2\2\u0179\u017a\7c\2\2\u017a\u017b\7r\2"+
		"\2\u017b\u017c\7r\2\2\u017c\u017d\7k\2\2\u017d\u017e\7p\2\2\u017e\u017f"+
		"\7g\2\2\u017f\u0180\7u\2\2\u0180\u0181\7u\2\2\u0181\u0182\7k\2\2\u0182"+
		"\u0183\7p\2\2\u0183\u0184\7f\2\2\u0184\u0185\7g\2\2\u0185\u0186\7z\2\2"+
		"\u0186p\3\2\2\2\u0187\u0188\7u\2\2\u0188\u0189\7c\2\2\u0189\u018a\7f\2"+
		"\2\u018a\u018b\7p\2\2\u018b\u018c\7g\2\2\u018c\u018d\7u\2\2\u018d\u018e"+
		"\7u\2\2\u018e\u018f\7k\2\2\u018f\u0190\7p\2\2\u0190\u0191\7f\2\2\u0191"+
		"\u0192\7g\2\2\u0192\u0193\7z\2\2\u0193r\3\2\2\2\u0194\u0195\7r\2\2\u0195"+
		"\u0196\7q\2\2\u0196\u0197\7y\2\2\u0197\u0198\7g\2\2\u0198\u0199\7t\2\2"+
		"\u0199\u019a\7k\2\2\u019a\u019b\7p\2\2\u019b\u019c\7f\2\2\u019c\u019d"+
		"\7g\2\2\u019d\u019e\7z\2\2\u019et\3\2\2\2\u019f\u01a1\t\2\2\2\u01a0\u019f"+
		"\3\2\2\2\u01a1\u01a2\3\2\2\2\u01a2\u01a0\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3"+
		"v\3\2\2\2\u01a4\u01a6\4\62;\2\u01a5\u01a4\3\2\2\2\u01a6\u01a7\3\2\2\2"+
		"\u01a7\u01a5\3\2\2\2\u01a7\u01a8\3\2\2\2\u01a8x\3\2\2\2\u01a9\u01ab\4"+
		"\62;\2\u01aa\u01a9\3\2\2\2\u01ab\u01ac\3\2\2\2\u01ac\u01aa\3\2\2\2\u01ac"+
		"\u01ad\3\2\2\2\u01ad\u01ae\3\2\2\2\u01ae\u01b0\7\60\2\2\u01af\u01b1\4"+
		"\62;\2\u01b0\u01af\3\2\2\2\u01b1\u01b2\3\2\2\2\u01b2\u01b0\3\2\2\2\u01b2"+
		"\u01b3\3\2\2\2\u01b3z\3\2\2\2\u01b4\u01b6\t\2\2\2\u01b5\u01b4\3\2\2\2"+
		"\u01b6\u01b7\3\2\2\2\u01b7\u01b5\3\2\2\2\u01b7\u01b8\3\2\2\2\u01b8|\3"+
		"\2\2\2\u01b9\u01bb\7\17\2\2\u01ba\u01b9\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb"+
		"\u01bc\3\2\2\2\u01bc\u01bd\7\f\2\2\u01bd\u01be\3\2\2\2\u01be\u01bf\b?"+
		"\2\2\u01bf~\3\2\2\2\u01c0\u01c2\t\3\2\2\u01c1\u01c0\3\2\2\2\u01c2\u01c3"+
		"\3\2\2\2\u01c3\u01c1\3\2\2\2\u01c3\u01c4\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5"+
		"\u01c6\b@\2\2\u01c6\u0080\3\2\2\2\u01c7\u01cc\7B\2\2\u01c8\u01cd\5\u0083"+
		"B\2\u01c9\u01cd\5\u0085C\2\u01ca\u01cd\5\u0087D\2\u01cb\u01cd\5\u0089"+
		"E\2\u01cc\u01c8\3\2\2\2\u01cc\u01c9\3\2\2\2\u01cc\u01ca\3\2\2\2\u01cc"+
		"\u01cb\3\2\2\2\u01cd\u0082\3\2\2\2\u01ce\u01d0\7b\2\2\u01cf\u01d1\n\4"+
		"\2\2\u01d0\u01cf\3\2\2\2\u01d1\u01d2\3\2\2\2\u01d2\u01d0\3\2\2\2\u01d2"+
		"\u01d3\3\2\2\2\u01d3\u01d4\3\2\2\2\u01d4\u01d5\7b\2\2\u01d5\u0084\3\2"+
		"\2\2\u01d6\u01d8\7)\2\2\u01d7\u01d9\n\5\2\2\u01d8\u01d7\3\2\2\2\u01d9"+
		"\u01da\3\2\2\2\u01da\u01d8\3\2\2\2\u01da\u01db\3\2\2\2\u01db\u01dc\3\2"+
		"\2\2\u01dc\u01dd\7)\2\2\u01dd\u0086\3\2\2\2\u01de\u01e0\7$\2\2\u01df\u01e1"+
		"\n\6\2\2\u01e0\u01df\3\2\2\2\u01e1\u01e2\3\2\2\2\u01e2\u01e0\3\2\2\2\u01e2"+
		"\u01e3\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4\u01e5\7$\2\2\u01e5\u0088\3\2"+
		"\2\2\u01e6\u01e9\t\7\2\2\u01e7\u01e9\5]/\2\u01e8\u01e6\3\2\2\2\u01e8\u01e7"+
		"\3\2\2\2\u01e9\u01ea\3\2\2\2\u01ea\u01e8\3\2\2\2\u01ea\u01eb\3\2\2\2\u01eb"+
		"\u008a\3\2\2\2\24\2\u00ba\u00c0\u00f0\u00f6\u01a2\u01a7\u01ac\u01b2\u01b7"+
		"\u01ba\u01c3\u01cc\u01d2\u01da\u01e2\u01e8\u01ea\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}