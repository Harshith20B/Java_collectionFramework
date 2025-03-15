package dataStruct2;
import java.util.*;
/* if array starting with 1
 * 1. root i=0
 * 2. parent of i = i-1/2
 * 3. left child of i = 2i+1
 * 4. right child of i = 2i+1
 */
//small element shud be at the top
public class Heap<T extends Comparable<T>>{
    private ArrayList<T> list;
    public Heap(){
        list = new ArrayList<>();
    }
    private void swap(int first, int second){
        T temp = list.get(first);
        list.set(first,list.get(second));
        list.set(second,temp);
    }
    private int parent(int i){
        return (i-1)/2;
    }
    private int left(int i){
        return 2*i+1;
    }
    private int right(int i){
        return 2*i+2;
    }
    public void insert(T value){
        list.add(value);
        upheap(list.size()-1);
    }
    public void upheap(int index){
        if(index==0){
            return;
        }
        int p = parent(index);
        if(list.get(index).compareTo(list.get(p))<0){
            swap(index,p);
            upheap(p);
        }
    }
    public T remove() throws Exception{
        if(list.isEmpty()){
            throw new Exception("Removing from an empty heap");
        }
        T temp = list.get(0);
        T last = list.get(list.size()-1);
        if(!list.isEmpty()){
            list.set(0,last);
            list.remove(list.size()-1);
            downheap(0);
        }
        return temp;
    }
    private void downheap(int index){
        int min = index;
        int left = left(index);
        int right = right(index);
        if(left<list.size() && list.get(min).compareTo(list.get(left))>0){
            min=left;
        }
        //if elem at min is greater than left child then compareTo will be greater than 0 and min will be left
        if(right<list.size() && list.get(min).compareTo(list.get(right))>0){
            min=right;
        }
        if(min!=index){
            swap(min,index);
            downheap(min);
        }
    }
    public ArrayList<T> heapSort() throws Exception{
        ArrayList<T> data = new ArrayList<>();
        while(!list.isEmpty()){
            data.add(this.remove());
        }
        return data;
    }
}