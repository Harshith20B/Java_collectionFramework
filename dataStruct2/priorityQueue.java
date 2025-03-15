package dataStruct2;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class priorityQueue {
    public String frequencySort(String s) {
        // Step 1: Count the frequency of each character
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Create a max heap based on frequency
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = 
            new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        maxHeap.addAll(frequencyMap.entrySet());

        // Step 3: Build the result string
        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            char character = entry.getKey();
            int frequency = entry.getValue();
            for (int i = 0; i < frequency; i++) {
                result.append(character);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        priorityQueue solution = new priorityQueue();
        String input = "tree";
        String output = solution.frequencySort(input);
        System.out.println(output); // Output could be "eetr" or "eert"
    }
}
