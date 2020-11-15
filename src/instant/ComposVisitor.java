package instant;

/**
 * BNFC-Generated Composition Visitor
 */

public class ComposVisitor implements
        instant.Absyn.Program.Visitor<instant.Absyn.Program>,
        instant.Absyn.Statement.Visitor<instant.Absyn.Statement>,
        instant.Absyn.Expression.Visitor<instant.Absyn.Expression> {
    /* Program */
    public instant.Absyn.Program visit(instant.Absyn.Prog p, Context arg) {
        instant.Absyn.ListStatement liststatement_ = new instant.Absyn.ListStatement();
        for (instant.Absyn.Statement x : p.liststatement_) {
            liststatement_.add(x.accept(this, arg));
        }
        return new instant.Absyn.Prog(liststatement_);
    }

    /* Statement */
    public instant.Absyn.Statement visit(instant.Absyn.SAssignment p, Context arg) {
        String ident_ = p.ident_;
        instant.Absyn.Expression expression_ = p.expression_.accept(this, arg);
        return new instant.Absyn.SAssignment(ident_, expression_);
    }

    public instant.Absyn.Statement visit(instant.Absyn.SExpression p, Context arg) {
        instant.Absyn.Expression expression_ = p.expression_.accept(this, arg);
        return new instant.Absyn.SExpression(expression_);
    }

    /* Expression */
    public instant.Absyn.Expression visit(instant.Absyn.AdditionExpression p, Context arg) {
        instant.Absyn.Expression expression_1 = p.expression_1.accept(this, arg);
        instant.Absyn.Expression expression_2 = p.expression_2.accept(this, arg);
        return new instant.Absyn.AdditionExpression(expression_1, expression_2);
    }

    public instant.Absyn.Expression visit(instant.Absyn.SubtractExpression p, Context arg) {
        instant.Absyn.Expression expression_1 = p.expression_1.accept(this, arg);
        instant.Absyn.Expression expression_2 = p.expression_2.accept(this, arg);
        return new instant.Absyn.SubtractExpression(expression_1, expression_2);
    }

    public instant.Absyn.Expression visit(instant.Absyn.MultiplyExpression p, Context arg) {
        instant.Absyn.Expression expression_1 = p.expression_1.accept(this, arg);
        instant.Absyn.Expression expression_2 = p.expression_2.accept(this, arg);
        return new instant.Absyn.MultiplyExpression(expression_1, expression_2);
    }

    public instant.Absyn.Expression visit(instant.Absyn.DivideExpression p, Context arg) {
        instant.Absyn.Expression expression_1 = p.expression_1.accept(this, arg);
        instant.Absyn.Expression expression_2 = p.expression_2.accept(this, arg);
        return new instant.Absyn.DivideExpression(expression_1, expression_2);
    }

    public instant.Absyn.Expression visit(instant.Absyn.LiteralExpression p, Context arg) {
        Integer integer_ = p.integer_;
        return new instant.Absyn.LiteralExpression(integer_);
    }

    public instant.Absyn.Expression visit(instant.Absyn.VarExpression p, Context arg) {
        String ident_ = p.ident_;
        return new instant.Absyn.VarExpression(ident_);
    }
}
