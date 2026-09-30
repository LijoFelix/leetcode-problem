class Solution {
    public int countHousePlacements(int n) {
        long mod = 1000000007;
        if (n == 1) return 4;

        long prev2 = 2;
        long prev1 = 3;
        long current = 3;

        for (int i = 3; i <= n; i++) {
            current = (prev1 + prev2) % mod;
            prev2 = prev1;
            prev1 = current;
        }

        long totalWays = (current * current) % mod;
        return (int) totalWays;
    }
}