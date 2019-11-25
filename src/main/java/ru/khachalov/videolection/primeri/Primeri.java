package ru.khachalov.videolection.primeri;

public class Primeri {

    public void outNumbers(){
        for (int i = 0; i < 1000; i++){
            System.out.println((char) i);
        }
    }

    public static void main(String[] args) {
        String a = "nbme";
        String b = "name";
        System.out.println(a.compareTo(b));
    }
}
