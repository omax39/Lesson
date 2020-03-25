package ru.khachalov.yandexless;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Dishes {
    private String name;
    private List<PriceCatalog> ingr;
    private int countDish;

    public int getCountDish() {
        return countDish;
    }

    public void setCountDish(int countDish) {
        this.countDish = countDish;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PriceCatalog> getIngr() {
        return ingr;
    }

    public void setIngr(PriceCatalog priceCatalog) {
        this.ingr.add(priceCatalog);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dishes dishes = (Dishes) o;
        return Objects.equals(name, dishes.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
