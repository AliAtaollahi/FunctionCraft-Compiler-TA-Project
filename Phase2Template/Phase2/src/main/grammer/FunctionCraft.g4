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

ifStatement:
    IF condition
    body
    (ELSEIF condition body)*
    (ELSE body)? END;

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

putsStatement:
    PUTS LPAR expression
    RPAR SEMICOLLON;

lenStatement:
    LEN LPAR expression RPAR;

pushStatement:
    PUSH LPAR expression COMMA expression RPAR SEMICOLLON;

loopDoStatement:
    LOOP DO
    loopBody
    END;

loopBody:
    (statement
    | BREAK (IF condition)? SEMICOLLON
    | NEXT (IF condition)? SEMICOLLON
    )*
    (
    returnStatement
    )?;

forStatement:
    FOR IDENTIFIER IN range
    loopBody
    END;

range:
    (LPAR expression DOUBLEDOT expression RPAR)
    | (LBRACK (expression (COMMA expression)*) RBRACK)
    | IDENTIFIER;

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

statement:
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