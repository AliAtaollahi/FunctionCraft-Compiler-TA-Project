grammar Jepeto;

@header{
    import main.ast.nodes.*;
    import main.ast.nodes.declaration.*;
    import main.ast.nodes.expression.*;
    import main.ast.nodes.expression.operators.*;
    import main.ast.nodes.expression.values.*;
    import main.ast.nodes.expression.values.primitive.*;
    import main.ast.nodes.statement.*;
}

jepeto returns [Program jepetoProgram]:
    p=program
    { $jepetoProgram = $p.programRet; }
    EOF;

program returns [Program programRet]:
    {
        $programRet = new Program();
        $programRet.setLine(1);
    }
    (
        fd=functionDeclaration
        { $programRet.addFunction($fd.functionDecRet); }
    )*
        m=main
        { $programRet.setMain($m.mainRet); }
    (
        fd2=functionDeclaration
        { $programRet.addFunction($fd2.functionDecRet); }
    )*
    ;

functionDeclaration returns [FunctionDeclaration functionDecRet]:
    f=FUNC name=IDENTIFIER
    {
        $functionDecRet = new FunctionDeclaration();
        Identifier idRet = new Identifier($name.text);
        idRet.setLine($f.getLine());
        $functionDecRet.setFunctionName(idRet);
        $functionDecRet.setLine($f.getLine());
    }
    args=functionArgumentsDeclaration
    { $functionDecRet.setArgs($args.argsRet); }
    COLON b=body
    { $functionDecRet.setBody($b.bodyRet); }
    ;

functionArgumentsDeclaration returns[ArrayList <Identifier> argsRet, int line]:
    { $argsRet = new ArrayList <>(); }
    l=LPAR
    { $line = $l.getLine(); }
    ( id=IDENTIFIER
    {
        Identifier idRet = new Identifier($id.text);
        $argsRet.add(idRet);
        idRet.setLine($id.getLine());
    }
    (COMMA id2=IDENTIFIER
    {
        Identifier idRet2 = new Identifier($id2.text);
        $argsRet.add(idRet2);
        idRet2.setLine($id2.getLine());
    }
    )*
    )? RPAR
    ;

body returns[Statement bodyRet]:
    s1=singleStatement
    { $bodyRet = $s1.singleSRet; }
    | s2=block
    { $bodyRet = $s2.blockRet; }
    ;

main returns[MainDeclaration mainRet]:
    m=MAIN
    {
        $mainRet = new MainDeclaration();
        $mainRet.setLine($m.getLine());
    }
    COLON (f=functionCallStatement
    { $mainRet.setBody($f.functionCallStmtRet); }
    | p=printStatement
    { $mainRet.setBody($p.printStmtRet); }
    )
    ;



functionCall returns[FunctionCall funcCallRet, int line]:
    id=identifier
    {Expression instance = $id.idRet;}
    (l=LPAR f1=functionArguments
    {
         $funcCallRet = new FunctionCall(instance, $f1.argsRet, $f1.argsWithKeyRet);
         instance = $funcCallRet;
         $line = $l.getLine();
         $funcCallRet.setLine($line);
    }
    RPAR)*
    (l2=LPAR f2=functionArguments
    {
        $line = $l2.getLine();
        $funcCallRet = new FunctionCall(instance, $f2.argsRet, $f2.argsWithKeyRet);
        $funcCallRet.setLine($line);
    }
    RPAR);

functionArguments returns[ArrayList <Expression> argsRet, Map<Identifier, Expression> argsWithKeyRet]:
    {
        $argsRet = new ArrayList <>();
        $argsWithKeyRet = new LinkedHashMap<>();
    }
    sc=splitedExpressionsWithComma
    {
        $argsRet = $sc.spltExpWthCommaRet;
    }
    | sk=splitedExpressionsWithCommaAndKey
    {
        $argsWithKeyRet = $sk.spltExpWthKeyRet;
    };

