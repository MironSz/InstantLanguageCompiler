package instant;

/**
 * BNFC-Generated Fold Visitor
 */
public abstract class FoldVisitor<R> implements AllVisitor<R> {
    public abstract R leaf(Context arg);

    public abstract R combine(R x, R y, Context arg);

    /* Program */
    public R visit(instant.Absyn.Prog p, Context arg) {
        System.out.println("FoldVisitor.visit prog");
        R r = leaf(arg);
        for (instant.Absyn.Statement x : p.liststatement_) {
            System.out.println(x);
            r = combine(x.accept(this, arg), r, arg);
        }
        return r;
    }

    /* Statement */
    public R visit(instant.Absyn.SAssignment p, Context arg) {
        R r = leaf(arg);
        r = combine(p.expression_.accept(this, arg), r, arg);
        return r;
    }

    public R visit(instant.Absyn.SExpression p, Context arg) {
        System.out.println("FoldVisitor.visit");
        R r = leaf(arg);
        r = combine(p.expression_.accept(this, arg), r, arg);
        return r;
    }

    /* Expression */
    public R visit(instant.Absyn.AdditionExpression p, Context arg) {
        R r = leaf(arg);
        r = combine(p.expression_1.accept(this, arg), r, arg);
        r = combine(p.expression_2.accept(this, arg), r, arg);
        return r;
    }

    public R visit(instant.Absyn.SubtractExpression p, Context arg) {
        R r = leaf(arg);
        r = combine(p.expression_1.accept(this, arg), r, arg);
        r = combine(p.expression_2.accept(this, arg), r, arg);
        return r;
    }

    public R visit(instant.Absyn.MultiplyExpression p, Context arg) {
        R r = leaf(arg);
        r = combine(p.expression_1.accept(this, arg), r, arg);
        r = combine(p.expression_2.accept(this, arg), r, arg);
        return r;
    }

    public R visit(instant.Absyn.DivideExpression p, Context arg) {
        R r = leaf(arg);
        r = combine(p.expression_1.accept(this, arg), r, arg);
        r = combine(p.expression_2.accept(this, arg), r, arg);
        return r;
    }

    public R visit(instant.Absyn.LiteralExpression p, Context arg) {
        R r = leaf(arg);
        return r;
    }

    public R visit(instant.Absyn.VarExpression p, Context arg) {
        R r = leaf(arg);
        return r;
    }


}
