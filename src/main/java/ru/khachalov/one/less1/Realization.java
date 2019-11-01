package ru.khachalov.one.less1;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Realization implements FizzBuzz {
    static String result = "";
    ArrayList resul = new ArrayList();
    @Override
    public String print(int from, int to) {
        if (to >= from & from >= 0) {
            for (int i = from; i <= to; i++) {
                if (i % 3 == 0 & i % 5 == 0) {
                    result = "FizzBuzz";
                    resul.add(result + "(" + i + ")");
                } else if (i % 5 == 0) {
                    result = "Buzz";
                    resul.add(result + "(" + i + ")");
                } else if (i % 3 == 0) {
                    result = "Fizz";
                    resul.add(result + "(" + i + ")");
                } else {
                    result = String.valueOf(i);
                    resul.add(result);
                }
                //System.out.print(resul.get(i - 1) + "   ");
                //OutputOnDisplay.io.print(resul.get(i - 1) + "   ");
                if (i % 15 == 0){
                    //System.out.println();
                    //OutputOnDisplay.io.println();
                }
            }
        } else {
            throw new IllegalArgumentException("Error input param");
        }
        return result;
    }

    public static void main(String[] args) {
        new Realization().print(1,100);
    }
}
