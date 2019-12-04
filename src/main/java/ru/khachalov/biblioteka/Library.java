package ru.khachalov.biblioteka;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<Book>();
    public void addBook(int id, String name, String place, String section){
        books.add(new Book(id, name, place, section));
        books.get(books.size()-1).setAvailable(true);

    }
    public void getBook(int index){
        books.get(index);

    }
    public void deleteBook(){

    }
}
