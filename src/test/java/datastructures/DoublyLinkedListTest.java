package datastructures;

import org.junit.Test;

public class DoublyLinkedListTest {

    @Test
    public void testConstructor () {
        DoublyLinkedList myDLL = new DoublyLinkedList(7);

        myDLL.printAll();


        /*
            EXPECTED OUTPUT:
            ----------------
            Head: 7
            Tail: 7
            Length: 1

            Linked List:
            7

        */
    }

    @Test
    public void testRemoveLast() {
        DoublyLinkedList myDLL = new DoublyLinkedList(1);
        myDLL.append(2);

        // (2) Items - Returns 2 Node
        System.out.println(myDLL.removeLast().value);
        // (1) Item - Returns 1 Node
        System.out.println(myDLL.removeLast().value);
        // (0) Items - Returns null
        System.out.println(myDLL.removeLast());


    	/*
        	EXPECTED OUTPUT:
        	----------------
        	2
        	1
        	null

     	*/
    }
}
