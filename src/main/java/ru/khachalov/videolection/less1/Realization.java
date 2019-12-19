package ru.khachalov.videolection.less1;

import java.util.ArrayList;

/*
Приложение вывода кратности 3, 5 или 15
Числа перебираются в выбранном промежутке.
Если число кратно 3 то выводится сообщение "Fizz"
Если кратно 5, то "Buzz"
Если кратно 15, то "FizzBuzz"
В других случаях выводится просто число
*/

public class Realization implements FizzBuzz {
    final static int LOWWER = 1;    // Нижняя граница перебираемых чисел
    final static int HIGTHER = 100;     // Верхняя граница
    static String result = "";      // Создаем строку получаемого результата
    ArrayList resul = new ArrayList();      // Объявляем список полученных нами результатов

    @Override
    public String print(int from, int to) {     // Метод реализации перебора чисел
        if (to >= from & from >= 0) {     // Условие положительности нижней границы и также что верхняя не меньше нижней
            for (int i = from; i <= to; i++) {      // Цикл перебора чисел
                if (i % 15 == 0) {      // Условие кратности 15
                    result = "FizzBuzz";    // Если истинно, присваиваем переменной строки "FizzBuzz"
                    resul.add(result + "(" + i + ")");     // и добавляем в наш список результатов
                } else if (i % 5 == 0) {      // Условие кратности 5
                    result = "Buzz";           // Если истинно, присваиваем переменной строки "Buzz"
                    resul.add(result + "(" + i + ")");      // и добавляем в наш список результатов
                } else if (i % 3 == 0) {       // Условие кратности 3
                    result = "Fizz";        // Если истинно, присваиваем переменной строки "Fizz"
                    resul.add(result + "(" + i + ")");      // и добавляем в наш список результатов
                } else {                       // Если число не кратно ни одному из приведенных условий,
                    result = String.valueOf(i);    // то присваиваем значение данного числа
                    resul.add(result);      // и добавляем его в наш список
                }
            }
        } else {                        // Если изначальная проверка границ не пройдена,
            throw new IllegalArgumentException("Error input param");    // то выбрасываем исключение
        }
        return result;      // Формальный возврат для тестов, например, чтобы вернуть результат from = to = 45
    }

    public ArrayList getResul() {       // Метод получения списка резульататов
        return resul;
    }

    public int getResulSize(){      // Метод получения размера полученных результатов (Тоже для тестов)
        FizzBuzz fizzBuzz = new Realization();
        fizzBuzz.print(LOWWER, HIGTHER);
        return fizzBuzz.getResul().size();
    }

    public int sizeResulRigth(){    // Метод получения правильно количества чисел (для тестов)
        int sizeRigth;
        sizeRigth = HIGTHER - LOWWER + 1;
        return sizeRigth;
    }

//    public void checkResul(){
//        if (LOWWER >= 0 & resul.size() != HIGTHER - LOWWER + 1){
//            throw new IllegalArgumentException("size massiv incorrect");
//        }
//    }

    public void outputing (){       // Вывод результатов на экран
        for (int k =0; k < resul.size(); k++){      // Цикл перебора элементов списка
            //System.out.print(resul.get(k - 1) + "   ");
            OutputOnDisplay.io.print(resul.get(k) + "   ");     // Метод вывода на экран класса OutputOnDisplay (Не мой)
            if (k % 15 == 0){       // Для красоты вывода, после какждых 15 значений
                //System.out.println();
                OutputOnDisplay.io.println();   // делаем перенос строки
            }
        }
    }

    public static void main(String[] args) {
        FizzBuzz real = new Realization();      // Создаем объект класса Realization
        real.print(LOWWER,HIGTHER);     // Вызывает метод реализации
        real.outputing();       // Выводим на экран результаты
    }
}
