package dataStruct1;
import java.util.*;
public class StackReverse {
	static void pushAtBottom(int data,Stack<Integer> s) {
		if(s.isEmpty()) {
			s.push(data);
			return;
		}
		int top=s.pop();
		pushAtBottom(data,s);
		s.push(top);
	}
	static void reverseStack(Stack<Integer> s) {
		if(s.isEmpty()) {
			return;
		}
		int top=s.pop();
		reverseStack(s);
		pushAtBottom(top,s);		
	}
	public static void main(String args[]) {
		Stack<Integer>  s = new Stack<>();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		reverseStack(s);
		while(!s.isEmpty()) {
			System.out.println(s.peek());
			s.pop();
		}
	}
}
