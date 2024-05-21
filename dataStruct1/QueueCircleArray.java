package dataStruct1;

import dataStruct1.QueueArray.Queue;

public class QueueCircleArray {
	static class Queue{
		static int arr[];
		static int size;
		static int rear=-1;
		static int front=-1;
		Queue(int size){
			this.size=size;
			arr=new int[size];
		}
		static boolean isEmpty() {
			return rear==-1 && front==-1;
		}
		static boolean isFull() {
			return (rear+1)%size==front;
		}
		static void add(int data) {
			if(isFull()) {
				System.out.println("Queue is Full");
				return;
			}
			//1st ELEMENT ADDITION
			if(front==-1) {
				front=0;
			}
			rear=(rear+1)%size;
			arr[rear]=data;
		}
		static int remove() {
			if(isEmpty()) {
				System.out.println("Queue is empty");
				return -1;
			}
			int result=arr[front];
			//SINGLE ELEMENT CONDITION
			if(rear==front) {
				rear=front=-1;
			}else {
				front=(front+1)%size;//WE USE MODULO SIZE HERE FOR THE CASE WHEN FRONT IS THE LAST ELEMENT
			}
			return result;
		}
		static int peek() {
			if(isEmpty()) {
				System.out.println("Queue is Empty");
				return -1;
			}
			return arr[front];
		}
	}
	public static void main(String args[]) {
		Queue q1 = new Queue(5);
		q1.add(1);
		q1.add(2);
		q1.add(3);
		q1.add(4);
		q1.add(5);
		System.out.println(q1.remove());
		q1.add(6);
		System.out.println(q1.remove());
		q1.add(7);
		while(!q1.isEmpty()) {
			System.out.println(q1.peek());
			q1.remove();
		}
	}
}
