package ru.khachalov.videolection.primeri;

import java.util.Scanner;

public class Primeri {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите год в формате \"yyyy\"");
        String value = scanner.nextLine();
        int year = Integer.parseInt(value);
        System.out.print("Количество дней: ");
        if (year % 400 == 0) {
            System.out.println(366);
        } else if ( year % 4 == 0 & year % 100 != 0) {
            System.out.println(366);
        } else {
            System.out.println(365);
        }

    }
}
