package ru.khachalov.structandalgorithms.linkedlists.reverseLink;

public class ReversLink {
    private Link current;
    private Link prev;
    public boolean isEmpty(){
        return (current == null);
    }

    public void insert(long key){
        Link dd = new Link(key);
        if (isEmpty()){
            current = dd;
        } else if (current.next == null){
            current.next = dd;
            current.next.next = current;
            prev = current;
            step();
        } else {
            dd.next = current.next;
            current.next = dd;
            prev = current;
            step();
        }
    }

    public Link find(long key){
        if (!isEmpty()) {
            Link temp = current;
            while (true) {
                if (current.data == key) {
                    return current;
                }
                prev = current;
                step();
                if (current == temp){
                    break;
                }
            }
        }
        return null;
    }

    public Link remove(long key){
        Link temp;
        if (!isEmpty() & find(key)!=null){
             if (current.next == null){
                 temp = current;
                 current = null;
                 return temp;
             } else if (current == current.next.next){
                 temp = current;
                 step();
                 current.next = null;
                 return temp;
             } else {
                 temp = current;
                 prev.next = current.next;
                 step();
                 return temp;
             }
        } else {
            return null;
        }
    }

    public void displayRev(){
        Link temp = current;
        if (!isEmpty()){
            while (true){
                current.displayLink();
                step();
                if (current == temp || current == null){
                    current = temp;
                    break;
                }
            }
            System.out.println();
        } else {
            System.out.println("Список пуст");
        }
    }

    public void step(){
        if (!isEmpty() & current.next!=null){
            current = current.next;
        }
    }

    public void stepWithPrev(){
        if (!isEmpty() & current.next!=null){
            prev = current;
            current = current.next;
        }
    }

    public Link removeCur(){
        Link temp;
        if (!isEmpty()){
            temp = current;
            prev.next = current.next;
            step();
        } else {
            temp = null;
        }
        return temp;
    }

    public void insertPrev(long key){
        Link dd = new Link(key);
        if (isEmpty()){
            current = dd;
        } else if (current.next == null){
            dd.next = current;
            current.next = dd;
            prev = current;
            current = dd;
        } else {
            dd.next = current;
            current = dd;
            prev.next = dd;
        }
    }

    public Link getCurrent() {
        return current;
    }

}
