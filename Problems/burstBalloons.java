public class Solution { 
  public int maxCoins(int[] nums) { 
    int n = nums.length; 
    int[] newNums = new int[n + 2]; 
    newNums[0] = 1; 
    newNums[n + 1] = 1; 
    for (int i = 0; i < n; i++) { 
      newNums[i + 1] = nums[i]; 
    } 
    int[][] memo = new int[n + 2][n + 2]; 
    return maxCoinsHelper(memo, newNums, 0, n + 1); 
    } 
    private int maxCoinsHelper(int[][] memo, int[] nums, int left, int right) { 
    if (left + 1 == right) { 
    return 0; 
    } 
    if (memo[left][right] > 0) { 
    return memo[left][right]; 
    } 
    int max = 0; 
    for (int i = left + 1; i < right; i++) { 
    int coins = nums[left] * nums[i] * nums[right]; 
    coins += maxCoinsHelper(memo, nums, left, i) + maxCoinsHelper(memo, nums, i, right); 
    max = Math.max(max, coins); 
    } 
    memo[left][right] = max; 
    return max; 
  } 
}
