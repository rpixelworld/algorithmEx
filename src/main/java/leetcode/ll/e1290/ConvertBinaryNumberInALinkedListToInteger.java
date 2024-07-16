package leetcode.ll.e1290;

import leetcode.ll.ListNode;

public class ConvertBinaryNumberInALinkedListToInteger {

    public int getDecimalValue(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while (temp!=null) {
            length ++;
            temp=temp.next;
        }

        int decimal = 0;
        temp = head;
        for(int i=length-1; i>=0; i--) {
            decimal += temp.val*Math.pow(2, i);
            temp = temp.next;
        }
        return decimal;
    }


}
