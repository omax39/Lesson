package ru.khachalov.biblioteka;

public class Manager extends Library {
    @Override
    public void closeLib() {
        super.closeLib();
    }

    @Override
    public void openLib() {
        super.openLib();
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
