grammar FunctionCraft;



program returns [Program flProgram]:
    {
        $flProgram = new Program();
        $flProgram.setLine(1);
    }
    (
        f = functionDeclaration{$flProgram.addFunctionDeclaration($f.functionDeclarationRet);}
        | p = patternMatching{$flProgram.addPatternDeclaration($p.patternRet);}
    )*
    m = main{$flProgram.setMain($m.mainRet);};

functionDeclaration returns [FunctionDeclaration functionDeclarationRet]:
    {
        $functionDeclarationRet = new FunctionDeclaration();
    }
    def = DEF {$functionDeclarationRet.setLine($def.line);} id = IDENTIFIER {
        Identifier id_ = new Identifier($id.text);
        id_.setLine($id.line);
        $functionDeclarationRet.setFunctionName(id_);
    }
    f = functionArgumentsDeclaration {$functionDeclarationRet.setArgs($f.argRet);}
    b = body {$functionDeclarationRet.setBody($b.bodyRet);}
    END
    ;

functionArgumentsDeclaration returns [ArrayList<VarDeclaration> argRet]:
    {
        $argRet = new ArrayList<VarDeclaration>();
    }
    LPAR
    (id1 = IDENTIFIER
    {
        Identifier id_ = new Identifier(id1.text);
        id_.setLine($id1.line);
        VarDeclaration = newVarDec(id_);
        $argRet.add(newVarDec);
    }
    (COMMA id2 = IDENTIFIER
        {
            Identifier id_ = new Identifier(id2.text);
            id_.setLine($id2.line);
            VarDeclaration = newVarDec(id_);
            $argRet.add(newVarDec);
        }
    )*
    (
    COMMA LBRACK id3 = IDENTIFIER
     {
        Identifier id_ = new Identifier(id3.text);
        id_.setLine($id3.line);
        VarDeclaration = newVarDec(id_);
     }
     ASSIGN e1 = expression
      {
        newVarDec.setDefaultVal(e1.expRet);
        $argRet.add(newVarDec);
      }
      (COMMA id4 = IDENTIFIER
       {
            Identifier id_ = new Identifier(id4.text);
            id_.setLine($id4.line);
            VarDeclaration = newVarDec(id_);
       }
       ASSIGN e2 = expression
       {
            newVarDec.setDefaultVal(e2.expRet);
            $argRet.add(newVarDec);
       }
       )* RBRACK
    )?
    )? RPAR;

patternMatching returns [PatternDeclaration patternRet]:
    pat = PATTERN
    {
        int patternLine = $pat.line;
    }
    patternName = IDENTIFIER
    {
        Identifier patternNameId = new Identifier($patternName.text);
        patternNameId.setLine($patternName.line);
    }
    LPAR targetVar = IDENTIFIER
    {
        Identifier targetVariable = new Identifier($targetVar.text);
        targetVariable.setLine($targetVar.line);
        $patternRet = new PatternDeclaration(patternNameId, targetVariable);
        $patternRet.setLine(patternLine);
    }
    RPAR
    (PATTERN_MATCHING_SEPARATOR c = condition
     {
        $patternRet.setConditions($c.conditionRet);
     }
     ASSIGN e = expression
     {
        $patternRet.addReturnExp($e.expRet);
     }
     )*
    SEMICOLLON;

main returns [MainDeclaration mainRet]:
    {
        $mainRet = new MainDeclaration();
    }
    DEF m = MAIN
    {
        $mainRet.setLine($m.line);
    }
    LPAR RPAR
    b = body
    {$mainRet.setBody($b.bodyRet);}
    END;

functionArguments returns [ArrayList<Expression> funcArgsRet]:
    {
        $funcArgsRet = new ArrayList<Expression>();
    }
    (e1 = expression
    {
       $funcArgsRet.add($e1.expRet);
    }
    (COMMA e2 = expression
    {
       $funcArgsRet.add($e2.expRet);
    }
    )* )?;


returnStatement returns [ReturnStatement returnStmtRet]:
    {
        $returnStmtRet = new ReturnStatement();
    }
    RETURN (e = expression{$returnStmtRet.setReturnExp(e.expRet);})? SEMICOLLON;

