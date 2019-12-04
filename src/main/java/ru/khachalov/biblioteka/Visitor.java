package ru.khachalov.biblioteka;

import java.util.Date;

public class Visitor extends Library{
    private Date time = new Date();
    private String name;

    Visitor(String name, Date time){
        this.name = name;
        this.time = time;
    }

    public Date getTime() {
        return time;
    }

    public String getName() {
        return name;
    }
}
