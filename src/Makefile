JAVAC=javac
JAVAC_FLAGS=-sourcepath .
JAVA=java
JAVA_FLAGS=
CUP=java_cup.Main
CUPFLAGS=-nopositions -expect 100
JLEX=JLex.Main
all: test

test: absyn instant/Yylex.class instant/PrettyPrinter.class instant/Test.class instant/ComposVisitor.class instant/AbstractVisitor.class instant/FoldVisitor.class instant/LLVMFoldLeftVisitor.class instant/AllVisitor.class instant/parser.class instant/sym.class instant/Test.class

.PHONY: absyn

%.class: %.java
	${JAVAC} ${JAVAC_FLAGS} $^

absyn: instant/Absyn/Program.java instant/Absyn/Prog.java instant/Absyn/Statement.java instant/Absyn/SAssignment.java instant/Absyn/SExpression.java instant/Absyn/ListStatement.java instant/Absyn/Expression.java instant/Absyn/AdditionExpression.java instant/Absyn/SubtractExpression.java instant/Absyn/MultiplyExpression.java instant/Absyn/DivideExpression.java instant/Absyn/LiteralExpression.java instant/Absyn/VarExpression.java
	${JAVAC} ${JAVAC_FLAGS} $^

instant/Yylex.java: instant/Yylex
	${JAVA} ${JAVA_FLAGS} ${JLEX}  instant/Yylex

instant/sym.java instant/parser.java: instant/instant.cup
	${JAVA} ${JAVA_FLAGS} ${CUP} ${CUPFLAGS} instant/instant.cup
	mv sym.java parser.java instant/

instant/Yylex.class: instant/Yylex.java instant/sym.java

instant/sym.class: instant/sym.java

instant/parser.class: instant/parser.java instant/sym.java

instant/PrettyPrinter.class: instant/PrettyPrinter.java

instan/LLVMFoldLeftVisitor.class: instant/LLVMFoldLeftVisitor.java

clean:
	rm -f instant/Absyn/*.class instant/*.class

distclean: vclean

vclean:
	 rm -f instant/Absyn/Program.java instant/Absyn/Prog.java instant/Absyn/Statement.java instant/Absyn/SAssignment.java instant/Absyn/SExpression.java instant/Absyn/ListStatement.java instant/Absyn/Expression.java instant/Absyn/AdditionExpression.java instant/Absyn/SubtractExpression.java instant/Absyn/MultiplyExpression.java instant/Absyn/DivideExpression.java instant/Absyn/LiteralExpression.java instant/Absyn/VarExpression.java instant/Absyn/Program.class instant/Absyn/Prog.class instant/Absyn/Statement.class instant/Absyn/SAssignment.class instant/Absyn/SExpression.class instant/Absyn/ListStatement.class instant/Absyn/Expression.class instant/Absyn/AdditionExpression.class instant/Absyn/SubtractExpression.class instant/Absyn/MultiplyExpression.class instant/Absyn/DivideExpression.class instant/Absyn/LiteralExpression.class instant/Absyn/VarExpression.class
	 rm -f instant/Absyn/*.class
	 rmdir instant/Absyn/
	 rm -f instant/Yylex instant/instant.cup instant/Yylex.java instant/VisitSkel.java instant/ComposVisitor.java instant/AbstractVisitor.java instant/FoldVisitor.java instant/LLVMFoldLeftVisitor instant/AllVisitor.java instant/PrettyPrinter.java instant/Skeleton.java instant/Test.java instant/sym.java instant/parser.java instant/*.class
	rm -f Makefile
	rmdir -p instant/

