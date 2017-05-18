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
		T__0=1, T__1=2, WS=3, BLANK=4, TAB=5, FORMFEED=6, NEWLINE=7, CRETURN=8, 
		BLOCKCOMMENT=9, COMMENTLINE=10, COMMENT=11, BOOLEAN=12, BREAK=13, CLASS=14, 
		CONTINUE=15, DO=16, ELSE=17, EXTENDS=18, FLOAT=19, IF=20, INTEGER=21, 
		NEW=22, STRING=23, THEN=24, FOR=25, RETURN=26, VOID=27, NIL=28, THIS=29, 
		FINAL=30, DOWNTO=31, STATIC=32, PLUS=33, MUL=34, IN_DIV=35, NOTEQUAL=36, 
		LESS=37, LESSEQUAL=38, OR=39, NOT=40, OBJECTCREAT=41, SUB=42, FLOAT_DIV=43, 
		MODULUS=44, EQUAL=45, GREATER=46, AND=47, GREATEREQUAL=48, CONCAT=49, 
		ASSIGN=50, LSB=51, RSB=52, LP=53, RP=54, LB=55, RB=56, SEMICOLONE=57, 
		COLON=58, DOT=59, COMMA=60, INTLIT=61, BOOLEANLIT=62, FLOATLIT=63, ID=64, 
		STRINGLIT=65, PRIMITIVE_TYPE=66, UNCLOSE_STRING=67, ILLEGAL_ESCAPE=68, 
		ERROR_CHAR=69;
	public static final int
		RULE_type_notvoid = 0, RULE_program = 1, RULE_classDecl = 2, RULE_method_dec = 3, 
		RULE_listPara = 4, RULE_element_type_method = 5, RULE_iden_list = 6, RULE_list_expression = 7, 
		RULE_brace_list_expression = 8, RULE_member = 9, RULE_decl = 10, RULE_constant_dec_global = 11, 
		RULE_variable_dec_global = 12, RULE_element_type = 13, RULE_constant_dec = 14, 
		RULE_variable_dec = 15, RULE_para = 16, RULE_statement = 17, RULE_array_type = 18, 
		RULE_typeArray = 19, RULE_size = 20, RULE_class_type = 21, RULE_domain = 22, 
		RULE_expression = 23, RULE_block_stm = 24, RULE_asignment_statement = 25, 
		RULE_lhs = 26, RULE_if_statement = 27, RULE_for_statement = 28, RULE_scalar_variable = 29, 
		RULE_break_statement = 30, RULE_continue_statement = 31, RULE_return_statement = 32, 
		RULE_method_inovation = 33;
	public static final String[] ruleNames = {
		"type_notvoid", "program", "classDecl", "method_dec", "listPara", "element_type_method", 
		"iden_list", "list_expression", "brace_list_expression", "member", "decl", 
		"constant_dec_global", "variable_dec_global", "element_type", "constant_dec", 
		"variable_dec", "para", "statement", "array_type", "typeArray", "size", 
		"class_type", "domain", "expression", "block_stm", "asignment_statement", 
		"lhs", "if_statement", "for_statement", "scalar_variable", "break_statement", 
		"continue_statement", "return_statement", "method_inovation"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "'to'", null, null, null, null, null, null, null, null, null, 
		"'boolean'", "'break'", "'class'", "'continue'", "'do'", "'else'", "'extends'", 
		"'float'", "'if'", "'int'", null, "'string'", "'then'", "'for'", "'return'", 
		"'void'", "'nil'", "'this'", "'final'", "'downto'", "'static'", "'+'", 
		"'*'", "'\\'", "'!='", "'<'", "'<='", "'||'", "'!'", null, "'-'", "'/'", 
		"'%'", "'=='", "'>'", "'&&'", "'>='", "'^'", "':='", "'['", "']'", "'{'", 
		"'}'", "'('", "')'", "';'", "':'", "'.'", "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, "WS", "BLANK", "TAB", "FORMFEED", "NEWLINE", "CRETURN", 
		"BLOCKCOMMENT", "COMMENTLINE", "COMMENT", "BOOLEAN", "BREAK", "CLASS", 
		"CONTINUE", "DO", "ELSE", "EXTENDS", "FLOAT", "IF", "INTEGER", "NEW", 
		"STRING", "THEN", "FOR", "RETURN", "VOID", "NIL", "THIS", "FINAL", "DOWNTO", 
		"STATIC", "PLUS", "MUL", "IN_DIV", "NOTEQUAL", "LESS", "LESSEQUAL", "OR", 
		"NOT", "OBJECTCREAT", "SUB", "FLOAT_DIV", "MODULUS", "EQUAL", "GREATER", 
		"AND", "GREATEREQUAL", "CONCAT", "ASSIGN", "LSB", "RSB", "LP", "RP", "LB", 
		"RB", "SEMICOLONE", "COLON", "DOT", "COMMA", "INTLIT", "BOOLEANLIT", "FLOATLIT", 
		"ID", "STRINGLIT", "PRIMITIVE_TYPE", "UNCLOSE_STRING", "ILLEGAL_ESCAPE", 
		"ERROR_CHAR"
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
	public static class Type_notvoidContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(BKOOLParser.INTEGER, 0); }
		public TerminalNode FLOAT() { return getToken(BKOOLParser.FLOAT, 0); }
		public TerminalNode BOOLEAN() { return getToken(BKOOLParser.BOOLEAN, 0); }
		public TerminalNode STRING() { return getToken(BKOOLParser.STRING, 0); }
		public Type_notvoidContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_notvoid; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitType_notvoid(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_notvoidContext type_notvoid() throws RecognitionException {
		Type_notvoidContext _localctx = new Type_notvoidContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_type_notvoid);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << FLOAT) | (1L << INTEGER) | (1L << STRING))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
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

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(BKOOLParser.EOF, 0); }
		public List<ClassDeclContext> classDecl() {
			return getRuleContexts(ClassDeclContext.class);
		}
		public ClassDeclContext classDecl(int i) {
			return getRuleContext(ClassDeclContext.class,i);
		}
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
		enterRule(_localctx, 2, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(70);
				classDecl();
				}
				}
				setState(73); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CLASS );
			setState(75);
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

	public static class ClassDeclContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(BKOOLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(BKOOLParser.ID, i);
		}
		public TerminalNode LP() { return getToken(BKOOLParser.LP, 0); }
		public TerminalNode RP() { return getToken(BKOOLParser.RP, 0); }
		public List<MemberContext> member() {
			return getRuleContexts(MemberContext.class);
		}
		public MemberContext member(int i) {
			return getRuleContext(MemberContext.class,i);
		}
		public ClassDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitClassDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclContext classDecl() throws RecognitionException {
		ClassDeclContext _localctx = new ClassDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_classDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(CLASS);
			setState(78);
			match(ID);
			setState(81);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(79);
				match(EXTENDS);
				setState(80);
				match(ID);
				}
			}

			setState(83);
			match(LP);
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 12)) & ~0x3f) == 0 && ((1L << (_la - 12)) & ((1L << (BOOLEAN - 12)) | (1L << (FLOAT - 12)) | (1L << (INTEGER - 12)) | (1L << (STRING - 12)) | (1L << (VOID - 12)) | (1L << (FINAL - 12)) | (1L << (STATIC - 12)) | (1L << (ID - 12)))) != 0)) {
				{
				{
				setState(84);
				member();
				}
				}
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(90);
			match(RP);
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

	public static class Method_decContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(BKOOLParser.ID, 0); }
		public TerminalNode LB() { return getToken(BKOOLParser.LB, 0); }
		public ListParaContext listPara() {
			return getRuleContext(ListParaContext.class,0);
		}
		public TerminalNode RB() { return getToken(BKOOLParser.RB, 0); }
		public Block_stmContext block_stm() {
			return getRuleContext(Block_stmContext.class,0);
		}
		public Element_type_methodContext element_type_method() {
			return getRuleContext(Element_type_methodContext.class,0);
		}
		public TerminalNode STATIC() { return getToken(BKOOLParser.STATIC, 0); }
		public Method_decContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_dec; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitMethod_dec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Method_decContext method_dec() throws RecognitionException {
		Method_decContext _localctx = new Method_decContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_method_dec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(92);
				element_type_method();
				}
				break;
			}
			setState(96);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(95);
				match(STATIC);
				}
			}

			setState(98);
			match(ID);
			setState(99);
			match(LB);
			setState(100);
			listPara();
			setState(101);
			match(RB);
			setState(102);
			block_stm();
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

	public static class ListParaContext extends ParserRuleContext {
		public List<ParaContext> para() {
			return getRuleContexts(ParaContext.class);
		}
		public ParaContext para(int i) {
			return getRuleContext(ParaContext.class,i);
		}
		public List<TerminalNode> SEMICOLONE() { return getTokens(BKOOLParser.SEMICOLONE); }
		public TerminalNode SEMICOLONE(int i) {
			return getToken(BKOOLParser.SEMICOLONE, i);
		}
		public ListParaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listPara; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitListPara(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListParaContext listPara() throws RecognitionException {
		ListParaContext _localctx = new ListParaContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_listPara);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(109);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(104);
						para();
						setState(105);
						match(SEMICOLONE);
						}
						} 
					}
					setState(111);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				}
				setState(112);
				para();
				}
			}

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

	public static class Element_type_methodContext extends ParserRuleContext {
		public Element_typeContext element_type() {
			return getRuleContext(Element_typeContext.class,0);
		}
		public TerminalNode VOID() { return getToken(BKOOLParser.VOID, 0); }
		public Element_type_methodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_element_type_method; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitElement_type_method(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Element_type_methodContext element_type_method() throws RecognitionException {
		Element_type_methodContext _localctx = new Element_type_methodContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_element_type_method);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case FLOAT:
			case INTEGER:
			case STRING:
			case ID:
				{
				setState(115);
				element_type();
				}
				break;
			case VOID:
				{
				setState(116);
				match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
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

	public static class Iden_listContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(BKOOLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(BKOOLParser.ID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(BKOOLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BKOOLParser.COMMA, i);
		}
		public Iden_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iden_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitIden_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Iden_listContext iden_list() throws RecognitionException {
		Iden_listContext _localctx = new Iden_listContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_iden_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(119);
					match(ID);
					setState(120);
					match(COMMA);
					}
					} 
				}
				setState(125);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			setState(126);
			match(ID);
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

	public static class List_expressionContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(BKOOLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BKOOLParser.COMMA, i);
		}
		public List_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitList_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final List_expressionContext list_expression() throws RecognitionException {
		List_expressionContext _localctx = new List_expressionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_list_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			_la = _input.LA(1);
			if (((((_la - 22)) & ~0x3f) == 0 && ((1L << (_la - 22)) & ((1L << (NEW - 22)) | (1L << (NIL - 22)) | (1L << (THIS - 22)) | (1L << (PLUS - 22)) | (1L << (NOT - 22)) | (1L << (SUB - 22)) | (1L << (LB - 22)) | (1L << (INTLIT - 22)) | (1L << (BOOLEANLIT - 22)) | (1L << (FLOATLIT - 22)) | (1L << (ID - 22)) | (1L << (STRINGLIT - 22)))) != 0)) {
				{
				setState(133);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(128);
						expression(0);
						setState(129);
						match(COMMA);
						}
						} 
					}
					setState(135);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				}
				setState(136);
				expression(0);
				}
			}

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

	public static class Brace_list_expressionContext extends ParserRuleContext {
		public TerminalNode LB() { return getToken(BKOOLParser.LB, 0); }
		public List_expressionContext list_expression() {
			return getRuleContext(List_expressionContext.class,0);
		}
		public TerminalNode RB() { return getToken(BKOOLParser.RB, 0); }
		public Brace_list_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_brace_list_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitBrace_list_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Brace_list_expressionContext brace_list_expression() throws RecognitionException {
		Brace_list_expressionContext _localctx = new Brace_list_expressionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_brace_list_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(LB);
			setState(140);
			list_expression();
			setState(141);
			match(RB);
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

	public static class MemberContext extends ParserRuleContext {
		public Constant_dec_globalContext constant_dec_global() {
			return getRuleContext(Constant_dec_globalContext.class,0);
		}
		public Variable_dec_globalContext variable_dec_global() {
			return getRuleContext(Variable_dec_globalContext.class,0);
		}
		public Method_decContext method_dec() {
			return getRuleContext(Method_decContext.class,0);
		}
		public MemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_member; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitMember(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MemberContext member() throws RecognitionException {
		MemberContext _localctx = new MemberContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_member);
		try {
			setState(146);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(143);
				constant_dec_global();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(144);
				variable_dec_global();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(145);
				method_dec();
				}
				break;
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

	public static class DeclContext extends ParserRuleContext {
		public Constant_decContext constant_dec() {
			return getRuleContext(Constant_decContext.class,0);
		}
		public Variable_decContext variable_dec() {
			return getRuleContext(Variable_decContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(148);
				constant_dec();
				}
				break;
			case 2:
				{
				setState(149);
				variable_dec();
				}
				break;
			}
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

	public static class Constant_dec_globalContext extends ParserRuleContext {
		public TerminalNode FINAL() { return getToken(BKOOLParser.FINAL, 0); }
		public Element_typeContext element_type() {
			return getRuleContext(Element_typeContext.class,0);
		}
		public TerminalNode ID() { return getToken(BKOOLParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLONE() { return getToken(BKOOLParser.SEMICOLONE, 0); }
		public TerminalNode STATIC() { return getToken(BKOOLParser.STATIC, 0); }
		public Constant_dec_globalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant_dec_global; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitConstant_dec_global(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Constant_dec_globalContext constant_dec_global() throws RecognitionException {
		Constant_dec_globalContext _localctx = new Constant_dec_globalContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_constant_dec_global);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(152);
				match(STATIC);
				}
			}

			setState(155);
			match(FINAL);
			setState(156);
			element_type();
			setState(157);
			match(ID);
			setState(158);
			match(T__0);
			setState(159);
			expression(0);
			setState(160);
			match(SEMICOLONE);
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

	public static class Variable_dec_globalContext extends ParserRuleContext {
		public Iden_listContext iden_list() {
			return getRuleContext(Iden_listContext.class,0);
		}
		public TerminalNode COLON() { return getToken(BKOOLParser.COLON, 0); }
		public Element_typeContext element_type() {
			return getRuleContext(Element_typeContext.class,0);
		}
		public TerminalNode SEMICOLONE() { return getToken(BKOOLParser.SEMICOLONE, 0); }
		public TerminalNode STATIC() { return getToken(BKOOLParser.STATIC, 0); }
		public Variable_dec_globalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_dec_global; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitVariable_dec_global(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Variable_dec_globalContext variable_dec_global() throws RecognitionException {
		Variable_dec_globalContext _localctx = new Variable_dec_globalContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_variable_dec_global);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(162);
				match(STATIC);
				}
			}

			setState(165);
			iden_list();
			setState(166);
			match(COLON);
			setState(167);
			element_type();
			setState(168);
			match(SEMICOLONE);
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

	public static class Element_typeContext extends ParserRuleContext {
		public Type_notvoidContext type_notvoid() {
			return getRuleContext(Type_notvoidContext.class,0);
		}
		public Array_typeContext array_type() {
			return getRuleContext(Array_typeContext.class,0);
		}
		public Class_typeContext class_type() {
			return getRuleContext(Class_typeContext.class,0);
		}
		public Element_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_element_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitElement_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Element_typeContext element_type() throws RecognitionException {
		Element_typeContext _localctx = new Element_typeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_element_type);
		try {
			setState(173);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(170);
				type_notvoid();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(171);
				array_type();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(172);
				class_type();
				}
				break;
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

	public static class Constant_decContext extends ParserRuleContext {
		public TerminalNode FINAL() { return getToken(BKOOLParser.FINAL, 0); }
		public Element_typeContext element_type() {
			return getRuleContext(Element_typeContext.class,0);
		}
		public TerminalNode ID() { return getToken(BKOOLParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLONE() { return getToken(BKOOLParser.SEMICOLONE, 0); }
		public TerminalNode STATIC() { return getToken(BKOOLParser.STATIC, 0); }
		public Constant_decContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant_dec; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitConstant_dec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Constant_decContext constant_dec() throws RecognitionException {
		Constant_decContext _localctx = new Constant_decContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_constant_dec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(175);
				match(STATIC);
				}
			}

			setState(178);
			match(FINAL);
			setState(179);
			element_type();
			setState(180);
			match(ID);
			setState(181);
			match(T__0);
			setState(182);
			expression(0);
			setState(183);
			match(SEMICOLONE);
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

	public static class Variable_decContext extends ParserRuleContext {
		public Iden_listContext iden_list() {
			return getRuleContext(Iden_listContext.class,0);
		}
		public TerminalNode COLON() { return getToken(BKOOLParser.COLON, 0); }
		public Element_typeContext element_type() {
			return getRuleContext(Element_typeContext.class,0);
		}
		public TerminalNode SEMICOLONE() { return getToken(BKOOLParser.SEMICOLONE, 0); }
		public TerminalNode STATIC() { return getToken(BKOOLParser.STATIC, 0); }
		public Variable_decContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_dec; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitVariable_dec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Variable_decContext variable_dec() throws RecognitionException {
		Variable_decContext _localctx = new Variable_decContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_variable_dec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(185);
				match(STATIC);
				}
			}

			setState(188);
			iden_list();
			setState(189);
			match(COLON);
			setState(190);
			element_type();
			setState(191);
			match(SEMICOLONE);
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

	public static class ParaContext extends ParserRuleContext {
		public Iden_listContext iden_list() {
			return getRuleContext(Iden_listContext.class,0);
		}
		public TerminalNode COLON() { return getToken(BKOOLParser.COLON, 0); }
		public Element_typeContext element_type() {
			return getRuleContext(Element_typeContext.class,0);
		}
		public ParaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_para; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitPara(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParaContext para() throws RecognitionException {
		ParaContext _localctx = new ParaContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_para);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			iden_list();
			setState(194);
			match(COLON);
			setState(195);
			element_type();
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

	public static class StatementContext extends ParserRuleContext {
		public Asignment_statementContext asignment_statement() {
			return getRuleContext(Asignment_statementContext.class,0);
		}
		public If_statementContext if_statement() {
			return getRuleContext(If_statementContext.class,0);
		}
		public For_statementContext for_statement() {
			return getRuleContext(For_statementContext.class,0);
		}
		public Break_statementContext break_statement() {
			return getRuleContext(Break_statementContext.class,0);
		}
		public Continue_statementContext continue_statement() {
			return getRuleContext(Continue_statementContext.class,0);
		}
		public Return_statementContext return_statement() {
			return getRuleContext(Return_statementContext.class,0);
		}
		public Method_inovationContext method_inovation() {
			return getRuleContext(Method_inovationContext.class,0);
		}
		public Block_stmContext block_stm() {
			return getRuleContext(Block_stmContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_statement);
		try {
			setState(205);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(197);
				asignment_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(198);
				if_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(199);
				for_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(200);
				break_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(201);
				continue_statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(202);
				return_statement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(203);
				method_inovation();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(204);
				block_stm();
				}
				break;
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

	public static class Array_typeContext extends ParserRuleContext {
		public TypeArrayContext typeArray() {
			return getRuleContext(TypeArrayContext.class,0);
		}
		public TerminalNode LSB() { return getToken(BKOOLParser.LSB, 0); }
		public SizeContext size() {
			return getRuleContext(SizeContext.class,0);
		}
		public TerminalNode RSB() { return getToken(BKOOLParser.RSB, 0); }
		public Array_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitArray_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_typeContext array_type() throws RecognitionException {
		Array_typeContext _localctx = new Array_typeContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_array_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			typeArray();
			setState(208);
			match(LSB);
			setState(209);
			size();
			setState(210);
			match(RSB);
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

	public static class TypeArrayContext extends ParserRuleContext {
		public Type_notvoidContext type_notvoid() {
			return getRuleContext(Type_notvoidContext.class,0);
		}
		public TerminalNode ID() { return getToken(BKOOLParser.ID, 0); }
		public TypeArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArray; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitTypeArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeArrayContext typeArray() throws RecognitionException {
		TypeArrayContext _localctx = new TypeArrayContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_typeArray);
		try {
			setState(214);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case FLOAT:
			case INTEGER:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(212);
				type_notvoid();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(213);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class SizeContext extends ParserRuleContext {
		public TerminalNode INTLIT() { return getToken(BKOOLParser.INTLIT, 0); }
		public SizeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_size; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitSize(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SizeContext size() throws RecognitionException {
		SizeContext _localctx = new SizeContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_size);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			match(INTLIT);
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

	public static class Class_typeContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(BKOOLParser.ID, 0); }
		public Class_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitClass_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_typeContext class_type() throws RecognitionException {
		Class_typeContext _localctx = new Class_typeContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_class_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			match(ID);
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

	public static class DomainContext extends ParserRuleContext {
		public TerminalNode INTLIT() { return getToken(BKOOLParser.INTLIT, 0); }
		public TerminalNode STRINGLIT() { return getToken(BKOOLParser.STRINGLIT, 0); }
		public TerminalNode FLOATLIT() { return getToken(BKOOLParser.FLOATLIT, 0); }
		public TerminalNode BOOLEANLIT() { return getToken(BKOOLParser.BOOLEANLIT, 0); }
		public TerminalNode THIS() { return getToken(BKOOLParser.THIS, 0); }
		public TerminalNode NIL() { return getToken(BKOOLParser.NIL, 0); }
		public TerminalNode ID() { return getToken(BKOOLParser.ID, 0); }
		public DomainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_domain; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitDomain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DomainContext domain() throws RecognitionException {
		DomainContext _localctx = new DomainContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_domain);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			_la = _input.LA(1);
			if ( !(((((_la - 28)) & ~0x3f) == 0 && ((1L << (_la - 28)) & ((1L << (NIL - 28)) | (1L << (THIS - 28)) | (1L << (INTLIT - 28)) | (1L << (BOOLEANLIT - 28)) | (1L << (FLOATLIT - 28)) | (1L << (ID - 28)) | (1L << (STRINGLIT - 28)))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NewExpContext extends ExpressionContext {
		public TerminalNode NEW() { return getToken(BKOOLParser.NEW, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LB() { return getToken(BKOOLParser.LB, 0); }
		public List_expressionContext list_expression() {
			return getRuleContext(List_expressionContext.class,0);
		}
		public TerminalNode RB() { return getToken(BKOOLParser.RB, 0); }
		public NewExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitNewExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinaryPSOpContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(BKOOLParser.PLUS, 0); }
		public TerminalNode SUB() { return getToken(BKOOLParser.SUB, 0); }
		public BinaryPSOpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitBinaryPSOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryPSOpContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(BKOOLParser.PLUS, 0); }
		public TerminalNode SUB() { return getToken(BKOOLParser.SUB, 0); }
		public UnaryPSOpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitUnaryPSOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BraceExpContext extends ExpressionContext {
		public TerminalNode LB() { return getToken(BKOOLParser.LB, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RB() { return getToken(BKOOLParser.RB, 0); }
		public BraceExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitBraceExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinaryAOOpContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AND() { return getToken(BKOOLParser.AND, 0); }
		public TerminalNode OR() { return getToken(BKOOLParser.OR, 0); }
		public BinaryAOOpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitBinaryAOOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CallExpContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DOT() { return getToken(BKOOLParser.DOT, 0); }
		public TerminalNode ID() { return getToken(BKOOLParser.ID, 0); }
		public Brace_list_expressionContext brace_list_expression() {
			return getRuleContext(Brace_list_expressionContext.class,0);
		}
		public CallExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitCallExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinaryEQOpContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EQUAL() { return getToken(BKOOLParser.EQUAL, 0); }
		public TerminalNode NOTEQUAL() { return getToken(BKOOLParser.NOTEQUAL, 0); }
		public BinaryEQOpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitBinaryEQOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinaryGLOpContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode GREATER() { return getToken(BKOOLParser.GREATER, 0); }
		public TerminalNode GREATEREQUAL() { return getToken(BKOOLParser.GREATEREQUAL, 0); }
		public TerminalNode LESS() { return getToken(BKOOLParser.LESS, 0); }
		public TerminalNode LESSEQUAL() { return getToken(BKOOLParser.LESSEQUAL, 0); }
		public BinaryGLOpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitBinaryGLOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EndContext extends ExpressionContext {
		public DomainContext domain() {
			return getRuleContext(DomainContext.class,0);
		}
		public EndContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitEnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinaryMFIMOpContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MUL() { return getToken(BKOOLParser.MUL, 0); }
		public TerminalNode FLOAT_DIV() { return getToken(BKOOLParser.FLOAT_DIV, 0); }
		public TerminalNode IN_DIV() { return getToken(BKOOLParser.IN_DIV, 0); }
		public TerminalNode MODULUS() { return getToken(BKOOLParser.MODULUS, 0); }
		public BinaryMFIMOpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitBinaryMFIMOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryNOpContext extends ExpressionContext {
		public TerminalNode NOT() { return getToken(BKOOLParser.NOT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public UnaryNOpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitUnaryNOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinaryCOpContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode CONCAT() { return getToken(BKOOLParser.CONCAT, 0); }
		public BinaryCOpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitBinaryCOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IndexExpContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LSB() { return getToken(BKOOLParser.LSB, 0); }
		public TerminalNode RSB() { return getToken(BKOOLParser.RSB, 0); }
		public IndexExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitIndexExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			switch (_input.LA(1)) {
			case LB:
				{
				_localctx = new BraceExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(223);
				match(LB);
				setState(224);
				expression(0);
				setState(225);
				match(RB);
				}
				break;
			case NEW:
				{
				_localctx = new NewExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(227);
				match(NEW);
				setState(228);
				expression(0);
				{
				setState(229);
				match(LB);
				setState(230);
				list_expression();
				setState(231);
				match(RB);
				}
				}
				break;
			case PLUS:
			case SUB:
				{
				_localctx = new UnaryPSOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(233);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==SUB) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(234);
				expression(9);
				}
				break;
			case NOT:
				{
				_localctx = new UnaryNOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(235);
				match(NOT);
				setState(236);
				expression(8);
				}
				break;
			case NIL:
			case THIS:
			case INTLIT:
			case BOOLEANLIT:
			case FLOATLIT:
			case ID:
			case STRINGLIT:
				{
				_localctx = new EndContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(237);
				domain();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(271);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(269);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryCOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(240);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(241);
						match(CONCAT);
						setState(242);
						expression(8);
						}
						break;
					case 2:
						{
						_localctx = new BinaryMFIMOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(243);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(244);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << IN_DIV) | (1L << FLOAT_DIV) | (1L << MODULUS))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(245);
						expression(7);
						}
						break;
					case 3:
						{
						_localctx = new BinaryPSOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(246);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(247);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==SUB) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(248);
						expression(6);
						}
						break;
					case 4:
						{
						_localctx = new BinaryAOOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(249);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(250);
						_la = _input.LA(1);
						if ( !(_la==OR || _la==AND) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(251);
						expression(5);
						}
						break;
					case 5:
						{
						_localctx = new BinaryEQOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(252);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(253);
						_la = _input.LA(1);
						if ( !(_la==NOTEQUAL || _la==EQUAL) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(254);
						expression(4);
						}
						break;
					case 6:
						{
						_localctx = new BinaryGLOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(255);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(256);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LESS) | (1L << LESSEQUAL) | (1L << GREATER) | (1L << GREATEREQUAL))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(257);
						expression(3);
						}
						break;
					case 7:
						{
						_localctx = new CallExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(258);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(259);
						match(DOT);
						setState(260);
						match(ID);
						setState(262);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
						case 1:
							{
							setState(261);
							brace_list_expression();
							}
							break;
						}
						}
						break;
					case 8:
						{
						_localctx = new IndexExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(264);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(265);
						match(LSB);
						setState(266);
						expression(0);
						setState(267);
						match(RSB);
						}
						break;
					}
					} 
				}
				setState(273);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Block_stmContext extends ParserRuleContext {
		public TerminalNode LP() { return getToken(BKOOLParser.LP, 0); }
		public TerminalNode RP() { return getToken(BKOOLParser.RP, 0); }
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Block_stmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block_stm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitBlock_stm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Block_stmContext block_stm() throws RecognitionException {
		Block_stmContext _localctx = new Block_stmContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_block_stm);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			match(LP);
			setState(278);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(275);
					decl();
					}
					} 
				}
				setState(280);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			setState(284);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 13)) & ~0x3f) == 0 && ((1L << (_la - 13)) & ((1L << (BREAK - 13)) | (1L << (CONTINUE - 13)) | (1L << (IF - 13)) | (1L << (NEW - 13)) | (1L << (FOR - 13)) | (1L << (RETURN - 13)) | (1L << (NIL - 13)) | (1L << (THIS - 13)) | (1L << (PLUS - 13)) | (1L << (NOT - 13)) | (1L << (SUB - 13)) | (1L << (LP - 13)) | (1L << (LB - 13)) | (1L << (INTLIT - 13)) | (1L << (BOOLEANLIT - 13)) | (1L << (FLOATLIT - 13)) | (1L << (ID - 13)) | (1L << (STRINGLIT - 13)))) != 0)) {
				{
				{
				setState(281);
				statement();
				}
				}
				setState(286);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(287);
			match(RP);
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

	public static class Asignment_statementContext extends ParserRuleContext {
		public LhsContext lhs() {
			return getRuleContext(LhsContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(BKOOLParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLONE() { return getToken(BKOOLParser.SEMICOLONE, 0); }
		public Asignment_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asignment_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitAsignment_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Asignment_statementContext asignment_statement() throws RecognitionException {
		Asignment_statementContext _localctx = new Asignment_statementContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_asignment_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			lhs();
			setState(290);
			match(ASSIGN);
			setState(291);
			expression(0);
			setState(292);
			match(SEMICOLONE);
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

	public static class LhsContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(BKOOLParser.ID, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode DOT() { return getToken(BKOOLParser.DOT, 0); }
		public TerminalNode LSB() { return getToken(BKOOLParser.LSB, 0); }
		public TerminalNode RSB() { return getToken(BKOOLParser.RSB, 0); }
		public LhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lhs; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitLhs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LhsContext lhs() throws RecognitionException {
		LhsContext _localctx = new LhsContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_lhs);
		try {
			setState(304);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(294);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(295);
				expression(0);
				setState(296);
				match(DOT);
				setState(297);
				match(ID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(299);
				expression(0);
				setState(300);
				match(LSB);
				setState(301);
				expression(0);
				setState(302);
				match(RSB);
				}
				break;
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

	public static class If_statementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(BKOOLParser.IF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode THEN() { return getToken(BKOOLParser.THEN, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(BKOOLParser.ELSE, 0); }
		public If_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitIf_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_statementContext if_statement() throws RecognitionException {
		If_statementContext _localctx = new If_statementContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_if_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			match(IF);
			setState(307);
			expression(0);
			setState(308);
			match(THEN);
			{
			setState(309);
			statement();
			}
			setState(312);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(310);
				match(ELSE);
				{
				setState(311);
				statement();
				}
				}
				break;
			}
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

	public static class For_statementContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(BKOOLParser.FOR, 0); }
		public Scalar_variableContext scalar_variable() {
			return getRuleContext(Scalar_variableContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(BKOOLParser.ASSIGN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode DO() { return getToken(BKOOLParser.DO, 0); }
		public TerminalNode DOWNTO() { return getToken(BKOOLParser.DOWNTO, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public For_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitFor_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_statementContext for_statement() throws RecognitionException {
		For_statementContext _localctx = new For_statementContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_for_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			match(FOR);
			setState(315);
			scalar_variable();
			setState(316);
			match(ASSIGN);
			setState(317);
			expression(0);
			setState(318);
			_la = _input.LA(1);
			if ( !(_la==T__1 || _la==DOWNTO) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(319);
			expression(0);
			setState(320);
			match(DO);
			{
			setState(321);
			statement();
			}
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

	public static class Scalar_variableContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(BKOOLParser.ID, 0); }
		public Scalar_variableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scalar_variable; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitScalar_variable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Scalar_variableContext scalar_variable() throws RecognitionException {
		Scalar_variableContext _localctx = new Scalar_variableContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_scalar_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323);
			match(ID);
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

	public static class Break_statementContext extends ParserRuleContext {
		public TerminalNode BREAK() { return getToken(BKOOLParser.BREAK, 0); }
		public TerminalNode SEMICOLONE() { return getToken(BKOOLParser.SEMICOLONE, 0); }
		public Break_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_break_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitBreak_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Break_statementContext break_statement() throws RecognitionException {
		Break_statementContext _localctx = new Break_statementContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_break_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			match(BREAK);
			setState(326);
			match(SEMICOLONE);
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

	public static class Continue_statementContext extends ParserRuleContext {
		public TerminalNode CONTINUE() { return getToken(BKOOLParser.CONTINUE, 0); }
		public TerminalNode SEMICOLONE() { return getToken(BKOOLParser.SEMICOLONE, 0); }
		public Continue_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continue_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitContinue_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Continue_statementContext continue_statement() throws RecognitionException {
		Continue_statementContext _localctx = new Continue_statementContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_continue_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			match(CONTINUE);
			setState(329);
			match(SEMICOLONE);
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

	public static class Return_statementContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(BKOOLParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLONE() { return getToken(BKOOLParser.SEMICOLONE, 0); }
		public Return_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitReturn_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_statementContext return_statement() throws RecognitionException {
		Return_statementContext _localctx = new Return_statementContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_return_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			match(RETURN);
			setState(332);
			expression(0);
			setState(333);
			match(SEMICOLONE);
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

	public static class Method_inovationContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DOT() { return getToken(BKOOLParser.DOT, 0); }
		public TerminalNode ID() { return getToken(BKOOLParser.ID, 0); }
		public TerminalNode SEMICOLONE() { return getToken(BKOOLParser.SEMICOLONE, 0); }
		public TerminalNode LB() { return getToken(BKOOLParser.LB, 0); }
		public List_expressionContext list_expression() {
			return getRuleContext(List_expressionContext.class,0);
		}
		public TerminalNode RB() { return getToken(BKOOLParser.RB, 0); }
		public Method_inovationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_inovation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitMethod_inovation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Method_inovationContext method_inovation() throws RecognitionException {
		Method_inovationContext _localctx = new Method_inovationContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_method_inovation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
			expression(0);
			setState(336);
			match(DOT);
			setState(337);
			match(ID);
			setState(342);
			_la = _input.LA(1);
			if (_la==LB) {
				{
				setState(338);
				match(LB);
				setState(339);
				list_expression();
				setState(340);
				match(RB);
				}
			}

			setState(344);
			match(SEMICOLONE);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 23:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 4);
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		case 6:
			return precpred(_ctx, 11);
		case 7:
			return precpred(_ctx, 10);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3G\u015d\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\3\3\6\3J\n\3\r\3\16\3K\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\5\4T\n\4\3\4\3\4\7\4X\n\4\f\4\16\4[\13\4\3\4\3\4\3\5\5\5`\n\5\3\5\5"+
		"\5c\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\7\6n\n\6\f\6\16\6q\13\6\3"+
		"\6\5\6t\n\6\3\7\3\7\5\7x\n\7\3\b\3\b\7\b|\n\b\f\b\16\b\177\13\b\3\b\3"+
		"\b\3\t\3\t\3\t\7\t\u0086\n\t\f\t\16\t\u0089\13\t\3\t\5\t\u008c\n\t\3\n"+
		"\3\n\3\n\3\n\3\13\3\13\3\13\5\13\u0095\n\13\3\f\3\f\5\f\u0099\n\f\3\r"+
		"\5\r\u009c\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\5\16\u00a6\n\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\17\3\17\3\17\5\17\u00b0\n\17\3\20\5\20\u00b3\n\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\5\21\u00bd\n\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\5\23\u00d0\n\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\5\25\u00d9\n\25\3"+
		"\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u00f1\n\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\5\31\u0109\n\31\3\31\3\31\3\31\3\31\3\31\7\31"+
		"\u0110\n\31\f\31\16\31\u0113\13\31\3\32\3\32\7\32\u0117\n\32\f\32\16\32"+
		"\u011a\13\32\3\32\7\32\u011d\n\32\f\32\16\32\u0120\13\32\3\32\3\32\3\33"+
		"\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\5\34\u0133\n\34\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u013b\n\35\3\36\3"+
		"\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3 \3 \3 \3!\3!\3!\3\""+
		"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\5#\u0159\n#\3#\3#\3#\2\3\60$\2\4\6\b"+
		"\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BD\2\n\6\2\16"+
		"\16\25\25\27\27\31\31\4\2\36\37?C\4\2##,,\4\2$%-.\4\2))\61\61\4\2&&//"+
		"\5\2\'(\60\60\62\62\4\2\4\4!!\u0169\2F\3\2\2\2\4I\3\2\2\2\6O\3\2\2\2\b"+
		"_\3\2\2\2\ns\3\2\2\2\fw\3\2\2\2\16}\3\2\2\2\20\u008b\3\2\2\2\22\u008d"+
		"\3\2\2\2\24\u0094\3\2\2\2\26\u0098\3\2\2\2\30\u009b\3\2\2\2\32\u00a5\3"+
		"\2\2\2\34\u00af\3\2\2\2\36\u00b2\3\2\2\2 \u00bc\3\2\2\2\"\u00c3\3\2\2"+
		"\2$\u00cf\3\2\2\2&\u00d1\3\2\2\2(\u00d8\3\2\2\2*\u00da\3\2\2\2,\u00dc"+
		"\3\2\2\2.\u00de\3\2\2\2\60\u00f0\3\2\2\2\62\u0114\3\2\2\2\64\u0123\3\2"+
		"\2\2\66\u0132\3\2\2\28\u0134\3\2\2\2:\u013c\3\2\2\2<\u0145\3\2\2\2>\u0147"+
		"\3\2\2\2@\u014a\3\2\2\2B\u014d\3\2\2\2D\u0151\3\2\2\2FG\t\2\2\2G\3\3\2"+
		"\2\2HJ\5\6\4\2IH\3\2\2\2JK\3\2\2\2KI\3\2\2\2KL\3\2\2\2LM\3\2\2\2MN\7\2"+
		"\2\3N\5\3\2\2\2OP\7\20\2\2PS\7B\2\2QR\7\24\2\2RT\7B\2\2SQ\3\2\2\2ST\3"+
		"\2\2\2TU\3\2\2\2UY\7\67\2\2VX\5\24\13\2WV\3\2\2\2X[\3\2\2\2YW\3\2\2\2"+
		"YZ\3\2\2\2Z\\\3\2\2\2[Y\3\2\2\2\\]\78\2\2]\7\3\2\2\2^`\5\f\7\2_^\3\2\2"+
		"\2_`\3\2\2\2`b\3\2\2\2ac\7\"\2\2ba\3\2\2\2bc\3\2\2\2cd\3\2\2\2de\7B\2"+
		"\2ef\79\2\2fg\5\n\6\2gh\7:\2\2hi\5\62\32\2i\t\3\2\2\2jk\5\"\22\2kl\7;"+
		"\2\2ln\3\2\2\2mj\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2pr\3\2\2\2qo\3\2"+
		"\2\2rt\5\"\22\2so\3\2\2\2st\3\2\2\2t\13\3\2\2\2ux\5\34\17\2vx\7\35\2\2"+
		"wu\3\2\2\2wv\3\2\2\2x\r\3\2\2\2yz\7B\2\2z|\7>\2\2{y\3\2\2\2|\177\3\2\2"+
		"\2}{\3\2\2\2}~\3\2\2\2~\u0080\3\2\2\2\177}\3\2\2\2\u0080\u0081\7B\2\2"+
		"\u0081\17\3\2\2\2\u0082\u0083\5\60\31\2\u0083\u0084\7>\2\2\u0084\u0086"+
		"\3\2\2\2\u0085\u0082\3\2\2\2\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087"+
		"\u0088\3\2\2\2\u0088\u008a\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u008c\5\60"+
		"\31\2\u008b\u0087\3\2\2\2\u008b\u008c\3\2\2\2\u008c\21\3\2\2\2\u008d\u008e"+
		"\79\2\2\u008e\u008f\5\20\t\2\u008f\u0090\7:\2\2\u0090\23\3\2\2\2\u0091"+
		"\u0095\5\30\r\2\u0092\u0095\5\32\16\2\u0093\u0095\5\b\5\2\u0094\u0091"+
		"\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0093\3\2\2\2\u0095\25\3\2\2\2\u0096"+
		"\u0099\5\36\20\2\u0097\u0099\5 \21\2\u0098\u0096\3\2\2\2\u0098\u0097\3"+
		"\2\2\2\u0099\27\3\2\2\2\u009a\u009c\7\"\2\2\u009b\u009a\3\2\2\2\u009b"+
		"\u009c\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009e\7 \2\2\u009e\u009f\5\34"+
		"\17\2\u009f\u00a0\7B\2\2\u00a0\u00a1\7\3\2\2\u00a1\u00a2\5\60\31\2\u00a2"+
		"\u00a3\7;\2\2\u00a3\31\3\2\2\2\u00a4\u00a6\7\"\2\2\u00a5\u00a4\3\2\2\2"+
		"\u00a5\u00a6\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\5\16\b\2\u00a8\u00a9"+
		"\7<\2\2\u00a9\u00aa\5\34\17\2\u00aa\u00ab\7;\2\2\u00ab\33\3\2\2\2\u00ac"+
		"\u00b0\5\2\2\2\u00ad\u00b0\5&\24\2\u00ae\u00b0\5,\27\2\u00af\u00ac\3\2"+
		"\2\2\u00af\u00ad\3\2\2\2\u00af\u00ae\3\2\2\2\u00b0\35\3\2\2\2\u00b1\u00b3"+
		"\7\"\2\2\u00b2\u00b1\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4"+
		"\u00b5\7 \2\2\u00b5\u00b6\5\34\17\2\u00b6\u00b7\7B\2\2\u00b7\u00b8\7\3"+
		"\2\2\u00b8\u00b9\5\60\31\2\u00b9\u00ba\7;\2\2\u00ba\37\3\2\2\2\u00bb\u00bd"+
		"\7\"\2\2\u00bc\u00bb\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00be\3\2\2\2\u00be"+
		"\u00bf\5\16\b\2\u00bf\u00c0\7<\2\2\u00c0\u00c1\5\34\17\2\u00c1\u00c2\7"+
		";\2\2\u00c2!\3\2\2\2\u00c3\u00c4\5\16\b\2\u00c4\u00c5\7<\2\2\u00c5\u00c6"+
		"\5\34\17\2\u00c6#\3\2\2\2\u00c7\u00d0\5\64\33\2\u00c8\u00d0\58\35\2\u00c9"+
		"\u00d0\5:\36\2\u00ca\u00d0\5> \2\u00cb\u00d0\5@!\2\u00cc\u00d0\5B\"\2"+
		"\u00cd\u00d0\5D#\2\u00ce\u00d0\5\62\32\2\u00cf\u00c7\3\2\2\2\u00cf\u00c8"+
		"\3\2\2\2\u00cf\u00c9\3\2\2\2\u00cf\u00ca\3\2\2\2\u00cf\u00cb\3\2\2\2\u00cf"+
		"\u00cc\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00ce\3\2\2\2\u00d0%\3\2\2\2"+
		"\u00d1\u00d2\5(\25\2\u00d2\u00d3\7\65\2\2\u00d3\u00d4\5*\26\2\u00d4\u00d5"+
		"\7\66\2\2\u00d5\'\3\2\2\2\u00d6\u00d9\5\2\2\2\u00d7\u00d9\7B\2\2\u00d8"+
		"\u00d6\3\2\2\2\u00d8\u00d7\3\2\2\2\u00d9)\3\2\2\2\u00da\u00db\7?\2\2\u00db"+
		"+\3\2\2\2\u00dc\u00dd\7B\2\2\u00dd-\3\2\2\2\u00de\u00df\t\3\2\2\u00df"+
		"/\3\2\2\2\u00e0\u00e1\b\31\1\2\u00e1\u00e2\79\2\2\u00e2\u00e3\5\60\31"+
		"\2\u00e3\u00e4\7:\2\2\u00e4\u00f1\3\2\2\2\u00e5\u00e6\7\30\2\2\u00e6\u00e7"+
		"\5\60\31\2\u00e7\u00e8\79\2\2\u00e8\u00e9\5\20\t\2\u00e9\u00ea\7:\2\2"+
		"\u00ea\u00f1\3\2\2\2\u00eb\u00ec\t\4\2\2\u00ec\u00f1\5\60\31\13\u00ed"+
		"\u00ee\7*\2\2\u00ee\u00f1\5\60\31\n\u00ef\u00f1\5.\30\2\u00f0\u00e0\3"+
		"\2\2\2\u00f0\u00e5\3\2\2\2\u00f0\u00eb\3\2\2\2\u00f0\u00ed\3\2\2\2\u00f0"+
		"\u00ef\3\2\2\2\u00f1\u0111\3\2\2\2\u00f2\u00f3\f\t\2\2\u00f3\u00f4\7\63"+
		"\2\2\u00f4\u0110\5\60\31\n\u00f5\u00f6\f\b\2\2\u00f6\u00f7\t\5\2\2\u00f7"+
		"\u0110\5\60\31\t\u00f8\u00f9\f\7\2\2\u00f9\u00fa\t\4\2\2\u00fa\u0110\5"+
		"\60\31\b\u00fb\u00fc\f\6\2\2\u00fc\u00fd\t\6\2\2\u00fd\u0110\5\60\31\7"+
		"\u00fe\u00ff\f\5\2\2\u00ff\u0100\t\7\2\2\u0100\u0110\5\60\31\6\u0101\u0102"+
		"\f\4\2\2\u0102\u0103\t\b\2\2\u0103\u0110\5\60\31\5\u0104\u0105\f\r\2\2"+
		"\u0105\u0106\7=\2\2\u0106\u0108\7B\2\2\u0107\u0109\5\22\n\2\u0108\u0107"+
		"\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u0110\3\2\2\2\u010a\u010b\f\f\2\2\u010b"+
		"\u010c\7\65\2\2\u010c\u010d\5\60\31\2\u010d\u010e\7\66\2\2\u010e\u0110"+
		"\3\2\2\2\u010f\u00f2\3\2\2\2\u010f\u00f5\3\2\2\2\u010f\u00f8\3\2\2\2\u010f"+
		"\u00fb\3\2\2\2\u010f\u00fe\3\2\2\2\u010f\u0101\3\2\2\2\u010f\u0104\3\2"+
		"\2\2\u010f\u010a\3\2\2\2\u0110\u0113\3\2\2\2\u0111\u010f\3\2\2\2\u0111"+
		"\u0112\3\2\2\2\u0112\61\3\2\2\2\u0113\u0111\3\2\2\2\u0114\u0118\7\67\2"+
		"\2\u0115\u0117\5\26\f\2\u0116\u0115\3\2\2\2\u0117\u011a\3\2\2\2\u0118"+
		"\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u011e\3\2\2\2\u011a\u0118\3\2"+
		"\2\2\u011b\u011d\5$\23\2\u011c\u011b\3\2\2\2\u011d\u0120\3\2\2\2\u011e"+
		"\u011c\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u0121\3\2\2\2\u0120\u011e\3\2"+
		"\2\2\u0121\u0122\78\2\2\u0122\63\3\2\2\2\u0123\u0124\5\66\34\2\u0124\u0125"+
		"\7\64\2\2\u0125\u0126\5\60\31\2\u0126\u0127\7;\2\2\u0127\65\3\2\2\2\u0128"+
		"\u0133\7B\2\2\u0129\u012a\5\60\31\2\u012a\u012b\7=\2\2\u012b\u012c\7B"+
		"\2\2\u012c\u0133\3\2\2\2\u012d\u012e\5\60\31\2\u012e\u012f\7\65\2\2\u012f"+
		"\u0130\5\60\31\2\u0130\u0131\7\66\2\2\u0131\u0133\3\2\2\2\u0132\u0128"+
		"\3\2\2\2\u0132\u0129\3\2\2\2\u0132\u012d\3\2\2\2\u0133\67\3\2\2\2\u0134"+
		"\u0135\7\26\2\2\u0135\u0136\5\60\31\2\u0136\u0137\7\32\2\2\u0137\u013a"+
		"\5$\23\2\u0138\u0139\7\23\2\2\u0139\u013b\5$\23\2\u013a\u0138\3\2\2\2"+
		"\u013a\u013b\3\2\2\2\u013b9\3\2\2\2\u013c\u013d\7\33\2\2\u013d\u013e\5"+
		"<\37\2\u013e\u013f\7\64\2\2\u013f\u0140\5\60\31\2\u0140\u0141\t\t\2\2"+
		"\u0141\u0142\5\60\31\2\u0142\u0143\7\22\2\2\u0143\u0144\5$\23\2\u0144"+
		";\3\2\2\2\u0145\u0146\7B\2\2\u0146=\3\2\2\2\u0147\u0148\7\17\2\2\u0148"+
		"\u0149\7;\2\2\u0149?\3\2\2\2\u014a\u014b\7\21\2\2\u014b\u014c\7;\2\2\u014c"+
		"A\3\2\2\2\u014d\u014e\7\34\2\2\u014e\u014f\5\60\31\2\u014f\u0150\7;\2"+
		"\2\u0150C\3\2\2\2\u0151\u0152\5\60\31\2\u0152\u0153\7=\2\2\u0153\u0158"+
		"\7B\2\2\u0154\u0155\79\2\2\u0155\u0156\5\20\t\2\u0156\u0157\7:\2\2\u0157"+
		"\u0159\3\2\2\2\u0158\u0154\3\2\2\2\u0158\u0159\3\2\2\2\u0159\u015a\3\2"+
		"\2\2\u015a\u015b\7;\2\2\u015bE\3\2\2\2\37KSY_bosw}\u0087\u008b\u0094\u0098"+
		"\u009b\u00a5\u00af\u00b2\u00bc\u00cf\u00d8\u00f0\u0108\u010f\u0111\u0118"+
		"\u011e\u0132\u013a\u0158";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}