package ru.khachalov.biblioteka;

import java.util.Date;

public class Worker extends Library{
    public void pushOfReturnBook(){

    }

    @Override
    public Book findOfName(String name) {
        return super.findOfName(name);
    }

    public Book getBookForVis(String nameBook, String nameVis, Date timeVis){
        return findOfName(nameBook);
    }
}
