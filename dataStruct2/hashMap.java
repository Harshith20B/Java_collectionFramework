package dataStruct2;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
public class hashMap {
    public static void main(String args[]){
        HashMap<String,Integer> map = new HashMap<>();
        map.put("India",120);
        map.put("US",30);
        map.put("China",150);
        map.put("China",60);
        System.out.println(map);
        if(map.containsKey("China")){
            System.out.println("China is present with key : "+map.get("China"));
        }
        for(Map.Entry<String, Integer> val : map.entrySet()){
            System.out.println(val.getKey());
            System.out.println(val.getValue());
        }
        Set<String> keys = map.keySet();
        for(String key : keys){
            System.out.println(key+" "+map.get(key));
        }
        map.remove("China");
        System.out.println(map);
    }
}
