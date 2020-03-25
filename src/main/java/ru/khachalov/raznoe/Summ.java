package ru.khachalov.raznoe;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Summ {

    public static String inputLine(){
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        return line;
    }

    public static String inputLineFile() throws IOException {
        FileReader fileReader = new FileReader("src/main/java/ru/khachalov/raznoe/input.txt");
        Scanner in = new Scanner(fileReader);
        String line = in.nextLine();
        fileReader.close();
        return line;
    }

    public static long summing(int a, int b){
        return a+b;
    }

    public static void main(String[] args) throws IOException {
        String inpL = inputLine();
//        FileWriter fileWriter = new FileWriter("src/main/java/ru/khachalov/raznoe/output.txt");
        String[] num = inpL.split(" ");
        int a = Integer.parseInt(num[0]);
        int b = Integer.parseInt(num[1]);
        System.out.print(summing(a,b));
//        fileWriter.write(Long.toString(summing(a,b)));
//        fileWriter.close();
    }
}
