package ru.khachalov.one.less1;

import java.util.ArrayList;

public class Realization implements FizzBuzz {
    final static int LOWWER = 1;
    final static int HIGTHER = 100;
    static String result = "";
    ArrayList resul = new ArrayList();
    @Override
    public String print(int from, int to) {
        if (to >= from & from >= 0) {
            for (int i = from; i <= to; i++) {
                if (i % 15 == 0) {
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
            }
        } else {
            throw new IllegalArgumentException("Error input param");
        }
        return result;
    }

    public ArrayList getResul() {
        return resul;
    }

    public int getResulSize(){
        FizzBuzz fizzBuzz = new Realization();
        fizzBuzz.print(LOWWER, HIGTHER);
        return fizzBuzz.getResul().size();
    }

    public int sizeResulRigth(){
        int sizeRigth;
        sizeRigth = HIGTHER - LOWWER + 1;
        return sizeRigth;
    }

//    public void checkResul(){
//        if (LOWWER >= 0 & resul.size() != HIGTHER - LOWWER + 1){
//            throw new IllegalArgumentException("size massiv incorrect");
//        }
//    }

    public void outputing (){
        for (int k =0; k < resul.size(); k++){
            //System.out.print(resul.get(k - 1) + "   ");
            OutputOnDisplay.io.print(resul.get(k) + "   ");
            if (k % 15 == 0){
                //System.out.println();
                OutputOnDisplay.io.println();
            }
        }
    }

    public static void main(String[] args) {
        FizzBuzz real = new Realization();
        real.print(LOWWER,HIGTHER);
        real.outputing();
    }
}
