// Generated from BKOOL.g4 by ANTLR 4.5.3

    package bkool.parser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BKOOLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, BLANK=2, TAB=3, FORMFEED=4, NEWLINE=5, CRETURN=6, COMMENT=7, BLOCKCOMMENT=8, 
		COMMENTLINE=9, BOOLEAN=10, BREAK=11, CLASS=12, CONTINUE=13, DO=14, ELSE=15, 
		EXTENDS=16, FLOAT=17, IF=18, INTEGER=19, NEW=20, STRING=21, THEN=22, FOR=23, 
		RETURN=24, VOID=25, NIL=26, THIS=27, FINAL=28, STATIC=29, PLUS=30, MUL=31, 
		IN_DIV=32, NOTEQUAL=33, LESS=34, LESSEQUAL=35, OR=36, NOT=37, OBJECTCREAT=38, 
		SUB=39, FLOAT_DIV=40, MODULUS=41, EQUAL=42, GREATER=43, GREATEREQUAL=44, 
		CONCA=45, LSB=46, RSB=47, LP=48, RP=49, LB=50, RB=51, SEMICOLONE=52, COLON=53, 
		DOT=54, COMMA=55, INTLIT=56, FLOATLIT=57, ID=58, STRINGLIT=59, BOOLEANLIT=60, 
		UNCLOSE_STRING=61, ILLEGAL_ESCAPE=62, ERROR_CHAR=63;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"WS", "BLANK", "TAB", "FORMFEED", "NEWLINE", "CRETURN", "COMMENT", "BLOCKCOMMENT", 
		"COMMENTLINE", "BOOLEAN", "BREAK", "CLASS", "CONTINUE", "DO", "ELSE", 
		"EXTENDS", "FLOAT", "IF", "INTEGER", "NEW", "STRING", "THEN", "FOR", "RETURN", 
		"VOID", "NIL", "THIS", "FINAL", "STATIC", "PLUS", "MUL", "IN_DIV", "NOTEQUAL", 
		"LESS", "LESSEQUAL", "OR", "NOT", "OBJECTCREAT", "SUB", "FLOAT_DIV", "MODULUS", 
		"EQUAL", "GREATER", "GREATEREQUAL", "CONCA", "LSB", "RSB", "LP", "RP", 
		"LB", "RB", "SEMICOLONE", "COLON", "DOT", "COMMA", "INTLIT", "FLOATLIT", 
		"ID", "STRINGLIT", "BOOLEANLIT", "UNCLOSE_STRING", "ILLEGAL_ESCAPE", "ERROR_CHAR"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "'bool'", 
		"'break'", "'class'", "'continue'", "'do'", "'else'", "'extends'", "'float'", 
		"'if'", "'int'", null, "'string'", "'then'", "'for'", "'return'", "'void'", 
		"'nil'", "'this'", "'final'", "'static'", "'+'", "'*'", "'\\'", "'!='", 
		"'<'", "'<='", "'||'", "'!'", null, "'-'", "'/'", "'%'", "'=='", "'>'", 
		"'>='", "'^'", "'['", "']'", "'{'", "'}'", "'('", "')'", "';'", "':'", 
		"'.'", "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "WS", "BLANK", "TAB", "FORMFEED", "NEWLINE", "CRETURN", "COMMENT", 
		"BLOCKCOMMENT", "COMMENTLINE", "BOOLEAN", "BREAK", "CLASS", "CONTINUE", 
		"DO", "ELSE", "EXTENDS", "FLOAT", "IF", "INTEGER", "NEW", "STRING", "THEN", 
		"FOR", "RETURN", "VOID", "NIL", "THIS", "FINAL", "STATIC", "PLUS", "MUL", 
		"IN_DIV", "NOTEQUAL", "LESS", "LESSEQUAL", "OR", "NOT", "OBJECTCREAT", 
		"SUB", "FLOAT_DIV", "MODULUS", "EQUAL", "GREATER", "GREATEREQUAL", "CONCA", 
		"LSB", "RSB", "LP", "RP", "LB", "RB", "SEMICOLONE", "COLON", "DOT", "COMMA", 
		"INTLIT", "FLOATLIT", "ID", "STRINGLIT", "BOOLEANLIT", "UNCLOSE_STRING", 
		"ILLEGAL_ESCAPE", "ERROR_CHAR"
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


	public BKOOLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "BKOOL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2A\u01b9\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\3\2\6\2\u0083\n\2\r\2\16\2\u0084\3\2\3\2\3\3\3\3\3"+
		"\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\7\t\u0099\n\t\f"+
		"\t\16\t\u009c\13\t\3\t\3\t\3\t\5\t\u00a1\n\t\3\t\3\t\3\n\3\n\3\n\3\n\7"+
		"\n\u00a9\n\n\f\n\16\n\u00ac\13\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23"+
		"\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\34"+
		"\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3\"\3#\3#\3$\3$\3$\3%\3"+
		"%\3%\3&\3&\3\'\3\'\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3+\3,\3,\3-\3-\3-\3"+
		".\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65"+
		"\3\66\3\66\3\67\3\67\38\38\39\69\u0159\n9\r9\169\u015a\3:\6:\u015e\n:"+
		"\r:\16:\u015f\3:\3:\5:\u0164\n:\3:\6:\u0167\n:\r:\16:\u0168\3:\3:\7:\u016d"+
		"\n:\f:\16:\u0170\13:\3:\5:\u0173\n:\3:\3:\5:\u0177\n:\5:\u0179\n:\3:\6"+
		":\u017c\n:\r:\16:\u017d\5:\u0180\n:\5:\u0182\n:\3;\6;\u0185\n;\r;\16;"+
		"\u0186\3;\7;\u018a\n;\f;\16;\u018d\13;\3<\3<\3<\3<\7<\u0193\n<\f<\16<"+
		"\u0196\13<\3<\3<\3=\3=\3=\3=\3=\3=\3=\3=\3=\5=\u01a3\n=\3>\3>\3>\3>\7"+
		">\u01a9\n>\f>\16>\u01ac\13>\3?\3?\7?\u01b0\n?\f?\16?\u01b3\13?\3?\3?\3"+
		"?\3@\3@\4\u009a\u01b1\2A\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63"+
		"\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62"+
		"c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177A\3\2\17\5\2\13\f\17\17\"\""+
		"\b\2\"\"DEGGKKMQVV\3\2\2\u0081\4\2\f\f\17\17\3\2\62;\4\2GGgg\4\2--//\5"+
		"\2C\\aac|\6\2\62;C\\aac|\t\2$$^^ddhhppttvv\6\2\n\f\16\17$$^^\3\2\"\u0081"+
		"\7\2\"\"CIKLNYaa\u01cf\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2"+
		"\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2"+
		"\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2"+
		"Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3"+
		"\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2"+
		"\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2"+
		"w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\3\u0082\3\2\2"+
		"\2\5\u0088\3\2\2\2\7\u008a\3\2\2\2\t\u008c\3\2\2\2\13\u008e\3\2\2\2\r"+
		"\u0090\3\2\2\2\17\u0092\3\2\2\2\21\u0094\3\2\2\2\23\u00a4\3\2\2\2\25\u00af"+
		"\3\2\2\2\27\u00b4\3\2\2\2\31\u00ba\3\2\2\2\33\u00c0\3\2\2\2\35\u00c9\3"+
		"\2\2\2\37\u00cc\3\2\2\2!\u00d1\3\2\2\2#\u00d9\3\2\2\2%\u00df\3\2\2\2\'"+
		"\u00e2\3\2\2\2)\u00e6\3\2\2\2+\u00ea\3\2\2\2-\u00f1\3\2\2\2/\u00f6\3\2"+
		"\2\2\61\u00fa\3\2\2\2\63\u0101\3\2\2\2\65\u0106\3\2\2\2\67\u010a\3\2\2"+
		"\29\u010f\3\2\2\2;\u0115\3\2\2\2=\u011c\3\2\2\2?\u011e\3\2\2\2A\u0120"+
		"\3\2\2\2C\u0122\3\2\2\2E\u0125\3\2\2\2G\u0127\3\2\2\2I\u012a\3\2\2\2K"+
		"\u012d\3\2\2\2M\u012f\3\2\2\2O\u0133\3\2\2\2Q\u0135\3\2\2\2S\u0137\3\2"+
		"\2\2U\u0139\3\2\2\2W\u013c\3\2\2\2Y\u013e\3\2\2\2[\u0141\3\2\2\2]\u0143"+
		"\3\2\2\2_\u0145\3\2\2\2a\u0147\3\2\2\2c\u0149\3\2\2\2e\u014b\3\2\2\2g"+
		"\u014d\3\2\2\2i\u014f\3\2\2\2k\u0151\3\2\2\2m\u0153\3\2\2\2o\u0155\3\2"+
		"\2\2q\u0158\3\2\2\2s\u015d\3\2\2\2u\u0184\3\2\2\2w\u018e\3\2\2\2y\u01a2"+
		"\3\2\2\2{\u01a4\3\2\2\2}\u01ad\3\2\2\2\177\u01b7\3\2\2\2\u0081\u0083\t"+
		"\2\2\2\u0082\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0082\3\2\2\2\u0084"+
		"\u0085\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\b\2\2\2\u0087\4\3\2\2\2"+
		"\u0088\u0089\7\"\2\2\u0089\6\3\2\2\2\u008a\u008b\7\13\2\2\u008b\b\3\2"+
		"\2\2\u008c\u008d\7\16\2\2\u008d\n\3\2\2\2\u008e\u008f\7\f\2\2\u008f\f"+
		"\3\2\2\2\u0090\u0091\7\17\2\2\u0091\16\3\2\2\2\u0092\u0093\t\3\2\2\u0093"+
		"\20\3\2\2\2\u0094\u0095\7\61\2\2\u0095\u0096\7,\2\2\u0096\u009a\3\2\2"+
		"\2\u0097\u0099\t\4\2\2\u0098\u0097\3\2\2\2\u0099\u009c\3\2\2\2\u009a\u009b"+
		"\3\2\2\2\u009a\u0098\3\2\2\2\u009b\u00a0\3\2\2\2\u009c\u009a\3\2\2\2\u009d"+
		"\u009e\7,\2\2\u009e\u00a1\7\61\2\2\u009f\u00a1\7\2\2\3\u00a0\u009d\3\2"+
		"\2\2\u00a0\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\b\t\2\2\u00a3"+
		"\22\3\2\2\2\u00a4\u00a5\7\'\2\2\u00a5\u00a6\7\'\2\2\u00a6\u00aa\3\2\2"+
		"\2\u00a7\u00a9\n\5\2\2\u00a8\u00a7\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00a8"+
		"\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ad\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad"+
		"\u00ae\b\n\2\2\u00ae\24\3\2\2\2\u00af\u00b0\7d\2\2\u00b0\u00b1\7q\2\2"+
		"\u00b1\u00b2\7q\2\2\u00b2\u00b3\7n\2\2\u00b3\26\3\2\2\2\u00b4\u00b5\7"+
		"d\2\2\u00b5\u00b6\7t\2\2\u00b6\u00b7\7g\2\2\u00b7\u00b8\7c\2\2\u00b8\u00b9"+
		"\7m\2\2\u00b9\30\3\2\2\2\u00ba\u00bb\7e\2\2\u00bb\u00bc\7n\2\2\u00bc\u00bd"+
		"\7c\2\2\u00bd\u00be\7u\2\2\u00be\u00bf\7u\2\2\u00bf\32\3\2\2\2\u00c0\u00c1"+
		"\7e\2\2\u00c1\u00c2\7q\2\2\u00c2\u00c3\7p\2\2\u00c3\u00c4\7v\2\2\u00c4"+
		"\u00c5\7k\2\2\u00c5\u00c6\7p\2\2\u00c6\u00c7\7w\2\2\u00c7\u00c8\7g\2\2"+
		"\u00c8\34\3\2\2\2\u00c9\u00ca\7f\2\2\u00ca\u00cb\7q\2\2\u00cb\36\3\2\2"+
		"\2\u00cc\u00cd\7g\2\2\u00cd\u00ce\7n\2\2\u00ce\u00cf\7u\2\2\u00cf\u00d0"+
		"\7g\2\2\u00d0 \3\2\2\2\u00d1\u00d2\7g\2\2\u00d2\u00d3\7z\2\2\u00d3\u00d4"+
		"\7v\2\2\u00d4\u00d5\7g\2\2\u00d5\u00d6\7p\2\2\u00d6\u00d7\7f\2\2\u00d7"+
		"\u00d8\7u\2\2\u00d8\"\3\2\2\2\u00d9\u00da\7h\2\2\u00da\u00db\7n\2\2\u00db"+
		"\u00dc\7q\2\2\u00dc\u00dd\7c\2\2\u00dd\u00de\7v\2\2\u00de$\3\2\2\2\u00df"+
		"\u00e0\7k\2\2\u00e0\u00e1\7h\2\2\u00e1&\3\2\2\2\u00e2\u00e3\7k\2\2\u00e3"+
		"\u00e4\7p\2\2\u00e4\u00e5\7v\2\2\u00e5(\3\2\2\2\u00e6\u00e7\7p\2\2\u00e7"+
		"\u00e8\7g\2\2\u00e8\u00e9\7y\2\2\u00e9*\3\2\2\2\u00ea\u00eb\7u\2\2\u00eb"+
		"\u00ec\7v\2\2\u00ec\u00ed\7t\2\2\u00ed\u00ee\7k\2\2\u00ee\u00ef\7p\2\2"+
		"\u00ef\u00f0\7i\2\2\u00f0,\3\2\2\2\u00f1\u00f2\7v\2\2\u00f2\u00f3\7j\2"+
		"\2\u00f3\u00f4\7g\2\2\u00f4\u00f5\7p\2\2\u00f5.\3\2\2\2\u00f6\u00f7\7"+
		"h\2\2\u00f7\u00f8\7q\2\2\u00f8\u00f9\7t\2\2\u00f9\60\3\2\2\2\u00fa\u00fb"+
		"\7t\2\2\u00fb\u00fc\7g\2\2\u00fc\u00fd\7v\2\2\u00fd\u00fe\7w\2\2\u00fe"+
		"\u00ff\7t\2\2\u00ff\u0100\7p\2\2\u0100\62\3\2\2\2\u0101\u0102\7x\2\2\u0102"+
		"\u0103\7q\2\2\u0103\u0104\7k\2\2\u0104\u0105\7f\2\2\u0105\64\3\2\2\2\u0106"+
		"\u0107\7p\2\2\u0107\u0108\7k\2\2\u0108\u0109\7n\2\2\u0109\66\3\2\2\2\u010a"+
		"\u010b\7v\2\2\u010b\u010c\7j\2\2\u010c\u010d\7k\2\2\u010d\u010e\7u\2\2"+
		"\u010e8\3\2\2\2\u010f\u0110\7h\2\2\u0110\u0111\7k\2\2\u0111\u0112\7p\2"+
		"\2\u0112\u0113\7c\2\2\u0113\u0114\7n\2\2\u0114:\3\2\2\2\u0115\u0116\7"+
		"u\2\2\u0116\u0117\7v\2\2\u0117\u0118\7c\2\2\u0118\u0119\7v\2\2\u0119\u011a"+
		"\7k\2\2\u011a\u011b\7e\2\2\u011b<\3\2\2\2\u011c\u011d\7-\2\2\u011d>\3"+
		"\2\2\2\u011e\u011f\7,\2\2\u011f@\3\2\2\2\u0120\u0121\7^\2\2\u0121B\3\2"+
		"\2\2\u0122\u0123\7#\2\2\u0123\u0124\7?\2\2\u0124D\3\2\2\2\u0125\u0126"+
		"\7>\2\2\u0126F\3\2\2\2\u0127\u0128\7>\2\2\u0128\u0129\7?\2\2\u0129H\3"+
		"\2\2\2\u012a\u012b\7~\2\2\u012b\u012c\7~\2\2\u012cJ\3\2\2\2\u012d\u012e"+
		"\7#\2\2\u012eL\3\2\2\2\u012f\u0130\7p\2\2\u0130\u0131\7g\2\2\u0131\u0132"+
		"\7y\2\2\u0132N\3\2\2\2\u0133\u0134\7/\2\2\u0134P\3\2\2\2\u0135\u0136\7"+
		"\61\2\2\u0136R\3\2\2\2\u0137\u0138\7\'\2\2\u0138T\3\2\2\2\u0139\u013a"+
		"\7?\2\2\u013a\u013b\7?\2\2\u013bV\3\2\2\2\u013c\u013d\7@\2\2\u013dX\3"+
		"\2\2\2\u013e\u013f\7@\2\2\u013f\u0140\7?\2\2\u0140Z\3\2\2\2\u0141\u0142"+
		"\7`\2\2\u0142\\\3\2\2\2\u0143\u0144\7]\2\2\u0144^\3\2\2\2\u0145\u0146"+
		"\7_\2\2\u0146`\3\2\2\2\u0147\u0148\7}\2\2\u0148b\3\2\2\2\u0149\u014a\7"+
		"\177\2\2\u014ad\3\2\2\2\u014b\u014c\7*\2\2\u014cf\3\2\2\2\u014d\u014e"+
		"\7+\2\2\u014eh\3\2\2\2\u014f\u0150\7=\2\2\u0150j\3\2\2\2\u0151\u0152\7"+
		"<\2\2\u0152l\3\2\2\2\u0153\u0154\7\60\2\2\u0154n\3\2\2\2\u0155\u0156\7"+
		".\2\2\u0156p\3\2\2\2\u0157\u0159\t\6\2\2\u0158\u0157\3\2\2\2\u0159\u015a"+
		"\3\2\2\2\u015a\u0158\3\2\2\2\u015a\u015b\3\2\2\2\u015br\3\2\2\2\u015c"+
		"\u015e\t\6\2\2\u015d\u015c\3\2\2\2\u015e\u015f\3\2\2\2\u015f\u015d\3\2"+
		"\2\2\u015f\u0160\3\2\2\2\u0160\u0181\3\2\2\2\u0161\u0163\t\7\2\2\u0162"+
		"\u0164\t\b\2\2\u0163\u0162\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u0166\3\2"+
		"\2\2\u0165\u0167\t\6\2\2\u0166\u0165\3\2\2\2\u0167\u0168\3\2\2\2\u0168"+
		"\u0166\3\2\2\2\u0168\u0169\3\2\2\2\u0169\u0182\3\2\2\2\u016a\u017f\7\60"+
		"\2\2\u016b\u016d\t\6\2\2\u016c\u016b\3\2\2\2\u016d\u0170\3\2\2\2\u016e"+
		"\u016c\3\2\2\2\u016e\u016f\3\2\2\2\u016f\u0178\3\2\2\2\u0170\u016e\3\2"+
		"\2\2\u0171\u0173\t\7\2\2\u0172\u0171\3\2\2\2\u0172\u0173\3\2\2\2\u0173"+
		"\u0179\3\2\2\2\u0174\u0176\t\7\2\2\u0175\u0177\t\b\2\2\u0176\u0175\3\2"+
		"\2\2\u0176\u0177\3\2\2\2\u0177\u0179\3\2\2\2\u0178\u0172\3\2\2\2\u0178"+
		"\u0174\3\2\2\2\u0179\u017b\3\2\2\2\u017a\u017c\t\6\2\2\u017b\u017a\3\2"+
		"\2\2\u017c\u017d\3\2\2\2\u017d\u017b\3\2\2\2\u017d\u017e\3\2\2\2\u017e"+
		"\u0180\3\2\2\2\u017f\u016e\3\2\2\2\u017f\u0180\3\2\2\2\u0180\u0182\3\2"+
		"\2\2\u0181\u0161\3\2\2\2\u0181\u016a\3\2\2\2\u0182t\3\2\2\2\u0183\u0185"+
		"\t\t\2\2\u0184\u0183\3\2\2\2\u0185\u0186\3\2\2\2\u0186\u0184\3\2\2\2\u0186"+
		"\u0187\3\2\2\2\u0187\u018b\3\2\2\2\u0188\u018a\t\n\2\2\u0189\u0188\3\2"+
		"\2\2\u018a\u018d\3\2\2\2\u018b\u0189\3\2\2\2\u018b\u018c\3\2\2\2\u018c"+
		"v\3\2\2\2\u018d\u018b\3\2\2\2\u018e\u0194\7$\2\2\u018f\u0190\7^\2\2\u0190"+
		"\u0193\t\13\2\2\u0191\u0193\n\f\2\2\u0192\u018f\3\2\2\2\u0192\u0191\3"+
		"\2\2\2\u0193\u0196\3\2\2\2\u0194\u0192\3\2\2\2\u0194\u0195\3\2\2\2\u0195"+
		"\u0197\3\2\2\2\u0196\u0194\3\2\2\2\u0197\u0198\7$\2\2\u0198x\3\2\2\2\u0199"+
		"\u019a\7v\2\2\u019a\u019b\7t\2\2\u019b\u019c\7w\2\2\u019c\u01a3\7g\2\2"+
		"\u019d\u019e\7h\2\2\u019e\u019f\7c\2\2\u019f\u01a0\7n\2\2\u01a0\u01a1"+
		"\7u\2\2\u01a1\u01a3\7g\2\2\u01a2\u0199\3\2\2\2\u01a2\u019d\3\2\2\2\u01a3"+
		"z\3\2\2\2\u01a4\u01aa\7$\2\2\u01a5\u01a6\7^\2\2\u01a6\u01a9\t\13\2\2\u01a7"+
		"\u01a9\n\f\2\2\u01a8\u01a5\3\2\2\2\u01a8\u01a7\3\2\2\2\u01a9\u01ac\3\2"+
		"\2\2\u01aa\u01a8\3\2\2\2\u01aa\u01ab\3\2\2\2\u01ab|\3\2\2\2\u01ac\u01aa"+
		"\3\2\2\2\u01ad\u01b1\7$\2\2\u01ae\u01b0\t\r\2\2\u01af\u01ae\3\2\2\2\u01b0"+
		"\u01b3\3\2\2\2\u01b1\u01b2\3\2\2\2\u01b1\u01af\3\2\2\2\u01b2\u01b4\3\2"+
		"\2\2\u01b3\u01b1\3\2\2\2\u01b4\u01b5\7^\2\2\u01b5\u01b6\n\13\2\2\u01b6"+
		"~\3\2\2\2\u01b7\u01b8\n\16\2\2\u01b8\u0080\3\2\2\2\32\2\u0084\u009a\u00a0"+
		"\u00aa\u015a\u015f\u0163\u0168\u016e\u0172\u0176\u0178\u017d\u017f\u0181"+
		"\u0186\u018b\u0192\u0194\u01a2\u01a8\u01aa\u01b1\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}