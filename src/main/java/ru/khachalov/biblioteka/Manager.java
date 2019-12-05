package ru.khachalov.biblioteka;

public class Manager {
    private Library library;
    public Manager(Library library){
        this.library = library;
    }
    public void closeLibrary(){
        library.closeLib();
    }
    public void openLibrary(){
        library.openLib();
    }
    public void addBookInLibrary(int id, String name, String place, String section){
        library.addBook(id,name,place,section);
    }
    public void deleteBookOfLibrary(int index){ //удалить книгу из библиотеки
        library.deleteBook(index);
    }
}
