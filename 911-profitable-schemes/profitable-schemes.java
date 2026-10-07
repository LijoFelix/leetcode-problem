class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int MOD = 1_000_000_007;
        int[][] dp = new int[n + 1][minProfit + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        int len = group.length;
        for (int k = 0; k < len; k++) {
            int g = group[k];
            int p = profit[k];

            for (int i = n; i >= g; i--) {
                for (int j = minProfit; j >= 0; j--) {
                    int prevProfit = Math.max(0, j - p);
                    dp[i][j] = (dp[i][j] + dp[i - g][prevProfit]) % MOD;
                }
            }
        }

        return dp[n][minProfit];
    }
}