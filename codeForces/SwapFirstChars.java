package codeForces;
import java.util.Scanner;
public class SwapFirstChars {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for(int i=0;i<t;i++){
            String[] input = sc.nextLine().split(" ");
            String a = input[0];
            String b = input[1];
            String newA = b.charAt(0)+a.substring(1);
            String newB = b.charAt(0)+a.substring(1);
            System.out.println(newA+" "+newB);
        }
        sc.close();
    }
}
