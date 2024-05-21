package dataStruct1;
import java.util.LinkedList;
//Code to remove nth node of a list
public class NthNodeoflist{
	class Node{
		String data;
		Node next;
		Node(String data){
			this.data=data;
			next=null;
		}
	}
	Node head;
	void removeNode(int n,LinkedList<String> list){
		if((head)==null) {
			System.out.println("Empty list");
			return;
		}
		Node currNode=head;
		int size=1;
		while(currNode.next!=null) {
			currNode=currNode.next;
			size++;
		}
		int a = size-n;
		int b=1;
		Node currNode2=head;
		if (a == 0) {
	        head = head.next;
	        return;
	    }
		while(b<a) {	
			currNode2=currNode2.next;
			b++;
		}
		currNode2.next=currNode2.next.next;
	}
	public static void main(String args[]) {
		LinkedList<String> list = new LinkedList<>();
		list.add("this");
		list.add("is");
		list.add("a");
		list.add("list");
		System.out.println(list);
		NthNodeoflist obj1 = new NthNodeoflist();
		obj1.removeNode(1,list);
		System.out.println(list);
	}
}