splitedExpressionsWithComma returns[ArrayList <Expression> spltExpWthCommaRet]:
    { $spltExpWthCommaRet = new ArrayList <>(); }
    (exp=expression
    { $spltExpWthCommaRet.add($exp.exprRet); }
    (COMMA exp2= expression
    { $spltExpWthCommaRet.add($exp2.exprRet); }
    )*
    )?
    ;

splitedExpressionsWithCommaAndKey returns[Map <Identifier, Expression> spltExpWthKeyRet]:
    { $spltExpWthKeyRet = new LinkedHashMap<>(); }
    (id=identifier ASSIGN exp=expression
    { $spltExpWthKeyRet.put($id.idRet,$exp.exprRet); }
    (COMMA  id2=identifier ASSIGN exp2=expression
    { $spltExpWthKeyRet.put($id2.idRet,$exp2.exprRet); }
    )*
    )?
    ;

functionCallStatement returns[Statement functionCallStmtRet]:
    fc=functionCall
    {
        $functionCallStmtRet = new FunctionCallStmt($fc.funcCallRet);
        $functionCallStmtRet.setLine($fc.line);
    }
    SEMICOLLON;

returnStatement returns[ReturnStmt returnStmtRet]:
    r=RETURN (exp=expression
    {
        $returnStmtRet = new ReturnStmt($exp.exprRet);
        $returnStmtRet.setLine($r.getLine());
    }
    | vd=voidValue
    {
      $returnStmtRet = new ReturnStmt($vd.voidValueRet);
      $returnStmtRet.setLine($r.getLine());
    }
    )
    SEMICOLLON;

ifStatement returns[ConditionalStmt ifStmtRet]:
    i=IF exp=expression COLON b=conditionBody
    {
        $ifStmtRet = new ConditionalStmt($exp.exprRet, $b.condBodyRet);
        $ifStmtRet.setLine($i.getLine());
    }
    (ELSE COLON elb=conditionBody
    { $ifStmtRet.setElseBody($elb.condBodyRet); }
    )?
    ;

ifStatementWithReturn returns[ConditionalStmt ifStmtWthRRet]:
    i=IF exp=expression COLON b=body
    {
        $ifStmtWthRRet = new ConditionalStmt($exp.exprRet, $b.bodyRet);
        $ifStmtWthRRet.setLine($i.getLine());
    }
    ELSE COLON elb=body
    { $ifStmtWthRRet.setElseBody($elb.bodyRet); }
    ;

printStatement returns[PrintStmt printStmtRet]:
    p=PRINT LPAR exp=expression
    {
        $printStmtRet = new PrintStmt($exp.exprRet);
        $printStmtRet.setLine($p.getLine());
    }
    RPAR SEMICOLLON
    ;

statement returns[Statement sRet]:
    s1=ifStatement
    { $sRet = $s1.ifStmtRet; }
    | s2=printStatement
    { $sRet = $s2.printStmtRet; }
    | s3=functionCallStatement
    { $sRet = $s3.functionCallStmtRet; }
    | s4=returnStatement
    { $sRet = $s4.returnStmtRet; }
    ;

singleStatement returns[Statement singleSRet]:
    s1=returnStatement
    { $singleSRet = $s1.returnStmtRet; }
    | s2=ifStatementWithReturn
    { $singleSRet = $s2.ifStmtWthRRet; }
    ;

block returns[BlockStmt blockRet]:
    l=LBRACE
    {
        $blockRet = new BlockStmt();
        $blockRet.setLine($l.getLine());
    }
    ((s=statement
    { $blockRet.addStatement($s.sRet); }
    )*
    (rs=returnStatement
    { $blockRet.addStatement($rs.returnStmtRet); }
    | is=ifStatementWithReturn
    { $blockRet.addStatement($is.ifStmtWthRRet); }
    )
    (s2=statement
    { $blockRet.addStatement($s2.sRet); }
    )*
    ) RBRACE;

