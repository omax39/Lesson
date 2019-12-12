package ru.khachalov.structandalgorithms.stackandother.Deque;

public class DequeApp {
    public static void main(String[] args)
    {
        Deque theDeque = new Deque(5);  // queue holds 5 items
        StackP stackP = new StackP(theDeque);
//        theDeque.insertLeft(5);
//        theDeque.displayQueue();
//        theDeque.insertRight(6);
//        theDeque.displayQueue();
//        theDeque.insertLeft(4);
//        theDeque.displayQueue();
//        theDeque.insertRight(7);
//        theDeque.displayQueue();
//        theDeque.insertLeft(3);
//        theDeque.displayQueue();
//        theDeque.removeLeft();
//        theDeque.displayQueue();
//        theDeque.removeLeft();
//        theDeque.displayQueue();
//        theDeque.removeRigth();
//        theDeque.displayQueue();
//        theDeque.removeRigth();
//
//        theDeque.displayQueue();
//        System.out.println(theDeque.removeLeft());


        stackP.push(1);
        stackP.displayStack();
        stackP.push(2);
        stackP.displayStack();
        stackP.push(3);
        stackP.displayStack();
        stackP.push(4);
        stackP.displayStack();
        stackP.push(5);
        stackP.displayStack();





    }  // end main()
}
