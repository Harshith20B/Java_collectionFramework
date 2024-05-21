package dataStruct1;
public class LinkedlistDet {
	Node2 head;
	private int size;
	LinkedlistDet(){
		this.size=0;
	}
	class Node2{
		 String data;
		 Node2 next;
		 Node2(String data){
			 this.data=data;
			 next=null;
			 size++;
		 }
	}
	void addFirst2(String data) {
		Node2 newNode = new Node2(data);
		if(head==null) {
			head=newNode;
			return;
		}
		newNode.next=head;
		head=newNode;
	}
	void addLast2(String data) {
		Node2 newNode = new Node2(data);
		if(head==null) {
			head=newNode;
			return;
		}
		Node2 currNode = head;
		while(currNode.next!=null) {
			currNode=currNode.next;
		}
		currNode.next=newNode;
	}
	void deleteFirst(){
		if(head==null){
			System.out.println("The list is empty");
		}
		size--;
		head=head.next;
	}
	void deleteLast() {
		if(head==null) {
			System.out.println("The list is empty");
			return;
		}
		size--;
		if(head.next==null) {
			head=null;
			return;
		}
		Node2 secondLast = head;
		Node2 lastNode = head.next;
		while(lastNode.next!=null) {
			lastNode=lastNode.next;
			secondLast=secondLast.next;
		}
		secondLast.next=null;
	}
	void reverseIterate() {
		Node2 prevNode = null;
		Node2 currNode = head;
		while(currNode!=null) {
			Node2 nextNode = currNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = nextNode;
		}
		head.next=null;
		head=prevNode;
	}
	void printList2() {
		if(head==null) {
			System.out.println("List is empty");
		}
		Node2 currNode = head;
		while(currNode!=null) {
			System.out.print(currNode.data+"->");
			currNode=currNode.next;
		}
		System.out.println("NULL");
	}
	int getSize() {
		return size;
	}
	public static void main(String args[]) {
		LinkedlistDet list = new LinkedlistDet();
		list.addFirst2("is");
		list.addLast2("a");
		list.addFirst2("This");
		list.addLast2("list");
		list.printList2();
//		list.deleteFirst();
//		list.printList2();
//		list.deleteLast();
//		list.printList2();
		System.out.println(list.getSize());
		list.reverseIterate();
		list.printList2();
	}
}
