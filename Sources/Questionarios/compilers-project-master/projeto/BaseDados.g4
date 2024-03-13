grammar BaseDados ;

program: stat EOF;

stat: declaracao* ;

declaracao: 'questao' ':' TIPO (DIFICULDADE)? pontuacao? '['tema']' STRING? respostas; 

respostas: 'inicio'? (resp ';')* 'fim'? ;

resp:   STRING BOOLEANO? pontuacao?;

pontuacao: 'pontuacao' '=' valor;

valor:       INT				#IntegerCtx
	   | '(' INT ',' INT ')'	#ValorTuploCtx
	   ;

tema: 
		(TEXTO|TIPO) ('->' tema)	#TemaPlus
	|	(TEXTO|TIPO)				#TemaFinish
	;


DIFICULDADE: 'facil' | 'medio' | 'dificil' ;
BOOLEANO: 'true' | 'false';
INT: '-'?[0-9]+;

TIPO: [A-Z][a-zA-Z0-9_]+;
TEXTO: [a-zA-Z0-9_]+;
STRING: '"'  .*? '"';
WS: [ \t\n\r]+ -> skip ;
COMMENTS: '#' .*? '\n' '\r'? -> skip;
