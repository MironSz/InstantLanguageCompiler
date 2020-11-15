package instant;

/**
 * BNFC-Generated Abstract Visitor
 */
//!!!!!!!!!!!!!!!!!!!!!!!!! TOOODOOOOODO
public class AbstractVisitor<R> implements AllVisitor<R> {
    /* Program */
    public R visit(instant.Absyn.Prog p, Context arg) {
        return visitDefault(p, arg);
    }

    public R visitDefault(instant.Absyn.Program p, Context arg) {
        throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }

    /* Statement */
    public R visit(instant.Absyn.SAssignment p, Context arg) {
        return visitDefault(p, arg);
    }

    public R visit(instant.Absyn.SExpression p, Context arg) {
        return visitDefault(p, arg);
    }

    public R visitDefault(instant.Absyn.Statement p, Context arg) {
        throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }

    /* Expression */
    public R visit(instant.Absyn.AdditionExpression p, Context arg) {
        return visitDefault(p, arg);
    }

    public R visit(instant.Absyn.SubtractExpression p, Context arg) {
        return visitDefault(p, arg);
    }

    public R visit(instant.Absyn.MultiplyExpression p, Context arg) {
        return visitDefault(p, arg);
    }

    public R visit(instant.Absyn.DivideExpression p, Context arg) {
        return visitDefault(p, arg);
    }

    public R visit(instant.Absyn.LiteralExpression p, Context arg) {
        return visitDefault(p, arg);
    }

    public R visit(instant.Absyn.VarExpression p, Context arg) {
        return visitDefault(p, arg);
    }

    public R visitDefault(instant.Absyn.Expression p, Context arg) {
        throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }

}
