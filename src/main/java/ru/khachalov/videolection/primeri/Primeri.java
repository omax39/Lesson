package ru.khachalov.videolection.primeri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class Primeri {

    public static void writeMatr(int[][] arr){
        Random random = new Random();
        for (int i = 0; i< arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = random.nextInt(256);
            }
        }
    }

    public static void displayMatr(int[][] arr){
        for (int i = 0; i< arr.length; i++) {
            for (int j = 0; j< arr.length; j++) {
                System.out.format("%4d", arr[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[][] rotateMatr(int[][] arr, int degree){
        int[][] rotatedArr = new int[arr.length][arr.length];
        if (degree%90 == 0){
            for (int i = 0; i < degree/90; i++){
                for (int k = 0; k < arr.length; k++){
                    for (int j = arr.length-1; j >= 0; j--){
                        rotatedArr[k][arr.length - j -1] = arr[j][k];
                    }
                }
                arr = rotatedArr;
            }
        }
        return rotatedArr;
    }

    public static void main(String[] args) throws IOException {
        int SIZE = 8;
        int[][] colors = new int[SIZE][SIZE];
        int[][] rotatedColors;

        writeMatr(colors);
        displayMatr(colors);
        System.out.println("Введите градус кратный 90: ");
        int deg = getInt();
        if (deg%90 == 0) {
            rotatedColors = rotateMatr(colors, deg);
            displayMatr(rotatedColors);
        } else {
            System.out.println("Неверный градус поворота");
        }
    }

    public static int getInt() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return Integer.parseInt(s);
    }
}
