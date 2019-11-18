package ru.khachalov.structandalgorithms.arrays;

import java.util.Arrays;

public class HighArrayApp {
    public static void main(String[] args)
    {
        HighArray orderArr;
        int maxSize = 100;            // array size
        orderArr = new HighArray(maxSize);
        HighArray arr;                // reference to array
        arr = new HighArray(maxSize); // create the array

        arr.insert(77);               // insert 10 items
        arr.insert(99);
        arr.insert(77);
        arr.insert(22);
        arr.insert(77);
        arr.insert(88);
        arr.insert(22);
        arr.insert(00);
        arr.insert(99);
        arr.insert(33);

        arr.display();
        arr.noDups();
        arr.display();                // display items

        while (arr.getMax() != -1){
            orderArr.insert(arr.getMax());
            arr.removeMax();
        }
        orderArr.display();

        //int searchKey = 35;           // search for item
        //if( arr.find(searchKey) )
        //    System.out.println("Found " + searchKey);
        //else
        //    System.out.println("Can't find " + searchKey);

        //arr.delete(00);               // delete 3 items
        //arr.delete(55);
        //arr.delete(99);

        //arr.display();                // display items again
        //System.out.println(arr.getMax());
        //arr.removeMax();
        //arr.display();
    }  // end main()
}
