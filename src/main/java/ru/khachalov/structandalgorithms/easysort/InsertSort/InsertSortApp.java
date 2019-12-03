package ru.khachalov.structandalgorithms.easysort.InsertSort;

public class InsertSortApp {
    public static void main(String[] args)
    {
        int maxSize = 1000000;            // array size
        ArrayIns arr;                 // reference to array
        arr = new ArrayIns(maxSize);  // create the array

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

//        for (long i = 0; i < maxSize; i++){
//            arr.insert(i);
//        }

//        for (long i = maxSize - 1; i >= 0; i--){
//            arr.insert(i);
//        }

        for (int j =  0; j < maxSize; j++){
            arr.insert((long)(Math.random()*(maxSize-1)));
        }

        arr.display();                // display items

        arr.insertionSort();          // insertion-sort them
        arr.display();
//        arr.noDups();
        arr.display();                // display them again
//        System.out.println(arr.median());
    }  // end main()
}
