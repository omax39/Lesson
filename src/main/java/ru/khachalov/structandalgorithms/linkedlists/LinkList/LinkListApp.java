package ru.khachalov.structandalgorithms.linkedlists.LinkList;

public class LinkListApp {
    public static void main(String[] args)
    {
        LinkList theList = new LinkList();  // make new list

//        theList.insertFirst(22, 2.99);      // insert four items
//        theList.insertFirst(44, 4.99);
//        theList.insertFirst(66, 6.99);
//        theList.insertFirst(88, 8.99);
        int i = 0;

        while (true){
            int a = (int) (Math.random()*99);
            double b = (double) ((int) ((Math.round(Math.random()*10))*100))/100;
            theList.insertFirst(a,b);
            i++;
            if(i % 1000 == 0){
                System.out.println(i);
            }
        }


//        while( !theList.isEmpty() )         // until it's empty,
//        {
//            Link aLink = theList.deleteFirst();   // delete link
//            System.out.print("Deleted ");         // display it
//            aLink.displayLink();
//            System.out.println("");
//        }
//        theList.displayList();              // display list
    }  // end main()
}
