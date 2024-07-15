package leetcode.ll.e0876;

import leetcode.ll.ListNode;

public class MiddleOfTheLinkedList {

    public ListNode middleNode(ListNode head) {
        if (head == null ) return null;

        int length = 1;
        ListNode temp = head;
        while (temp.next != null) {
            length ++;
            temp = temp.next;
        }

        temp = head;
        for(int i = 0; i<length/2; i++) {
            temp = temp.next;
        }
        return temp;
    }
}
