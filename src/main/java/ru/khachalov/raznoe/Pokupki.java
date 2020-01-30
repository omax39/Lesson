package ru.khachalov.raznoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pokupki {
    public static void main(String[] args) throws IOException {
        String s = "";
        String[] products = new String[]{"Хлеб", "Яблоки", "Молоко", "Гречка", "Рис"};
        int[] prices = new int[]{20, 60, 50, 80, 75};
        String[][] pokupki = new String[products.length][4];
        int chisloPokupok = 0;
        int summ = 0;
        System.out.println("Список возможных товаров для покупки");
        for (int i = 0; i < products.length; i++){
            System.out.print(i+1+". ");
            System.out.println(products[i] + " - " + prices[i]);
        }
        while (!s.equals("end")){
            System.out.println("Введите номер товара и количество через пробел или введите `end`");
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            s = br.readLine();
            String[] ss = s.split(" ");
            if (!s.equals("end")) {
                try {
                    int productNum = Integer.parseInt(ss[0]);
                    int productCount = Integer.parseInt(ss[1]);
                    summ += productCount*prices[productNum-1];
                    pokupki[chisloPokupok][0] = products[productNum-1];
                    pokupki[chisloPokupok][1] = Integer.toString(productCount);
                    pokupki[chisloPokupok][2] = Integer.toString(prices[productNum-1]);
                    pokupki[chisloPokupok][3] = Integer.toString(productCount*prices[productNum-1]);
                    chisloPokupok++;
                } catch (NumberFormatException e) {
                    System.out.println("Введите целое число");
                }
            }
        }
        System.out.println("Наименование товара" + "\t" + "Количество" + "\t"
                + "Цена/за.ед" + "\t" + "Общая стоимость");
        for(int i = 0; i < chisloPokupok; i++){
            for(int j = 0; j < 4; j++){
                System.out.print(pokupki[i][j] + "\t" +"\t" + "\t" +"\t");
            }
            System.out.println();
        }
        System.out.println("Итого: " + summ);
    }
}
