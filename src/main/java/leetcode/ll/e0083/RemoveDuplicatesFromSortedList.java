package leetcode.ll.e0083;

import leetcode.ll.ListNode;

public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {

        if(head == null) {
            return null;
        }
        ListNode pre = head;
        ListNode temp = head;
        int value = head.val;
        while (temp!=null) {
            if (temp == head) {
                pre = temp;
                temp = temp.next;
                continue;
            }

            if(temp.val == value) {
                pre.next = temp.next;
            }
            else {
                pre = temp;
            }
            value = temp.val;
            temp = temp.next;
        }

        return head;
    }

    public static void main(String[] args) {
        //case1
        ListNode case1 = ListNode.create(new int[]{1,1,2});
        new RemoveDuplicatesFromSortedList().deleteDuplicates(case1).print();

        //case2
        ListNode case2 = ListNode.create(new int[]{1,1,2,3,3});
        new RemoveDuplicatesFromSortedList().deleteDuplicates(case2).print();
    }
}