conditionBody returns[Statement condBodyRet]:
    l=LBRACE
    {
      BlockStmt bc = new BlockStmt();
      $condBodyRet = bc;
      $condBodyRet.setLine($l.getLine());
    }
    (s=statement
    {
        bc.addStatement($s.sRet);
        $condBodyRet = bc;
        $condBodyRet.setLine($l.getLine());
    }
    )* RBRACE
    | s2=statement
    {
        $condBodyRet = $s2.sRet;
    }
    ;

expression returns[Expression exprRet]:
    ae1=andExpression
    { $exprRet = $ae1.andExprRet; }
    (o=OR ae2=andExpression
    {
         BinaryOperator op = BinaryOperator.or;
         $exprRet = new BinaryExpression($exprRet, $ae2.andExprRet, op);
         $exprRet.setLine($o.getLine());
    }
    )*
    ;

andExpression returns[Expression andExprRet]:
    e1=equalityExpression
    { $andExprRet = $e1.eqExprRet; }
    (a=AND e2=equalityExpression
    {
        BinaryOperator op = BinaryOperator.and;
        $andExprRet = new BinaryExpression($andExprRet, $e2.eqExprRet, op);
        $andExprRet.setLine($a.getLine());
    }
    )*
    ;

equalityExpression returns[Expression eqExprRet]
    locals[BinaryOperator op, int line]:
    r1=relationalExpression
    { $eqExprRet = $r1.relExprRet; }
    ((eq=EQUAL
    {
        $op = BinaryOperator.eq;
        $line = $eq.getLine();
    }
    | neq=NOT_EQUAL
    {
        $op = BinaryOperator.neq;
        $line = $neq.getLine();
    }
    ) r2=relationalExpression
    {
        $eqExprRet = new BinaryExpression($eqExprRet, $r2.relExprRet, $op);
        $eqExprRet.setLine($line);
    }
    )*
    ;

relationalExpression returns[Expression relExprRet]
    locals[BinaryOperator op, int line]:
    a1=additiveExpression
    { $relExprRet = $a1.addExprRet; }
    ((gt=GREATER_THAN
    {
        $op = BinaryOperator.gt;
        $line = $gt.getLine();
    }
    | lt=LESS_THAN
    {
        $op = BinaryOperator.lt;
        $line = $lt.getLine();
    }
    ) a2=additiveExpression
    {
        $relExprRet = new BinaryExpression($relExprRet, $a2.addExprRet, $op);
        $relExprRet.setLine($line);
    }
    )*
    ;

additiveExpression returns[Expression addExprRet]
    locals[BinaryOperator op, int line]:
    m1=multiplicativeExpression
    { $addExprRet = $m1.multExprRet; }
    ((add=PLUS
    {
        $op = BinaryOperator.add;
        $line = $add.getLine();
    }
    | sub=MINUS
    {
        $op = BinaryOperator.sub;
        $line = $sub.getLine();
    }
    ) m2=multiplicativeExpression
    {
        $addExprRet = new BinaryExpression($addExprRet, $m2.multExprRet, $op);
        $addExprRet.setLine($line);
    }
    )*
    ;

multiplicativeExpression returns[Expression multExprRet]
    locals[BinaryOperator op, int line]:
    p1=preUnaryExpression
    { $multExprRet = $p1.preUnaryExprRet; }
    ((mult=MULT
    {
        $op = BinaryOperator.mult;
        $line = $mult.getLine();
    }
    |  div=DIVIDE
    {
        $op = BinaryOperator.div;
        $line = $div.getLine();
    }
    ) p2=preUnaryExpression
    {
        $multExprRet = new BinaryExpression($multExprRet, $p2.preUnaryExprRet, $op);
        $multExprRet.setLine($line);
    }
    )*;

preUnaryExpression returns[Expression preUnaryExprRet]
    locals[UnaryOperator op, int line]:
    ((not=NOT
    {
        $op = UnaryOperator.not;
        $line = $not.getLine();
    }
    | minus=MINUS
    {
        $op = UnaryOperator.minus;
        $line = $minus.getLine();
    }
    ) p=preUnaryExpression
    {
        $preUnaryExprRet = new UnaryExpression($p.preUnaryExprRet, $op);
        $preUnaryExprRet.setLine($line);
    }
    )
    | a=appendExpression
    { $preUnaryExprRet = $a.appendExprRet; }
    ;

