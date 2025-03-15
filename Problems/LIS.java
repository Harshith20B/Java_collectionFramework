package Problems;
//Longest Increasing Subsequence
import java.util.Arrays;

import Problems2.Solution;

public class LIS{
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxLength = 1;
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        
        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums2 = {0, 1, 0, 3, 2, 3};
        int[] nums3 = {7, 7, 7, 7, 7, 7, 7};
        
        System.out.println(solution.lengthOfLIS(nums1));  // Output: 4
        System.out.println(solution.lengthOfLIS(nums2));  // Output: 4
        System.out.println(solution.lengthOfLIS(nums3));  // Output: 1
    }
}
