class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        
        if (n == 1) {
            return grid[0][0];
        }

        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        int firstIdx = -1;

        for (int j = 0; j < n; j++) {
            int val = grid[0][j];
            if (val < firstMin) {
                secondMin = firstMin;
                firstMin = val;
                firstIdx = j;
            } else if (val < secondMin) {
                secondMin = val;
            }
        }

        for (int i = 1; i < n; i++) {
            int nextFirstMin = Integer.MAX_VALUE;
            int nextSecondMin = Integer.MAX_VALUE;
            int nextFirstIdx = -1;

            for (int j = 0; j < n; j++) {
                int prevMin = (j == firstIdx) ? secondMin : firstMin;
                int sum = grid[i][j] + prevMin;

                if (sum < nextFirstMin) {
                    nextSecondMin = nextFirstMin;
                    nextFirstMin = sum;
                    nextFirstIdx = j;
                } else if (sum < nextSecondMin) {
                    nextSecondMin = sum;
                }
            }

            firstMin = nextFirstMin;
            secondMin = nextSecondMin;
            firstIdx = nextFirstIdx;
        }

        return firstMin;
    }
}