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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode temp = head;
        int count=1,len=1;
        while(count!=k){
            temp=temp.next;
            count++;
        }
        ListNode temp2 = head;
        while(temp2.next!=null){
            len++;
            temp2=temp2.next;
        }
        int count3 = len-k+1;
        ListNode temp3=head;
        int count4=1;
        while(count4!=count3){
            count4++;
            temp3=temp3.next;
        }
        int tem = temp.val;
        temp.val=temp3.val;
        temp3.val=tem;
        return head;
    }
}