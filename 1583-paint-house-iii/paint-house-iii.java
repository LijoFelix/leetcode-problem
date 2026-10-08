class Solution {
    private static final int INF = 1_000_000_000;
    private Integer[][][] memo;
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        memo = new Integer[m][target + 1][n + 1];
        int result = solve(0, 0, 0, houses, cost, m, n, target);
        return result >= INF ? -1 : result;
    }
    private int solve(int i, int k, int prevColor, int[] houses, int[][] cost, int m, int n, int target) {
        if (k > target) return INF;
        if (i == m) return k == target ? 0 : INF;
        if (memo[i][k][prevColor] != null) return memo[i][k][prevColor];
        int minCost = INF;
        if (houses[i] != 0) {
            int currentColor = houses[i];
            int nextK = (currentColor == prevColor) ? k : k + 1;
            minCost = solve(i + 1, nextK, currentColor, houses, cost, m, n, target);
        } else {
            for (int c = 1; c <= n; c++) {
                int nextK = (c == prevColor) ? k : k + 1;
                int currentCost = cost[i][c - 1] + solve(i + 1, nextK, c, houses, cost, m, n, target);
                minCost = Math.min(minCost, currentCost);
            }
        }
        return memo[i][k][prevColor] = minCost;
    }
}