package dataStruct2;
import java.util.*;
/* if array starting with 1
 * 1. root i=0
 * 2. parent of i = i-1/2
 * 3. left child of i = 2i+1
 * 4. right child of i = 2i+1
 */
//small element shud be at the top
public class heaps{
    public static void main(String args[]) throws Exception{
        Heap<Integer> heap = new Heap<>();
        heap.insert(30);
        heap.insert(20);
        heap.insert(40);
        heap.insert(70);
        System.out.println(heap.remove());
        ArrayList<Integer> list = heap.heapSort();
        System.out.println(list);
    }
}