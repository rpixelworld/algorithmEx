package datastructures;

import org.junit.Test;

public class QueueTest {

    @Test
    public void testConstructor() {
        Queue myQueue = new Queue(4);

        myQueue.printAll();
    }

    @Test
    public void testEnqueue() {
        Queue myQueue = new Queue(2);

        System.out.println("Before enqueue():");
        System.out.println("--------------");
        myQueue.printAll();

        myQueue.enqueue(1);

        System.out.println("\n\nAfter enqueue():");
        System.out.println("-------------");
        myQueue.printAll();
    }

    @Test
    public void testDequeue() {
        Queue myQueue = new Queue(2);
        myQueue.enqueue(1);

        // (2) Items - Returns 2 Node
        System.out.println(myQueue.dequeue().value);
        // (1) Item - Returns 1 Node
        System.out.println(myQueue.dequeue().value);
        // (0) Items - Returns null
        System.out.println(myQueue.dequeue());

    }
}
