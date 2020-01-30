package ru.khachalov.raznoe;

public class StatMethods {

    public static int randNumber(int a, int b){
        int c = (int) (a + Math.random()*((b-a)+1));
        return c;
    }

    public static int[] createArrNum(){
        int[] arrNum = new int[10];
        for (int i = 0; i < arrNum.length; i++){
            int av = (int)(Math.random()*50);
            int bv = (int)(av + Math.random()*50);
            if (randNumber(av,bv) > bv || randNumber(av,bv) < av) {
                throw new IllegalArgumentException("Ошибка");
            }
            arrNum[i] = randNumber(av,bv);
        }
        return arrNum;
    }

    public static void sortArr(int[] arr){
        int in, out;
        for(out=1; out<arr.length; out++)
        {
            int temp = arr[out];
            in = out;
            while (in > 0 && arr[in - 1] >= temp)
            {
                arr[in] = arr[in - 1];
                --in;
            }
            arr[in] = temp;
        }
    }

    public static void displayArr(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        for (int k = 0; k < 5; k++){
            int[] temp = createArrNum();
            sortArr(temp);
            displayArr(temp);
            System.out.println();
        }
    }
}
