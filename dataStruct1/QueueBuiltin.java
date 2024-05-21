package dataStruct1;
//QUEUE IS FIFO AND STACK IS LIFO
import java.util.*;
public class QueueBuiltin {
	public static void main(String args[]) {
		Queue<Integer> q = new LinkedList<>();//Queue is an interface implemented by ArrayDeque and LinkedList
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		System.out.println(q);
		while(!q.isEmpty()) {
			System.out.println(q.peek());
			q.remove();
		}
		System.out.println(q);
	}
}
