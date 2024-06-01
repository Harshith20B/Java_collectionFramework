package Problems;

public class prac {
    public static void main(String args[]){
        String s1 = "ram";
        String s2 = "ram";
        System.out.println(s1==s2);
        String s3 = new String("ram");
        String s4 = new String("ram");
        System.out.println(s3==s4);
        System.out.println(s3.equals(s4));
        String[] words = { "I", "programmed", "you", "to", "believe", "that." };
        String s = String.join( " ", words ); 
        System.out.println(s);
    }
}
// String Literals and the String Pool:

// String s1 = "ram";
// String s2 = "ram";
// In Java, string literals are interned, meaning they are stored in a common pool.
// When you assign a string literal to a variable (s1 and s2), Java checks the string pool first.
// If the string already exists in the pool, it reuses the reference to the existing string.
// Therefore, s1 and s2 both point to the same memory location in the string pool.
// s1 == s2 compares the references, and since both refer to the same object, it returns true.
// String Objects Created with new:

// java
// Copy code
// String s3 = new String("ram");
// String s4 = new String("ram");
// When you use the new keyword to create a string, it creates a new String object on the heap, even if the same string exists in the string pool.
// Each new String("ram") call creates a new, distinct object in memory.
// Therefore, s3 and s4 refer to different objects in memory.
// s3 == s4 compares the references, and since they refer to different objects, it returns false.
