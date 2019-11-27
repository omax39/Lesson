package ru.khachalov.videolection.less3;

public class UnarSub implements Expr{
    private final Expr right;

    public UnarSub(Expr right){
        this.right = right;
    }

    @Override
    public int evaluate() {
        return  (-1) * right.evaluate();
    }
}
