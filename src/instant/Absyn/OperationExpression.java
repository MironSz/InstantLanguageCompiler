package instant.Absyn;

import instant.Context;
import instant.LLVMContext;

import static java.lang.Integer.max;

public class OperationExpression extends Expression {
    public final Expression expression_1, expression_2;

    public boolean isSwapped = false;
    int leftDepth;
    int rightDepth;


    public OperationExpression(Expression p1, Expression p2) {
        expression_1 = p1;
        expression_2 = p2;
        leftDepth = p1.depth;
        rightDepth = p2.depth;
        depth = max(leftDepth, rightDepth) + 1;
    }

    @Override
    public <R> R accept(Visitor<R> v, Context arg) {
        return null;
    }
}
