package datastructures;

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int length;

    public DoublyLinkedList (int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    class Node {
        int value;
        Node prev;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public Node getHead() {
        return head;
    }


    public Node getTail() {
        return tail;
    }


    public int getLength() {
        return length;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if(length==0) {
            head=newNode;
            tail=newNode;
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length ++;
    }

    public Node removeLast() {
        if(length==0) {
            return null;
        }
        Node removed = tail;

        if(head == tail) {
            length = 0;
            head = null;
            tail = null;
            return removed;
        }

        tail = tail.prev;
        tail.next = null;
        removed.prev = null;
        length --;

        return removed;
    }

    public void prepend(int value) {

    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nDoubly Linked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }
}
