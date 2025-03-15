// longest subarray with sum = k
package Problems2;
import java.util.*;
class Solution {
    public static int lenOfLongSubarr(int A[], int N, int K) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLength = 0;

        for (int i = 0; i < N; i++) {
            sum += A[i];

            if (sum == K) {
                maxLength = i + 1;
            }

            if (map.containsKey(sum - K)) {
                maxLength = Math.max(maxLength, i - map.get(sum - K));
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return maxLength;
    }
}
