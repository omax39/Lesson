package ru.khachalov.structandalgorithms.linkedlists.SortedList;


public class PriorApp {
    public static void main(String[] args) {
        SortedList sortedList = new SortedList();
        PriorityQueue priorityQueue = new PriorityQueue(sortedList);
        priorityQueue.insert(6);
        priorityQueue.insert(3);
        priorityQueue.insert(7);
        priorityQueue.insert(8);
        priorityQueue.insert(0);
        priorityQueue.insert(1);

        priorityQueue.display();

        while (!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.remove().dData);
            priorityQueue.display();
        }
    }
}
