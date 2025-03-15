package Problems2;
public class climbingStairs {
    
    public static int climbStairs(int n) {
        if (n <= 1) return 1;

        // DP array to store number of ways to reach each step
        int[] dp = new int[n + 1];

        // Base cases
        dp[0] = 1;
        dp[1] = 1;

        // Fill the dp array using the recurrence relation
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5; // Example input
        System.out.println("Number of ways to reach step " + n + ": " + climbStairs(n));
    }
}
