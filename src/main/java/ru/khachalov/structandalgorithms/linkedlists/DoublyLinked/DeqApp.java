package ru.khachalov.structandalgorithms.linkedlists.DoublyLinked;

public class DeqApp {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        DequeForLink dequeForLink = new DequeForLink(doublyLinkedList);

        dequeForLink.insertLeft(5);
        dequeForLink.insertLeft(8);
        dequeForLink.insertRight(0);
        dequeForLink.insertLeft(9);
        dequeForLink.insertRight(4);

        doublyLinkedList.displayForward();

        while (!dequeForLink.isEmpty()){
            long a = dequeForLink.removeLeft().dData;
            System.out.println(a);
        }

    }
}
