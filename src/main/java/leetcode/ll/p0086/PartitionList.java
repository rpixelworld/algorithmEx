package leetcode.ll.p0086;

import leetcode.ll.ListNode;

import java.util.List;

public class PartitionList {

    public ListNode partition(ListNode head, int x) {

        ListNode ltHead = null;
        ListNode ltPointer = null;
        ListNode gtHead = null;
        ListNode gtPointer = null;

        while (head !=null) {
            if(head.val<x) {
                if(ltHead == null) {
                    ltHead = head;
                    ltPointer = head;
                }
                else {
                    ltPointer.next = head;
                    ltPointer = ltPointer.next;
                }
            }
            else {
                if(gtHead == null) {
                    gtHead = head;
                    gtPointer = head;
                }
                else {
                    gtPointer.next = head;
                    gtPointer = gtPointer.next;
                }
            }
            head = head.next;
        }
        if(ltPointer!=null){
            ltPointer.next = gtHead;
        }
        else {
            ltHead = gtHead;
        }
        if(gtPointer!=null) {
            gtPointer.next = null;
        }

        return ltHead;
    }

    public static void main(String[] args) {
        //case1
        ListNode case1 = ListNode.create(new int[]{1,4,3,2,5,2});
        new PartitionList().partition(case1, 3).print();

        //case2
        ListNode case2 = ListNode.create(new int[]{2,1});
        new PartitionList().partition(case2, 2).print();
    }
}
