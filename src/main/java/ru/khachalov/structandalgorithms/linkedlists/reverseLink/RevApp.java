package ru.khachalov.structandalgorithms.linkedlists.reverseLink;

public class RevApp {
    public static void main(String[] args) {
        ReversLink reversLink = new ReversLink();
        reversLink.insert(88);
        reversLink.displayRev();
        reversLink.insert(99);
        reversLink.displayRev();
        reversLink.insert(22);
        reversLink.displayRev();
        reversLink.insert(55);
        reversLink.displayRev();
        reversLink.insert(33);
        reversLink.displayRev();
        reversLink.insert(44);

        Link a = reversLink.find(88);
        if (a != null) {
            System.out.println("Эллемент найден:");
            System.out.println(a.data);
        } else {
            System.out.println("Эллемент не найден");
        }
        reversLink.displayRev();

        Link b = reversLink.remove(22);
        if (b != null) {
            System.out.println("Эллемент найден:");
            System.out.println(b.data);
        } else {
            System.out.println("Эллемент не найден");
        }
        reversLink.displayRev();
        reversLink.step();
        reversLink.step();
        reversLink.displayRev();

    }
}
