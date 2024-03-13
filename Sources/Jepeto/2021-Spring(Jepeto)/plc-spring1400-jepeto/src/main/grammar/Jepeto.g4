grammar Jepeto;

@header{
     import main.ast.nodes.*;
     import main.ast.nodes.declaration.*;
     import main.ast.nodes.expression.*;
     import main.ast.nodes.expression.operators.*;
     import main.ast.nodes.expression.values.*;
     import main.ast.nodes.expression.values.primitive.*;
     import main.ast.nodes.statement.*;
     import java.util.*;
 }

jepeto returns [Program jepetoProgram] :
    p = program
    {$jepetoProgram = $p.programRet;}
    EOF;

program returns [Program programRet] :
    {$programRet = new Program();
     $programRet.setLine(1);}
    (f1 = functionDeclaration
    {$programRet.addFunction($f1.funcDecRet);}
    )*
    m = main
    {$programRet.setMain($m.mainRet);}
    (f2 = functionDeclaration
    {$programRet.addFunction($f2.funcDecRet);}
    )*;

functionDeclaration returns [FunctionDeclaration funcDecRet] :
    {$funcDecRet = new FunctionDeclaration();}
    func = FUNC
    {$funcDecRet.setLine($func.getLine());}
    id = identifier
    {$funcDecRet.setFunctionName($id.idRet);}
    args = functionArgumentsDeclaration
    {$funcDecRet.setArgs($args.argsRet);}
    COLON  st = body
    {$funcDecRet.setBody($st.stmt);};

functionArgumentsDeclaration returns [ArrayList<Identifier> argsRet, int line] :
    {$argsRet = new ArrayList<>();}
    par = LPAR
    {$line = $par.getLine();}
    (id1 = identifier
    {$argsRet.add($id1.idRet);}
    (COMMA id2 = identifier
    {$argsRet.add($id2.idRet);}
    )*)? RPAR ;


body returns [Statement stmt]:
    st1 = singleStatement
    {$stmt = $st1.stmt;}
    | st2 = block
    {$stmt = $st2.stmt;}
    ;

main returns [MainDeclaration mainRet] :
    {$mainRet = new MainDeclaration();}
    m= MAIN
    {$mainRet.setLine($m.getLine());}
    COLON (f = functionCallStatement
    {$mainRet.setBody($f.stmt);}
    | p = printStatement
    {$mainRet.setBody($p.stmt);}
    )? ;

functionCall returns [FunctionCall fcallRet]
    locals [Expression expr]:
    id = identifier
    {$expr = $id.idRet;}
    (lpar = LPAR f = functionArguments
    {FunctionCall fcall = new FunctionCall($expr, $f.funcArgRet, $f.funcArgWithKeyRet);
     fcall.setLine($lpar.getLine());
     $expr = fcall;}
    RPAR)*
    par = LPAR farg = functionArguments
    {$fcallRet = new FunctionCall($expr, $farg.funcArgRet, $farg.funcArgWithKeyRet);
     $fcallRet.setLine($par.getLine());}
    RPAR;

functionArguments returns [ArrayList<Expression> funcArgRet, Map<Identifier, Expression> funcArgWithKeyRet]:
    {$funcArgRet = new ArrayList<>();
     $funcArgWithKeyRet = new HashMap<>();}
    s1 = splitedExpressionsWithComma
    {$funcArgRet = $s1.arguments;}
    | s2 = splitedExpressionsWithCommaAndKey
    {$funcArgWithKeyRet = $s2.arguments;}
    ;

splitedExpressionsWithComma returns [ArrayList<Expression> arguments] :
    {$arguments = new ArrayList<>();}
    (e1 = expression
    {$arguments.add($e1.expr);}
    (COMMA e2 = expression
    {$arguments.add($e2.expr);}
    )*)?;

splitedExpressionsWithCommaAndKey returns [Map<Identifier, Expression> arguments] :
    {$arguments = new LinkedHashMap<>();}
    (id1 = identifier ASSIGN e1 = expression
    {$arguments.put($id1.idRet, $e1.expr);}
    (COMMA  id2 = identifier ASSIGN e2 = expression
    {$arguments.put($id2.idRet, $e2.expr);}
    )*)?;

functionCallStatement returns [FunctionCallStmt stmt] :
    f = functionCall
    {$stmt = new FunctionCallStmt($f.fcallRet);
     $stmt.setLine($f.fcallRet.getLine());}
    SEMICOLLON;

returnStatement returns [ReturnStmt stmt]:
    {$stmt = new ReturnStmt();}
    ret = RETURN
    {$stmt.setLine($ret.getLine());}
    (e = expression
    {$stmt.setReturnedExpr($e.expr);}
    | v = voidValue
    {$stmt.setReturnedExpr($v.val);}
    ) SEMICOLLON;

