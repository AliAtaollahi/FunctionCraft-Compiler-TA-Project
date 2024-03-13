O projeto em si está na pasta "projeto".

Para além disso, também se encontra lá uma pasta "exemplos" com 5 exemplos de código fonte da linguagem desenvolvida, e uma pasta "exemplos_base_dados" com exemplo de ficheiros que utilizam a linguagem auxiliar também desenvolvida neste projeto, que servem para carregar (utilizando a função de import) questões já criadas para o programa, como se fosse uma base de dados.

Também criamos um script apenas para que fosse mais simples compilar o código fonte e executar. A sua utilização é da seguinte forma:
    $ ./ex [nome_ficheiro]          -> compila o código para Java (para o ficheiro Out.java) - utilizando o script run - imprime na consola o código gerado e executa
    $ ./ex [nome_ficheiro] --build  -> faz "antlr4-build", e de seguida executa o mesmo que o comando acima executa
