package ru.khachalov.one.less3;

public class Calculator implements ExprBuilder{

    public static String removeCharAt(String s, int pos){
        return s.substring(0, pos) + s.substring(pos + 1);
    }

    public Expr realizationExpr(String left, String right, String opec){
        if (opec.equals("-") & (left.equals(null) || left.equals("+")
                || left.equals("*") || left.equals("-")|| left.equals("/") )) {
            return new UnarSub(new Const(Integer.parseInt(right)));
        } else if (opec.equals("^")){
            return new Sqr(new Const(Integer.parseInt(left)),
                    new Const(Integer.parseInt(right)));
        } else if (opec.equals("*")){
            return new Mult(new Const(Integer.parseInt(left)),
                    new Const(Integer.parseInt(right)));
        } else if (opec.equals("/")){
            return new Div(new Const(Integer.parseInt(left)),
                    new Const(Integer.parseInt(right)));
        } else if (opec.equals("+")){
            return new Add(new Const(Integer.parseInt(left)),
                    new Const(Integer.parseInt(right)));
        } else if (opec.equals("-")){
            return new Sub(new Const(Integer.parseInt(left)),
                    new Const(Integer.parseInt(right)));
        }
        return null;
    }


    public Expr parsing(String in){
        int i =1;
        Expr expr = new Calculator().realizationExpr(Character.toString(in.charAt(i-1)),
                Character.toString(in.charAt(i+1)), Character.toString(in.charAt(1)));

        for (i = 1; i < in.length() - 1; i++){
            return expr;
        }
        return null;
    }


    @Override
    public Expr build(String input) {
        int i = 1;
        input = input.replaceAll(" ", "");
        String correctSymbol = "1234567890^+-*/()";
        int corrSym = 0;
        for (int k = 0; k < input.length(); k++){
            if (correctSymbol.contains(Character.toString(input.charAt(k)))) {
                corrSym++;
            }
        }
        if (corrSym != input.length()){
            throw new IllegalArgumentException("wrong String");
        }



        return parsing(input);
        //while (input.contains("(")){
         //   Par par = new Par(input);
        //}

    }

    public static void main(String[] args) {
        System.out.println(new Calculator().build("5*6+4").evaluate());
    }
}
