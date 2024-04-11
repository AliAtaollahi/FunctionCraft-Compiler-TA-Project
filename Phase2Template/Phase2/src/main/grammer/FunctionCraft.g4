grammar FunctionCraft;



program returns [Program flProgram]:
    {
        $flProgram = new Program();
        $flProgram.setLine(1);
    }
    (
        f = functionDeclaration{$flProgram.addFunctionDeclaration(f.functionDeclarationRet);}
        | p = patternMatching{$fl.Program.addPatternDeclaration(p.patternRet);}
    )*
    m = main{$flProgram.setMain(m.mainRet);};

functionDeclaration returns [FunctionDeclaration functionDeclarationRet]:
    DEF IDENTIFIER
    functionArgumentsDeclaration
    body
    END
    ;

functionArgumentsDeclaration:
    LPAR
    (IDENTIFIER
    (COMMA IDENTIFIER)*
    (
    COMMA LBRACK IDENTIFIER ASSIGN expression (COMMA IDENTIFIER ASSIGN expression)* RBRACK
    )?
    )? RPAR;

patternMatching returns [PatternDeclaration patternRet]:
    PATTERN IDENTIFIER
    LPAR IDENTIFIER RPAR
    (PATTERN_MATCHING_SEPARATOR condition ASSIGN expression)*
    SEMICOLLON;

main returns [MainDeclaration mainRet]:
    DEF MAIN
    LPAR RPAR
    body
    END;

functionArguments:
    (expression (COMMA expression)* )?;


returnStatement:
    RETURN (expression)? SEMICOLLON;

ifStatement:
    IF condition
    body
    (ELSEIF condition body)*
    (ELSE body)? END;

condition:
    (LPAR expression RPAR ((AND | OR) (LPAR)? condition (RPAR)?)*)*;

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


body:
    (statement)*
    (
    returnStatement
    )?;


expression:
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