package ru.khachalov.structandalgorithms.linkedlists.reverseLink;

public class StackOnRevL {
    private ReversLink reversLink;
    StackOnRevL(ReversLink reversLink){
        this.reversLink = reversLink;
    }

    public boolean isEmpty(){
        return reversLink.isEmpty();
    }

    public void push(long key){
        reversLink.insertPrev(key);
    }

    public Link pop(){
        return reversLink.removeCur();
    }
    public void displayStack(){
        reversLink.displayRev();
    }
}
