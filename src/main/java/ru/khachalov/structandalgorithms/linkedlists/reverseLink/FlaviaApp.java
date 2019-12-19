package ru.khachalov.structandalgorithms.linkedlists.reverseLink;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FlaviaApp {
    static ReversLink reversLink = new ReversLink();
    public static int getInt() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return Integer.parseInt(s);
    }


    public static void main(String[] args) throws IOException {

        int numPeople;
        int numStep;
        int numFirst;
        System.out.println("Введите кол-во людей: ");
        numPeople = getInt();
        System.out.println("Введите размер шага отсчета: ");
        numStep = getInt();
        System.out.println("С кого начнем? ");
        numFirst = getInt();

        for (int i = 1; i <= numPeople; i++){
            reversLink.insert(i);
        }
        reversLink.find(numFirst);
        reversLink.displayRev();
        while (numPeople != 1){
            for (int i = 0; i < numStep; i++){
                reversLink.stepWithPrev();
            }
            Link a = reversLink.removeCur();
            System.out.print(a.data + " ");
            numPeople--;
        }
        System.out.print("Остался человек под номером - ");
        reversLink.displayRev();
    }
}
