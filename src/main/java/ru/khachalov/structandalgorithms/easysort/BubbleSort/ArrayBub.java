package ru.khachalov.structandalgorithms.easysort.BubbleSort;

public class ArrayBub {
    private long[] a;                 // ref to array a
    private int nElems;               // number of data items
    //--------------------------------------------------------------
    public ArrayBub(int max)          // constructor
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
    public void bubbleSort()
    {
        int out, in, low = 0,high = nElems-1;

        /*for(out=nElems-1; out>0; out--)   // outer loop (backward)
            for(in=0; in<out; in++)        // inner loop (forward)
                if( a[in] > a[in+1] )       // out of order?
                    swap(in, in+1);*/          // swap them

        while (high > low){
            for(in=low; in<high; in++) {        // inner loop (forward)
                if (a[in] > a[in + 1])       // out of order?
                    swap(in, in + 1);
            }
            high--;
            for (out=high; out > low; out--){
                if (a[out] < a[out - 1]){
                    swap(out, out -1 );
                }
            }
            low++;
        }

    }  // end bubbleSort()

    public void oddEvenSort(){
        boolean c = false;
        int out = nElems-1;
        while (!c) {
            c = true;
            for (int j = 1; j < out; j=j+2)   // outer loop (backward)
                if (a[j] > a[j+1]) {
                    swap(j, j + 1);
                    if (c) c = false;
                }
            for (int i = 0; i < out; i=i+2)   // outer loop (backward)
                if (a[i] > a[i+1]) {
                    swap(i, i + 1);
                    if (c) c = false;
                }
        }
    }

    //--------------------------------------------------------------
    private void swap(int one, int two)
    {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
//--------------------------------------------------------------
}
