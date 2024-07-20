package datastructures;

public class Stack {

    Node top;
    int height;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }

    }

    public Stack (int value){
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    public Node getTop() {
        return top;
    }

    public int getHeight() {
        return height;
    }

    public void push (int value) {
        Node newNode = new Node(value);

        if (height>0) {
            newNode.next = top;
        }
        top = newNode;
        height ++;
    }

    public Node pop() {
        if(height==0) return null;

        Node removed = top;
        top = top.next;
        height --;

        return removed;
    }

    public void printStack() {
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (height == 0) {
            System.out.println("Top: null");
        } else {
            System.out.println("Top: " + top.value);
        }
        System.out.println("Height:" + height);
        System.out.println("\nStack:");
        if (height == 0) {
            System.out.println("empty");
        } else {
            printStack();
        }
    }

    public void makeEmpty() {
        top = null;
        height = 0;
    }
}
