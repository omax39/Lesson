package ru.khachalov.biblioteka;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Book extends Library{
    private int id; //id книги
    private String name; //ее имя
    private String place; //место на полке
    private String section; //раздел
    private List bookGet = new ArrayList<Visitor>(); //список Посетителей взявших книги (Имя и время)
    private List bookSet = new ArrayList<Visitor>(); //список Посетителей отдавших книги (Имя и время)
    private boolean available;
    Book(int id, String name, String place, String section){
        this.id = id;
        this.name = name;
        this.place = place;
        this.section = section;
    }

    public void setBookGet(List bookGet) {
        this.bookGet = bookGet;
    }

    public void setTimeSet(List bookSet) {
        this.bookSet = bookSet;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPlace() {
        return place;
    }

    public String getSection() {
        return section;
    }

    public List getBookGet() {
        return bookGet;
    }

    public List getBookSet() {
        return bookSet;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
