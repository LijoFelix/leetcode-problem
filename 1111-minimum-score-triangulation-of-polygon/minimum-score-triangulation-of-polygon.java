class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        for (int len = 2; len < n; len++) {
            for (int i = 0; i + len < n; i++) {
                int j = i + len;
                int minScore = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    int score = dp[i][k] + dp[k][j] + values[i] * values[k] * values[j];
                    minScore = Math.min(minScore, score);
                }
                dp[i][j] = minScore;
            }
        }
        return dp[0][n - 1];
    }
}