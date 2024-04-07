// Generated from D:/8/TA/Compiler/Design-Compiler-Course-Projects/Phase1/VideoSample/src/main/grammar/FunctionCraft.g4 by ANTLR 4.13.1
package main.grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class FunctionCraftParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		MAIN=1, FUNCTION=2, PRINT=3, FOR=4, RETURN=5, INT=6, FLOAT=7, BOOLEAN=8, 
		ZERO=9, INT_VAL=10, FLOAT_VAL=11, BOOLEAN_VAL=12, LPAR=13, RPAR=14, LBRACKET=15, 
		RBRACKET=16, NOT=17, PLUS=18, MINUS=19, MULT=20, DIV=21, MOD=22, GEQ=23, 
		LEQ=24, GTR=25, LES=26, EQL=27, NEQ=28, AND=29, OR=30, ASSIGN=31, LBRACE=32, 
		RBRACE=33, COMMA=34, DOT=35, COLON=36, SEMICOLON=37, QUESTION=38, IDENTIFIER=39, 
		PREDICATE=40, ARROW=41, COMMENT=42, WS=43;
	public static final int
		RULE_program = 0, RULE_primitive = 1, RULE_primitive_val = 2, RULE_primitive_val_sign = 3, 
		RULE_main = 4, RULE_function = 5, RULE_body_function = 6, RULE_statement = 7, 
		RULE_print = 8, RULE_forloop = 9, RULE_array = 10, RULE_assignment = 11, 
		RULE_initialization = 12, RULE_initialization_array = 13, RULE_function_call = 14, 
		RULE_predicate_def = 15, RULE_implication = 16, RULE_query_bool = 17, 
		RULE_query_list = 18, RULE_expr = 19, RULE_expr_other = 20;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "primitive", "primitive_val", "primitive_val_sign", "main", 
			"function", "body_function", "statement", "print", "forloop", "array", 
			"assignment", "initialization", "initialization_array", "function_call", 
			"predicate_def", "implication", "query_bool", "query_list", "expr", "expr_other"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'main'", "'function'", "'print'", "'for'", "'return'", "'int'", 
			"'float'", "'boolean'", "'0'", null, null, null, "'('", "')'", "'['", 
			"']'", "'!'", "'+'", "'-'", "'*'", "'/'", "'%'", "'>='", "'<='", "'>'", 
			"'<'", "'=='", "'!='", "'&&'", "'||'", "'='", "'{'", "'}'", "','", "'.'", 
			"':'", "';'", "'?'", null, null, "'=>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "MAIN", "FUNCTION", "PRINT", "FOR", "RETURN", "INT", "FLOAT", "BOOLEAN", 
			"ZERO", "INT_VAL", "FLOAT_VAL", "BOOLEAN_VAL", "LPAR", "RPAR", "LBRACKET", 
			"RBRACKET", "NOT", "PLUS", "MINUS", "MULT", "DIV", "MOD", "GEQ", "LEQ", 
			"GTR", "LES", "EQL", "NEQ", "AND", "OR", "ASSIGN", "LBRACE", "RBRACE", 
			"COMMA", "DOT", "COLON", "SEMICOLON", "QUESTION", "IDENTIFIER", "PREDICATE", 
			"ARROW", "COMMENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "FunctionCraft.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FunctionCraftParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public MainContext main() {
			return getRuleContext(MainContext.class,0);
		}
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public List<TerminalNode> COMMENT() { return getTokens(FunctionCraftParser.COMMENT); }
		public TerminalNode COMMENT(int i) {
			return getToken(FunctionCraftParser.COMMENT, i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUNCTION || _la==COMMENT) {
				{
				setState(44);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case FUNCTION:
					{
					setState(42);
					function();
					}
					break;
				case COMMENT:
					{
					setState(43);
					match(COMMENT);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(48);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(49);
			main();
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMENT) {
				{
				{
				setState(50);
				match(COMMENT);
				}
				}
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrimitiveContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(FunctionCraftParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(FunctionCraftParser.FLOAT, 0); }
		public TerminalNode BOOLEAN() { return getToken(FunctionCraftParser.BOOLEAN, 0); }
		public PrimitiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterPrimitive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitPrimitive(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitPrimitive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveContext primitive() throws RecognitionException {
		PrimitiveContext _localctx = new PrimitiveContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_primitive);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 448L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Primitive_valContext extends ParserRuleContext {
		public TerminalNode INT_VAL() { return getToken(FunctionCraftParser.INT_VAL, 0); }
		public TerminalNode ZERO() { return getToken(FunctionCraftParser.ZERO, 0); }
		public TerminalNode FLOAT_VAL() { return getToken(FunctionCraftParser.FLOAT_VAL, 0); }
		public TerminalNode BOOLEAN_VAL() { return getToken(FunctionCraftParser.BOOLEAN_VAL, 0); }
		public Primitive_valContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitive_val; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterPrimitive_val(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitPrimitive_val(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitPrimitive_val(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Primitive_valContext primitive_val() throws RecognitionException {
		Primitive_valContext _localctx = new Primitive_valContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_primitive_val);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 7680L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Primitive_val_signContext extends ParserRuleContext {
		public Token op;
		public TerminalNode INT_VAL() { return getToken(FunctionCraftParser.INT_VAL, 0); }
		public TerminalNode FLOAT_VAL() { return getToken(FunctionCraftParser.FLOAT_VAL, 0); }
		public TerminalNode MINUS() { return getToken(FunctionCraftParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(FunctionCraftParser.PLUS, 0); }
		public Primitive_val_signContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitive_val_sign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterPrimitive_val_sign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitPrimitive_val_sign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitPrimitive_val_sign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Primitive_val_signContext primitive_val_sign() throws RecognitionException {
		Primitive_val_signContext _localctx = new Primitive_val_signContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_primitive_val_sign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			((Primitive_val_signContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==PLUS || _la==MINUS) ) {
				((Primitive_val_signContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(61);
			_la = _input.LA(1);
			if ( !(_la==INT_VAL || _la==FLOAT_VAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			 System.out.println("Operator: " + (((Primitive_val_signContext)_localctx).op!=null?((Primitive_val_signContext)_localctx).op.getText():null)); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class MainContext extends ParserRuleContext {
		public TerminalNode MAIN() { return getToken(FunctionCraftParser.MAIN, 0); }
		public TerminalNode LBRACE() { return getToken(FunctionCraftParser.LBRACE, 0); }
		public Body_functionContext body_function() {
			return getRuleContext(Body_functionContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(FunctionCraftParser.RBRACE, 0); }
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterMain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitMain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitMain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_main);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(MAIN);
			 System.out.println("MainBody"); 
			setState(66);
			match(LBRACE);
			setState(67);
			body_function();
			setState(68);
			match(RBRACE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionContext extends ParserRuleContext {
		public Token name;
		public Token idn;
		public Token idn2;
		public TerminalNode FUNCTION() { return getToken(FunctionCraftParser.FUNCTION, 0); }
		public TerminalNode LPAR() { return getToken(FunctionCraftParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FunctionCraftParser.RPAR, 0); }
		public TerminalNode COLON() { return getToken(FunctionCraftParser.COLON, 0); }
		public List<PrimitiveContext> primitive() {
			return getRuleContexts(PrimitiveContext.class);
		}
		public PrimitiveContext primitive(int i) {
			return getRuleContext(PrimitiveContext.class,i);
		}
		public TerminalNode LBRACE() { return getToken(FunctionCraftParser.LBRACE, 0); }
		public Body_functionContext body_function() {
			return getRuleContext(Body_functionContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(FunctionCraftParser.RBRACE, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(FunctionCraftParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(FunctionCraftParser.IDENTIFIER, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FunctionCraftParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FunctionCraftParser.COMMA, i);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(FUNCTION);
			setState(71);
			((FunctionContext)_localctx).name = match(IDENTIFIER);
			 System.out.println("FunctionDec: " + (((FunctionContext)_localctx).name!=null?((FunctionContext)_localctx).name.getText():null)); 
			setState(73);
			match(LPAR);
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 448L) != 0)) {
				{
				setState(74);
				primitive();
				setState(75);
				((FunctionContext)_localctx).idn = match(IDENTIFIER);
				 System.out.println("ArgumentDec: " + (((FunctionContext)_localctx).idn!=null?((FunctionContext)_localctx).idn.getText():null)); 
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(77);
					match(COMMA);
					setState(78);
					primitive();
					setState(79);
					((FunctionContext)_localctx).idn2 = match(IDENTIFIER);
					 System.out.println("ArgumentDec: " + (((FunctionContext)_localctx).idn2!=null?((FunctionContext)_localctx).idn2.getText():null)); 
					}
					}
					setState(86);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(89);
			match(RPAR);
			setState(90);
			match(COLON);
			setState(91);
			primitive();
			setState(92);
			match(LBRACE);
			setState(93);
			body_function();
			setState(94);
			match(RBRACE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Body_functionContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> COMMENT() { return getTokens(FunctionCraftParser.COMMENT); }
		public TerminalNode COMMENT(int i) {
			return getToken(FunctionCraftParser.COMMENT, i);
		}
		public Body_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterBody_function(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitBody_function(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitBody_function(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Body_functionContext body_function() throws RecognitionException {
		Body_functionContext _localctx = new Body_functionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_body_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6047313961432L) != 0)) {
				{
				setState(98);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PRINT:
				case FOR:
				case INT:
				case FLOAT:
				case BOOLEAN:
				case LPAR:
				case IDENTIFIER:
				case PREDICATE:
					{
					setState(96);
					statement();
					}
					break;
				case COMMENT:
					{
					setState(97);
					match(COMMENT);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(FunctionCraftParser.SEMICOLON, 0); }
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public InitializationContext initialization() {
			return getRuleContext(InitializationContext.class,0);
		}
		public Initialization_arrayContext initialization_array() {
			return getRuleContext(Initialization_arrayContext.class,0);
		}
		public Predicate_defContext predicate_def() {
			return getRuleContext(Predicate_defContext.class,0);
		}
		public ForloopContext forloop() {
			return getRuleContext(ForloopContext.class,0);
		}
		public ImplicationContext implication() {
			return getRuleContext(ImplicationContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_statement);
		try {
			setState(114);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRINT:
			case INT:
			case FLOAT:
			case BOOLEAN:
			case IDENTIFIER:
			case PREDICATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(108);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(103);
					print();
					}
					break;
				case 2:
					{
					setState(104);
					assignment();
					}
					break;
				case 3:
					{
					setState(105);
					initialization();
					}
					break;
				case 4:
					{
					setState(106);
					initialization_array();
					}
					break;
				case 5:
					{
					setState(107);
					predicate_def();
					}
					break;
				}
				setState(110);
				match(SEMICOLON);
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(112);
				forloop();
				}
				break;
			case LPAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(113);
				implication();
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrintContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(FunctionCraftParser.PRINT, 0); }
		public TerminalNode LPAR() { return getToken(FunctionCraftParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FunctionCraftParser.RPAR, 0); }
		public TerminalNode IDENTIFIER() { return getToken(FunctionCraftParser.IDENTIFIER, 0); }
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public Query_boolContext query_bool() {
			return getRuleContext(Query_boolContext.class,0);
		}
		public Query_listContext query_list() {
			return getRuleContext(Query_listContext.class,0);
		}
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitPrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(PRINT);
			 System.out.println("Built-in: print"); 
			setState(118);
			match(LPAR);
			setState(123);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(119);
				match(IDENTIFIER);
				}
				break;
			case 2:
				{
				setState(120);
				array();
				}
				break;
			case 3:
				{
				setState(121);
				query_bool();
				}
				break;
			case 4:
				{
				setState(122);
				query_list();
				}
				break;
			}
			setState(125);
			match(RPAR);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ForloopContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(FunctionCraftParser.FOR, 0); }
		public TerminalNode LPAR() { return getToken(FunctionCraftParser.LPAR, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(FunctionCraftParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(FunctionCraftParser.IDENTIFIER, i);
		}
		public TerminalNode COLON() { return getToken(FunctionCraftParser.COLON, 0); }
		public TerminalNode RPAR() { return getToken(FunctionCraftParser.RPAR, 0); }
		public TerminalNode LBRACE() { return getToken(FunctionCraftParser.LBRACE, 0); }
		public Body_functionContext body_function() {
			return getRuleContext(Body_functionContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(FunctionCraftParser.RBRACE, 0); }
		public ForloopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forloop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterForloop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitForloop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitForloop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForloopContext forloop() throws RecognitionException {
		ForloopContext _localctx = new ForloopContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_forloop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(FOR);
			 System.out.println("Loop: for"); 
			setState(129);
			match(LPAR);
			setState(130);
			match(IDENTIFIER);
			setState(131);
			match(COLON);
			setState(132);
			match(IDENTIFIER);
			setState(133);
			match(RPAR);
			setState(134);
			match(LBRACE);
			setState(135);
			body_function();
			setState(136);
			match(RBRACE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(FunctionCraftParser.IDENTIFIER, 0); }
		public TerminalNode LBRACKET() { return getToken(FunctionCraftParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(FunctionCraftParser.RBRACKET, 0); }
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_array);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(IDENTIFIER);
			setState(139);
			match(LBRACKET);
			setState(140);
			match(RBRACKET);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(FunctionCraftParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(FunctionCraftParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode LBRACKET() { return getToken(FunctionCraftParser.LBRACKET, 0); }
		public TerminalNode INT_VAL() { return getToken(FunctionCraftParser.INT_VAL, 0); }
		public TerminalNode RBRACKET() { return getToken(FunctionCraftParser.RBRACKET, 0); }
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_assignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(IDENTIFIER);
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(143);
				match(LBRACKET);
				setState(144);
				match(INT_VAL);
				setState(145);
				match(RBRACKET);
				}
			}

			setState(148);
			match(ASSIGN);
			setState(149);
			expr();
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

	@SuppressWarnings("CheckReturnValue")
	public static class InitializationContext extends ParserRuleContext {
		public Token name;
		public PrimitiveContext primitive() {
			return getRuleContext(PrimitiveContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(FunctionCraftParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(FunctionCraftParser.IDENTIFIER, 0); }
		public InitializationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initialization; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterInitialization(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitInitialization(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitInitialization(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitializationContext initialization() throws RecognitionException {
		InitializationContext _localctx = new InitializationContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_initialization);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			primitive();
			setState(152);
			((InitializationContext)_localctx).name = match(IDENTIFIER);
			 System.out.println("VarDec: " + (((InitializationContext)_localctx).name!=null?((InitializationContext)_localctx).name.getText():null)); 
			setState(154);
			match(ASSIGN);
			setState(155);
			expr();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Initialization_arrayContext extends ParserRuleContext {
		public Token name;
		public PrimitiveContext primitive() {
			return getRuleContext(PrimitiveContext.class,0);
		}
		public List<TerminalNode> LBRACKET() { return getTokens(FunctionCraftParser.LBRACKET); }
		public TerminalNode LBRACKET(int i) {
			return getToken(FunctionCraftParser.LBRACKET, i);
		}
		public TerminalNode INT_VAL() { return getToken(FunctionCraftParser.INT_VAL, 0); }
		public List<TerminalNode> RBRACKET() { return getTokens(FunctionCraftParser.RBRACKET); }
		public TerminalNode RBRACKET(int i) {
			return getToken(FunctionCraftParser.RBRACKET, i);
		}
		public TerminalNode ASSIGN() { return getToken(FunctionCraftParser.ASSIGN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(FunctionCraftParser.IDENTIFIER, 0); }
		public List<Primitive_valContext> primitive_val() {
			return getRuleContexts(Primitive_valContext.class);
		}
		public Primitive_valContext primitive_val(int i) {
			return getRuleContext(Primitive_valContext.class,i);
		}
		public List<Primitive_val_signContext> primitive_val_sign() {
			return getRuleContexts(Primitive_val_signContext.class);
		}
		public Primitive_val_signContext primitive_val_sign(int i) {
			return getRuleContext(Primitive_val_signContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FunctionCraftParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FunctionCraftParser.COMMA, i);
		}
		public Initialization_arrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initialization_array; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterInitialization_array(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitInitialization_array(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitInitialization_array(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Initialization_arrayContext initialization_array() throws RecognitionException {
		Initialization_arrayContext _localctx = new Initialization_arrayContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_initialization_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			primitive();
			setState(158);
			match(LBRACKET);
			setState(159);
			match(INT_VAL);
			setState(160);
			match(RBRACKET);
			setState(161);
			((Initialization_arrayContext)_localctx).name = match(IDENTIFIER);
			 System.out.println("VarDec: " + (((Initialization_arrayContext)_localctx).name!=null?((Initialization_arrayContext)_localctx).name.getText():null)); 
			setState(163);
			match(ASSIGN);
			setState(164);
			match(LBRACKET);
			setState(167);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ZERO:
			case INT_VAL:
			case FLOAT_VAL:
			case BOOLEAN_VAL:
				{
				setState(165);
				primitive_val();
				}
				break;
			case PLUS:
			case MINUS:
				{
				setState(166);
				primitive_val_sign();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(169);
				match(COMMA);
				setState(172);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ZERO:
				case INT_VAL:
				case FLOAT_VAL:
				case BOOLEAN_VAL:
					{
					setState(170);
					primitive_val();
					}
					break;
				case PLUS:
				case MINUS:
					{
					setState(171);
					primitive_val_sign();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(178);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(179);
			match(RBRACKET);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Function_callContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(FunctionCraftParser.IDENTIFIER, 0); }
		public TerminalNode LPAR() { return getToken(FunctionCraftParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FunctionCraftParser.RPAR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FunctionCraftParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FunctionCraftParser.COMMA, i);
		}
		public Function_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterFunction_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitFunction_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitFunction_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_callContext function_call() throws RecognitionException {
		Function_callContext _localctx = new Function_callContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_function_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			match(IDENTIFIER);
			setState(182);
			match(LPAR);
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 549755862528L) != 0)) {
				{
				setState(183);
				expr();
				setState(188);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(184);
					match(COMMA);
					setState(185);
					expr();
					}
					}
					setState(190);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(193);
			match(RPAR);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Predicate_defContext extends ParserRuleContext {
		public Token name;
		public TerminalNode LPAR() { return getToken(FunctionCraftParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FunctionCraftParser.RPAR, 0); }
		public TerminalNode PREDICATE() { return getToken(FunctionCraftParser.PREDICATE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(FunctionCraftParser.IDENTIFIER, 0); }
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public Predicate_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterPredicate_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitPredicate_def(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitPredicate_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Predicate_defContext predicate_def() throws RecognitionException {
		Predicate_defContext _localctx = new Predicate_defContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_predicate_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			((Predicate_defContext)_localctx).name = match(PREDICATE);
			 System.out.println("Predicate: " + (((Predicate_defContext)_localctx).name!=null?((Predicate_defContext)_localctx).name.getText():null)); 
			setState(197);
			match(LPAR);
			setState(200);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(198);
				match(IDENTIFIER);
				}
				break;
			case 2:
				{
				setState(199);
				array();
				}
				break;
			}
			setState(202);
			match(RPAR);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ImplicationContext extends ParserRuleContext {
		public List<TerminalNode> LPAR() { return getTokens(FunctionCraftParser.LPAR); }
		public TerminalNode LPAR(int i) {
			return getToken(FunctionCraftParser.LPAR, i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> RPAR() { return getTokens(FunctionCraftParser.RPAR); }
		public TerminalNode RPAR(int i) {
			return getToken(FunctionCraftParser.RPAR, i);
		}
		public TerminalNode ARROW() { return getToken(FunctionCraftParser.ARROW, 0); }
		public Body_functionContext body_function() {
			return getRuleContext(Body_functionContext.class,0);
		}
		public ImplicationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_implication; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterImplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitImplication(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitImplication(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImplicationContext implication() throws RecognitionException {
		ImplicationContext _localctx = new ImplicationContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_implication);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			match(LPAR);
			 System.out.println("Implication"); 
			setState(206);
			expr();
			setState(207);
			match(RPAR);
			setState(208);
			match(ARROW);
			setState(209);
			match(LPAR);
			setState(210);
			body_function();
			setState(211);
			match(RPAR);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Query_boolContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(FunctionCraftParser.LBRACKET, 0); }
		public TerminalNode QUESTION() { return getToken(FunctionCraftParser.QUESTION, 0); }
		public Predicate_defContext predicate_def() {
			return getRuleContext(Predicate_defContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(FunctionCraftParser.RBRACKET, 0); }
		public Query_boolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query_bool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterQuery_bool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitQuery_bool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitQuery_bool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Query_boolContext query_bool() throws RecognitionException {
		Query_boolContext _localctx = new Query_boolContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_query_bool);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			match(LBRACKET);
			setState(214);
			match(QUESTION);
			setState(215);
			predicate_def();
			setState(216);
			match(RBRACKET);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Query_listContext extends ParserRuleContext {
		public Token name;
		public TerminalNode LBRACKET() { return getToken(FunctionCraftParser.LBRACKET, 0); }
		public TerminalNode LPAR() { return getToken(FunctionCraftParser.LPAR, 0); }
		public TerminalNode QUESTION() { return getToken(FunctionCraftParser.QUESTION, 0); }
		public TerminalNode RPAR() { return getToken(FunctionCraftParser.RPAR, 0); }
		public TerminalNode RBRACKET() { return getToken(FunctionCraftParser.RBRACKET, 0); }
		public TerminalNode PREDICATE() { return getToken(FunctionCraftParser.PREDICATE, 0); }
		public Query_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterQuery_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitQuery_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitQuery_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Query_listContext query_list() throws RecognitionException {
		Query_listContext _localctx = new Query_listContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_query_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			match(LBRACKET);
			setState(219);
			((Query_listContext)_localctx).name = match(PREDICATE);
			 System.out.println("Predicate: " + (((Query_listContext)_localctx).name!=null?((Query_listContext)_localctx).name.getText():null)); 
			setState(221);
			match(LPAR);
			setState(222);
			match(QUESTION);
			setState(223);
			match(RPAR);
			setState(224);
			match(RBRACKET);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public Expr_otherContext expr_other() {
			return getRuleContext(Expr_otherContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			expr_other();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Expr_otherContext extends ParserRuleContext {
		public TerminalNode LPAR() { return getToken(FunctionCraftParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(FunctionCraftParser.RPAR, 0); }
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(FunctionCraftParser.IDENTIFIER, 0); }
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public Query_boolContext query_bool() {
			return getRuleContext(Query_boolContext.class,0);
		}
		public Primitive_valContext primitive_val() {
			return getRuleContext(Primitive_valContext.class,0);
		}
		public Expr_otherContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_other; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterExpr_other(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitExpr_other(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitExpr_other(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_otherContext expr_other() throws RecognitionException {
		Expr_otherContext _localctx = new Expr_otherContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_expr_other);
		try {
			setState(237);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(228);
				match(LPAR);
				setState(229);
				expr();
				setState(230);
				match(RPAR);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(232);
				array();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(233);
				match(IDENTIFIER);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(234);
				function_call();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(235);
				query_bool();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(236);
				primitive_val();
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

	public static final String _serializedATN =
		"\u0004\u0001+\u00f0\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0001\u0000\u0001\u0000"+
		"\u0005\u0000-\b\u0000\n\u0000\f\u00000\t\u0000\u0001\u0000\u0001\u0000"+
		"\u0005\u00004\b\u0000\n\u0000\f\u00007\t\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0005\u0005S\b\u0005\n\u0005\f\u0005V\t\u0005\u0003\u0005X\b\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0001\u0006\u0005\u0006c\b\u0006\n\u0006\f\u0006f\t"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003"+
		"\u0007m\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003"+
		"\u0007s\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0003\b|\b\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b"+
		"\u0093\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u00a8\b\r\u0001\r\u0001\r\u0001"+
		"\r\u0003\r\u00ad\b\r\u0005\r\u00af\b\r\n\r\f\r\u00b2\t\r\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e"+
		"\u00bb\b\u000e\n\u000e\f\u000e\u00be\t\u000e\u0003\u000e\u00c0\b\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0003\u000f\u00c9\b\u000f\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0003\u0014\u00ee\b\u0014\u0001\u0014\u0000\u0000"+
		"\u0015\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \"$&(\u0000\u0004\u0001\u0000\u0006\b\u0001\u0000\t"+
		"\f\u0001\u0000\u0012\u0013\u0001\u0000\n\u000b\u00f6\u0000.\u0001\u0000"+
		"\u0000\u0000\u00028\u0001\u0000\u0000\u0000\u0004:\u0001\u0000\u0000\u0000"+
		"\u0006<\u0001\u0000\u0000\u0000\b@\u0001\u0000\u0000\u0000\nF\u0001\u0000"+
		"\u0000\u0000\fd\u0001\u0000\u0000\u0000\u000er\u0001\u0000\u0000\u0000"+
		"\u0010t\u0001\u0000\u0000\u0000\u0012\u007f\u0001\u0000\u0000\u0000\u0014"+
		"\u008a\u0001\u0000\u0000\u0000\u0016\u008e\u0001\u0000\u0000\u0000\u0018"+
		"\u0097\u0001\u0000\u0000\u0000\u001a\u009d\u0001\u0000\u0000\u0000\u001c"+
		"\u00b5\u0001\u0000\u0000\u0000\u001e\u00c3\u0001\u0000\u0000\u0000 \u00cc"+
		"\u0001\u0000\u0000\u0000\"\u00d5\u0001\u0000\u0000\u0000$\u00da\u0001"+
		"\u0000\u0000\u0000&\u00e2\u0001\u0000\u0000\u0000(\u00ed\u0001\u0000\u0000"+
		"\u0000*-\u0003\n\u0005\u0000+-\u0005*\u0000\u0000,*\u0001\u0000\u0000"+
		"\u0000,+\u0001\u0000\u0000\u0000-0\u0001\u0000\u0000\u0000.,\u0001\u0000"+
		"\u0000\u0000./\u0001\u0000\u0000\u0000/1\u0001\u0000\u0000\u00000.\u0001"+
		"\u0000\u0000\u000015\u0003\b\u0004\u000024\u0005*\u0000\u000032\u0001"+
		"\u0000\u0000\u000047\u0001\u0000\u0000\u000053\u0001\u0000\u0000\u0000"+
		"56\u0001\u0000\u0000\u00006\u0001\u0001\u0000\u0000\u000075\u0001\u0000"+
		"\u0000\u000089\u0007\u0000\u0000\u00009\u0003\u0001\u0000\u0000\u0000"+
		":;\u0007\u0001\u0000\u0000;\u0005\u0001\u0000\u0000\u0000<=\u0007\u0002"+
		"\u0000\u0000=>\u0007\u0003\u0000\u0000>?\u0006\u0003\uffff\uffff\u0000"+
		"?\u0007\u0001\u0000\u0000\u0000@A\u0005\u0001\u0000\u0000AB\u0006\u0004"+
		"\uffff\uffff\u0000BC\u0005 \u0000\u0000CD\u0003\f\u0006\u0000DE\u0005"+
		"!\u0000\u0000E\t\u0001\u0000\u0000\u0000FG\u0005\u0002\u0000\u0000GH\u0005"+
		"\'\u0000\u0000HI\u0006\u0005\uffff\uffff\u0000IW\u0005\r\u0000\u0000J"+
		"K\u0003\u0002\u0001\u0000KL\u0005\'\u0000\u0000LT\u0006\u0005\uffff\uffff"+
		"\u0000MN\u0005\"\u0000\u0000NO\u0003\u0002\u0001\u0000OP\u0005\'\u0000"+
		"\u0000PQ\u0006\u0005\uffff\uffff\u0000QS\u0001\u0000\u0000\u0000RM\u0001"+
		"\u0000\u0000\u0000SV\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000"+
		"TU\u0001\u0000\u0000\u0000UX\u0001\u0000\u0000\u0000VT\u0001\u0000\u0000"+
		"\u0000WJ\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000XY\u0001\u0000"+
		"\u0000\u0000YZ\u0005\u000e\u0000\u0000Z[\u0005$\u0000\u0000[\\\u0003\u0002"+
		"\u0001\u0000\\]\u0005 \u0000\u0000]^\u0003\f\u0006\u0000^_\u0005!\u0000"+
		"\u0000_\u000b\u0001\u0000\u0000\u0000`c\u0003\u000e\u0007\u0000ac\u0005"+
		"*\u0000\u0000b`\u0001\u0000\u0000\u0000ba\u0001\u0000\u0000\u0000cf\u0001"+
		"\u0000\u0000\u0000db\u0001\u0000\u0000\u0000de\u0001\u0000\u0000\u0000"+
		"e\r\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000gm\u0003\u0010\b"+
		"\u0000hm\u0003\u0016\u000b\u0000im\u0003\u0018\f\u0000jm\u0003\u001a\r"+
		"\u0000km\u0003\u001e\u000f\u0000lg\u0001\u0000\u0000\u0000lh\u0001\u0000"+
		"\u0000\u0000li\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000lk\u0001"+
		"\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000no\u0005%\u0000\u0000os\u0001"+
		"\u0000\u0000\u0000ps\u0003\u0012\t\u0000qs\u0003 \u0010\u0000rl\u0001"+
		"\u0000\u0000\u0000rp\u0001\u0000\u0000\u0000rq\u0001\u0000\u0000\u0000"+
		"s\u000f\u0001\u0000\u0000\u0000tu\u0005\u0003\u0000\u0000uv\u0006\b\uffff"+
		"\uffff\u0000v{\u0005\r\u0000\u0000w|\u0005\'\u0000\u0000x|\u0003\u0014"+
		"\n\u0000y|\u0003\"\u0011\u0000z|\u0003$\u0012\u0000{w\u0001\u0000\u0000"+
		"\u0000{x\u0001\u0000\u0000\u0000{y\u0001\u0000\u0000\u0000{z\u0001\u0000"+
		"\u0000\u0000|}\u0001\u0000\u0000\u0000}~\u0005\u000e\u0000\u0000~\u0011"+
		"\u0001\u0000\u0000\u0000\u007f\u0080\u0005\u0004\u0000\u0000\u0080\u0081"+
		"\u0006\t\uffff\uffff\u0000\u0081\u0082\u0005\r\u0000\u0000\u0082\u0083"+
		"\u0005\'\u0000\u0000\u0083\u0084\u0005$\u0000\u0000\u0084\u0085\u0005"+
		"\'\u0000\u0000\u0085\u0086\u0005\u000e\u0000\u0000\u0086\u0087\u0005 "+
		"\u0000\u0000\u0087\u0088\u0003\f\u0006\u0000\u0088\u0089\u0005!\u0000"+
		"\u0000\u0089\u0013\u0001\u0000\u0000\u0000\u008a\u008b\u0005\'\u0000\u0000"+
		"\u008b\u008c\u0005\u000f\u0000\u0000\u008c\u008d\u0005\u0010\u0000\u0000"+
		"\u008d\u0015\u0001\u0000\u0000\u0000\u008e\u0092\u0005\'\u0000\u0000\u008f"+
		"\u0090\u0005\u000f\u0000\u0000\u0090\u0091\u0005\n\u0000\u0000\u0091\u0093"+
		"\u0005\u0010\u0000\u0000\u0092\u008f\u0001\u0000\u0000\u0000\u0092\u0093"+
		"\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000\u0000\u0094\u0095"+
		"\u0005\u001f\u0000\u0000\u0095\u0096\u0003&\u0013\u0000\u0096\u0017\u0001"+
		"\u0000\u0000\u0000\u0097\u0098\u0003\u0002\u0001\u0000\u0098\u0099\u0005"+
		"\'\u0000\u0000\u0099\u009a\u0006\f\uffff\uffff\u0000\u009a\u009b\u0005"+
		"\u001f\u0000\u0000\u009b\u009c\u0003&\u0013\u0000\u009c\u0019\u0001\u0000"+
		"\u0000\u0000\u009d\u009e\u0003\u0002\u0001\u0000\u009e\u009f\u0005\u000f"+
		"\u0000\u0000\u009f\u00a0\u0005\n\u0000\u0000\u00a0\u00a1\u0005\u0010\u0000"+
		"\u0000\u00a1\u00a2\u0005\'\u0000\u0000\u00a2\u00a3\u0006\r\uffff\uffff"+
		"\u0000\u00a3\u00a4\u0005\u001f\u0000\u0000\u00a4\u00a7\u0005\u000f\u0000"+
		"\u0000\u00a5\u00a8\u0003\u0004\u0002\u0000\u00a6\u00a8\u0003\u0006\u0003"+
		"\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a7\u00a6\u0001\u0000\u0000"+
		"\u0000\u00a8\u00b0\u0001\u0000\u0000\u0000\u00a9\u00ac\u0005\"\u0000\u0000"+
		"\u00aa\u00ad\u0003\u0004\u0002\u0000\u00ab\u00ad\u0003\u0006\u0003\u0000"+
		"\u00ac\u00aa\u0001\u0000\u0000\u0000\u00ac\u00ab\u0001\u0000\u0000\u0000"+
		"\u00ad\u00af\u0001\u0000\u0000\u0000\u00ae\u00a9\u0001\u0000\u0000\u0000"+
		"\u00af\u00b2\u0001\u0000\u0000\u0000\u00b0\u00ae\u0001\u0000\u0000\u0000"+
		"\u00b0\u00b1\u0001\u0000\u0000\u0000\u00b1\u00b3\u0001\u0000\u0000\u0000"+
		"\u00b2\u00b0\u0001\u0000\u0000\u0000\u00b3\u00b4\u0005\u0010\u0000\u0000"+
		"\u00b4\u001b\u0001\u0000\u0000\u0000\u00b5\u00b6\u0005\'\u0000\u0000\u00b6"+
		"\u00bf\u0005\r\u0000\u0000\u00b7\u00bc\u0003&\u0013\u0000\u00b8\u00b9"+
		"\u0005\"\u0000\u0000\u00b9\u00bb\u0003&\u0013\u0000\u00ba\u00b8\u0001"+
		"\u0000\u0000\u0000\u00bb\u00be\u0001\u0000\u0000\u0000\u00bc\u00ba\u0001"+
		"\u0000\u0000\u0000\u00bc\u00bd\u0001\u0000\u0000\u0000\u00bd\u00c0\u0001"+
		"\u0000\u0000\u0000\u00be\u00bc\u0001\u0000\u0000\u0000\u00bf\u00b7\u0001"+
		"\u0000\u0000\u0000\u00bf\u00c0\u0001\u0000\u0000\u0000\u00c0\u00c1\u0001"+
		"\u0000\u0000\u0000\u00c1\u00c2\u0005\u000e\u0000\u0000\u00c2\u001d\u0001"+
		"\u0000\u0000\u0000\u00c3\u00c4\u0005(\u0000\u0000\u00c4\u00c5\u0006\u000f"+
		"\uffff\uffff\u0000\u00c5\u00c8\u0005\r\u0000\u0000\u00c6\u00c9\u0005\'"+
		"\u0000\u0000\u00c7\u00c9\u0003\u0014\n\u0000\u00c8\u00c6\u0001\u0000\u0000"+
		"\u0000\u00c8\u00c7\u0001\u0000\u0000\u0000\u00c9\u00ca\u0001\u0000\u0000"+
		"\u0000\u00ca\u00cb\u0005\u000e\u0000\u0000\u00cb\u001f\u0001\u0000\u0000"+
		"\u0000\u00cc\u00cd\u0005\r\u0000\u0000\u00cd\u00ce\u0006\u0010\uffff\uffff"+
		"\u0000\u00ce\u00cf\u0003&\u0013\u0000\u00cf\u00d0\u0005\u000e\u0000\u0000"+
		"\u00d0\u00d1\u0005)\u0000\u0000\u00d1\u00d2\u0005\r\u0000\u0000\u00d2"+
		"\u00d3\u0003\f\u0006\u0000\u00d3\u00d4\u0005\u000e\u0000\u0000\u00d4!"+
		"\u0001\u0000\u0000\u0000\u00d5\u00d6\u0005\u000f\u0000\u0000\u00d6\u00d7"+
		"\u0005&\u0000\u0000\u00d7\u00d8\u0003\u001e\u000f\u0000\u00d8\u00d9\u0005"+
		"\u0010\u0000\u0000\u00d9#\u0001\u0000\u0000\u0000\u00da\u00db\u0005\u000f"+
		"\u0000\u0000\u00db\u00dc\u0005(\u0000\u0000\u00dc\u00dd\u0006\u0012\uffff"+
		"\uffff\u0000\u00dd\u00de\u0005\r\u0000\u0000\u00de\u00df\u0005&\u0000"+
		"\u0000\u00df\u00e0\u0005\u000e\u0000\u0000\u00e0\u00e1\u0005\u0010\u0000"+
		"\u0000\u00e1%\u0001\u0000\u0000\u0000\u00e2\u00e3\u0003(\u0014\u0000\u00e3"+
		"\'\u0001\u0000\u0000\u0000\u00e4\u00e5\u0005\r\u0000\u0000\u00e5\u00e6"+
		"\u0003&\u0013\u0000\u00e6\u00e7\u0005\u000e\u0000\u0000\u00e7\u00ee\u0001"+
		"\u0000\u0000\u0000\u00e8\u00ee\u0003\u0014\n\u0000\u00e9\u00ee\u0005\'"+
		"\u0000\u0000\u00ea\u00ee\u0003\u001c\u000e\u0000\u00eb\u00ee\u0003\"\u0011"+
		"\u0000\u00ec\u00ee\u0003\u0004\u0002\u0000\u00ed\u00e4\u0001\u0000\u0000"+
		"\u0000\u00ed\u00e8\u0001\u0000\u0000\u0000\u00ed\u00e9\u0001\u0000\u0000"+
		"\u0000\u00ed\u00ea\u0001\u0000\u0000\u0000\u00ed\u00eb\u0001\u0000\u0000"+
		"\u0000\u00ed\u00ec\u0001\u0000\u0000\u0000\u00ee)\u0001\u0000\u0000\u0000"+
		"\u0012,.5TWbdlr{\u0092\u00a7\u00ac\u00b0\u00bc\u00bf\u00c8\u00ed";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}