appendExpression returns[Expression appendExprRet]:
    a1=accessExpression
    { $appendExprRet = $a1.accessExprRet; }
    (app=APPEND a2=accessExpression
    {
        BinaryOperator op = BinaryOperator.append;
        $appendExprRet = new BinaryExpression($appendExprRet, $a2.accessExprRet, op);
        $appendExprRet.setLine($app.getLine());
    }
    )*
    ;

accessExpression returns[Expression accessExprRet]
    locals[Expression instance]:
    o=otherExpression
    {
        $instance = $o.otherExprRet;
        $accessExprRet =  $instance;
    }
    (l=LPAR fa=functionArguments
    {
        FunctionCall fc = new FunctionCall($instance);
        fc.setArgsWithKey($fa.argsWithKeyRet);
        fc.setArgs($fa.argsRet);
        $accessExprRet = fc;
        $instance = $accessExprRet;
        $accessExprRet.setLine($l.getLine());
    }
    RPAR)*
    (l=LBRACK index=expression
    {
        $accessExprRet = new ListAccessByIndex($instance, $index.exprRet);
        $accessExprRet.setLine($l.getLine());
        $instance = $accessExprRet;
    }
    RBRACK)*
    (s=sizeExpression
    {
        $accessExprRet = new ListSize($instance);
        $accessExprRet.setLine($s.line);
    }
    )*
    ;

otherExpression returns[Expression otherExprRet]:
    v=values
    { $otherExprRet = $v.valuesRet; }
    | id=identifier
    { $otherExprRet = $id.idRet; }
    | an=anonymousFunction
    { $otherExprRet = $an.anRet; }
    | LPAR (exp=expression) RPAR
    { $otherExprRet = $exp.exprRet; }
    ;

anonymousFunction returns[AnonymousFunction anRet]:
    args=functionArgumentsDeclaration
    {
        $anRet = new AnonymousFunction($args.argsRet);
        $anRet.setLine($args.line);
    }
    ARROW b=block
    {
        Statement bodyRet = $b.blockRet;
        $anRet.setBody(bodyRet);
    }
    ;

sizeExpression returns[int line]:
    DOT s=SIZE
    {
        $line = $s.getLine();
    }
;

values returns[Value valuesRet]:
    b=boolValue
    {
        $valuesRet = new BoolValue($b.boolValueRet);
        $valuesRet.setLine($b.line);
    }
    | s=STRING_VALUE
    {
        $valuesRet = new StringValue(($s.text).substring(1, ($s.text).length()-1));
        $valuesRet.setLine($s.getLine());
    }
    | i=INT_VALUE
    {
        $valuesRet = new IntValue($i.int);
        $valuesRet.setLine($i.getLine());
    }
    | l=listValue
    { $valuesRet = $l.listValueRet; }
    ;

listValue returns[ListValue listValueRet]:
    l=LBRACK s=splitedExpressionsWithComma
    {
        $listValueRet = new ListValue($s.spltExpWthCommaRet);
        $listValueRet.setLine($l.getLine());
    }
    RBRACK
    ;

boolValue returns[boolean boolValueRet, int line]:
    t=TRUE
    {
        $boolValueRet = true;
        $line = $t.getLine();
    }
    | f=FALSE
    {
        $boolValueRet = false;
        $line = $f.getLine();
    }
    ;

voidValue returns[VoidValue voidValueRet, int line]:
    v=VOID
    {
        $voidValueRet = new VoidValue();
        $voidValueRet.setLine($v.getLine());
        $line = $v.getLine();
    }
    ;

identifier returns[Identifier idRet, int line]:
    id=IDENTIFIER
    {
        $idRet = new Identifier($id.text);
        $idRet.setLine($id.getLine());
        $line = $id.getLine();
    }
    ;


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