ifStatement returns[IfStatement ifRet]:
    {
        $ifRet = new IfStatement();
    }
    if = IF
    {
        $ifRet.setLine($if.line);
    }
    c1 = condition {$ifRet.addCondition($c1.conditionRet);}
    b = body {$ifRet.setThenBody($b.bodyRet);}
    {
        ArrayList<Statement> tempArray = new ArrayList<Statement>();
    }
    (ELSEIF c2 = condition
     {
        $ifRet.addCondition($c2.conditionRet);
     }
     b1 = body
     {
        tempArray.addAll($b1.bodyRet);
     }
     )*
    (ELSE b2 = body
     {
        tempArray.addAll($b2.bodyRet);
     }
    )?
     {
        $ifRet.setElseBody(tempArray);
     }
     END;

condition returns [ArrayList<Expression> conditionRet]:
    {
        $conditionRet = new ArrayList<Expression>();
    }
    (LPAR e = expression
     {$conditionRet.add($e.expRet);}
     RPAR ((AND | OR) (LPAR)? c = condition
     {
        $conditionRet.addAll($c.conditionRet);
     }
     (RPAR)?)*)*;

putsStatement returns [PutStatement putRet]:
    p = PUTS LPAR e = expression
    {
        $putRet = new PutStatement($e.expRet);
        $putRet.setLine($p.line);
    }
    RPAR SEMICOLLON;

lenStatement returns [LenStatement lenRet]:
    l = LEN LPAR e = expression
    {
        $lenRet = new LenStatement($e.expRet);
        $lenRet.setLine($l.line);
    }
    RPAR;

pushStatement returns [PushStatement pushRet]:
    p = PUSH LPAR e1 = expression COMMA e2 = expression RPAR SEMICOLLON
    {
        $pushRet = new PushStatement($e1.expRet, $e2.expRet);
        $pushRet.setLine($p.line);
    }
    ;

loopDoStatement returns [LoopDoStatement loopDoRet]:
    l1 = LOOP DO
    l2 = loopBody
    {
        $loopDoRet = new LoopDoStatement(l2.loopStmts, l2.loopExps, l2.loopRetStmt);
        $loopDoRet.setLine($l1.line);
    }
    END;

loopBody returns [ArrayList<Statement> loopStmts, ArrayList<Expression> loopExps, ReturnStatement loopRetStmt]:
    {
        $loopStmts = new ArrayList<Statement>();
        $loopExps = new ArrayList<Expression>();
        $loopRetStmt = new ReturnStatement();
    }
    (s = statement {$loopStmts.add($s.stmtRet);}
    | BREAK (IF c1 = condition{$loopExps.addAll($c1.conditionRet);})? SEMICOLLON
    | NEXT (IF c2 = condition{$loopExps.addAll($c2.conditionRet);})? SEMICOLLON
    )*
    (
    r = returnStatement {$loopRetStmt = $r.returnStmtRet;}
    )?;

forStatement returns [ForStatement forStRet]:
    f = FOR id = IDENTIFIER IN r = range
    l = loopBody
    END
    {
        $forStRet = new ForStatement(new Identifier($id.text),
                                     $r.rangeRet, $l.loopExps, $l.loopStmts,
                                     $l.loopRetStmt);
        $forStRet.setLine($f.line);
    }
    ;

range returns [ArrayList<Expression> rangeRet]:
    {
        $rangeRet = new ArrayList<Expression>();
    }
    (LPAR e1 = expression
    {
        $rangeRet.add($e1.expRet);
    }
    DOUBLEDOT e2 = expression
    {
        $rangeRet.add($e2.expRet);
    }
    RPAR)
    | (LBRACK (e3 = expression
    {
        $rangeRet.add($e3.expRet);
    }
    (COMMA e4 = expression
    {
        $rangeRet.add($e4.expRet);
    }
    )*) RBRACK)
    | id = IDENTIFIER
    {
        Identifier id_ = new Identifier($id.text);
        $rangeRet.add(id_);
    }
    ;

filterStatement returns [FilterStatement filterStatementRet]:
    {
        ArrayList<Expression> conditionExps = new ArrayList<Expression>();
    }
    brack = LBRACK e1 = expression SEPARATOR id = IDENTIFIER
    ARROW r = range COMMA e2 = expression
    {
        conditionExps.add($e2.expRet);
    }
    (COMMA e3 = expression
    {
        conditionExps.add($e3.expRet);
    }
    )*
    {
        Identifier id_ = new Identifier($id.text);
        id_.setLine($id.line);
        $filterStatementRet = new FilterStatement(id_, $e1.expRet,
                                                  conditionExps, $r.rangeRet);
        $filterStatementRet.setLine($brack.line);
    }
    RBRACK;

