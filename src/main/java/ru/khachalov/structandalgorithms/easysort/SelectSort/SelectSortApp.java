package ru.khachalov.structandalgorithms.easysort.SelectSort;

public class SelectSortApp {
    public static void main(String[] args)
    {
        int maxSize = 100000;            // array size
        ArraySel arr;                 // reference to array
        arr = new ArraySel(maxSize);  // create the array

/*        arr.insert(77);               // insert 10 items
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);*/

        for (long i = 0; i < maxSize; i++){
            arr.insert(i);
        }

//        for (long i = maxSize - 1; i >= 0; i--){
//            arr.insert(i);
//        }

//        for (int j =  0; j < maxSize; j++){
//            arr.insert((long)(Math.random()*(maxSize-1)));
//        }

//        arr.display();                // display items

        arr.selectionSort();          // selection-sort them

//        arr.display();                // display them again
    }  // end main()
}
