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
    functionArgumentsDeclaration
    (PATTERN_MATCHING_SEPARATOR condition ASSIGN expression)*
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
    loopBody
    (ELSEIF { System.out.println("Decision: ELSE IF"); } condition loopBody)*
    (ELSE { System.out.println("Decision: ELSE"); } loopBody)? END;

condition:
    LPAR expression RPAR;

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
    IDENTIFIER (accessList)?
    (ASSIGN
    | PLUS_ASSIGN
    | MINUS_ASSIGN
    | DIVIDE_ASSIGN
    | MULT_ASSIGN
    | MOD_ASSIGN)
     expression { System.out.println("Assignment: " + $IDENTIFIER.text); } SEMICOLLON;

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
    expression APPEND orExpression { System.out.println("Operator: " + $APPEND.text); }
    | orExpression;

orExpression:
    LPAR orExpression RPAR (OR LPAR orExpression RPAR { System.out.println("Operator: " + $OR.text); })+
    | andExpression;

 andExpression:
    LPAR andExpression RPAR (AND LPAR andExpression RPAR { System.out.println("Operator: " + $AND.text); })+
    | eqaulityExpression
 ;

eqaulityExpression:
    eqaulityExpression
    (op = EQUAL
    | op = NOT_EQUAL
    ) relationalExpression { System.out.println("Operator: " + $op.text); }
    | relationalExpression;

relationalExpression:
    relationalExpression
    (op = GREATER_THAN
    | op = LESS_THAN
    | op = LESS_EQUAL_THAN
    | op = GREATER_EQUAL_THAN
    ) additiveExpression { System.out.println("Operator: " + $op.text); }
    | additiveExpression;


additiveExpression:
    additiveExpression
    (op = PLUS
    | op = MINUS
    ) multiplicativeExpression { System.out.println("Operator: " + $op.text); }
    | multiplicativeExpression;


multiplicativeExpression:
    multiplicativeExpression
    (op = MULT
    | op = DIVIDE
    ) preUnaryExpression { System.out.println("Operator: " + $op.text); }
    | preUnaryExpression;


preUnaryExpression:
    op = NOT LPAR expression RPAR  { System.out.println("Operator: " + $op.text); }
    | op = MINUS preUnaryExpression { System.out.println("Operator: " + $op.text); }
    | posUnaryExpression;


posUnaryExpression:
    posUnaryExpression
    (op = INCREMENT
    | op = DECREMENT) { System.out.println("Operator: " + $op.text); }
    | accessExpression;

accessExpression:
    otherExpression
    (LPAR { System.out.println("Function Call"); } functionArguments
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