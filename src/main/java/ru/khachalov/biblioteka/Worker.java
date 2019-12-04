package ru.khachalov.biblioteka;

import java.util.Date;

public class Worker extends Library{
    public void pushOfReturnBook(String nameVis, Date timeVis){ //Оповещение о том, что нужно вернуть
        Visitor a = new Visitor(nameVis);
        //...//
    }
    public boolean getBookForVis(String nameBook, String nameVis){ //Дать книгу посетителю
        if (isStatusLib()) {
            addVisitor(nameVis);
            int idArray = findOfName(nameBook);
            if (getBook(idArray).isAvailable()) {
                getBook(idArray).setAvailable(false);
                getBook(idArray).setBookGet(getVisitorLast());
                getVisitorLast().setBooksTaked(getBook(idArray));
                return true;
            }
        }
        return false;
    }
    public boolean takeBookOfVis(String nameBook, String nameVis){ //Забрать книгу у посетителя
        if (isStatusLib()) {
            addVisitor(nameVis);
            int idArray = findOfName(nameBook);
            if (!getBook(idArray).isAvailable()) {
                getBook(idArray).setAvailable(true);
                getBook(idArray).setBookSet(getVisitorLast());
                return true;
            }
        }
        return false;
    }
}
