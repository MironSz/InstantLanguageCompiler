//package instant;
//
//import instant.Absyn.Expression;
//import instant.Absyn.LiteralExpression;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class LLVMContext extends Context {
//    private int registerCount = 0;
//    private List<Integer> registerStack;
//    private Map<Expression, String> expressiontoRegisterMap = new HashMap<>();
//
//    public String getNewRegister(Expression expression) {
//        if (expression instanceof LiteralExpression){
//            return getResultOfExpression(expression);
//        }
//        if (expressiontoRegisterMap.containsKey(expression)) {
//            return expressiontoRegisterMap.get(expression);
//        }
//        String name = expression.getName() + registerCount;
//        registerCount++;
//        expressiontoRegisterMap.put(expression, name);
//        return name;
//    }
//
//    public String getResultOfExpression(Expression expression) {
//        if (expression instanceof LiteralExpression)
//            return Integer.toString( ((LiteralExpression)expression).integer_);
//        return expressiontoRegisterMap.getOrDefault(expression, "register_was_not_defined");
//    }
//
////    abstract class OperationArgument{
////    }
////
////    class LiteralArgument extends OperationArgument{
////        int value;
////        LiteralArgument(int value){
////            this.value=value;
////        }
////
////        @Override
////        public String toString() {
////            return Integer.toString(value);
////        }
////    }
////    class RegisterArgument extends OperationArgument{
////
////    }
//}
