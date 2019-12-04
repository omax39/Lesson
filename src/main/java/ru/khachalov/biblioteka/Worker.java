package ru.khachalov.biblioteka;

import java.util.Date;

public class Worker extends Library{
    public void pushOfReturnBook(String nameVis, Date timeVis){
        Visitor a = new Visitor(nameVis, timeVis);
        //...//
    }
    public boolean getBookForVis(String nameBook, String nameVis, Date timeVis){
        Visitor a = new Visitor(nameVis, timeVis);
        int idArray = findOfName(nameBook);
        if (getBook(idArray).isAvailable()){
            getBook(idArray).setAvailable(false);
            getBook(idArray).setBookGet(a);
            return true;
        }
        return false;
    }
    public boolean takeBookOfVis(String nameBook, String nameVis, Date timeVis){
        Visitor a = new Visitor(nameVis, timeVis);
        int idArray = findOfName(nameBook);
        if (!getBook(idArray).isAvailable()){
            getBook(idArray).setAvailable(true);
            getBook(idArray).setBookSet(a);
            return true;
        }
        return false;
    }
}
