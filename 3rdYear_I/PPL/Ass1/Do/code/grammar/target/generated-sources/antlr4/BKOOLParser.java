// Generated from BKOOL.g4 by ANTLR 4.5.3

    package bkool.parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BKOOLParser extends Parser {
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
	public static final int
		RULE_program = 0;
	public static final String[] ruleNames = {
		"program"
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
	public String getGrammarFileName() { return "BKOOL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BKOOLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(BKOOLParser.ID, 0); }
		public TerminalNode LP() { return getToken(BKOOLParser.LP, 0); }
		public TerminalNode RP() { return getToken(BKOOLParser.RP, 0); }
		public TerminalNode EOF() { return getToken(BKOOLParser.EOF, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2);
			match(CLASS);
			setState(3);
			match(ID);
			setState(4);
			match(LP);
			setState(5);
			match(RP);
			setState(6);
			match(EOF);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3A\13\4\2\t\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\2\2\3\2\2\2\t\2\4\3\2\2\2\4\5\7\16\2\2\5\6\7<\2"+
		"\2\6\7\7\62\2\2\7\b\7\63\2\2\b\t\7\2\2\3\t\3\3\2\2\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}