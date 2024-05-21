package dataStruct1;
public class ListPalindrome {
	Node head;
	class Node{
		String data;
		Node next;
		Node(String data){
			this.data=data;
			next=null;
		}
	}
	void addFirst2(String data) {
		Node newNode = new Node(data);
		if(head==null) {
			head=newNode;
			return;
		}
		newNode.next=head;
		head=newNode;
	}
	void addLast2(String data) {
		Node newNode = new Node(data);
		if(head==null) {
			head=newNode;
			return;
		}
		Node currNode=head;
		while(currNode.next!=null) {
			currNode=currNode.next;
		}
		currNode.next=newNode;
	}
	void printList2() {
		if(head==null) {
			System.out.println("The list is empty");
			return;
		}
		Node currNode = head;
		while(currNode!=null) {
			System.out.print(currNode.data+"->");
			currNode=currNode.next;
		}
		System.out.println("NUll");
	}
	class Solution2{
		Node reverse(Node head) {
			Node currNode = head;
			Node prevNode = null;
			while(currNode!=null) {
				Node nextNode = currNode.next;
				currNode.next=prevNode;
				prevNode=currNode;
				currNode=nextNode;
			}
			return prevNode;
		}
		Node findMiddle(Node head) {
			Node hare=head;
			Node turtle = head;
			while(hare.next!=null  && hare.next.next!=null) {
				hare=hare.next.next;
				turtle=turtle.next;
			}
			return turtle;
		}
		boolean ispalindrome(Node head) {
			if(head==null || head.next==null) {
				return true;
			}
			Node middle = findMiddle(head);
			Node secondHalfStart = reverse(middle.next);
			Node firstHalfStart = head;
			while(secondHalfStart!=null) {
				if(firstHalfStart.data!=secondHalfStart.data) {
					return false;
				}
				firstHalfStart=firstHalfStart.next;
				secondHalfStart=secondHalfStart.next;
			}
			return true;
		}
	}
	
	public static void main(String args[]) {
		ListPalindrome obj1 = new ListPalindrome();
		obj1.addFirst2("is");
		obj1.addFirst2("This");
		obj1.addLast2("a");
		obj1.addLast2("list");
		obj1.printList2();
		ListPalindrome.Solution2 obj2 = obj1.new Solution2();
		System.out.println(obj2.ispalindrome(obj1.head));
	}
}



