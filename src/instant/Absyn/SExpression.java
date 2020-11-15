package instant.Absyn; // Java Package generated by the BNF Converter.

import instant.Context;

public class SExpression extends Statement {
    public final Expression expression_;

    public SExpression(Expression p1) {
        expression_ = p1;
    }

    public <R> R accept(instant.Absyn.Statement.Visitor<R> v, Context arg) {
        return v.visit(this, arg);
    }

    public boolean equals(java.lang.Object o) {
        if (this == o) return true;
        if (o instanceof instant.Absyn.SExpression) {
            instant.Absyn.SExpression x = (instant.Absyn.SExpression) o;
            return this.expression_.equals(x.expression_);
        }
        return false;
    }

    public int hashCode() {
        return this.expression_.hashCode();
    }


}