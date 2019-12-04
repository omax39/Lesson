package ru.khachalov.biblioteka;

import java.util.Date;

public class Visitor extends Library{
    private Date time;
    private String name;

    Visitor(String name){
        this.name = name;
    }

    public Date getTime() {
        time = new Date();
        return time;
    }

    public String getName() {
        return name;
    }
}
