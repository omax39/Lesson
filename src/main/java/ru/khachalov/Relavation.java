package ru.khachalov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Relavation {

    public static String inputLine(){
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        return line;
    }

    public static void findRel(){
        int o = 0;
        int countTests = Integer.parseInt(inputLine());
        int[] arrSums = new int[countTests];
        for (int i =0; i < countTests; i++){
            int sum =0;
            String[] ss = inputLine().split(" ");
            int[] rell = new int[Integer.parseInt(ss[0])];
            String[] rel = inputLine().split(" ");
            for (int j = 0; j< rel.length; j++){
                rell[j] = (Integer.parseInt(rel[j]));
            }
            Arrays.sort(rell);
            int k = rell.length-1;
            while (k >= Integer.parseInt(ss[1]) || rell[k] > 0){
                sum += rell[k];
                k--;
                if (k == -1) break;
            }
            arrSums[o] = sum;
            o++;
        }
        for (int i = 0; i < arrSums.length; i++){
            System.out.println(arrSums[i]);
        }
    }

    public static void main(String[] args) {
        findRel();
    }
}
