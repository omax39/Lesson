package ru.khachalov.one.less3;

public class Sqr implements Expr{
    private final Expr left;
    private final Expr right;

    public Sqr(Expr left, Expr right){
        this.left = left;
        this.right = right;
    }

    @Override
    public int evaluate() {
        int resultSqr = 1;
        for (int i = 0; i < right.evaluate(); i++ ){
            resultSqr = resultSqr*left.evaluate();
        }
        return resultSqr;
    }
}
