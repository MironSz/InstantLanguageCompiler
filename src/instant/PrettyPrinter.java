package instant;

public class PrettyPrinter {
    //For certain applications increasing the initial size of the buffer may improve performance.
    private static final int INITIAL_BUFFER_SIZE = 128;
    private static final int INDENT_WIDTH = 2;
    //You may wish to change the parentheses used in precedence.
    private static final String _L_PAREN = new String("(");
    private static final String _R_PAREN = new String(")");

    //You may wish to change render
    private static void render(String s) {
        if (s.equals("{")) {
            buf_.append("\n");
            indent();
            buf_.append(s);
            _n_ = _n_ + INDENT_WIDTH;
            buf_.append("\n");
            indent();
        } else if (s.equals("(") || s.equals("["))
            buf_.append(s);
        else if (s.equals(")") || s.equals("]")) {
            backup();
            buf_.append(s);
            buf_.append(" ");
        } else if (s.equals("}")) {
            int t;
            _n_ = _n_ - INDENT_WIDTH;
            for (t = 0; t < INDENT_WIDTH; t++) {
                backup();
            }
            buf_.append(s);
            buf_.append("\n");
            indent();
        } else if (s.equals(",")) {
            backup();
            buf_.append(s);
            buf_.append(" ");
        } else if (s.equals(";")) {
            backup();
            buf_.append(s);
            buf_.append("\n");
            indent();
        } else if (s.equals("")) return;
        else if (s.trim().equals("")) {
            backup();
            buf_.append(s);
        } else {
            buf_.append(s);
            buf_.append(" ");
        }
    }


    //  print and show methods are defined for each category.
    public static String print(instant.Absyn.Program foo) {
        pp(foo, 0);
        trim();
        String temp = buf_.toString();
        buf_.delete(0, buf_.length());
        return temp;
    }

    public static String show(instant.Absyn.Program foo) {
        sh(foo);
        String temp = buf_.toString();
        buf_.delete(0, buf_.length());
        return temp;
    }

    public static String print(instant.Absyn.Statement foo) {
        pp(foo, 0);
        trim();
        String temp = buf_.toString();
        buf_.delete(0, buf_.length());
        return temp;
    }

    public static String show(instant.Absyn.Statement foo) {
        sh(foo);
        String temp = buf_.toString();
        buf_.delete(0, buf_.length());
        return temp;
    }

    public static String print(instant.Absyn.ListStatement foo) {
        pp(foo, 0);
        trim();
        String temp = buf_.toString();
        buf_.delete(0, buf_.length());
        return temp;
    }

    public static String show(instant.Absyn.ListStatement foo) {
        sh(foo);
        String temp = buf_.toString();
        buf_.delete(0, buf_.length());
        return temp;
    }

    public static String print(instant.Absyn.Expression foo) {
        pp(foo, 0);
        trim();
        String temp = buf_.toString();
        buf_.delete(0, buf_.length());
        return temp;
    }

    public static String show(instant.Absyn.Expression foo) {
        sh(foo);
        String temp = buf_.toString();
        buf_.delete(0, buf_.length());
        return temp;
    }

    /***   You shouldn't need to change anything beyond this point.   ***/

    private static void pp(instant.Absyn.Program foo, int _i_) {
        if (foo instanceof instant.Absyn.Prog) {
            instant.Absyn.Prog _prog = (instant.Absyn.Prog) foo;
            if (_i_ > 0) render(_L_PAREN);
            pp(_prog.liststatement_, 0);
            if (_i_ > 0) render(_R_PAREN);
        }
    }

    private static void pp(instant.Absyn.Statement foo, int _i_) {
        if (foo instanceof instant.Absyn.SAssignment) {
            instant.Absyn.SAssignment _sassignment = (instant.Absyn.SAssignment) foo;
            if (_i_ > 0) render(_L_PAREN);
            pp(_sassignment.ident_, 0);
            render("=");
            pp(_sassignment.expression_, 0);
            if (_i_ > 0) render(_R_PAREN);
        } else if (foo instanceof instant.Absyn.SExpression) {
            instant.Absyn.SExpression _sexpression = (instant.Absyn.SExpression) foo;
            if (_i_ > 0) render(_L_PAREN);
            pp(_sexpression.expression_, 0);
            if (_i_ > 0) render(_R_PAREN);
        }
    }

