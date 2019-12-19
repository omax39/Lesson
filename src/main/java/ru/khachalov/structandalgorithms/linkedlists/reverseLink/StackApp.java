package ru.khachalov.structandalgorithms.linkedlists.reverseLink;

public class StackApp {
    public static void main(String[] args) {
        ReversLink reversLink = new ReversLink();
        StackOnRevL stackOnRevL = new StackOnRevL(reversLink);
        stackOnRevL.push(22);
        stackOnRevL.push(33);
        stackOnRevL.displayStack();
        stackOnRevL.pop();
        stackOnRevL.displayStack();
        stackOnRevL.push(44);
        stackOnRevL.displayStack();
        stackOnRevL.push(55);
        stackOnRevL.displayStack();
        stackOnRevL.push(66);
        stackOnRevL.displayStack();
        Link a = stackOnRevL.pop();
        stackOnRevL.displayStack();
        System.out.println(a.data);
        a = stackOnRevL.pop();
        System.out.println(a.data);
        stackOnRevL.displayStack();
    }
}
