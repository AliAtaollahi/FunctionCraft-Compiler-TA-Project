grammar FunctionCraft;

program:
    (
        functionDeclaration
        | patternMatching
    )*
    main;

functionDeclaration:
    DEF IDENTIFIER { System.out.println("FuncDec: " + $IDENTIFIER.text); }
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

patternMatching:
    PATTERN IDENTIFIER { System.out.println("PatternDec: " + $IDENTIFIER.text); }
    LPAR IDENTIFIER RPAR
    (SEPARATOR condition ASSIGN expression)*
    SEMICOLLON;

main:
    DEF MAIN { System.out.println("MAIN"); }
    LPAR RPAR
    body
    END;

functionArguments:
    (expression (COMMA expression)* )?;


returnStatement:
    RETURN { System.out.println("RETURN"); } (expression)? SEMICOLLON;

ifStatement:
    IF { System.out.println("Decision: IF"); } condition
    body
    (ELSEIF { System.out.println("Decision: ELSE IF"); } condition body)*
    (ELSE { System.out.println("Decision: ELSE"); } body)? END;

condition:
    (LPAR expression RPAR ((AND | OR) (LPAR)? condition (RPAR)?)*)*;

putsStatement:
    PUTS { System.out.println("Built-In: PUTS"); } LPAR expression
    RPAR SEMICOLLON;

lenStatement:
    LEN { System.out.println("Built-In: LEN"); } LPAR expression RPAR;

pushStatement:
    PUSH { System.out.println("Built-In: PUSH"); } LPAR expression COMMA expression RPAR SEMICOLLON;

loopDoStatement:
    LOOP DO { System.out.println("Loop: DO"); }
    loopBody
    END;

loopBody:
    (statement
    | BREAK { System.out.println("Control: BREAK"); } (IF condition)? SEMICOLLON
    | NEXT { System.out.println("Control: NEXT"); } (IF condition)? SEMICOLLON
    )*
    (
    returnStatement
    )?;

forStatement:
    FOR { System.out.println("Loop: FOR"); } IDENTIFIER IN range
    loopBody
    END;

range:
    (LPAR expression DOUBLEDOT expression RPAR)
    | (LBRACK (expression (COMMA expression)*) RBRACK)
    | IDENTIFIER;

filterStatement:
    { System.out.println("Structure: FILTER"); } LBRACK expression SEPARATOR IDENTIFIER
    ARROW range COMMA expression (COMMA expression)* RBRACK;

matchPatternStatement:
    { System.out.println("Built-In: MATCH"); } IDENTIFIER DOT MATCH LPAR expression RPAR;

chopAndChompStatement:
    (CHOP { System.out.println("Built-In: CHOP"); }
    | CHOMP { System.out.println("Built-In: CHOMP"); }) LPAR expression RPAR;

assignment:
    IDENTIFIER { System.out.println("Assignment: " + $IDENTIFIER.text); } (accessList)?
    ASSIGN expression SEMICOLLON;

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
    relationalExpression
    ((op = EQUAL
    | op = NOT_EQUAL
    | op = IS_NOT
    | op = IS
    ) relationalExpression { System.out.println("Operator: " + $op.text); }
    )*
    ;

relationalExpression:
    additiveExpression
    ((op = GREATER_THAN
    | op = LESS_THAN
    ) additiveExpression { System.out.println("Operator: " + $op.text); }
    )*
    ;

additiveExpression:
    multiplicativeExpression
    ((op = PLUS
    | op = MINUS
    ) multiplicativeExpression { System.out.println("Operator: " + $op.text); }
    )*
    ;

multiplicativeExpression:
    preUnaryExpression
    ((op = MULT
    | op = DIVIDE
    ) preUnaryExpression { System.out.println("Operator: " + $op.text); }
    )*;

preUnaryExpression:
    ((op = NOT
    | op = MINUS
    | op = INCREMENT
    | op = DECREMENT
    ) preUnaryExpression { System.out.println("Operator: " + $op.text); }
    )
    | appendExpression
    ;

appendExpression:
    accessExpression
    (APPEND accessExpression { System.out.println("Operator: " + $APPEND.text); }
    )*
    ;

accessExpression:
    otherExpression
    (LPAR functionArguments
    RPAR { System.out.println("FunctionCall"); } )*
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
    | LPAR (expression)? RPAR
    ;

lambdaFunction:
    ARROW { System.out.println("Structure: LAMBDA"); } functionArgumentsDeclaration
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
IS_NOT: 'is not';
IS: 'is';
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