package ru.khachalov.yandexless;

import java.util.Objects;

public class FoodCatalog {
    private String t, u;
    private int a;
    private double pr, f , ch, fv;
    public FoodCatalog(String t, int a, String u, double pr, double f, double ch, double fv){
        this.t = t;
        this.u = u;
        this.a = a;
        this.pr = pr;
        this.f = f;
        this.ch = ch;
        this.fv = fv;
    }

    public String getT() {
        return t;
    }

    public String getU() {
        return u;
    }

    public int getA() {
        return a;
    }

    public double getPr() {
        return pr;
    }

    public double getF() {
        return f;
    }

    public double getCh() {
        return ch;
    }

    public double getFv() {
        return fv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodCatalog that = (FoodCatalog) o;
        return Objects.equals(t, that.t);
    }

    @Override
    public int hashCode() {
        return Objects.hash(t);
    }
}
