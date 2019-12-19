package ru.khachalov.structandalgorithms.linkedlists.SortedList;

public class PriorityQueue {
    SortedList sortedList;
    PriorityQueue(SortedList sortedList){
        this.sortedList = sortedList;
    }

    public boolean isEmpty(){
        return sortedList.isEmpty();
    }

    public void insert(long key){
        sortedList.insert(key);
    }
    public Link remove(){
        return sortedList.remove();
    }

    public void display(){
        sortedList.displayList();
    }
}
