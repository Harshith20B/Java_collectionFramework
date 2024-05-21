package Problems;
import java.util.*;

public class cards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt(); // number of test cases

        for (int testCase = 0; testCase < t; testCase++) {
            int n = scanner.nextInt(); // number of cards
            int k = scanner.nextInt(); // number of cards exchanged during each operation
            int[] cards = new int[n]; // array to store the numbers on cards

            for (int i = 0; i < n; i++) {
                cards[i] = scanner.nextInt(); // read the numbers on cards
            }

            // Count the frequency of each number
            Map<Integer, Integer> frequencyMap = new HashMap<>();
            for (int num : cards) {
                frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            }

            // Find the maximum frequency of any number
            int maxFrequency = 0;
            for (int freq : frequencyMap.values()) {
                maxFrequency = Math.max(maxFrequency, freq);
            }

            // Calculate the minimum number of cards left
            int minCardsLeft;
            if (maxFrequency >= k) {
                minCardsLeft = n - (maxFrequency - (maxFrequency % k));
            } else {
                minCardsLeft = n;
            }
            System.out.println(minCardsLeft);
        }

        scanner.close();
    }
}
