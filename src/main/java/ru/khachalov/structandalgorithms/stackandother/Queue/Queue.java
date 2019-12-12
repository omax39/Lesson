package ru.khachalov.structandalgorithms.stackandother.Queue;

public class Queue {
    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;
    private int nItems;
    //--------------------------------------------------------------
    public Queue(int s)          // constructor
    {
        maxSize = s;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }
    //--------------------------------------------------------------
    public void insert(long j)   // put item at rear of queue
    {
        if(rear == maxSize-1)         // deal with wraparound
            rear = -1;
        queArray[++rear] = j;         // increment rear and insert
        nItems++;                     // one more item
    }
    //--------------------------------------------------------------
    public long remove()         // take item from front of queue
    {
        long temp = queArray[front++]; // get value and incr front
        if (!isEmpty()) {
            if (front == maxSize)           // deal with wraparound
                front = 0;
            nItems--;                      // one less item
        } else {
            throw new IllegalArgumentException("Queue is Empty");
        }
        return temp;
    }
    //--------------------------------------------------------------
    public long peekFront()      // peek at front of queue
    {
        return queArray[front];
    }
    //--------------------------------------------------------------
    public void redPurch()      // peek at front of queue
    {
        queArray[front]--;
    }

    public boolean isEmpty()    // true if queue is empty
    {
        return (nItems==0);
    }
    //--------------------------------------------------------------
    public boolean isFull()     // true if queue is full
    {
        return (nItems==maxSize);
    }
    //--------------------------------------------------------------
    public int size()           // number of items in queue
    {
        return nItems;
    }

    public void displayQueue() {
        if (isEmpty()){
            System.out.println("Очередь пуста");
        } else if (front == rear){
            System.out.println("В очереди один элемент: " + queArray[front]);
        } else if (front < rear){
            System.out.println("В очереди: ");
            for (int i = front; i<=rear; i++){
                System.out.print(queArray[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("В очереди: ");
            for (int i = front; i < maxSize; i++){
                System.out.print(queArray[i]+" ");
            }
            for (int i = 0; i <= rear; i++){
                System.out.print(queArray[i]+" ");
            }
            System.out.println();
        }
    }
    //--------------------------------------------------------------
}
