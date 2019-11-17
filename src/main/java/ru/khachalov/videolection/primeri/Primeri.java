package ru.khachalov.one.primeri;

public class Primeri {

    public void outNumbers(){
        for (int i = 0; i < 1000; i++){
            System.out.println((char) i);
        }
    }

    public static void main(String[] args) {
        Primeri primer = new Primeri();
        primer.outNumbers();
    }
}
