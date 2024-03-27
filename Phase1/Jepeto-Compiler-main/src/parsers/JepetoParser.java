// Generated from E:/Uni/Term 6/6-Compiler/Project/Phase 2/Phase 2/src/main/grammar\Jepeto.g4 by ANTLR 4.9.1
package parsers;

    import main.ast.nodes.*;
    import main.ast.nodes.declaration.*;
    import main.ast.nodes.expression.*;
    import main.ast.nodes.expression.operators.*;
    import main.ast.nodes.expression.values.*;
    import main.ast.nodes.expression.values.primitive.*;
    import main.ast.nodes.statement.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JepetoParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		FUNC=1, MAIN=2, SIZE=3, PRINT=4, RETURN=5, VOID=6, IF=7, ELSE=8, PLUS=9, 
		MINUS=10, MULT=11, DIVIDE=12, EQUAL=13, NOT_EQUAL=14, GREATER_THAN=15, 
		LESS_THAN=16, AND=17, OR=18, NOT=19, APPEND=20, TRUE=21, FALSE=22, ARROW=23, 
		ASSIGN=24, LPAR=25, RPAR=26, LBRACK=27, RBRACK=28, LBRACE=29, RBRACE=30, 
		COMMA=31, DOT=32, COLON=33, SEMICOLLON=34, INT_VALUE=35, IDENTIFIER=36, 
		STRING_VALUE=37, COMMENT=38, WS=39;
	public static final int
		RULE_jepeto = 0, RULE_program = 1, RULE_functionDeclaration = 2, RULE_functionArgumentsDeclaration = 3, 
		RULE_body = 4, RULE_main = 5, RULE_functionCall = 6, RULE_functionArguments = 7, 
		RULE_splitedExpressionsWithComma = 8, RULE_splitedExpressionsWithCommaAndKey = 9, 
		RULE_functionCallStatement = 10, RULE_returnStatement = 11, RULE_ifStatement = 12, 
		RULE_ifStatementWithReturn = 13, RULE_printStatement = 14, RULE_statement = 15, 
		RULE_singleStatement = 16, RULE_block = 17, RULE_conditionBody = 18, RULE_expression = 19, 
		RULE_andExpression = 20, RULE_equalityExpression = 21, RULE_relationalExpression = 22, 
		RULE_additiveExpression = 23, RULE_multiplicativeExpression = 24, RULE_preUnaryExpression = 25, 
		RULE_appendExpression = 26, RULE_accessExpression = 27, RULE_otherExpression = 28, 
		RULE_anonymousFunction = 29, RULE_sizeExpression = 30, RULE_values = 31, 
		RULE_listValue = 32, RULE_boolValue = 33, RULE_voidValue = 34, RULE_identifier = 35;
	private static String[] makeRuleNames() {
		return new String[] {
			"jepeto", "program", "functionDeclaration", "functionArgumentsDeclaration", 
			"body", "main", "functionCall", "functionArguments", "splitedExpressionsWithComma", 
			"splitedExpressionsWithCommaAndKey", "functionCallStatement", "returnStatement", 
			"ifStatement", "ifStatementWithReturn", "printStatement", "statement", 
			"singleStatement", "block", "conditionBody", "expression", "andExpression", 
			"equalityExpression", "relationalExpression", "additiveExpression", "multiplicativeExpression", 
			"preUnaryExpression", "appendExpression", "accessExpression", "otherExpression", 
			"anonymousFunction", "sizeExpression", "values", "listValue", "boolValue", 
			"voidValue", "identifier"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'func'", "'main'", "'size'", "'print'", "'return'", "'void'", 
			"'if'", "'else'", "'+'", "'-'", "'*'", "'/'", "'is'", "'not'", "'>'", 
			"'<'", "'and'", "'or'", "'~'", "'::'", "'true'", "'false'", "'->'", "'='", 
			"'('", "')'", "'['", "']'", "'{'", "'}'", "','", "'.'", "':'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "FUNC", "MAIN", "SIZE", "PRINT", "RETURN", "VOID", "IF", "ELSE", 
			"PLUS", "MINUS", "MULT", "DIVIDE", "EQUAL", "NOT_EQUAL", "GREATER_THAN", 
			"LESS_THAN", "AND", "OR", "NOT", "APPEND", "TRUE", "FALSE", "ARROW", 
			"ASSIGN", "LPAR", "RPAR", "LBRACK", "RBRACK", "LBRACE", "RBRACE", "COMMA", 
			"DOT", "COLON", "SEMICOLLON", "INT_VALUE", "IDENTIFIER", "STRING_VALUE", 
			"COMMENT", "WS"
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
	public String getGrammarFileName() { return "Jepeto.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JepetoParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class JepetoContext extends ParserRuleContext {
		public Program jepetoProgram;
		public ProgramContext p;
		public TerminalNode EOF() { return getToken(JepetoParser.EOF, 0); }
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public JepetoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jepeto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterJepeto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitJepeto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitJepeto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JepetoContext jepeto() throws RecognitionException {
		JepetoContext _localctx = new JepetoContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_jepeto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			((JepetoContext)_localctx).p = program();
			 ((JepetoContext)_localctx).jepetoProgram =  ((JepetoContext)_localctx).p.programRet; 
			setState(74);
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

	public static class ProgramContext extends ParserRuleContext {
		public Program programRet;
		public FunctionDeclarationContext fd;
		public MainContext m;
		public FunctionDeclarationContext fd2;
		public MainContext main() {
			return getRuleContext(MainContext.class,0);
		}
		public List<FunctionDeclarationContext> functionDeclaration() {
			return getRuleContexts(FunctionDeclarationContext.class);
		}
		public FunctionDeclarationContext functionDeclaration(int i) {
			return getRuleContext(FunctionDeclarationContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitProgram(this);
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

			        ((ProgramContext)_localctx).programRet =  new Program();
			        _localctx.programRet.setLine(1);
			    
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUNC) {
				{
				{
				setState(77);
				((ProgramContext)_localctx).fd = functionDeclaration();
				 _localctx.programRet.addFunction(((ProgramContext)_localctx).fd.functionDecRet); 
				}
				}
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(85);
			((ProgramContext)_localctx).m = main();
			 _localctx.programRet.setMain(((ProgramContext)_localctx).m.mainRet); 
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUNC) {
				{
				{
				setState(87);
				((ProgramContext)_localctx).fd2 = functionDeclaration();
				 _localctx.programRet.addFunction(((ProgramContext)_localctx).fd2.functionDecRet); 
				}
				}
				setState(94);
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

	public static class FunctionDeclarationContext extends ParserRuleContext {
		public FunctionDeclaration functionDecRet;
		public Token f;
		public Token name;
		public FunctionArgumentsDeclarationContext args;
		public BodyContext b;
		public TerminalNode COLON() { return getToken(JepetoParser.COLON, 0); }
		public TerminalNode FUNC() { return getToken(JepetoParser.FUNC, 0); }
		public TerminalNode IDENTIFIER() { return getToken(JepetoParser.IDENTIFIER, 0); }
		public FunctionArgumentsDeclarationContext functionArgumentsDeclaration() {
			return getRuleContext(FunctionArgumentsDeclarationContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitFunctionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_functionDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			((FunctionDeclarationContext)_localctx).f = match(FUNC);
			setState(96);
			((FunctionDeclarationContext)_localctx).name = match(IDENTIFIER);

			        ((FunctionDeclarationContext)_localctx).functionDecRet =  new FunctionDeclaration();
			        Identifier idRet = new Identifier((((FunctionDeclarationContext)_localctx).name!=null?((FunctionDeclarationContext)_localctx).name.getText():null));
			        idRet.setLine(((FunctionDeclarationContext)_localctx).f.getLine());
			        _localctx.functionDecRet.setFunctionName(idRet);
			        _localctx.functionDecRet.setLine(((FunctionDeclarationContext)_localctx).f.getLine());
			    
			setState(98);
			((FunctionDeclarationContext)_localctx).args = functionArgumentsDeclaration();
			 _localctx.functionDecRet.setArgs(((FunctionDeclarationContext)_localctx).args.argsRet); 
			setState(100);
			match(COLON);
			setState(101);
			((FunctionDeclarationContext)_localctx).b = body();
			 _localctx.functionDecRet.setBody(((FunctionDeclarationContext)_localctx).b.bodyRet); 
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

	public static class FunctionArgumentsDeclarationContext extends ParserRuleContext {
		public ArrayList <Identifier> argsRet;
		public int line;
		public Token l;
		public Token id;
		public Token id2;
		public TerminalNode RPAR() { return getToken(JepetoParser.RPAR, 0); }
		public TerminalNode LPAR() { return getToken(JepetoParser.LPAR, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(JepetoParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(JepetoParser.IDENTIFIER, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(JepetoParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JepetoParser.COMMA, i);
		}
		public FunctionArgumentsDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionArgumentsDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterFunctionArgumentsDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitFunctionArgumentsDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitFunctionArgumentsDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionArgumentsDeclarationContext functionArgumentsDeclaration() throws RecognitionException {
		FunctionArgumentsDeclarationContext _localctx = new FunctionArgumentsDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_functionArgumentsDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((FunctionArgumentsDeclarationContext)_localctx).argsRet =  new ArrayList <>(); 
			setState(105);
			((FunctionArgumentsDeclarationContext)_localctx).l = match(LPAR);
			 ((FunctionArgumentsDeclarationContext)_localctx).line =  ((FunctionArgumentsDeclarationContext)_localctx).l.getLine(); 
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(107);
				((FunctionArgumentsDeclarationContext)_localctx).id = match(IDENTIFIER);

				        Identifier idRet = new Identifier((((FunctionArgumentsDeclarationContext)_localctx).id!=null?((FunctionArgumentsDeclarationContext)_localctx).id.getText():null));
				        _localctx.argsRet.add(idRet);
				        idRet.setLine(((FunctionArgumentsDeclarationContext)_localctx).id.getLine());
				    
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(109);
					match(COMMA);
					setState(110);
					((FunctionArgumentsDeclarationContext)_localctx).id2 = match(IDENTIFIER);

					        Identifier idRet2 = new Identifier((((FunctionArgumentsDeclarationContext)_localctx).id2!=null?((FunctionArgumentsDeclarationContext)_localctx).id2.getText():null));
					        _localctx.argsRet.add(idRet2);
					        idRet2.setLine(((FunctionArgumentsDeclarationContext)_localctx).id2.getLine());
					    
					}
					}
					setState(116);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(119);
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

	public static class BodyContext extends ParserRuleContext {
		public Statement bodyRet;
		public SingleStatementContext s1;
		public BlockContext s2;
		public SingleStatementContext singleStatement() {
			return getRuleContext(SingleStatementContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_body);
		try {
			setState(127);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RETURN:
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(121);
				((BodyContext)_localctx).s1 = singleStatement();
				 ((BodyContext)_localctx).bodyRet =  ((BodyContext)_localctx).s1.singleSRet; 
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
				((BodyContext)_localctx).s2 = block();
				 ((BodyContext)_localctx).bodyRet =  ((BodyContext)_localctx).s2.blockRet; 
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

	public static class MainContext extends ParserRuleContext {
		public MainDeclaration mainRet;
		public Token m;
		public FunctionCallStatementContext f;
		public PrintStatementContext p;
		public TerminalNode COLON() { return getToken(JepetoParser.COLON, 0); }
		public TerminalNode MAIN() { return getToken(JepetoParser.MAIN, 0); }
		public FunctionCallStatementContext functionCallStatement() {
			return getRuleContext(FunctionCallStatementContext.class,0);
		}
		public PrintStatementContext printStatement() {
			return getRuleContext(PrintStatementContext.class,0);
		}
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterMain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitMain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitMain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_main);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			((MainContext)_localctx).m = match(MAIN);

			        ((MainContext)_localctx).mainRet =  new MainDeclaration();
			        _localctx.mainRet.setLine(((MainContext)_localctx).m.getLine());
			    
			setState(131);
			match(COLON);
			setState(138);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(132);
				((MainContext)_localctx).f = functionCallStatement();
				 _localctx.mainRet.setBody(((MainContext)_localctx).f.functionCallStmtRet); 
				}
				break;
			case PRINT:
				{
				setState(135);
				((MainContext)_localctx).p = printStatement();
				 _localctx.mainRet.setBody(((MainContext)_localctx).p.printStmtRet); 
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

	public static class FunctionCallContext extends ParserRuleContext {
		public FunctionCall funcCallRet;
		public int line;
		public IdentifierContext id;
		public Token l;
		public FunctionArgumentsContext f1;
		public Token l2;
		public FunctionArgumentsContext f2;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<TerminalNode> RPAR() { return getTokens(JepetoParser.RPAR); }
		public TerminalNode RPAR(int i) {
			return getToken(JepetoParser.RPAR, i);
		}
		public List<TerminalNode> LPAR() { return getTokens(JepetoParser.LPAR); }
		public TerminalNode LPAR(int i) {
			return getToken(JepetoParser.LPAR, i);
		}
		public List<FunctionArgumentsContext> functionArguments() {
			return getRuleContexts(FunctionArgumentsContext.class);
		}
		public FunctionArgumentsContext functionArguments(int i) {
			return getRuleContext(FunctionArgumentsContext.class,i);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_functionCall);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			((FunctionCallContext)_localctx).id = identifier();
			Expression instance = ((FunctionCallContext)_localctx).id.idRet;
			setState(149);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(142);
					((FunctionCallContext)_localctx).l = match(LPAR);
					setState(143);
					((FunctionCallContext)_localctx).f1 = functionArguments();

					         ((FunctionCallContext)_localctx).funcCallRet =  new FunctionCall(instance, ((FunctionCallContext)_localctx).f1.argsRet, ((FunctionCallContext)_localctx).f1.argsWithKeyRet);
					         instance = _localctx.funcCallRet;
					         ((FunctionCallContext)_localctx).line =  ((FunctionCallContext)_localctx).l.getLine();
					         _localctx.funcCallRet.setLine(_localctx.line);
					    
					setState(145);
					match(RPAR);
					}
					} 
				}
				setState(151);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			{
			setState(152);
			((FunctionCallContext)_localctx).l2 = match(LPAR);
			setState(153);
			((FunctionCallContext)_localctx).f2 = functionArguments();

			        ((FunctionCallContext)_localctx).line =  ((FunctionCallContext)_localctx).l2.getLine();
			        ((FunctionCallContext)_localctx).funcCallRet =  new FunctionCall(instance, ((FunctionCallContext)_localctx).f2.argsRet, ((FunctionCallContext)_localctx).f2.argsWithKeyRet);
			        _localctx.funcCallRet.setLine(_localctx.line);
			    
			setState(155);
			match(RPAR);
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

	public static class FunctionArgumentsContext extends ParserRuleContext {
		public ArrayList <Expression> argsRet;
		public Map<Identifier, Expression> argsWithKeyRet;
		public SplitedExpressionsWithCommaContext sc;
		public SplitedExpressionsWithCommaAndKeyContext sk;
		public SplitedExpressionsWithCommaContext splitedExpressionsWithComma() {
			return getRuleContext(SplitedExpressionsWithCommaContext.class,0);
		}
		public SplitedExpressionsWithCommaAndKeyContext splitedExpressionsWithCommaAndKey() {
			return getRuleContext(SplitedExpressionsWithCommaAndKeyContext.class,0);
		}
		public FunctionArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionArguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterFunctionArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitFunctionArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitFunctionArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionArgumentsContext functionArguments() throws RecognitionException {
		FunctionArgumentsContext _localctx = new FunctionArgumentsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_functionArguments);
		try {
			setState(164);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{

				        ((FunctionArgumentsContext)_localctx).argsRet =  new ArrayList <>();
				        ((FunctionArgumentsContext)_localctx).argsWithKeyRet =  new LinkedHashMap<>();
				    
				setState(158);
				((FunctionArgumentsContext)_localctx).sc = splitedExpressionsWithComma();

				        ((FunctionArgumentsContext)_localctx).argsRet =  ((FunctionArgumentsContext)_localctx).sc.spltExpWthCommaRet;
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(161);
				((FunctionArgumentsContext)_localctx).sk = splitedExpressionsWithCommaAndKey();

				        ((FunctionArgumentsContext)_localctx).argsWithKeyRet =  ((FunctionArgumentsContext)_localctx).sk.spltExpWthKeyRet;
				    
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

	public static class SplitedExpressionsWithCommaContext extends ParserRuleContext {
		public ArrayList <Expression> spltExpWthCommaRet;
		public ExpressionContext exp;
		public ExpressionContext exp2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(JepetoParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JepetoParser.COMMA, i);
		}
		public SplitedExpressionsWithCommaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_splitedExpressionsWithComma; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterSplitedExpressionsWithComma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitSplitedExpressionsWithComma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitSplitedExpressionsWithComma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SplitedExpressionsWithCommaContext splitedExpressionsWithComma() throws RecognitionException {
		SplitedExpressionsWithCommaContext _localctx = new SplitedExpressionsWithCommaContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_splitedExpressionsWithComma);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((SplitedExpressionsWithCommaContext)_localctx).spltExpWthCommaRet =  new ArrayList <>(); 
			setState(178);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << LBRACK) | (1L << INT_VALUE) | (1L << IDENTIFIER) | (1L << STRING_VALUE))) != 0)) {
				{
				setState(167);
				((SplitedExpressionsWithCommaContext)_localctx).exp = expression();
				 _localctx.spltExpWthCommaRet.add(((SplitedExpressionsWithCommaContext)_localctx).exp.exprRet); 
				setState(175);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(169);
					match(COMMA);
					setState(170);
					((SplitedExpressionsWithCommaContext)_localctx).exp2 = expression();
					 _localctx.spltExpWthCommaRet.add(((SplitedExpressionsWithCommaContext)_localctx).exp2.exprRet); 
					}
					}
					setState(177);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class SplitedExpressionsWithCommaAndKeyContext extends ParserRuleContext {
		public Map <Identifier, Expression> spltExpWthKeyRet;
		public IdentifierContext id;
		public ExpressionContext exp;
		public IdentifierContext id2;
		public ExpressionContext exp2;
		public List<TerminalNode> ASSIGN() { return getTokens(JepetoParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(JepetoParser.ASSIGN, i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(JepetoParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JepetoParser.COMMA, i);
		}
		public SplitedExpressionsWithCommaAndKeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_splitedExpressionsWithCommaAndKey; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterSplitedExpressionsWithCommaAndKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitSplitedExpressionsWithCommaAndKey(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitSplitedExpressionsWithCommaAndKey(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SplitedExpressionsWithCommaAndKeyContext splitedExpressionsWithCommaAndKey() throws RecognitionException {
		SplitedExpressionsWithCommaAndKeyContext _localctx = new SplitedExpressionsWithCommaAndKeyContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_splitedExpressionsWithCommaAndKey);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((SplitedExpressionsWithCommaAndKeyContext)_localctx).spltExpWthKeyRet =  new LinkedHashMap<>(); 
			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(181);
				((SplitedExpressionsWithCommaAndKeyContext)_localctx).id = identifier();
				setState(182);
				match(ASSIGN);
				setState(183);
				((SplitedExpressionsWithCommaAndKeyContext)_localctx).exp = expression();
				 _localctx.spltExpWthKeyRet.put(((SplitedExpressionsWithCommaAndKeyContext)_localctx).id.idRet,((SplitedExpressionsWithCommaAndKeyContext)_localctx).exp.exprRet); 
				setState(193);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(185);
					match(COMMA);
					setState(186);
					((SplitedExpressionsWithCommaAndKeyContext)_localctx).id2 = identifier();
					setState(187);
					match(ASSIGN);
					setState(188);
					((SplitedExpressionsWithCommaAndKeyContext)_localctx).exp2 = expression();
					 _localctx.spltExpWthKeyRet.put(((SplitedExpressionsWithCommaAndKeyContext)_localctx).id2.idRet,((SplitedExpressionsWithCommaAndKeyContext)_localctx).exp2.exprRet); 
					}
					}
					setState(195);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class FunctionCallStatementContext extends ParserRuleContext {
		public Statement functionCallStmtRet;
		public FunctionCallContext fc;
		public TerminalNode SEMICOLLON() { return getToken(JepetoParser.SEMICOLLON, 0); }
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public FunctionCallStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCallStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterFunctionCallStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitFunctionCallStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitFunctionCallStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallStatementContext functionCallStatement() throws RecognitionException {
		FunctionCallStatementContext _localctx = new FunctionCallStatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_functionCallStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			((FunctionCallStatementContext)_localctx).fc = functionCall();

			        ((FunctionCallStatementContext)_localctx).functionCallStmtRet =  new FunctionCallStmt(((FunctionCallStatementContext)_localctx).fc.funcCallRet);
			        _localctx.functionCallStmtRet.setLine(((FunctionCallStatementContext)_localctx).fc.line);
			    
			setState(200);
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

	public static class ReturnStatementContext extends ParserRuleContext {
		public ReturnStmt returnStmtRet;
		public Token r;
		public ExpressionContext exp;
		public VoidValueContext vd;
		public TerminalNode SEMICOLLON() { return getToken(JepetoParser.SEMICOLLON, 0); }
		public TerminalNode RETURN() { return getToken(JepetoParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VoidValueContext voidValue() {
			return getRuleContext(VoidValueContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			((ReturnStatementContext)_localctx).r = match(RETURN);
			setState(209);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
			case NOT:
			case TRUE:
			case FALSE:
			case LPAR:
			case LBRACK:
			case INT_VALUE:
			case IDENTIFIER:
			case STRING_VALUE:
				{
				setState(203);
				((ReturnStatementContext)_localctx).exp = expression();

				        ((ReturnStatementContext)_localctx).returnStmtRet =  new ReturnStmt(((ReturnStatementContext)_localctx).exp.exprRet);
				        _localctx.returnStmtRet.setLine(((ReturnStatementContext)_localctx).r.getLine());
				    
				}
				break;
			case VOID:
				{
				setState(206);
				((ReturnStatementContext)_localctx).vd = voidValue();

				      ((ReturnStatementContext)_localctx).returnStmtRet =  new ReturnStmt(((ReturnStatementContext)_localctx).vd.voidValueRet);
				      _localctx.returnStmtRet.setLine(((ReturnStatementContext)_localctx).r.getLine());
				    
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(211);
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

	public static class IfStatementContext extends ParserRuleContext {
		public ConditionalStmt ifStmtRet;
		public Token i;
		public ExpressionContext exp;
		public ConditionBodyContext b;
		public ConditionBodyContext elb;
		public List<TerminalNode> COLON() { return getTokens(JepetoParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(JepetoParser.COLON, i);
		}
		public TerminalNode IF() { return getToken(JepetoParser.IF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<ConditionBodyContext> conditionBody() {
			return getRuleContexts(ConditionBodyContext.class);
		}
		public ConditionBodyContext conditionBody(int i) {
			return getRuleContext(ConditionBodyContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(JepetoParser.ELSE, 0); }
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			((IfStatementContext)_localctx).i = match(IF);
			setState(214);
			((IfStatementContext)_localctx).exp = expression();
			setState(215);
			match(COLON);
			setState(216);
			((IfStatementContext)_localctx).b = conditionBody();

			        ((IfStatementContext)_localctx).ifStmtRet =  new ConditionalStmt(((IfStatementContext)_localctx).exp.exprRet, ((IfStatementContext)_localctx).b.condBodyRet);
			        _localctx.ifStmtRet.setLine(((IfStatementContext)_localctx).i.getLine());
			    
			setState(223);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(218);
				match(ELSE);
				setState(219);
				match(COLON);
				setState(220);
				((IfStatementContext)_localctx).elb = conditionBody();
				 _localctx.ifStmtRet.setElseBody(((IfStatementContext)_localctx).elb.condBodyRet); 
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

	public static class IfStatementWithReturnContext extends ParserRuleContext {
		public ConditionalStmt ifStmtWthRRet;
		public Token i;
		public ExpressionContext exp;
		public BodyContext b;
		public BodyContext elb;
		public List<TerminalNode> COLON() { return getTokens(JepetoParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(JepetoParser.COLON, i);
		}
		public TerminalNode ELSE() { return getToken(JepetoParser.ELSE, 0); }
		public TerminalNode IF() { return getToken(JepetoParser.IF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<BodyContext> body() {
			return getRuleContexts(BodyContext.class);
		}
		public BodyContext body(int i) {
			return getRuleContext(BodyContext.class,i);
		}
		public IfStatementWithReturnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatementWithReturn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterIfStatementWithReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitIfStatementWithReturn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitIfStatementWithReturn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementWithReturnContext ifStatementWithReturn() throws RecognitionException {
		IfStatementWithReturnContext _localctx = new IfStatementWithReturnContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_ifStatementWithReturn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			((IfStatementWithReturnContext)_localctx).i = match(IF);
			setState(226);
			((IfStatementWithReturnContext)_localctx).exp = expression();
			setState(227);
			match(COLON);
			setState(228);
			((IfStatementWithReturnContext)_localctx).b = body();

			        ((IfStatementWithReturnContext)_localctx).ifStmtWthRRet =  new ConditionalStmt(((IfStatementWithReturnContext)_localctx).exp.exprRet, ((IfStatementWithReturnContext)_localctx).b.bodyRet);
			        _localctx.ifStmtWthRRet.setLine(((IfStatementWithReturnContext)_localctx).i.getLine());
			    
			setState(230);
			match(ELSE);
			setState(231);
			match(COLON);
			setState(232);
			((IfStatementWithReturnContext)_localctx).elb = body();
			 _localctx.ifStmtWthRRet.setElseBody(((IfStatementWithReturnContext)_localctx).elb.bodyRet); 
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

	public static class PrintStatementContext extends ParserRuleContext {
		public PrintStmt printStmtRet;
		public Token p;
		public ExpressionContext exp;
		public TerminalNode LPAR() { return getToken(JepetoParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(JepetoParser.RPAR, 0); }
		public TerminalNode SEMICOLLON() { return getToken(JepetoParser.SEMICOLLON, 0); }
		public TerminalNode PRINT() { return getToken(JepetoParser.PRINT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrintStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterPrintStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitPrintStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitPrintStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintStatementContext printStatement() throws RecognitionException {
		PrintStatementContext _localctx = new PrintStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_printStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			((PrintStatementContext)_localctx).p = match(PRINT);
			setState(236);
			match(LPAR);
			setState(237);
			((PrintStatementContext)_localctx).exp = expression();

			        ((PrintStatementContext)_localctx).printStmtRet =  new PrintStmt(((PrintStatementContext)_localctx).exp.exprRet);
			        _localctx.printStmtRet.setLine(((PrintStatementContext)_localctx).p.getLine());
			    
			setState(239);
			match(RPAR);
			setState(240);
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

	public static class StatementContext extends ParserRuleContext {
		public Statement sRet;
		public IfStatementContext s1;
		public PrintStatementContext s2;
		public FunctionCallStatementContext s3;
		public ReturnStatementContext s4;
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public PrintStatementContext printStatement() {
			return getRuleContext(PrintStatementContext.class,0);
		}
		public FunctionCallStatementContext functionCallStatement() {
			return getRuleContext(FunctionCallStatementContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_statement);
		try {
			setState(254);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(242);
				((StatementContext)_localctx).s1 = ifStatement();
				 ((StatementContext)_localctx).sRet =  ((StatementContext)_localctx).s1.ifStmtRet; 
				}
				break;
			case PRINT:
				enterOuterAlt(_localctx, 2);
				{
				setState(245);
				((StatementContext)_localctx).s2 = printStatement();
				 ((StatementContext)_localctx).sRet =  ((StatementContext)_localctx).s2.printStmtRet; 
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(248);
				((StatementContext)_localctx).s3 = functionCallStatement();
				 ((StatementContext)_localctx).sRet =  ((StatementContext)_localctx).s3.functionCallStmtRet; 
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 4);
				{
				setState(251);
				((StatementContext)_localctx).s4 = returnStatement();
				 ((StatementContext)_localctx).sRet =  ((StatementContext)_localctx).s4.returnStmtRet; 
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

	public static class SingleStatementContext extends ParserRuleContext {
		public Statement singleSRet;
		public ReturnStatementContext s1;
		public IfStatementWithReturnContext s2;
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public IfStatementWithReturnContext ifStatementWithReturn() {
			return getRuleContext(IfStatementWithReturnContext.class,0);
		}
		public SingleStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterSingleStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitSingleStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitSingleStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleStatementContext singleStatement() throws RecognitionException {
		SingleStatementContext _localctx = new SingleStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_singleStatement);
		try {
			setState(262);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RETURN:
				enterOuterAlt(_localctx, 1);
				{
				setState(256);
				((SingleStatementContext)_localctx).s1 = returnStatement();
				 ((SingleStatementContext)_localctx).singleSRet =  ((SingleStatementContext)_localctx).s1.returnStmtRet; 
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(259);
				((SingleStatementContext)_localctx).s2 = ifStatementWithReturn();
				 ((SingleStatementContext)_localctx).singleSRet =  ((SingleStatementContext)_localctx).s2.ifStmtWthRRet; 
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

	public static class BlockContext extends ParserRuleContext {
		public BlockStmt blockRet;
		public Token l;
		public StatementContext s;
		public ReturnStatementContext rs;
		public IfStatementWithReturnContext is;
		public StatementContext s2;
		public TerminalNode RBRACE() { return getToken(JepetoParser.RBRACE, 0); }
		public TerminalNode LBRACE() { return getToken(JepetoParser.LBRACE, 0); }
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public IfStatementWithReturnContext ifStatementWithReturn() {
			return getRuleContext(IfStatementWithReturnContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_block);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			((BlockContext)_localctx).l = match(LBRACE);

			        ((BlockContext)_localctx).blockRet =  new BlockStmt();
			        _localctx.blockRet.setLine(((BlockContext)_localctx).l.getLine());
			    
			{
			setState(271);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(266);
					((BlockContext)_localctx).s = statement();
					 _localctx.blockRet.addStatement(((BlockContext)_localctx).s.sRet); 
					}
					} 
				}
				setState(273);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			setState(280);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RETURN:
				{
				setState(274);
				((BlockContext)_localctx).rs = returnStatement();
				 _localctx.blockRet.addStatement(((BlockContext)_localctx).rs.returnStmtRet); 
				}
				break;
			case IF:
				{
				setState(277);
				((BlockContext)_localctx).is = ifStatementWithReturn();
				 _localctx.blockRet.addStatement(((BlockContext)_localctx).is.ifStmtWthRRet); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(287);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PRINT) | (1L << RETURN) | (1L << IF) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(282);
				((BlockContext)_localctx).s2 = statement();
				 _localctx.blockRet.addStatement(((BlockContext)_localctx).s2.sRet); 
				}
				}
				setState(289);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(290);
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

	public static class ConditionBodyContext extends ParserRuleContext {
		public Statement condBodyRet;
		public Token l;
		public StatementContext s;
		public StatementContext s2;
		public TerminalNode RBRACE() { return getToken(JepetoParser.RBRACE, 0); }
		public TerminalNode LBRACE() { return getToken(JepetoParser.LBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ConditionBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterConditionBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitConditionBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitConditionBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionBodyContext conditionBody() throws RecognitionException {
		ConditionBodyContext _localctx = new ConditionBodyContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_conditionBody);
		int _la;
		try {
			setState(306);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(292);
				((ConditionBodyContext)_localctx).l = match(LBRACE);

				      BlockStmt bc = new BlockStmt();
				      ((ConditionBodyContext)_localctx).condBodyRet =  bc;
				      _localctx.condBodyRet.setLine(((ConditionBodyContext)_localctx).l.getLine());
				    
				setState(299);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PRINT) | (1L << RETURN) | (1L << IF) | (1L << IDENTIFIER))) != 0)) {
					{
					{
					setState(294);
					((ConditionBodyContext)_localctx).s = statement();

					        bc.addStatement(((ConditionBodyContext)_localctx).s.sRet);
					        ((ConditionBodyContext)_localctx).condBodyRet =  bc;
					        _localctx.condBodyRet.setLine(((ConditionBodyContext)_localctx).l.getLine());
					    
					}
					}
					setState(301);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(302);
				match(RBRACE);
				}
				break;
			case PRINT:
			case RETURN:
			case IF:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(303);
				((ConditionBodyContext)_localctx).s2 = statement();

				        ((ConditionBodyContext)_localctx).condBodyRet =  ((ConditionBodyContext)_localctx).s2.sRet;
				    
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

	public static class ExpressionContext extends ParserRuleContext {
		public Expression exprRet;
		public AndExpressionContext ae1;
		public Token o;
		public AndExpressionContext ae2;
		public List<AndExpressionContext> andExpression() {
			return getRuleContexts(AndExpressionContext.class);
		}
		public AndExpressionContext andExpression(int i) {
			return getRuleContext(AndExpressionContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(JepetoParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(JepetoParser.OR, i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			((ExpressionContext)_localctx).ae1 = andExpression();
			 ((ExpressionContext)_localctx).exprRet =  ((ExpressionContext)_localctx).ae1.andExprRet; 
			setState(316);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(310);
				((ExpressionContext)_localctx).o = match(OR);
				setState(311);
				((ExpressionContext)_localctx).ae2 = andExpression();

				         BinaryOperator op = BinaryOperator.or;
				         ((ExpressionContext)_localctx).exprRet =  new BinaryExpression(_localctx.exprRet, ((ExpressionContext)_localctx).ae2.andExprRet, op);
				         _localctx.exprRet.setLine(((ExpressionContext)_localctx).o.getLine());
				    
				}
				}
				setState(318);
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

	public static class AndExpressionContext extends ParserRuleContext {
		public Expression andExprRet;
		public EqualityExpressionContext e1;
		public Token a;
		public EqualityExpressionContext e2;
		public List<EqualityExpressionContext> equalityExpression() {
			return getRuleContexts(EqualityExpressionContext.class);
		}
		public EqualityExpressionContext equalityExpression(int i) {
			return getRuleContext(EqualityExpressionContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(JepetoParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(JepetoParser.AND, i);
		}
		public AndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitAndExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitAndExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndExpressionContext andExpression() throws RecognitionException {
		AndExpressionContext _localctx = new AndExpressionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_andExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			((AndExpressionContext)_localctx).e1 = equalityExpression();
			 ((AndExpressionContext)_localctx).andExprRet =  ((AndExpressionContext)_localctx).e1.eqExprRet; 
			setState(327);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(321);
				((AndExpressionContext)_localctx).a = match(AND);
				setState(322);
				((AndExpressionContext)_localctx).e2 = equalityExpression();

				        BinaryOperator op = BinaryOperator.and;
				        ((AndExpressionContext)_localctx).andExprRet =  new BinaryExpression(_localctx.andExprRet, ((AndExpressionContext)_localctx).e2.eqExprRet, op);
				        _localctx.andExprRet.setLine(((AndExpressionContext)_localctx).a.getLine());
				    
				}
				}
				setState(329);
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

	public static class EqualityExpressionContext extends ParserRuleContext {
		public Expression eqExprRet;
		public BinaryOperator op;
		public int line;
		public RelationalExpressionContext r1;
		public Token eq;
		public Token neq;
		public RelationalExpressionContext r2;
		public List<RelationalExpressionContext> relationalExpression() {
			return getRuleContexts(RelationalExpressionContext.class);
		}
		public RelationalExpressionContext relationalExpression(int i) {
			return getRuleContext(RelationalExpressionContext.class,i);
		}
		public List<TerminalNode> EQUAL() { return getTokens(JepetoParser.EQUAL); }
		public TerminalNode EQUAL(int i) {
			return getToken(JepetoParser.EQUAL, i);
		}
		public List<TerminalNode> NOT_EQUAL() { return getTokens(JepetoParser.NOT_EQUAL); }
		public TerminalNode NOT_EQUAL(int i) {
			return getToken(JepetoParser.NOT_EQUAL, i);
		}
		public EqualityExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterEqualityExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitEqualityExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitEqualityExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualityExpressionContext equalityExpression() throws RecognitionException {
		EqualityExpressionContext _localctx = new EqualityExpressionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_equalityExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330);
			((EqualityExpressionContext)_localctx).r1 = relationalExpression();
			 ((EqualityExpressionContext)_localctx).eqExprRet =  ((EqualityExpressionContext)_localctx).r1.relExprRet; 
			setState(343);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EQUAL || _la==NOT_EQUAL) {
				{
				{
				setState(336);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case EQUAL:
					{
					setState(332);
					((EqualityExpressionContext)_localctx).eq = match(EQUAL);

					        ((EqualityExpressionContext)_localctx).op =  BinaryOperator.eq;
					        ((EqualityExpressionContext)_localctx).line =  ((EqualityExpressionContext)_localctx).eq.getLine();
					    
					}
					break;
				case NOT_EQUAL:
					{
					setState(334);
					((EqualityExpressionContext)_localctx).neq = match(NOT_EQUAL);

					        ((EqualityExpressionContext)_localctx).op =  BinaryOperator.neq;
					        ((EqualityExpressionContext)_localctx).line =  ((EqualityExpressionContext)_localctx).neq.getLine();
					    
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(338);
				((EqualityExpressionContext)_localctx).r2 = relationalExpression();

				        ((EqualityExpressionContext)_localctx).eqExprRet =  new BinaryExpression(_localctx.eqExprRet, ((EqualityExpressionContext)_localctx).r2.relExprRet, _localctx.op);
				        _localctx.eqExprRet.setLine(_localctx.line);
				    
				}
				}
				setState(345);
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

	public static class RelationalExpressionContext extends ParserRuleContext {
		public Expression relExprRet;
		public BinaryOperator op;
		public int line;
		public AdditiveExpressionContext a1;
		public Token gt;
		public Token lt;
		public AdditiveExpressionContext a2;
		public List<AdditiveExpressionContext> additiveExpression() {
			return getRuleContexts(AdditiveExpressionContext.class);
		}
		public AdditiveExpressionContext additiveExpression(int i) {
			return getRuleContext(AdditiveExpressionContext.class,i);
		}
		public List<TerminalNode> GREATER_THAN() { return getTokens(JepetoParser.GREATER_THAN); }
		public TerminalNode GREATER_THAN(int i) {
			return getToken(JepetoParser.GREATER_THAN, i);
		}
		public List<TerminalNode> LESS_THAN() { return getTokens(JepetoParser.LESS_THAN); }
		public TerminalNode LESS_THAN(int i) {
			return getToken(JepetoParser.LESS_THAN, i);
		}
		public RelationalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterRelationalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitRelationalExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitRelationalExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationalExpressionContext relationalExpression() throws RecognitionException {
		RelationalExpressionContext _localctx = new RelationalExpressionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_relationalExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(346);
			((RelationalExpressionContext)_localctx).a1 = additiveExpression();
			 ((RelationalExpressionContext)_localctx).relExprRet =  ((RelationalExpressionContext)_localctx).a1.addExprRet; 
			setState(359);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==GREATER_THAN || _la==LESS_THAN) {
				{
				{
				setState(352);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case GREATER_THAN:
					{
					setState(348);
					((RelationalExpressionContext)_localctx).gt = match(GREATER_THAN);

					        ((RelationalExpressionContext)_localctx).op =  BinaryOperator.gt;
					        ((RelationalExpressionContext)_localctx).line =  ((RelationalExpressionContext)_localctx).gt.getLine();
					    
					}
					break;
				case LESS_THAN:
					{
					setState(350);
					((RelationalExpressionContext)_localctx).lt = match(LESS_THAN);

					        ((RelationalExpressionContext)_localctx).op =  BinaryOperator.lt;
					        ((RelationalExpressionContext)_localctx).line =  ((RelationalExpressionContext)_localctx).lt.getLine();
					    
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(354);
				((RelationalExpressionContext)_localctx).a2 = additiveExpression();

				        ((RelationalExpressionContext)_localctx).relExprRet =  new BinaryExpression(_localctx.relExprRet, ((RelationalExpressionContext)_localctx).a2.addExprRet, _localctx.op);
				        _localctx.relExprRet.setLine(_localctx.line);
				    
				}
				}
				setState(361);
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

	public static class AdditiveExpressionContext extends ParserRuleContext {
		public Expression addExprRet;
		public BinaryOperator op;
		public int line;
		public MultiplicativeExpressionContext m1;
		public Token add;
		public Token sub;
		public MultiplicativeExpressionContext m2;
		public List<MultiplicativeExpressionContext> multiplicativeExpression() {
			return getRuleContexts(MultiplicativeExpressionContext.class);
		}
		public MultiplicativeExpressionContext multiplicativeExpression(int i) {
			return getRuleContext(MultiplicativeExpressionContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(JepetoParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(JepetoParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(JepetoParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(JepetoParser.MINUS, i);
		}
		public AdditiveExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterAdditiveExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitAdditiveExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitAdditiveExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdditiveExpressionContext additiveExpression() throws RecognitionException {
		AdditiveExpressionContext _localctx = new AdditiveExpressionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_additiveExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(362);
			((AdditiveExpressionContext)_localctx).m1 = multiplicativeExpression();
			 ((AdditiveExpressionContext)_localctx).addExprRet =  ((AdditiveExpressionContext)_localctx).m1.multExprRet; 
			setState(375);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(368);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PLUS:
					{
					setState(364);
					((AdditiveExpressionContext)_localctx).add = match(PLUS);

					        ((AdditiveExpressionContext)_localctx).op =  BinaryOperator.add;
					        ((AdditiveExpressionContext)_localctx).line =  ((AdditiveExpressionContext)_localctx).add.getLine();
					    
					}
					break;
				case MINUS:
					{
					setState(366);
					((AdditiveExpressionContext)_localctx).sub = match(MINUS);

					        ((AdditiveExpressionContext)_localctx).op =  BinaryOperator.sub;
					        ((AdditiveExpressionContext)_localctx).line =  ((AdditiveExpressionContext)_localctx).sub.getLine();
					    
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(370);
				((AdditiveExpressionContext)_localctx).m2 = multiplicativeExpression();

				        ((AdditiveExpressionContext)_localctx).addExprRet =  new BinaryExpression(_localctx.addExprRet, ((AdditiveExpressionContext)_localctx).m2.multExprRet, _localctx.op);
				        _localctx.addExprRet.setLine(_localctx.line);
				    
				}
				}
				setState(377);
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

	public static class MultiplicativeExpressionContext extends ParserRuleContext {
		public Expression multExprRet;
		public BinaryOperator op;
		public int line;
		public PreUnaryExpressionContext p1;
		public Token mult;
		public Token div;
		public PreUnaryExpressionContext p2;
		public List<PreUnaryExpressionContext> preUnaryExpression() {
			return getRuleContexts(PreUnaryExpressionContext.class);
		}
		public PreUnaryExpressionContext preUnaryExpression(int i) {
			return getRuleContext(PreUnaryExpressionContext.class,i);
		}
		public List<TerminalNode> MULT() { return getTokens(JepetoParser.MULT); }
		public TerminalNode MULT(int i) {
			return getToken(JepetoParser.MULT, i);
		}
		public List<TerminalNode> DIVIDE() { return getTokens(JepetoParser.DIVIDE); }
		public TerminalNode DIVIDE(int i) {
			return getToken(JepetoParser.DIVIDE, i);
		}
		public MultiplicativeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterMultiplicativeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitMultiplicativeExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitMultiplicativeExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplicativeExpressionContext multiplicativeExpression() throws RecognitionException {
		MultiplicativeExpressionContext _localctx = new MultiplicativeExpressionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_multiplicativeExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			((MultiplicativeExpressionContext)_localctx).p1 = preUnaryExpression();
			 ((MultiplicativeExpressionContext)_localctx).multExprRet =  ((MultiplicativeExpressionContext)_localctx).p1.preUnaryExprRet; 
			setState(391);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULT || _la==DIVIDE) {
				{
				{
				setState(384);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case MULT:
					{
					setState(380);
					((MultiplicativeExpressionContext)_localctx).mult = match(MULT);

					        ((MultiplicativeExpressionContext)_localctx).op =  BinaryOperator.mult;
					        ((MultiplicativeExpressionContext)_localctx).line =  ((MultiplicativeExpressionContext)_localctx).mult.getLine();
					    
					}
					break;
				case DIVIDE:
					{
					setState(382);
					((MultiplicativeExpressionContext)_localctx).div = match(DIVIDE);

					        ((MultiplicativeExpressionContext)_localctx).op =  BinaryOperator.div;
					        ((MultiplicativeExpressionContext)_localctx).line =  ((MultiplicativeExpressionContext)_localctx).div.getLine();
					    
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(386);
				((MultiplicativeExpressionContext)_localctx).p2 = preUnaryExpression();

				        ((MultiplicativeExpressionContext)_localctx).multExprRet =  new BinaryExpression(_localctx.multExprRet, ((MultiplicativeExpressionContext)_localctx).p2.preUnaryExprRet, _localctx.op);
				        _localctx.multExprRet.setLine(_localctx.line);
				    
				}
				}
				setState(393);
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

	public static class PreUnaryExpressionContext extends ParserRuleContext {
		public Expression preUnaryExprRet;
		public UnaryOperator op;
		public int line;
		public Token not;
		public Token minus;
		public PreUnaryExpressionContext p;
		public AppendExpressionContext a;
		public PreUnaryExpressionContext preUnaryExpression() {
			return getRuleContext(PreUnaryExpressionContext.class,0);
		}
		public TerminalNode NOT() { return getToken(JepetoParser.NOT, 0); }
		public TerminalNode MINUS() { return getToken(JepetoParser.MINUS, 0); }
		public AppendExpressionContext appendExpression() {
			return getRuleContext(AppendExpressionContext.class,0);
		}
		public PreUnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preUnaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterPreUnaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitPreUnaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitPreUnaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PreUnaryExpressionContext preUnaryExpression() throws RecognitionException {
		PreUnaryExpressionContext _localctx = new PreUnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_preUnaryExpression);
		try {
			setState(406);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(398);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NOT:
					{
					setState(394);
					((PreUnaryExpressionContext)_localctx).not = match(NOT);

					        ((PreUnaryExpressionContext)_localctx).op =  UnaryOperator.not;
					        ((PreUnaryExpressionContext)_localctx).line =  ((PreUnaryExpressionContext)_localctx).not.getLine();
					    
					}
					break;
				case MINUS:
					{
					setState(396);
					((PreUnaryExpressionContext)_localctx).minus = match(MINUS);

					        ((PreUnaryExpressionContext)_localctx).op =  UnaryOperator.minus;
					        ((PreUnaryExpressionContext)_localctx).line =  ((PreUnaryExpressionContext)_localctx).minus.getLine();
					    
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(400);
				((PreUnaryExpressionContext)_localctx).p = preUnaryExpression();

				        ((PreUnaryExpressionContext)_localctx).preUnaryExprRet =  new UnaryExpression(((PreUnaryExpressionContext)_localctx).p.preUnaryExprRet, _localctx.op);
				        _localctx.preUnaryExprRet.setLine(_localctx.line);
				    
				}
				}
				break;
			case TRUE:
			case FALSE:
			case LPAR:
			case LBRACK:
			case INT_VALUE:
			case IDENTIFIER:
			case STRING_VALUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(403);
				((PreUnaryExpressionContext)_localctx).a = appendExpression();
				 ((PreUnaryExpressionContext)_localctx).preUnaryExprRet =  ((PreUnaryExpressionContext)_localctx).a.appendExprRet; 
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

	public static class AppendExpressionContext extends ParserRuleContext {
		public Expression appendExprRet;
		public AccessExpressionContext a1;
		public Token app;
		public AccessExpressionContext a2;
		public List<AccessExpressionContext> accessExpression() {
			return getRuleContexts(AccessExpressionContext.class);
		}
		public AccessExpressionContext accessExpression(int i) {
			return getRuleContext(AccessExpressionContext.class,i);
		}
		public List<TerminalNode> APPEND() { return getTokens(JepetoParser.APPEND); }
		public TerminalNode APPEND(int i) {
			return getToken(JepetoParser.APPEND, i);
		}
		public AppendExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_appendExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterAppendExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitAppendExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitAppendExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AppendExpressionContext appendExpression() throws RecognitionException {
		AppendExpressionContext _localctx = new AppendExpressionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_appendExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(408);
			((AppendExpressionContext)_localctx).a1 = accessExpression();
			 ((AppendExpressionContext)_localctx).appendExprRet =  ((AppendExpressionContext)_localctx).a1.accessExprRet; 
			setState(416);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==APPEND) {
				{
				{
				setState(410);
				((AppendExpressionContext)_localctx).app = match(APPEND);
				setState(411);
				((AppendExpressionContext)_localctx).a2 = accessExpression();

				        BinaryOperator op = BinaryOperator.append;
				        ((AppendExpressionContext)_localctx).appendExprRet =  new BinaryExpression(_localctx.appendExprRet, ((AppendExpressionContext)_localctx).a2.accessExprRet, op);
				        _localctx.appendExprRet.setLine(((AppendExpressionContext)_localctx).app.getLine());
				    
				}
				}
				setState(418);
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

	public static class AccessExpressionContext extends ParserRuleContext {
		public Expression accessExprRet;
		public Expression instance;
		public OtherExpressionContext o;
		public Token l;
		public FunctionArgumentsContext fa;
		public ExpressionContext index;
		public SizeExpressionContext s;
		public OtherExpressionContext otherExpression() {
			return getRuleContext(OtherExpressionContext.class,0);
		}
		public List<TerminalNode> RPAR() { return getTokens(JepetoParser.RPAR); }
		public TerminalNode RPAR(int i) {
			return getToken(JepetoParser.RPAR, i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(JepetoParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(JepetoParser.RBRACK, i);
		}
		public List<TerminalNode> LPAR() { return getTokens(JepetoParser.LPAR); }
		public TerminalNode LPAR(int i) {
			return getToken(JepetoParser.LPAR, i);
		}
		public List<FunctionArgumentsContext> functionArguments() {
			return getRuleContexts(FunctionArgumentsContext.class);
		}
		public FunctionArgumentsContext functionArguments(int i) {
			return getRuleContext(FunctionArgumentsContext.class,i);
		}
		public List<TerminalNode> LBRACK() { return getTokens(JepetoParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(JepetoParser.LBRACK, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<SizeExpressionContext> sizeExpression() {
			return getRuleContexts(SizeExpressionContext.class);
		}
		public SizeExpressionContext sizeExpression(int i) {
			return getRuleContext(SizeExpressionContext.class,i);
		}
		public AccessExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accessExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterAccessExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitAccessExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitAccessExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccessExpressionContext accessExpression() throws RecognitionException {
		AccessExpressionContext _localctx = new AccessExpressionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_accessExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(419);
			((AccessExpressionContext)_localctx).o = otherExpression();

			        ((AccessExpressionContext)_localctx).instance =  ((AccessExpressionContext)_localctx).o.otherExprRet;
			        ((AccessExpressionContext)_localctx).accessExprRet =   _localctx.instance;
			    
			setState(428);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LPAR) {
				{
				{
				setState(421);
				((AccessExpressionContext)_localctx).l = match(LPAR);
				setState(422);
				((AccessExpressionContext)_localctx).fa = functionArguments();

				        FunctionCall fc = new FunctionCall(_localctx.instance);
				        fc.setArgsWithKey(((AccessExpressionContext)_localctx).fa.argsWithKeyRet);
				        fc.setArgs(((AccessExpressionContext)_localctx).fa.argsRet);
				        ((AccessExpressionContext)_localctx).accessExprRet =  fc;
				        ((AccessExpressionContext)_localctx).instance =  _localctx.accessExprRet;
				        _localctx.accessExprRet.setLine(((AccessExpressionContext)_localctx).l.getLine());
				    
				setState(424);
				match(RPAR);
				}
				}
				setState(430);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(438);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACK) {
				{
				{
				setState(431);
				((AccessExpressionContext)_localctx).l = match(LBRACK);
				setState(432);
				((AccessExpressionContext)_localctx).index = expression();

				        ((AccessExpressionContext)_localctx).accessExprRet =  new ListAccessByIndex(_localctx.instance, ((AccessExpressionContext)_localctx).index.exprRet);
				        _localctx.accessExprRet.setLine(((AccessExpressionContext)_localctx).l.getLine());
				        ((AccessExpressionContext)_localctx).instance =  _localctx.accessExprRet;
				    
				setState(434);
				match(RBRACK);
				}
				}
				setState(440);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(446);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(441);
				((AccessExpressionContext)_localctx).s = sizeExpression();

				        ((AccessExpressionContext)_localctx).accessExprRet =  new ListSize(_localctx.instance);
				        _localctx.accessExprRet.setLine(((AccessExpressionContext)_localctx).s.line);
				    
				}
				}
				setState(448);
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

	public static class OtherExpressionContext extends ParserRuleContext {
		public Expression otherExprRet;
		public ValuesContext v;
		public IdentifierContext id;
		public AnonymousFunctionContext an;
		public ExpressionContext exp;
		public ValuesContext values() {
			return getRuleContext(ValuesContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public AnonymousFunctionContext anonymousFunction() {
			return getRuleContext(AnonymousFunctionContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(JepetoParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(JepetoParser.RPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public OtherExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_otherExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterOtherExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitOtherExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitOtherExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OtherExpressionContext otherExpression() throws RecognitionException {
		OtherExpressionContext _localctx = new OtherExpressionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_otherExpression);
		try {
			setState(463);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(449);
				((OtherExpressionContext)_localctx).v = values();
				 ((OtherExpressionContext)_localctx).otherExprRet =  ((OtherExpressionContext)_localctx).v.valuesRet; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(452);
				((OtherExpressionContext)_localctx).id = identifier();
				 ((OtherExpressionContext)_localctx).otherExprRet =  ((OtherExpressionContext)_localctx).id.idRet; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(455);
				((OtherExpressionContext)_localctx).an = anonymousFunction();
				 ((OtherExpressionContext)_localctx).otherExprRet =  ((OtherExpressionContext)_localctx).an.anRet; 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(458);
				match(LPAR);
				{
				setState(459);
				((OtherExpressionContext)_localctx).exp = expression();
				}
				setState(460);
				match(RPAR);
				 ((OtherExpressionContext)_localctx).otherExprRet =  ((OtherExpressionContext)_localctx).exp.exprRet; 
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

	public static class AnonymousFunctionContext extends ParserRuleContext {
		public AnonymousFunction anRet;
		public FunctionArgumentsDeclarationContext args;
		public BlockContext b;
		public TerminalNode ARROW() { return getToken(JepetoParser.ARROW, 0); }
		public FunctionArgumentsDeclarationContext functionArgumentsDeclaration() {
			return getRuleContext(FunctionArgumentsDeclarationContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public AnonymousFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anonymousFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterAnonymousFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitAnonymousFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitAnonymousFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnonymousFunctionContext anonymousFunction() throws RecognitionException {
		AnonymousFunctionContext _localctx = new AnonymousFunctionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_anonymousFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(465);
			((AnonymousFunctionContext)_localctx).args = functionArgumentsDeclaration();

			        ((AnonymousFunctionContext)_localctx).anRet =  new AnonymousFunction(((AnonymousFunctionContext)_localctx).args.argsRet);
			        _localctx.anRet.setLine(((AnonymousFunctionContext)_localctx).args.line);
			    
			setState(467);
			match(ARROW);
			setState(468);
			((AnonymousFunctionContext)_localctx).b = block();

			        Statement bodyRet = ((AnonymousFunctionContext)_localctx).b.blockRet;
			        _localctx.anRet.setBody(bodyRet);
			    
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

	public static class SizeExpressionContext extends ParserRuleContext {
		public int line;
		public Token s;
		public TerminalNode DOT() { return getToken(JepetoParser.DOT, 0); }
		public TerminalNode SIZE() { return getToken(JepetoParser.SIZE, 0); }
		public SizeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sizeExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterSizeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitSizeExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitSizeExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SizeExpressionContext sizeExpression() throws RecognitionException {
		SizeExpressionContext _localctx = new SizeExpressionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_sizeExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(471);
			match(DOT);
			setState(472);
			((SizeExpressionContext)_localctx).s = match(SIZE);

			        ((SizeExpressionContext)_localctx).line =  ((SizeExpressionContext)_localctx).s.getLine();
			    
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

	public static class ValuesContext extends ParserRuleContext {
		public Value valuesRet;
		public BoolValueContext b;
		public Token s;
		public Token i;
		public ListValueContext l;
		public BoolValueContext boolValue() {
			return getRuleContext(BoolValueContext.class,0);
		}
		public TerminalNode STRING_VALUE() { return getToken(JepetoParser.STRING_VALUE, 0); }
		public TerminalNode INT_VALUE() { return getToken(JepetoParser.INT_VALUE, 0); }
		public ListValueContext listValue() {
			return getRuleContext(ListValueContext.class,0);
		}
		public ValuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_values; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterValues(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitValues(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitValues(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValuesContext values() throws RecognitionException {
		ValuesContext _localctx = new ValuesContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_values);
		try {
			setState(485);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 1);
				{
				setState(475);
				((ValuesContext)_localctx).b = boolValue();

				        ((ValuesContext)_localctx).valuesRet =  new BoolValue(((ValuesContext)_localctx).b.boolValueRet);
				        _localctx.valuesRet.setLine(((ValuesContext)_localctx).b.line);
				    
				}
				break;
			case STRING_VALUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(478);
				((ValuesContext)_localctx).s = match(STRING_VALUE);

				        ((ValuesContext)_localctx).valuesRet =  new StringValue(((((ValuesContext)_localctx).s!=null?((ValuesContext)_localctx).s.getText():null)).substring(1, ((((ValuesContext)_localctx).s!=null?((ValuesContext)_localctx).s.getText():null)).length()-1));
				        _localctx.valuesRet.setLine(((ValuesContext)_localctx).s.getLine());
				    
				}
				break;
			case INT_VALUE:
				enterOuterAlt(_localctx, 3);
				{
				setState(480);
				((ValuesContext)_localctx).i = match(INT_VALUE);

				        ((ValuesContext)_localctx).valuesRet =  new IntValue((((ValuesContext)_localctx).i!=null?Integer.valueOf(((ValuesContext)_localctx).i.getText()):0));
				        _localctx.valuesRet.setLine(((ValuesContext)_localctx).i.getLine());
				    
				}
				break;
			case LBRACK:
				enterOuterAlt(_localctx, 4);
				{
				setState(482);
				((ValuesContext)_localctx).l = listValue();
				 ((ValuesContext)_localctx).valuesRet =  ((ValuesContext)_localctx).l.listValueRet; 
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

	public static class ListValueContext extends ParserRuleContext {
		public ListValue listValueRet;
		public Token l;
		public SplitedExpressionsWithCommaContext s;
		public TerminalNode RBRACK() { return getToken(JepetoParser.RBRACK, 0); }
		public TerminalNode LBRACK() { return getToken(JepetoParser.LBRACK, 0); }
		public SplitedExpressionsWithCommaContext splitedExpressionsWithComma() {
			return getRuleContext(SplitedExpressionsWithCommaContext.class,0);
		}
		public ListValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterListValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitListValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitListValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListValueContext listValue() throws RecognitionException {
		ListValueContext _localctx = new ListValueContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_listValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(487);
			((ListValueContext)_localctx).l = match(LBRACK);
			setState(488);
			((ListValueContext)_localctx).s = splitedExpressionsWithComma();

			        ((ListValueContext)_localctx).listValueRet =  new ListValue(((ListValueContext)_localctx).s.spltExpWthCommaRet);
			        _localctx.listValueRet.setLine(((ListValueContext)_localctx).l.getLine());
			    
			setState(490);
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

	public static class BoolValueContext extends ParserRuleContext {
		public boolean boolValueRet;
		public int line;
		public Token t;
		public Token f;
		public TerminalNode TRUE() { return getToken(JepetoParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(JepetoParser.FALSE, 0); }
		public BoolValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterBoolValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitBoolValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitBoolValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolValueContext boolValue() throws RecognitionException {
		BoolValueContext _localctx = new BoolValueContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_boolValue);
		try {
			setState(496);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(492);
				((BoolValueContext)_localctx).t = match(TRUE);

				        ((BoolValueContext)_localctx).boolValueRet =  true;
				        ((BoolValueContext)_localctx).line =  ((BoolValueContext)_localctx).t.getLine();
				    
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(494);
				((BoolValueContext)_localctx).f = match(FALSE);

				        ((BoolValueContext)_localctx).boolValueRet =  false;
				        ((BoolValueContext)_localctx).line =  ((BoolValueContext)_localctx).f.getLine();
				    
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

	public static class VoidValueContext extends ParserRuleContext {
		public VoidValue voidValueRet;
		public int line;
		public Token v;
		public TerminalNode VOID() { return getToken(JepetoParser.VOID, 0); }
		public VoidValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_voidValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterVoidValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitVoidValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitVoidValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VoidValueContext voidValue() throws RecognitionException {
		VoidValueContext _localctx = new VoidValueContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_voidValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(498);
			((VoidValueContext)_localctx).v = match(VOID);

			        ((VoidValueContext)_localctx).voidValueRet =  new VoidValue();
			        _localctx.voidValueRet.setLine(((VoidValueContext)_localctx).v.getLine());
			        ((VoidValueContext)_localctx).line =  ((VoidValueContext)_localctx).v.getLine();
			    
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

	public static class IdentifierContext extends ParserRuleContext {
		public Identifier idRet;
		public int line;
		public Token id;
		public TerminalNode IDENTIFIER() { return getToken(JepetoParser.IDENTIFIER, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JepetoListener ) ((JepetoListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JepetoVisitor ) return ((JepetoVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(501);
			((IdentifierContext)_localctx).id = match(IDENTIFIER);

			        ((IdentifierContext)_localctx).idRet =  new Identifier((((IdentifierContext)_localctx).id!=null?((IdentifierContext)_localctx).id.getText():null));
			        _localctx.idRet.setLine(((IdentifierContext)_localctx).id.getLine());
			        ((IdentifierContext)_localctx).line =  ((IdentifierContext)_localctx).id.getLine();
			    
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3)\u01fb\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\7\3S\n\3"+
		"\f\3\16\3V\13\3\3\3\3\3\3\3\3\3\3\3\7\3]\n\3\f\3\16\3`\13\3\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5s\n\5\f"+
		"\5\16\5v\13\5\5\5x\n\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u0082\n\6\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u008d\n\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\7\b\u0096\n\b\f\b\16\b\u0099\13\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\5\t\u00a7\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u00b0"+
		"\n\n\f\n\16\n\u00b3\13\n\5\n\u00b5\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\7\13\u00c2\n\13\f\13\16\13\u00c5\13\13\5\13\u00c7"+
		"\n\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00d4\n\r\3\r\3"+
		"\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00e2\n\16\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\5\21\u0101\n\21\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0109\n\22\3\23"+
		"\3\23\3\23\3\23\3\23\7\23\u0110\n\23\f\23\16\23\u0113\13\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\5\23\u011b\n\23\3\23\3\23\3\23\7\23\u0120\n\23\f"+
		"\23\16\23\u0123\13\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\7\24\u012c\n"+
		"\24\f\24\16\24\u012f\13\24\3\24\3\24\3\24\3\24\5\24\u0135\n\24\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\7\25\u013d\n\25\f\25\16\25\u0140\13\25\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\7\26\u0148\n\26\f\26\16\26\u014b\13\26\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\5\27\u0153\n\27\3\27\3\27\3\27\7\27\u0158\n\27"+
		"\f\27\16\27\u015b\13\27\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u0163\n\30"+
		"\3\30\3\30\3\30\7\30\u0168\n\30\f\30\16\30\u016b\13\30\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\5\31\u0173\n\31\3\31\3\31\3\31\7\31\u0178\n\31\f\31\16"+
		"\31\u017b\13\31\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u0183\n\32\3\32\3\32"+
		"\3\32\7\32\u0188\n\32\f\32\16\32\u018b\13\32\3\33\3\33\3\33\3\33\5\33"+
		"\u0191\n\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u0199\n\33\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\7\34\u01a1\n\34\f\34\16\34\u01a4\13\34\3\35\3\35\3"+
		"\35\3\35\3\35\3\35\3\35\7\35\u01ad\n\35\f\35\16\35\u01b0\13\35\3\35\3"+
		"\35\3\35\3\35\3\35\7\35\u01b7\n\35\f\35\16\35\u01ba\13\35\3\35\3\35\3"+
		"\35\7\35\u01bf\n\35\f\35\16\35\u01c2\13\35\3\36\3\36\3\36\3\36\3\36\3"+
		"\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u01d2\n\36\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\5!\u01e8"+
		"\n!\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\5#\u01f3\n#\3$\3$\3$\3%\3%\3%\3%\2"+
		"\2&\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@B"+
		"DFH\2\2\2\u0204\2J\3\2\2\2\4N\3\2\2\2\6a\3\2\2\2\bj\3\2\2\2\n\u0081\3"+
		"\2\2\2\f\u0083\3\2\2\2\16\u008e\3\2\2\2\20\u00a6\3\2\2\2\22\u00a8\3\2"+
		"\2\2\24\u00b6\3\2\2\2\26\u00c8\3\2\2\2\30\u00cc\3\2\2\2\32\u00d7\3\2\2"+
		"\2\34\u00e3\3\2\2\2\36\u00ed\3\2\2\2 \u0100\3\2\2\2\"\u0108\3\2\2\2$\u010a"+
		"\3\2\2\2&\u0134\3\2\2\2(\u0136\3\2\2\2*\u0141\3\2\2\2,\u014c\3\2\2\2."+
		"\u015c\3\2\2\2\60\u016c\3\2\2\2\62\u017c\3\2\2\2\64\u0198\3\2\2\2\66\u019a"+
		"\3\2\2\28\u01a5\3\2\2\2:\u01d1\3\2\2\2<\u01d3\3\2\2\2>\u01d9\3\2\2\2@"+
		"\u01e7\3\2\2\2B\u01e9\3\2\2\2D\u01f2\3\2\2\2F\u01f4\3\2\2\2H\u01f7\3\2"+
		"\2\2JK\5\4\3\2KL\b\2\1\2LM\7\2\2\3M\3\3\2\2\2NT\b\3\1\2OP\5\6\4\2PQ\b"+
		"\3\1\2QS\3\2\2\2RO\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2UW\3\2\2\2VT\3"+
		"\2\2\2WX\5\f\7\2X^\b\3\1\2YZ\5\6\4\2Z[\b\3\1\2[]\3\2\2\2\\Y\3\2\2\2]`"+
		"\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_\5\3\2\2\2`^\3\2\2\2ab\7\3\2\2bc\7&\2\2"+
		"cd\b\4\1\2de\5\b\5\2ef\b\4\1\2fg\7#\2\2gh\5\n\6\2hi\b\4\1\2i\7\3\2\2\2"+
		"jk\b\5\1\2kl\7\33\2\2lw\b\5\1\2mn\7&\2\2nt\b\5\1\2op\7!\2\2pq\7&\2\2q"+
		"s\b\5\1\2ro\3\2\2\2sv\3\2\2\2tr\3\2\2\2tu\3\2\2\2ux\3\2\2\2vt\3\2\2\2"+
		"wm\3\2\2\2wx\3\2\2\2xy\3\2\2\2yz\7\34\2\2z\t\3\2\2\2{|\5\"\22\2|}\b\6"+
		"\1\2}\u0082\3\2\2\2~\177\5$\23\2\177\u0080\b\6\1\2\u0080\u0082\3\2\2\2"+
		"\u0081{\3\2\2\2\u0081~\3\2\2\2\u0082\13\3\2\2\2\u0083\u0084\7\4\2\2\u0084"+
		"\u0085\b\7\1\2\u0085\u008c\7#\2\2\u0086\u0087\5\26\f\2\u0087\u0088\b\7"+
		"\1\2\u0088\u008d\3\2\2\2\u0089\u008a\5\36\20\2\u008a\u008b\b\7\1\2\u008b"+
		"\u008d\3\2\2\2\u008c\u0086\3\2\2\2\u008c\u0089\3\2\2\2\u008d\r\3\2\2\2"+
		"\u008e\u008f\5H%\2\u008f\u0097\b\b\1\2\u0090\u0091\7\33\2\2\u0091\u0092"+
		"\5\20\t\2\u0092\u0093\b\b\1\2\u0093\u0094\7\34\2\2\u0094\u0096\3\2\2\2"+
		"\u0095\u0090\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098"+
		"\3\2\2\2\u0098\u009a\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u009b\7\33\2\2"+
		"\u009b\u009c\5\20\t\2\u009c\u009d\b\b\1\2\u009d\u009e\7\34\2\2\u009e\17"+
		"\3\2\2\2\u009f\u00a0\b\t\1\2\u00a0\u00a1\5\22\n\2\u00a1\u00a2\b\t\1\2"+
		"\u00a2\u00a7\3\2\2\2\u00a3\u00a4\5\24\13\2\u00a4\u00a5\b\t\1\2\u00a5\u00a7"+
		"\3\2\2\2\u00a6\u009f\3\2\2\2\u00a6\u00a3\3\2\2\2\u00a7\21\3\2\2\2\u00a8"+
		"\u00b4\b\n\1\2\u00a9\u00aa\5(\25\2\u00aa\u00b1\b\n\1\2\u00ab\u00ac\7!"+
		"\2\2\u00ac\u00ad\5(\25\2\u00ad\u00ae\b\n\1\2\u00ae\u00b0\3\2\2\2\u00af"+
		"\u00ab\3\2\2\2\u00b0\u00b3\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2"+
		"\2\2\u00b2\u00b5\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b4\u00a9\3\2\2\2\u00b4"+
		"\u00b5\3\2\2\2\u00b5\23\3\2\2\2\u00b6\u00c6\b\13\1\2\u00b7\u00b8\5H%\2"+
		"\u00b8\u00b9\7\32\2\2\u00b9\u00ba\5(\25\2\u00ba\u00c3\b\13\1\2\u00bb\u00bc"+
		"\7!\2\2\u00bc\u00bd\5H%\2\u00bd\u00be\7\32\2\2\u00be\u00bf\5(\25\2\u00bf"+
		"\u00c0\b\13\1\2\u00c0\u00c2\3\2\2\2\u00c1\u00bb\3\2\2\2\u00c2\u00c5\3"+
		"\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c7\3\2\2\2\u00c5"+
		"\u00c3\3\2\2\2\u00c6\u00b7\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\25\3\2\2"+
		"\2\u00c8\u00c9\5\16\b\2\u00c9\u00ca\b\f\1\2\u00ca\u00cb\7$\2\2\u00cb\27"+
		"\3\2\2\2\u00cc\u00d3\7\7\2\2\u00cd\u00ce\5(\25\2\u00ce\u00cf\b\r\1\2\u00cf"+
		"\u00d4\3\2\2\2\u00d0\u00d1\5F$\2\u00d1\u00d2\b\r\1\2\u00d2\u00d4\3\2\2"+
		"\2\u00d3\u00cd\3\2\2\2\u00d3\u00d0\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6"+
		"\7$\2\2\u00d6\31\3\2\2\2\u00d7\u00d8\7\t\2\2\u00d8\u00d9\5(\25\2\u00d9"+
		"\u00da\7#\2\2\u00da\u00db\5&\24\2\u00db\u00e1\b\16\1\2\u00dc\u00dd\7\n"+
		"\2\2\u00dd\u00de\7#\2\2\u00de\u00df\5&\24\2\u00df\u00e0\b\16\1\2\u00e0"+
		"\u00e2\3\2\2\2\u00e1\u00dc\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\33\3\2\2"+
		"\2\u00e3\u00e4\7\t\2\2\u00e4\u00e5\5(\25\2\u00e5\u00e6\7#\2\2\u00e6\u00e7"+
		"\5\n\6\2\u00e7\u00e8\b\17\1\2\u00e8\u00e9\7\n\2\2\u00e9\u00ea\7#\2\2\u00ea"+
		"\u00eb\5\n\6\2\u00eb\u00ec\b\17\1\2\u00ec\35\3\2\2\2\u00ed\u00ee\7\6\2"+
		"\2\u00ee\u00ef\7\33\2\2\u00ef\u00f0\5(\25\2\u00f0\u00f1\b\20\1\2\u00f1"+
		"\u00f2\7\34\2\2\u00f2\u00f3\7$\2\2\u00f3\37\3\2\2\2\u00f4\u00f5\5\32\16"+
		"\2\u00f5\u00f6\b\21\1\2\u00f6\u0101\3\2\2\2\u00f7\u00f8\5\36\20\2\u00f8"+
		"\u00f9\b\21\1\2\u00f9\u0101\3\2\2\2\u00fa\u00fb\5\26\f\2\u00fb\u00fc\b"+
		"\21\1\2\u00fc\u0101\3\2\2\2\u00fd\u00fe\5\30\r\2\u00fe\u00ff\b\21\1\2"+
		"\u00ff\u0101\3\2\2\2\u0100\u00f4\3\2\2\2\u0100\u00f7\3\2\2\2\u0100\u00fa"+
		"\3\2\2\2\u0100\u00fd\3\2\2\2\u0101!\3\2\2\2\u0102\u0103\5\30\r\2\u0103"+
		"\u0104\b\22\1\2\u0104\u0109\3\2\2\2\u0105\u0106\5\34\17\2\u0106\u0107"+
		"\b\22\1\2\u0107\u0109\3\2\2\2\u0108\u0102\3\2\2\2\u0108\u0105\3\2\2\2"+
		"\u0109#\3\2\2\2\u010a\u010b\7\37\2\2\u010b\u0111\b\23\1\2\u010c\u010d"+
		"\5 \21\2\u010d\u010e\b\23\1\2\u010e\u0110\3\2\2\2\u010f\u010c\3\2\2\2"+
		"\u0110\u0113\3\2\2\2\u0111\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u011a"+
		"\3\2\2\2\u0113\u0111\3\2\2\2\u0114\u0115\5\30\r\2\u0115\u0116\b\23\1\2"+
		"\u0116\u011b\3\2\2\2\u0117\u0118\5\34\17\2\u0118\u0119\b\23\1\2\u0119"+
		"\u011b\3\2\2\2\u011a\u0114\3\2\2\2\u011a\u0117\3\2\2\2\u011b\u0121\3\2"+
		"\2\2\u011c\u011d\5 \21\2\u011d\u011e\b\23\1\2\u011e\u0120\3\2\2\2\u011f"+
		"\u011c\3\2\2\2\u0120\u0123\3\2\2\2\u0121\u011f\3\2\2\2\u0121\u0122\3\2"+
		"\2\2\u0122\u0124\3\2\2\2\u0123\u0121\3\2\2\2\u0124\u0125\7 \2\2\u0125"+
		"%\3\2\2\2\u0126\u0127\7\37\2\2\u0127\u012d\b\24\1\2\u0128\u0129\5 \21"+
		"\2\u0129\u012a\b\24\1\2\u012a\u012c\3\2\2\2\u012b\u0128\3\2\2\2\u012c"+
		"\u012f\3\2\2\2\u012d\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u0130\3\2"+
		"\2\2\u012f\u012d\3\2\2\2\u0130\u0135\7 \2\2\u0131\u0132\5 \21\2\u0132"+
		"\u0133\b\24\1\2\u0133\u0135\3\2\2\2\u0134\u0126\3\2\2\2\u0134\u0131\3"+
		"\2\2\2\u0135\'\3\2\2\2\u0136\u0137\5*\26\2\u0137\u013e\b\25\1\2\u0138"+
		"\u0139\7\24\2\2\u0139\u013a\5*\26\2\u013a\u013b\b\25\1\2\u013b\u013d\3"+
		"\2\2\2\u013c\u0138\3\2\2\2\u013d\u0140\3\2\2\2\u013e\u013c\3\2\2\2\u013e"+
		"\u013f\3\2\2\2\u013f)\3\2\2\2\u0140\u013e\3\2\2\2\u0141\u0142\5,\27\2"+
		"\u0142\u0149\b\26\1\2\u0143\u0144\7\23\2\2\u0144\u0145\5,\27\2\u0145\u0146"+
		"\b\26\1\2\u0146\u0148\3\2\2\2\u0147\u0143\3\2\2\2\u0148\u014b\3\2\2\2"+
		"\u0149\u0147\3\2\2\2\u0149\u014a\3\2\2\2\u014a+\3\2\2\2\u014b\u0149\3"+
		"\2\2\2\u014c\u014d\5.\30\2\u014d\u0159\b\27\1\2\u014e\u014f\7\17\2\2\u014f"+
		"\u0153\b\27\1\2\u0150\u0151\7\20\2\2\u0151\u0153\b\27\1\2\u0152\u014e"+
		"\3\2\2\2\u0152\u0150\3\2\2\2\u0153\u0154\3\2\2\2\u0154\u0155\5.\30\2\u0155"+
		"\u0156\b\27\1\2\u0156\u0158\3\2\2\2\u0157\u0152\3\2\2\2\u0158\u015b\3"+
		"\2\2\2\u0159\u0157\3\2\2\2\u0159\u015a\3\2\2\2\u015a-\3\2\2\2\u015b\u0159"+
		"\3\2\2\2\u015c\u015d\5\60\31\2\u015d\u0169\b\30\1\2\u015e\u015f\7\21\2"+
		"\2\u015f\u0163\b\30\1\2\u0160\u0161\7\22\2\2\u0161\u0163\b\30\1\2\u0162"+
		"\u015e\3\2\2\2\u0162\u0160\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u0165\5\60"+
		"\31\2\u0165\u0166\b\30\1\2\u0166\u0168\3\2\2\2\u0167\u0162\3\2\2\2\u0168"+
		"\u016b\3\2\2\2\u0169\u0167\3\2\2\2\u0169\u016a\3\2\2\2\u016a/\3\2\2\2"+
		"\u016b\u0169\3\2\2\2\u016c\u016d\5\62\32\2\u016d\u0179\b\31\1\2\u016e"+
		"\u016f\7\13\2\2\u016f\u0173\b\31\1\2\u0170\u0171\7\f\2\2\u0171\u0173\b"+
		"\31\1\2\u0172\u016e\3\2\2\2\u0172\u0170\3\2\2\2\u0173\u0174\3\2\2\2\u0174"+
		"\u0175\5\62\32\2\u0175\u0176\b\31\1\2\u0176\u0178\3\2\2\2\u0177\u0172"+
		"\3\2\2\2\u0178\u017b\3\2\2\2\u0179\u0177\3\2\2\2\u0179\u017a\3\2\2\2\u017a"+
		"\61\3\2\2\2\u017b\u0179\3\2\2\2\u017c\u017d\5\64\33\2\u017d\u0189\b\32"+
		"\1\2\u017e\u017f\7\r\2\2\u017f\u0183\b\32\1\2\u0180\u0181\7\16\2\2\u0181"+
		"\u0183\b\32\1\2\u0182\u017e\3\2\2\2\u0182\u0180\3\2\2\2\u0183\u0184\3"+
		"\2\2\2\u0184\u0185\5\64\33\2\u0185\u0186\b\32\1\2\u0186\u0188\3\2\2\2"+
		"\u0187\u0182\3\2\2\2\u0188\u018b\3\2\2\2\u0189\u0187\3\2\2\2\u0189\u018a"+
		"\3\2\2\2\u018a\63\3\2\2\2\u018b\u0189\3\2\2\2\u018c\u018d\7\25\2\2\u018d"+
		"\u0191\b\33\1\2\u018e\u018f\7\f\2\2\u018f\u0191\b\33\1\2\u0190\u018c\3"+
		"\2\2\2\u0190\u018e\3\2\2\2\u0191\u0192\3\2\2\2\u0192\u0193\5\64\33\2\u0193"+
		"\u0194\b\33\1\2\u0194\u0199\3\2\2\2\u0195\u0196\5\66\34\2\u0196\u0197"+
		"\b\33\1\2\u0197\u0199\3\2\2\2\u0198\u0190\3\2\2\2\u0198\u0195\3\2\2\2"+
		"\u0199\65\3\2\2\2\u019a\u019b\58\35\2\u019b\u01a2\b\34\1\2\u019c\u019d"+
		"\7\26\2\2\u019d\u019e\58\35\2\u019e\u019f\b\34\1\2\u019f\u01a1\3\2\2\2"+
		"\u01a0\u019c\3\2\2\2\u01a1\u01a4\3\2\2\2\u01a2\u01a0\3\2\2\2\u01a2\u01a3"+
		"\3\2\2\2\u01a3\67\3\2\2\2\u01a4\u01a2\3\2\2\2\u01a5\u01a6\5:\36\2\u01a6"+
		"\u01ae\b\35\1\2\u01a7\u01a8\7\33\2\2\u01a8\u01a9\5\20\t\2\u01a9\u01aa"+
		"\b\35\1\2\u01aa\u01ab\7\34\2\2\u01ab\u01ad\3\2\2\2\u01ac\u01a7\3\2\2\2"+
		"\u01ad\u01b0\3\2\2\2\u01ae\u01ac\3\2\2\2\u01ae\u01af\3\2\2\2\u01af\u01b8"+
		"\3\2\2\2\u01b0\u01ae\3\2\2\2\u01b1\u01b2\7\35\2\2\u01b2\u01b3\5(\25\2"+
		"\u01b3\u01b4\b\35\1\2\u01b4\u01b5\7\36\2\2\u01b5\u01b7\3\2\2\2\u01b6\u01b1"+
		"\3\2\2\2\u01b7\u01ba\3\2\2\2\u01b8\u01b6\3\2\2\2\u01b8\u01b9\3\2\2\2\u01b9"+
		"\u01c0\3\2\2\2\u01ba\u01b8\3\2\2\2\u01bb\u01bc\5> \2\u01bc\u01bd\b\35"+
		"\1\2\u01bd\u01bf\3\2\2\2\u01be\u01bb\3\2\2\2\u01bf\u01c2\3\2\2\2\u01c0"+
		"\u01be\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c19\3\2\2\2\u01c2\u01c0\3\2\2\2"+
		"\u01c3\u01c4\5@!\2\u01c4\u01c5\b\36\1\2\u01c5\u01d2\3\2\2\2\u01c6\u01c7"+
		"\5H%\2\u01c7\u01c8\b\36\1\2\u01c8\u01d2\3\2\2\2\u01c9\u01ca\5<\37\2\u01ca"+
		"\u01cb\b\36\1\2\u01cb\u01d2\3\2\2\2\u01cc\u01cd\7\33\2\2\u01cd\u01ce\5"+
		"(\25\2\u01ce\u01cf\7\34\2\2\u01cf\u01d0\b\36\1\2\u01d0\u01d2\3\2\2\2\u01d1"+
		"\u01c3\3\2\2\2\u01d1\u01c6\3\2\2\2\u01d1\u01c9\3\2\2\2\u01d1\u01cc\3\2"+
		"\2\2\u01d2;\3\2\2\2\u01d3\u01d4\5\b\5\2\u01d4\u01d5\b\37\1\2\u01d5\u01d6"+
		"\7\31\2\2\u01d6\u01d7\5$\23\2\u01d7\u01d8\b\37\1\2\u01d8=\3\2\2\2\u01d9"+
		"\u01da\7\"\2\2\u01da\u01db\7\5\2\2\u01db\u01dc\b \1\2\u01dc?\3\2\2\2\u01dd"+
		"\u01de\5D#\2\u01de\u01df\b!\1\2\u01df\u01e8\3\2\2\2\u01e0\u01e1\7\'\2"+
		"\2\u01e1\u01e8\b!\1\2\u01e2\u01e3\7%\2\2\u01e3\u01e8\b!\1\2\u01e4\u01e5"+
		"\5B\"\2\u01e5\u01e6\b!\1\2\u01e6\u01e8\3\2\2\2\u01e7\u01dd\3\2\2\2\u01e7"+
		"\u01e0\3\2\2\2\u01e7\u01e2\3\2\2\2\u01e7\u01e4\3\2\2\2\u01e8A\3\2\2\2"+
		"\u01e9\u01ea\7\35\2\2\u01ea\u01eb\5\22\n\2\u01eb\u01ec\b\"\1\2\u01ec\u01ed"+
		"\7\36\2\2\u01edC\3\2\2\2\u01ee\u01ef\7\27\2\2\u01ef\u01f3\b#\1\2\u01f0"+
		"\u01f1\7\30\2\2\u01f1\u01f3\b#\1\2\u01f2\u01ee\3\2\2\2\u01f2\u01f0\3\2"+
		"\2\2\u01f3E\3\2\2\2\u01f4\u01f5\7\b\2\2\u01f5\u01f6\b$\1\2\u01f6G\3\2"+
		"\2\2\u01f7\u01f8\7&\2\2\u01f8\u01f9\b%\1\2\u01f9I\3\2\2\2*T^tw\u0081\u008c"+
		"\u0097\u00a6\u00b1\u00b4\u00c3\u00c6\u00d3\u00e1\u0100\u0108\u0111\u011a"+
		"\u0121\u012d\u0134\u013e\u0149\u0152\u0159\u0162\u0169\u0172\u0179\u0182"+
		"\u0189\u0190\u0198\u01a2\u01ae\u01b8\u01c0\u01d1\u01e7\u01f2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}