import java.util.Arrays;

class Solution {
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        
        Arrays.fill(dp, (int) 1e9);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            int c = cost[i];
            int t = time[i];

            for (int j = n; j >= 1; j--) {
                int prevWalls = Math.max(0, j - (t + 1));
                dp[j] = Math.min(dp[j], c + dp[prevWalls]);
            }
        }

        return dp[n];
    }
}