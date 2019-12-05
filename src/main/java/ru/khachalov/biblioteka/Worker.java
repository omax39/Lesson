package ru.khachalov.biblioteka;

import java.util.Date;

public class Worker {
    private Library library;
    public Worker(Library library){
        this.library = library;
    }
    public void pushOfReturnBook(String nameVis, Date timeVis){ //Оповещение о том, что нужно вернуть

    }
    public void getBookForVisOfLib(String nameBook, int id, String nameVis) {
        library.getBookForVis(nameBook,id,nameVis);
    }
    public void takeBookOfVisInLib(String nameBook, int id, String nameVis){
        library.takeBookOfVis(nameBook,id,nameVis);
    }
}
