package ru.khachalov.structandalgorithms.stackandother.PriorityQ;

public class RePriorityQ {
    // array in sorted order, from max at 0 to min at size-1
    private int maxSize;
    private long[] queArray;
    private int nItems;
    //-------------------------------------------------------------
    public RePriorityQ(int s)          // constructor
    {
        maxSize = s;
        queArray = new long[maxSize];
        nItems = 0;
    }
    //-------------------------------------------------------------
    public void insert(long item)    // insert item
    {
        if (!isFull()){
            queArray[nItems++] = item;
        } else {
            throw  new IllegalArgumentException("Is Full");
        }
    }  // end insert()
    //-------------------------------------------------------------
    public long remove() {
        long temp = queArray[0];
        int j = 0;
        if (!isEmpty()){
            for (int i = 1; i < nItems; i++){
                if (temp > queArray[i]){
                    temp = queArray[i];
                    j = i;
                }
            }
            for (int i = j; i < nItems-1; i++){
                queArray[i] = queArray[i+1];
            }
            nItems--;
        } else {
            throw new IllegalArgumentException("Is Empty");
        }
        return temp;
    }
    //-------------------------------------------------------------
//    public long peekMin()            // peek at minimum item
//    { return queArray[nItems-1]; }
    //-------------------------------------------------------------
    public boolean isEmpty()         // true if queue is empty
    { return (nItems==0); }
    //-------------------------------------------------------------
    public boolean isFull()          // true if queue is full
    { return (nItems == maxSize); }
//-------------------------------------------------------------
}
