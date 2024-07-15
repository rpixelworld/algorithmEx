package datastructures;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }


    public LinkedList(int value) {
        this.head = new Node(value);
        this.tail = head;
        this.length = 1;

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

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    /*
        append node at the end
     */
    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0){
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
        length ++;
    }

    public Node removeLast() {
        if(length == 0) {
            return null;
        }

        Node point = head;
        while (point.next!=null){
            if(point.next == tail) {
                Node temp = tail;
                tail = point;
                tail.next = null;
                length --;
                return temp;
            }
            point = point.next;
        }

        length =0;
        head = null;
        tail = null;
        return point;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if(length == 0) {
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
        }
        length ++;
    }

    public Node removeFirst() {
        if(length == 0) return null;

        Node temp = head;
        if(head.next == null) {
            head = null;
            tail = null;
        }
        else {
            head = temp.next;
            temp.next = null;
        }
        length --;

        return temp;
    }

    public Node get(int index) {
        if(index < 0 || index>=length || length==0) {
            return null;
        }

        Node temp = head;
        for(int i=0; i<length; i++) {
            if(i==index){
                break;
            }
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, int value) {
        if(index < 0 || index>=length || length==0) {
            return false;
        }

        Node temp = head;
        for(int i=0; i<length; i++) {
            if(i==index){
                break;
            }
            temp = temp.next;
        }
        temp.value = value;
        return true;
    }

    public boolean insert(int index, int value) {
        if(index < 0 || index>length) {
            return false;
        }

        if(index==0) {
            prepend(value);
            return true;
        }

        if(index==length) {
            append(value);
            return true;
        }

        Node pre = head;
        Node temp = head;
        for(int i=0; i<index; i++){
            pre = temp;
            temp = temp.next;
        }
        Node newNode = new Node(value);
        pre.next = newNode;
        newNode.next = temp;
        length ++;
        return true;
    }

    public Node remove(int index) {
        if(index < 0 || index>=length || length==0) {
            return null;
        }

        if(index == 0) return removeFirst();
        if(index == length-1) return removeLast();

        Node temp = head;
        Node pre = head;
        for(int i=0; i<index; i++) {
            pre = temp;
            temp = temp.next;
        }
        pre.next = temp.next;
        temp.next = null;
        length --;
        return temp;
    }

    public void reverse() {
        for(int i=0; i<length-1; i++){
            Node node = remove(length-2-i);
            append(node.value);
        }
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
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

}
