package ru.khachalov.biblioteka;

import java.util.Date;

public class Worker extends Library{
    public void pushOfReturnBook(String nameVis, Date timeVis){
        Visitor a = new Visitor(nameVis);
        //...//
    }
    public boolean getBookForVis(String nameBook, String nameVis){
        addVisitor(nameVis);
        int idArray = findOfName(nameBook);
        if (getBook(idArray).isAvailable()){
            getBook(idArray).setAvailable(false);
            getBook(idArray).setBookGet(getVisitorLast());
            return true;
        }
        return false;
    }
    public boolean takeBookOfVis(String nameBook, String nameVis){
        addVisitor(nameVis);
        int idArray = findOfName(nameBook);
        if (!getBook(idArray).isAvailable()){
            getBook(idArray).setAvailable(true);
            getBook(idArray).setBookSet(getVisitorLast());
            return true;
        }
        return false;
    }
}
