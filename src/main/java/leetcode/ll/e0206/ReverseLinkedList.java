package leetcode.ll.e0206;

import leetcode.ll.ListNode;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {

        if(head == null) {
            return null;
        }
        ListNode reversed = head;

        while (head.next != null) {
            ListNode afterHead = head.next;
            head.next = afterHead.next;
            afterHead.next = reversed;
            reversed = afterHead;
        }
        return reversed;
    }

    public static void main(String[] args) {
        //case1
        ListNode case1 = ListNode.create(new int[]{1,2,3,4,5});
        new ReverseLinkedList().reverseList(case1).print();

        //case2
        ListNode case2 = ListNode.create(new int[]{1,2});
        new ReverseLinkedList().reverseList(case2).print();

        ListNode case3 = ListNode.create(new int[]{});
//        new ReverseLinkedList().reverseList(case3).print();
    }
}
