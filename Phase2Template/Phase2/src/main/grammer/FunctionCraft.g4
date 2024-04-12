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

filterStatement:
    LBRACK expression SEPARATOR IDENTIFIER
    ARROW range COMMA expression (COMMA expression)* RBRACK;

matchPatternStatement:
    IDENTIFIER DOT MATCH LPAR expression RPAR;

chopAndChompStatement:
    (CHOP
    | CHOMP) LPAR expression RPAR;

assignment:
    IDENTIFIER (accessList)?
    (ASSIGN
    | PLUS_ASSIGN
    | MINUS_ASSIGN
    | DIVIDE_ASSIGN
    | MULT_ASSIGN
    | MOD_ASSIGN)
     expression SEMICOLLON;

accessList:
    LBRACK expression RBRACK;

statement returns [Statement stmtRet]:
    ifStatement
    | loopDoStatement
    | forStatement
    | putsStatement
    | pushStatement
    | expression SEMICOLLON
    | assignment
    ;


body returns [ArrayList<Statement> bodyRet]:
    (statement)*
    (
    returnStatement
    )?;


expression returns [Expression expRet]:
    expression APPEND eqaulityExpression
    | eqaulityExpression;


eqaulityExpression:
    eqaulityExpression
    (op = EQUAL
    | op = NOT_EQUAL
    ) relationalExpression
    | relationalExpression;

relationalExpression:
    relationalExpression
    (op = GREATER_THAN
    | op = LESS_THAN
    | op = LESS_EQUAL_THAN
    | op = GREATER_EQUAL_THAN
    ) additiveExpression
    | additiveExpression;


additiveExpression:
    additiveExpression
    (op = PLUS
    | op = MINUS
    ) multiplicativeExpression
    | multiplicativeExpression;


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
    | chopAndChompStatement
    | matchPatternStatement
    | filterStatement
    | lenStatement
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