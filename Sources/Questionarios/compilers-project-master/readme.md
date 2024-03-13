# Overview & introduction

For the course Compilers, our group developed a programming language capable of creating and manipulating quizzes efficiently. This language allows the creating of quizzes with various types of questions - for example, multiple-choice, true or false, short and also long written answers. Besides, it is also possible to create configurations relative to the presentation of the whole quiz, like determining the order of the questions or its maximum duration. Other functionalities are also included, like attributing points to each answer given. And, like almost any other programming language, it has support for conditionals, loops, and some data structures, like lists. To finalize, the language allows the programmer to write his questions directly on the program, but also allows him to upload questions already made, using a different syntax, as if it was a sort of format to store questions.

To accomplish this, two grammars where developed: one for the primary goal of the language - that is, creating and presenting quizzes -, and another for the definition of questions when outside the program script.

Besides the grammars, we also had to develop semantic analysis, so that semantic errors were detected at compile-time, and also the compiler, that transformed the code to Java. All of this was accomplished using the tool ANTLR4 (ANother Tool for Language Recognition).

In the directory `projeto/exemplos` we can find some examples in this language.
In the directory `projeto/exemplos_base_de_dados` we can find some examples of questions defined in the second language we mentioned above.