    private static void pp(instant.Absyn.ListStatement foo, int _i_) {
        for (java.util.Iterator<instant.Absyn.Statement> it = foo.iterator(); it.hasNext(); ) {
            pp(it.next(), _i_);
            if (it.hasNext()) {
                render(";");
            } else {
                render("");
            }
        }
    }

    private static void pp(instant.Absyn.Expression foo, int _i_) {
        if (foo instanceof instant.Absyn.AdditionExpression) {
            instant.Absyn.AdditionExpression _additionexpression = (instant.Absyn.AdditionExpression) foo;
            if (_i_ > 1) render(_L_PAREN);
            pp(_additionexpression.expression_1, 2);
            render("+");
            pp(_additionexpression.expression_2, 1);
            if (_i_ > 1) render(_R_PAREN);
        } else if (foo instanceof instant.Absyn.SubtractExpression) {
            instant.Absyn.SubtractExpression _subtractexpression = (instant.Absyn.SubtractExpression) foo;
            if (_i_ > 2) render(_L_PAREN);
            pp(_subtractexpression.expression_1, 2);
            render("-");
            pp(_subtractexpression.expression_2, 3);
            if (_i_ > 2) render(_R_PAREN);
        } else if (foo instanceof instant.Absyn.MultiplyExpression) {
            instant.Absyn.MultiplyExpression _multiplyexpression = (instant.Absyn.MultiplyExpression) foo;
            if (_i_ > 3) render(_L_PAREN);
            pp(_multiplyexpression.expression_1, 3);
            render("*");
            pp(_multiplyexpression.expression_2, 4);
            if (_i_ > 3) render(_R_PAREN);
        } else if (foo instanceof instant.Absyn.DivideExpression) {
            instant.Absyn.DivideExpression _divideexpression = (instant.Absyn.DivideExpression) foo;
            if (_i_ > 3) render(_L_PAREN);
            pp(_divideexpression.expression_1, 3);
            render("/");
            pp(_divideexpression.expression_2, 4);
            if (_i_ > 3) render(_R_PAREN);
        } else if (foo instanceof instant.Absyn.LiteralExpression) {
            instant.Absyn.LiteralExpression _literalexpression = (instant.Absyn.LiteralExpression) foo;
            if (_i_ > 4) render(_L_PAREN);
            pp(_literalexpression.integer_, 0);
            if (_i_ > 4) render(_R_PAREN);
        } else if (foo instanceof instant.Absyn.VarExpression) {
            instant.Absyn.VarExpression _varexpression = (instant.Absyn.VarExpression) foo;
            if (_i_ > 4) render(_L_PAREN);
            pp(_varexpression.ident_, 0);
            if (_i_ > 4) render(_R_PAREN);
        }
    }


    private static void sh(instant.Absyn.Program foo) {
        if (foo instanceof instant.Absyn.Prog) {
            instant.Absyn.Prog _prog = (instant.Absyn.Prog) foo;
            render("(");
            render("Prog");
            render("[");
            sh(_prog.liststatement_);
            render("]");
            render(")");
        }
    }

    private static void sh(instant.Absyn.Statement foo) {
        if (foo instanceof instant.Absyn.SAssignment) {
            instant.Absyn.SAssignment _sassignment = (instant.Absyn.SAssignment) foo;
            render("(");
            render("SAssignment");
            sh(_sassignment.ident_);
            sh(_sassignment.expression_);
            render(")");
        }
        if (foo instanceof instant.Absyn.SExpression) {
            instant.Absyn.SExpression _sexpression = (instant.Absyn.SExpression) foo;
            render("(");
            render("SExpression");
            sh(_sexpression.expression_);
            render(")");
        }
    }

