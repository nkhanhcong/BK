// Generated from MC.g4 by ANTLR 4.5.3

	package MC.parser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MCLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BLANK=1, TAB=2, FORMFEED=3, NEWLINE=4, COMMENT=5, BOOLEAN=6, BREAK=7, 
		CLASS=8, CONTINUE=9, DO=10, ELSE=11, EXTENDS=12, FLOAT=13, IF=14, INTEGER=15, 
		NEW=16, STRING=17, THEN=18, FOR=19, RETURN=20, VOID=21, NIL=22, THIS=23, 
		FINAL=24, STATIC=25, PLUS=26, MUL=27, IN_DIV=28, NOTEQUAL=29, LESS=30, 
		LESSEQUAL=31, OR=32, NOT=33, OBJECTCREAT=34, SUB=35, FLOAT_DIV=36, MODULUS=37, 
		EQUAL=38, GREATER=39, GREATEREQUAL=40, CONCA=41, LSB=42, RSB=43, LP=44, 
		RP=45, LB=46, RB=47, SEMICOLONE=48, COLON=49, DOT=50, COMMA=51, ASSIGN=52, 
		INTLIT=53, FLOATLIT=54, IDENTIFIER=55, STRINGLIT=56, BOOLEANLIT=57, UNCLOSE_STRING=58;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"BLANK", "TAB", "FORMFEED", "NEWLINE", "COMMENT", "BOOLEAN", "BREAK", 
		"CLASS", "CONTINUE", "DO", "ELSE", "EXTENDS", "FLOAT", "IF", "INTEGER", 
		"NEW", "STRING", "THEN", "FOR", "RETURN", "VOID", "NIL", "THIS", "FINAL", 
		"STATIC", "PLUS", "MUL", "IN_DIV", "NOTEQUAL", "LESS", "LESSEQUAL", "OR", 
		"NOT", "OBJECTCREAT", "SUB", "FLOAT_DIV", "MODULUS", "EQUAL", "GREATER", 
		"GREATEREQUAL", "CONCA", "LSB", "RSB", "LP", "RP", "LB", "RB", "SEMICOLONE", 
		"COLON", "DOT", "COMMA", "ASSIGN", "INTLIT", "FLOATLIT", "IDENTIFIER", 
		"STRINGLIT", "BOOLEANLIT", "UNCLOSE_STRING"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, "'bool'", "'break'", "'class'", "'continue'", 
		"'do'", "'else'", "'extends'", "'float'", "'if'", "'int'", null, "'string'", 
		"'then'", "'for'", "'return'", "'void'", "'nil'", "'this'", "'final'", 
		"'static'", "'+'", "'*'", "'\\'", "'!='", "'<'", "'<='", "'||'", "'!'", 
		null, "'-'", "'/'", "'%'", "'=='", "'>'", "'>='", "'^'", "'['", "']'", 
		"'{'", "'}'", "'('", "')'", "';'", "':'", "'.'", "','", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "BLANK", "TAB", "FORMFEED", "NEWLINE", "COMMENT", "BOOLEAN", "BREAK", 
		"CLASS", "CONTINUE", "DO", "ELSE", "EXTENDS", "FLOAT", "IF", "INTEGER", 
		"NEW", "STRING", "THEN", "FOR", "RETURN", "VOID", "NIL", "THIS", "FINAL", 
		"STATIC", "PLUS", "MUL", "IN_DIV", "NOTEQUAL", "LESS", "LESSEQUAL", "OR", 
		"NOT", "OBJECTCREAT", "SUB", "FLOAT_DIV", "MODULUS", "EQUAL", "GREATER", 
		"GREATEREQUAL", "CONCA", "LSB", "RSB", "LP", "RP", "LB", "RB", "SEMICOLONE", 
		"COLON", "DOT", "COMMA", "ASSIGN", "INTLIT", "FLOATLIT", "IDENTIFIER", 
		"STRINGLIT", "BOOLEANLIT", "UNCLOSE_STRING"
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
	public Token emit() {
	    switch (getType()) {
	    case UNCLOSE_STRING:       
	        Token result = super.emit();
	        // you'll need to define this method
	        throw new UncloseString(result.getText());
	        
	    case ILLEGAL_ESCAPE:
	    	result = super.emit();
	    	throw new IllegalEscape(result.getText());
	    case ERROR_CHAR:
	    	result = super.emit();
	    	throw new ErrorToken(result.getText());	
	    default:
	        return super.emit();
	    }
	}


	public MCLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MC.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2<\u018b\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\3\2\3\2\3\3"+
		"\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\7\6\u0084\n\6\f\6\16\6\u0087\13\6"+
		"\3\6\3\6\3\6\5\6\u008c\n\6\3\6\3\6\3\6\3\6\7\6\u0092\n\6\f\6\16\6\u0095"+
		"\13\6\5\6\u0097\n\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3"+
		"\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3"+
		"\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3"+
		"\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3"+
		"\36\3\36\3\36\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3#\3#\3#\3#\3$\3$\3"+
		"%\3%\3&\3&\3\'\3\'\3\'\3(\3(\3)\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3"+
		"/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66"+
		"\6\66\u0144\n\66\r\66\16\66\u0145\3\67\6\67\u0149\n\67\r\67\16\67\u014a"+
		"\3\67\3\67\7\67\u014f\n\67\f\67\16\67\u0152\13\67\3\67\5\67\u0155\n\67"+
		"\3\67\3\67\5\67\u0159\n\67\5\67\u015b\n\67\3\67\5\67\u015e\n\67\5\67\u0160"+
		"\n\67\38\68\u0163\n8\r8\168\u0164\38\78\u0168\n8\f8\168\u016b\138\39\3"+
		"9\39\39\79\u0171\n9\f9\169\u0174\139\39\39\3:\3:\3:\3:\3:\3:\3:\3:\3:"+
		"\5:\u0181\n:\3;\3;\3;\3;\7;\u0187\n;\f;\16;\u018a\13;\2\2<\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G"+
		"%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<\3\2\13"+
		"\3\2\2\u0100\4\2\13\f\17\17\3\2\62;\4\2GGgg\4\2--//\5\2C\\aac|\6\2\62"+
		";C\\aac|\t\2$$^^ddhhppttvv\6\2\n\f\16\17$$^^\u019d\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2"+
		"\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2"+
		"Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3"+
		"\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2"+
		"\2\2s\3\2\2\2\2u\3\2\2\2\3w\3\2\2\2\5y\3\2\2\2\7{\3\2\2\2\t}\3\2\2\2\13"+
		"\u0096\3\2\2\2\r\u0098\3\2\2\2\17\u009d\3\2\2\2\21\u00a3\3\2\2\2\23\u00a9"+
		"\3\2\2\2\25\u00b2\3\2\2\2\27\u00b5\3\2\2\2\31\u00ba\3\2\2\2\33\u00c2\3"+
		"\2\2\2\35\u00c8\3\2\2\2\37\u00cb\3\2\2\2!\u00cf\3\2\2\2#\u00d3\3\2\2\2"+
		"%\u00da\3\2\2\2\'\u00df\3\2\2\2)\u00e3\3\2\2\2+\u00ea\3\2\2\2-\u00ef\3"+
		"\2\2\2/\u00f3\3\2\2\2\61\u00f8\3\2\2\2\63\u00fe\3\2\2\2\65\u0105\3\2\2"+
		"\2\67\u0107\3\2\2\29\u0109\3\2\2\2;\u010b\3\2\2\2=\u010e\3\2\2\2?\u0110"+
		"\3\2\2\2A\u0113\3\2\2\2C\u0116\3\2\2\2E\u0118\3\2\2\2G\u011c\3\2\2\2I"+
		"\u011e\3\2\2\2K\u0120\3\2\2\2M\u0122\3\2\2\2O\u0125\3\2\2\2Q\u0127\3\2"+
		"\2\2S\u012a\3\2\2\2U\u012c\3\2\2\2W\u012e\3\2\2\2Y\u0130\3\2\2\2[\u0132"+
		"\3\2\2\2]\u0134\3\2\2\2_\u0136\3\2\2\2a\u0138\3\2\2\2c\u013a\3\2\2\2e"+
		"\u013c\3\2\2\2g\u013e\3\2\2\2i\u0140\3\2\2\2k\u0143\3\2\2\2m\u0148\3\2"+
		"\2\2o\u0162\3\2\2\2q\u016c\3\2\2\2s\u0180\3\2\2\2u\u0182\3\2\2\2wx\7\""+
		"\2\2x\4\3\2\2\2yz\7\13\2\2z\6\3\2\2\2{|\7\16\2\2|\b\3\2\2\2}~\7\f\2\2"+
		"~\n\3\2\2\2\177\u0080\7\61\2\2\u0080\u0081\7,\2\2\u0081\u0085\3\2\2\2"+
		"\u0082\u0084\t\2\2\2\u0083\u0082\3\2\2\2\u0084\u0087\3\2\2\2\u0085\u0083"+
		"\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u008b\3\2\2\2\u0087\u0085\3\2\2\2\u0088"+
		"\u0089\7,\2\2\u0089\u008c\7\61\2\2\u008a\u008c\7\2\2\3\u008b\u0088\3\2"+
		"\2\2\u008b\u008a\3\2\2\2\u008c\u0097\3\2\2\2\u008d\u008e\7\'\2\2\u008e"+
		"\u008f\7\'\2\2\u008f\u0093\3\2\2\2\u0090\u0092\n\3\2\2\u0091\u0090\3\2"+
		"\2\2\u0092\u0095\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094"+
		"\u0097\3\2\2\2\u0095\u0093\3\2\2\2\u0096\177\3\2\2\2\u0096\u008d\3\2\2"+
		"\2\u0097\f\3\2\2\2\u0098\u0099\7d\2\2\u0099\u009a\7q\2\2\u009a\u009b\7"+
		"q\2\2\u009b\u009c\7n\2\2\u009c\16\3\2\2\2\u009d\u009e\7d\2\2\u009e\u009f"+
		"\7t\2\2\u009f\u00a0\7g\2\2\u00a0\u00a1\7c\2\2\u00a1\u00a2\7m\2\2\u00a2"+
		"\20\3\2\2\2\u00a3\u00a4\7e\2\2\u00a4\u00a5\7n\2\2\u00a5\u00a6\7c\2\2\u00a6"+
		"\u00a7\7u\2\2\u00a7\u00a8\7u\2\2\u00a8\22\3\2\2\2\u00a9\u00aa\7e\2\2\u00aa"+
		"\u00ab\7q\2\2\u00ab\u00ac\7p\2\2\u00ac\u00ad\7v\2\2\u00ad\u00ae\7k\2\2"+
		"\u00ae\u00af\7p\2\2\u00af\u00b0\7w\2\2\u00b0\u00b1\7g\2\2\u00b1\24\3\2"+
		"\2\2\u00b2\u00b3\7f\2\2\u00b3\u00b4\7q\2\2\u00b4\26\3\2\2\2\u00b5\u00b6"+
		"\7g\2\2\u00b6\u00b7\7n\2\2\u00b7\u00b8\7u\2\2\u00b8\u00b9\7g\2\2\u00b9"+
		"\30\3\2\2\2\u00ba\u00bb\7g\2\2\u00bb\u00bc\7z\2\2\u00bc\u00bd\7v\2\2\u00bd"+
		"\u00be\7g\2\2\u00be\u00bf\7p\2\2\u00bf\u00c0\7f\2\2\u00c0\u00c1\7u\2\2"+
		"\u00c1\32\3\2\2\2\u00c2\u00c3\7h\2\2\u00c3\u00c4\7n\2\2\u00c4\u00c5\7"+
		"q\2\2\u00c5\u00c6\7c\2\2\u00c6\u00c7\7v\2\2\u00c7\34\3\2\2\2\u00c8\u00c9"+
		"\7k\2\2\u00c9\u00ca\7h\2\2\u00ca\36\3\2\2\2\u00cb\u00cc\7k\2\2\u00cc\u00cd"+
		"\7p\2\2\u00cd\u00ce\7v\2\2\u00ce \3\2\2\2\u00cf\u00d0\7p\2\2\u00d0\u00d1"+
		"\7g\2\2\u00d1\u00d2\7y\2\2\u00d2\"\3\2\2\2\u00d3\u00d4\7u\2\2\u00d4\u00d5"+
		"\7v\2\2\u00d5\u00d6\7t\2\2\u00d6\u00d7\7k\2\2\u00d7\u00d8\7p\2\2\u00d8"+
		"\u00d9\7i\2\2\u00d9$\3\2\2\2\u00da\u00db\7v\2\2\u00db\u00dc\7j\2\2\u00dc"+
		"\u00dd\7g\2\2\u00dd\u00de\7p\2\2\u00de&\3\2\2\2\u00df\u00e0\7h\2\2\u00e0"+
		"\u00e1\7q\2\2\u00e1\u00e2\7t\2\2\u00e2(\3\2\2\2\u00e3\u00e4\7t\2\2\u00e4"+
		"\u00e5\7g\2\2\u00e5\u00e6\7v\2\2\u00e6\u00e7\7w\2\2\u00e7\u00e8\7t\2\2"+
		"\u00e8\u00e9\7p\2\2\u00e9*\3\2\2\2\u00ea\u00eb\7x\2\2\u00eb\u00ec\7q\2"+
		"\2\u00ec\u00ed\7k\2\2\u00ed\u00ee\7f\2\2\u00ee,\3\2\2\2\u00ef\u00f0\7"+
		"p\2\2\u00f0\u00f1\7k\2\2\u00f1\u00f2\7n\2\2\u00f2.\3\2\2\2\u00f3\u00f4"+
		"\7v\2\2\u00f4\u00f5\7j\2\2\u00f5\u00f6\7k\2\2\u00f6\u00f7\7u\2\2\u00f7"+
		"\60\3\2\2\2\u00f8\u00f9\7h\2\2\u00f9\u00fa\7k\2\2\u00fa\u00fb\7p\2\2\u00fb"+
		"\u00fc\7c\2\2\u00fc\u00fd\7n\2\2\u00fd\62\3\2\2\2\u00fe\u00ff\7u\2\2\u00ff"+
		"\u0100\7v\2\2\u0100\u0101\7c\2\2\u0101\u0102\7v\2\2\u0102\u0103\7k\2\2"+
		"\u0103\u0104\7e\2\2\u0104\64\3\2\2\2\u0105\u0106\7-\2\2\u0106\66\3\2\2"+
		"\2\u0107\u0108\7,\2\2\u01088\3\2\2\2\u0109\u010a\7^\2\2\u010a:\3\2\2\2"+
		"\u010b\u010c\7#\2\2\u010c\u010d\7?\2\2\u010d<\3\2\2\2\u010e\u010f\7>\2"+
		"\2\u010f>\3\2\2\2\u0110\u0111\7>\2\2\u0111\u0112\7?\2\2\u0112@\3\2\2\2"+
		"\u0113\u0114\7~\2\2\u0114\u0115\7~\2\2\u0115B\3\2\2\2\u0116\u0117\7#\2"+
		"\2\u0117D\3\2\2\2\u0118\u0119\7p\2\2\u0119\u011a\7g\2\2\u011a\u011b\7"+
		"y\2\2\u011bF\3\2\2\2\u011c\u011d\7/\2\2\u011dH\3\2\2\2\u011e\u011f\7\61"+
		"\2\2\u011fJ\3\2\2\2\u0120\u0121\7\'\2\2\u0121L\3\2\2\2\u0122\u0123\7?"+
		"\2\2\u0123\u0124\7?\2\2\u0124N\3\2\2\2\u0125\u0126\7@\2\2\u0126P\3\2\2"+
		"\2\u0127\u0128\7@\2\2\u0128\u0129\7?\2\2\u0129R\3\2\2\2\u012a\u012b\7"+
		"`\2\2\u012bT\3\2\2\2\u012c\u012d\7]\2\2\u012dV\3\2\2\2\u012e\u012f\7_"+
		"\2\2\u012fX\3\2\2\2\u0130\u0131\7}\2\2\u0131Z\3\2\2\2\u0132\u0133\7\177"+
		"\2\2\u0133\\\3\2\2\2\u0134\u0135\7*\2\2\u0135^\3\2\2\2\u0136\u0137\7+"+
		"\2\2\u0137`\3\2\2\2\u0138\u0139\7=\2\2\u0139b\3\2\2\2\u013a\u013b\7<\2"+
		"\2\u013bd\3\2\2\2\u013c\u013d\7\60\2\2\u013df\3\2\2\2\u013e\u013f\7.\2"+
		"\2\u013fh\3\2\2\2\u0140\u0141\7?\2\2\u0141j\3\2\2\2\u0142\u0144\t\4\2"+
		"\2\u0143\u0142\3\2\2\2\u0144\u0145\3\2\2\2\u0145\u0143\3\2\2\2\u0145\u0146"+
		"\3\2\2\2\u0146l\3\2\2\2\u0147\u0149\t\4\2\2\u0148\u0147\3\2\2\2\u0149"+
		"\u014a\3\2\2\2\u014a\u0148\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u015f\3\2"+
		"\2\2\u014c\u0150\7\60\2\2\u014d\u014f\t\4\2\2\u014e\u014d\3\2\2\2\u014f"+
		"\u0152\3\2\2\2\u0150\u014e\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u015a\3\2"+
		"\2\2\u0152\u0150\3\2\2\2\u0153\u0155\t\5\2\2\u0154\u0153\3\2\2\2\u0154"+
		"\u0155\3\2\2\2\u0155\u015b\3\2\2\2\u0156\u0158\t\5\2\2\u0157\u0159\t\6"+
		"\2\2\u0158\u0157\3\2\2\2\u0158\u0159\3\2\2\2\u0159\u015b\3\2\2\2\u015a"+
		"\u0154\3\2\2\2\u015a\u0156\3\2\2\2\u015b\u0160\3\2\2\2\u015c\u015e\t\5"+
		"\2\2\u015d\u015c\3\2\2\2\u015d\u015e\3\2\2\2\u015e\u0160\3\2\2\2\u015f"+
		"\u014c\3\2\2\2\u015f\u015d\3\2\2\2\u0160n\3\2\2\2\u0161\u0163\t\7\2\2"+
		"\u0162\u0161\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u0162\3\2\2\2\u0164\u0165"+
		"\3\2\2\2\u0165\u0169\3\2\2\2\u0166\u0168\t\b\2\2\u0167\u0166\3\2\2\2\u0168"+
		"\u016b\3\2\2\2\u0169\u0167\3\2\2\2\u0169\u016a\3\2\2\2\u016ap\3\2\2\2"+
		"\u016b\u0169\3\2\2\2\u016c\u0172\7$\2\2\u016d\u016e\7^\2\2\u016e\u0171"+
		"\t\t\2\2\u016f\u0171\n\n\2\2\u0170\u016d\3\2\2\2\u0170\u016f\3\2\2\2\u0171"+
		"\u0174\3\2\2\2\u0172\u0170\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u0175\3\2"+
		"\2\2\u0174\u0172\3\2\2\2\u0175\u0176\7$\2\2\u0176r\3\2\2\2\u0177\u0178"+
		"\7v\2\2\u0178\u0179\7t\2\2\u0179\u017a\7w\2\2\u017a\u0181\7g\2\2\u017b"+
		"\u017c\7h\2\2\u017c\u017d\7c\2\2\u017d\u017e\7n\2\2\u017e\u017f\7u\2\2"+
		"\u017f\u0181\7g\2\2\u0180\u0177\3\2\2\2\u0180\u017b\3\2\2\2\u0181t\3\2"+
		"\2\2\u0182\u0188\7$\2\2\u0183\u0184\7^\2\2\u0184\u0187\t\t\2\2\u0185\u0187"+
		"\n\n\2\2\u0186\u0183\3\2\2\2\u0186\u0185\3\2\2\2\u0187\u018a\3\2\2\2\u0188"+
		"\u0186\3\2\2\2\u0188\u0189\3\2\2\2\u0189v\3\2\2\2\u018a\u0188\3\2\2\2"+
		"\26\2\u0085\u008b\u0093\u0096\u0145\u014a\u0150\u0154\u0158\u015a\u015d"+
		"\u015f\u0164\u0169\u0170\u0172\u0180\u0186\u0188\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}