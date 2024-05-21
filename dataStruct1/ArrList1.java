package dataStruct1;
import java.util.ArrayList;//LIST, QUEUE, SET, MAP
import java.util.Collections;
public class ArrList1 {
	public static void main(String args[]) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0);
		list.add(4);
		list.add(3);
		System.out.println(list);
		int num = list.get(0);
		System.out.println(num);
		list.add(1,1);//list.add(index,Number of the element to add);
		System.out.println(list);
		list.set(0, 5);
		System.out.println(list);
		list.remove(2);//Should mention the index here
		System.out.println(list);
		int size = list.size();
		System.out.println(size);
		Collections.sort(list);
		System.out.println(list);
	}
}