ifStatement returns [ConditionalStmt stmt] :
    iff = IF cond = expression COLON then = conditionBody
    {$stmt = new ConditionalStmt($cond.expr, $then.stmt);
     $stmt.setLine($iff.getLine());}
    (ELSE COLON elseSt = conditionBody
    {$stmt.setElseBody($elseSt.stmt);}
    )?;

ifStatementWithReturn returns [ConditionalStmt stmt]:
    iff = IF cond = expression COLON st1 = body
    {$stmt = new ConditionalStmt($cond.expr, $st1.stmt);
     $stmt.setLine($iff.getLine());}
    ELSE COLON st2 = body
    {$stmt.setElseBody($st2.stmt);}
    ;

printStatement returns [PrintStmt stmt]:
    pr = PRINT LPAR e = expression
    {$stmt = new PrintStmt($e.expr);
     $stmt.setLine($pr.getLine());}
    RPAR SEMICOLLON;

statement returns [Statement stmt]:
    s1 = ifStatement
    {$stmt = $s1.stmt;}
    | s2 = printStatement
    {$stmt = $s2.stmt;}
    | s3 = functionCallStatement
    {$stmt = $s3.stmt;}
    | s4 = returnStatement
    {$stmt = $s4.stmt;}
    ;

singleStatement returns [Statement stmt]:
    st1 = returnStatement
    {$stmt = $st1.stmt;}
    | st2 = ifStatementWithReturn
    {$stmt = $st2.stmt;}
    ;

block returns [BlockStmt stmt]:
    {$stmt = new BlockStmt();}
    lb = LBRACE
    {$stmt.setLine($lb.getLine());}
    ((st1 = statement
    {$stmt.addStatement($st1.stmt);}
    )*
    (st2 = returnStatement
    {$stmt.addStatement($st2.stmt);}
    | st3 = ifStatementWithReturn
    {$stmt.addStatement($st3.stmt);}
    ) (st4 = statement
    {$stmt.addStatement($st4.stmt);}
    )*) RBRACE;

conditionBody returns [Statement stmt]:
    {BlockStmt blst = new BlockStmt();}
    lb = LBRACE
    {blst.setLine($lb.getLine());}
    (st = statement
    {blst.addStatement($st.stmt);}
    )* RBRACE
    {$stmt = blst;}
    | st2 = statement
    {$stmt = $st2.stmt;}
    ;

expression returns [Expression expr]:
    l = andExpression
    {$expr = $l.expr;}
    (op = OR r = andExpression
    {$expr = new BinaryExpression($expr,$r.expr,BinaryOperator.or);
     $expr.setLine($op.getLine());}
    )*;

andExpression returns [Expression expr]:
    l = equalityExpression
    {$expr = $l.expr;}
    (op = AND r = equalityExpression
    {$expr = new BinaryExpression($expr,$r.expr,BinaryOperator.and);
     $expr.setLine($op.getLine());}
    )*;

equalityExpression returns [Expression expr]
    locals[BinaryOperator op, int line]:
    l = relationalExpression
    {$expr = $l.expr;}
    ((op1 = EQUAL
    {$op = BinaryOperator.eq;
     $line = $op1.getLine();}
    | op2 = NOT_EQUAL
    {$op = BinaryOperator.neq;
     $line = $op2.getLine();}
    ) r = relationalExpression
    {$expr = new BinaryExpression($expr,$r.expr,$op);
     $expr.setLine($line);}
    )*;

relationalExpression returns [Expression expr]
    locals [BinaryOperator op, int line]:
    l = additiveExpression
    {$expr = $l.expr;}
    ((op1 = GREATER_THAN
    {$op = BinaryOperator.gt;
    $line = $op1.getLine();}
    | op2 = LESS_THAN
    {$op = BinaryOperator.lt;
     $line = $op2.getLine();}
    ) r = additiveExpression
    {$expr = new BinaryExpression($expr,$r.expr,$op);
     $expr.setLine($line);}
    )*;

additiveExpression returns [Expression expr]
    locals [BinaryOperator op, int line]:
    l = multiplicativeExpression
    {$expr = $l.expr;}
    ((op1 = PLUS
    {$op = BinaryOperator.add;
     $line = $op1.getLine();}
    | op2 = MINUS
    {$op = BinaryOperator.sub;
     $line = $op2.getLine();}

    ) r = multiplicativeExpression
    {$expr = new BinaryExpression($expr,$r.expr,$op);
     $expr.setLine($line);}
    )*;

