grammar UTL;

program: //Pattren Matching
    (
        functionDeclaration
        | patternMatching
    )*
    main;

functionDeclaration: //OK
    DEF IDENTIFIER
    functionArgumentsDeclaration
    body
    END
    ;

functionArgumentsDeclaration: //OK
    LPAR
    (IDENTIFIER
    (COMMA IDENTIFIER)*
    (
    COMMA LBRACK IDENTIFIER ASSIGN expression (COMMA IDENTIFIER ASSIGN expression)* RBRACK
    )?
    )? RPAR;

patternMatching:
    PATTERN IDENTIFIER LPAR IDENTIFIER RPAR
    (SEPARATOR condition ASSIGN expression)*
    SEMICOLLON;

main: //OK
    DEF MAIN
    LPAR RPAR
    body
    END;

functionCall: //OK
    identifier
    LPAR functionArguments RPAR;

functionArguments: //OK
    (expression (COMMA expression)* )?;


functionCallStatement: //OK
    functionCall SEMICOLLON;

returnStatement: //OK
    RETURN (expression)? SEMICOLLON;

ifStatement: //OK
    IF condition
    body
    (ELSEIF body)*
    (ELSE body)? END;

condition: //CLEAN
    (LPAR expression RPAR ((AND | OR) (LPAR)? condition (RPAR)?)*)*;

putsStatement: //OK
    PUTS LPAR expression
    RPAR SEMICOLLON;

lenStatement: //OK
    LEN LPAR expression
    RPAR SEMICOLLON;

pushStatement: //OK
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

range: //CLEAN
    (LPAR expression DOUBLEDOT expression RPAR)
    | (LBRACK (expression (COMMA expression)*) RBRACK)
    | IDENTIFIER;

filterStatement:
    LBRACK expression SEPARATOR IDENTIFIER ARROW range COMMA expression (COMMA expression)* RBRACK;

matchPatternStatement:
    IDENTIFIER DOT MATCH LPAR expression RPAR;

chopStatement:
    CHOP LPAR expression RPAR;

assignment:
    IDENTIFIER ASSIGN expression SEMICOLLON;

statement: //OK
    ifStatement
    | loopDoStatement
    | forStatement
    | putsStatement
    | lenStatement
    | pushStatement
    | functionCallStatement
    | returnStatement
    | expression
    | assignment
    ;


body: //OK
    (statement)*
    (
    returnStatement
    )?;

expression:
    relationalExpression
    ((EQUAL
    | NOT_EQUAL
    ) relationalExpression
    )*
    ;

relationalExpression:
    additiveExpression
    ((GREATER_THAN
    | LESS_THAN
    ) additiveExpression
    )*
    ;

additiveExpression:
    multiplicativeExpression
    ((PLUS
    | MINUS
    ) multiplicativeExpression
    )*
    ;

multiplicativeExpression:
    preUnaryExpression
    ((MULT
    |  DIVIDE
    ) preUnaryExpression
    )*;

preUnaryExpression:
    ((NOT
    | MINUS
    | INCREMENT
    | DECREMENT
    ) preUnaryExpression
    )
    | appendExpression
    ;

appendExpression: //???
    accessExpression
    (APPEND accessExpression
    )*
    ;

accessExpression: //???
    otherExpression
    (LPAR functionArguments
    RPAR)*
    (LBRACK expression
    RBRACK)*
    ;

otherExpression:
    values
    | identifier
    | lambdaFunction
    | chopStatement
    | matchPatternStatement
    | filterStatement
    | LPAR (expression) RPAR
    ;

lambdaFunction: //OK
    functionArgumentsDeclaration
    ARROW LBRACE body RBRACE functionArguments SEMICOLLON
    ;


values:
    boolValue
    | STRING_VALUE
    | INT_VALUE
    | FLOAT_VALUE
    | listValue;

listValue:
    LBRACK functionArguments
    RBRACK
    ;

boolValue:
    TRUE
    | FALSE
    ;


identifier:
    IDENTIFIER
    ;


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
GREATER_THAN: '>';
LESS_THAN: '<';

AND: '&&';
OR: '||';
NOT: '!';
INCREMENT: '++';
DECREMENT: '--';

SEPARATOR: '|';
APPEND: '<<';

TRUE: 'true';
FALSE: 'false';

BREAK: 'break';
NEXT: 'next';

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
DOUBLEDOT: '..';
COLON: ':';
SEMICOLLON: ';';

INT_VALUE: '0' | [1-9][0-9]*;
FLOAT_VALUE: [0-9]* '.' [0-9]+;
IDENTIFIER: [a-zA-Z_][A-Za-z0-9_]*;
STRING_VALUE: '"'~["]*'"';
COMMENT: ('#' ~( '\r' | '\n')* | ('=begin' .*? '=end')) -> skip;
WS: ([ \t\n\r]) -> skip;