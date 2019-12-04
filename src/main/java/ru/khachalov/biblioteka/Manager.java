package ru.khachalov.biblioteka;

public class Manager extends Library {
    private boolean statusLib = false;
    public void closeLib(){
        statusLib = false;
    }
    public void openLib(){
        statusLib = true;
    }
    public boolean getStatusLib(){
        return statusLib;
    }

    @Override
    public void addBook(int id, String name, String place, String section) {
        super.addBook(id, name, place, section);
    }

    @Override
    public void deleteBook(int index) {
        super.deleteBook(index);
    }
}
