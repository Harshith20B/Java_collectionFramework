package Problems;
import java.util.Arrays;
public class AnagramCheck {
    public static void main(String args[]){
        String a1 = "ipad";
        String a2 = "paid";
        char[] a1chars = a1.toCharArray();
        char[] a2chars = a2.toCharArray();
        Arrays.sort(a1chars);
        Arrays.sort(a2chars);
        boolean isAnagram = new String(a1chars).equalsIgnoreCase(new String(a2chars));
        System.out.println(isAnagram);
    }
}
