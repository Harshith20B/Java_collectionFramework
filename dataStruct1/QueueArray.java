package dataStruct1;
public class QueueArray {
	static class Queue{
		static int arr[];
		static int rear=-1;
		static int size;
		Queue(int size){
			this.size=size;
			arr = new int[size];
		}
		static boolean isEmpty() {
			return rear==-1;
		}
		static void add(int data) {
			if(rear==size-1) {
				System.out.println("Full Queue");
			}
			rear++;
			arr[rear]=data;
		}
		static int remove() {
			if(isEmpty()) {
				System.out.println("Empty Queue");
				return -1;
			}
			int front=arr[0];
			for(int i=0;i<rear;i++) {
				arr[i]=arr[i+1];
			}
			rear--;
			return front;
		}
		static int peek() {
			if(isEmpty()) {
				System.out.println("Empty Queue");
				return -1;
			}
			return arr[0];
		}
	}
	public static void main(String args[]) {
		Queue q1 = new Queue(5);
		q1.add(1);
		q1.add(2);
		q1.add(3);
		System.out.println(q1.remove());
		System.out.println(q1.peek());
		q1.add(4);
		System.out.println(q1.peek());
		while(!q1.isEmpty()) {
			System.out.println(q1.peek());
			q1.remove();
		}
	}
}
