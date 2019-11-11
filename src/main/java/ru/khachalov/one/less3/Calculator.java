package ru.khachalov.one.less3;

import java.awt.geom.AffineTransform;
import java.util.Arrays;

public class Calculator implements ExprBuilder{

    Expr exprReal;

    public static String removeCharAt(String s, int pos){
        return s.substring(0, pos) + s.substring(pos + 1);
    }

    public int realizationExpr(String left, String right, char opec){
        if (opec == '+'){
            exprReal = new Add(new Const(Integer.parseInt(left)), new Const(Integer.parseInt(right)));
            return exprReal.evaluate();
        }
        if (opec == '-'){
            exprReal = new Sub(new Const(Integer.parseInt(left)), new Const(Integer.parseInt(right)));
            return exprReal.evaluate();
        }
        if (opec == '*'){
            exprReal = new Mult(new Const(Integer.parseInt(left)), new Const(Integer.parseInt(right)));
            return exprReal.evaluate();
        }
        if (opec == '/'){
            exprReal = new Div(new Const(Integer.parseInt(left)), new Const(Integer.parseInt(right)));
            return exprReal.evaluate();
        }
        if (opec == '^'){
            exprReal = new Sqr(new Const(Integer.parseInt(left)), new Const(Integer.parseInt(right)));
            return exprReal.evaluate();
        }
        if (opec == '-' & left == null) {
            exprReal = new UnarSub(new Const(Integer.parseInt(right)));
            return exprReal.evaluate();
        }
        return 0;
    }

    @Override
    public Expr build(String input) {
        input = input.replaceAll(" ", "");
        String correctSymbol = "1234567890^+-*/()";
        if (input.matches(correctSymbol)){
            throw new IllegalArgumentException("wrong String");
        }
        System.out.println(input);
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new Calculator().build("2*( -1+2^3+ 6/3* 5+2*(4-5))"));
    }
}
