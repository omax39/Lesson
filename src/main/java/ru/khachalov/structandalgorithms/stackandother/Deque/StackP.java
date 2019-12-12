package ru.khachalov.structandalgorithms.stackandother.Deque;

public class StackP {
    private Deque thisDeque;

    public StackP(Deque deque){
        this.thisDeque = deque;
    }

    public void push(long j){
        thisDeque.insertRight(j);
    }

    public long pop(){
        return thisDeque.removeRigth();
    }

    public boolean isEmpty(){
        return thisDeque.isEmpty();
    }

    public boolean isFull(){
        return thisDeque.isFull();
    }

    public long peek(){
        return thisDeque.peekRight();
    }

    public void displayStack(){
        thisDeque.displayQueue();
    }
}
