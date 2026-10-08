class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[k + 1][n + 1];
        for (int j = 1; j <= k; j++) {
            int best = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                best = Math.max(
                    best,
                    dp[j - 1][i - 1] - prices[i - 1]
                );
                dp[j][i] = Math.max(
                    dp[j][i - 1],
                    prices[i - 1] + best
                );
            }
        }
        return dp[k][n];
    }
}