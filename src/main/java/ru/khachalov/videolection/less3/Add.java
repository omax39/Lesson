package ru.khachalov.one.less3;
/* Сложение */
public class Add implements Expr{

    private final Expr left;
    private final Expr right;

    public Add(Expr left, Expr right){
        this.left = left;
        this.right = right;
    }

    @Override
    public int evaluate() {
        return left.evaluate() + right.evaluate();
    }
}
