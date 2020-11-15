package instant;

import instant.Absyn.Prog;
import instant.Absyn.Program;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String args[]) throws Exception
    {
        Yylex l = null;
        parser p;
        try
        {
            if (args.length == 0) l = new Yylex(new InputStreamReader(System.in));
            else l = new Yylex(new FileReader(args[0]));
        }
        catch(FileNotFoundException e)
        {
            System.err.println("Error: File not found: " + args[0]);
            System.exit(1);
        }
        p = new parser(l);
        /* The default parser is the first-defined entry point. */
        /* You may want to change this. Other options are: */
        /* pStatement, pListStatement, pExpression */
        try
        {
            Program parse_tree = p.pProgram();
            System.out.println();
            System.out.println("Parse Succesful!");
            System.out.println();
            System.out.println("[Abstract Syntax]");
            System.out.println();
            System.out.println(PrettyPrinter.show(parse_tree));
            System.out.println();
            System.out.println("[Linearized Tree]");
            System.out.println();
            System.out.println(PrettyPrinter.print(parse_tree));

            LLVMFoldLeftVisitor visitor = new LLVMFoldLeftVisitor();
//            visitor.visit((Prog)parse_tree,new LLVMContext());
            List<String> result = parse_tree.accept(visitor,new Context());

            for( String s :result){
                System.out.println(s);
                System.out.println();

            }

        }
        catch(Throwable e)
        {
            System.err.println("At line " + String.valueOf(l.line_num()) + ", near \"" + l.buff() + "\" :");
            System.err.println("     " + e.getMessage());
            System.exit(1);
        }
    }
}
