// Generated from U:/UT/6/PLC_TA/Design-Compiler-Course-Projects/Phase1Template/untitled/src/main/grammer/FunctionCraft.g4 by ANTLR 4.13.1
package main.grammer;
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
		DEF=1, END=2, MAIN=3, PUTS=4, PUSH=5, LEN=6, RETURN=7, IF=8, ELSE=9, ELSEIF=10, 
		METHOD=11, PATTERN=12, MATCH=13, LOOP=14, FOR=15, IN=16, DO=17, CHOP=18, 
		CHOMP=19, PLUS=20, MINUS=21, MULT=22, DIVIDE=23, EQUAL=24, NOT_EQUAL=25, 
		IS_NOT=26, IS=27, GREATER_THAN=28, LESS_THAN=29, AND=30, OR=31, NOT=32, 
		INCREMENT=33, DECREMENT=34, SEPARATOR=35, APPEND=36, TRUE=37, FALSE=38, 
		BREAK=39, NEXT=40, ARROW=41, ASSIGN=42, LPAR=43, RPAR=44, LBRACK=45, RBRACK=46, 
		LBRACE=47, RBRACE=48, COMMA=49, DOT=50, DOUBLEDOT=51, COLON=52, SEMICOLLON=53, 
		INT_VALUE=54, FLOAT_VALUE=55, IDENTIFIER=56, STRING_VALUE=57, COMMENT=58, 
		WS=59;
	public static final int
		RULE_program = 0, RULE_functionDeclaration = 1, RULE_functionArgumentsDeclaration = 2, 
		RULE_patternMatching = 3, RULE_main = 4, RULE_functionArguments = 5, RULE_returnStatement = 6, 
		RULE_ifStatement = 7, RULE_condition = 8, RULE_putsStatement = 9, RULE_lenStatement = 10, 
		RULE_pushStatement = 11, RULE_loopDoStatement = 12, RULE_loopBody = 13, 
		RULE_forStatement = 14, RULE_range = 15, RULE_filterStatement = 16, RULE_matchPatternStatement = 17, 
		RULE_chopAndChompStatement = 18, RULE_assignment = 19, RULE_accessList = 20, 
		RULE_statement = 21, RULE_body = 22, RULE_expression = 23, RULE_relationalExpression = 24, 
		RULE_additiveExpression = 25, RULE_multiplicativeExpression = 26, RULE_preUnaryExpression = 27, 
		RULE_appendExpression = 28, RULE_accessExpression = 29, RULE_otherExpression = 30, 
		RULE_lambdaFunction = 31, RULE_values = 32, RULE_listValue = 33, RULE_boolValue = 34, 
		RULE_functionPointer = 35;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "functionDeclaration", "functionArgumentsDeclaration", "patternMatching", 
			"main", "functionArguments", "returnStatement", "ifStatement", "condition", 
			"putsStatement", "lenStatement", "pushStatement", "loopDoStatement", 
			"loopBody", "forStatement", "range", "filterStatement", "matchPatternStatement", 
			"chopAndChompStatement", "assignment", "accessList", "statement", "body", 
			"expression", "relationalExpression", "additiveExpression", "multiplicativeExpression", 
			"preUnaryExpression", "appendExpression", "accessExpression", "otherExpression", 
			"lambdaFunction", "values", "listValue", "boolValue", "functionPointer"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'def'", "'end'", "'main'", "'puts'", "'push'", "'len'", "'return'", 
			"'if'", "'else'", "'elseif'", "'method'", "'pattern'", "'match'", "'loop'", 
			"'for'", "'in'", "'do'", "'chop'", "'chomp'", "'+'", "'-'", "'*'", "'/'", 
			"'=='", "'!='", "'is not'", "'is'", "'>'", "'<'", "'&&'", "'||'", "'!'", 
			"'++'", "'--'", "'|'", "'<<'", "'true'", "'false'", "'break'", "'next'", 
			"'->'", "'='", "'('", "')'", "'['", "']'", "'{'", "'}'", "','", "'.'", 
			"'..'", "':'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "DEF", "END", "MAIN", "PUTS", "PUSH", "LEN", "RETURN", "IF", "ELSE", 
			"ELSEIF", "METHOD", "PATTERN", "MATCH", "LOOP", "FOR", "IN", "DO", "CHOP", 
			"CHOMP", "PLUS", "MINUS", "MULT", "DIVIDE", "EQUAL", "NOT_EQUAL", "IS_NOT", 
			"IS", "GREATER_THAN", "LESS_THAN", "AND", "OR", "NOT", "INCREMENT", "DECREMENT", 
			"SEPARATOR", "APPEND", "TRUE", "FALSE", "BREAK", "NEXT", "ARROW", "ASSIGN", 
			"LPAR", "RPAR", "LBRACK", "RBRACK", "LBRACE", "RBRACE", "COMMA", "DOT", 
			"DOUBLEDOT", "COLON", "SEMICOLLON", "INT_VALUE", "FLOAT_VALUE", "IDENTIFIER", 
			"STRING_VALUE", "COMMENT", "WS"
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
		public List<FunctionDeclarationContext> functionDeclaration() {
			return getRuleContexts(FunctionDeclarationContext.class);
		}
		public FunctionDeclarationContext functionDeclaration(int i) {
			return getRuleContext(FunctionDeclarationContext.class,i);
		}
		public List<PatternMatchingContext> patternMatching() {
			return getRuleContexts(PatternMatchingContext.class);
		}
		public PatternMatchingContext patternMatching(int i) {
			return getRuleContext(PatternMatchingContext.class,i);
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(74);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case DEF:
						{
						setState(72);
						functionDeclaration();
						}
						break;
					case PATTERN:
						{
						setState(73);
						patternMatching();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(78);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(79);
			main();
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
	public static class FunctionDeclarationContext extends ParserRuleContext {
		public Token IDENTIFIER;
		public TerminalNode DEF() { return getToken(FunctionCraftParser.DEF, 0); }
		public TerminalNode IDENTIFIER() { return getToken(FunctionCraftParser.IDENTIFIER, 0); }
		public FunctionArgumentsDeclarationContext functionArgumentsDeclaration() {
			return getRuleContext(FunctionArgumentsDeclarationContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode END() { return getToken(FunctionCraftParser.END, 0); }
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitFunctionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_functionDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(DEF);
			setState(82);
			((FunctionDeclarationContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			 System.out.println("FuncDec: " + (((FunctionDeclarationContext)_localctx).IDENTIFIER!=null?((FunctionDeclarationContext)_localctx).IDENTIFIER.getText():null)); 
			setState(84);
			functionArgumentsDeclaration();
			setState(85);
			body();
			setState(86);
			match(END);
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
	public static class FunctionArgumentsDeclarationContext extends ParserRuleContext {
		public TerminalNode LPAR() { return getToken(FunctionCraftParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FunctionCraftParser.RPAR, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(FunctionCraftParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(FunctionCraftParser.IDENTIFIER, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FunctionCraftParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FunctionCraftParser.COMMA, i);
		}
		public TerminalNode LBRACK() { return getToken(FunctionCraftParser.LBRACK, 0); }
		public List<TerminalNode> ASSIGN() { return getTokens(FunctionCraftParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(FunctionCraftParser.ASSIGN, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RBRACK() { return getToken(FunctionCraftParser.RBRACK, 0); }
		public FunctionArgumentsDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionArgumentsDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterFunctionArgumentsDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitFunctionArgumentsDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitFunctionArgumentsDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionArgumentsDeclarationContext functionArgumentsDeclaration() throws RecognitionException {
		FunctionArgumentsDeclarationContext _localctx = new FunctionArgumentsDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_functionArgumentsDeclaration);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(LPAR);
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(89);
				match(IDENTIFIER);
				setState(94);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(90);
						match(COMMA);
						setState(91);
						match(IDENTIFIER);
						}
						} 
					}
					setState(96);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				}
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(97);
					match(COMMA);
					setState(98);
					match(LBRACK);
					setState(99);
					match(IDENTIFIER);
					setState(100);
					match(ASSIGN);
					setState(101);
					expression();
					setState(108);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(102);
						match(COMMA);
						setState(103);
						match(IDENTIFIER);
						setState(104);
						match(ASSIGN);
						setState(105);
						expression();
						}
						}
						setState(110);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(111);
					match(RBRACK);
					}
				}

				}
			}

			setState(117);
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
	public static class PatternMatchingContext extends ParserRuleContext {
		public Token IDENTIFIER;
		public TerminalNode PATTERN() { return getToken(FunctionCraftParser.PATTERN, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(FunctionCraftParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(FunctionCraftParser.IDENTIFIER, i);
		}
		public TerminalNode LPAR() { return getToken(FunctionCraftParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FunctionCraftParser.RPAR, 0); }
		public TerminalNode SEMICOLLON() { return getToken(FunctionCraftParser.SEMICOLLON, 0); }
		public List<TerminalNode> SEPARATOR() { return getTokens(FunctionCraftParser.SEPARATOR); }
		public TerminalNode SEPARATOR(int i) {
			return getToken(FunctionCraftParser.SEPARATOR, i);
		}
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public List<TerminalNode> ASSIGN() { return getTokens(FunctionCraftParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(FunctionCraftParser.ASSIGN, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public PatternMatchingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_patternMatching; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterPatternMatching(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitPatternMatching(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitPatternMatching(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PatternMatchingContext patternMatching() throws RecognitionException {
		PatternMatchingContext _localctx = new PatternMatchingContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_patternMatching);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(PATTERN);
			setState(120);
			((PatternMatchingContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			 System.out.println("PatternDec: " + (((PatternMatchingContext)_localctx).IDENTIFIER!=null?((PatternMatchingContext)_localctx).IDENTIFIER.getText():null)); 
			setState(122);
			match(LPAR);
			setState(123);
			((PatternMatchingContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			setState(124);
			match(RPAR);
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEPARATOR) {
				{
				{
				setState(125);
				match(SEPARATOR);
				setState(126);
				condition();
				setState(127);
				match(ASSIGN);
				setState(128);
				expression();
				}
				}
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(135);
			match(SEMICOLLON);
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
		public TerminalNode DEF() { return getToken(FunctionCraftParser.DEF, 0); }
		public TerminalNode MAIN() { return getToken(FunctionCraftParser.MAIN, 0); }
		public TerminalNode LPAR() { return getToken(FunctionCraftParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FunctionCraftParser.RPAR, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode END() { return getToken(FunctionCraftParser.END, 0); }
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
			setState(137);
			match(DEF);
			setState(138);
			match(MAIN);
			 System.out.println("MAIN"); 
			setState(140);
			match(LPAR);
			setState(141);
			match(RPAR);
			setState(142);
			body();
			setState(143);
			match(END);
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
	public static class FunctionArgumentsContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FunctionCraftParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FunctionCraftParser.COMMA, i);
		}
		public FunctionArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionArguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterFunctionArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitFunctionArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitFunctionArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionArgumentsContext functionArguments() throws RecognitionException {
		FunctionArgumentsContext _localctx = new FunctionArgumentsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_functionArguments);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(145);
				expression();
				setState(150);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(146);
						match(COMMA);
						setState(147);
						expression();
						}
						} 
					}
					setState(152);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(FunctionCraftParser.RETURN, 0); }
		public TerminalNode SEMICOLLON() { return getToken(FunctionCraftParser.SEMICOLLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			match(RETURN);
			 System.out.println("RETURN"); 
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 270262599515113536L) != 0)) {
				{
				setState(157);
				expression();
				}
			}

			setState(160);
			match(SEMICOLLON);
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
	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(FunctionCraftParser.IF, 0); }
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public List<BodyContext> body() {
			return getRuleContexts(BodyContext.class);
		}
		public BodyContext body(int i) {
			return getRuleContext(BodyContext.class,i);
		}
		public TerminalNode END() { return getToken(FunctionCraftParser.END, 0); }
		public List<TerminalNode> ELSEIF() { return getTokens(FunctionCraftParser.ELSEIF); }
		public TerminalNode ELSEIF(int i) {
			return getToken(FunctionCraftParser.ELSEIF, i);
		}
		public TerminalNode ELSE() { return getToken(FunctionCraftParser.ELSE, 0); }
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(IF);
			 System.out.println("Decision: IF"); 
			setState(164);
			condition();
			setState(165);
			body();
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELSEIF) {
				{
				{
				setState(166);
				match(ELSEIF);
				 System.out.println("Decision: ELSE IF"); 
				setState(168);
				condition();
				setState(169);
				body();
				}
				}
				setState(175);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(176);
				match(ELSE);
				 System.out.println("Decision: ELSE"); 
				setState(178);
				body();
				}
			}

			setState(181);
			match(END);
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
	public static class ConditionContext extends ParserRuleContext {
		public List<TerminalNode> LPAR() { return getTokens(FunctionCraftParser.LPAR); }
		public TerminalNode LPAR(int i) {
			return getToken(FunctionCraftParser.LPAR, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> RPAR() { return getTokens(FunctionCraftParser.RPAR); }
		public TerminalNode RPAR(int i) {
			return getToken(FunctionCraftParser.RPAR, i);
		}
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(FunctionCraftParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(FunctionCraftParser.AND, i);
		}
		public List<TerminalNode> OR() { return getTokens(FunctionCraftParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(FunctionCraftParser.OR, i);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_condition);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(183);
					match(LPAR);
					setState(184);
					expression();
					setState(185);
					match(RPAR);
					setState(196);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(186);
							_la = _input.LA(1);
							if ( !(_la==AND || _la==OR) ) {
							_errHandler.recoverInline(this);
							}
							else {
								if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
								_errHandler.reportMatch(this);
								consume();
							}
							setState(188);
							_errHandler.sync(this);
							switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
							case 1:
								{
								setState(187);
								match(LPAR);
								}
								break;
							}
							setState(190);
							condition();
							setState(192);
							_errHandler.sync(this);
							switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
							case 1:
								{
								setState(191);
								match(RPAR);
								}
								break;
							}
							}
							} 
						}
						setState(198);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
					}
					}
					} 
				}
				setState(203);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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
	public static class PutsStatementContext extends ParserRuleContext {
		public TerminalNode PUTS() { return getToken(FunctionCraftParser.PUTS, 0); }
		public TerminalNode LPAR() { return getToken(FunctionCraftParser.LPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(FunctionCraftParser.RPAR, 0); }
		public TerminalNode SEMICOLLON() { return getToken(FunctionCraftParser.SEMICOLLON, 0); }
		public PutsStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_putsStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterPutsStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitPutsStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitPutsStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PutsStatementContext putsStatement() throws RecognitionException {
		PutsStatementContext _localctx = new PutsStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_putsStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			match(PUTS);
			 System.out.println("Built-In: PUTS"); 
			setState(206);
			match(LPAR);
			setState(207);
			expression();
			setState(208);
			match(RPAR);
			setState(209);
			match(SEMICOLLON);
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
	public static class LenStatementContext extends ParserRuleContext {
		public TerminalNode LEN() { return getToken(FunctionCraftParser.LEN, 0); }
		public TerminalNode LPAR() { return getToken(FunctionCraftParser.LPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(FunctionCraftParser.RPAR, 0); }
		public LenStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lenStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterLenStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitLenStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitLenStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LenStatementContext lenStatement() throws RecognitionException {
		LenStatementContext _localctx = new LenStatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_lenStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			match(LEN);
			 System.out.println("Built-In: LEN"); 
			setState(213);
			match(LPAR);
			setState(214);
			expression();
			setState(215);
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
	public static class PushStatementContext extends ParserRuleContext {
		public TerminalNode PUSH() { return getToken(FunctionCraftParser.PUSH, 0); }
		public TerminalNode LPAR() { return getToken(FunctionCraftParser.LPAR, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(FunctionCraftParser.COMMA, 0); }
		public TerminalNode RPAR() { return getToken(FunctionCraftParser.RPAR, 0); }
		public TerminalNode SEMICOLLON() { return getToken(FunctionCraftParser.SEMICOLLON, 0); }
		public PushStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pushStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterPushStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitPushStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitPushStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PushStatementContext pushStatement() throws RecognitionException {
		PushStatementContext _localctx = new PushStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_pushStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			match(PUSH);
			 System.out.println("Built-In: PUSH"); 
			setState(219);
			match(LPAR);
			setState(220);
			expression();
			setState(221);
			match(COMMA);
			setState(222);
			expression();
			setState(223);
			match(RPAR);
			setState(224);
			match(SEMICOLLON);
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
	public static class LoopDoStatementContext extends ParserRuleContext {
		public TerminalNode LOOP() { return getToken(FunctionCraftParser.LOOP, 0); }
		public TerminalNode DO() { return getToken(FunctionCraftParser.DO, 0); }
		public LoopBodyContext loopBody() {
			return getRuleContext(LoopBodyContext.class,0);
		}
		public TerminalNode END() { return getToken(FunctionCraftParser.END, 0); }
		public LoopDoStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopDoStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterLoopDoStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitLoopDoStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitLoopDoStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopDoStatementContext loopDoStatement() throws RecognitionException {
		LoopDoStatementContext _localctx = new LoopDoStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_loopDoStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			match(LOOP);
			setState(227);
			match(DO);
			 System.out.println("Loop: DO"); 
			setState(229);
			loopBody();
			setState(230);
			match(END);
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
	public static class LoopBodyContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> BREAK() { return getTokens(FunctionCraftParser.BREAK); }
		public TerminalNode BREAK(int i) {
			return getToken(FunctionCraftParser.BREAK, i);
		}
		public List<TerminalNode> SEMICOLLON() { return getTokens(FunctionCraftParser.SEMICOLLON); }
		public TerminalNode SEMICOLLON(int i) {
			return getToken(FunctionCraftParser.SEMICOLLON, i);
		}
		public List<TerminalNode> NEXT() { return getTokens(FunctionCraftParser.NEXT); }
		public TerminalNode NEXT(int i) {
			return getToken(FunctionCraftParser.NEXT, i);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public List<TerminalNode> IF() { return getTokens(FunctionCraftParser.IF); }
		public TerminalNode IF(int i) {
			return getToken(FunctionCraftParser.IF, i);
		}
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public LoopBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterLoopBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitLoopBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitLoopBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopBodyContext loopBody() throws RecognitionException {
		LoopBodyContext _localctx = new LoopBodyContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_loopBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 270264248782604656L) != 0)) {
				{
				setState(247);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PUTS:
				case PUSH:
				case LEN:
				case IF:
				case METHOD:
				case LOOP:
				case FOR:
				case CHOP:
				case CHOMP:
				case MINUS:
				case NOT:
				case INCREMENT:
				case DECREMENT:
				case TRUE:
				case FALSE:
				case ARROW:
				case LPAR:
				case LBRACK:
				case INT_VALUE:
				case FLOAT_VALUE:
				case IDENTIFIER:
				case STRING_VALUE:
					{
					setState(232);
					statement();
					}
					break;
				case BREAK:
					{
					setState(233);
					match(BREAK);
					 System.out.println("Control: BREAK"); 
					setState(237);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==IF) {
						{
						setState(235);
						match(IF);
						setState(236);
						condition();
						}
					}

					setState(239);
					match(SEMICOLLON);
					}
					break;
				case NEXT:
					{
					setState(240);
					match(NEXT);
					 System.out.println("Control: NEXT"); 
					setState(244);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==IF) {
						{
						setState(242);
						match(IF);
						setState(243);
						condition();
						}
					}

					setState(246);
					match(SEMICOLLON);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(251);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(253);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RETURN) {
				{
				setState(252);
				returnStatement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ForStatementContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(FunctionCraftParser.FOR, 0); }
		public TerminalNode IDENTIFIER() { return getToken(FunctionCraftParser.IDENTIFIER, 0); }
		public TerminalNode IN() { return getToken(FunctionCraftParser.IN, 0); }
		public RangeContext range() {
			return getRuleContext(RangeContext.class,0);
		}
		public LoopBodyContext loopBody() {
			return getRuleContext(LoopBodyContext.class,0);
		}
		public TerminalNode END() { return getToken(FunctionCraftParser.END, 0); }
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_forStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			match(FOR);
			 System.out.println("Loop: FOR"); 
			setState(257);
			match(IDENTIFIER);
			setState(258);
			match(IN);
			setState(259);
			range();
			setState(260);
			loopBody();
			setState(261);
			match(END);
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
	public static class RangeContext extends ParserRuleContext {
		public TerminalNode LPAR() { return getToken(FunctionCraftParser.LPAR, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode DOUBLEDOT() { return getToken(FunctionCraftParser.DOUBLEDOT, 0); }
		public TerminalNode RPAR() { return getToken(FunctionCraftParser.RPAR, 0); }
		public TerminalNode LBRACK() { return getToken(FunctionCraftParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(FunctionCraftParser.RBRACK, 0); }
		public List<TerminalNode> COMMA() { return getTokens(FunctionCraftParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FunctionCraftParser.COMMA, i);
		}
		public TerminalNode IDENTIFIER() { return getToken(FunctionCraftParser.IDENTIFIER, 0); }
		public RangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitRange(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitRange(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RangeContext range() throws RecognitionException {
		RangeContext _localctx = new RangeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_range);
		int _la;
		try {
			setState(281);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAR:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(263);
				match(LPAR);
				setState(264);
				expression();
				setState(265);
				match(DOUBLEDOT);
				setState(266);
				expression();
				setState(267);
				match(RPAR);
				}
				}
				break;
			case LBRACK:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(269);
				match(LBRACK);
				{
				setState(270);
				expression();
				setState(275);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(271);
					match(COMMA);
					setState(272);
					expression();
					}
					}
					setState(277);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(278);
				match(RBRACK);
				}
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(280);
				match(IDENTIFIER);
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
	public static class FilterStatementContext extends ParserRuleContext {
		public TerminalNode LBRACK() { return getToken(FunctionCraftParser.LBRACK, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode SEPARATOR() { return getToken(FunctionCraftParser.SEPARATOR, 0); }
		public TerminalNode IDENTIFIER() { return getToken(FunctionCraftParser.IDENTIFIER, 0); }
		public TerminalNode ARROW() { return getToken(FunctionCraftParser.ARROW, 0); }
		public RangeContext range() {
			return getRuleContext(RangeContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(FunctionCraftParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FunctionCraftParser.COMMA, i);
		}
		public TerminalNode RBRACK() { return getToken(FunctionCraftParser.RBRACK, 0); }
		public FilterStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filterStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterFilterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitFilterStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitFilterStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FilterStatementContext filterStatement() throws RecognitionException {
		FilterStatementContext _localctx = new FilterStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_filterStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 System.out.println("Structure: FILTER"); 
			setState(284);
			match(LBRACK);
			setState(285);
			expression();
			setState(286);
			match(SEPARATOR);
			setState(287);
			match(IDENTIFIER);
			setState(288);
			match(ARROW);
			setState(289);
			range();
			setState(290);
			match(COMMA);
			setState(291);
			expression();
			setState(296);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(292);
				match(COMMA);
				setState(293);
				expression();
				}
				}
				setState(298);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(299);
			match(RBRACK);
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
	public static class MatchPatternStatementContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(FunctionCraftParser.IDENTIFIER, 0); }
		public TerminalNode DOT() { return getToken(FunctionCraftParser.DOT, 0); }
		public TerminalNode MATCH() { return getToken(FunctionCraftParser.MATCH, 0); }
		public TerminalNode LPAR() { return getToken(FunctionCraftParser.LPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(FunctionCraftParser.RPAR, 0); }
		public MatchPatternStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matchPatternStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterMatchPatternStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitMatchPatternStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitMatchPatternStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatchPatternStatementContext matchPatternStatement() throws RecognitionException {
		MatchPatternStatementContext _localctx = new MatchPatternStatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_matchPatternStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			 System.out.println("Built-In: MATCH"); 
			setState(302);
			match(IDENTIFIER);
			setState(303);
			match(DOT);
			setState(304);
			match(MATCH);
			setState(305);
			match(LPAR);
			setState(306);
			expression();
			setState(307);
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
	public static class ChopAndChompStatementContext extends ParserRuleContext {
		public TerminalNode LPAR() { return getToken(FunctionCraftParser.LPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(FunctionCraftParser.RPAR, 0); }
		public TerminalNode CHOP() { return getToken(FunctionCraftParser.CHOP, 0); }
		public TerminalNode CHOMP() { return getToken(FunctionCraftParser.CHOMP, 0); }
		public ChopAndChompStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chopAndChompStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterChopAndChompStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitChopAndChompStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitChopAndChompStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChopAndChompStatementContext chopAndChompStatement() throws RecognitionException {
		ChopAndChompStatementContext _localctx = new ChopAndChompStatementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_chopAndChompStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(313);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CHOP:
				{
				setState(309);
				match(CHOP);
				 System.out.println("Built-In: CHOP"); 
				}
				break;
			case CHOMP:
				{
				setState(311);
				match(CHOMP);
				 System.out.println("Built-In: CHOMP"); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(315);
			match(LPAR);
			setState(316);
			expression();
			setState(317);
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
	public static class AssignmentContext extends ParserRuleContext {
		public Token IDENTIFIER;
		public TerminalNode IDENTIFIER() { return getToken(FunctionCraftParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(FunctionCraftParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLLON() { return getToken(FunctionCraftParser.SEMICOLLON, 0); }
		public AccessListContext accessList() {
			return getRuleContext(AccessListContext.class,0);
		}
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
		enterRule(_localctx, 38, RULE_assignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			((AssignmentContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			 System.out.println("Assignment: " + (((AssignmentContext)_localctx).IDENTIFIER!=null?((AssignmentContext)_localctx).IDENTIFIER.getText():null)); 
			setState(322);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACK) {
				{
				setState(321);
				accessList();
				}
			}

			setState(324);
			match(ASSIGN);
			setState(325);
			expression();
			setState(326);
			match(SEMICOLLON);
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
	public static class AccessListContext extends ParserRuleContext {
		public TerminalNode LBRACK() { return getToken(FunctionCraftParser.LBRACK, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(FunctionCraftParser.RBRACK, 0); }
		public AccessListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accessList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterAccessList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitAccessList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitAccessList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccessListContext accessList() throws RecognitionException {
		AccessListContext _localctx = new AccessListContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_accessList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			match(LBRACK);
			setState(329);
			expression();
			setState(330);
			match(RBRACK);
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
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public LoopDoStatementContext loopDoStatement() {
			return getRuleContext(LoopDoStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public PutsStatementContext putsStatement() {
			return getRuleContext(PutsStatementContext.class,0);
		}
		public PushStatementContext pushStatement() {
			return getRuleContext(PushStatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLLON() { return getToken(FunctionCraftParser.SEMICOLLON, 0); }
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
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
		enterRule(_localctx, 42, RULE_statement);
		try {
			setState(341);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(332);
				ifStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(333);
				loopDoStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(334);
				forStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(335);
				putsStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(336);
				pushStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(337);
				expression();
				setState(338);
				match(SEMICOLLON);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(340);
				assignment();
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

	@SuppressWarnings("CheckReturnValue")
	public static class BodyContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(346);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 270262599515162992L) != 0)) {
				{
				{
				setState(343);
				statement();
				}
				}
				setState(348);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(350);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RETURN) {
				{
				setState(349);
				returnStatement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public Token op;
		public List<RelationalExpressionContext> relationalExpression() {
			return getRuleContexts(RelationalExpressionContext.class);
		}
		public RelationalExpressionContext relationalExpression(int i) {
			return getRuleContext(RelationalExpressionContext.class,i);
		}
		public List<TerminalNode> EQUAL() { return getTokens(FunctionCraftParser.EQUAL); }
		public TerminalNode EQUAL(int i) {
			return getToken(FunctionCraftParser.EQUAL, i);
		}
		public List<TerminalNode> NOT_EQUAL() { return getTokens(FunctionCraftParser.NOT_EQUAL); }
		public TerminalNode NOT_EQUAL(int i) {
			return getToken(FunctionCraftParser.NOT_EQUAL, i);
		}
		public List<TerminalNode> IS_NOT() { return getTokens(FunctionCraftParser.IS_NOT); }
		public TerminalNode IS_NOT(int i) {
			return getToken(FunctionCraftParser.IS_NOT, i);
		}
		public List<TerminalNode> IS() { return getTokens(FunctionCraftParser.IS); }
		public TerminalNode IS(int i) {
			return getToken(FunctionCraftParser.IS, i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_expression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(352);
			relationalExpression();
			setState(364);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(357);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case EQUAL:
						{
						setState(353);
						((ExpressionContext)_localctx).op = match(EQUAL);
						}
						break;
					case NOT_EQUAL:
						{
						setState(354);
						((ExpressionContext)_localctx).op = match(NOT_EQUAL);
						}
						break;
					case IS_NOT:
						{
						setState(355);
						((ExpressionContext)_localctx).op = match(IS_NOT);
						}
						break;
					case IS:
						{
						setState(356);
						((ExpressionContext)_localctx).op = match(IS);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(359);
					relationalExpression();
					 System.out.println("Operator: " + (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null)); 
					}
					} 
				}
				setState(366);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
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
	public static class RelationalExpressionContext extends ParserRuleContext {
		public Token op;
		public List<AdditiveExpressionContext> additiveExpression() {
			return getRuleContexts(AdditiveExpressionContext.class);
		}
		public AdditiveExpressionContext additiveExpression(int i) {
			return getRuleContext(AdditiveExpressionContext.class,i);
		}
		public List<TerminalNode> GREATER_THAN() { return getTokens(FunctionCraftParser.GREATER_THAN); }
		public TerminalNode GREATER_THAN(int i) {
			return getToken(FunctionCraftParser.GREATER_THAN, i);
		}
		public List<TerminalNode> LESS_THAN() { return getTokens(FunctionCraftParser.LESS_THAN); }
		public TerminalNode LESS_THAN(int i) {
			return getToken(FunctionCraftParser.LESS_THAN, i);
		}
		public RelationalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterRelationalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitRelationalExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitRelationalExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationalExpressionContext relationalExpression() throws RecognitionException {
		RelationalExpressionContext _localctx = new RelationalExpressionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_relationalExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(367);
			additiveExpression();
			setState(377);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(370);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case GREATER_THAN:
						{
						setState(368);
						((RelationalExpressionContext)_localctx).op = match(GREATER_THAN);
						}
						break;
					case LESS_THAN:
						{
						setState(369);
						((RelationalExpressionContext)_localctx).op = match(LESS_THAN);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(372);
					additiveExpression();
					 System.out.println("Operator: " + (((RelationalExpressionContext)_localctx).op!=null?((RelationalExpressionContext)_localctx).op.getText():null)); 
					}
					} 
				}
				setState(379);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
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
	public static class AdditiveExpressionContext extends ParserRuleContext {
		public Token op;
		public List<MultiplicativeExpressionContext> multiplicativeExpression() {
			return getRuleContexts(MultiplicativeExpressionContext.class);
		}
		public MultiplicativeExpressionContext multiplicativeExpression(int i) {
			return getRuleContext(MultiplicativeExpressionContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(FunctionCraftParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(FunctionCraftParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(FunctionCraftParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(FunctionCraftParser.MINUS, i);
		}
		public AdditiveExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterAdditiveExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitAdditiveExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitAdditiveExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdditiveExpressionContext additiveExpression() throws RecognitionException {
		AdditiveExpressionContext _localctx = new AdditiveExpressionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_additiveExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(380);
			multiplicativeExpression();
			setState(390);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(383);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case PLUS:
						{
						setState(381);
						((AdditiveExpressionContext)_localctx).op = match(PLUS);
						}
						break;
					case MINUS:
						{
						setState(382);
						((AdditiveExpressionContext)_localctx).op = match(MINUS);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(385);
					multiplicativeExpression();
					 System.out.println("Operator: " + (((AdditiveExpressionContext)_localctx).op!=null?((AdditiveExpressionContext)_localctx).op.getText():null)); 
					}
					} 
				}
				setState(392);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
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
	public static class MultiplicativeExpressionContext extends ParserRuleContext {
		public Token op;
		public List<PreUnaryExpressionContext> preUnaryExpression() {
			return getRuleContexts(PreUnaryExpressionContext.class);
		}
		public PreUnaryExpressionContext preUnaryExpression(int i) {
			return getRuleContext(PreUnaryExpressionContext.class,i);
		}
		public List<TerminalNode> MULT() { return getTokens(FunctionCraftParser.MULT); }
		public TerminalNode MULT(int i) {
			return getToken(FunctionCraftParser.MULT, i);
		}
		public List<TerminalNode> DIVIDE() { return getTokens(FunctionCraftParser.DIVIDE); }
		public TerminalNode DIVIDE(int i) {
			return getToken(FunctionCraftParser.DIVIDE, i);
		}
		public MultiplicativeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterMultiplicativeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitMultiplicativeExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitMultiplicativeExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplicativeExpressionContext multiplicativeExpression() throws RecognitionException {
		MultiplicativeExpressionContext _localctx = new MultiplicativeExpressionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_multiplicativeExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(393);
			preUnaryExpression();
			setState(403);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(396);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case MULT:
						{
						setState(394);
						((MultiplicativeExpressionContext)_localctx).op = match(MULT);
						}
						break;
					case DIVIDE:
						{
						setState(395);
						((MultiplicativeExpressionContext)_localctx).op = match(DIVIDE);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(398);
					preUnaryExpression();
					 System.out.println("Operator: " + (((MultiplicativeExpressionContext)_localctx).op!=null?((MultiplicativeExpressionContext)_localctx).op.getText():null)); 
					}
					} 
				}
				setState(405);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
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
	public static class PreUnaryExpressionContext extends ParserRuleContext {
		public Token op;
		public PreUnaryExpressionContext preUnaryExpression() {
			return getRuleContext(PreUnaryExpressionContext.class,0);
		}
		public TerminalNode NOT() { return getToken(FunctionCraftParser.NOT, 0); }
		public TerminalNode MINUS() { return getToken(FunctionCraftParser.MINUS, 0); }
		public TerminalNode INCREMENT() { return getToken(FunctionCraftParser.INCREMENT, 0); }
		public TerminalNode DECREMENT() { return getToken(FunctionCraftParser.DECREMENT, 0); }
		public AppendExpressionContext appendExpression() {
			return getRuleContext(AppendExpressionContext.class,0);
		}
		public PreUnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preUnaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterPreUnaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitPreUnaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitPreUnaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PreUnaryExpressionContext preUnaryExpression() throws RecognitionException {
		PreUnaryExpressionContext _localctx = new PreUnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_preUnaryExpression);
		try {
			setState(416);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
			case NOT:
			case INCREMENT:
			case DECREMENT:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(410);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NOT:
					{
					setState(406);
					((PreUnaryExpressionContext)_localctx).op = match(NOT);
					}
					break;
				case MINUS:
					{
					setState(407);
					((PreUnaryExpressionContext)_localctx).op = match(MINUS);
					}
					break;
				case INCREMENT:
					{
					setState(408);
					((PreUnaryExpressionContext)_localctx).op = match(INCREMENT);
					}
					break;
				case DECREMENT:
					{
					setState(409);
					((PreUnaryExpressionContext)_localctx).op = match(DECREMENT);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(412);
				preUnaryExpression();
				 System.out.println("Operator: " + (((PreUnaryExpressionContext)_localctx).op!=null?((PreUnaryExpressionContext)_localctx).op.getText():null)); 
				}
				}
				break;
			case LEN:
			case METHOD:
			case CHOP:
			case CHOMP:
			case TRUE:
			case FALSE:
			case ARROW:
			case LPAR:
			case LBRACK:
			case INT_VALUE:
			case FLOAT_VALUE:
			case IDENTIFIER:
			case STRING_VALUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(415);
				appendExpression();
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
	public static class AppendExpressionContext extends ParserRuleContext {
		public Token APPEND;
		public List<AccessExpressionContext> accessExpression() {
			return getRuleContexts(AccessExpressionContext.class);
		}
		public AccessExpressionContext accessExpression(int i) {
			return getRuleContext(AccessExpressionContext.class,i);
		}
		public List<TerminalNode> APPEND() { return getTokens(FunctionCraftParser.APPEND); }
		public TerminalNode APPEND(int i) {
			return getToken(FunctionCraftParser.APPEND, i);
		}
		public AppendExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_appendExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterAppendExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitAppendExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitAppendExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AppendExpressionContext appendExpression() throws RecognitionException {
		AppendExpressionContext _localctx = new AppendExpressionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_appendExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(418);
			accessExpression();
			setState(425);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(419);
					((AppendExpressionContext)_localctx).APPEND = match(APPEND);
					setState(420);
					accessExpression();
					 System.out.println("Operator: " + (((AppendExpressionContext)_localctx).APPEND!=null?((AppendExpressionContext)_localctx).APPEND.getText():null)); 
					}
					} 
				}
				setState(427);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
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
	public static class AccessExpressionContext extends ParserRuleContext {
		public OtherExpressionContext otherExpression() {
			return getRuleContext(OtherExpressionContext.class,0);
		}
		public List<TerminalNode> LPAR() { return getTokens(FunctionCraftParser.LPAR); }
		public TerminalNode LPAR(int i) {
			return getToken(FunctionCraftParser.LPAR, i);
		}
		public List<FunctionArgumentsContext> functionArguments() {
			return getRuleContexts(FunctionArgumentsContext.class);
		}
		public FunctionArgumentsContext functionArguments(int i) {
			return getRuleContext(FunctionArgumentsContext.class,i);
		}
		public List<TerminalNode> RPAR() { return getTokens(FunctionCraftParser.RPAR); }
		public TerminalNode RPAR(int i) {
			return getToken(FunctionCraftParser.RPAR, i);
		}
		public List<AccessListContext> accessList() {
			return getRuleContexts(AccessListContext.class);
		}
		public AccessListContext accessList(int i) {
			return getRuleContext(AccessListContext.class,i);
		}
		public AccessExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accessExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterAccessExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitAccessExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitAccessExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccessExpressionContext accessExpression() throws RecognitionException {
		AccessExpressionContext _localctx = new AccessExpressionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_accessExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(428);
			otherExpression();
			setState(436);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(429);
					match(LPAR);
					setState(430);
					functionArguments();
					setState(431);
					match(RPAR);
					 System.out.println("FunctionCall"); 
					}
					} 
				}
				setState(438);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			}
			setState(442);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(439);
					accessList();
					}
					} 
				}
				setState(444);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
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
	public static class OtherExpressionContext extends ParserRuleContext {
		public ValuesContext values() {
			return getRuleContext(ValuesContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(FunctionCraftParser.IDENTIFIER, 0); }
		public LambdaFunctionContext lambdaFunction() {
			return getRuleContext(LambdaFunctionContext.class,0);
		}
		public ChopAndChompStatementContext chopAndChompStatement() {
			return getRuleContext(ChopAndChompStatementContext.class,0);
		}
		public MatchPatternStatementContext matchPatternStatement() {
			return getRuleContext(MatchPatternStatementContext.class,0);
		}
		public FilterStatementContext filterStatement() {
			return getRuleContext(FilterStatementContext.class,0);
		}
		public LenStatementContext lenStatement() {
			return getRuleContext(LenStatementContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(FunctionCraftParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FunctionCraftParser.RPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public OtherExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_otherExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterOtherExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitOtherExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitOtherExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OtherExpressionContext otherExpression() throws RecognitionException {
		OtherExpressionContext _localctx = new OtherExpressionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_otherExpression);
		int _la;
		try {
			setState(457);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(445);
				values();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(446);
				match(IDENTIFIER);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(447);
				lambdaFunction();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(448);
				chopAndChompStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(449);
				matchPatternStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(450);
				filterStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(451);
				lenStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(452);
				match(LPAR);
				setState(454);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 270262599515113536L) != 0)) {
					{
					setState(453);
					expression();
					}
				}

				setState(456);
				match(RPAR);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LambdaFunctionContext extends ParserRuleContext {
		public TerminalNode ARROW() { return getToken(FunctionCraftParser.ARROW, 0); }
		public FunctionArgumentsDeclarationContext functionArgumentsDeclaration() {
			return getRuleContext(FunctionArgumentsDeclarationContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(FunctionCraftParser.LBRACE, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(FunctionCraftParser.RBRACE, 0); }
		public FunctionArgumentsContext functionArguments() {
			return getRuleContext(FunctionArgumentsContext.class,0);
		}
		public LambdaFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterLambdaFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitLambdaFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitLambdaFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaFunctionContext lambdaFunction() throws RecognitionException {
		LambdaFunctionContext _localctx = new LambdaFunctionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_lambdaFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(459);
			match(ARROW);
			 System.out.println("Structure: LAMBDA"); 
			setState(461);
			functionArgumentsDeclaration();
			setState(462);
			match(LBRACE);
			setState(463);
			body();
			setState(464);
			match(RBRACE);
			setState(465);
			functionArguments();
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
	public static class ValuesContext extends ParserRuleContext {
		public BoolValueContext boolValue() {
			return getRuleContext(BoolValueContext.class,0);
		}
		public TerminalNode STRING_VALUE() { return getToken(FunctionCraftParser.STRING_VALUE, 0); }
		public TerminalNode INT_VALUE() { return getToken(FunctionCraftParser.INT_VALUE, 0); }
		public TerminalNode FLOAT_VALUE() { return getToken(FunctionCraftParser.FLOAT_VALUE, 0); }
		public ListValueContext listValue() {
			return getRuleContext(ListValueContext.class,0);
		}
		public FunctionPointerContext functionPointer() {
			return getRuleContext(FunctionPointerContext.class,0);
		}
		public ValuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_values; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterValues(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitValues(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitValues(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValuesContext values() throws RecognitionException {
		ValuesContext _localctx = new ValuesContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_values);
		try {
			setState(473);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 1);
				{
				setState(467);
				boolValue();
				}
				break;
			case STRING_VALUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(468);
				match(STRING_VALUE);
				}
				break;
			case INT_VALUE:
				enterOuterAlt(_localctx, 3);
				{
				setState(469);
				match(INT_VALUE);
				}
				break;
			case FLOAT_VALUE:
				enterOuterAlt(_localctx, 4);
				{
				setState(470);
				match(FLOAT_VALUE);
				}
				break;
			case LBRACK:
				enterOuterAlt(_localctx, 5);
				{
				setState(471);
				listValue();
				}
				break;
			case METHOD:
				enterOuterAlt(_localctx, 6);
				{
				setState(472);
				functionPointer();
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
	public static class ListValueContext extends ParserRuleContext {
		public TerminalNode LBRACK() { return getToken(FunctionCraftParser.LBRACK, 0); }
		public FunctionArgumentsContext functionArguments() {
			return getRuleContext(FunctionArgumentsContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(FunctionCraftParser.RBRACK, 0); }
		public ListValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterListValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitListValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitListValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListValueContext listValue() throws RecognitionException {
		ListValueContext _localctx = new ListValueContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_listValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(475);
			match(LBRACK);
			setState(476);
			functionArguments();
			setState(477);
			match(RBRACK);
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
	public static class BoolValueContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(FunctionCraftParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(FunctionCraftParser.FALSE, 0); }
		public BoolValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterBoolValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitBoolValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitBoolValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolValueContext boolValue() throws RecognitionException {
		BoolValueContext _localctx = new BoolValueContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_boolValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(479);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
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
	public static class FunctionPointerContext extends ParserRuleContext {
		public TerminalNode METHOD() { return getToken(FunctionCraftParser.METHOD, 0); }
		public TerminalNode LPAR() { return getToken(FunctionCraftParser.LPAR, 0); }
		public TerminalNode COLON() { return getToken(FunctionCraftParser.COLON, 0); }
		public TerminalNode IDENTIFIER() { return getToken(FunctionCraftParser.IDENTIFIER, 0); }
		public TerminalNode RPAR() { return getToken(FunctionCraftParser.RPAR, 0); }
		public FunctionPointerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionPointer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterFunctionPointer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitFunctionPointer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitFunctionPointer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionPointerContext functionPointer() throws RecognitionException {
		FunctionPointerContext _localctx = new FunctionPointerContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_functionPointer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(481);
			match(METHOD);
			setState(482);
			match(LPAR);
			setState(483);
			match(COLON);
			setState(484);
			match(IDENTIFIER);
			setState(485);
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

	public static final String _serializedATN =
		"\u0004\u0001;\u01e8\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0001\u0000\u0001\u0000\u0005\u0000K\b\u0000\n\u0000\f\u0000"+
		"N\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0005\u0002]\b\u0002\n\u0002\f\u0002`\t\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002k\b\u0002\n\u0002\f\u0002"+
		"n\t\u0002\u0001\u0002\u0001\u0002\u0003\u0002r\b\u0002\u0003\u0002t\b"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0005\u0003\u0083\b\u0003\n\u0003\f\u0003\u0086\t\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0005\u0005\u0095\b\u0005\n\u0005\f\u0005\u0098\t\u0005\u0003"+
		"\u0005\u009a\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u009f"+
		"\b\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005"+
		"\u0007\u00ac\b\u0007\n\u0007\f\u0007\u00af\t\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0003\u0007\u00b4\b\u0007\u0001\u0007\u0001\u0007\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00bd\b\b\u0001\b\u0001\b\u0003"+
		"\b\u00c1\b\b\u0005\b\u00c3\b\b\n\b\f\b\u00c6\t\b\u0005\b\u00c8\b\b\n\b"+
		"\f\b\u00cb\t\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0003\r\u00ee\b\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0003\r\u00f5\b\r\u0001\r\u0005\r\u00f8\b\r\n\r\f\r\u00fb\t"+
		"\r\u0001\r\u0003\r\u00fe\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u0112\b\u000f\n\u000f\f\u000f"+
		"\u0115\t\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u011a\b"+
		"\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005"+
		"\u0010\u0127\b\u0010\n\u0010\f\u0010\u012a\t\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0003\u0012\u013a\b\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0143\b\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u0156\b\u0015"+
		"\u0001\u0016\u0005\u0016\u0159\b\u0016\n\u0016\f\u0016\u015c\t\u0016\u0001"+
		"\u0016\u0003\u0016\u015f\b\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0003\u0017\u0166\b\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0005\u0017\u016b\b\u0017\n\u0017\f\u0017\u016e\t\u0017\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0003\u0018\u0173\b\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0005\u0018\u0178\b\u0018\n\u0018\f\u0018\u017b\t\u0018\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u0180\b\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0005\u0019\u0185\b\u0019\n\u0019\f\u0019\u0188\t\u0019"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u018d\b\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0005\u001a\u0192\b\u001a\n\u001a\f\u001a\u0195"+
		"\t\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u019b"+
		"\b\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u01a1"+
		"\b\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0005"+
		"\u001c\u01a8\b\u001c\n\u001c\f\u001c\u01ab\t\u001c\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0005\u001d\u01b3\b\u001d"+
		"\n\u001d\f\u001d\u01b6\t\u001d\u0001\u001d\u0005\u001d\u01b9\b\u001d\n"+
		"\u001d\f\u001d\u01bc\t\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0003"+
		"\u001e\u01c7\b\u001e\u0001\u001e\u0003\u001e\u01ca\b\u001e\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0003 \u01da\b"+
		" \u0001!\u0001!\u0001!\u0001!\u0001\"\u0001\"\u0001#\u0001#\u0001#\u0001"+
		"#\u0001#\u0001#\u0001#\u0000\u0000$\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDF"+
		"\u0000\u0002\u0001\u0000\u001e\u001f\u0001\u0000%&\u0205\u0000L\u0001"+
		"\u0000\u0000\u0000\u0002Q\u0001\u0000\u0000\u0000\u0004X\u0001\u0000\u0000"+
		"\u0000\u0006w\u0001\u0000\u0000\u0000\b\u0089\u0001\u0000\u0000\u0000"+
		"\n\u0099\u0001\u0000\u0000\u0000\f\u009b\u0001\u0000\u0000\u0000\u000e"+
		"\u00a2\u0001\u0000\u0000\u0000\u0010\u00c9\u0001\u0000\u0000\u0000\u0012"+
		"\u00cc\u0001\u0000\u0000\u0000\u0014\u00d3\u0001\u0000\u0000\u0000\u0016"+
		"\u00d9\u0001\u0000\u0000\u0000\u0018\u00e2\u0001\u0000\u0000\u0000\u001a"+
		"\u00f9\u0001\u0000\u0000\u0000\u001c\u00ff\u0001\u0000\u0000\u0000\u001e"+
		"\u0119\u0001\u0000\u0000\u0000 \u011b\u0001\u0000\u0000\u0000\"\u012d"+
		"\u0001\u0000\u0000\u0000$\u0139\u0001\u0000\u0000\u0000&\u013f\u0001\u0000"+
		"\u0000\u0000(\u0148\u0001\u0000\u0000\u0000*\u0155\u0001\u0000\u0000\u0000"+
		",\u015a\u0001\u0000\u0000\u0000.\u0160\u0001\u0000\u0000\u00000\u016f"+
		"\u0001\u0000\u0000\u00002\u017c\u0001\u0000\u0000\u00004\u0189\u0001\u0000"+
		"\u0000\u00006\u01a0\u0001\u0000\u0000\u00008\u01a2\u0001\u0000\u0000\u0000"+
		":\u01ac\u0001\u0000\u0000\u0000<\u01c9\u0001\u0000\u0000\u0000>\u01cb"+
		"\u0001\u0000\u0000\u0000@\u01d9\u0001\u0000\u0000\u0000B\u01db\u0001\u0000"+
		"\u0000\u0000D\u01df\u0001\u0000\u0000\u0000F\u01e1\u0001\u0000\u0000\u0000"+
		"HK\u0003\u0002\u0001\u0000IK\u0003\u0006\u0003\u0000JH\u0001\u0000\u0000"+
		"\u0000JI\u0001\u0000\u0000\u0000KN\u0001\u0000\u0000\u0000LJ\u0001\u0000"+
		"\u0000\u0000LM\u0001\u0000\u0000\u0000MO\u0001\u0000\u0000\u0000NL\u0001"+
		"\u0000\u0000\u0000OP\u0003\b\u0004\u0000P\u0001\u0001\u0000\u0000\u0000"+
		"QR\u0005\u0001\u0000\u0000RS\u00058\u0000\u0000ST\u0006\u0001\uffff\uffff"+
		"\u0000TU\u0003\u0004\u0002\u0000UV\u0003,\u0016\u0000VW\u0005\u0002\u0000"+
		"\u0000W\u0003\u0001\u0000\u0000\u0000Xs\u0005+\u0000\u0000Y^\u00058\u0000"+
		"\u0000Z[\u00051\u0000\u0000[]\u00058\u0000\u0000\\Z\u0001\u0000\u0000"+
		"\u0000]`\u0001\u0000\u0000\u0000^\\\u0001\u0000\u0000\u0000^_\u0001\u0000"+
		"\u0000\u0000_q\u0001\u0000\u0000\u0000`^\u0001\u0000\u0000\u0000ab\u0005"+
		"1\u0000\u0000bc\u0005-\u0000\u0000cd\u00058\u0000\u0000de\u0005*\u0000"+
		"\u0000el\u0003.\u0017\u0000fg\u00051\u0000\u0000gh\u00058\u0000\u0000"+
		"hi\u0005*\u0000\u0000ik\u0003.\u0017\u0000jf\u0001\u0000\u0000\u0000k"+
		"n\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000"+
		"\u0000mo\u0001\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000op\u0005.\u0000"+
		"\u0000pr\u0001\u0000\u0000\u0000qa\u0001\u0000\u0000\u0000qr\u0001\u0000"+
		"\u0000\u0000rt\u0001\u0000\u0000\u0000sY\u0001\u0000\u0000\u0000st\u0001"+
		"\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000uv\u0005,\u0000\u0000v\u0005"+
		"\u0001\u0000\u0000\u0000wx\u0005\f\u0000\u0000xy\u00058\u0000\u0000yz"+
		"\u0006\u0003\uffff\uffff\u0000z{\u0005+\u0000\u0000{|\u00058\u0000\u0000"+
		"|\u0084\u0005,\u0000\u0000}~\u0005#\u0000\u0000~\u007f\u0003\u0010\b\u0000"+
		"\u007f\u0080\u0005*\u0000\u0000\u0080\u0081\u0003.\u0017\u0000\u0081\u0083"+
		"\u0001\u0000\u0000\u0000\u0082}\u0001\u0000\u0000\u0000\u0083\u0086\u0001"+
		"\u0000\u0000\u0000\u0084\u0082\u0001\u0000\u0000\u0000\u0084\u0085\u0001"+
		"\u0000\u0000\u0000\u0085\u0087\u0001\u0000\u0000\u0000\u0086\u0084\u0001"+
		"\u0000\u0000\u0000\u0087\u0088\u00055\u0000\u0000\u0088\u0007\u0001\u0000"+
		"\u0000\u0000\u0089\u008a\u0005\u0001\u0000\u0000\u008a\u008b\u0005\u0003"+
		"\u0000\u0000\u008b\u008c\u0006\u0004\uffff\uffff\u0000\u008c\u008d\u0005"+
		"+\u0000\u0000\u008d\u008e\u0005,\u0000\u0000\u008e\u008f\u0003,\u0016"+
		"\u0000\u008f\u0090\u0005\u0002\u0000\u0000\u0090\t\u0001\u0000\u0000\u0000"+
		"\u0091\u0096\u0003.\u0017\u0000\u0092\u0093\u00051\u0000\u0000\u0093\u0095"+
		"\u0003.\u0017\u0000\u0094\u0092\u0001\u0000\u0000\u0000\u0095\u0098\u0001"+
		"\u0000\u0000\u0000\u0096\u0094\u0001\u0000\u0000\u0000\u0096\u0097\u0001"+
		"\u0000\u0000\u0000\u0097\u009a\u0001\u0000\u0000\u0000\u0098\u0096\u0001"+
		"\u0000\u0000\u0000\u0099\u0091\u0001\u0000\u0000\u0000\u0099\u009a\u0001"+
		"\u0000\u0000\u0000\u009a\u000b\u0001\u0000\u0000\u0000\u009b\u009c\u0005"+
		"\u0007\u0000\u0000\u009c\u009e\u0006\u0006\uffff\uffff\u0000\u009d\u009f"+
		"\u0003.\u0017\u0000\u009e\u009d\u0001\u0000\u0000\u0000\u009e\u009f\u0001"+
		"\u0000\u0000\u0000\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0\u00a1\u0005"+
		"5\u0000\u0000\u00a1\r\u0001\u0000\u0000\u0000\u00a2\u00a3\u0005\b\u0000"+
		"\u0000\u00a3\u00a4\u0006\u0007\uffff\uffff\u0000\u00a4\u00a5\u0003\u0010"+
		"\b\u0000\u00a5\u00ad\u0003,\u0016\u0000\u00a6\u00a7\u0005\n\u0000\u0000"+
		"\u00a7\u00a8\u0006\u0007\uffff\uffff\u0000\u00a8\u00a9\u0003\u0010\b\u0000"+
		"\u00a9\u00aa\u0003,\u0016\u0000\u00aa\u00ac\u0001\u0000\u0000\u0000\u00ab"+
		"\u00a6\u0001\u0000\u0000\u0000\u00ac\u00af\u0001\u0000\u0000\u0000\u00ad"+
		"\u00ab\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001\u0000\u0000\u0000\u00ae"+
		"\u00b3\u0001\u0000\u0000\u0000\u00af\u00ad\u0001\u0000\u0000\u0000\u00b0"+
		"\u00b1\u0005\t\u0000\u0000\u00b1\u00b2\u0006\u0007\uffff\uffff\u0000\u00b2"+
		"\u00b4\u0003,\u0016\u0000\u00b3\u00b0\u0001\u0000\u0000\u0000\u00b3\u00b4"+
		"\u0001\u0000\u0000\u0000\u00b4\u00b5\u0001\u0000\u0000\u0000\u00b5\u00b6"+
		"\u0005\u0002\u0000\u0000\u00b6\u000f\u0001\u0000\u0000\u0000\u00b7\u00b8"+
		"\u0005+\u0000\u0000\u00b8\u00b9\u0003.\u0017\u0000\u00b9\u00c4\u0005,"+
		"\u0000\u0000\u00ba\u00bc\u0007\u0000\u0000\u0000\u00bb\u00bd\u0005+\u0000"+
		"\u0000\u00bc\u00bb\u0001\u0000\u0000\u0000\u00bc\u00bd\u0001\u0000\u0000"+
		"\u0000\u00bd\u00be\u0001\u0000\u0000\u0000\u00be\u00c0\u0003\u0010\b\u0000"+
		"\u00bf\u00c1\u0005,\u0000\u0000\u00c0\u00bf\u0001\u0000\u0000\u0000\u00c0"+
		"\u00c1\u0001\u0000\u0000\u0000\u00c1\u00c3\u0001\u0000\u0000\u0000\u00c2"+
		"\u00ba\u0001\u0000\u0000\u0000\u00c3\u00c6\u0001\u0000\u0000\u0000\u00c4"+
		"\u00c2\u0001\u0000\u0000\u0000\u00c4\u00c5\u0001\u0000\u0000\u0000\u00c5"+
		"\u00c8\u0001\u0000\u0000\u0000\u00c6\u00c4\u0001\u0000\u0000\u0000\u00c7"+
		"\u00b7\u0001\u0000\u0000\u0000\u00c8\u00cb\u0001\u0000\u0000\u0000\u00c9"+
		"\u00c7\u0001\u0000\u0000\u0000\u00c9\u00ca\u0001\u0000\u0000\u0000\u00ca"+
		"\u0011\u0001\u0000\u0000\u0000\u00cb\u00c9\u0001\u0000\u0000\u0000\u00cc"+
		"\u00cd\u0005\u0004\u0000\u0000\u00cd\u00ce\u0006\t\uffff\uffff\u0000\u00ce"+
		"\u00cf\u0005+\u0000\u0000\u00cf\u00d0\u0003.\u0017\u0000\u00d0\u00d1\u0005"+
		",\u0000\u0000\u00d1\u00d2\u00055\u0000\u0000\u00d2\u0013\u0001\u0000\u0000"+
		"\u0000\u00d3\u00d4\u0005\u0006\u0000\u0000\u00d4\u00d5\u0006\n\uffff\uffff"+
		"\u0000\u00d5\u00d6\u0005+\u0000\u0000\u00d6\u00d7\u0003.\u0017\u0000\u00d7"+
		"\u00d8\u0005,\u0000\u0000\u00d8\u0015\u0001\u0000\u0000\u0000\u00d9\u00da"+
		"\u0005\u0005\u0000\u0000\u00da\u00db\u0006\u000b\uffff\uffff\u0000\u00db"+
		"\u00dc\u0005+\u0000\u0000\u00dc\u00dd\u0003.\u0017\u0000\u00dd\u00de\u0005"+
		"1\u0000\u0000\u00de\u00df\u0003.\u0017\u0000\u00df\u00e0\u0005,\u0000"+
		"\u0000\u00e0\u00e1\u00055\u0000\u0000\u00e1\u0017\u0001\u0000\u0000\u0000"+
		"\u00e2\u00e3\u0005\u000e\u0000\u0000\u00e3\u00e4\u0005\u0011\u0000\u0000"+
		"\u00e4\u00e5\u0006\f\uffff\uffff\u0000\u00e5\u00e6\u0003\u001a\r\u0000"+
		"\u00e6\u00e7\u0005\u0002\u0000\u0000\u00e7\u0019\u0001\u0000\u0000\u0000"+
		"\u00e8\u00f8\u0003*\u0015\u0000\u00e9\u00ea\u0005\'\u0000\u0000\u00ea"+
		"\u00ed\u0006\r\uffff\uffff\u0000\u00eb\u00ec\u0005\b\u0000\u0000\u00ec"+
		"\u00ee\u0003\u0010\b\u0000\u00ed\u00eb\u0001\u0000\u0000\u0000\u00ed\u00ee"+
		"\u0001\u0000\u0000\u0000\u00ee\u00ef\u0001\u0000\u0000\u0000\u00ef\u00f8"+
		"\u00055\u0000\u0000\u00f0\u00f1\u0005(\u0000\u0000\u00f1\u00f4\u0006\r"+
		"\uffff\uffff\u0000\u00f2\u00f3\u0005\b\u0000\u0000\u00f3\u00f5\u0003\u0010"+
		"\b\u0000\u00f4\u00f2\u0001\u0000\u0000\u0000\u00f4\u00f5\u0001\u0000\u0000"+
		"\u0000\u00f5\u00f6\u0001\u0000\u0000\u0000\u00f6\u00f8\u00055\u0000\u0000"+
		"\u00f7\u00e8\u0001\u0000\u0000\u0000\u00f7\u00e9\u0001\u0000\u0000\u0000"+
		"\u00f7\u00f0\u0001\u0000\u0000\u0000\u00f8\u00fb\u0001\u0000\u0000\u0000"+
		"\u00f9\u00f7\u0001\u0000\u0000\u0000\u00f9\u00fa\u0001\u0000\u0000\u0000"+
		"\u00fa\u00fd\u0001\u0000\u0000\u0000\u00fb\u00f9\u0001\u0000\u0000\u0000"+
		"\u00fc\u00fe\u0003\f\u0006\u0000\u00fd\u00fc\u0001\u0000\u0000\u0000\u00fd"+
		"\u00fe\u0001\u0000\u0000\u0000\u00fe\u001b\u0001\u0000\u0000\u0000\u00ff"+
		"\u0100\u0005\u000f\u0000\u0000\u0100\u0101\u0006\u000e\uffff\uffff\u0000"+
		"\u0101\u0102\u00058\u0000\u0000\u0102\u0103\u0005\u0010\u0000\u0000\u0103"+
		"\u0104\u0003\u001e\u000f\u0000\u0104\u0105\u0003\u001a\r\u0000\u0105\u0106"+
		"\u0005\u0002\u0000\u0000\u0106\u001d\u0001\u0000\u0000\u0000\u0107\u0108"+
		"\u0005+\u0000\u0000\u0108\u0109\u0003.\u0017\u0000\u0109\u010a\u00053"+
		"\u0000\u0000\u010a\u010b\u0003.\u0017\u0000\u010b\u010c\u0005,\u0000\u0000"+
		"\u010c\u011a\u0001\u0000\u0000\u0000\u010d\u010e\u0005-\u0000\u0000\u010e"+
		"\u0113\u0003.\u0017\u0000\u010f\u0110\u00051\u0000\u0000\u0110\u0112\u0003"+
		".\u0017\u0000\u0111\u010f\u0001\u0000\u0000\u0000\u0112\u0115\u0001\u0000"+
		"\u0000\u0000\u0113\u0111\u0001\u0000\u0000\u0000\u0113\u0114\u0001\u0000"+
		"\u0000\u0000\u0114\u0116\u0001\u0000\u0000\u0000\u0115\u0113\u0001\u0000"+
		"\u0000\u0000\u0116\u0117\u0005.\u0000\u0000\u0117\u011a\u0001\u0000\u0000"+
		"\u0000\u0118\u011a\u00058\u0000\u0000\u0119\u0107\u0001\u0000\u0000\u0000"+
		"\u0119\u010d\u0001\u0000\u0000\u0000\u0119\u0118\u0001\u0000\u0000\u0000"+
		"\u011a\u001f\u0001\u0000\u0000\u0000\u011b\u011c\u0006\u0010\uffff\uffff"+
		"\u0000\u011c\u011d\u0005-\u0000\u0000\u011d\u011e\u0003.\u0017\u0000\u011e"+
		"\u011f\u0005#\u0000\u0000\u011f\u0120\u00058\u0000\u0000\u0120\u0121\u0005"+
		")\u0000\u0000\u0121\u0122\u0003\u001e\u000f\u0000\u0122\u0123\u00051\u0000"+
		"\u0000\u0123\u0128\u0003.\u0017\u0000\u0124\u0125\u00051\u0000\u0000\u0125"+
		"\u0127\u0003.\u0017\u0000\u0126\u0124\u0001\u0000\u0000\u0000\u0127\u012a"+
		"\u0001\u0000\u0000\u0000\u0128\u0126\u0001\u0000\u0000\u0000\u0128\u0129"+
		"\u0001\u0000\u0000\u0000\u0129\u012b\u0001\u0000\u0000\u0000\u012a\u0128"+
		"\u0001\u0000\u0000\u0000\u012b\u012c\u0005.\u0000\u0000\u012c!\u0001\u0000"+
		"\u0000\u0000\u012d\u012e\u0006\u0011\uffff\uffff\u0000\u012e\u012f\u0005"+
		"8\u0000\u0000\u012f\u0130\u00052\u0000\u0000\u0130\u0131\u0005\r\u0000"+
		"\u0000\u0131\u0132\u0005+\u0000\u0000\u0132\u0133\u0003.\u0017\u0000\u0133"+
		"\u0134\u0005,\u0000\u0000\u0134#\u0001\u0000\u0000\u0000\u0135\u0136\u0005"+
		"\u0012\u0000\u0000\u0136\u013a\u0006\u0012\uffff\uffff\u0000\u0137\u0138"+
		"\u0005\u0013\u0000\u0000\u0138\u013a\u0006\u0012\uffff\uffff\u0000\u0139"+
		"\u0135\u0001\u0000\u0000\u0000\u0139\u0137\u0001\u0000\u0000\u0000\u013a"+
		"\u013b\u0001\u0000\u0000\u0000\u013b\u013c\u0005+\u0000\u0000\u013c\u013d"+
		"\u0003.\u0017\u0000\u013d\u013e\u0005,\u0000\u0000\u013e%\u0001\u0000"+
		"\u0000\u0000\u013f\u0140\u00058\u0000\u0000\u0140\u0142\u0006\u0013\uffff"+
		"\uffff\u0000\u0141\u0143\u0003(\u0014\u0000\u0142\u0141\u0001\u0000\u0000"+
		"\u0000\u0142\u0143\u0001\u0000\u0000\u0000\u0143\u0144\u0001\u0000\u0000"+
		"\u0000\u0144\u0145\u0005*\u0000\u0000\u0145\u0146\u0003.\u0017\u0000\u0146"+
		"\u0147\u00055\u0000\u0000\u0147\'\u0001\u0000\u0000\u0000\u0148\u0149"+
		"\u0005-\u0000\u0000\u0149\u014a\u0003.\u0017\u0000\u014a\u014b\u0005."+
		"\u0000\u0000\u014b)\u0001\u0000\u0000\u0000\u014c\u0156\u0003\u000e\u0007"+
		"\u0000\u014d\u0156\u0003\u0018\f\u0000\u014e\u0156\u0003\u001c\u000e\u0000"+
		"\u014f\u0156\u0003\u0012\t\u0000\u0150\u0156\u0003\u0016\u000b\u0000\u0151"+
		"\u0152\u0003.\u0017\u0000\u0152\u0153\u00055\u0000\u0000\u0153\u0156\u0001"+
		"\u0000\u0000\u0000\u0154\u0156\u0003&\u0013\u0000\u0155\u014c\u0001\u0000"+
		"\u0000\u0000\u0155\u014d\u0001\u0000\u0000\u0000\u0155\u014e\u0001\u0000"+
		"\u0000\u0000\u0155\u014f\u0001\u0000\u0000\u0000\u0155\u0150\u0001\u0000"+
		"\u0000\u0000\u0155\u0151\u0001\u0000\u0000\u0000\u0155\u0154\u0001\u0000"+
		"\u0000\u0000\u0156+\u0001\u0000\u0000\u0000\u0157\u0159\u0003*\u0015\u0000"+
		"\u0158\u0157\u0001\u0000\u0000\u0000\u0159\u015c\u0001\u0000\u0000\u0000"+
		"\u015a\u0158\u0001\u0000\u0000\u0000\u015a\u015b\u0001\u0000\u0000\u0000"+
		"\u015b\u015e\u0001\u0000\u0000\u0000\u015c\u015a\u0001\u0000\u0000\u0000"+
		"\u015d\u015f\u0003\f\u0006\u0000\u015e\u015d\u0001\u0000\u0000\u0000\u015e"+
		"\u015f\u0001\u0000\u0000\u0000\u015f-\u0001\u0000\u0000\u0000\u0160\u016c"+
		"\u00030\u0018\u0000\u0161\u0166\u0005\u0018\u0000\u0000\u0162\u0166\u0005"+
		"\u0019\u0000\u0000\u0163\u0166\u0005\u001a\u0000\u0000\u0164\u0166\u0005"+
		"\u001b\u0000\u0000\u0165\u0161\u0001\u0000\u0000\u0000\u0165\u0162\u0001"+
		"\u0000\u0000\u0000\u0165\u0163\u0001\u0000\u0000\u0000\u0165\u0164\u0001"+
		"\u0000\u0000\u0000\u0166\u0167\u0001\u0000\u0000\u0000\u0167\u0168\u0003"+
		"0\u0018\u0000\u0168\u0169\u0006\u0017\uffff\uffff\u0000\u0169\u016b\u0001"+
		"\u0000\u0000\u0000\u016a\u0165\u0001\u0000\u0000\u0000\u016b\u016e\u0001"+
		"\u0000\u0000\u0000\u016c\u016a\u0001\u0000\u0000\u0000\u016c\u016d\u0001"+
		"\u0000\u0000\u0000\u016d/\u0001\u0000\u0000\u0000\u016e\u016c\u0001\u0000"+
		"\u0000\u0000\u016f\u0179\u00032\u0019\u0000\u0170\u0173\u0005\u001c\u0000"+
		"\u0000\u0171\u0173\u0005\u001d\u0000\u0000\u0172\u0170\u0001\u0000\u0000"+
		"\u0000\u0172\u0171\u0001\u0000\u0000\u0000\u0173\u0174\u0001\u0000\u0000"+
		"\u0000\u0174\u0175\u00032\u0019\u0000\u0175\u0176\u0006\u0018\uffff\uffff"+
		"\u0000\u0176\u0178\u0001\u0000\u0000\u0000\u0177\u0172\u0001\u0000\u0000"+
		"\u0000\u0178\u017b\u0001\u0000\u0000\u0000\u0179\u0177\u0001\u0000\u0000"+
		"\u0000\u0179\u017a\u0001\u0000\u0000\u0000\u017a1\u0001\u0000\u0000\u0000"+
		"\u017b\u0179\u0001\u0000\u0000\u0000\u017c\u0186\u00034\u001a\u0000\u017d"+
		"\u0180\u0005\u0014\u0000\u0000\u017e\u0180\u0005\u0015\u0000\u0000\u017f"+
		"\u017d\u0001\u0000\u0000\u0000\u017f\u017e\u0001\u0000\u0000\u0000\u0180"+
		"\u0181\u0001\u0000\u0000\u0000\u0181\u0182\u00034\u001a\u0000\u0182\u0183"+
		"\u0006\u0019\uffff\uffff\u0000\u0183\u0185\u0001\u0000\u0000\u0000\u0184"+
		"\u017f\u0001\u0000\u0000\u0000\u0185\u0188\u0001\u0000\u0000\u0000\u0186"+
		"\u0184\u0001\u0000\u0000\u0000\u0186\u0187\u0001\u0000\u0000\u0000\u0187"+
		"3\u0001\u0000\u0000\u0000\u0188\u0186\u0001\u0000\u0000\u0000\u0189\u0193"+
		"\u00036\u001b\u0000\u018a\u018d\u0005\u0016\u0000\u0000\u018b\u018d\u0005"+
		"\u0017\u0000\u0000\u018c\u018a\u0001\u0000\u0000\u0000\u018c\u018b\u0001"+
		"\u0000\u0000\u0000\u018d\u018e\u0001\u0000\u0000\u0000\u018e\u018f\u0003"+
		"6\u001b\u0000\u018f\u0190\u0006\u001a\uffff\uffff\u0000\u0190\u0192\u0001"+
		"\u0000\u0000\u0000\u0191\u018c\u0001\u0000\u0000\u0000\u0192\u0195\u0001"+
		"\u0000\u0000\u0000\u0193\u0191\u0001\u0000\u0000\u0000\u0193\u0194\u0001"+
		"\u0000\u0000\u0000\u01945\u0001\u0000\u0000\u0000\u0195\u0193\u0001\u0000"+
		"\u0000\u0000\u0196\u019b\u0005 \u0000\u0000\u0197\u019b\u0005\u0015\u0000"+
		"\u0000\u0198\u019b\u0005!\u0000\u0000\u0199\u019b\u0005\"\u0000\u0000"+
		"\u019a\u0196\u0001\u0000\u0000\u0000\u019a\u0197\u0001\u0000\u0000\u0000"+
		"\u019a\u0198\u0001\u0000\u0000\u0000\u019a\u0199\u0001\u0000\u0000\u0000"+
		"\u019b\u019c\u0001\u0000\u0000\u0000\u019c\u019d\u00036\u001b\u0000\u019d"+
		"\u019e\u0006\u001b\uffff\uffff\u0000\u019e\u01a1\u0001\u0000\u0000\u0000"+
		"\u019f\u01a1\u00038\u001c\u0000\u01a0\u019a\u0001\u0000\u0000\u0000\u01a0"+
		"\u019f\u0001\u0000\u0000\u0000\u01a17\u0001\u0000\u0000\u0000\u01a2\u01a9"+
		"\u0003:\u001d\u0000\u01a3\u01a4\u0005$\u0000\u0000\u01a4\u01a5\u0003:"+
		"\u001d\u0000\u01a5\u01a6\u0006\u001c\uffff\uffff\u0000\u01a6\u01a8\u0001"+
		"\u0000\u0000\u0000\u01a7\u01a3\u0001\u0000\u0000\u0000\u01a8\u01ab\u0001"+
		"\u0000\u0000\u0000\u01a9\u01a7\u0001\u0000\u0000\u0000\u01a9\u01aa\u0001"+
		"\u0000\u0000\u0000\u01aa9\u0001\u0000\u0000\u0000\u01ab\u01a9\u0001\u0000"+
		"\u0000\u0000\u01ac\u01b4\u0003<\u001e\u0000\u01ad\u01ae\u0005+\u0000\u0000"+
		"\u01ae\u01af\u0003\n\u0005\u0000\u01af\u01b0\u0005,\u0000\u0000\u01b0"+
		"\u01b1\u0006\u001d\uffff\uffff\u0000\u01b1\u01b3\u0001\u0000\u0000\u0000"+
		"\u01b2\u01ad\u0001\u0000\u0000\u0000\u01b3\u01b6\u0001\u0000\u0000\u0000"+
		"\u01b4\u01b2\u0001\u0000\u0000\u0000\u01b4\u01b5\u0001\u0000\u0000\u0000"+
		"\u01b5\u01ba\u0001\u0000\u0000\u0000\u01b6\u01b4\u0001\u0000\u0000\u0000"+
		"\u01b7\u01b9\u0003(\u0014\u0000\u01b8\u01b7\u0001\u0000\u0000\u0000\u01b9"+
		"\u01bc\u0001\u0000\u0000\u0000\u01ba\u01b8\u0001\u0000\u0000\u0000\u01ba"+
		"\u01bb\u0001\u0000\u0000\u0000\u01bb;\u0001\u0000\u0000\u0000\u01bc\u01ba"+
		"\u0001\u0000\u0000\u0000\u01bd\u01ca\u0003@ \u0000\u01be\u01ca\u00058"+
		"\u0000\u0000\u01bf\u01ca\u0003>\u001f\u0000\u01c0\u01ca\u0003$\u0012\u0000"+
		"\u01c1\u01ca\u0003\"\u0011\u0000\u01c2\u01ca\u0003 \u0010\u0000\u01c3"+
		"\u01ca\u0003\u0014\n\u0000\u01c4\u01c6\u0005+\u0000\u0000\u01c5\u01c7"+
		"\u0003.\u0017\u0000\u01c6\u01c5\u0001\u0000\u0000\u0000\u01c6\u01c7\u0001"+
		"\u0000\u0000\u0000\u01c7\u01c8\u0001\u0000\u0000\u0000\u01c8\u01ca\u0005"+
		",\u0000\u0000\u01c9\u01bd\u0001\u0000\u0000\u0000\u01c9\u01be\u0001\u0000"+
		"\u0000\u0000\u01c9\u01bf\u0001\u0000\u0000\u0000\u01c9\u01c0\u0001\u0000"+
		"\u0000\u0000\u01c9\u01c1\u0001\u0000\u0000\u0000\u01c9\u01c2\u0001\u0000"+
		"\u0000\u0000\u01c9\u01c3\u0001\u0000\u0000\u0000\u01c9\u01c4\u0001\u0000"+
		"\u0000\u0000\u01ca=\u0001\u0000\u0000\u0000\u01cb\u01cc\u0005)\u0000\u0000"+
		"\u01cc\u01cd\u0006\u001f\uffff\uffff\u0000\u01cd\u01ce\u0003\u0004\u0002"+
		"\u0000\u01ce\u01cf\u0005/\u0000\u0000\u01cf\u01d0\u0003,\u0016\u0000\u01d0"+
		"\u01d1\u00050\u0000\u0000\u01d1\u01d2\u0003\n\u0005\u0000\u01d2?\u0001"+
		"\u0000\u0000\u0000\u01d3\u01da\u0003D\"\u0000\u01d4\u01da\u00059\u0000"+
		"\u0000\u01d5\u01da\u00056\u0000\u0000\u01d6\u01da\u00057\u0000\u0000\u01d7"+
		"\u01da\u0003B!\u0000\u01d8\u01da\u0003F#\u0000\u01d9\u01d3\u0001\u0000"+
		"\u0000\u0000\u01d9\u01d4\u0001\u0000\u0000\u0000\u01d9\u01d5\u0001\u0000"+
		"\u0000\u0000\u01d9\u01d6\u0001\u0000\u0000\u0000\u01d9\u01d7\u0001\u0000"+
		"\u0000\u0000\u01d9\u01d8\u0001\u0000\u0000\u0000\u01daA\u0001\u0000\u0000"+
		"\u0000\u01db\u01dc\u0005-\u0000\u0000\u01dc\u01dd\u0003\n\u0005\u0000"+
		"\u01dd\u01de\u0005.\u0000\u0000\u01deC\u0001\u0000\u0000\u0000\u01df\u01e0"+
		"\u0007\u0001\u0000\u0000\u01e0E\u0001\u0000\u0000\u0000\u01e1\u01e2\u0005"+
		"\u000b\u0000\u0000\u01e2\u01e3\u0005+\u0000\u0000\u01e3\u01e4\u00054\u0000"+
		"\u0000\u01e4\u01e5\u00058\u0000\u0000\u01e5\u01e6\u0005,\u0000\u0000\u01e6"+
		"G\u0001\u0000\u0000\u0000-JL^lqs\u0084\u0096\u0099\u009e\u00ad\u00b3\u00bc"+
		"\u00c0\u00c4\u00c9\u00ed\u00f4\u00f7\u00f9\u00fd\u0113\u0119\u0128\u0139"+
		"\u0142\u0155\u015a\u015e\u0165\u016c\u0172\u0179\u017f\u0186\u018c\u0193"+
		"\u019a\u01a0\u01a9\u01b4\u01ba\u01c6\u01c9\u01d9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}