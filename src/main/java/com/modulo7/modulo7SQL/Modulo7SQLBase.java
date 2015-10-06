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
		SELECT=1, MIDI=2, SHEET=3, MP3=4, MUSICXML=5, PREPROCESS=6, NATURALCONTOUR=7, 
		STEINBECKCONTOUR=8, MULLENFESTEINCONTOUR=9, ON=10, FROM=11, WHERE=12, 
		AND=13, OR=14, IS=15, NULL=16, IN=17, TRUE=18, FALSE=19, DIVIDE=20, MOD=21, 
		PLUS=22, MINUS=23, NEGATION=24, VERTBAR=25, BITAND=26, POWER_OP=27, BINARY=28, 
		ESCAPE=29, ASTERISK=30, RPAREN=31, LPAREN=32, RBRACK=33, LBRACK=34, COLON=35, 
		ALL_FIELDS=36, EQ=37, LTH=38, GTH=39, NOT_EQ=40, NOT=41, LET=42, GET=43, 
		SEMI=44, COMMA=45, DOT=46, COLLATE=47, USING=48, INDEX=49, BETWEEN=50, 
		POLYPHONIC=51, HAPPINESSINDEX=52, SADNESSINDEX=53, POWERINDEX=54, MAXMELODICREPREATINGFACTOR=55, 
		ID=56, INT=57, DOUBLE=58, DATABASENAME=59, NEWLINE=60, WS=61, USER_VAR=62;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"SELECT", "MIDI", "SHEET", "MP3", "MUSICXML", "PREPROCESS", "NATURALCONTOUR", 
		"STEINBECKCONTOUR", "MULLENFESTEINCONTOUR", "ON", "FROM", "WHERE", "AND", 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2@\u021b\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3"+
		"\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\3\16\5\16\u00fb\n\16\3\17\3\17\3\17\3\17\5\17\u0101\n\17\3"+
		"\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3"+
		"\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\5\25\u011d"+
		"\n\25\3\26\3\26\3\26\3\26\5\26\u0123\n\26\3\27\3\27\3\30\3\30\3\31\3\31"+
		"\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$"+
		"\3$\3%\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3)\3*\3*\3*\3*\3+\3+\3+\3,\3,\3"+
		",\3-\3-\3.\3.\3/\3/\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\61\3\61"+
		"\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63"+
		"\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64"+
		"\3\64\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65"+
		"\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66"+
		"\3\66\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\38\38\38"+
		"\38\38\38\38\38\38\38\38\38\38\38\38\38\38\38\38\38\38\38\38\38\38\38"+
		"\39\69\u01d0\n9\r9\169\u01d1\3:\6:\u01d5\n:\r:\16:\u01d6\3;\6;\u01da\n"+
		";\r;\16;\u01db\3;\3;\6;\u01e0\n;\r;\16;\u01e1\3<\6<\u01e5\n<\r<\16<\u01e6"+
		"\3=\5=\u01ea\n=\3=\3=\3=\3=\3>\6>\u01f1\n>\r>\16>\u01f2\3>\3>\3?\3?\3"+
		"?\3?\3?\5?\u01fc\n?\3@\3@\6@\u0200\n@\r@\16@\u0201\3@\3@\3A\3A\6A\u0208"+
		"\nA\rA\16A\u0209\3A\3A\3B\3B\6B\u0210\nB\rB\16B\u0211\3B\3B\3C\3C\6C\u0218"+
		"\nC\rC\16C\u0219\2\2D\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
		"\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63"+
		"e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177\2\u0081\2\u0083\2\u0085\2\3\2\b"+
		"\5\2C\\aac|\5\2\13\f\17\17\"\"\3\2bb\3\2))\3\2$$\7\2&&\62;C\\aac|\u0229"+
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
		"{\3\2\2\2\2}\3\2\2\2\3\u0087\3\2\2\2\5\u008e\3\2\2\2\7\u0093\3\2\2\2\t"+
		"\u0099\3\2\2\2\13\u009d\3\2\2\2\r\u00a6\3\2\2\2\17\u00b1\3\2\2\2\21\u00c0"+
		"\3\2\2\2\23\u00d1\3\2\2\2\25\u00e7\3\2\2\2\27\u00ea\3\2\2\2\31\u00ef\3"+
		"\2\2\2\33\u00fa\3\2\2\2\35\u0100\3\2\2\2\37\u0102\3\2\2\2!\u0105\3\2\2"+
		"\2#\u010a\3\2\2\2%\u010d\3\2\2\2\'\u0112\3\2\2\2)\u011c\3\2\2\2+\u0122"+
		"\3\2\2\2-\u0124\3\2\2\2/\u0126\3\2\2\2\61\u0128\3\2\2\2\63\u012a\3\2\2"+
		"\2\65\u012c\3\2\2\2\67\u012e\3\2\2\29\u0130\3\2\2\2;\u0137\3\2\2\2=\u013e"+
		"\3\2\2\2?\u0140\3\2\2\2A\u0142\3\2\2\2C\u0144\3\2\2\2E\u0146\3\2\2\2G"+
		"\u0148\3\2\2\2I\u014a\3\2\2\2K\u014d\3\2\2\2M\u014f\3\2\2\2O\u0151\3\2"+
		"\2\2Q\u0153\3\2\2\2S\u0156\3\2\2\2U\u015a\3\2\2\2W\u015d\3\2\2\2Y\u0160"+
		"\3\2\2\2[\u0162\3\2\2\2]\u0164\3\2\2\2_\u0166\3\2\2\2a\u016e\3\2\2\2c"+
		"\u0174\3\2\2\2e\u017a\3\2\2\2g\u0182\3\2\2\2i\u018d\3\2\2\2k\u019c\3\2"+
		"\2\2m\u01a9\3\2\2\2o\u01b4\3\2\2\2q\u01cf\3\2\2\2s\u01d4\3\2\2\2u\u01d9"+
		"\3\2\2\2w\u01e4\3\2\2\2y\u01e9\3\2\2\2{\u01f0\3\2\2\2}\u01f6\3\2\2\2\177"+
		"\u01fd\3\2\2\2\u0081\u0205\3\2\2\2\u0083\u020d\3\2\2\2\u0085\u0217\3\2"+
		"\2\2\u0087\u0088\7u\2\2\u0088\u0089\7g\2\2\u0089\u008a\7n\2\2\u008a\u008b"+
		"\7g\2\2\u008b\u008c\7e\2\2\u008c\u008d\7v\2\2\u008d\4\3\2\2\2\u008e\u008f"+
		"\7o\2\2\u008f\u0090\7k\2\2\u0090\u0091\7f\2\2\u0091\u0092\7k\2\2\u0092"+
		"\6\3\2\2\2\u0093\u0094\7u\2\2\u0094\u0095\7j\2\2\u0095\u0096\7g\2\2\u0096"+
		"\u0097\7g\2\2\u0097\u0098\7v\2\2\u0098\b\3\2\2\2\u0099\u009a\7o\2\2\u009a"+
		"\u009b\7r\2\2\u009b\u009c\7\65\2\2\u009c\n\3\2\2\2\u009d\u009e\7o\2\2"+
		"\u009e\u009f\7w\2\2\u009f\u00a0\7u\2\2\u00a0\u00a1\7k\2\2\u00a1\u00a2"+
		"\7e\2\2\u00a2\u00a3\7z\2\2\u00a3\u00a4\7o\2\2\u00a4\u00a5\7n\2\2\u00a5"+
		"\f\3\2\2\2\u00a6\u00a7\7r\2\2\u00a7\u00a8\7t\2\2\u00a8\u00a9\7g\2\2\u00a9"+
		"\u00aa\7r\2\2\u00aa\u00ab\7t\2\2\u00ab\u00ac\7q\2\2\u00ac\u00ad\7e\2\2"+
		"\u00ad\u00ae\7g\2\2\u00ae\u00af\7u\2\2\u00af\u00b0\7u\2\2\u00b0\16\3\2"+
		"\2\2\u00b1\u00b2\7p\2\2\u00b2\u00b3\7c\2\2\u00b3\u00b4\7v\2\2\u00b4\u00b5"+
		"\7w\2\2\u00b5\u00b6\7t\2\2\u00b6\u00b7\7c\2\2\u00b7\u00b8\7n\2\2\u00b8"+
		"\u00b9\7e\2\2\u00b9\u00ba\7q\2\2\u00ba\u00bb\7p\2\2\u00bb\u00bc\7v\2\2"+
		"\u00bc\u00bd\7q\2\2\u00bd\u00be\7w\2\2\u00be\u00bf\7t\2\2\u00bf\20\3\2"+
		"\2\2\u00c0\u00c1\7u\2\2\u00c1\u00c2\7v\2\2\u00c2\u00c3\7g\2\2\u00c3\u00c4"+
		"\7k\2\2\u00c4\u00c5\7p\2\2\u00c5\u00c6\7d\2\2\u00c6\u00c7\7g\2\2\u00c7"+
		"\u00c8\7e\2\2\u00c8\u00c9\7m\2\2\u00c9\u00ca\7e\2\2\u00ca\u00cb\7q\2\2"+
		"\u00cb\u00cc\7p\2\2\u00cc\u00cd\7v\2\2\u00cd\u00ce\7q\2\2\u00ce\u00cf"+
		"\7w\2\2\u00cf\u00d0\7t\2\2\u00d0\22\3\2\2\2\u00d1\u00d2\7\"\2\2\u00d2"+
		"\u00d3\7o\2\2\u00d3\u00d4\7w\2\2\u00d4\u00d5\7n\2\2\u00d5\u00d6\7n\2\2"+
		"\u00d6\u00d7\7g\2\2\u00d7\u00d8\7p\2\2\u00d8\u00d9\7h\2\2\u00d9\u00da"+
		"\7g\2\2\u00da\u00db\7u\2\2\u00db\u00dc\7v\2\2\u00dc\u00dd\7g\2\2\u00dd"+
		"\u00de\7k\2\2\u00de\u00df\7p\2\2\u00df\u00e0\7e\2\2\u00e0\u00e1\7q\2\2"+
		"\u00e1\u00e2\7p\2\2\u00e2\u00e3\7v\2\2\u00e3\u00e4\7q\2\2\u00e4\u00e5"+
		"\7w\2\2\u00e5\u00e6\7t\2\2\u00e6\24\3\2\2\2\u00e7\u00e8\7q\2\2\u00e8\u00e9"+
		"\7p\2\2\u00e9\26\3\2\2\2\u00ea\u00eb\7h\2\2\u00eb\u00ec\7t\2\2\u00ec\u00ed"+
		"\7q\2\2\u00ed\u00ee\7o\2\2\u00ee\30\3\2\2\2\u00ef\u00f0\7y\2\2\u00f0\u00f1"+
		"\7j\2\2\u00f1\u00f2\7g\2\2\u00f2\u00f3\7t\2\2\u00f3\u00f4\7g\2\2\u00f4"+
		"\32\3\2\2\2\u00f5\u00f6\7c\2\2\u00f6\u00f7\7p\2\2\u00f7\u00fb\7f\2\2\u00f8"+
		"\u00f9\7(\2\2\u00f9\u00fb\7(\2\2\u00fa\u00f5\3\2\2\2\u00fa\u00f8\3\2\2"+
		"\2\u00fb\34\3\2\2\2\u00fc\u00fd\7q\2\2\u00fd\u0101\7t\2\2\u00fe\u00ff"+
		"\7~\2\2\u00ff\u0101\7~\2\2\u0100\u00fc\3\2\2\2\u0100\u00fe\3\2\2\2\u0101"+
		"\36\3\2\2\2\u0102\u0103\7k\2\2\u0103\u0104\7u\2\2\u0104 \3\2\2\2\u0105"+
		"\u0106\7p\2\2\u0106\u0107\7w\2\2\u0107\u0108\7n\2\2\u0108\u0109\7n\2\2"+
		"\u0109\"\3\2\2\2\u010a\u010b\7k\2\2\u010b\u010c\7p\2\2\u010c$\3\2\2\2"+
		"\u010d\u010e\7v\2\2\u010e\u010f\7t\2\2\u010f\u0110\7w\2\2\u0110\u0111"+
		"\7g\2\2\u0111&\3\2\2\2\u0112\u0113\7h\2\2\u0113\u0114\7c\2\2\u0114\u0115"+
		"\7n\2\2\u0115\u0116\7u\2\2\u0116\u0117\7g\2\2\u0117(\3\2\2\2\u0118\u0119"+
		"\7f\2\2\u0119\u011a\7k\2\2\u011a\u011d\7x\2\2\u011b\u011d\7\61\2\2\u011c"+
		"\u0118\3\2\2\2\u011c\u011b\3\2\2\2\u011d*\3\2\2\2\u011e\u011f\7o\2\2\u011f"+
		"\u0120\7q\2\2\u0120\u0123\7f\2\2\u0121\u0123\7\'\2\2\u0122\u011e\3\2\2"+
		"\2\u0122\u0121\3\2\2\2\u0123,\3\2\2\2\u0124\u0125\7-\2\2\u0125.\3\2\2"+
		"\2\u0126\u0127\7/\2\2\u0127\60\3\2\2\2\u0128\u0129\7\u0080\2\2\u0129\62"+
		"\3\2\2\2\u012a\u012b\7~\2\2\u012b\64\3\2\2\2\u012c\u012d\7(\2\2\u012d"+
		"\66\3\2\2\2\u012e\u012f\7`\2\2\u012f8\3\2\2\2\u0130\u0131\7d\2\2\u0131"+
		"\u0132\7k\2\2\u0132\u0133\7p\2\2\u0133\u0134\7c\2\2\u0134\u0135\7t\2\2"+
		"\u0135\u0136\7{\2\2\u0136:\3\2\2\2\u0137\u0138\7g\2\2\u0138\u0139\7u\2"+
		"\2\u0139\u013a\7e\2\2\u013a\u013b\7c\2\2\u013b\u013c\7r\2\2\u013c\u013d"+
		"\7g\2\2\u013d<\3\2\2\2\u013e\u013f\7,\2\2\u013f>\3\2\2\2\u0140\u0141\7"+
		"+\2\2\u0141@\3\2\2\2\u0142\u0143\7*\2\2\u0143B\3\2\2\2\u0144\u0145\7_"+
		"\2\2\u0145D\3\2\2\2\u0146\u0147\7]\2\2\u0147F\3\2\2\2\u0148\u0149\7<\2"+
		"\2\u0149H\3\2\2\2\u014a\u014b\7\60\2\2\u014b\u014c\7,\2\2\u014cJ\3\2\2"+
		"\2\u014d\u014e\7?\2\2\u014eL\3\2\2\2\u014f\u0150\7>\2\2\u0150N\3\2\2\2"+
		"\u0151\u0152\7@\2\2\u0152P\3\2\2\2\u0153\u0154\7#\2\2\u0154\u0155\7?\2"+
		"\2\u0155R\3\2\2\2\u0156\u0157\7p\2\2\u0157\u0158\7q\2\2\u0158\u0159\7"+
		"v\2\2\u0159T\3\2\2\2\u015a\u015b\7>\2\2\u015b\u015c\7?\2\2\u015cV\3\2"+
		"\2\2\u015d\u015e\7@\2\2\u015e\u015f\7?\2\2\u015fX\3\2\2\2\u0160\u0161"+
		"\7=\2\2\u0161Z\3\2\2\2\u0162\u0163\7.\2\2\u0163\\\3\2\2\2\u0164\u0165"+
		"\7\60\2\2\u0165^\3\2\2\2\u0166\u0167\7e\2\2\u0167\u0168\7q\2\2\u0168\u0169"+
		"\7n\2\2\u0169\u016a\7n\2\2\u016a\u016b\7c\2\2\u016b\u016c\7v\2\2\u016c"+
		"\u016d\7g\2\2\u016d`\3\2\2\2\u016e\u016f\7w\2\2\u016f\u0170\7u\2\2\u0170"+
		"\u0171\7k\2\2\u0171\u0172\7p\2\2\u0172\u0173\7i\2\2\u0173b\3\2\2\2\u0174"+
		"\u0175\7k\2\2\u0175\u0176\7p\2\2\u0176\u0177\7f\2\2\u0177\u0178\7g\2\2"+
		"\u0178\u0179\7z\2\2\u0179d\3\2\2\2\u017a\u017b\7d\2\2\u017b\u017c\7g\2"+
		"\2\u017c\u017d\7v\2\2\u017d\u017e\7y\2\2\u017e\u017f\7g\2\2\u017f\u0180"+
		"\7g\2\2\u0180\u0181\7p\2\2\u0181f\3\2\2\2\u0182\u0183\7r\2\2\u0183\u0184"+
		"\7q\2\2\u0184\u0185\7n\2\2\u0185\u0186\7{\2\2\u0186\u0187\7r\2\2\u0187"+
		"\u0188\7j\2\2\u0188\u0189\7q\2\2\u0189\u018a\7p\2\2\u018a\u018b\7k\2\2"+
		"\u018b\u018c\7e\2\2\u018ch\3\2\2\2\u018d\u018e\7j\2\2\u018e\u018f\7c\2"+
		"\2\u018f\u0190\7r\2\2\u0190\u0191\7r\2\2\u0191\u0192\7k\2\2\u0192\u0193"+
		"\7p\2\2\u0193\u0194\7g\2\2\u0194\u0195\7u\2\2\u0195\u0196\7u\2\2\u0196"+
		"\u0197\7k\2\2\u0197\u0198\7p\2\2\u0198\u0199\7f\2\2\u0199\u019a\7g\2\2"+
		"\u019a\u019b\7z\2\2\u019bj\3\2\2\2\u019c\u019d\7u\2\2\u019d\u019e\7c\2"+
		"\2\u019e\u019f\7f\2\2\u019f\u01a0\7p\2\2\u01a0\u01a1\7g\2\2\u01a1\u01a2"+
		"\7u\2\2\u01a2\u01a3\7u\2\2\u01a3\u01a4\7k\2\2\u01a4\u01a5\7p\2\2\u01a5"+
		"\u01a6\7f\2\2\u01a6\u01a7\7g\2\2\u01a7\u01a8\7z\2\2\u01a8l\3\2\2\2\u01a9"+
		"\u01aa\7r\2\2\u01aa\u01ab\7q\2\2\u01ab\u01ac\7y\2\2\u01ac\u01ad\7g\2\2"+
		"\u01ad\u01ae\7t\2\2\u01ae\u01af\7k\2\2\u01af\u01b0\7p\2\2\u01b0\u01b1"+
		"\7f\2\2\u01b1\u01b2\7g\2\2\u01b2\u01b3\7z\2\2\u01b3n\3\2\2\2\u01b4\u01b5"+
		"\7o\2\2\u01b5\u01b6\7c\2\2\u01b6\u01b7\7z\2\2\u01b7\u01b8\7o\2\2\u01b8"+
		"\u01b9\7g\2\2\u01b9\u01ba\7n\2\2\u01ba\u01bb\7q\2\2\u01bb\u01bc\7f\2\2"+
		"\u01bc\u01bd\7k\2\2\u01bd\u01be\7e\2\2\u01be\u01bf\7t\2\2\u01bf\u01c0"+
		"\7g\2\2\u01c0\u01c1\7r\2\2\u01c1\u01c2\7g\2\2\u01c2\u01c3\7c\2\2\u01c3"+
		"\u01c4\7v\2\2\u01c4\u01c5\7k\2\2\u01c5\u01c6\7p\2\2\u01c6\u01c7\7i\2\2"+
		"\u01c7\u01c8\7h\2\2\u01c8\u01c9\7c\2\2\u01c9\u01ca\7e\2\2\u01ca\u01cb"+
		"\7v\2\2\u01cb\u01cc\7q\2\2\u01cc\u01cd\7t\2\2\u01cdp\3\2\2\2\u01ce\u01d0"+
		"\t\2\2\2\u01cf\u01ce\3\2\2\2\u01d0\u01d1\3\2\2\2\u01d1\u01cf\3\2\2\2\u01d1"+
		"\u01d2\3\2\2\2\u01d2r\3\2\2\2\u01d3\u01d5\4\62;\2\u01d4\u01d3\3\2\2\2"+
		"\u01d5\u01d6\3\2\2\2\u01d6\u01d4\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7t\3"+
		"\2\2\2\u01d8\u01da\4\62;\2\u01d9\u01d8\3\2\2\2\u01da\u01db\3\2\2\2\u01db"+
		"\u01d9\3\2\2\2\u01db\u01dc\3\2\2\2\u01dc\u01dd\3\2\2\2\u01dd\u01df\7\60"+
		"\2\2\u01de\u01e0\4\62;\2\u01df\u01de\3\2\2\2\u01e0\u01e1\3\2\2\2\u01e1"+
		"\u01df\3\2\2\2\u01e1\u01e2\3\2\2\2\u01e2v\3\2\2\2\u01e3\u01e5\t\2\2\2"+
		"\u01e4\u01e3\3\2\2\2\u01e5\u01e6\3\2\2\2\u01e6\u01e4\3\2\2\2\u01e6\u01e7"+
		"\3\2\2\2\u01e7x\3\2\2\2\u01e8\u01ea\7\17\2\2\u01e9\u01e8\3\2\2\2\u01e9"+
		"\u01ea\3\2\2\2\u01ea\u01eb\3\2\2\2\u01eb\u01ec\7\f\2\2\u01ec\u01ed\3\2"+
		"\2\2\u01ed\u01ee\b=\2\2\u01eez\3\2\2\2\u01ef\u01f1\t\3\2\2\u01f0\u01ef"+
		"\3\2\2\2\u01f1\u01f2\3\2\2\2\u01f2\u01f0\3\2\2\2\u01f2\u01f3\3\2\2\2\u01f3"+
		"\u01f4\3\2\2\2\u01f4\u01f5\b>\2\2\u01f5|\3\2\2\2\u01f6\u01fb\7B\2\2\u01f7"+
		"\u01fc\5\177@\2\u01f8\u01fc\5\u0081A\2\u01f9\u01fc\5\u0083B\2\u01fa\u01fc"+
		"\5\u0085C\2\u01fb\u01f7\3\2\2\2\u01fb\u01f8\3\2\2\2\u01fb\u01f9\3\2\2"+
		"\2\u01fb\u01fa\3\2\2\2\u01fc~\3\2\2\2\u01fd\u01ff\7b\2\2\u01fe\u0200\n"+
		"\4\2\2\u01ff\u01fe\3\2\2\2\u0200\u0201\3\2\2\2\u0201\u01ff\3\2\2\2\u0201"+
		"\u0202\3\2\2\2\u0202\u0203\3\2\2\2\u0203\u0204\7b\2\2\u0204\u0080\3\2"+
		"\2\2\u0205\u0207\7)\2\2\u0206\u0208\n\5\2\2\u0207\u0206\3\2\2\2\u0208"+
		"\u0209\3\2\2\2\u0209\u0207\3\2\2\2\u0209\u020a\3\2\2\2\u020a\u020b\3\2"+
		"\2\2\u020b\u020c\7)\2\2\u020c\u0082\3\2\2\2\u020d\u020f\7$\2\2\u020e\u0210"+
		"\n\6\2\2\u020f\u020e\3\2\2\2\u0210\u0211\3\2\2\2\u0211\u020f\3\2\2\2\u0211"+
		"\u0212\3\2\2\2\u0212\u0213\3\2\2\2\u0213\u0214\7$\2\2\u0214\u0084\3\2"+
		"\2\2\u0215\u0218\t\7\2\2\u0216\u0218\5]/\2\u0217\u0215\3\2\2\2\u0217\u0216"+
		"\3\2\2\2\u0218\u0219\3\2\2\2\u0219\u0217\3\2\2\2\u0219\u021a\3\2\2\2\u021a"+
		"\u0086\3\2\2\2\24\2\u00fa\u0100\u011c\u0122\u01d1\u01d6\u01db\u01e1\u01e6"+
		"\u01e9\u01f2\u01fb\u0201\u0209\u0211\u0217\u0219\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}