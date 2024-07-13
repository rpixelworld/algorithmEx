package datastructures.ll;

import org.junit.Test;

public class LinkListTest {

    @Test
    public void testConstructor() {
        LinkedList myLinkedList = new LinkedList(4);

        myLinkedList.printAll();
    }
}
