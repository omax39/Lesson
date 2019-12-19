package ru.khachalov.structandalgorithms.linkedlists.SortedList;

public class Link {
    public long dData;                  // data item
    public Link next;                   // next link in list
    // -------------------------------------------------------------
    public Link(long dd)                // constructor
    { dData = dd; }
    // -------------------------------------------------------------
    public void displayLink()           // display this link
    { System.out.print(dData + " "); }
}