matchPatternStatement returns [MatchPatternStatement matchPatRet]:
    id = IDENTIFIER DOT m = MATCH LPAR e = expression RPAR
    {
        Identifier id_ = new Identifier($id.text);
        $matchPatRet = new MatchPatternStatement(id_, $e.expRet);
        $matchPatRet.setLine($m.line);
    }
    ;

chopStatement returns [ChopStatement chopRet]:

    c = CHOP LPAR e = expression RPAR
    {
        $chopRet = new ChopStatement($e.expRet);
        $chopRet.setLine($c.line);
    }
    ;
chompStatement returns [ChompStatement chompRet]:
    c = CHOMP LPAR e = expression RPAR
    {
        $chompRet = new ChompStatement($e.expRet);
        $chompRet.setLine($c.line);
    }
    ;

assignment returns [AssignStatement assignRet]:
    {
        boolean access = false;
        int line;
        AssignOperator op;
    }
    id = IDENTIFIER (a = accessList {access = true;})?
    (as = ASSIGN {op = AssignOperator.ASSIGN;line = $as.line;}
    | pl = PLUS_ASSIGN {op = AssignOperator.PLUS_ASSIGN;line = $pl.line;}
    | mi = MINUS_ASSIGN {op = AssignOperator.MINUS_ASSIGN;line = $mi.line;}
    | di = DIVIDE_ASSIGN {op = AssignOperator.DIVIDE_ASSIGN;line = $di.line;}
    | mu = MULT_ASSIGN {op = AssignOperator.MULT_ASSIGN;line = $mu.line;}
    | mo = MOD_ASSIGN {op = AssignOperator.MOD_ASSIGN;line = $mo.line;})
     e = expression SEMICOLLON
     {
          Identifier id_ = new Identifier($id.text);
          id_.setLine($id.line);
          $assignRet = new AssignStatement(access, id_, $e.expRet, op);
          if(access){
            $assignRet.setAccessListExpression($a.accessListExp);
          }
          $assignRet.setLine(line);
     };

accessList returns [Expression accessListExp]:
    LBRACK e = expression {$accessListExp = $e.expRet;} RBRACK;

statement returns [Statement stmtRet]:
    if = ifStatement {$stmtRet = $if.ifRet;}
    | loop = loopDoStatement {$stmtRet = $loop.loopDoRet;}
    | for = forStatement {$stmtRet = $for.forStRet;}
    | puts = putsStatement {$stmtRet = $puts.putRet;}
    | push = pushStatement {$stmtRet = $push.pushRet;}
    | e = expression
     {
        ExpressionStatement expStmt = new ExpressionStatement($e.expRet);
        $stmtRet = expStmt;
        $stmtRet.setLine($e.expRet.getLine());
     }
     SEMICOLLON
    | as = assignment {$stmtRet = $as.assignRet;}
    ;


body returns [ArrayList<Statement> bodyRet]:
    {
        $bodyRet = new ArrayList<Statement>();
    }
    (s = statement {$bodyRet.add($s.stmtRet);})*
    (
    r = returnStatement {$bodyRet.add($r.returnStmtRet);}
    )?;


expression returns [Expression expRet]:
    e1 = expression a = APPEND e2 = eqaulityExpression
    {
        if(!($e1.expRet instanceof AppendExpression)){
            $expRet = new AppendExpression($e1.expRet);
            $expRet.setLine($a.line);
        }
        else{
            $e1.expRet.addAppendedExpression($e2.expRet)
            $expRet = $e1.expRet;
        }
    }
    | e3 = eqaulityExpression {$expRet = $e3.expRet;};


eqaulityExpression returns [Expression expRet]:
    {
        BinaryOperator op;
    }
    e1 = eqaulityExpression
    (op1 = EQUAL {op = BinaryOperator.EQUAL;}
    | op2 = NOT_EQUAL {op = BinaryOperator.NOT_EQUAL;}
    ) r1 = relationalExpression {$expRet = new BinaryExpression($e1.expRet, $r1.expRet, op);}
    | r2 = relationalExpression {$expRet = $r2.expRet;};

