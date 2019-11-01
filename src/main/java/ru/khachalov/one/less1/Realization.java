package ru.khachalov.one.less1;

public class Realization implements FizzBuzz {
    static String result = "";
    @Override
    public String print(int from, int to) {
        if (to >= from & from >= 0) {
            for (int i = from; i <= to; i++) {
                if (i % 3 == 0 & i % 5 == 0) {
                    result = "FizzBuzz";
                } else if (i % 5 == 0) {
                    result = "Buzz";
                } else if (i % 3 == 0) {
                    result = "Fizz";
                } else {
                    result = String.valueOf(i);
                }
            }
        } else {
            throw new IllegalArgumentException("Error input param");
        }
        return result;
    }

    public static void main(String[] args) {
        new Realization().print(1, 1000);
    }
}
