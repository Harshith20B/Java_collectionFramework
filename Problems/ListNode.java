package Problems;
import java.util.*;
//Maximum twin sum of a linked list
public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class twinSum{
    public int pairSum(ListNode head){
        ListNode temp = head;
        int len=0;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        Stack<Integer> stack = new Stack<>();
        temp=head;
        while(temp!=null){
            stack.push(temp.val);
            temp=temp.next;
        }
        int max=0;
        temp=head;
        while(stack.size()>stack.size()/2){
            int val = temp.val+stack.pop();
            if(val>max)
                max=val;
            temp=temp.next; 
        }
        return max;
    }
}
