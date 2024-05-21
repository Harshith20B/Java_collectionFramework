package dataStruct1;
//FOR LINKED LSIT
public class StackLinkedList {
	static class Node{
		int data;
		Node next;
		Node(int data) {
			this.data=data;
			next=null;
		}
	}
	static class Stack{
		static Node head;
		static boolean isEmpty() {
			return head==null;
		}
		static void push(int data) {
			Node newNode = new Node(data);
			if(isEmpty()) {
				head=newNode;
				return;
			}
			newNode.next=head;
			head=newNode;
		}
		static int pop() {
			if(isEmpty()) {
				return -1;
			}
			int top=head.data;
			head=head.next;
			return top;
		}
		static int peek() {
			if(isEmpty()) {
				return -1;
			}
			return head.data;
		}
	}
	public static void main(String args[]) {
		Stack s = new Stack();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		while(!s.isEmpty()) {
			System.out.println(s.peek());
			s.pop();
		}
	}
}
