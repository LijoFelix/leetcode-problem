class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        int[] points = new int[maxVal + 1];
        for (int num : nums) {
            points[num] += num;
        }
        int prev2 = 0;
        int prev1 = 0;
        for (int i = 0; i <= maxVal; i++) {
            int current = Math.max(prev1, prev2 + points[i]);
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
}