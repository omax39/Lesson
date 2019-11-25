package ru.khachalov.structandalgorithms.orderarrays;

public class OrderedApp {
    public static void main(String[] args)
    {
        int maxSize = 100;             // array size
        OrdArray arr;                  // reference to array
        OrdArray arr1;
        OrdArray arr2;
        arr = new OrdArray(maxSize*2);   // create the array
        arr1 = new OrdArray(maxSize);
        arr2 = new OrdArray(maxSize);

        for(int i = 0; i < (int) (Math.random()*(maxSize+1)); i++ ){
            arr1.insert((int)(Math.random()*(maxSize+1)));
        }
        for(int i = 0; i < (int) (Math.random()*(maxSize+1)); i++ ){
            arr2.insert((int)(Math.random()*(maxSize+1)));
        }
        arr1.display();
        arr2.display();
        int sizeArr12 = arr1.size() + arr2.size();
        if (arr1.size() < arr2.size()){
            arr.merge(arr1, arr2);
        } else {
            arr.merge(arr2, arr1);
        }

        arr.display();
        if (sizeArr12 == arr.size()){
            System.out.println("Yes");
        } else System.out.println("No");
        //arr.insert(77);                // insert 10 items
        //arr.insert(99);
        //arr.insert(44);
        //arr.insert(55);
        //arr.insert(22);
        //arr.insert(88);
        //arr.insert(11);
        //arr.insert(00);
        //arr.insert(66);
        //arr.insert(33);

        //arr.insert(35);
        //int searchKey = 55;            // search for item
        //if( arr.getVal(arr.find(searchKey)) == searchKey )
        //    System.out.println("Found " + searchKey);
        //else
         //   System.out.println("Can't find " + searchKey);

        //arr.display();                 // display items

        //arr.delete(00);                // delete 3 items
        //arr.delete(55);
        //arr.delete(99);

        //arr.display();                 // display items again
    }  // end main()
}
