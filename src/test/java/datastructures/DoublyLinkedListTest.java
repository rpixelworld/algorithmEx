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

    @Test
    public void testPrepend() {
        DoublyLinkedList myDLL = new DoublyLinkedList(2);
        myDLL.append(3);

        System.out.println("Before prepend():");
        System.out.println("-----------------");
        myDLL.printAll();

        myDLL.prepend(1);

        System.out.println("\n\nAfter prepend():");
        System.out.println("----------------");
        myDLL.printAll();


        /*
            EXPECTED OUTPUT:

            Before prepend():
            -----------------
            Head: 2
            Tail: 3
            Length: 2

            Doubly Linked List:
            2
            3


            After prepend():
            ----------------
            Head: 1
            Tail: 3
            Length: 3

            Doubly Linked List:
            1
            2
            3

        */
    }

    @Test
    public void testRemoveFirst() {
        DoublyLinkedList myDLL = new DoublyLinkedList(2);
        myDLL.append(1);

        // (2) Items - Returns 2 Node
        System.out.println(myDLL.removeFirst().value);
        // (1) Item - Returns 1 Node
        System.out.println(myDLL.removeFirst().value);
        // (0) Items - Returns null
        System.out.println(myDLL.removeFirst());


        /*
            EXPECTED OUTPUT:
            ----------------
            2
            1
            null

        */
    }

    @Test
    public void testGet() {
        DoublyLinkedList myDLL = new DoublyLinkedList(0);
        myDLL.append(1);
        myDLL.append(2);
        myDLL.append(3);


        System.out.println(myDLL.get(3).value);


        /*
            EXPECTED OUTPUT:
            ----------------
            3

        */
    }

    @Test
    public void testSet() {
        DoublyLinkedList myDLL = new DoublyLinkedList(0);
        myDLL.append(1);
        myDLL.append(2);
        myDLL.append(3);

        System.out.println("DLL before set():");
        myDLL.printList();

        myDLL.set(2, 99);

        System.out.println("\nDLL after set():");
        myDLL.printList();


        /*
            EXPECTED OUTPUT:
            ----------------
            DLL before set():
            0
            1
            2
            3

            DLL after set():
            0
            1
            99
            3

        */
    }

    @Test
    public void testInsert() {
        DoublyLinkedList myDLL = new DoublyLinkedList(1);
        myDLL.append(3);

        System.out.println("DLL before insert():");
        myDLL.printList();

        myDLL.insert(1, 2);

        System.out.println("\nDLL after insert(2) in middle:");
        myDLL.printList();

        myDLL.insert(0, 0);

        System.out.println("\nDLL after insert(0) at beginning:");
        myDLL.printList();

        myDLL.insert(4, 4);

        System.out.println("\nDLL after insert(4) at end:");
        myDLL.printList();


        /*
            EXPECTED OUTPUT:
            ----------------
            DLL before insert():
            1
            3

            DLL after insert(2) in middle:
            1
            2
            3

            DLL after insert(0) at beginning:
            0
            1
            2
            3

            DLL after insert(4) at end:
            0
            1
            2
            3
            4

        */
    }

    @Test
    public void testRemove() {
        DoublyLinkedList myDLL = new DoublyLinkedList(1);
        myDLL.append(2);
        myDLL.append(3);
        myDLL.append(4);
        myDLL.append(5);

        System.out.println("DLL before remove():");
        myDLL.printList();

        System.out.println("\nRemoved node:");
        System.out.println(myDLL.remove(2).value);
        System.out.println("DLL after remove() in middle:");
        myDLL.printList();

        System.out.println("\nRemoved node:");
        System.out.println(myDLL.remove(0).value);
        System.out.println("DLL after remove() of first node:");
        myDLL.printList();

        System.out.println("\nRemoved node:");
        System.out.println(myDLL.remove(2).value);
        System.out.println("DLL after remove() of last node:");
        myDLL.printList();


        /*
            EXPECTED OUTPUT:
            ----------------
            DLL before remove():
            1
            2
            3
            4
            5

            Removed node:
            3
            DLL after remove() in middle:
            1
            2
            4
            5

            Removed node:
            1
            DLL after remove() of first node:
            2
            4
            5

            Removed node:
            5
            DLL after remove() of last node:
            2
            4

        */
    }

    @Test
    public void testSwapFirstLast() {
        DoublyLinkedList myDLL = new DoublyLinkedList(1);
        myDLL.append(2);
        myDLL.append(3);
        myDLL.append(4);
        myDLL.append(5);

        System.out.println("DLL before swap:");
        myDLL.printList();

        myDLL.swapFirstLast();

        System.out.println("\nDLL after swap:");
        myDLL.printList();

        myDLL = new DoublyLinkedList(1);
        myDLL.append(2);
        System.out.println("DLL before swap:");
        myDLL.printList();

        myDLL.swapFirstLast();

        System.out.println("\nDLL after swap:");
        myDLL.printList();
        /*
       		EXPECTED OUTPUT:
        	----------------
            DLL before swap:
            1
            2
            3
            4
            5

            DLL after swap:
            5
            2
            3
            4
            1

     	*/
    }

    @Test
    public void testReverse() {
        DoublyLinkedList myDLL = new DoublyLinkedList(1);
        myDLL.append(2);
        myDLL.append(3);
        myDLL.append(4);
//        myDLL.append(5);

        System.out.println("DLL before reverse:");
        myDLL.printList();

        myDLL.reverse();

        System.out.println("\nDLL after reverse:");
        myDLL.printList();


        /*
       		EXPECTED OUTPUT:
        	----------------
            DLL before reverse:
            1
            2
            3
            4
            5

            DLL after reverse:
            5
            4
            3
            2
            1

     	*/
    }

    @Test
    public void testIsPalindrome () {
        DoublyLinkedList myDLL1 = new DoublyLinkedList(1);
        myDLL1.append(2);
        myDLL1.append(3);
        myDLL1.append(2);
        myDLL1.append(1);

        System.out.println("myDLL1 isPalindrome:");
        System.out.println( myDLL1.isPalindrome() );



        DoublyLinkedList myDLL2 = new DoublyLinkedList(1);
        myDLL2.append(2);
        myDLL2.append(3);

        System.out.println("\nmyDLL2 isPalindrome:");
        System.out.println( myDLL2.isPalindrome() );
    }

    @Test
    public void testSwapPairs() {
        DoublyLinkedList myDll = new DoublyLinkedList(1);
        myDll.append(2);
        myDll.append(3);
        myDll.append(4);

        System.out.println("myDll before swapPairs:");
        myDll.printList();

        myDll.swapPairs();

        System.out.println("\nmyDll after swapPairs:");
        myDll.printList();
    }
}
