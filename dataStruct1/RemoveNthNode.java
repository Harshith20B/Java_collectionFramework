package dataStruct1;
//TO REMOVE NTH NODE FROM BEHIND
public class RemoveNthNode {
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
	void removeNode(int n){
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
	class LinkedList2 {
	    Node removeNthFromEnd(Node head, int n) {
	        // Create a dummy node to handle the case where the head needs to be removed
	        if(head.next==null) {
	        	return null;
	        }
	        // Find the total size of the linked list
	        int size = 0;
	        Node currNode = head;
	        while (currNode != null) {
	            currNode = currNode.next;
	            size++;
	        }
	        if(n==size) {
	        	return head.next;
	        }
	        int indexToSearch = size - n;//This is the index of the element before the element 
	        							 									   //to be deleted
	        Node prevNode=head;
	        int i=1;
	        while(i < indexToSearch) {
	            prevNode = prevNode.next;
	            i++;
	        }

	        // Remove the nth node from the end
	        prevNode.next = prevNode.next.next;

	        return head;
	    }
	}
	public static void main(String args[]) {
		RemoveNthNode obj1 = new RemoveNthNode();
		obj1.addFirst2("is");
		obj1.addFirst2("This");
		obj1.addLast2("a");
		obj1.addLast2("list");
		obj1.printList2();
//		obj1.removeNode(2);
//		obj1.printList2();
		RemoveNthNode.LinkedList2 obj2 = obj1.new LinkedList2();
		obj2.removeNthFromEnd(obj1.head,2);
		obj1.printList2();
	}
}


