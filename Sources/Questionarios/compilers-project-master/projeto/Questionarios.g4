grammar Questionarios ;

@parser::members{
	static int acceptParaInstructions = 0;
	static int contextID = 0;
	static int listContador = 0;
}

program : stat* EOF;

stat:     declaracao '.'	#StatDeclaracao
	| atribuicao '.'		#StatAtribuicao
	| metodo '.'			#StatMetodo
	| ciclo					#StatCiclo
	| se					#StatSe
	| instrucoes_para '.'	#StatInstrucoes_Para	
	;


declaracao returns [Type t = null] :  textoList 'as' type ;
										
textoList returns [String[] var = null] locals[int contextnumID = contextID, Type t = null]: 
		TEXTO (',' TEXTO)* ;

atribuicao returns[String var = null] locals[int contextnumID = contextID]:	variavel ':=' valor ;

variavel returns[String var = null] locals[String nameASemantica = "", String name = "", Type t = null]: 
		TEXTO ('->' variavel)? ; 

metodo locals[int contextnumID = contextID, Type t = null]:	  variavel '%' metodo_em_si 	#metodoComVariavel
	| metodo_em_si 						#metodoSemVariavel
	;

metodo_em_si locals [String varName = null, String metodoNome = null] /* returns [String met = null] */ : TEXTO '(' argum? (',' argum)* ')';

argum returns [String metodoNome = null, String varName = null, Type t = null, String var = null] locals[int contextnumID = contextID]:   variavel '=' valor 		#argumVariavel
								| valor										#argumValor
								;

instrucoes_para locals[int num = acceptParaInstructions]:  'parar'		#Instrucoes_para_parar
				|  'continuar' 											#Instrucoes_para_continuar
			;

ciclo locals[int contextnumID = contextID]:	'para' {contextID++;} '(' declaracao 'em' variavel ')' 'inicio' {acceptParaInstructions++;} stat+ {acceptParaInstructions--;contextID--;} 'fim' ;


se: se_inicial ouse* senao? ;

se_inicial: 'se' '(' condicao ')' 'inicio' {contextID++;} stat+ 'fim' {contextID--;} ;
ouse: 'ouse' '(' condicao ')' 'inicio' {contextID++;} stat+ 'fim' {contextID--;} ;
senao: 'senao' 'inicio' {contextID++;} stat+ 'fim' {contextID--;} ;

condicao returns [String var = null] locals [Type t = null, int contextnumID = contextID]:
		 	  condicao op=('>'|'<'|'<='|'>='|'=='|'!=') condicao 	#CondicaoComparacao
			| condicao op2=('e' | 'ou') condicao					#CondicaoEOu
			| variavel												#CondicaoValor
			| '(' condicao ')' 										#CondicaoPerentesis
			;

aux_string returns [Type t = null, String var = null] locals[int contextnumID = contextID]:   STRING 		#Aux_StringString
				| variavel  		#Aux_StringVariavel
				| metodo			#Aux_StringMetodo
									;

string returns [Type t = null, String var = null]:	aux_string ('&' aux_string)* ;

valor returns [Type t = null, String tipo = null, String var = null, Boolean isVariavel = false, String isVariavelNome] locals[int contextnumID = contextID]:    
		  variavel		#ValorVariavel
		| string		#ValorString		
		| expr			#ValorExpr
		| '{' listaMembro? '}'			#ValorLista 
		| dificuldade	#ValorDificuldade
		| resposta		#ValorResposta
		| metodo		#ValorMetodo
		| tema			#ValorTema 
		| type			#ValorType
		| condicao		#ValorCondicao
		| booleano		#ValorBooleano
		| TIPOQUESTAO   #ValorTipoQuestao
		;

tema returns [Type t = null, String var = null]: '[' TEXTO ('->' TEXTO)* ']';

expr returns [Type t = null, String var = null] locals[int contextnumID = contextID]:   
	    op=('-'|'+') expr			#ExprOp
      | e1=expr op=('*'|'/'|'//') e2=expr					#ExprMultDiv
      | e1=expr op=('+'|'-') e2=expr						#ExprAddSub
      | INT ('.' INT)?										#ExprInt
      | variavel											#ExprVariavel
      | '(' expr ')'										#ExprExpr
      ;

resposta returns [Type t = null, String var = null]:   string ',' expr			#RespostaPalavra
	  | string ',' booleano ',' expr ',' expr 									#RespostaVF
	  ;


listaMembro returns [Type t = null] : valor						#ListaMembroValor
									| valor ';' listaMembro		#ListaMembroMembro
									;
									

dificuldade returns [String var = null] locals [Type t = null]: DIFICULDADE ;

booleano returns [String var = null] locals[Type t = null]:   BOOLEANO ;


type returns[Type res = null, String tipo = null, Type listContentType = null]:	  
				  'Inteiro'						#InteiroType
				| 'Real'						#RealType
				| 'Questao:EscolhaMultipla'		#EscolhaMultiplaType
				| 'Questao:VerdadeiroFalso'		#VerdadeiroFalsoType
				| 'Questao:CurtaTextual'		#CurtaTextualType
				| 'Questao:LongaTextual'		#LongaTextualType
				| 'Resposta:EscolhaMultipla'	#REscolhaMultiplaType
				| 'Resposta:VerdadeiroFalso'	#RVerdadeiroFalsoType
				| 'Resposta:CurtaTextual'		#RCurtaTextualType
				| 'Resposta:LongaTextual'		#RLongaTextualType
				| 'String'						#StringType
				| 'Questionario'				#QuestionarioType
				| 'Grupo'						#GrupoType
				| 'Boolean'						#BooleanType
				| 'Resposta'					#RespostaType
				| 'Tema'						#TemaType
				| 'Questao'						#QuestaoType
				| 'Lista'  '<' type '>'			#ListaType
				|  'Dificuldade' 				#DificuldadeType
				;

COMMENTS: '#' .*? ('\n' | EOF) '\r'? -> skip;

BOOLEANO: 'true' | 'false' ;
DIFICULDADE: 'DIFICIL' | 'MEDIO' | 'FACIL' ;
TIPOQUESTAO: 'VerdadeiroFalso' | 'EscolhaMultipla' | 'CurtaTextual' | 'LongaTextual';
INT: [0-9]+;
STRING: '"' .*? '"';
TEXTO: [A-Za-z0-9_]+;


WS: [ \t\n\r]+ -> skip;
