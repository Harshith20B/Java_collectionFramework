//Hash Set is unordered
package dataStruct2;
import java.util.HashSet;
import java.util.Iterator;
public class hashSet{
    public static void main(String args[]){
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);
        if(set.contains(1)){
            System.out.println("It contanis 1");
        }else{
            System.out.println("does not contain 1");
        }
        set.remove(1);
        System.out.println(set.size());
        System.out.println(set);
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
