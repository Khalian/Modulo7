// Generated from Modulo7SQLBase.g4 by ANTLR 4.5.1

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
		SELECT=1, MIDI=2, SHEET=3, MP3=4, MUSICXML=5, ON=6, FROM=7, WHERE=8, AND=9, 
		OR=10, IS=11, NULL=12, IN=13, TRUE=14, FALSE=15, DIVIDE=16, MOD=17, PLUS=18, 
		MINUS=19, NEGATION=20, VERTBAR=21, BITAND=22, POWER_OP=23, BINARY=24, 
		ESCAPE=25, ASTERISK=26, RPAREN=27, LPAREN=28, RBRACK=29, LBRACK=30, COLON=31, 
		ALL_FIELDS=32, EQ=33, LTH=34, GTH=35, NOT_EQ=36, NOT=37, LET=38, GET=39, 
		SEMI=40, COMMA=41, DOT=42, COLLATE=43, USING=44, INDEX=45, BETWEEN=46, 
		POLYPHONIC=47, HAPPINESSINDEX=48, SADNESSINDEX=49, POWERINDEX=50, MAXMELODICREPREATINGFACTOR=51, 
		ID=52, INT=53, DOUBLE=54, DATABASENAME=55, NEWLINE=56, WS=57, USER_VAR=58;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"SELECT", "MIDI", "SHEET", "MP3", "MUSICXML", "ON", "FROM", "WHERE", "AND", 
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
		null, "'select'", "'midi'", "'sheet'", "'mp3'", "'musicxml'", "'on'", 
		"'from'", "'where'", null, null, "'is'", "'null'", "'in'", "'true'", "'false'", 
		null, null, "'+'", "'-'", "'~'", "'|'", "'&'", "'^'", "'binary'", "'escape'", 
		"'*'", "')'", "'('", "']'", "'['", "':'", "'.*'", "'='", "'<'", "'>'", 
		"'!='", "'not'", "'<='", "'>='", "';'", "','", "'.'", "'collate'", "'using'", 
		"'index'", "'between'", "'polyphonic'", "'happinessindex'", "'sadnessindex'", 
		"'powerindex'", "'maxmelodicrepeatingfactor'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "SELECT", "MIDI", "SHEET", "MP3", "MUSICXML", "ON", "FROM", "WHERE", 
		"AND", "OR", "IS", "NULL", "IN", "TRUE", "FALSE", "DIVIDE", "MOD", "PLUS", 
		"MINUS", "NEGATION", "VERTBAR", "BITAND", "POWER_OP", "BINARY", "ESCAPE", 
		"ASTERISK", "RPAREN", "LPAREN", "RBRACK", "LBRACK", "COLON", "ALL_FIELDS", 
		"EQ", "LTH", "GTH", "NOT_EQ", "NOT", "LET", "GET", "SEMI", "COMMA", "DOT", 
		"COLLATE", "USING", "INDEX", "BETWEEN", "POLYPHONIC", "HAPPINESSINDEX", 
		"SADNESSINDEX", "POWERINDEX", "MAXMELODICREPREATINGFACTOR", "ID", "INT", 
		"DOUBLE", "DATABASENAME", "NEWLINE", "WS", "USER_VAR"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2<\u01d2\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7"+
		"\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3"+
		"\n\5\n\u00b2\n\n\3\13\3\13\3\13\3\13\5\13\u00b8\n\13\3\f\3\f\3\f\3\r\3"+
		"\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\21\5\21\u00d4\n\21\3\22\3\22\3\22\3\22"+
		"\5\22\u00da\n\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30"+
		"\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3"+
		"!\3\"\3\"\3#\3#\3$\3$\3%\3%\3%\3&\3&\3&\3&\3\'\3\'\3\'\3(\3(\3(\3)\3)"+
		"\3*\3*\3+\3+\3,\3,\3,\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-\3-\3.\3.\3.\3.\3."+
		"\3.\3/\3/\3/\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3"+
		"\60\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3"+
		"\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3"+
		"\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3"+
		"\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3"+
		"\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\65\6\65\u0187"+
		"\n\65\r\65\16\65\u0188\3\66\6\66\u018c\n\66\r\66\16\66\u018d\3\67\6\67"+
		"\u0191\n\67\r\67\16\67\u0192\3\67\3\67\6\67\u0197\n\67\r\67\16\67\u0198"+
		"\38\68\u019c\n8\r8\168\u019d\39\59\u01a1\n9\39\39\39\39\3:\6:\u01a8\n"+
		":\r:\16:\u01a9\3:\3:\3;\3;\3;\3;\3;\5;\u01b3\n;\3<\3<\6<\u01b7\n<\r<\16"+
		"<\u01b8\3<\3<\3=\3=\6=\u01bf\n=\r=\16=\u01c0\3=\3=\3>\3>\6>\u01c7\n>\r"+
		">\16>\u01c8\3>\3>\3?\3?\6?\u01cf\n?\r?\16?\u01d0\2\2@\3\3\5\4\7\5\t\6"+
		"\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24"+
		"\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K"+
		"\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w\2y\2{\2"+
		"}\2\3\2\b\5\2C\\aac|\5\2\13\f\17\17\"\"\3\2bb\3\2))\3\2$$\7\2&&\62;C\\"+
		"aac|\u01e0\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2"+
		"\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S"+
		"\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2"+
		"\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2"+
		"\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\3\177\3\2\2\2"+
		"\5\u0086\3\2\2\2\7\u008b\3\2\2\2\t\u0091\3\2\2\2\13\u0095\3\2\2\2\r\u009e"+
		"\3\2\2\2\17\u00a1\3\2\2\2\21\u00a6\3\2\2\2\23\u00b1\3\2\2\2\25\u00b7\3"+
		"\2\2\2\27\u00b9\3\2\2\2\31\u00bc\3\2\2\2\33\u00c1\3\2\2\2\35\u00c4\3\2"+
		"\2\2\37\u00c9\3\2\2\2!\u00d3\3\2\2\2#\u00d9\3\2\2\2%\u00db\3\2\2\2\'\u00dd"+
		"\3\2\2\2)\u00df\3\2\2\2+\u00e1\3\2\2\2-\u00e3\3\2\2\2/\u00e5\3\2\2\2\61"+
		"\u00e7\3\2\2\2\63\u00ee\3\2\2\2\65\u00f5\3\2\2\2\67\u00f7\3\2\2\29\u00f9"+
		"\3\2\2\2;\u00fb\3\2\2\2=\u00fd\3\2\2\2?\u00ff\3\2\2\2A\u0101\3\2\2\2C"+
		"\u0104\3\2\2\2E\u0106\3\2\2\2G\u0108\3\2\2\2I\u010a\3\2\2\2K\u010d\3\2"+
		"\2\2M\u0111\3\2\2\2O\u0114\3\2\2\2Q\u0117\3\2\2\2S\u0119\3\2\2\2U\u011b"+
		"\3\2\2\2W\u011d\3\2\2\2Y\u0125\3\2\2\2[\u012b\3\2\2\2]\u0131\3\2\2\2_"+
		"\u0139\3\2\2\2a\u0144\3\2\2\2c\u0153\3\2\2\2e\u0160\3\2\2\2g\u016b\3\2"+
		"\2\2i\u0186\3\2\2\2k\u018b\3\2\2\2m\u0190\3\2\2\2o\u019b\3\2\2\2q\u01a0"+
		"\3\2\2\2s\u01a7\3\2\2\2u\u01ad\3\2\2\2w\u01b4\3\2\2\2y\u01bc\3\2\2\2{"+
		"\u01c4\3\2\2\2}\u01ce\3\2\2\2\177\u0080\7u\2\2\u0080\u0081\7g\2\2\u0081"+
		"\u0082\7n\2\2\u0082\u0083\7g\2\2\u0083\u0084\7e\2\2\u0084\u0085\7v\2\2"+
		"\u0085\4\3\2\2\2\u0086\u0087\7o\2\2\u0087\u0088\7k\2\2\u0088\u0089\7f"+
		"\2\2\u0089\u008a\7k\2\2\u008a\6\3\2\2\2\u008b\u008c\7u\2\2\u008c\u008d"+
		"\7j\2\2\u008d\u008e\7g\2\2\u008e\u008f\7g\2\2\u008f\u0090\7v\2\2\u0090"+
		"\b\3\2\2\2\u0091\u0092\7o\2\2\u0092\u0093\7r\2\2\u0093\u0094\7\65\2\2"+
		"\u0094\n\3\2\2\2\u0095\u0096\7o\2\2\u0096\u0097\7w\2\2\u0097\u0098\7u"+
		"\2\2\u0098\u0099\7k\2\2\u0099\u009a\7e\2\2\u009a\u009b\7z\2\2\u009b\u009c"+
		"\7o\2\2\u009c\u009d\7n\2\2\u009d\f\3\2\2\2\u009e\u009f\7q\2\2\u009f\u00a0"+
		"\7p\2\2\u00a0\16\3\2\2\2\u00a1\u00a2\7h\2\2\u00a2\u00a3\7t\2\2\u00a3\u00a4"+
		"\7q\2\2\u00a4\u00a5\7o\2\2\u00a5\20\3\2\2\2\u00a6\u00a7\7y\2\2\u00a7\u00a8"+
		"\7j\2\2\u00a8\u00a9\7g\2\2\u00a9\u00aa\7t\2\2\u00aa\u00ab\7g\2\2\u00ab"+
		"\22\3\2\2\2\u00ac\u00ad\7c\2\2\u00ad\u00ae\7p\2\2\u00ae\u00b2\7f\2\2\u00af"+
		"\u00b0\7(\2\2\u00b0\u00b2\7(\2\2\u00b1\u00ac\3\2\2\2\u00b1\u00af\3\2\2"+
		"\2\u00b2\24\3\2\2\2\u00b3\u00b4\7q\2\2\u00b4\u00b8\7t\2\2\u00b5\u00b6"+
		"\7~\2\2\u00b6\u00b8\7~\2\2\u00b7\u00b3\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8"+
		"\26\3\2\2\2\u00b9\u00ba\7k\2\2\u00ba\u00bb\7u\2\2\u00bb\30\3\2\2\2\u00bc"+
		"\u00bd\7p\2\2\u00bd\u00be\7w\2\2\u00be\u00bf\7n\2\2\u00bf\u00c0\7n\2\2"+
		"\u00c0\32\3\2\2\2\u00c1\u00c2\7k\2\2\u00c2\u00c3\7p\2\2\u00c3\34\3\2\2"+
		"\2\u00c4\u00c5\7v\2\2\u00c5\u00c6\7t\2\2\u00c6\u00c7\7w\2\2\u00c7\u00c8"+
		"\7g\2\2\u00c8\36\3\2\2\2\u00c9\u00ca\7h\2\2\u00ca\u00cb\7c\2\2\u00cb\u00cc"+
		"\7n\2\2\u00cc\u00cd\7u\2\2\u00cd\u00ce\7g\2\2\u00ce \3\2\2\2\u00cf\u00d0"+
		"\7f\2\2\u00d0\u00d1\7k\2\2\u00d1\u00d4\7x\2\2\u00d2\u00d4\7\61\2\2\u00d3"+
		"\u00cf\3\2\2\2\u00d3\u00d2\3\2\2\2\u00d4\"\3\2\2\2\u00d5\u00d6\7o\2\2"+
		"\u00d6\u00d7\7q\2\2\u00d7\u00da\7f\2\2\u00d8\u00da\7\'\2\2\u00d9\u00d5"+
		"\3\2\2\2\u00d9\u00d8\3\2\2\2\u00da$\3\2\2\2\u00db\u00dc\7-\2\2\u00dc&"+
		"\3\2\2\2\u00dd\u00de\7/\2\2\u00de(\3\2\2\2\u00df\u00e0\7\u0080\2\2\u00e0"+
		"*\3\2\2\2\u00e1\u00e2\7~\2\2\u00e2,\3\2\2\2\u00e3\u00e4\7(\2\2\u00e4."+
		"\3\2\2\2\u00e5\u00e6\7`\2\2\u00e6\60\3\2\2\2\u00e7\u00e8\7d\2\2\u00e8"+
		"\u00e9\7k\2\2\u00e9\u00ea\7p\2\2\u00ea\u00eb\7c\2\2\u00eb\u00ec\7t\2\2"+
		"\u00ec\u00ed\7{\2\2\u00ed\62\3\2\2\2\u00ee\u00ef\7g\2\2\u00ef\u00f0\7"+
		"u\2\2\u00f0\u00f1\7e\2\2\u00f1\u00f2\7c\2\2\u00f2\u00f3\7r\2\2\u00f3\u00f4"+
		"\7g\2\2\u00f4\64\3\2\2\2\u00f5\u00f6\7,\2\2\u00f6\66\3\2\2\2\u00f7\u00f8"+
		"\7+\2\2\u00f88\3\2\2\2\u00f9\u00fa\7*\2\2\u00fa:\3\2\2\2\u00fb\u00fc\7"+
		"_\2\2\u00fc<\3\2\2\2\u00fd\u00fe\7]\2\2\u00fe>\3\2\2\2\u00ff\u0100\7<"+
		"\2\2\u0100@\3\2\2\2\u0101\u0102\7\60\2\2\u0102\u0103\7,\2\2\u0103B\3\2"+
		"\2\2\u0104\u0105\7?\2\2\u0105D\3\2\2\2\u0106\u0107\7>\2\2\u0107F\3\2\2"+
		"\2\u0108\u0109\7@\2\2\u0109H\3\2\2\2\u010a\u010b\7#\2\2\u010b\u010c\7"+
		"?\2\2\u010cJ\3\2\2\2\u010d\u010e\7p\2\2\u010e\u010f\7q\2\2\u010f\u0110"+
		"\7v\2\2\u0110L\3\2\2\2\u0111\u0112\7>\2\2\u0112\u0113\7?\2\2\u0113N\3"+
		"\2\2\2\u0114\u0115\7@\2\2\u0115\u0116\7?\2\2\u0116P\3\2\2\2\u0117\u0118"+
		"\7=\2\2\u0118R\3\2\2\2\u0119\u011a\7.\2\2\u011aT\3\2\2\2\u011b\u011c\7"+
		"\60\2\2\u011cV\3\2\2\2\u011d\u011e\7e\2\2\u011e\u011f\7q\2\2\u011f\u0120"+
		"\7n\2\2\u0120\u0121\7n\2\2\u0121\u0122\7c\2\2\u0122\u0123\7v\2\2\u0123"+
		"\u0124\7g\2\2\u0124X\3\2\2\2\u0125\u0126\7w\2\2\u0126\u0127\7u\2\2\u0127"+
		"\u0128\7k\2\2\u0128\u0129\7p\2\2\u0129\u012a\7i\2\2\u012aZ\3\2\2\2\u012b"+
		"\u012c\7k\2\2\u012c\u012d\7p\2\2\u012d\u012e\7f\2\2\u012e\u012f\7g\2\2"+
		"\u012f\u0130\7z\2\2\u0130\\\3\2\2\2\u0131\u0132\7d\2\2\u0132\u0133\7g"+
		"\2\2\u0133\u0134\7v\2\2\u0134\u0135\7y\2\2\u0135\u0136\7g\2\2\u0136\u0137"+
		"\7g\2\2\u0137\u0138\7p\2\2\u0138^\3\2\2\2\u0139\u013a\7r\2\2\u013a\u013b"+
		"\7q\2\2\u013b\u013c\7n\2\2\u013c\u013d\7{\2\2\u013d\u013e\7r\2\2\u013e"+
		"\u013f\7j\2\2\u013f\u0140\7q\2\2\u0140\u0141\7p\2\2\u0141\u0142\7k\2\2"+
		"\u0142\u0143\7e\2\2\u0143`\3\2\2\2\u0144\u0145\7j\2\2\u0145\u0146\7c\2"+
		"\2\u0146\u0147\7r\2\2\u0147\u0148\7r\2\2\u0148\u0149\7k\2\2\u0149\u014a"+
		"\7p\2\2\u014a\u014b\7g\2\2\u014b\u014c\7u\2\2\u014c\u014d\7u\2\2\u014d"+
		"\u014e\7k\2\2\u014e\u014f\7p\2\2\u014f\u0150\7f\2\2\u0150\u0151\7g\2\2"+
		"\u0151\u0152\7z\2\2\u0152b\3\2\2\2\u0153\u0154\7u\2\2\u0154\u0155\7c\2"+
		"\2\u0155\u0156\7f\2\2\u0156\u0157\7p\2\2\u0157\u0158\7g\2\2\u0158\u0159"+
		"\7u\2\2\u0159\u015a\7u\2\2\u015a\u015b\7k\2\2\u015b\u015c\7p\2\2\u015c"+
		"\u015d\7f\2\2\u015d\u015e\7g\2\2\u015e\u015f\7z\2\2\u015fd\3\2\2\2\u0160"+
		"\u0161\7r\2\2\u0161\u0162\7q\2\2\u0162\u0163\7y\2\2\u0163\u0164\7g\2\2"+
		"\u0164\u0165\7t\2\2\u0165\u0166\7k\2\2\u0166\u0167\7p\2\2\u0167\u0168"+
		"\7f\2\2\u0168\u0169\7g\2\2\u0169\u016a\7z\2\2\u016af\3\2\2\2\u016b\u016c"+
		"\7o\2\2\u016c\u016d\7c\2\2\u016d\u016e\7z\2\2\u016e\u016f\7o\2\2\u016f"+
		"\u0170\7g\2\2\u0170\u0171\7n\2\2\u0171\u0172\7q\2\2\u0172\u0173\7f\2\2"+
		"\u0173\u0174\7k\2\2\u0174\u0175\7e\2\2\u0175\u0176\7t\2\2\u0176\u0177"+
		"\7g\2\2\u0177\u0178\7r\2\2\u0178\u0179\7g\2\2\u0179\u017a\7c\2\2\u017a"+
		"\u017b\7v\2\2\u017b\u017c\7k\2\2\u017c\u017d\7p\2\2\u017d\u017e\7i\2\2"+
		"\u017e\u017f\7h\2\2\u017f\u0180\7c\2\2\u0180\u0181\7e\2\2\u0181\u0182"+
		"\7v\2\2\u0182\u0183\7q\2\2\u0183\u0184\7t\2\2\u0184h\3\2\2\2\u0185\u0187"+
		"\t\2\2\2\u0186\u0185\3\2\2\2\u0187\u0188\3\2\2\2\u0188\u0186\3\2\2\2\u0188"+
		"\u0189\3\2\2\2\u0189j\3\2\2\2\u018a\u018c\4\62;\2\u018b\u018a\3\2\2\2"+
		"\u018c\u018d\3\2\2\2\u018d\u018b\3\2\2\2\u018d\u018e\3\2\2\2\u018el\3"+
		"\2\2\2\u018f\u0191\4\62;\2\u0190\u018f\3\2\2\2\u0191\u0192\3\2\2\2\u0192"+
		"\u0190\3\2\2\2\u0192\u0193\3\2\2\2\u0193\u0194\3\2\2\2\u0194\u0196\7\60"+
		"\2\2\u0195\u0197\4\62;\2\u0196\u0195\3\2\2\2\u0197\u0198\3\2\2\2\u0198"+
		"\u0196\3\2\2\2\u0198\u0199\3\2\2\2\u0199n\3\2\2\2\u019a\u019c\t\2\2\2"+
		"\u019b\u019a\3\2\2\2\u019c\u019d\3\2\2\2\u019d\u019b\3\2\2\2\u019d\u019e"+
		"\3\2\2\2\u019ep\3\2\2\2\u019f\u01a1\7\17\2\2\u01a0\u019f\3\2\2\2\u01a0"+
		"\u01a1\3\2\2\2\u01a1\u01a2\3\2\2\2\u01a2\u01a3\7\f\2\2\u01a3\u01a4\3\2"+
		"\2\2\u01a4\u01a5\b9\2\2\u01a5r\3\2\2\2\u01a6\u01a8\t\3\2\2\u01a7\u01a6"+
		"\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a9\u01a7\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aa"+
		"\u01ab\3\2\2\2\u01ab\u01ac\b:\2\2\u01act\3\2\2\2\u01ad\u01b2\7B\2\2\u01ae"+
		"\u01b3\5w<\2\u01af\u01b3\5y=\2\u01b0\u01b3\5{>\2\u01b1\u01b3\5}?\2\u01b2"+
		"\u01ae\3\2\2\2\u01b2\u01af\3\2\2\2\u01b2\u01b0\3\2\2\2\u01b2\u01b1\3\2"+
		"\2\2\u01b3v\3\2\2\2\u01b4\u01b6\7b\2\2\u01b5\u01b7\n\4\2\2\u01b6\u01b5"+
		"\3\2\2\2\u01b7\u01b8\3\2\2\2\u01b8\u01b6\3\2\2\2\u01b8\u01b9\3\2\2\2\u01b9"+
		"\u01ba\3\2\2\2\u01ba\u01bb\7b\2\2\u01bbx\3\2\2\2\u01bc\u01be\7)\2\2\u01bd"+
		"\u01bf\n\5\2\2\u01be\u01bd\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0\u01be\3\2"+
		"\2\2\u01c0\u01c1\3\2\2\2\u01c1\u01c2\3\2\2\2\u01c2\u01c3\7)\2\2\u01c3"+
		"z\3\2\2\2\u01c4\u01c6\7$\2\2\u01c5\u01c7\n\6\2\2\u01c6\u01c5\3\2\2\2\u01c7"+
		"\u01c8\3\2\2\2\u01c8\u01c6\3\2\2\2\u01c8\u01c9\3\2\2\2\u01c9\u01ca\3\2"+
		"\2\2\u01ca\u01cb\7$\2\2\u01cb|\3\2\2\2\u01cc\u01cf\t\7\2\2\u01cd\u01cf"+
		"\5U+\2\u01ce\u01cc\3\2\2\2\u01ce\u01cd\3\2\2\2\u01cf\u01d0\3\2\2\2\u01d0"+
		"\u01ce\3\2\2\2\u01d0\u01d1\3\2\2\2\u01d1~\3\2\2\2\24\2\u00b1\u00b7\u00d3"+
		"\u00d9\u0188\u018d\u0192\u0198\u019d\u01a0\u01a9\u01b2\u01b8\u01c0\u01c8"+
		"\u01ce\u01d0\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}