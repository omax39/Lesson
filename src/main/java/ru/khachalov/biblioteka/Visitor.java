package ru.khachalov.biblioteka;

import java.util.Date;

public class Visitor extends Library{
    private Date time = new Date();
    private String name;
    private String pushs;

    public Date getTime() {
        return time;
    }

    public String getName() {
        return name;
    }
}
