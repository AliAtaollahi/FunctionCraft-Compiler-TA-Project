grammar FunctionCraft;

program
    : (COMMENT)* main COMMENT*
    ;

primitive
    : INT
    ;

primitive_val
    : INT_VAL
    ;

main
    :
    MAIN { System.out.println("MainBody"); }
    LBRACE
    body_function
    RBRACE
    ;

body_function
    : (statement | COMMENT)*
    ;

statement
    : (print
    | assignment
    | initialization) SEMICOLON
    ;

print
    :
    PRINT { System.out.println("Built-in: print"); }
    LPAR
    IDENTIFIER
    RPAR
    ;

assignment
    :
    IDENTIFIER
    ASSIGN
    expr
    ;

initialization
    :
    primitive
    name = IDENTIFIER { System.out.println("VarDec: " + $name.text); }
    ASSIGN
    expr
    ;

expr
    : expr_other
    ;

expr_other
    : LPAR expr RPAR
    | IDENTIFIER
    | primitive_val
    ;

MAIN:     'main';
PRINT:    'print';
INT:       'int';
INT_VAL:     [1-9][0-9]*;
LPAR: '(';
RPAR: ')';
NOT:   '!';
PLUS:  '+';
MINUS: '-';
MULT:  '*';
DIV:   '/';
MOD:   '%';
GEQ: '>=';
LEQ: '<=';
GTR: '>';
LES: '<';
EQL: '==';
NEQ: '!=';
AND: '&&';
OR:  '||';
ASSIGN: '=';
LBRACE:    '{';
RBRACE:    '}';
COMMA:     ',';
DOT:       '.';
COLON:     ':';
SEMICOLON: ';';
QUESTION:  '?';
IDENTIFIER: [a-z][a-zA-Z0-9_]*;
ARROW:      '=>';
COMMENT:    '#' ~[\r\n]* -> skip;
WS:         [ \t\r\n]+ -> skip;