multiplicativeExpression returns [Expression expr]
    locals [BinaryOperator op, int line]:
    l = preUnaryExpression
    {$expr = $l.expr;}
    ((op1 = MULT
    {$op = BinaryOperator.mult;
     $line = $op1.getLine();}
    | op2 = DIVIDE
    {$op = BinaryOperator.div;
     $line = $op2.getLine();}
    ) r = preUnaryExpression
    {$expr = new BinaryExpression($expr,$r.expr,$op);
    $expr.setLine($line);}
    )*;

preUnaryExpression returns [Expression expr]
    locals[UnaryOperator op, int line]:
    ((op1 = NOT
    {$op = UnaryOperator.not;
     $line = $op1.getLine();}
    | op2 = MINUS
    {$op = UnaryOperator.minus;
     $line = $op2.getLine();}
    ) pre = preUnaryExpression
    {$expr = new UnaryExpression($pre.expr, $op);
     $expr.setLine($line);}
    ) | ap = appendExpression
    {$expr = $ap.expr;}
    ;

appendExpression returns [Expression expr]:
    l = accessExpression
    {$expr = $l.expr;}
    (op = APPEND r = accessExpression
    {$expr = new BinaryExpression($expr,$r.expr,BinaryOperator.append);
     $expr.setLine($op.getLine());}
    )*;

accessExpression returns [Expression expr] :
    other = otherExpression
    {$expr = $other.expr;}
    (par = LPAR f = functionArguments
     {FunctionCall fcall = new FunctionCall($expr, $f.funcArgRet, $f.funcArgWithKeyRet);
     fcall.setLine($par.getLine());
     $expr = fcall;}
     RPAR)*  (lb = LBRACK e = expression
     {ListAccessByIndex ac = new ListAccessByIndex($expr,$e.expr);
      ac.setLine($lb.getLine());
      $expr = ac;}
     RBRACK)* (se = sizeExpression
     {ListSize ls = new ListSize($expr);
      ls.setLine($se.line);
      $expr = ls;}
     )*;

otherExpression returns [Expression expr]:
    v = values
    {$expr = $v.val;}
    | id = identifier
    {$expr = $id.idRet;}
    | afunc = anonymousFunction
    {$expr = $afunc.expr;}
    | LPAR e = expression
    {$expr = $e.expr;}
    RPAR;

anonymousFunction returns [AnonymousFunction expr]:
    args = functionArgumentsDeclaration
    {$expr = new AnonymousFunction($args.argsRet);
     $expr.setLine($args.line);}
    ARROW b = block
    {$expr.setBody($b.stmt);}
    ;

sizeExpression returns [int line]:
    d = DOT
    {$line = $d.getLine();}
    SIZE;

values returns [Value val]:
    bv = boolValue
    {$val = $bv.val;}
    | str = STRING_VALUE
    {$val = new StringValue($str.text.replaceAll("^\"|\"$", ""));
     $val.setLine($str.getLine());}
    | iv = INT_VALUE
    {$val = new IntValue($iv.int);
     $val.setLine($iv.getLine());}
    | lv = listValue
    {$val = $lv.val;}
    ;

listValue returns [ListValue val]:
    lb = LBRACK sp = splitedExpressionsWithComma
    {$val = new ListValue($sp.arguments);
     $val.setLine($lb.getLine());}
    RBRACK;

boolValue returns [Value val]:
    t = TRUE
    {$val = new BoolValue(true);
     $val.setLine($t.getLine());}
    | f = FALSE
    {$val = new BoolValue(false);
     $val.setLine($f.getLine());}
    ;

voidValue returns [Value val]:
    v = VOID
    {$val = new VoidValue();
    $val.setLine($v.getLine());}
    ;

identifier returns [Identifier idRet]:
    id = IDENTIFIER
    {$idRet = new Identifier($id.text);
     $idRet.setLine($id.getLine());};

FUNC: 'func';
MAIN: 'main';
SIZE: 'size';

PRINT: 'print';
RETURN: 'return';
VOID: 'void';

IF: 'if';
ELSE: 'else';

PLUS: '+';
MINUS: '-';
MULT: '*';
DIVIDE: '/';

EQUAL: 'is';
NOT_EQUAL: 'not';
GREATER_THAN: '>';
LESS_THAN: '<';

AND: 'and';
OR: 'or';
NOT: '~';

APPEND: '::';

TRUE: 'true';
FALSE: 'false';

ARROW: '->';

ASSIGN: '=';

LPAR: '(';
RPAR: ')';
LBRACK: '[';
RBRACK: ']';
LBRACE: '{';
RBRACE: '}';

COMMA: ',';
DOT: '.';
COLON: ':';
SEMICOLLON: ';';

INT_VALUE: '0' | [1-9][0-9]*;
IDENTIFIER: [a-zA-Z_][A-Za-z0-9_]*;
STRING_VALUE: '"'~["]*'"';
COMMENT: ('#' ~( '\r' | '\n')*) -> skip;
WS: ([ \t\n\r]) -> skip;
