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
		FALSE=18, DIVIDE=19, MOD=20, PLUS=21, MINUS=22, NEGATION=23, VERTBAR=24, 
		BITAND=25, POWER_OP=26, BINARY=27, ESCAPE=28, ASTERISK=29, RPAREN=30, 
		LPAREN=31, RBRACK=32, LBRACK=33, COLON=34, ALL_FIELDS=35, EQ=36, LTH=37, 
		GTH=38, NOT_EQ=39, NOT=40, LET=41, GET=42, SEMI=43, COMMA=44, DOT=45, 
		COLLATE=46, USING=47, INDEX=48, BETWEEN=49, POLYPHONIC=50, HAPPINESSINDEX=51, 
		SADNESSINDEX=52, POWERINDEX=53, MAXMELODICREPREATINGFACTOR=54, ID=55, 
		INT=56, DOUBLE=57, DATABASENAME=58, NEWLINE=59, WS=60, USER_VAR=61;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"SELECT", "MIDI", "SHEET", "MP3", "MUSICXML", "FROM", "WHERE", "AND", 
		"OR", "IS", "NULL", "LIKE", "IN", "EXISTS", "ALL", "ANY", "TRUE", "FALSE", 
		"DIVIDE", "MOD", "PLUS", "MINUS", "NEGATION", "VERTBAR", "BITAND", "POWER_OP", 
		"BINARY", "ESCAPE", "ASTERISK", "RPAREN", "LPAREN", "RBRACK", "LBRACK", 
		"COLON", "ALL_FIELDS", "EQ", "LTH", "GTH", "NOT_EQ", "NOT", "LET", "GET", 
		"SEMI", "COMMA", "DOT", "COLLATE", "USING", "INDEX", "BETWEEN", "POLYPHONIC", 
		"HAPPINESSINDEX", "SADNESSINDEX", "POWERINDEX", "MAXMELODICREPREATINGFACTOR", 
		"ID", "INT", "DOUBLE", "DATABASENAME", "NEWLINE", "WS", "USER_VAR", "USER_VAR_SUBFIX1", 
		"USER_VAR_SUBFIX2", "USER_VAR_SUBFIX3", "USER_VAR_SUBFIX4"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'select'", "'midi'", "'sheet'", "'mp3'", "'musicxml'", "'from'", 
		"'where'", null, null, "'is'", "'null'", "'like'", "'in'", "'exists'", 
		"'all'", "'any'", "'true'", "'false'", null, null, "'+'", "'-'", "'~'", 
		"'|'", "'&'", "'^'", "'binary'", "'escape'", "'*'", "')'", "'('", "']'", 
		"'['", "':'", "'.*'", "'='", "'<'", "'>'", "'!='", "'not'", "'<='", "'>='", 
		"';'", "','", "'.'", "'collate'", "'using'", "'index'", "'between'", "'polyphonic'", 
		"'happinessindex'", "'sadnessindex'", "'powerindex'", "'maxmelodicrepeatingfactor'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "SELECT", "MIDI", "SHEET", "MP3", "MUSICXML", "FROM", "WHERE", "AND", 
		"OR", "IS", "NULL", "LIKE", "IN", "EXISTS", "ALL", "ANY", "TRUE", "FALSE", 
		"DIVIDE", "MOD", "PLUS", "MINUS", "NEGATION", "VERTBAR", "BITAND", "POWER_OP", 
		"BINARY", "ESCAPE", "ASTERISK", "RPAREN", "LPAREN", "RBRACK", "LBRACK", 
		"COLON", "ALL_FIELDS", "EQ", "LTH", "GTH", "NOT_EQ", "NOT", "LET", "GET", 
		"SEMI", "COMMA", "DOT", "COLLATE", "USING", "INDEX", "BETWEEN", "POLYPHONIC", 
		"HAPPINESSINDEX", "SADNESSINDEX", "POWERINDEX", "MAXMELODICREPREATINGFACTOR", 
		"ID", "INT", "DOUBLE", "DATABASENAME", "NEWLINE", "WS", "USER_VAR"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2?\u01e9\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3"+
		"\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t"+
		"\3\t\3\t\5\t\u00b5\n\t\3\n\3\n\3\n\3\n\5\n\u00bb\n\n\3\13\3\13\3\13\3"+
		"\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3"+
		"\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\5\24\u00eb"+
		"\n\24\3\25\3\25\3\25\3\25\5\25\u00f1\n\25\3\26\3\26\3\27\3\27\3\30\3\30"+
		"\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\""+
		"\3#\3#\3$\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3(\3)\3)\3)\3)\3*\3*\3*\3+\3"+
		"+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3/\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60"+
		"\3\60\3\61\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\62\3\62"+
		"\3\62\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\64\3\64"+
		"\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\65"+
		"\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\66\3\66"+
		"\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67"+
		"\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67"+
		"\3\67\3\67\3\67\3\67\3\67\3\67\3\67\38\68\u019e\n8\r8\168\u019f\39\69"+
		"\u01a3\n9\r9\169\u01a4\3:\6:\u01a8\n:\r:\16:\u01a9\3:\3:\6:\u01ae\n:\r"+
		":\16:\u01af\3;\6;\u01b3\n;\r;\16;\u01b4\3<\5<\u01b8\n<\3<\3<\3<\3<\3="+
		"\6=\u01bf\n=\r=\16=\u01c0\3=\3=\3>\3>\3>\3>\3>\5>\u01ca\n>\3?\3?\6?\u01ce"+
		"\n?\r?\16?\u01cf\3?\3?\3@\3@\6@\u01d6\n@\r@\16@\u01d7\3@\3@\3A\3A\6A\u01de"+
		"\nA\rA\16A\u01df\3A\3A\3B\3B\6B\u01e6\nB\rB\16B\u01e7\2\2C\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G"+
		"%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{"+
		"?}\2\177\2\u0081\2\u0083\2\3\2\b\5\2C\\aac|\5\2\13\f\17\17\"\"\3\2bb\3"+
		"\2))\3\2$$\7\2&&\62;C\\aac|\u01f7\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2"+
		"\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2"+
		"\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2"+
		"\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2"+
		"O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3"+
		"\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2"+
		"\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2"+
		"u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\3\u0085\3\2\2\2\5\u008c\3\2"+
		"\2\2\7\u0091\3\2\2\2\t\u0097\3\2\2\2\13\u009b\3\2\2\2\r\u00a4\3\2\2\2"+
		"\17\u00a9\3\2\2\2\21\u00b4\3\2\2\2\23\u00ba\3\2\2\2\25\u00bc\3\2\2\2\27"+
		"\u00bf\3\2\2\2\31\u00c4\3\2\2\2\33\u00c9\3\2\2\2\35\u00cc\3\2\2\2\37\u00d3"+
		"\3\2\2\2!\u00d7\3\2\2\2#\u00db\3\2\2\2%\u00e0\3\2\2\2\'\u00ea\3\2\2\2"+
		")\u00f0\3\2\2\2+\u00f2\3\2\2\2-\u00f4\3\2\2\2/\u00f6\3\2\2\2\61\u00f8"+
		"\3\2\2\2\63\u00fa\3\2\2\2\65\u00fc\3\2\2\2\67\u00fe\3\2\2\29\u0105\3\2"+
		"\2\2;\u010c\3\2\2\2=\u010e\3\2\2\2?\u0110\3\2\2\2A\u0112\3\2\2\2C\u0114"+
		"\3\2\2\2E\u0116\3\2\2\2G\u0118\3\2\2\2I\u011b\3\2\2\2K\u011d\3\2\2\2M"+
		"\u011f\3\2\2\2O\u0121\3\2\2\2Q\u0124\3\2\2\2S\u0128\3\2\2\2U\u012b\3\2"+
		"\2\2W\u012e\3\2\2\2Y\u0130\3\2\2\2[\u0132\3\2\2\2]\u0134\3\2\2\2_\u013c"+
		"\3\2\2\2a\u0142\3\2\2\2c\u0148\3\2\2\2e\u0150\3\2\2\2g\u015b\3\2\2\2i"+
		"\u016a\3\2\2\2k\u0177\3\2\2\2m\u0182\3\2\2\2o\u019d\3\2\2\2q\u01a2\3\2"+
		"\2\2s\u01a7\3\2\2\2u\u01b2\3\2\2\2w\u01b7\3\2\2\2y\u01be\3\2\2\2{\u01c4"+
		"\3\2\2\2}\u01cb\3\2\2\2\177\u01d3\3\2\2\2\u0081\u01db\3\2\2\2\u0083\u01e5"+
		"\3\2\2\2\u0085\u0086\7u\2\2\u0086\u0087\7g\2\2\u0087\u0088\7n\2\2\u0088"+
		"\u0089\7g\2\2\u0089\u008a\7e\2\2\u008a\u008b\7v\2\2\u008b\4\3\2\2\2\u008c"+
		"\u008d\7o\2\2\u008d\u008e\7k\2\2\u008e\u008f\7f\2\2\u008f\u0090\7k\2\2"+
		"\u0090\6\3\2\2\2\u0091\u0092\7u\2\2\u0092\u0093\7j\2\2\u0093\u0094\7g"+
		"\2\2\u0094\u0095\7g\2\2\u0095\u0096\7v\2\2\u0096\b\3\2\2\2\u0097\u0098"+
		"\7o\2\2\u0098\u0099\7r\2\2\u0099\u009a\7\65\2\2\u009a\n\3\2\2\2\u009b"+
		"\u009c\7o\2\2\u009c\u009d\7w\2\2\u009d\u009e\7u\2\2\u009e\u009f\7k\2\2"+
		"\u009f\u00a0\7e\2\2\u00a0\u00a1\7z\2\2\u00a1\u00a2\7o\2\2\u00a2\u00a3"+
		"\7n\2\2\u00a3\f\3\2\2\2\u00a4\u00a5\7h\2\2\u00a5\u00a6\7t\2\2\u00a6\u00a7"+
		"\7q\2\2\u00a7\u00a8\7o\2\2\u00a8\16\3\2\2\2\u00a9\u00aa\7y\2\2\u00aa\u00ab"+
		"\7j\2\2\u00ab\u00ac\7g\2\2\u00ac\u00ad\7t\2\2\u00ad\u00ae\7g\2\2\u00ae"+
		"\20\3\2\2\2\u00af\u00b0\7c\2\2\u00b0\u00b1\7p\2\2\u00b1\u00b5\7f\2\2\u00b2"+
		"\u00b3\7(\2\2\u00b3\u00b5\7(\2\2\u00b4\u00af\3\2\2\2\u00b4\u00b2\3\2\2"+
		"\2\u00b5\22\3\2\2\2\u00b6\u00b7\7q\2\2\u00b7\u00bb\7t\2\2\u00b8\u00b9"+
		"\7~\2\2\u00b9\u00bb\7~\2\2\u00ba\u00b6\3\2\2\2\u00ba\u00b8\3\2\2\2\u00bb"+
		"\24\3\2\2\2\u00bc\u00bd\7k\2\2\u00bd\u00be\7u\2\2\u00be\26\3\2\2\2\u00bf"+
		"\u00c0\7p\2\2\u00c0\u00c1\7w\2\2\u00c1\u00c2\7n\2\2\u00c2\u00c3\7n\2\2"+
		"\u00c3\30\3\2\2\2\u00c4\u00c5\7n\2\2\u00c5\u00c6\7k\2\2\u00c6\u00c7\7"+
		"m\2\2\u00c7\u00c8\7g\2\2\u00c8\32\3\2\2\2\u00c9\u00ca\7k\2\2\u00ca\u00cb"+
		"\7p\2\2\u00cb\34\3\2\2\2\u00cc\u00cd\7g\2\2\u00cd\u00ce\7z\2\2\u00ce\u00cf"+
		"\7k\2\2\u00cf\u00d0\7u\2\2\u00d0\u00d1\7v\2\2\u00d1\u00d2\7u\2\2\u00d2"+
		"\36\3\2\2\2\u00d3\u00d4\7c\2\2\u00d4\u00d5\7n\2\2\u00d5\u00d6\7n\2\2\u00d6"+
		" \3\2\2\2\u00d7\u00d8\7c\2\2\u00d8\u00d9\7p\2\2\u00d9\u00da\7{\2\2\u00da"+
		"\"\3\2\2\2\u00db\u00dc\7v\2\2\u00dc\u00dd\7t\2\2\u00dd\u00de\7w\2\2\u00de"+
		"\u00df\7g\2\2\u00df$\3\2\2\2\u00e0\u00e1\7h\2\2\u00e1\u00e2\7c\2\2\u00e2"+
		"\u00e3\7n\2\2\u00e3\u00e4\7u\2\2\u00e4\u00e5\7g\2\2\u00e5&\3\2\2\2\u00e6"+
		"\u00e7\7f\2\2\u00e7\u00e8\7k\2\2\u00e8\u00eb\7x\2\2\u00e9\u00eb\7\61\2"+
		"\2\u00ea\u00e6\3\2\2\2\u00ea\u00e9\3\2\2\2\u00eb(\3\2\2\2\u00ec\u00ed"+
		"\7o\2\2\u00ed\u00ee\7q\2\2\u00ee\u00f1\7f\2\2\u00ef\u00f1\7\'\2\2\u00f0"+
		"\u00ec\3\2\2\2\u00f0\u00ef\3\2\2\2\u00f1*\3\2\2\2\u00f2\u00f3\7-\2\2\u00f3"+
		",\3\2\2\2\u00f4\u00f5\7/\2\2\u00f5.\3\2\2\2\u00f6\u00f7\7\u0080\2\2\u00f7"+
		"\60\3\2\2\2\u00f8\u00f9\7~\2\2\u00f9\62\3\2\2\2\u00fa\u00fb\7(\2\2\u00fb"+
		"\64\3\2\2\2\u00fc\u00fd\7`\2\2\u00fd\66\3\2\2\2\u00fe\u00ff\7d\2\2\u00ff"+
		"\u0100\7k\2\2\u0100\u0101\7p\2\2\u0101\u0102\7c\2\2\u0102\u0103\7t\2\2"+
		"\u0103\u0104\7{\2\2\u01048\3\2\2\2\u0105\u0106\7g\2\2\u0106\u0107\7u\2"+
		"\2\u0107\u0108\7e\2\2\u0108\u0109\7c\2\2\u0109\u010a\7r\2\2\u010a\u010b"+
		"\7g\2\2\u010b:\3\2\2\2\u010c\u010d\7,\2\2\u010d<\3\2\2\2\u010e\u010f\7"+
		"+\2\2\u010f>\3\2\2\2\u0110\u0111\7*\2\2\u0111@\3\2\2\2\u0112\u0113\7_"+
		"\2\2\u0113B\3\2\2\2\u0114\u0115\7]\2\2\u0115D\3\2\2\2\u0116\u0117\7<\2"+
		"\2\u0117F\3\2\2\2\u0118\u0119\7\60\2\2\u0119\u011a\7,\2\2\u011aH\3\2\2"+
		"\2\u011b\u011c\7?\2\2\u011cJ\3\2\2\2\u011d\u011e\7>\2\2\u011eL\3\2\2\2"+
		"\u011f\u0120\7@\2\2\u0120N\3\2\2\2\u0121\u0122\7#\2\2\u0122\u0123\7?\2"+
		"\2\u0123P\3\2\2\2\u0124\u0125\7p\2\2\u0125\u0126\7q\2\2\u0126\u0127\7"+
		"v\2\2\u0127R\3\2\2\2\u0128\u0129\7>\2\2\u0129\u012a\7?\2\2\u012aT\3\2"+
		"\2\2\u012b\u012c\7@\2\2\u012c\u012d\7?\2\2\u012dV\3\2\2\2\u012e\u012f"+
		"\7=\2\2\u012fX\3\2\2\2\u0130\u0131\7.\2\2\u0131Z\3\2\2\2\u0132\u0133\7"+
		"\60\2\2\u0133\\\3\2\2\2\u0134\u0135\7e\2\2\u0135\u0136\7q\2\2\u0136\u0137"+
		"\7n\2\2\u0137\u0138\7n\2\2\u0138\u0139\7c\2\2\u0139\u013a\7v\2\2\u013a"+
		"\u013b\7g\2\2\u013b^\3\2\2\2\u013c\u013d\7w\2\2\u013d\u013e\7u\2\2\u013e"+
		"\u013f\7k\2\2\u013f\u0140\7p\2\2\u0140\u0141\7i\2\2\u0141`\3\2\2\2\u0142"+
		"\u0143\7k\2\2\u0143\u0144\7p\2\2\u0144\u0145\7f\2\2\u0145\u0146\7g\2\2"+
		"\u0146\u0147\7z\2\2\u0147b\3\2\2\2\u0148\u0149\7d\2\2\u0149\u014a\7g\2"+
		"\2\u014a\u014b\7v\2\2\u014b\u014c\7y\2\2\u014c\u014d\7g\2\2\u014d\u014e"+
		"\7g\2\2\u014e\u014f\7p\2\2\u014fd\3\2\2\2\u0150\u0151\7r\2\2\u0151\u0152"+
		"\7q\2\2\u0152\u0153\7n\2\2\u0153\u0154\7{\2\2\u0154\u0155\7r\2\2\u0155"+
		"\u0156\7j\2\2\u0156\u0157\7q\2\2\u0157\u0158\7p\2\2\u0158\u0159\7k\2\2"+
		"\u0159\u015a\7e\2\2\u015af\3\2\2\2\u015b\u015c\7j\2\2\u015c\u015d\7c\2"+
		"\2\u015d\u015e\7r\2\2\u015e\u015f\7r\2\2\u015f\u0160\7k\2\2\u0160\u0161"+
		"\7p\2\2\u0161\u0162\7g\2\2\u0162\u0163\7u\2\2\u0163\u0164\7u\2\2\u0164"+
		"\u0165\7k\2\2\u0165\u0166\7p\2\2\u0166\u0167\7f\2\2\u0167\u0168\7g\2\2"+
		"\u0168\u0169\7z\2\2\u0169h\3\2\2\2\u016a\u016b\7u\2\2\u016b\u016c\7c\2"+
		"\2\u016c\u016d\7f\2\2\u016d\u016e\7p\2\2\u016e\u016f\7g\2\2\u016f\u0170"+
		"\7u\2\2\u0170\u0171\7u\2\2\u0171\u0172\7k\2\2\u0172\u0173\7p\2\2\u0173"+
		"\u0174\7f\2\2\u0174\u0175\7g\2\2\u0175\u0176\7z\2\2\u0176j\3\2\2\2\u0177"+
		"\u0178\7r\2\2\u0178\u0179\7q\2\2\u0179\u017a\7y\2\2\u017a\u017b\7g\2\2"+
		"\u017b\u017c\7t\2\2\u017c\u017d\7k\2\2\u017d\u017e\7p\2\2\u017e\u017f"+
		"\7f\2\2\u017f\u0180\7g\2\2\u0180\u0181\7z\2\2\u0181l\3\2\2\2\u0182\u0183"+
		"\7o\2\2\u0183\u0184\7c\2\2\u0184\u0185\7z\2\2\u0185\u0186\7o\2\2\u0186"+
		"\u0187\7g\2\2\u0187\u0188\7n\2\2\u0188\u0189\7q\2\2\u0189\u018a\7f\2\2"+
		"\u018a\u018b\7k\2\2\u018b\u018c\7e\2\2\u018c\u018d\7t\2\2\u018d\u018e"+
		"\7g\2\2\u018e\u018f\7r\2\2\u018f\u0190\7g\2\2\u0190\u0191\7c\2\2\u0191"+
		"\u0192\7v\2\2\u0192\u0193\7k\2\2\u0193\u0194\7p\2\2\u0194\u0195\7i\2\2"+
		"\u0195\u0196\7h\2\2\u0196\u0197\7c\2\2\u0197\u0198\7e\2\2\u0198\u0199"+
		"\7v\2\2\u0199\u019a\7q\2\2\u019a\u019b\7t\2\2\u019bn\3\2\2\2\u019c\u019e"+
		"\t\2\2\2\u019d\u019c\3\2\2\2\u019e\u019f\3\2\2\2\u019f\u019d\3\2\2\2\u019f"+
		"\u01a0\3\2\2\2\u01a0p\3\2\2\2\u01a1\u01a3\4\62;\2\u01a2\u01a1\3\2\2\2"+
		"\u01a3\u01a4\3\2\2\2\u01a4\u01a2\3\2\2\2\u01a4\u01a5\3\2\2\2\u01a5r\3"+
		"\2\2\2\u01a6\u01a8\4\62;\2\u01a7\u01a6\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a9"+
		"\u01a7\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aa\u01ab\3\2\2\2\u01ab\u01ad\7\60"+
		"\2\2\u01ac\u01ae\4\62;\2\u01ad\u01ac\3\2\2\2\u01ae\u01af\3\2\2\2\u01af"+
		"\u01ad\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0t\3\2\2\2\u01b1\u01b3\t\2\2\2"+
		"\u01b2\u01b1\3\2\2\2\u01b3\u01b4\3\2\2\2\u01b4\u01b2\3\2\2\2\u01b4\u01b5"+
		"\3\2\2\2\u01b5v\3\2\2\2\u01b6\u01b8\7\17\2\2\u01b7\u01b6\3\2\2\2\u01b7"+
		"\u01b8\3\2\2\2\u01b8\u01b9\3\2\2\2\u01b9\u01ba\7\f\2\2\u01ba\u01bb\3\2"+
		"\2\2\u01bb\u01bc\b<\2\2\u01bcx\3\2\2\2\u01bd\u01bf\t\3\2\2\u01be\u01bd"+
		"\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0\u01be\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1"+
		"\u01c2\3\2\2\2\u01c2\u01c3\b=\2\2\u01c3z\3\2\2\2\u01c4\u01c9\7B\2\2\u01c5"+
		"\u01ca\5}?\2\u01c6\u01ca\5\177@\2\u01c7\u01ca\5\u0081A\2\u01c8\u01ca\5"+
		"\u0083B\2\u01c9\u01c5\3\2\2\2\u01c9\u01c6\3\2\2\2\u01c9\u01c7\3\2\2\2"+
		"\u01c9\u01c8\3\2\2\2\u01ca|\3\2\2\2\u01cb\u01cd\7b\2\2\u01cc\u01ce\n\4"+
		"\2\2\u01cd\u01cc\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf\u01cd\3\2\2\2\u01cf"+
		"\u01d0\3\2\2\2\u01d0\u01d1\3\2\2\2\u01d1\u01d2\7b\2\2\u01d2~\3\2\2\2\u01d3"+
		"\u01d5\7)\2\2\u01d4\u01d6\n\5\2\2\u01d5\u01d4\3\2\2\2\u01d6\u01d7\3\2"+
		"\2\2\u01d7\u01d5\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d8\u01d9\3\2\2\2\u01d9"+
		"\u01da\7)\2\2\u01da\u0080\3\2\2\2\u01db\u01dd\7$\2\2\u01dc\u01de\n\6\2"+
		"\2\u01dd\u01dc\3\2\2\2\u01de\u01df\3\2\2\2\u01df\u01dd\3\2\2\2\u01df\u01e0"+
		"\3\2\2\2\u01e0\u01e1\3\2\2\2\u01e1\u01e2\7$\2\2\u01e2\u0082\3\2\2\2\u01e3"+
		"\u01e6\t\7\2\2\u01e4\u01e6\5[.\2\u01e5\u01e3\3\2\2\2\u01e5\u01e4\3\2\2"+
		"\2\u01e6\u01e7\3\2\2\2\u01e7\u01e5\3\2\2\2\u01e7\u01e8\3\2\2\2\u01e8\u0084"+
		"\3\2\2\2\24\2\u00b4\u00ba\u00ea\u00f0\u019f\u01a4\u01a9\u01af\u01b4\u01b7"+
		"\u01c0\u01c9\u01cf\u01d7\u01df\u01e5\u01e7\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}