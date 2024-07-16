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
        Node newNode = new Node(value);
        if (length==0) {
            head = newNode;
            tail = newNode;
        }
        else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        length ++;
    }

    public Node removeFirst() {
        if(length==0)   return null;

        Node removed = head;
        if(head == tail) {
            head = null;
            tail = null;
        }
        else {
            head = removed.next;
            head.prev = null;
            removed.next = null;
        }
        length --;
        return removed;

    }

    public Node get(int index) {

        if (index<0 || index>=length) return null;
        Node temp = null;

        for(int i=0; i<=index; i++) {
            temp = (temp==null?head:temp.next);
        }
        return temp;
    }

    public boolean set(int index, int value) {

        if (index<0 || index>=length) return false;
        Node temp = null;

        for(int i=0; i<=index; i++) {
            temp = (temp==null?head:temp.next);
        }
        temp.value = value;
        return true;
    }

    public boolean insert(int index, int value) {
        if (index<0 || index>length) return false;

        if (index == 0) {
            prepend(value);
            return true;
        }
        if(index == length) {
            append(value);
            return true;
        }

        Node newNode = new Node(value);
        Node pre = head;
        Node cur = head;

        for (int i=0; i<index; i++) {
            pre = cur;
            cur = cur.next;
        }
        pre.next = newNode;
        newNode.next = cur;
        newNode.prev = pre;
        cur.prev = newNode;

        length++;
        return true;
    }

    public Node remove(int index) {
        if (index<0 || index>=length) return null;

        if (index==0){
            return removeFirst();
        }

        if(index==length-1) {
            return removeLast();
        }

        Node pre = head;
        Node cur = head;
        for(int i=0; i<index;i++) {
            pre = cur;
            cur = cur.next;
        }

        pre.next = cur.next;
        cur.next.prev = pre;
        cur.prev = null;
        cur.next = null;

        length--;
        return cur;
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
