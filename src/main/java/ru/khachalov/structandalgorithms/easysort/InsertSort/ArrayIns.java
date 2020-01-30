package ru.khachalov.structandalgorithms.easysort.InsertSort;

public class ArrayIns {
    private long[] a;                 // ref to array a
    private int nElems;               // number of data items
    //--------------------------------------------------------------
    public ArrayIns(int max)          // constructor
    {
        a = new long[max];                 // create the array
        nElems = 0;                        // no items yet
    }
    //--------------------------------------------------------------
    public void insert(long value)    // put element into array
    {
        a[nElems] = value;             // insert it
        nElems++;                      // increment size
    }
    //--------------------------------------------------------------
    public void display()             // displays array contents
    {
        for(int j=0; j<nElems; j++)       // for each element,
            System.out.print(a[j] + " ");  // display it
        System.out.println("");
    }
    //--------------------------------------------------------------
    public void insertionSort()
    {
        int in, out;
//        long copy = 0;
//        long comp = 0;
//        int countDup = 0;
        for(out=1; out<nElems; out++)     // out is dividing line
        {
            long temp = a[out];            // remove marked item
//            copy++;
            in = out;                      // start shifts at out
            while(in>0 && a[in-1] >= temp) // until one is smaller,
            {
                a[in] = a[in-1];            // shift item to right
//                copy++;
//                comp++;
                --in;                       // go left one position
            }
            a[in] = temp;
//            if (a[in+1] == temp){
//                while (in > 0){
//                    a[in] = a[in-1];
//                    in--;
//                }
//                a[in] = -1;
////                countDup++;
//            }
//            comp++;
                   // insert marked item
//            copy++;
        }  // end for
//        for (int i = 0; i < nElems - countDup; i++){
//            if (countDup < nElems){
//                a[i]=a[i+countDup];
//            }
//        }
//        nElems = nElems - countDup;
//        System.out.println("Кол-во копирований  " + copy);
//        System.out.println("Кол-во сравнений  " + comp);
//        System.out.println("Всего операций  " + (comp+copy));
    }  // end insertionSort()

    public double median(){
        int halfNElems = nElems/2;
        if(nElems%2 == 0){
            return (double)(a[halfNElems]+a[halfNElems-1])/2;
        }
        return (double) a[halfNElems];
    }

    public long getVal(int index){
        return a[index];
    }

//    public void noDups(){
//        int c = 0;
//        int m = 1;
//        for (int i = 1; i < nElems; i++){
//            for (int l = 0; l < m; l++){
//                if (a[i] == a[l]) {
//                    c++;
//                }
//            }
//            if (c == 0){
//                a[m] = a[i];
//                m++;
//            }
//            c=0;
//        }
//        nElems= m;
//    }

//--------------------------------------------------------------
}
