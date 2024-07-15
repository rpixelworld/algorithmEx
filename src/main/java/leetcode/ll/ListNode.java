package leetcode.ll;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class ListNode {

    public int val;
    public ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode create(int[] vals) {
        ListNode head = null;
        ListNode list = null;
        for(int i=0; i<vals.length; i++) {
            ListNode aNode = new ListNode();
            aNode.val = vals[i];

            if(head==null){
                head = aNode;
                list = aNode;
            }
            else {
                list.next = aNode;
                list = list.next;
            }
        }
        return head;
    }

    public void print() {
        ListNode pList = this;
        if (pList==null) {
            System.out.println("null");
        }
        else {
            System.out.print("[");
            while(pList!=null) {
                System.out.print(pList.val);
                if(pList.next!=null)
                    System.out.print(", ");
                pList = pList.next;
            }
            System.out.println("]");
        }
    }
}
