package leetcode.ll.m0092;

import leetcode.ll.ListNode;

public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;

        ListNode sub1 = null;
        ListNode subHead1 = head;

        if(left==1){
            subHead1=null;
            sub1=null;
        }
        else {
            for(int i=1; i<left; i++) {
                sub1 = (sub1==null? subHead1 : sub1.next);
            }
        }

        ListNode reversed = sub1==null?head:sub1.next;
        ListNode tobeReverseHead = sub1==null?head:sub1.next;
        if(left>1)  sub1.next = null;


        for (int i=left; i<right; i++) {
            ListNode after = tobeReverseHead.next;
            tobeReverseHead.next = after.next;
            after.next = reversed;
            reversed = after;
        }

        if(left>1){
            sub1.next = reversed;
            return subHead1;
        }
        else{
            return reversed;
        }
    }





    public static void main(String[] args) {
        //case1
        ListNode case1 = ListNode.create(new int[]{1,2,3,4,5});
        new ReverseLinkedListII().reverseBetween(case1, 2,4).print();
        new ReverseLinkedListII().reverseBetween(case1, 3,4).print();

        //case2
        ListNode case2 = ListNode.create(new int[]{5});
        new ReverseLinkedListII().reverseBetween(case2, 1, 1).print();

        //case3
        ListNode case3 = ListNode.create(new int[]{3,5});
        new ReverseLinkedListII().reverseBetween(case3, 1,2).print();

        //case4
//        ListNode case4 = ListNode.create(new int[]{1,2,3,4,5});
//        new ReverseLinkedListII().reverseBetween(case4, 3,4).print();
    }
}
