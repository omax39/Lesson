package ru.khachalov.structandalgorithms.stackandother.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Cashbox {

    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static void main(String[] args) throws IOException {
        List<Integer> purchases = new ArrayList<>();
        List<Queue> queues = new ArrayList<>();
        String input;
        System.out.println("Введите кол-во касс: ");
        int j = Integer.parseInt(getString());
        for(int i = 0; i < j; i++){
            queues.add(new Queue(5));
        }
        int time = 0;
        System.out.println("Нажмите клавишу");
        while (true){
            input = getString();
            if (input.equals("exit")) {
                System.out.println("Маназин закрыт");
                break;
            }
            int purchas = (int) (Math.random() * 5 + 1);
            while (true) {
                int a = (int) (Math.random()*queues.size());
                if (!queues.get(a).isFull()) {
                    queues.get(a).insert(purchas);
                    break;
                } else {
                    System.out.println("Очередь полна, идем в другую");
                    time++;
                    queues.get(a).remove();
                    System.out.println("Клиент ушел с кассы");
                }
            }
            time++;

            System.out.println("Прошло времени " + time);
            for (int i = 0; i < queues.size(); i++){
                queues.get(i).redPurch();
                if (queues.get(i).peekFront() == 0){
                    queues.get(i).remove();
                    System.out.println("Клиент ушел с кассы");
                }
                System.out.println("Касса номер: " + i);
                queues.get(i).displayQueue();
            }
        }
    }
}
