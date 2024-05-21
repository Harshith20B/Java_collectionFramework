package dataStruct1;
public class pr1{
	static class Node{
		int data;
		Node next;
		Node(int data){
			this.data=data;
			next=null;
		}
	}
	static class Stack2{
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
	public static void main(String args[]){
		Stack2 obj1 = new Stack2();
		obj1.push(1);
		obj1.push(2);
		obj1.push(3);
		obj1.push(4);
		while(!obj1.isEmpty()) {
			System.out.println(obj1.peek());
			obj1.pop();
		}
	}
}