// Generated from MC.g4 by ANTLR 4.5.3

	package MC.parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MCParser extends Parser {
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
		INTLIT=53, FLOATLIT=54, IDENTIFIER=55, STRINGLIT=56, BOOLEANLIT=57, UNCLOSE_STRING=58, 
		ID=59;
	public static final int
		RULE_program = 0;
	public static final String[] ruleNames = {
		"program"
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
		"STRINGLIT", "BOOLEANLIT", "UNCLOSE_STRING", "ID"
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
	public String getGrammarFileName() { return "MC.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MCParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MCParser.ID, 0); }
		public TerminalNode LP() { return getToken(MCParser.LP, 0); }
		public TerminalNode RP() { return getToken(MCParser.RP, 0); }
		public TerminalNode EOF() { return getToken(MCParser.EOF, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitProgram(this);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3=\13\4\2\t\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\2\2\3\2\2\2\t\2\4\3\2\2\2\4\5\7\n\2\2\5\6\7=\2"+
		"\2\6\7\7.\2\2\7\b\7/\2\2\b\t\7\2\2\3\t\3\3\2\2\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}