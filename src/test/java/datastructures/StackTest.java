package datastructures;

import org.junit.Test;

public class StackTest {

    @Test
    public void testConstructor () {
        Stack myStack = new Stack(4);

        myStack.printAll();

        /*
            EXPECTED OUTPUT:
            ----------------
            Top: 4
            Height: 1

            Stack:
            4

        */
    }

    @Test
    public void testPush() {
        Stack myStack = new Stack(2);

        System.out.println("Before push():");
        System.out.println("--------------");
        myStack.printAll();

        myStack.push(1);

        System.out.println("\n\nAfter push():");
        System.out.println("-------------");
        myStack.printAll();
    }

    @Test
    public void testPop() {
        Stack myStack = new Stack(2);
        myStack.push(1);

        // (2) Items - Returns 1 Node
        System.out.println(myStack.pop().value);
        // (1) Item - Returns 2 Node
        System.out.println(myStack.pop().value);
        // (0) Items - Returns null
        System.out.println(myStack.pop());
    }
}
