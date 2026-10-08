class Solution {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        int[] A = new int[m + 2];
        System.arraycopy(cuts, 0, A, 1, m);
        A[0] = 0;
        A[m + 1] = n;
        Arrays.sort(A);
        int[][] dp = new int[m + 2][m + 2];
        for (int len = 2; len <= m + 1; len++) {
            for (int i = 0; i + len <= m + 1; i++) {
                int j = i + len;
                int minCost = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    minCost = Math.min(minCost, dp[i][k] + dp[k][j]);
                }
                dp[i][j] = minCost + (A[j] - A[i]);
            }
        }
        return dp[0][m + 1];
    }
}