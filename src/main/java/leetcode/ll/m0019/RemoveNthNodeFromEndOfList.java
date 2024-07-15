package leetcode.ll.m0019;

import leetcode.ll.ListNode;

public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head==null) return null;

        ListNode fast = head;
        while (n>0) {
            fast = fast.next;
            if(fast == null) return head.next;
            n--;
        }

        if(fast == null) return head.next;

        ListNode slow = head;
        while (fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;

        return head;
    }


    public static void main(String[] args) {
        //case 1
        ListNode case1 = ListNode.create(new int[]{1,2,3,4,5});
        new RemoveNthNodeFromEndOfList().removeNthFromEnd(case1, 2).print();

        //case 2
        ListNode case2 = ListNode.create(new int[]{1});
//        new RemoveNthNodeFromEndOfList().removeNthFromEnd(case2, 1).print();

        //case 3
        ListNode case3 = ListNode.create(new int[]{1,2});
        new RemoveNthNodeFromEndOfList().removeNthFromEnd(case3, 1).print();


    }
}
