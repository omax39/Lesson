package ru.khachalov.biblioteka;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>(); //список книг
    private List<Visitor> visitors = new ArrayList<>(); //список посетителей
    private boolean statusLib = false; //Статус библиотеки Закрыта/Открыта
    public void closeLib(){ //Закрыть библиотеку
        statusLib = false;
    }
    public void openLib(){ //открыть библиотеку
        statusLib = true;
    }

    public boolean isStatusLib() { //запрос статуса библиотеки
        return statusLib;
    }

    public void addBook(int id, String name, String place, String section){ //добавить книгу в библиотеку
        books.add(new Book(id, name, place, section));
        books.get(books.size()-1).setAvailable(true);

    }
    public Book getBook(int index){ //получить книгу по индексу
        return books.get(index);
    }
    public Visitor getVisitorLast(){ //получить текущего посетителя
        return visitors.get(visitors.size()-1);
    }
    public void addVisitor(int id, String name){ //добавить посетителя
        visitors.add(new Visitor(id, name));
    }
    public void deleteBook(int index){ //удалить книгу из библиотеки
        books.remove(index);
    }
    public int findOfName(String name){ //поиск индекса книги по имени
        int i;
        for (i = 0; i < books.size(); i++){
            if (books.get(i).getName().equals(name)){
                break;
            }
        }
        return i;
    }
    public List<Book> getAvailBooks(){ //получить доступные книги
        List<Book> availBooks = new ArrayList<>();
        for (int i = 0; i< books.size(); i++){
            if (books.get(i).isAvailable()){
                availBooks.add(books.get(i));
            }
        }
        return availBooks;
    }
    public List<Book> getInfoVisAndBooks(){ //получить информацию о книгах, которые были взяты (когда, кем, сама книга)
        List<Book> infoBooks = new ArrayList<>();
        for (int i = 0; i< books.size(); i++){
            if (books.get(i).usableBook()){
                infoBooks.add(books.get(i));
            }
        }
        return infoBooks;
    }
    public boolean getBookForVis(String nameBook, int id, String nameVis){ //Дать книгу посетителю
        if (isStatusLib()) {
            int indexVis = -1; //индекс посетителя
            for (int i = 0; i < visitors.size(); i++){ // Перебираем и смотрим есть ли у нас уже такой id пользователя
                if(visitors.get(i).getId() == id){     // если есть, то присваиваем indexVis id
                    indexVis = i;
                }
            }
            if (indexVis == -1){                       // Если indexVis все же остался -1, значит такого посетителя нет
                addVisitor(id, nameVis);               // и нужно его добавить
                indexVis = getVisitorLast().getId();   // а indexVis присваиваем id добавленного посетителя
            }
            int idArray = findOfName(nameBook);        // Ищем книгу по имени, которую захотел посетитель.
            if (getBook(idArray).isAvailable()) {      // Если книга доступна для выдачи
                getBook(idArray).setAvailable(false);  // то установливаем флаг "Занята"
                getBook(idArray).setBookGet(visitors.get(indexVis)); // Передаем книге данные посетителя о выдаче.
                visitors.get(indexVis).setBooksTaked(getBook(idArray)); // Передаем пользователю инфо о взятых книгах.
                return true;
            }
        }
        return false;
    }
    public boolean takeBookOfVis(String nameBook, int id, String nameVis){ //Забрать книгу у посетителя
        if (isStatusLib()) {
            int indexVis = -1;
            for (int i = 0; i < visitors.size(); i++){
                if(visitors.get(i).getId() == id){
                    indexVis = i;
                }
            }
            if (indexVis == -1){
                addVisitor(id, nameVis);
                indexVis = getVisitorLast().getId();
            }
            int idArray = findOfName(nameBook);
            if (!getBook(idArray).isAvailable()) {
                getBook(idArray).setAvailable(true);
                getBook(idArray).setBookSet(visitors.get(indexVis));
                return true;
            }
        }
        return false;
    }
//    public Book findOfPlace(String place){
//        int i;
//        for (i = 0; i < books.size(); i++){
//            if (books.get(i).getPlace().equals(place)){
//                break;
//            }
//        }
//        if (books.get(i).isAvailable()) {
//            return books.get(i);
//        } else return null;
//    }
//    public List findOfSection(String section){
//        List<Integer> booksOfSection = new ArrayList<>();
//        for (int i = 0; i < books.size(); i++){
//            if (books.get(i).getSection().equals(section)){
//                booksOfSection.add(i);
//            }
//        }
//        return booksOfSection;
//    }
//    public List findOfId(int id){
//        List<Integer> booksOfId = new ArrayList<>();
//        for (int i = 0; i < books.size(); i++){
//            if (books.get(i).getId()==id){
//                booksOfId.add(i);
//            }
//        }
//        return booksOfId;
//    }
}
