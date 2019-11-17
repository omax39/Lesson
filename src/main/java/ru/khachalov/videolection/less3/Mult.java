package ru.khachalov.one.less3;

public class Mult implements Expr{

    private final Expr left;
    private final Expr right;

    public Mult(Expr left, Expr right){
        this.left = left;
        this.right = right;
    }

    @Override
    public int evaluate() {
        return left.evaluate() * right.evaluate();
    }
}
