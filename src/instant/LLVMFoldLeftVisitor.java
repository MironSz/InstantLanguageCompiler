package instant;

import instant.Absyn.*;

import java.util.LinkedList;
import java.util.List;

public class LLVMFoldLeftVisitor extends FoldVisitor<List<String>> {
    @Override
    public List<String> leaf(Context arg) {
        return new LinkedList<>();
    }

    @Override
    public List<String> combine(List<String> y,List<String> x, Context arg) {
        System.out.println("x = " + x + ", y = " + y + ", arg = " + arg);
        x.addAll(y);
        return x;
    }

    private List<String> visitTrinaryOperation(String operationName, Expression operationExpression, Expression left, Expression right, Context context) {
        System.out.println("LLVMFoldLeftVisitor.visitTrinaryOperation");
        List<String> leftOperations = left.accept(this, context);
        List<String> operations = combine(leftOperations, right.accept(this, context), context);

        String leftOperationRegister = context.getResultOfExpression(left);
        String rightOperationRegister = context.getResultOfExpression(right);
        String resultRegister = context.getNewRegister(operationExpression);

        String calculateResult = "   " + resultRegister + " = " + operationName + " i32 " + leftOperationRegister + ", " + rightOperationRegister;

        operations.add(calculateResult);
        return operations;
    }

    @Override
    public List<String> visit(Prog p, Context arg) {
        arg = new Context();
        System.out.println("LLVMFoldLeftVisitor.visit Prog");
//        System.out.println("p = " + p + ", arg = " + arg);
        String programBeginning = "declare void @printInt(i32)\n" +
                "define i32 @main() {";
        String programEnd = "   ret i32 0\n}\n";

        List<String> allInstructions = super.visit(p, arg);
        allInstructions.add(programEnd);
        allInstructions.add(0, programBeginning);


        return allInstructions;
    }

    @Override

    public List<String> visit(SAssignment p, Context arg) {
        List<String> calculateExpression = p.expression_.accept(this,arg);
        String newRegister = arg.assignNewRegister(p.ident_);
        String resultRegister = arg.getResultOfExpression(p.expression_);
        String assignment = "    "+newRegister+" = " + resultRegister;
        calculateExpression.add(assignment);
        return calculateExpression;
    }

    @Override

    public List<String> visit(LiteralExpression p, Context arg) {
        System.out.println("p = " + p.integer_ + ", arg = " + arg);
        return new LinkedList<>();
    }

    @Override

    public List<String> visit(SExpression p, Context arg) {
        System.out.println("LLVMFoldLeftVisitor.visit Sexp");
        List<String> resultExpressions = p.expression_.accept(this, arg);

        String resultOfExpression = arg.getResultOfExpression(p.expression_);

        String printResult = "     call void @printInt (i32 " + resultOfExpression + ")";
        resultExpressions.add(printResult);
        return resultExpressions;
    }

    @Override
    public List<String> visit(AdditionExpression p, Context arg) {
        System.out.println("LLVMFoldLeftVisitor.visit");
//        System.out.println("p = " + p + ", arg = " + arg);
        return visitTrinaryOperation("Add", p, p.expression_1, p.expression_2, arg);
    }

    @Override
    public List<String> visit(SubtractExpression p, Context arg) {
        return visitTrinaryOperation("Sub", p, p.expression_1, p.expression_2, arg);
    }

    @Override
    public List<String> visit(MultiplyExpression p, Context arg) {
        return visitTrinaryOperation("Mul", p, p.expression_1, p.expression_2, arg);
    }

    @Override
    public List<String> visit(DivideExpression p, Context arg) {
        return visitTrinaryOperation("Div", p, p.expression_1, p.expression_2, arg);
    }

    @Override
    public List<String> visit(VarExpression p, Context arg) {

        return super.visit(p, arg);
    }


}
