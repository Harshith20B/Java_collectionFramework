package Problems2;
import java.util.*;

public class printingSubsequences {

    static int[] arr = {1, 2, 3}; // Input array defined globally

    // Recursive function to find subsequences
    public static void findSubsequences(int index, List<Integer> current) {
        // Base case: if index reaches the length of the array, print the current subsequence
        if (index == arr.length) {
            System.out.println(current);
            return;
        }

        // Include the current element in the subsequence
        current.add(arr[index]);
        findSubsequences(index + 1, current);

        // Backtrack and exclude the current element from the subsequence
        current.remove(current.size() - 1);
        findSubsequences(index + 1, current);
    }

    public static void main(String[] args) {
        List<Integer> current = new ArrayList<>();
        
        // Start recursion
        findSubsequences(0, current);
    }
}

// import java.util.*;

// public class SubsequencesWithSumK {

//     static int[] arr = {1, 2, 3}; // Input array defined globally
//     static int k = 3;             // Target sum

//     // Recursive function to find subsequences with sum equal to k
//     public static void findSubsequencesWithSumK(int index, List<Integer> current, int currentSum) {
//         // Base case: if index reaches the length of the array
//         if (index == arr.length) {
//             // If current subsequence's sum equals k, print it
//             if (currentSum == k) {
//                 System.out.println(current);
//             }
//             return;
//         }

//         // Include the current element in the subsequence
//         current.add(arr[index]);
//         findSubsequencesWithSumK(index + 1, current, currentSum + arr[index]);

//         // Backtrack and exclude the current element from the subsequence
//         current.remove(current.size() - 1);
//         findSubsequencesWithSumK(index + 1, current, currentSum);
//     }

//     public static void main(String[] args) {
//         List<Integer> current = new ArrayList<>();
        
//         // Start recursion
//         findSubsequencesWithSumK(0, current, 0);
//     }
// }