relationalExpression returns [Expression expRet]:
    {
        BinaryOperator op;
    }
    r1 = relationalExpression
    (op = GREATER_THAN {op = BinaryOperator.GREATER_THAN;}
    | LESS_THAN {op = BinaryOperator.LESS_THAN;}
    | LESS_EQUAL_THAN {op = BinaryOperator.LESS_EQUAL_THAN;}
    | GREATER_EQUAL_THAN {op = BinaryOperator.GREATER_EQUAL_THAN;}
    ) a1 = additiveExpression {$expRet = new BinaryExpression($r1.expRet, $a1.expRet, op);}
    | a2 = additiveExpression {$expRet = $a2.expRet;};


additiveExpression returns [Expression expRet]:
    {
        BinaryOperator op;
    }
    a1 = additiveExpression
    (PLUS {op = BinaryOperator.PLUS;}
    | MINUS {op = BinaryOperator.MINUS;}
    ) m1 = multiplicativeExpression {$expRet = new BinaryExpression($a1.expRet, $m1.expRet, op);}
    | m2 = multiplicativeExpression
    {
        $expRet = $m2.expRet;
    }
    ;


multiplicativeExpression:
    multiplicativeExpression
    (op = MULT
    | op = DIVIDE
    ) preUnaryExpression
    | preUnaryExpression;


preUnaryExpression:
    (op = NOT
    | op = MINUS
    | op = INCREMENT
    | op = DECREMENT
    ) accessExpression
    | accessExpression;


accessExpression:
    otherExpression
    (LPAR functionArguments
    RPAR)*
    (accessList)*
    ;

otherExpression:
    values
    | IDENTIFIER
    | lambdaFunction
    | chopStatement
    |chompStatement
    | matchPatternStatement
    | filterStatement
    | lenStatement//move len to expression
    | LPAR (expression)? RPAR;



lambdaFunction:
    ARROW  functionArgumentsDeclaration
     LBRACE body RBRACE functionArguments
    ;


values:
    boolValue
    | STRING_VALUE
    | INT_VALUE
    | FLOAT_VALUE
    | listValue
    | functionPointer;

listValue:
    LBRACK functionArguments
    RBRACK
    ;

boolValue:
    TRUE
    | FALSE
    ;

functionPointer:
    METHOD LPAR COLON IDENTIFIER RPAR;


DEF: 'def';
END: 'end';
MAIN: 'main';

PUTS: 'puts';
PUSH: 'push';
LEN: 'len';
RETURN: 'return';

IF: 'if';
ELSE: 'else';
ELSEIF: 'elseif';

METHOD: 'method';

PATTERN: 'pattern';
MATCH: 'match';
LOOP: 'loop';
FOR: 'for';
IN: 'in';
DO: 'do';

CHOP: 'chop';
CHOMP: 'chomp';

PLUS: '+';
MINUS: '-';
MULT: '*';
DIVIDE: '/';

EQUAL: '==';
NOT_EQUAL: '!=';
LESS_EQUAL_THAN: '<=';
GREATER_EQUAL_THAN: '>=';
GREATER_THAN: '>';
LESS_THAN: '<';

AND: '&&';
OR: '||';
NOT: '!';
INCREMENT: '++';
DECREMENT: '--';

PATTERN_MATCHING_SEPARATOR: '    |';
SEPARATOR: '|';
APPEND: '<<';

TRUE: 'true';
FALSE: 'false';

BREAK: 'break';
NEXT: 'next';

ARROW: '->';

PLUS_ASSIGN: '+=';
MINUS_ASSIGN: '-=';
MULT_ASSIGN: '*=';
DIVIDE_ASSIGN: '/=';
MOD_ASSIGN: '%=';
ASSIGN: '=';

LPAR: '(';
RPAR: ')';
LBRACK: '[';
RBRACK: ']';
LBRACE: '{';
RBRACE: '}';

COMMA: ',';
DOT: '.';
DOUBLEDOT: '..';
COLON: ':';
SEMICOLLON: ';';

INT_VALUE: '0' | [1-9][0-9]*;
FLOAT_VALUE: [0-9]* '.' [0-9]+;
IDENTIFIER: [a-zA-Z_][A-Za-z0-9_]*;
STRING_VALUE: '"'~["]*'"';
COMMENT: ('#' ~( '\r' | '\n')* | ('=begin' .*? '=end')) -> skip;
WS: ([ \t\n\r]) -> skip;