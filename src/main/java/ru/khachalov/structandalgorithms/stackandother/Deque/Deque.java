package ru.khachalov.structandalgorithms.stackandother.Deque;

public class Deque {
    private int maxSize;
    private long[] queArray;
    private int left;
    private int right;
    private int nItems;
    public Deque(int s){
        this.maxSize = s;
        queArray = new long[maxSize];
        left = maxSize/2+1;
        right = maxSize/2;
        nItems = 0;
    }

    public boolean isEmpty(){
        return (nItems == 0);
    }

    public boolean isFull(){
        return (nItems == maxSize);
    }

    public void insertLeft(long in){
        if(!isFull()){
            if (left == 0){
                left = maxSize;
            }
            queArray[--left] = in;
            nItems++;
        } else {
            throw new IllegalArgumentException("Deque Is Full");
        }
    }

    public void insertRight(long in){
        if(!isFull()){
            if (right == maxSize-1){
                right = -1;
            }
            queArray[++right] = in;
            nItems++;
        } else {
            throw new IllegalArgumentException("Deque Is Full");
        }
    }

    public long removeLeft(){
        long temp;
        if(!isEmpty()) {
            temp = queArray[left++];
            nItems--;
            if(left == maxSize){
                left = 0;
            }
        } else {
            throw new IllegalArgumentException("Deque Is Empty");
        }
        return temp;
    }

    public long removeRigth(){
        long temp;
        if(!isEmpty()) {
            temp = queArray[right--];
            nItems--;
            if(right == -1){
                right = maxSize-1;
            }
        } else {
            throw new IllegalArgumentException("Deque Is Empty");
        }
        return temp;
    }

    public long peekLeft(){
        return queArray[left];
    }

    public long peekRight(){
        return queArray[right];
    }

    public void displayQueue() {
        if (isEmpty()){
            System.out.println("Очередь пуста");
        } else if (left == right){
            System.out.println("В очереди один элемент: " + queArray[left]);
        } else if (left < right){
            System.out.println("В очереди: ");
            for (int i = left; i<=right; i++){
                System.out.print(queArray[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("В очереди: ");
            for (int i = left; i < maxSize; i++){
                System.out.print(queArray[i]+" ");
            }
            for (int i = 0; i <= right; i++){
                System.out.print(queArray[i]+" ");
            }
            System.out.println();
        }
    }
}
