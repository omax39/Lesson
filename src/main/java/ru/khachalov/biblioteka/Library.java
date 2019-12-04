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
    public void deleteBook(int index){
        books.remove(index);
    }
    public Book findOfName(String name){
        int i;
        for (i = 0; i < books.size(); i++){
            if (books.get(i).getName().equals(name)){
                break;
            }
        }
        if (books.get(i).isAvailable()) {
            return books.get(i);
        } else return null;
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
