package ru.khachalov.videolection.less3;

public class Const implements Expr {

    private final int value;

    public Const(int value){
        this.value = value;
    }


    @Override
    public int evaluate() {
        return value;
    }
}
