class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int minAbove = dp[i - 1][j];
                if (j > 0) {
                    minAbove = Math.min(minAbove, dp[i - 1][j - 1]);
                }
                if (j < n - 1) {
                    minAbove = Math.min(minAbove, dp[i - 1][j + 1]);
                }
                dp[i][j] = matrix[i][j] + minAbove;
            }
        }

        int minPath = dp[n - 1][0];
        for (int j = 1; j < n; j++) {
            minPath = Math.min(minPath, dp[n - 1][j]);
        }

        return minPath;
    }
}