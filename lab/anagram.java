import java.util.Arrays;
import java.util.Scanner;
public class anagram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first string: ");
        String a1 = scanner.nextLine();
        System.out.print("Enter the second string: ");
        String a2 = scanner.nextLine();
        char[] a1chars = a1.toLowerCase().toCharArray();
        char[] a2chars = a2.toLowerCase().toCharArray();
        Arrays.sort(a1chars);
        Arrays.sort(a2chars);
        boolean isAnagram = Arrays.equals(a1chars, a2chars);
        if(isAnagram == true) {
            System.out.println("They are anagrams");
        }
        else
            System.out.println("They are not anagrams");
        scanner.close();
    }
}
