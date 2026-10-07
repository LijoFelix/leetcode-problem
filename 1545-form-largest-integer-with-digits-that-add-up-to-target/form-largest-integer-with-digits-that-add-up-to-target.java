class Solution {
    public String largestNumber(int[] cost, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int c = 1; c <= target; c++) {
            for (int d = 1; d <= 9; d++) {
                int digitCost = cost[d - 1];
                if (c >= digitCost && dp[c - digitCost] != -1) {
                    dp[c] = Math.max(dp[c], dp[c - digitCost] + 1);
                }
            }
        }

        if (dp[target] == -1) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        int c = target;

        for (int d = 9; d >= 1; d--) {
            int digitCost = cost[d - 1];
            while (c >= digitCost && dp[c - digitCost] == dp[c] - 1) {
                sb.append(d);
                c -= digitCost;
            }
        }

        return sb.toString();
    }
}