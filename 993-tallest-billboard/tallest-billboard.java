class Solution {
    public int tallestBillboard(int[] rods) {
        int sum = 0;
        for (int r : rods) {
            sum += r;
        }

        int[] dp = new int[sum + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int r : rods) {
            int[] cur = dp.clone();

            for (int d = 0; d <= sum; d++) {
                if (cur[d] < 0) continue;

                if (d + r <= sum) {
                    dp[d + r] = Math.max(dp[d + r], cur[d]);
                }

                int newDiff = Math.abs(d - r);
                int newShorter = cur[d] + Math.min(d, r);
                dp[newDiff] = Math.max(dp[newDiff], newShorter);
            }
        }

        return dp[0];
    }
}