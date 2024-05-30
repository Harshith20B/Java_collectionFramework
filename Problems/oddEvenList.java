package Problems;

public class oddEvenList {
    
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp1 = head;
        ListNode evenHead = head.next;
        ListNode temp2 = evenHead;
        ListNode temp3;
        while(temp1.next!=null && temp2.next!=null){
            temp3 = temp2.next;
            temp1.next = temp3;
            temp2.next = temp3.next;
            temp1 = temp3;
            temp2 = temp2.next;
        }
        temp1.next = evenHead;
        return head;
    }
}