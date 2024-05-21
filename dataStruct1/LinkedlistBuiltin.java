package dataStruct1;
import java.util.LinkedList;
public class LinkedlistBuiltin {
	public static void main(String args[]) {
		LinkedList<String> list = new LinkedList<String>();
		list.addFirst("a");
		list.addFirst("is");
		list.addFirst("This");
		list.add("list");//Adds it at the end of the list
		System.out.println(list);
		System.out.println(list.size());
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+"->");
		}
		System.out.println("null");
		list.removeFirst();
		list.removeLast();
		System.out.println(list);
		list.addFirst("This");
		list.addLast("list");
		list.remove(3);//INDEX
		System.out.println(list);
	}
}
