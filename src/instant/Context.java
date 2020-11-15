package instant;

import instant.Absyn.Expression;
import instant.Absyn.LiteralExpression;
import instant.Absyn.VarExpression;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Context {
    private int registerCount = 0;
    private List<Integer> registerStack;
    private Map<Expression, String> expressiontoRegisterMap = new HashMap<>();
    private Map<String,String> identToRegister = new HashMap<>();

    public String getNewRegister(Expression expression) {
        if (expression instanceof LiteralExpression){
            return getResultOfExpression(expression);
        }
        if (expressiontoRegisterMap.containsKey(expression)) {
            return expressiontoRegisterMap.get(expression);
        }
        String name = expression.getName() + registerCount;
        registerCount++;
        expressiontoRegisterMap.put(expression, name);
        return "%"+name;
    }

    public String getResultOfExpression(Expression expression) {
        if (expression instanceof LiteralExpression)
            return "%"+Integer.toString( ((LiteralExpression)expression).integer_);
        if (expression instanceof VarExpression)
            return "%"+identToRegister.getOrDefault(((VarExpression) expression).ident_,"umdefined_variable");
        return "%"+expressiontoRegisterMap.getOrDefault(expression, "register_was_not_defined");
    }

    public void setNewVarRegister(String ident,Expression expression){
        String registerName = this.getResultOfExpression(expression);
        identToRegister.put(ident,registerName);

    }

    public String assignNewRegister(String ident){
        String newRegister = ident+registerCount;
        registerCount++;
        identToRegister.put(ident,newRegister);
        return "%"+newRegister;

    }

}
