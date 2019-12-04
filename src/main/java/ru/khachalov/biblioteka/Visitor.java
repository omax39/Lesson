package ru.khachalov.biblioteka;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Visitor extends Library{
    private Date time;
    private String name;
    private List<Book> booksTaked = new ArrayList<>();

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

    public List<Book> getBooksTaked() {
        return booksTaked;
    }

    public void setBooksTaked(Book takedBook) {
        this.booksTaked.add(takedBook);
    }
}
