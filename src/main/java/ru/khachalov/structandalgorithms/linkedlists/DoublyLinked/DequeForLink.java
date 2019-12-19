package ru.khachalov.structandalgorithms.linkedlists.DoublyLinked;

public class DequeForLink {
    DoublyLinkedList doublyLinkedList;
    DequeForLink(DoublyLinkedList doublyLinkedList){
        this.doublyLinkedList = doublyLinkedList;
    }

    public boolean isEmpty(){
        return doublyLinkedList.isEmpty();
    }

    public void insertLeft(long key){
        doublyLinkedList.insertFirst(key);
    }

    public void insertRight(long key){
        doublyLinkedList.insertLast(key);
    }

    public Link removeLeft(){
        return doublyLinkedList.deleteFirst();
    }

    public Link removeRight(){
        return doublyLinkedList.deleteLast();
    }

    public Link peekLeft(){
        return doublyLinkedList.getFirst();
    }

    public Link peekRight(){
        return doublyLinkedList.getLast();
    }

}
