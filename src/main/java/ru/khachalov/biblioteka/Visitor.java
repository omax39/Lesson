package ru.khachalov.biblioteka;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Visitor{
    private Date time;
    private String name;
    private List<Book> booksTaked = new ArrayList<>();
    private int id;
    private Library library;
    Visitor(int id, String name){
        this.name = name;
        this.id = id;
    }
    Visitor(int id, String name, Library library){
        this.name = name;
        this.id = id;
        this.library = library;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void takeBookInLib(String nameBook, int id, String nameVis) {
        library.getBookForVis(nameBook,id,nameVis);
    }
    public void getBookOfLib(String nameBook, int id, String nameVis){
        library.takeBookOfVis(nameBook,id,nameVis);
    }
}
