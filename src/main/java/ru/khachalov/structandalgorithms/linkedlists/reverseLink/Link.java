package ru.khachalov.structandalgorithms.linkedlists.reverseLink;

public class Link {
    public long data;
    public Link next;
    Link(long data){
        this.data = data;
    }

    public void displayLink() {
        System.out.print(data + " ");
    }
}
