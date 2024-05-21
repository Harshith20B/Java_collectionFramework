package dataStruct1;

import dataStruct1.QueueCircleArray.Queue;

public class QueueLinkedList {
	static class Node{
		int data;
		Node next;
		Node(int data){
			this.data=data;
			next=null;
		}
	}
	static class Queue{
		static Node head=null;
		static Node tail=null;
		static boolean isEmpty() {
			return head==null && tail==null;
		}
		static void add(int data) {
			Node newNode = new Node(data);
			if(tail==null) {
				head=tail=newNode;
			}
			tail.next=newNode;
			tail=newNode;
		}
		static int remove() {
			if(isEmpty()) {
				System.out.println("Empty Queue");
				return -1;
			}
			if(head==tail) {
				tail=null;
			}
			int front=head.data;
			head=head.next;
			return front;
		}
		static int peek() {
			if(isEmpty()) {
				System.out.println("The list is empty");
				return -1;
			}
			return head.data;
		}
	}
	public static void main(String args[]) {
		Queue q1 = new Queue();
		q1.add(1);
		q1.add(2);
		q1.add(3);
		q1.add(4);
		q1.add(5);
		while(!q1.isEmpty()) {
			System.out.println(q1.peek());
			q1.remove();
		}
	}
}
