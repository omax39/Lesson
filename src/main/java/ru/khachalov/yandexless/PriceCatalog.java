package ru.khachalov.yandexless;

import java.util.Objects;

public class PriceCatalog {
    private String t, u;
    private int p, a;

    public PriceCatalog(String t, int p, int a,  String u){
        this.t = t;
        this.u = u;
        this.a = a;
        this.p = p;
    }
    public String getT() {
        return t;
    }

    public String getU() {
        return u;
    }

    public int getP() {
        return p;
    }

    public int getA() {
        return a;
    }

    public void setU(String u) {
        this.u = u;
    }

    public void setA(int a) {
        this.a = a;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceCatalog that = (PriceCatalog) o;
        return Objects.equals(t, that.t);
    }

    @Override
    public int hashCode() {
        return Objects.hash(t);
    }

}
