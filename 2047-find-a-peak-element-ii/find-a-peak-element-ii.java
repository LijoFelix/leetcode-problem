class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int startCol = 0;
        int endCol = mat[0].length - 1;

        while (startCol <= endCol) {
            int midCol = startCol + (endCol - startCol) / 2;

            int maxRow = 0;
            for (int r = 0; r < mat.length; r++) {
                if (mat[r][midCol] > mat[maxRow][midCol]) {
                    maxRow = r;
                }
            }

            int leftVal = midCol - 1 >= 0 ? mat[maxRow][midCol - 1] : -1;
            int rightVal = midCol + 1 < mat[0].length ? mat[maxRow][midCol + 1] : -1;

            if (mat[maxRow][midCol] > leftVal && mat[maxRow][midCol] > rightVal) {
                return new int[]{maxRow, midCol};
            } else if (mat[maxRow][midCol] < leftVal) {
                endCol = midCol - 1;
            } else {
                startCol = midCol + 1;
            }
        }

        return new int[]{-1, -1};
    }
}