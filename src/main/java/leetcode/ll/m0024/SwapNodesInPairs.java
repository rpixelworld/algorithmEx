package leetcode.ll.m0024;

import leetcode.ll.ListNode;
import org.junit.Assert;

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {

        if(head==null || head.next==null){
            return head;
        }
        ListNode dummy = new ListNode(0, head);

        ListNode previous = dummy;
        while (head!=null) {
            ListNode first = head;
            ListNode second = head.next;
            if(second==null){
                break;
            }

            previous.next = second;
            first.next = second.next;
            second.next = first;

            previous = head;
            head = head.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        //case1
        ListNode case1 = ListNode.create(new int[]{1,2,3,4});
        new SwapNodesInPairs().swapPairs(case1).print();

        //case2
        ListNode case2 = ListNode.create(new int[]{});
        Assert.assertNull(new SwapNodesInPairs().swapPairs(case2));

        ListNode case3 = ListNode.create(new int[]{1});
        new SwapNodesInPairs().swapPairs(case3).print();

    }
}
