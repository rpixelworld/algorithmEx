package datastructures;

public class Queue {

    Node first;
    Node last;
    int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public Queue(int value) {
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length = 1;
    }

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    public int getLength() {
        return length;
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);

        if(length==0) {
            first = newNode;
        }
        else {
            last.next = newNode;
        }
        last = newNode;
        length++;
    }

    public Node dequeue() {
        if(length == 0) {
            return null;
        }

        Node removed = first;
        if(length == 1) {
            first = null;
            last = null;
        }
        else {
            first = first.next;
        }
        length --;
        return removed;
    }

    public void printList() {
        Node temp = first;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("First: null");
            System.out.println("Last: null");
        } else {
            System.out.println("First: " + first.value);
            System.out.println("Last: " + last.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nQueue:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        first = null;
        last = null;
        length = 0;
    }
}