    private static void sh(instant.Absyn.ListStatement foo) {
        for (java.util.Iterator<instant.Absyn.Statement> it = foo.iterator(); it.hasNext(); ) {
            sh(it.next());
            if (it.hasNext())
                render(",");
        }
    }

    private static void sh(instant.Absyn.Expression foo) {
        if (foo instanceof instant.Absyn.AdditionExpression) {
            instant.Absyn.AdditionExpression _additionexpression = (instant.Absyn.AdditionExpression) foo;
            render("(");
            render("AdditionExpression");
            sh(_additionexpression.expression_1);
            sh(_additionexpression.expression_2);
            render(")");
        }
        if (foo instanceof instant.Absyn.SubtractExpression) {
            instant.Absyn.SubtractExpression _subtractexpression = (instant.Absyn.SubtractExpression) foo;
            render("(");
            render("SubtractExpression");
            sh(_subtractexpression.expression_1);
            sh(_subtractexpression.expression_2);
            render(")");
        }
        if (foo instanceof instant.Absyn.MultiplyExpression) {
            instant.Absyn.MultiplyExpression _multiplyexpression = (instant.Absyn.MultiplyExpression) foo;
            render("(");
            render("MultiplyExpression");
            sh(_multiplyexpression.expression_1);
            sh(_multiplyexpression.expression_2);
            render(")");
        }
        if (foo instanceof instant.Absyn.DivideExpression) {
            instant.Absyn.DivideExpression _divideexpression = (instant.Absyn.DivideExpression) foo;
            render("(");
            render("DivideExpression");
            sh(_divideexpression.expression_1);
            sh(_divideexpression.expression_2);
            render(")");
        }
        if (foo instanceof instant.Absyn.LiteralExpression) {
            instant.Absyn.LiteralExpression _literalexpression = (instant.Absyn.LiteralExpression) foo;
            render("(");
            render("LiteralExpression");
            sh(_literalexpression.integer_);
            render(")");
        }
        if (foo instanceof instant.Absyn.VarExpression) {
            instant.Absyn.VarExpression _varexpression = (instant.Absyn.VarExpression) foo;
            render("(");
            render("VarExpression");
            sh(_varexpression.ident_);
            render(")");
        }
    }


    private static void pp(Integer n, int _i_) {
        buf_.append(n);
        buf_.append(" ");
    }

    private static void pp(Double d, int _i_) {
        buf_.append(String.format(java.util.Locale.ROOT, "%.15g ", d));
    }

    private static void pp(String s, int _i_) {
        buf_.append(s);
        buf_.append(" ");
    }

    private static void pp(Character c, int _i_) {
        buf_.append("'" + c.toString() + "'");
        buf_.append(" ");
    }

    private static void sh(Integer n) {
        render(n.toString());
    }

    private static void sh(Double d) {
        render(String.format(java.util.Locale.ROOT, "%.15g", d));
    }

    private static void sh(Character c) {
        render("'" + c.toString() + "'");
    }

    private static void sh(String s) {
        printQuoted(s);
    }

    private static void printQuoted(String s) {
        render("\"" + s + "\"");
    }

    private static void indent() {
        int n = _n_;
        while (n > 0) {
            buf_.append(' ');
            n--;
        }
    }

    private static void backup() {
        int prev = buf_.length() - 1;
        if (buf_.charAt(prev) == ' ')
            buf_.setLength(prev);
    }

    private static void trim() {
        // Trim initial spaces
        int end = 0;
        int len = buf_.length();
        while (end < len && buf_.charAt(end) == ' ')
            end++;
        buf_.delete(0, end);
        // Trim trailing spaces
        end = buf_.length();
        while (end > 0 && buf_.charAt(end - 1) == ' ')
            end--;
        buf_.setLength(end);
    }

    private static int _n_ = 0;
    private static StringBuilder buf_ = new StringBuilder(INITIAL_BUFFER_SIZE);
}

