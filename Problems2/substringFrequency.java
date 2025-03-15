package Problems2;
//package lab;
import java.util.Scanner;
public class substringFrequency {
    public static int frequency( String source, String part ) {
        if ( source == null || source.isEmpty() || part == null || part.isEmpty() )
            return 0;
        int count = 0;
        for ( int pos = 0; (pos = source.indexOf( part, pos )) != -1; count++ )
            pos += part.length();
        return count;
    }
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the string" ); // 2
        String str = sc.nextLine();
        System.out.println("enter the substring" ); // 1
        String substr = sc.nextLine();
        System.out.println( frequency( str, substr ) ); // 0
        sc.close();
    }
}
